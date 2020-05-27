package ebd.radioBlockCenter;

import ebd.logging.Logging;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Map;

public class RadioBlockCenter {

    EventBus localBus = new EventBus();
    String rbcID = "rbc";
    String tmsEndpointID = "tmsEndpoint";
    Logging logger;

    TMSCommunicator tmsCommunicator;
    TMSEndpoint tmsEndpoint;
    ETCSEndpoint etcsEndpoint;
    MessageReceiver messageReceiver = new MessageReceiver(localBus, rbcID, "etcsEndpoint", false);
    MessageSender messageSender = new MessageSender(localBus, rbcID, false);

    String registeredTMS = "";
    Map<Integer, String> trainIDMap;

    public RadioBlockCenter() {
        tmsCommunicator = new TMSCommunicator();
        tmsCommunicator.start();
        try {
            this.logger = new Logging(localBus, 1, "RBC ");
        } catch(IOException e) {
            e.printStackTrace();
        }

        tmsEndpoint = new TMSEndpoint(rbcID, localBus, registeredTMS, trainIDMap);
        etcsEndpoint = new ETCSEndpoint(rbcID, localBus, registeredTMS, trainIDMap);

        localBus.register(tmsCommunicator);
        localBus.register(tmsEndpoint);
        localBus.register(etcsEndpoint);
    }
}
