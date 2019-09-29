package ebd.radioBlockCenter;

import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.logger.Logging;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import ebd.radioBlockCenter.util.handlers.MessageHandler;
import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RadioBlockCenter {

    private EventBus localBus;
    private String rbcID;
    private List<Integer> controlledTrainsByID;
    private HashMap<Integer,List<String>> trainIdsToRouts;

    private MessageSender messageSender;
    private MessageReceiver messageReceiver;

    /*
    Handler
     */
    private Logging logger;
    private MessageHandler messageHandler;

    public RadioBlockCenter(String rbcID, List<Integer> controlledTrainsByID){
        this.localBus = new EventBus();
        //this.localBus.register(this);
        this.rbcID = rbcID;
        this.controlledTrainsByID = controlledTrainsByID;

        try {
            this.logger = new Logging(this.localBus,Integer.parseInt(this.rbcID));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.messageHandler = new MessageHandler(this.localBus, this.controlledTrainsByID, this.rbcID, this.trainIdsToRouts);

        this.messageSender = new MessageSender(this.localBus,this.rbcID,false);
        this.messageReceiver = new MessageReceiver(this.localBus,this.rbcID, "all");

        this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), "RBC initialized"));
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
