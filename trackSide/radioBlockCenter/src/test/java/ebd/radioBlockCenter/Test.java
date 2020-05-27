package ebd.radioBlockCenter;

import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.events.radioBlockCenter.SendTMSMessageEvent;
import ebd.rbc_tms.message.Message_01;
import ebd.rbc_tms.message.Message_14;
import ebd.rbc_tms.message.Message_15;
import ebd.rbc_tms.payload.Payload_01;
import ebd.rbc_tms.payload.Payload_14;
import ebd.rbc_tms.payload.Payload_15;
import static ebd.messageLibrary.util.ETCSVariables.*;
import ebd.rbc_tms.util.PositionInfo;
import ebd.rbc_tms.util.TrainInfo;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        RadioBlockCenter rbc = new RadioBlockCenter();
        rbc.localBus.post(new SendTMSMessageEvent(rbc.rbcID, rbc.tmsEndpointID, new Message_01("all", "rbc", new Payload_01(
                AppTime.currentTimeMillis(), 1, "0.3"))));
        rbc.localBus.post(new SendTMSMessageEvent(rbc.rbcID, rbc.tmsEndpointID, new Message_14("all", "rbc", new Payload_14(new TrainInfo(12, 12, AppTime.currentTimeMillis()), new PositionInfo(
                Q_SCALE_1M, 1, NID_PRVLRBG_UNKNOWN, 10, Q_DIRLRBG_NOMINAL, Q_DLRBG_NOMINAL, 0, 0, Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE, 110, 10, Q_DIRTRAIN_NOMINAL, M_MODE_FULL_SUPERVISION, M_LEVEL_3, 0)))));
        //rbc.localBus.post(new SendTMSMessageEvent(rbc.rbcID, rbc.tmsEndpointID, new Message_15("all", "rbc", new Payload_15(null, null, 0))));
    }

}
