package de.ibw.smart.logic.intf;

import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.impl.SmartServer4TmsImpl;
import de.ibw.smart.logic.intf.messages.Converter;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.smart.logic.safety.SafetyLogic;
import de.ibw.tms.train.model.TrainModel;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.util.exception.FieldTypeNotSupportedException;
import ebd.messageLibrary.util.exception.NotSerializableException;
import ebd.rbc_tms.Serializer;
import ebd.rbc_tms.message.Message;
import ebd.internal.Payload;
import ebd.internal.payload.Payload_00;
import ebd.internal.payload.Payload_14;
import ebd.internal.util.TrainInfo;
import ebd.internal.util.exception.MissingInformationException;
import ebd.rbc_tms.message.general.Response;
import ebd.rbc_tms.message.rbc.ETCSTrainMessage;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * Die Smart Logic simuliert das TMS als Proxy. Diese Komponente stellt den Proxy auf ein TMS innerhalb der SL dar.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1
 * @since 2020-05-26
 */
public class SmartLogicTmsProxy implements TmsIntf {

    /**
     * Die Komponentenbezeichnung im Logging
     */
    public static final String TMS_PROXY = "TMS-PROXY";

    private SmartServer server;
    private EventBusManager EM = null;

    /**
     * Priorty for priority queue sending to tms
     */
    private long lPriority = 3L;


    /**
     * Setzen der Priority von Nachrichten des Proxies an das TMS
     * @param lPriority long - Priority
     */
    public void setiPriority(long lPriority) {
        this.lPriority = lPriority;
    }

    /**
     * Konstruktor der den Proxy instanziiert.
     * @param smartServer4Tms - die ServerInstanz in der SmartLogic die den Proxy benutzt
     */
    public SmartLogicTmsProxy(SmartServer smartServer4Tms) {
        server = smartServer4Tms;
    }

    /**
     * Wird nicht ver&auml;ndert der Proxy kann zur Laufzeit nicht die Komponente wechseln.
     * Der TMSServer erh&auml;lt Nachrichten vom RBC
     * @param TmsServer RBCModul -
     */

    @Override
    public void setTmsServer(RbcModul TmsServer) {
        return;
    }

    /**
     * verwaltet was der Proxy unternimmt wenn eine Ma-Request vom RBC eintrifft.
     * Biser wird die Nachricht an das TMs weitergeleitet.
     * @param msgFromRbc Message - Nachricht des RBC
     * @return Message - Standard Acknowledgment wird an des RBC als Antwort gesendet
     */

    @Override
    public Message handleMaRequest(Message msgFromRbc) {
        return handleMessageAsProxy(msgFromRbc);
    }

