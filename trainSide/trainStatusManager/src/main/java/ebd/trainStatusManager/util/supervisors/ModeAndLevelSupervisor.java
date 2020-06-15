package ebd.trainStatusManager.util.supervisors;


import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.etcsModeAndLevel.ETCSLevel;
import ebd.globalUtils.etcsModeAndLevel.ETCSMode;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.*;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.Packet_80;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ModeAndLevelSupervisor {

    private class ModeProfil {

        private boolean unspecified = true;
        private TreeMap<Double,ETCSMode> modeTreeMap = new TreeMap<>();

        private ModeProfil(){};

        private ModeProfil(TreeMap<Double, ETCSMode> modeTreeMap){
            this.unspecified = false;
            this.modeTreeMap = modeTreeMap;
        }

        private ETCSMode getMode(double distance){
            Map.Entry<Double,ETCSMode> entry = modeTreeMap.floorEntry(distance);
            return entry == null ? null : entry.getValue();
        }

        private ETCSMode getNextMode(double distance){
            Map.Entry<Double,ETCSMode> entry =  modeTreeMap.higherEntry(distance);
            return entry == null ? null : entry.getValue();
        }

        private Map.Entry<Double,ETCSMode> getNextModeAndDistance(double distance){
            return modeTreeMap.higherEntry(distance);
        }

    }

    private EventBus localEventBus;
    private TrainDataVolatile trainDataVolatile;
    private TrainDataPerma trainDataPerma;
    private RouteDataVolatile routeDataVolatile;
    private ETCSLevel curLevel = ETCSLevel.LEVEL_TWO;
    private ETCSMode curMode = ETCSMode.STAND_BY;

    private ModeProfil modeProfil;

    private double curDis = 0; //in [m]

    /*
    Control Booleans
     */
    private BreakingCurve bc = null;
    private boolean errorDetected = false;
    private boolean unconEStop = false; //TODO Implement unconditional emergency stop message


    /**
     *
     * @param localEventBus The local {@link EventBus}
     */
    public ModeAndLevelSupervisor(EventBus localEventBus) {
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);
        this.trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        this.trainDataPerma = this.localEventBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        this.routeDataVolatile = this.localEventBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
        this.modeProfil = new ModeProfil();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cte){

        this.curDis = trainDataVolatile.getCurTripSectionDistance();

        checkModeProfil();

        testLevelConditions();

        checkAndAssignAllModes();

        this.localEventBus.postSticky(new LevelReportEvent("tsm", "all", this.curLevel));
        this.localEventBus.postSticky(new ModeReportEvent("tsm", "all", this.curMode));

    }

    @Subscribe
    public void exception(ExceptionEvent ee){
        if(!validTarget(ee.target)) return;

        if(ee.exceptionEventTyp == ExceptionEventTyp.CRITICAL) this.errorDetected = true;
    }

    @Subscribe
    public void breakinCurve(NewBreakingCurveEvent nbce){
        this.bc = nbce.breakingCurveGroup.getPermittedSpeedCurve();
        Packet_80 p80 = routeDataVolatile.getPacket_80();
        this.modeProfil = makeModeProfil(p80);
    }


    /*
    Modes
     */
    private void checkModeProfil() {
        if(this.modeProfil.unspecified) return;

        if(this.modeProfil.getNextMode(this.curDis) == ETCSMode.SHUNTING){
            if(!routeDataVolatile.isLastMABeforeEndOfMission()) {
                this.localEventBus.post(new RouteDataChangeEvent("tsm","rd","lastMABeforeEndOfMission", true));
            }
        }
        if(this.modeProfil.getMode(this.curDis) == ETCSMode.SHUNTING){
            if(!routeDataVolatile.isLastMABeforeEndOfMission()) {
                this.localEventBus.post(new RouteDataChangeEvent("tsm","rd","lastMABeforeEndOfMission", true));
            }
            //TODO Switch to Shunting?
        }
    }


    private void checkAndAssignAllModes(){


        //SRS-026 4.6.3 [5], [19], [50] ignored, no driver
        //SRS-026 4.6.3 [6] ignored, until Shunting Request is implemented
        //SRS-026 4.6.3 [17], [18], [65] ignored because balise implementation does not send trip signals
        //SRS-026 4.6.3 [27], [28], [30] ignored, no desks to operate
        //SRS-026 4.6.3 [41] ignored, T_NVCONTACT not implemented
        //SRS-026 4.6.3 [49], [52], [65] ignored, no driving in shunting mode implemented
        //SRS-026 4.6.3 [66] ignored //TODO Implement Balise direction
        //SRS-026 4.6.3 [68] ignored, no driver

        /*
        Tests for modes along the priorities defined in SRS-026 4.6.2 .
        Only implemented modes (see ETCSMode) are considered.
         */
        switch (this.curMode){
            case STAND_BY:
                if(checkModeCondition13()); //P3 SystemFailure
                else if(checkModeCondition20()); //P4 Trip
                else if(checkModeCondition10()); //P7 FullSupervision
                //No switch from Standby to Shunting is currently possible
                break;
            case SHUNTING:
                if(checkModeCondition13()); //P3 SystemFailure
                break;
            case FULL_SUPERVISION:
                if(checkModeCondition13()); // P3 SystemFailure
                else if(checkModeCondition12()); //P4 Trip
                else if(checkModeCondition16()); //P4 Trip
                else if(checkModeCondition20()); //P4 Trip
                else if(checkModeCondition69()); //P4 Trip
                else if(checkModeCondition51()); //P6 Shunting
                break;
            case TRIP:
                if(checkModeCondition13()); // P3 SystemFailure
                else if(checkModeCondition7()); // P4 PostTrip
                break;
            case POST_TRIP:
                if(checkModeCondition13()); // P3 SystemFailure
                else if(checkModeCondition31()); //P5 FullSupervision
                break;
            case NO_MODE:
            case SYSTEM_FAILURE:
                break;
        }
    }
    /*
    Mode conditions
     */

    /**
     * See SRS-026 4.6.3 [7]
     * Returns true and switches into {@link ETCSMode#POST_TRIP} if condition is met.
     * @return True if a valid system state was detected and the current speed of the train is 0 m/s.
     */
    private boolean checkModeCondition7() {
        boolean etcsLevelOneOrTwoOrThree = this.curLevel != ETCSLevel.LEVEL_ZERO && this.curLevel != ETCSLevel.NTC_PZBLZB;

        if(etcsLevelOneOrTwoOrThree && this.trainDataVolatile.getCurrentSpeed() == 0){
            this.curMode = ETCSMode.POST_TRIP;
            return true;
        }
        return false;
    }

    /**
     * See SRS-026 4.6.3 [10]
     * Returns true and switches into {@link ETCSMode#FULL_SUPERVISION} if condition is met.
     * @return True if a valid system state was detected
     */
    private boolean checkModeCondition10() {
        boolean vaildRouteData = routeDataVolatile != null
                && routeDataVolatile.getPacket_15() != null
                && routeDataVolatile.getPacket_21() != null
                && routeDataVolatile.getPacket_27() != null;

        boolean vaildTrainData = trainDataPerma != null && trainDataVolatile != null;
        vaildTrainData = vaildTrainData && trainDataVolatile.getCurrentPosition() != null;
        // TODO Insert after a SR/SH start is implemented
        //vaildTrainData = vaildTrainData && trainDataVolatile.getCurrentPosition().getLocation().getId() != ETCSVariables.NID_LRBG_UNKNOWN;
        if(vaildTrainData && vaildRouteData){//SRS-026 4.6.3 [10]
            if(this.modeProfil.unspecified || this.modeProfil.getMode(this.curDis) != ETCSMode.SHUNTING) {
                this.curMode = ETCSMode.FULL_SUPERVISION;
                return true;
            }
        }

        return false;
    }

    /**
     * See SRS-026 4.6.3 [12]
     * Returns true and switches into {@link ETCSMode#TRIP} if condition is met.
     * @return True if a train has passed EMA/LOA
     */
    private boolean checkModeCondition12(){
        boolean etcsLevelOneOrTwoOrThree = this.curLevel != ETCSLevel.LEVEL_ZERO && this.curLevel != ETCSLevel.NTC_PZBLZB;
        Position curPos = this.trainDataVolatile.getCurrentPosition();
        if(this.routeDataVolatile.getRefLocation() == null || this.bc == null || curPos.getLocation().getId() == ETCSVariables.NID_LRBG_UNKNOWN){
            return false;
        }

        double distanceToEoaLoa = this.bc.getHighestXValue() - curPos.totalDistanceToPastLocation(this.bc.getRefLocation().getId());
        boolean loaOrEoaPassed = distanceToEoaLoa < 0 ;

        if(loaOrEoaPassed && etcsLevelOneOrTwoOrThree){//SRS-026 4.6.3 [12]
            this.curMode = ETCSMode.TRIP;
            return true;
        }
        return false;
    }

    /**
     * See SRS-026 4.6.3 [13]
     * Returns true and switches into {@link ETCSMode#SYSTEM_FAILURE} if condition is met.
     * @return True if a system failure was detected
     */
    private boolean checkModeCondition13() {
        if(this.errorDetected) {
            this.curMode = ETCSMode.SYSTEM_FAILURE; //SRS-026 4.6.3 [13]
            return true;
        }
        return false;
    }

    /**
     * See SRS-026 4.6.3 [16]
     * Returns true and switches into {@link ETCSMode#TRIP} if condition is met.
     * @return True if a train has passed EMA/LOA
     */
    private boolean checkModeCondition16(){
        return checkModeCondition12();
    }


    /**
     * See SRS-026 4.6.3 [20]
     * Returns true and switches into {@link ETCSMode#TRIP} if condition is met.
     * @return True if a unconditional emergency stop was received
     */
    private boolean checkModeCondition20() {
        if(this.unconEStop) {
            this.curMode = ETCSMode.TRIP; //SRS-026 4.6.3 [13]
            return true;
        }
        return false;
    }

    /**
     * See SRS-026 4.6.3 [20]
     * Returns true and switches into {@link ETCSMode#FULL_SUPERVISION} if condition is met.
     * @return True if a valid state for route data exists and the train not in front of SSP and modeProfil does not demand shunting
     */
    private boolean checkModeCondition31() {
        Position curPos = this.trainDataVolatile.getCurrentPosition();
        if(curPos == null || this.routeDataVolatile.getRefLocation() == null) return false;

        int locationID = this.routeDataVolatile.getRefLocation().getId();
        boolean trainBehindStartOfSSPOrGP = curPos.getLocation().getId() == locationID || curPos.previousLocationsContainsID(locationID);

        boolean etcsLevelTwoOrThree = this.curLevel == ETCSLevel.LEVEL_TWO || this.curLevel == ETCSLevel.LEVEL_THREE;
        boolean vaildRouteData = routeDataVolatile != null
                && routeDataVolatile.getPacket_15() != null
                && routeDataVolatile.getPacket_21() != null
                && routeDataVolatile.getPacket_27() != null
                && trainBehindStartOfSSPOrGP;

        if(vaildRouteData && etcsLevelTwoOrThree){//SRS-026 4.6.3 [31]
            if(this.modeProfil.unspecified || this.modeProfil.getMode(this.curDis) != ETCSMode.STAND_BY)
                this.curMode = ETCSMode.FULL_SUPERVISION;
            return true;
        }
        return false;
    }

    /**
     * See SRS-026 4.6.3 [51]
     * Returns true and switches into {@link ETCSMode#SHUNTING} if condition is met.
     * @return True if a mode profile demands a switch into shunting and preconditions are met
     */
    private boolean checkModeCondition51() {
        if(!this.modeProfil.unspecified && this.modeProfil.getMode(this.curDis) == ETCSMode.SHUNTING){
            this.curMode = ETCSMode.SHUNTING;
            return true;
        }
        return false;
    }

    /**
     * See SRS-026 4.6.3 [69]
     * Returns true and switches into {@link ETCSMode#TRIP} if condition is met.
     * @return True if a train is currently in front of SSP
     */
    private boolean checkModeCondition69(){
        Position curPos = this.trainDataVolatile.getCurrentPosition();
        if(curPos == null || this.routeDataVolatile.getRefLocation() == null) return false;

        int locationID = this.routeDataVolatile.getRefLocation().getId();
        boolean trainBehindStartOfSSPOrGP = curPos.getLocation().getId() == locationID || curPos.previousLocationsContainsID(locationID);

        if(!trainBehindStartOfSSPOrGP) {//SRS-026 4.6.3 [69]
            this.curMode = ETCSMode.TRIP;
            return true;
        }

        return false;
    }

    /*
    Levels
     */
    private void testLevelConditions() {
        //TODO Implement other levels then ETCSLevel.LEVEL_TWO
        if(this.curLevel != ETCSLevel.LEVEL_TWO) this.curLevel = ETCSLevel.LEVEL_TWO;
    }

    /*
    Misc
     */
    private ModeProfil makeModeProfil(Packet_80 p80) {
        if(p80 == null) return new ModeProfil();

        List<Packet_80.Packet_80_MAMode> modeList = p80.modes;
        modeList.add(0, p80.mode);

        double scale = Math.pow(10,p80.Q_SCALE - 1);

        TreeMap<Double,ETCSMode> modeTreeMap = new TreeMap<>();
        for (Packet_80.Packet_80_MAMode mode : modeList){
            modeTreeMap.put(mode.D_MAMODE * scale, modeTranslator(mode.M_MAMODE));
        }


        return new ModeProfil(modeTreeMap);
    }

    private ETCSMode modeTranslator(int m_mamode) {
        switch (m_mamode){
            case 1:
                return ETCSMode.SHUNTING;
            case 0:
            case 2:
            default:
                return ETCSMode.NO_MODE;
        }
    }

    private boolean validTarget(String target){

        if(target.contains("tsm") || target.contains("all")){
            if(!target.contains(";")){
                return true;
            }
            else if (target.contains(";T=" + trainDataVolatile.getEtcsID())){
                return true;
            }
        }

        return false;
    }
}