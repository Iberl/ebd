package ebd.radioBlockCenter;

import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.events.radioBlockCenter.SendTMSMessageEvent;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import ebd.rbc_tms.message.Message_01;
import ebd.rbc_tms.message.Message_15;
import ebd.rbc_tms.payload.Payload_01;
import ebd.rbc_tms.payload.Payload_15;
import org.greenrobot.eventbus.EventBus;

import java.util.Map;

public class RadioBlockCenter {

    EventBus localBus = new EventBus();
    String rbcID = "rbc";
    String tmsEndpointID = "tmsEndpoint";

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
        tmsEndpoint = new TMSEndpoint(rbcID, localBus, registeredTMS, trainIDMap);
        etcsEndpoint = new ETCSEndpoint(rbcID, localBus, registeredTMS, trainIDMap);

        localBus.register(tmsCommunicator);
        localBus.register(tmsEndpoint);
        localBus.register(etcsEndpoint);
    }
}
