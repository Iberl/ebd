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
            return modeTreeMap.floorEntry(distance).getValue();
        }

        private Map.Entry<Double,ETCSMode> getNextMode(double distance){
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

        double curDis = trainDataVolatile.getCurTripSectionDistance();
        if(this.modeProfil.getNextMode(curDis).getValue() == ETCSMode.SHUNTING){
            if(!routeDataVolatile.isLastMABeforeEndOfMission()) {
                this.localEventBus.post(new RouteDataChangeEvent("tsm","rd","lastMABeforeEndOfMission", true));
            }
        }
        if(this.modeProfil.getMode(curDis) == ETCSMode.SHUNTING){
            if(!routeDataVolatile.isLastMABeforeEndOfMission()) {
                this.localEventBus.post(new RouteDataChangeEvent("tsm","rd","lastMABeforeEndOfMission", true));
            }
            //TODO Switch to Shunting?
        }
    }


    private void checkAndAssignAllModes(){

        /*
        Tests for modes along the priorities defined in SRS-026 4.6.2 .
        Only implemented modes (see ETCSMode) are considered.
        Every Priority is tested until one finds a mode applicable, assigns it to this.curMode and returns true.
         */
        if (modeP3());
        else if (modeP4());
        else if (modeP5());
        else if (modeP6());
        else modeP7();
    }

    /**
     * See SRS-026 4.6.2 Figure 2
     * @return True if a mode condtion was vaild and mode was assigned
     */
    private boolean modeP3() {
        if(this.errorDetected) {
            this.curMode = ETCSMode.SYSTEM_FAILURE; //SRS-026 4.6.3 [13]
            return true;
        }
        return false;
    }

    private boolean modeP4() {
        //SRS-026 4.6.3 [68] ignored, no driver
        //SRS-026 4.6.3 [28] ignored, no desk to close
        //SRS-026 4.6.3 [17], [18], [65] ignored because balise implementation does not send trip signals
        //SRS-026 4.6.3 [41] T_NVCONTACT not implemented
        //SRS-026 4.6.3 [49], [52], [65] ignored, no driving in shunting mode implemented
        //SRS-026 4.6.3 [66] ignored //TODO Implement Balise direction

        if((this.curMode == ETCSMode.FULL_SUPERVISION || this.curMode == ETCSMode.STAND_BY) && this.unconEStop){//SRS-026 4.6.3 [20]
            this.curMode = ETCSMode.TRIP;
            return true;
        }

        boolean etcsLevelOneOrTwoOrThree = this.curLevel != ETCSLevel.LEVEL_ZERO && this.curLevel != ETCSLevel.NTC_PZBLZB;

        if(this.curMode == ETCSMode.TRIP && etcsLevelOneOrTwoOrThree && this.trainDataVolatile.getCurrentSpeed() == 0){//SRS-026 4.6.3 [7]
            this.curMode = ETCSMode.POST_TRIP;
            return true;
        }

        /*
         Distance related checks
         */
        Position curPos = this.trainDataVolatile.getCurrentPosition();
        if(this.routeDataVolatile.getRefLocation() == null || this.bc == null || curPos.getLocation().getId() == ETCSVariables.NID_LRBG_UNKNOWN){
            return false;
        }

        int locationID = this.routeDataVolatile.getRefLocation().getId();
        double distanceToEoaLoa = this.bc.getHighestXValue() - curPos.totalDistanceToPastLocation(this.bc.getRefLocation().getId());
        boolean loaOrEoaPassed = distanceToEoaLoa < 0 ;



        if(this.curMode == ETCSMode.FULL_SUPERVISION && loaOrEoaPassed && etcsLevelOneOrTwoOrThree){//SRS-026 4.6.3 [12], [16]
            this.curMode = ETCSMode.TRIP;
            return true;
        }

        boolean trainBeforeStartOfSSPOrGP = !curPos.previousLocationsContainID(locationID);

        if(this.curMode == ETCSMode.FULL_SUPERVISION && trainBeforeStartOfSSPOrGP) {//SRS-026 4.6.3 [69]
            this.curMode = ETCSMode.TRIP;
            return true;
        }


        return false;
    }

    private boolean modeP5() {
        //SRS-026 4.6.3 [5], [19], [50] ignored, no driver
        //SRS-026 4.6.3 [27], [28], [30] ignored, no desks to operate
        //SRS-026 4.6.3 [6] ignored, until Shunting Request is implemented


        Position curPos = this.trainDataVolatile.getCurrentPosition();
        if(curPos == null || this.routeDataVolatile.getRefLocation() == null) return false;

        int locationID = this.routeDataVolatile.getRefLocation().getId();
        boolean trainBeforeStartOfSSPOrGP = !curPos.previousLocationsContainID(locationID);

        boolean etcsLevelTwoOrThree = this.curLevel == ETCSLevel.LEVEL_TWO || this.curLevel == ETCSLevel.LEVEL_THREE;
        boolean vaildRouteData = routeDataVolatile != null
                && routeDataVolatile.getPacket_15() != null
                && routeDataVolatile.getPacket_21() != null
                && routeDataVolatile.getPacket_27() != null
                && trainBeforeStartOfSSPOrGP;

        if(this.curMode == ETCSMode.POST_TRIP && this.modeProfil.unspecified && vaildRouteData && etcsLevelTwoOrThree){//SRS-026 4.6.3 [31]
            this.curMode = ETCSMode.FULL_SUPERVISION;
            return true;
        }

        return false;
    }

    private boolean modeP6() {
        //SRS-026 4.6.3 [28] ignored, no desks to operate
        //SRS-026 4.6.3 [51] //TODO Implement Mode Profil
        return false;
    }

    private boolean modeP7() {
        boolean vaildRouteData = routeDataVolatile != null
                && routeDataVolatile.getPacket_15() != null
                && routeDataVolatile.getPacket_21() != null
                && routeDataVolatile.getPacket_27() != null;

        boolean vaildTrainData = trainDataPerma != null && trainDataVolatile != null;
        vaildTrainData = vaildTrainData && trainDataVolatile.getCurrentPosition() != null;
        // TODO Insert after a SR/SH start is implemented
        //vaildTrainData = vaildTrainData && trainDataVolatile.getCurrentPosition().getLocation().getId() != ETCSVariables.NID_LRBG_UNKNOWN;

        if(this.curMode == ETCSMode.STAND_BY && vaildTrainData && vaildRouteData && this.modeProfil.unspecified){//SRS-026 4.6.3 [10]
            this.curMode = ETCSMode.FULL_SUPERVISION;
            return true;
        }
        return false;
    }

    private boolean standBy(){
        //SRS-026 4.6.3 [27], [28], [30] are ignored, there is no desk to close.
        if(curMode == ETCSMode.SHUNTING && trainDataVolatile.getCurrentSpeed() == 0){ //SRS-026 4.6.3 [19]
            this.curMode = ETCSMode.STAND_BY;
            return true;
        }
        return false;
    }

    private boolean shunting(){
        //TODO Implement preconditions for SRS-026 4.6.3 [6],[50],[51] and [61]

        boolean etcsLevelOneZeroNTC = this.curLevel == ETCSLevel.LEVEL_ONE
                                        || this.curLevel == ETCSLevel.LEVEL_ZERO
                                        || this.curLevel == ETCSLevel.NTC_PZBLZB;

        if(etcsLevelOneZeroNTC && trainDataVolatile.getCurrentSpeed() == 0){
            this.curMode = ETCSMode.STAND_BY;
            return true;
        }

        boolean shuntingIsGranted = true; //TODO Implement Shunting Request Messages

        if(!etcsLevelOneZeroNTC && trainDataVolatile.getCurrentSpeed() == 0 && shuntingIsGranted){
            this.curMode = ETCSMode.STAND_BY;
            return true;
        }

        return false;
    }

    private boolean fullSupervision(){
        //SRS-026 4.6.3 [25], [32] ignored, modes not implemented
        boolean vaildTrainData = trainDataPerma != null && trainDataVolatile != null;
        boolean vaildRouteData = routeDataVolatile != null
                                    && routeDataVolatile.getPacket_15() != null
                                    && routeDataVolatile.getPacket_21() != null
                                    && routeDataVolatile.getPacket_27() != null;
        boolean unspecificModeProfil = true; //TODO Implement ModeProfil

        boolean etcsLevelTwoOrThree = this.curLevel == ETCSLevel.LEVEL_TWO || this.curLevel == ETCSLevel.LEVEL_THREE;

        if(this.curMode == ETCSMode.POST_TRIP && unspecificModeProfil && vaildRouteData && etcsLevelTwoOrThree){//SRS-026 4.6.3 [31]
            this.curMode = ETCSMode.FULL_SUPERVISION;
            return true;
        }

        if(this.curMode == ETCSMode.STAND_BY && vaildTrainData && vaildRouteData && unspecificModeProfil){//SRS-026 4.6.3 [10]
            this.curMode = ETCSMode.FULL_SUPERVISION;
            return true;
        }

        return false;
    }

    private boolean trip(){
        //SRS-026 4.6.3 [17],[18], [65] ignored because balise implementation does not send trip signals
        //SRS-026 4.6.3 [41] T_NVCONTACT not implemented
        //SRS-026 4.6.3 [66] //TODO Implement Balise direction
        //SRS-026 4.6.3 [69] ignored //TODO Save implementation
        boolean unconEStop = true; //TODO Implement unconditional emergency stop message
        boolean loaOrEoaPassed = true; //TODO Implement passed eoa
        boolean etcsLevelTwoOrThree = this.curLevel == ETCSLevel.LEVEL_TWO || this.curLevel == ETCSLevel.LEVEL_THREE;


        if(this.curMode == ETCSMode.FULL_SUPERVISION || this.curMode == ETCSMode.STAND_BY && unconEStop){//SRS-026 4.6.3 [20]
            this.curMode = ETCSMode.TRIP;
            return true;
        }

        if(this.curMode == ETCSMode.FULL_SUPERVISION && loaOrEoaPassed && this.curLevel == ETCSLevel.LEVEL_ONE){//SRS-026 4.6.3 [12]
            this.curMode = ETCSMode.TRIP;
            return true;
        }

        if(this.curMode == ETCSMode.FULL_SUPERVISION && loaOrEoaPassed && etcsLevelTwoOrThree){//SRS-026 4.6.3 [16]
            this.curMode = ETCSMode.TRIP;
            return true;
        }

        return false;
    }

    private boolean postTrip(){
        boolean ackByDriver = true;
        boolean etcsLevelNotZeorOrNTC = this.curLevel != ETCSLevel.LEVEL_ZERO && this.curLevel != ETCSLevel.NTC_PZBLZB;

        if(this.curMode == ETCSMode.TRIP && etcsLevelNotZeorOrNTC && ackByDriver){//SRS-026 4.6.3 [7]
            this.curMode = ETCSMode.POST_TRIP;
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