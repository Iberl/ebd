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
/**
 * Die Smart Logic simuliert das TMS als Proxy. Diese Komponente stellt den Proxy auf ein TMS innerhalb der SL dar.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
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

    /**
     * verwaltet was der Proxy unternimmt wenn eine Registrierung vom RBC eintrifft.
     * Bisher wird die Nachricht an das TMS weitergeleitet.
     * @param msgFromRbc Message - Nachricht des RBC
     * @return Message - Standard Acknowledgment wird an des RBC als Antwort gesendet
     */

    @Override
    public Message handleRegister(Message<Payload> msgFromRbc) {
        return handleMessageAsProxy(msgFromRbc);
    }

    /**
     * verwaltet was der Proxy unternimmt wenn eine Anmeldung vom RBC eintrifft.
     * Bisher wird die Nachricht an das TMS weitergeleitet.
     * @param msgFromRbc Message - Nachricht des RBC
     * @return Message - Standard Acknowledgment wird an des RBC als Antwort gesendet
     */

    @Override
    public Message handleLogin(Message<Payload> msgFromRbc) {
        return handleMessageAsProxy(msgFromRbc);
    }

    /**
     * Verwaltet was der Proxy unternimmt, wenn eine Nachricht vom RBC eintrifft, die anzeigt, das das RBC eine Anfrage
     * ohne Fehler entgegengenommen hat.
     * Es wird dabei die SmartLogic das Ack verwalten und dann an das TMS weiterleiten
     * @param msgFromRbc Message - Nachricht des RBC
     */

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

    /**
     * verwaltet was der Proxy unternimmt wenn eine PositionReport vom RBC eintrifft.
     * Der Position Report wird vom SmartLogic Server mituntersucht
     * @param msgFromRbc Message - Nachricht des RBC
     * @return Message - Acknowledgment wird an des RBC als Antwort gesendet - kann auch einen Fehler senden
     */

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
