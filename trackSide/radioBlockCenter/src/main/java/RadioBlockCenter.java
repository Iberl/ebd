import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.messageLibrary.message.trackmessages.Message_24;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class RadioBlockCenter {

    private EventBus localBus;
    private String rbcID;
    private List<String> controlledTrainsByID;

    private Logging logger;
    private MessageSender messageSender;
    private MessageReceiver messageReceiver;

    public RadioBlockCenter(EventBus localBus, String rbcID, List<String> controlledTrainsByID){
        this.localBus = localBus;
        this.localBus.register(this);
        this.rbcID = rbcID;
        this.controlledTrainsByID = controlledTrainsByID;

        try {
            this.logger = new Logging(this.localBus,Integer.parseInt(this.rbcID));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.messageSender = new MessageSender(this.localBus,this.rbcID,false);
        this.messageReceiver = new MessageReceiver(this.localBus,this.rbcID, "all");
    }

    @Subscribe
    public void receivedMessage(ReceivedMessageEvent rme){
        if(!validTarget(rme.targets)) return;
        if(rme.message instanceof Message_24){
        //TODO: Use "sender" of RME instead of controlledTrainsByID
        String msg = String.format("RBC -> Logging: RBC received position report from train %s", controlledTrainsByID.get(0));
        this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
        }
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
