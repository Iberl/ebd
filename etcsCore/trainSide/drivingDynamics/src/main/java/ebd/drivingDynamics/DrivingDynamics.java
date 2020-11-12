package ebd.drivingDynamics;

import ebd.breakingCurveCalculator.utils.events.BreakingCurveExceptionEvent;
import ebd.drivingDynamics.util.ATOServerConnector;
import ebd.drivingDynamics.util.TripProfileProvider;
import ebd.drivingDynamics.util.actions.*;
import ebd.drivingDynamics.util.events.DrivingDynamicsExceptionEvent;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.enums.*;
import ebd.globalUtils.events.dmi.DMISpeedUpdateEvent;
import ebd.globalUtils.events.drivingDynamics.DDHaltEvent;
import ebd.globalUtils.events.drivingDynamics.NewTripProfileEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.*;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Spline;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.speedAndDistanceSupervisionModule.SpeedSupervisor;
import ebd.globalUtils.events.speedDistanceSupervision.SsmReportEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Driving Dynamics simulates the physical movement of the train. It uses a {@link DrivingStrategy} to represent a driver.
 * Internally, the actual state is represented by a {@link DynamicState} that holds all relevant values.
 *
 * @author LSF
 * @version 0.1
 */
public class DrivingDynamics {

    private final EventBus localEventBus;
    private final int etcsTrainID;
    private final ConfigHandler ch;
    private final TrainDataVolatile trainDataVolatile;
    private final RouteDataVolatile routeDataVolatile;
    private final TripProfileProvider tripProfileProvider;
    private final ATOServerConnector atoServerConnector;

    boolean atoOn = false;
    boolean shouldHalt = false;

    private Spline tripProfile;
    private Position tripStartPosition;

    private DynamicState dynamicState;
    private DrivingStrategy drivingStrategy;

    private final String tdTarget = "td";
    private final String exceptionTarget = "tsm";
    private double maxTripSectionDistance;

    private double profileTargetSpeed = 0d;
    private double breakModifierForRSM = 1;
    private boolean inRSMRecovery = false;

    private int cycleCount;
    private final int cylceCountMax; //TODO Connect to Config

    private final List<Action> actionList;
    private MovementState currentMovementState = MovementState.UNCHANGED;
    private SpeedInterventionLevel currentSil = SpeedInterventionLevel.NO_INTERVENTION;
    private SpeedInterventionLevel lastSendSil = SpeedInterventionLevel.NOT_SET;
    private SpeedSupervisionState currentSsState = SpeedSupervisionState.CEILING_SPEED_SUPERVISION;
    private SpeedSupervisionState lastSendState = SpeedSupervisionState.NOT_SET;
    private ETCSMode currentMode= ETCSMode.NO_MODE;
    private ETCSLevel currentLevel = ETCSLevel.NO_LEVEL;

    /**
     * Drving Dynamics simulates the physical movement of the train. It uses a {@link DrivingStrategy} to represent a driver.
     *
     * @param localEventBus The local {@link EventBus} of the train
     */
    public DrivingDynamics(EventBus localEventBus, int etcsTrainID){
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);
        this.etcsTrainID = etcsTrainID;

        this.ch = ConfigHandler.getInstance();
        try {
            this.drivingStrategy = new DrivingStrategy(this.localEventBus);
        } catch (IOException | ParseException e) {
            localEventBus.post(new DrivingDynamicsExceptionEvent("td", this.exceptionTarget, new NotCausedByAEvent(), e, ExceptionEventTyp.FATAL));
        } catch (DDBadDataException e) {
            localEventBus.post(new DrivingDynamicsExceptionEvent("td", this.exceptionTarget, new NotCausedByAEvent(), e));
        }

        this.trainDataVolatile = localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        this.routeDataVolatile = localEventBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
        this.tripProfileProvider = new TripProfileProvider(this.localEventBus);
        this.atoServerConnector = new ATOServerConnector(this.localEventBus, this.etcsTrainID);

