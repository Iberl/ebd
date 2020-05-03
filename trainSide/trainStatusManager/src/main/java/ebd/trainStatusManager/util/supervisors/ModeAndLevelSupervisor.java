package ebd.trainStatusManager.util.supervisors;


import ebd.globalUtils.etcsModeAndLevel.ETCSLevel;
import ebd.globalUtils.etcsModeAndLevel.ETCSMode;
import ebd.globalUtils.events.trainStatusMananger.LevelChangeRequestEvent;
import ebd.globalUtils.events.trainStatusMananger.ModeChangeRequestEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ModeAndLevelSupervisor {

    EventBus localEventBus;
    ETCSLevel curLevel = ETCSLevel.LEVEL_THREE;
    ETCSMode curMode = ETCSMode.STAND_BY;

    public ModeAndLevelSupervisor(EventBus localEventBus, ETCSLevel curLevel, ETCSMode curMode) {
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);
        this.curLevel = curLevel;
        this.curMode = curMode;
    }

    @Subscribe
    public void modeChange(ModeChangeRequestEvent mcre){
        boolean approved = checkAndAssigneMode(mcre.newMode);
        sendModeStatus(mcre, approved);

    }



    @Subscribe
    public void levelChange(LevelChangeRequestEvent mcre){
        boolean approved = checkAndAssigneLevel(mcre.newLevel);
        sendLevelStatus(mcre, approved);
    }


    private boolean checkAndAssigneMode(ETCSMode newMode) {
        return false;
    }

    private void sendModeStatus(ModeChangeRequestEvent mcre, boolean approved) {
    }

    private boolean checkAndAssigneLevel(ETCSLevel newLevel) {
        return false;
    }

    private void sendLevelStatus(LevelChangeRequestEvent mcre, boolean approved) {

    }
}
