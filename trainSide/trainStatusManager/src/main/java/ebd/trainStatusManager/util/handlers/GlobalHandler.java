package ebd.trainStatusManager.util.handlers;

import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.trainStatusMananger.ContinueClockEvent;
import ebd.globalUtils.events.trainStatusMananger.PauseClockEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * This class handles the communication with the global {@link EventBus}
 * for the {@link ebd.trainStatusManager.TrainStatusManager}.
 *
 * @author Lars Schulze-Falck
 */
public class GlobalHandler {

    EventBus localBus;
    int etcsTrainID;

    /**
     * Constructor
     * @param localBus the local {@link EventBus} of the train
     * @param etcsTrainID the ETCS ID of the train
     */
    public GlobalHandler(EventBus localBus, int etcsTrainID){

        this.localBus = localBus;
        this.etcsTrainID = etcsTrainID;
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void pauseClock(PauseClockEvent pce){
        if(!validTarget(pce.targets)) return;
        this.localBus.post(pce);
    }

    @Subscribe
    public void continueClock(ContinueClockEvent cce){
        if(!validTarget(cce.targets)) return;
        this.localBus.post(cce);
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