        this.cylceCountMax = (int)(ch.timeBetweenDynLog / (ch.clockTickInMS / 1000.0));
        this.cycleCount = this.cylceCountMax;

        this.actionList = new ArrayList<>();
        int actionListSize = (int)(this.ch.averageTimeBetweenActions / (ch.clockTickInMS / 1000.0)) + 1;
        for (int i = 0; i < actionListSize; i++){
            this.actionList.add(new NoAction(this.localEventBus));
        }
    }

    /**
     * Every clock tick event this method runs all code necessary to calculate the next dynamic state from the previous
     * one. It takes into account {@link SpeedInterventionLevel} decided by the {@link SpeedSupervisor}
     * and the {@link Action} decided by the {@link DrivingStrategy}.
     * This method also updates {@link TrainDataVolatile} with the new values.
     *
     * @param cte A {@link ClockTickEvent}
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cte){
        /*
        Getting the modified time between two clock ticks, which is the time between clock ticks modified by the
        time acceleration factor.
         */
        double deltaT = cte.deltaT;

        /*
        If driving dynamics is locked, nothing will be done.
         */
        if(this.dynamicState == null || (this.tripProfile == null && !this.atoServerConnector.isAtoOn()) || this.currentMode == ETCSMode.NO_MODE){
            return;
        }

        /*
        Update TrainDataVolatile to set the current maximum allowed speed of the train
        based on the tripProfile
         */
        updateCurrentMaxTripProfileSpeed();

        /*
        Controls the ATO Mode
         */
        if(!this.atoOn) this.atoOn = this.atoServerConnector.isAtoOn();
        else if(!this.atoServerConnector.isAtoOn()){
            this.dynamicState.setMovementState(MovementState.SERVICE_BREAKING);
            this.dynamicState.setBreakingModification(1);
            this.atoOn = false;
        }

        /*
        Sets the dynamic state in preparation for the next state.
         */
        if(this.atoOn){
            drivingInATO();
        }
        else if(this.currentMode == ETCSMode.STAND_BY){
            drivingIllegal();
        }
        else {
            executeAction(drivingAllowed());
            sendToLogEventSpeedState();
            sendMovementStateIfNotAlreadySend();
        }

        /*
        Calculate the next dynamic state.
         */
        this.dynamicState.nextState(deltaT);


        /*
        Sends global PositionEvent
         */
        EventBus.getDefault().post(new PositionEvent("dd;T=" + this.etcsTrainID, "all", dynamicState.getPosition()));

        /*
        Update TrainDataVolatile with the newly calculated values
         */
        updateTrainDataVolatile();

        /*
        Informs ATO if appropriate
         */
        if(this.atoOn){
            this.atoServerConnector.sendDynamicStateToATO(this.dynamicState);
        }

        cycleCount++;
        if(this.cycleCount >= this.cylceCountMax || (this.dynamicState.getSpeed() < 1 && this.dynamicState.getSpeed() > 0)){
            cycleCount = 0;
            sendToLogEventDynamicState();
        }
    }

    /**
     * Listens to {@link NewPositionEvent}. Because there could be a unknown amount of time passed since the new
     * {@link Position} was calculated, this function first calculates a possible offset and then updates {@link DynamicState}
     * @param npe A {@link NewPositionEvent}
     */
    @Subscribe
    public void newPosition(NewPositionEvent npe){
        if (this.dynamicState == null) return;
        Position newPos = npe.newPosition;
        Position oldPos = this.dynamicState.getPosition();
        double offset = oldPos.getIncrement() -  newPos.estimatedDistanceToPastLocation(oldPos.getLocation().getId());
        newPos.setIncrement(newPos.getIncrement() + offset);
        this.dynamicState.setPosition(newPos);

        String msg = "New location with ID " + newPos.getLocation().getId() + " was reached";
        this.localEventBus.post(new ToLogEvent("dd", "log", msg));
    }

    @Subscribe
    public void newMode(ModeReportEvent mre){
        this.currentMode = mre.curMode;
    }

    @Subscribe
    public void newLevel(LevelReportEvent mre){
        this.currentLevel = mre.curLevel;
    }


    /**
     * This method locks Driving Dynamics, signaling the end of movement of the train
     * @param le A {@link DDHaltEvent}
     */
    @Subscribe
    public void setHalt(DDHaltEvent le){
        this.shouldHalt = true;
    }

    /**
     * This method updates the trip profile. This can become necessary should a new one become available. This does
     * <b>not</b> require the train to be at standstill.
     * @param utpe {@link NewTripProfileEvent}
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void updateTripProfile(NewTripProfileEvent utpe){
        if(!(utpe.target.contains("dd") || utpe.target.contains("all"))){
            return;
        }
        this.tripProfile = utpe.tripProfile;
        if(this.tripProfile instanceof BackwardSpline){
            BackwardSpline backwardSpline = (BackwardSpline)this.tripProfile;
            this.maxTripSectionDistance = backwardSpline.getHighestXValue();
        }
        else if(this.tripProfile instanceof ForwardSpline){
            this.maxTripSectionDistance = Double.MAX_VALUE;
        }
        else{
            IllegalArgumentException iAE = new IllegalArgumentException("The trip profile used an unsupported implementation of Spline");
            this.localEventBus.post(new DrivingDynamicsExceptionEvent("dd", this.exceptionTarget, utpe, iAE, ExceptionEventTyp.FATAL));
        }


        Position curPos = this.trainDataVolatile.getCurrentPosition();
        //we need a copy of, not a referenz to, the current Position
        this.tripStartPosition = new Position(curPos.getIncrement(),curPos.getDirection(),curPos.getLocation(),curPos.getPreviousLocations());
        if(this.dynamicState == null){
            this.dynamicState = new DynamicState(trainDataVolatile.getCurrentPosition(), trainDataVolatile.getAvailableAcceleration());
        }
        else {
            this.dynamicState.setDistanceToStartOfProfile(curPos.estimatedDistanceToPastLocation(utpe.refLocID));
        }
        this.shouldHalt = false;


        if(ch.debug){
            saveTripProfileToFile(utpe);
        }
    }

    /**
     * Movement decision tree should ATO be turned on.
     */
    private void drivingInATO() {
        MovementState ms;
        double modifier;

        SsmReportEvent speedSupervisionReport = this.localEventBus.getStickyEvent(SsmReportEvent.class);
        if(speedSupervisionReport == null ){
            ms = this.atoServerConnector.getCurMovementState();
            modifier = this.atoServerConnector.getCurModifier();
        }
        else {
            this.currentSil = speedSupervisionReport.interventionLevel;
            this.currentSsState = speedSupervisionReport.supervisionState;
            switch (this.currentSil){
                case NOT_SET, NO_INTERVENTION, INDICATION, OVERSPEED, WARNING -> {
                    sendToLogEventSpeedSupervision(MovementState.UNCHANGED);
                    ms = this.atoServerConnector.getCurMovementState();
                    modifier = this.atoServerConnector.getCurModifier();
                }
                case APPLY_SERVICE_BREAKS -> {
                    sendToLogEventSpeedSupervision(MovementState.SERVICE_BREAKING);
                    ms = MovementState.SERVICE_BREAKING;
                    modifier = 1;
                }
                default -> {
                    sendToLogEventSpeedSupervision(MovementState.EMERGENCY_BREAKING);
                    ms = MovementState.EMERGENCY_BREAKING;
                    modifier = 1;
                }
            }
        }
        this.dynamicState.setMovementState(ms);
        this.dynamicState.setAccelerationModification(modifier);
        this.dynamicState.setBreakingModification(modifier);
        sendToLogEventSpeedState();
    }

    /**
     * Movement decision tree should the current {@link ETCSMode} forbid movement.
     */
    private void drivingIllegal(){
        if(this.dynamicState.getSpeed() != 0){
            IllegalStateException ise = new IllegalStateException("The train was moving when movement was not allowed");
            DrivingDynamicsExceptionEvent ddee = new DrivingDynamicsExceptionEvent("tsm",
                                                                                    "dd",
                                                                                    new NotCausedByAEvent(),
                                                                                    ise,
                                                                                    ExceptionEventTyp.FATAL
                                                                                    );
        }
    }

    /**
     * Movement decision tree should the current {@link ETCSMode} allow movement.
     */
    private Action drivingAllowed() {
        /*
        Checks the current SsmReportEvent for the status of the train
        Getting next action that should be taken and parsing that action
         */
        SsmReportEvent speedSupervisionReport = this.localEventBus.getStickyEvent(SsmReportEvent.class);
        if(speedSupervisionReport == null ){
            return this.drivingStrategy.actionToTake();
        }
        else if(this.shouldHalt && this.dynamicState.getSpeed() == 0){
            sendMovementStateIfNotAlreadySend();
            return new HaltAction(this.localEventBus);
        }
        else {
            this.currentSil = speedSupervisionReport.interventionLevel;
            this.currentSsState = speedSupervisionReport.supervisionState;
            if(this.currentSsState != SpeedSupervisionState.RELEASE_SPEED_SUPERVISION){
                switch (this.currentSil) {
                    case NOT_SET, NO_INTERVENTION, INDICATION, OVERSPEED, WARNING -> {
                        sendToLogEventSpeedSupervision(MovementState.UNCHANGED);
                        return this.drivingStrategy.actionToTake();
                    }
                    case APPLY_SERVICE_BREAKS -> {
                        sendToLogEventSpeedSupervision(MovementState.SERVICE_BREAKING);
                        return new BreakAction(this.localEventBus, 1, BreakMode.SERVICE_BREAKING);
                    }
                    default -> {
                        sendToLogEventSpeedSupervision(MovementState.EMERGENCY_BREAKING);
                        return new BreakAction(this.localEventBus, 1, BreakMode.EMERGENCY_BREAKING);
                    }
                }
            }
            else {
                calculateModifier();
                /*
                This control flow is necessary in case the train emergency breaks into RSM.
                It allows the train to accelerate again until the stopping region is reached.
                */
                if (this.currentSil == SpeedInterventionLevel.INDICATION) {
                    if(this.breakModifierForRSM > 0){
                        this.inRSMRecovery = false;
                        return new BreakAction(this.localEventBus, this.breakModifierForRSM, BreakMode.SERVICE_BREAKING);
                    }
                    else if ((this.dynamicState.getSpeed() > 0 && !this.inRSMRecovery) || this.dynamicState.getSpeed() > 5) {
                        this.inRSMRecovery = false;
                        return new CruiseAction(this.localEventBus);
                    }
                    else if (!shouldHalt){
                        this.inRSMRecovery = true;
                        return new AccelerationAction(this.localEventBus, 1);
                    }
                    else {
                        return new HaltAction(this.localEventBus);
                    }


                } else {
                    sendToLogEventSpeedSupervision(MovementState.EMERGENCY_BREAKING);
                    return new BreakAction(this.localEventBus, 1, BreakMode.EMERGENCY_BREAKING);
                }
            }
        }
    }



    /**
     * This method gathers the new information from dynamic state and send these to {@link TrainDataVolatile}
     */
    private void updateTrainDataVolatile(){
        HashMap<String,Object> nameToValue = new HashMap<>();
        nameToValue.put("currentSpeed", this.dynamicState.getSpeed());
        nameToValue.put("currentPosition", this.dynamicState.getPosition());
        nameToValue.put("curTripDistance", this.dynamicState.getTripDistance());
        nameToValue.put("curTripSectionDistance", this.dynamicState.getDistanceToStartOfProfile());
        nameToValue.put("curTripTime", this.dynamicState.getTime());
        this.localEventBus.post(new TrainDataMultiChangeEvent("dd", this.tdTarget, nameToValue));
    }

    /**
     * This method calculates the new profile maximum speed for the current location. Also sends these to {@link TrainDataVolatile}
     */
    private void updateCurrentMaxTripProfileSpeed() {
        double tripSectionDistance = this.dynamicState.getDistanceToStartOfProfile();

        if(tripSectionDistance < this.maxTripSectionDistance) this.profileTargetSpeed = tripProfile.getPointOnCurve(tripSectionDistance);
        else this.profileTargetSpeed = 0d;

        this.localEventBus.post(new TrainDataChangeEvent("dd", this.tdTarget, "currentProfileMaxSpeed", this.profileTargetSpeed));
    }

    /**
     * Sends logging information from dynamic state
     */
    private void sendToLogEventDynamicState() {
        double a = dynamicState.getAcceleration();
        double v = dynamicState.getSpeed();
        double vm = this.profileTargetSpeed;
        int l = dynamicState.getPosition().getLocation().getId();
        double i = dynamicState.getPosition().getIncrement();
        double td = dynamicState.getTripDistance();
        double tt = dynamicState.getTime();
        String msg = String.format("Acc: %5.2f m/s^2 V: %5.2f m/s, V_max: %5.2f m/s, ",a,v,vm);
        String msg2 = String.format("Pos: LRBG %3d + %7.2f m, TripDist: %8.2f m, TripTime: %6.1f s",l,i,td,tt);
        this.localEventBus.post(new ToLogEvent("dd", "log", msg + msg2));

    }

    /**
     * Sends logging information regarding the current {@link SpeedInterventionLevel}
     */
    private void sendToLogEventSpeedSupervision(MovementState movementState) {
        if(this.lastSendSil == this.currentSil) return;
        this.lastSendSil = this.currentSil;
        String msg = String.format("Current speed supervision intervention level: %s ", this.currentSil);
        this.localEventBus.post(new ToLogEvent("ssm", "log", msg));
        if(movementState != MovementState.UNCHANGED) sendToLogEventMovementState(movementState);
    }

    /**
     * Sends logging information regarding the current {@link SpeedInterventionLevel}
     */
    private void sendToLogEventSpeedState() {
        if(this.lastSendState == this.currentSsState) return;
        this.lastSendState = this.currentSsState;
        String msg = String.format("Current speed supervision state: %s ", this.currentSsState);
        this.localEventBus.post(new ToLogEvent("ssm", "log", msg));
    }

    /**
     * Sends logging information regarding the current {@link MovementState}
     */
    private void sendToLogEventMovementState(MovementState ms) {
        String msg = String.format("Set movement state to: %s ", ms);
        this.localEventBus.post(new ToLogEvent("dd", "log", msg));

    }

    /**
     * Sends logging information regarding the current {@link MovementState} if this {@link MovementState}
     * was not the last MovementState send.
     */
    private void sendMovementStateIfNotAlreadySend(){
        if(this.currentMovementState != this.dynamicState.getMovementState()){
            sendToLogEventMovementState(this.dynamicState.getMovementState());
            this.currentMovementState = this.dynamicState.getMovementState();
        }
    }

    /**
     * Calculates the necessary modifier to break gracefully to the signal
     */
    private void calculateModifier() {
        double currentSpeed = this.dynamicState.getSpeed();
        double maxBreakingAcc = this.trainDataVolatile.getCurrentServiceBreakingPower().getPointOnCurve(currentSpeed);
        double distanceToEOA = this.maxTripSectionDistance - this.dynamicState.getDistanceToStartOfProfile() - 1; //Break 1 m in front of EOA
        double neededBreakingACC = -0.5 * Math.pow(currentSpeed,2) / distanceToEOA;
        neededBreakingACC -= this.routeDataVolatile.getCurrentGradient() * 9.81 * 0.001;
        double modifier = -neededBreakingACC/maxBreakingAcc;
        if(modifier > 1){
            modifier = 1;
        }
        else if(modifier < 0.5){
            modifier = 0;
        }
        this.breakModifierForRSM = modifier;
    }

    /**
     * Takes a spline and saves it to a file
     */
    private void saveTripProfileToFile(NewTripProfileEvent ddutpe) {
        Spline tp = ddutpe.tripProfile;
        LocalDateTime ldt = LocalDateTime.now();
        String timeString =  DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ldt);
        String dirPathString = "results/tripProfiles/" + timeString.replaceAll(":", "-") + "/";

        if(!new File(dirPathString).mkdirs()){
            System.err.println("Could not create necessary directories");
            System.exit(-1); //TODO Make better and Event
        }

        String dateString = DateTimeFormatter.BASIC_ISO_DATE.format(ldt);
        String fileName = String.format("ETCS_ID_%d-%s-%s",this.etcsTrainID,tp.getID(),dateString);

        try {
            FileWriter fW = new FileWriter(dirPathString + fileName);
            BufferedWriter writer = new BufferedWriter(fW);
            writer.write(tp.toString());
            writer.flush();
            writer.close();

        } catch (IOException e1) {
            localEventBus.post(new BreakingCurveExceptionEvent("dd", "tsm", ddutpe, e1));
        }



    }

    /**
     * This Method takes an Action and applies the resulting behaviour.
     * @param action Any {@link Action}
     */
    private void executeAction(Action action) {

        this.actionList.remove(0);
        this.actionList.add(action);

        Action tempAction = getActionFromActionList();

        if (tempAction instanceof AccelerationAction) {
            this.dynamicState.setMovementState(MovementState.ACCELERATING);
            this.dynamicState.setAccelerationModification(((AccelerationAction) tempAction).getAccelerationPercentage());
        }
        else if (tempAction instanceof BreakAction) {
            MovementState ms = switch (((BreakAction) tempAction).getBreakMode()){
                                    case EMERGENCY_BREAKING -> MovementState.EMERGENCY_BREAKING;
                                    case SERVICE_BREAKING -> MovementState.SERVICE_BREAKING;
                                    case NORMAL_BREAKING -> MovementState.NORMAL_BREAKING;
                                };
            this.dynamicState.setMovementState(ms);
            this.dynamicState.setBreakingModification(((BreakAction) tempAction).getBreakPercentage());
        }
        else if (tempAction instanceof CruiseAction) {
            this.dynamicState.setMovementState(MovementState.CRUISE);
        }
        else if (tempAction instanceof CoastAction) {
            this.dynamicState.setMovementState(MovementState.COASTING);
        }
        else if (tempAction instanceof HaltAction) {
            this.dynamicState.setMovementState(MovementState.HALTING);
        }
        else if(!(tempAction instanceof NoAction)) {
            IllegalArgumentException iAE = new IllegalArgumentException("DrivingDynamics could not parse this action: " + tempAction.getClass().getSimpleName());
            localEventBus.post(new DrivingDynamicsExceptionEvent("dd", this.exceptionTarget, new NotCausedByAEvent(), iAE, ExceptionEventTyp.FATAL));
        }
    }

    private Action getActionFromActionList() {
        double accumMods = 0;
        int counter = 0;
        BreakMode curMode = BreakMode.SERVICE_BREAKING;
        for(Action action : this.actionList){
            if (action instanceof AccelerationAction) {
                accumMods += ((AccelerationAction) action).getAccelerationPercentage();
                counter++;
            }
            else if (action instanceof BreakAction) {
                accumMods -= ((BreakAction) action).getBreakPercentage();
                curMode = ((BreakAction) action).getBreakMode();
                counter++;
            }
            else {
                counter++;
            }
        }

        double curModifier = accumMods / counter;

        if(curModifier > 1) curModifier = 1;
        else if (curModifier > -0.1 && curModifier < 0.1) curModifier = 0;
        else if (curModifier < -1) curModifier = -1;

        if(curModifier > 0){
            return new AccelerationAction(this.localEventBus, curModifier);
        }
        else if(curModifier < 0){
            return new BreakAction(this.localEventBus, Math.abs(curModifier), curMode);
        }

        Action lastAction = this.actionList.get(this.actionList.size()-1);
        if (lastAction instanceof AccelerationAction || lastAction instanceof BreakAction) {
            return new CoastAction(this.localEventBus);
        }
        else {
            return lastAction;
        }
    }
}
