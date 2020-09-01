package de.ibw.smart.logic.intf;

import org.junit.jupiter.api.Test;

class SmartLogicTest {



    @Test
    void sendMessageToTms() {
        //SmartLogic.createTestSend(false,false, true, 0, bStartTms);



        /*
        TmsIntf TestTms = new RbcModul.TestTms();
        TmsServer.setTmsHandler(TestTms);
        TestTms.setTmsServer(TmsServer);

        TmsServer.start();
        TmsClient.start();
        TrainInfo Info = new TrainInfo(0, 0, 0L);
        PositionInfo PosInfo = new PositionInfo(0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0);
        Payload_15 MaRequestLoad = new Payload_15(Info,PosInfo, 0);
        Message_15 RbcMaRequest = new Message_15(UUID.randomUUID(),"TMS_A1", "RBC_1", MaRequestLoad );
        RbcModul RbcClient = new RbcModul(RbcMaRequest, null, 22223);
        //if(b4Show)RbcClient.start();
        */
    }
}