package ebd.radioBlockCenter;

import ebd.logging.Logging;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import ebd.radioBlockCenter.util.Constants;
import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Map;

public class RadioBlockCenter {

    private EventBus localBus = new EventBus();
    private Logging  logger;

    private static int    rbcID;
    private final  String tmsEndpointID = Constants.ID_TMS_ENDPOINT;

    private TMSCommunicator tmsCommunicator;
    private TMSEndpoint     tmsEndpoint;
    private ETCSEndpoint    etcsEndpoint;
    private MessageReceiver messageReceiver;
    private MessageSender   messageSender;

    private String registeredTMS = "";

    private Map<Integer, String> trainIDMap;

    public RadioBlockCenter(int rbcID) {
        this.rbcID = rbcID;

        tmsCommunicator = new TMSCommunicator(localBus);
        tmsCommunicator.start();

        tmsEndpoint = new TMSEndpoint(localBus, rbcID, registeredTMS, trainIDMap);
        etcsEndpoint = new ETCSEndpoint(localBus, rbcID, registeredTMS, trainIDMap);
        messageSender = new MessageSender(localBus, String.valueOf(rbcID), false);
        messageReceiver = new MessageReceiver(localBus, String.valueOf(rbcID), Constants.ID_ETCS_ENDPOINT, false);

        try {
            this.logger = new Logging(localBus, rbcID, "RBC");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
