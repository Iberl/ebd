package ebd.trainStatusManager.util;

import org.greenrobot.eventbus.EventBus;

public class TelegramHandler {

    //TODO: Respect SRS 3 A.3.3
    private EventBus localBus;
    private String etcsTrainID;

    public TelegramHandler(EventBus localBus, String etcsTrainID){
        this.localBus = localBus;
        this.etcsTrainID = etcsTrainID;
    }


}
