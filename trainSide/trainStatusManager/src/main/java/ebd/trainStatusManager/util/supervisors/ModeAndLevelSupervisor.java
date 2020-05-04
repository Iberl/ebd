package ebd.trainStatusManager.util.supervisors;


import ebd.globalUtils.etcsModeAndLevel.ETCSLevel;
import ebd.globalUtils.etcsModeAndLevel.ETCSMode;
import ebd.globalUtils.events.trainStatusMananger.LevelChangeRequestEvent;
import ebd.globalUtils.events.trainStatusMananger.ModeChangeRequestEvent;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ModeAndLevelSupervisor {

    EventBus localEventBus;
    TrainDataVolatile trainDataVolatile;
    TrainDataPerma trainDataPerma;
    RouteDataVolatile routeDataVolatile;
    ETCSLevel curLevel = ETCSLevel.LEVEL_THREE;
    ETCSMode curMode = ETCSMode.STAND_BY;

    public ModeAndLevelSupervisor(EventBus localEventBus) {
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);
        this.trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        this.trainDataPerma = this.localEventBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        this.routeDataVolatile = this.localEventBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
    }

    @Subscribe
    public void modeChange(ModeChangeRequestEvent mcre){
        if(!validTarget(mcre.target)) return;

        boolean approved = checkAndAssignMode(mcre.newMode);
        sendModeStatus(mcre, approved);

    }




    @Subscribe
    public void levelChange(LevelChangeRequestEvent lcre){
        if(!validTarget(lcre.target)) return;

        boolean approved = checkAndAssigneLevel(lcre.newLevel);
        sendLevelStatus(lcre, approved);
    }

    /*
    Modes
     */

    private boolean checkAndAssignMode(ETCSMode newMode) {

        switch (newMode){
            case SYSTEM_FAILURE:
                return systemFailure();
            case STAND_BY:
                return standBy();
            case SHUNTING:
                return shunting();
            case FULL_SUPERVISION:
                return fullSupervision();
            case TRIP:
                return trip();
            case POST_TRIP:
                return postTrip();
            default:
                return false;
        }
    }

    private void sendModeStatus(ModeChangeRequestEvent mcre, boolean approved) {
    }

    private boolean systemFailure() {
        this.curMode = ETCSMode.SYSTEM_FAILURE; //SRS-026 4.6.3 [13]
        return true;
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

    private boolean checkAndAssigneLevel(ETCSLevel newLevel) {
        return false;
    }

    private void sendLevelStatus(LevelChangeRequestEvent mcre, boolean approved) {

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