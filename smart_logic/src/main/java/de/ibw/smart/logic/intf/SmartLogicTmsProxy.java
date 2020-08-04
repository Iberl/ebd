package de.ibw.smart.logic.intf;

import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.impl.SmartServer4TmsImpl;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.smart.logic.safety.SmartSafety;
import ebd.rbc_tms.Message;
import ebd.rbc_tms.Payload;
import ebd.rbc_tms.payload.Payload_00;
import ebd.rbc_tms.payload.Payload_14;
import ebd.rbc_tms.util.ETCSVariables;
import ebd.rbc_tms.util.TrainInfo;
import ebd.rbc_tms.util.exception.MissingInformationException;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SmartLogicTmsProxy implements TmsIntf {

    public static final String TMS_PROXY = "TMS-PROXY";
    private SmartServer server;
    private EventBusManager EM = null;

    /**
     * Priorty for priority queue sending to tms
     */
    private long lPriority = 3L;

    public SmartLogicTmsProxy() {
        try {
            this.EM = EventBusManager.registerOrGetBus(1, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setiPriority(long lPriority) {
        this.lPriority = lPriority;
    }

    public SmartLogicTmsProxy(SmartServer smartServer4Tms) {
        server = smartServer4Tms;
    }

    @Override
    public void setTmsServer(RbcModul TmsServer) {
        return;
    }

    @Override
    public Message handleMaRequest(Message<Payload> msgFromRbc) {
        return handleMessageAsProxy(msgFromRbc);
    }

    private Message handleMessageAsProxy(Message<Payload> msgFromRbc) {
        try {
            if(EM != null) {
                EM.log("TMS Output Queue has " + SmartLogic.outputQueue.size() + "Elements", TMS_PROXY);
                EM.log("SL Sends To TMS: " + msgFromRbc.parseToJson(), TMS_PROXY);

            }
            SmartLogic.outputQueue.offer(new SmartServerMessage(msgFromRbc.parseToJson(), this.lPriority));


            return getResponseMessage(0, msgFromRbc, null);
        } catch (MissingInformationException e) {
            if(EM != null) {
                EM.log("ERROR: JSON has missing information: " + msgFromRbc.toString(), TMS_PROXY);
            }
            return getResponseMessage(2, msgFromRbc, e);
        }
    }



    @Override
    public Message handleRegister(Message<Payload> msgFromRbc) {
        return handleMessageAsProxy(msgFromRbc);
    }

    @Override
    public Message handleLogin(Message<Payload> msgFromRbc) {
        return handleMessageAsProxy(msgFromRbc);
    }

    @Override
    public void handleNoError(Message<Payload> msgFromRbc) {

        Payload_00 P = (Payload_00) msgFromRbc.getPayload();
        handleAck(msgFromRbc.getHeader(), P);

        handleMessageAsProxy(msgFromRbc);
    }

    private void handleAck(Message.Header header, Payload_00 p) {
        UUID uuid = header.uuid;
        int iCode = p.errorCode;


            if(iCode == 0) {
                try {
                    SmartServer4TmsImpl.ackQueues.offer(uuid, true);
                    //SmartServer4TmsImpl.AckRepo.update(header.uuid,MaAckQueue);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

            } else {
                try {
                    SmartServer4TmsImpl.ackQueues.offer(uuid, false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

    }

    @Override
    public Message handlePositionReport(Message msgFromRbc) {
        boolean is4TMS;

        TrainInfo TI = null;
        is4TMS = SmartSafety.getSmartSafety().handlePositionReport(msgFromRbc);
        if(is4TMS) return handleMessageAsProxy(msgFromRbc); // sends also to tms

        // send not to tms but generate an error
        else {
            Payload_14 P_Pos = (Payload_14) msgFromRbc.getPayload();
            TI = P_Pos.trainInfo;
            return getResponseMessage(2, msgFromRbc,TI, new MissingInformationException("Position Report Invalid"));
        }
    }

    private Message getResponseMessage(int iErrorCode, Message msgFromRbc, TrainInfo TI, MissingInformationException e) {
        if(e != null) e.printStackTrace();
        String sRbc_id = null;
        UUID uuid = null;
        String sTms_id = null;
        try {
            sRbc_id = msgFromRbc.getHeader().rbc_id;
            uuid = msgFromRbc.getHeader().uuid;
            sTms_id = msgFromRbc.getHeader().tms_id;
        } catch(Exception E) {
            E.printStackTrace();
            throw E;

        }
        return RbcModul.createResponseMessage(iErrorCode, sRbc_id, uuid, sTms_id,TI);
    }
    private Message getResponseMessage(int iErrorCode, Message<Payload> msgFromRbc, MissingInformationException e) {
        if(e != null) e.printStackTrace();

        String sRbc_id = null;
        UUID uuid = null;
        String sTms_id = null;
        try {
            sRbc_id = msgFromRbc.getHeader().rbc_id;
            uuid = msgFromRbc.getHeader().uuid;
            sTms_id = msgFromRbc.getHeader().tms_id;
        } catch(Exception E) {
            E.printStackTrace();
            throw E;

        }
        return RbcModul.createResponseMessage(iErrorCode, sRbc_id, uuid, sTms_id, null);
    }
}
