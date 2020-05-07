package ebd.radioBlockCenter;

import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import org.greenrobot.eventbus.EventBus;

import java.util.Map;

public class RadioBlockCenter {

    EventBus localBus = new EventBus();
    String rbcID = "rbc";

    TMSCommunicator tmsCommunicator;
    TMSEndpoint tmsEndpoint;
    ETCSEndpoint etcsEndpoint;
    MessageReceiver messageReceiver = new MessageReceiver(localBus, rbcID, "etcsEndpoint", false);
    MessageSender messageSender = new MessageSender(localBus, rbcID, false);

    String registeredTMS = "";
    Map<Integer, String> trainIDMap;

    public RadioBlockCenter() {
        tmsCommunicator = new TMSCommunicator();
        tmsEndpoint = new TMSEndpoint(rbcID, localBus, registeredTMS, trainIDMap);
        etcsEndpoint = new ETCSEndpoint(rbcID, localBus, registeredTMS, trainIDMap);
    }
}
