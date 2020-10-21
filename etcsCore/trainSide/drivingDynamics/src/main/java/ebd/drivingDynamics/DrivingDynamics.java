package ebd.drivingDynamics;

import ebd.breakingCurveCalculator.utils.events.BreakingCurveExceptionEvent;
import ebd.drivingDynamics.util.ATOServerConnector;
import ebd.drivingDynamics.util.TripProfileProvider;
import ebd.drivingDynamics.util.actions.AccelerationAction;
import ebd.drivingDynamics.util.actions.Action;
import ebd.drivingDynamics.util.actions.BreakAction;
import ebd.drivingDynamics.util.events.DrivingDynamicsExceptionEvent;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.etcsModeAndLevel.ETCSLevel;
import ebd.globalUtils.etcsModeAndLevel.ETCSMode;
import ebd.globalUtils.events.dmi.DMIUpdateEvent;
import ebd.globalUtils.events.drivingDynamics.DDHaltEvent;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.*;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.movementState.MovementState;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;
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

    private long time;
    private long timeOfLastAction = -1;
    private final double timeBetweenActions;

    private final String tdTarget = "td";
    private final String exceptionTarget = "tsm";
    private double maxTripSectionDistance;

    private double profileTargetSpeed = 0d;
    private double breakModifierForRSM = 1;
    private boolean inRSM = false;

    private int cycleCount = 20;
    private int cylceCountMax = 20; //TODO Connect to Config
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

        this.timeBetweenActions = this.ch.timeBetweenActions;
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
        this.time = AppTime.nanoTime();
        double deltaT = cte.deltaT;

        /*
        If driving dynamics is locked, nothing will be done.
         */
        if(this.dynamicState == null || (this.tripProfile == null && !this.atoServerConnector.isAtoOn()) || this.currentMode == ETCSMode.NO_MODE){
            String source = "dd;T=" + trainDataVolatile.getEtcsID();
            EventBus.getDefault().post(new DMIUpdateEvent(source, "dmi", 0, 0, (int)0, 0,
                    SpeedInterventionLevel.NO_INTERVENTION, SpeedSupervisionState.CEILING_SPEED_SUPERVISION,
                    0, 0, 0, 0, 0));
            return;
        }

        /*
        Update TrainDataVolatile to set the current maximum allowed speed of the train
        based on the tripProfile
         */
        updateCurrentMaxTripProfileSpeed();

        if(!this.atoOn) this.atoOn = this.atoServerConnector.isAtoOn();
        else if(!this.atoServerConnector.isAtoOn()){
            this.dynamicState.setMovementState(MovementState.BREAKING);
            this.dynamicState.setBreakingModification(1);
            this.atoOn = false;
        }

        if(this.atoOn){
            drivingInATO();
        }
        else if(this.currentMode == ETCSMode.STAND_BY){
            drivingIllegal();
        }
        else {
            drivingAllowed();
        }


        /*
        Calculate the next dynamic state.
         */
        this.dynamicState.nextState(deltaT);

        if(this.atoOn){
            this.atoServerConnector.sendDynamicStateToATO(this.dynamicState);
        }
        /*
        Sends global PositionEvent
         */

        EventBus.getDefault().post(new PositionEvent("dd;T=" + this.etcsTrainID, "all", dynamicState.getPosition()));

        /*
        Update TrainDataVolatile with the newly calculated values
         */
        updateTrainDataVolatile();

        /*
        Update DMI
         */
        updateDMI();

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
        double offset = oldPos.getIncrement() -  newPos.totalDistanceToPastLocation(oldPos.getLocation().getId());
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
     * @param utpe {@link DDUpdateTripProfileEvent}
     */
    @Subscribe
    public void updateTripProfile(DDUpdateTripProfileEvent utpe){
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
            this.dynamicState.setDistanceToStartOfProfile(curPos.totalDistanceToPastLocation(utpe.refLocID));
        }
        this.time = AppTime.nanoTime();
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
                    sendToLogEventSpeedSupervision(MovementState.BREAKING);
                    ms = MovementState.BREAKING;
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
    private void drivingAllowed() {
        /*
        Checks the current SsmReportEvent for the status of the train
        Getting next action that should be taken and parsing that action
         */
        SsmReportEvent speedSupervisionReport = this.localEventBus.getStickyEvent(SsmReportEvent.class);
        if(speedSupervisionReport == null ){
            actionParser(this.drivingStrategy.actionToTake());
        }
        else if(this.shouldHalt && this.dynamicState.getSpeed() == 0){
            sendMovementStateIfNotAlreadySend(MovementState.HALTING);
            this.dynamicState.setMovementState(MovementState.HALTING);
            this.dynamicState.setBreakingModification(1d);
        }
        else {
            this.currentSil = speedSupervisionReport.interventionLevel;
            this.currentSsState = speedSupervisionReport.supervisionState;
            if(this.currentSsState != SpeedSupervisionState.RELEASE_SPEED_SUPERVISION){
                this.inRSM = false;
                switch (this.currentSil) {
                    case NOT_SET, NO_INTERVENTION, INDICATION, OVERSPEED, WARNING -> {
                        sendToLogEventSpeedSupervision(MovementState.UNCHANGED);
                        actionParser(this.drivingStrategy.actionToTake());
                    }
                    case APPLY_SERVICE_BREAKS -> {
                        sendToLogEventSpeedSupervision(MovementState.BREAKING);
                        this.dynamicState.setMovementState(MovementState.BREAKING);
                        this.dynamicState.setBreakingModification(1d);
                    }
                    default -> {
                        sendToLogEventSpeedSupervision(MovementState.EMERGENCY_BREAKING);
                        this.dynamicState.setMovementState(MovementState.EMERGENCY_BREAKING);
                        this.dynamicState.setBreakingModification(1d);
                    }
                }
            }
            else {
                if(!this.inRSM) calculateModifier();
                this.inRSM = true;
                /*
                        This control flow is necessary in case the train emergency breaks into RSM.
                        This control flow allows the train accelerate again until the stopping reagion is reached.
                        */
                switch (this.currentSil) {
                    case INDICATION -> {
                        if (!shouldHalt && this.dynamicState.getSpeed() == 0) {
                            sendToLogEventSpeedSupervision(MovementState.ACCELERATING);
                            this.dynamicState.setMovementState(MovementState.ACCELERATING);
                            this.dynamicState.setAccelerationModification(1d);
                            calculateModifier();
                        }
                        if (!shouldHalt && this.dynamicState.getSpeed() <= 1) {
                            sendToLogEventSpeedSupervision(MovementState.CRUISE);
                            this.dynamicState.setMovementState(MovementState.CRUISE);
                            calculateModifier();
                        } else {
                            sendToLogEventSpeedSupervision(MovementState.BREAKING);
                            this.dynamicState.setMovementState(MovementState.BREAKING);
                            this.dynamicState.setBreakingModification(this.breakModifierForRSM);
                        }
                    }
                    default -> {
                        sendToLogEventSpeedSupervision(MovementState.EMERGENCY_BREAKING);
                        this.dynamicState.setMovementState(MovementState.EMERGENCY_BREAKING);
                        this.dynamicState.setBreakingModification(1d);
                    }
                }
            }
            sendToLogEventSpeedState();
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
     * This method gathers the new information from dynamic state, adds data saved in {@link TrainDataVolatile}
     * and send these to the DMI
     */
    private void updateDMI(){
        double speed = this.dynamicState.getSpeed();
        double targetSpeed = this.trainDataVolatile.getTargetSpeed();
        double distanceToDrive = this.maxTripSectionDistance - this.dynamicState.getDistanceToStartOfProfile();
        double currentIndSpeed = this.trainDataVolatile.getCurrentIndicationSpeed();
        double currentPermSpeed = this.trainDataVolatile.getCurrentMaximumSpeed();
        double currentWarnSpeed = this.trainDataVolatile.getCurrentWarningSpeed();
        double currentIntervSpeed = this.trainDataVolatile.getCurrentServiceIntervention2Speed();
        double curApplReleaseSpeed = this.trainDataVolatile.getCurrentApplicableReleaseSpeed();

        String source = "dd;T=" + this.etcsTrainID;
        EventBus.getDefault().post(new DMIUpdateEvent(source, "dmi", speed, targetSpeed, (int)distanceToDrive,
                curApplReleaseSpeed, this.currentSil, this.currentSsState, currentIndSpeed,
                currentPermSpeed, currentWarnSpeed, currentIntervSpeed, this.dynamicState.getTripDistance()));
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
    private void sendMovementStateIfNotAlreadySend(MovementState ms){
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
        double distanceToEOA = this.maxTripSectionDistance - this.dynamicState.getDistanceToStartOfProfile();
        double neededBreakingACC = -0.5 * Math.pow(currentSpeed,2) / distanceToEOA;
        neededBreakingACC -= this.routeDataVolatile.getCurrentGradient() * 9.81 * 0.001;
        double modifier = -neededBreakingACC/maxBreakingAcc;
        if(modifier <= 0 || modifier > 1){
            modifier = 1;
        }
        this.breakModifierForRSM = modifier;
        System.out.println("modifier: " + modifier);
    }

    /**
     * Takes a spline and saves it to a file
     */
    private void saveTripProfileToFile(DDUpdateTripProfileEvent ddutpe) {
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
    private void actionParser(Action action) {
        if(this.timeOfLastAction > -1 && (this.time - this.timeOfLastAction) / 1E9 < this.timeBetweenActions){
            return;
        }

        this.timeOfLastAction = this.time;

        switch(action.getClass().getSimpleName()){
            case "NoAction":
                break;
            case "AccelerationAction":
                this.dynamicState.setMovementState(MovementState.ACCELERATING);
                this.dynamicState.setAccelerationModification(((AccelerationAction)action).getAccelerationPercentage());
                sendMovementStateIfNotAlreadySend(MovementState.ACCELERATING);
                break;
            case "BreakAction":
                this.dynamicState.setMovementState(MovementState.BREAKING);
                this.dynamicState.setBreakingModification(((BreakAction)action).getBreakPercentage());
                sendMovementStateIfNotAlreadySend(MovementState.BREAKING);
                break;
            case "CruiseAction":
                this.dynamicState.setMovementState(MovementState.CRUISE);
                sendMovementStateIfNotAlreadySend(MovementState.CRUISE);
                break;
            case "CoastAction":
                this.dynamicState.setMovementState(MovementState.COASTING);
                sendMovementStateIfNotAlreadySend(MovementState.COASTING);
                break;
            case "HaltAction":
                this.dynamicState.setMovementState(MovementState.HALTING);
                sendMovementStateIfNotAlreadySend(MovementState.HALTING);
                break;
            default:
                IllegalArgumentException iAE = new IllegalArgumentException("DrivingDynamics could not parse this action: " + action.getClass().getSimpleName());
                localEventBus.post(new DrivingDynamicsExceptionEvent("dd", this.exceptionTarget, new NotCausedByAEvent(), iAE, ExceptionEventTyp.FATAL));
        }
    }


}
