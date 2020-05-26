package ebd.radioBlockCenter;

import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.events.radioBlockCenter.SendTMSMessageEvent;
import ebd.rbc_tms.message.Message_01;
import ebd.rbc_tms.message.Message_15;
import ebd.rbc_tms.payload.Payload_01;
import ebd.rbc_tms.payload.Payload_15;

public class Test {

    public static void main(String[] args) {
        RadioBlockCenter rbc = new RadioBlockCenter();
        //rbc.localBus.post(new SendTMSMessageEvent(rbc.rbcID, rbc.tmsEndpointID, new Message_01("all", "rbc", new Payload_01(
        //        AppTime.currentTimeMillis(), 1, "0.3"))));
        //rbc.localBus.post(new SendTMSMessageEvent(rbc.rbcID, rbc.tmsEndpointID, new Message_15("all", "rbc", new Payload_15(null, null, 0))));
    }

}
