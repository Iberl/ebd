package ebd.radioBlockCenter.util.handlers;

import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.messageLibrary.message.trackmessages.Message_24;
import ebd.messageLibrary.message.trainmessages.Message_132;
import ebd.messageLibrary.message.trainmessages.Message_146;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageHandler {

    EventBus localBus;
    String rbcID;

    List<Integer> controlledTrainsByID;
    Map<Integer, List<String>> trainIDsToRoute;

    public MessageHandler(EventBus localBus, List<Integer> controlledTrainIDs, String rbcID, Map<Integer, List<String>> trainIDsToRoute) {
        this.localBus = localBus;
        this.localBus.register(this);
        this.controlledTrainsByID = controlledTrainIDs;
        this.rbcID = rbcID;
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void receivedMessage(ReceivedMessageEvent rme){
        if(!validTarget(rme.targets)) return;
        if(rme.message instanceof Message_24){
            //TODO: Use "sender" of RME instead of controlledTrainsByID
            String msg = String.format("RBC -> ebd.logger.Logging: RBC received position report from train %s", controlledTrainsByID.get(0));
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
        }
        else if(rme.message instanceof Message_132){
            String msg = String.format("RBC -> ebd.logger.Logging: RBC received MA request from train %s", controlledTrainsByID.get(0));
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
            sendMessage3(rme);
        }
        else if(rme.message instanceof Message_146){
            String msg = String.format("RBC -> ebd.logger.Logging: RBC received Acknowledge from train %s", controlledTrainsByID.get(0));
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
        }
    }

    private void sendMessage3(ReceivedMessageEvent rme) {

    }

    private boolean validTarget(List<String> targetList){

        for(String target : targetList){
            if(target.contains("tsm") || target.contains("all")){
                if(!target.contains(";")){
                    return true;
                }
                else if (target.contains(";R=" + this.rbcID)){
                    return true;
                }
            }
        }
        return false;
    }


}