    private Message handleMessageAsProxy(Message msgFromRbc) {



        try {
        String strMessage = Serializer.serialize(msgFromRbc);
        System.out.println("Message to TMS: " + strMessage);
            if(EM != null) {
                EM.log("TMS Output Queue has " + SmartLogic.outputQueue.size() + "Elements", TMS_PROXY);

                EM.log("SL Sends To TMS: " + strMessage, TMS_PROXY);
            }
            try {
                SmartLogic.outputQueue.put(new SmartServerMessage(strMessage, this.lPriority));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return getResponseMessage(0, msgFromRbc, null);
        } catch (NotSerializableException | FieldTypeNotSupportedException | ebd.messageLibrary.util.exception.MissingInformationException e) {
            e.printStackTrace();
        }
        return null;


    }

    /**
     * verwaltet was der Proxy unternimmt wenn eine Registrierung vom RBC eintrifft.
     * Bisher wird die Nachricht an das TMS weitergeleitet.
     * @param msgFromRbc Message - Nachricht des RBC
     * @return Message - Standard Acknowledgment wird an des RBC als Antwort gesendet
     */

    @Override
    public Message handleRegister(Message msgFromRbc) {
        return handleMessageAsProxy(msgFromRbc);
    }

    /**
     * verwaltet was der Proxy unternimmt wenn eine Anmeldung vom RBC eintrifft.
     * Bisher wird die Nachricht an das TMS weitergeleitet.
     * @param msgFromRbc Message - Nachricht des RBC
     * @return Message - Standard Acknowledgment wird an des RBC als Antwort gesendet
     */

    @Override
    public Message handleLogin(Message msgFromRbc) {
        return handleMessageAsProxy(msgFromRbc);
    }

    /**
     * Verwaltet was der Proxy unternimmt, wenn eine Nachricht vom RBC eintrifft, die anzeigt, das das RBC eine Anfrage
     * ohne Fehler entgegengenommen hat.
     * Es wird dabei die SmartLogic das Ack verwalten und dann an das TMS weiterleiten
     * @param msgFromRbc Message - Nachricht des RBC
     */
    @Override
    public void handleNoError(Message msgFromRbc) {


        handleAck(msgFromRbc);

        handleMessageAsProxy(msgFromRbc);
    }


    private void handleAck(Message mRbc) {
        UUID uuid = mRbc.uuid;

        // type prüfen

        Response rRbc = (Response) mRbc;
        int iCode = rRbc.errorCode;


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

    /**
     * verwaltet was der Proxy unternimmt wenn eine PositionReport vom RBC eintrifft.
     * Der Position Report wird vom SmartLogic Server mituntersucht
     * @param msgFromRbc Message - Nachricht des RBC
     * @return Message - Acknowledgment wird an des RBC als Antwort gesendet - kann auch einen Fehler senden
     */

    @Override
    public Message handlePositionReport(Message msgFromRbc) {
        boolean is4TMS;
        int nidTrain = -1;
        TrainInfo TI = null;
        PositionPacket PosPacket = null;
        ETCSTrainMessage P_PosWithinTrainMessage = (ETCSTrainMessage) msgFromRbc;
        nidTrain = P_PosWithinTrainMessage.nid_engine;
        ebd.messageLibrary.message.Message LibMessage = P_PosWithinTrainMessage.etcsMessage;
        try {
           PosPacket = Converter.retrievePosPacket(LibMessage);
            is4TMS = SafetyLogic.getSmartSafety().handlePositionReport(nidTrain, PosPacket, msgFromRbc);
            if(is4TMS) return handleMessageAsProxy(msgFromRbc);// sends also to tms
            else {
                TI = new TrainInfo(nidTrain, nidTrain, msgFromRbc.timestamp);
                return getResponseMessage(-1, msgFromRbc,TI, new MissingInformationException("Position Report Invalid"));
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();

        }
        TI = new TrainInfo(nidTrain, nidTrain, msgFromRbc.timestamp);
        return getResponseMessage(-1, msgFromRbc,TI, new MissingInformationException("Position Report Invalid"));




        // send not to tms but generate an error

    }



    private Message getResponseMessage(int iErrorCode, Message msgFromRbc, TrainInfo TI, MissingInformationException e) {
        if(e != null) e.printStackTrace();
        String sRbc_id = null;
        UUID uuid = null;
        String sTms_id = null;
        try {
            sRbc_id = String.valueOf(msgFromRbc.rbc_id);
            uuid = msgFromRbc.uuid;
            sTms_id = String.valueOf(msgFromRbc.tms_id);
        } catch(Exception E) {
            E.printStackTrace();
            throw E;

        }
        return RbcModul.createResponseMessage(iErrorCode, sRbc_id, uuid, sTms_id,TI);
    }
    private Message getResponseMessage(int iErrorCode, Message msgFromRbc, MissingInformationException e) {
        if(e != null) e.printStackTrace();

        String sRbc_id = null;
        UUID uuid = null;
        String sTms_id = null;
        try {
            sRbc_id = String.valueOf(msgFromRbc.rbc_id);
            uuid = msgFromRbc.uuid;
            sTms_id = String.valueOf(msgFromRbc.tms_id);
        } catch(Exception E) {
            E.printStackTrace();
            //throw E;

        }
        return RbcModul.createResponseMessage(iErrorCode, sRbc_id, uuid, sTms_id, null);
    }
}
