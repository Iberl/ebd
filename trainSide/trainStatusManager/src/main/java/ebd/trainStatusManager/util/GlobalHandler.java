package ebd.trainStatusManager.util;

import ebd.globalUtils.events.DisconnectEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class GlobalHandler {

    EventBus localBus;
    String etcsTrainID;

    public GlobalHandler(EventBus localBus, String etcsTrainID){

        this.localBus = localBus;
        this.etcsTrainID = etcsTrainID;
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void disconnect(DisconnectEvent de){
        if(!validTarget(de.targets)){
            return;
        }
        this.localBus.post(de);
    }

    /**
     * True if this Instance is a vaild target of the event
     * @param targetList the target list a the event
     * @return True if this instance is a vaild target of the event
     */
    private boolean validTarget(List<String> targetList){
        boolean result = false;

        for(String target : targetList){
            if(target.contains("tsm") || target.contains("all")){
                if(!target.contains(";")){
                    result = true;
                    break;
                }
                else if (target.contains(";T=" + this.etcsTrainID)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }


}
