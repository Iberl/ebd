package ebd.radioBlockCenter;

import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.logger.ToLogDebugEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.globalUtils.events.messageSender.SendETCSMessageEvent;
import ebd.globalUtils.events.radioBlockCenter.SendTMSMessageEvent;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.message.trackmessages.Message_24;
import ebd.messageLibrary.message.trainmessages.*;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.radioBlockCenter.util.Constants;
import ebd.rbc_tms.message.Message_10;
import ebd.rbc_tms.message.Message_11;
import ebd.rbc_tms.message.Message_14;
import ebd.rbc_tms.message.Message_15;
import ebd.rbc_tms.payload.Payload_10;
import ebd.rbc_tms.payload.Payload_11;
import ebd.rbc_tms.payload.Payload_14;
import ebd.rbc_tms.payload.Payload_15;
import ebd.rbc_tms.util.PositionInfo;
import ebd.rbc_tms.util.TrainInfo;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static ebd.radioBlockCenter.util.ETCSMessageAssembler.assembleMessage_24;
import static ebd.radioBlockCenter.util.ETCSPacketCreator.createPacket_57;
import static ebd.radioBlockCenter.util.ETCSPacketCreator.createPacket_58;
import static ebd.radioBlockCenter.util.TMSMessageCreator.createPositionInfo;

public class ETCSEndpoint {

    private EventBus _localBus;
    private final int _rbcID;
    private final String _rbcIDString;

    private final String _moduleID        = Constants.ID_ETCS_ENDPOINT;
    private final String _messageSenderID = Constants.ID_MESSAGE_SENDER;
    private final String _tmsEndpoint     = Constants.ID_TMS_ENDPOINT;

    private String               registeredTMS;
    private Map<Integer, String> trainIDMap;

    // Constructor

    public ETCSEndpoint(EventBus localBus, int rbcID, String registeredTMS, Map<Integer, String> trainIDMap) {
        this._localBus = localBus;
        this._rbcID = rbcID;
        this._rbcIDString = String.valueOf(rbcID);
        this.registeredTMS = registeredTMS;
        this.trainIDMap = trainIDMap;
        _localBus.register(this);
    }

    public int getNID_OPERATIONAL(int nid_engine) {
        String trainID = trainIDMap.get(nid_engine);
        if(trainID == null || trainID.isEmpty()) throw new IllegalArgumentException("Unknown NID_ENGINE value");

        return Integer.parseInt(trainID);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void receiveMessage(ReceivedMessageEvent event) {
        if(!Objects.equals(event.target, _moduleID)) return;
        if(!(event.message instanceof TrainMessage)) throw new IllegalArgumentException("The RBC is not able to receive trackside ETCS messages.");
        TrainMessage message = (TrainMessage) event.message;
        // TODO Trippy
        trainIDMap.put(message.NID_ENGINE, event.sender.replace("ms;T=", ""));

        // Handle Message
        try {
            Method method = this.getClass().getDeclaredMethod("handleMessage", message.getClass(), int.class);
            method.invoke(this, message, getNID_OPERATIONAL(message.NID_ENGINE));
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.err.println("The received message type is not supported.");
            e.printStackTrace();
        }
    }

    public void handleMessage(Message_132 message, int NID_OPERATIONAL) {
        // MA Request

        log("Received MA request from train " + NID_OPERATIONAL);

        // TODO Respond to Train?

        // TODO Forward to TMS
        TrainInfo    trainInfo    = new TrainInfo(message.NID_ENGINE, NID_OPERATIONAL, message.T_TRAIN);
        PositionInfo positionInfo = createPositionInfo(message.positionPacket);
        Payload_15   payload_15   = new Payload_15(trainInfo, positionInfo, message.Q_MARQSTREASON);
        _localBus.post(new SendTMSMessageEvent(_moduleID, _tmsEndpoint, new Message_15(registeredTMS, _rbcIDString, payload_15)));
    }

    public void handleMessage(Message_136 message, int NID_OPERATIONAL) {
        // Position Report

        // TODO Logging
        log("Received position report from train " + NID_OPERATIONAL);

        // TODO Respond to Train?

        // TODO Forward to TMS
        TrainInfo    trainInfo    = new TrainInfo(message.NID_ENGINE, NID_OPERATIONAL, message.T_TRAIN);
        PositionInfo positionInfo = createPositionInfo(message.positionPacket);
        Payload_14   payload_14   = new Payload_14(trainInfo, positionInfo);
        _localBus.post(new SendTMSMessageEvent(_moduleID, _tmsEndpoint, new Message_14(registeredTMS, _rbcIDString, payload_14)));
    }

    public void handleMessage(Message_146 message, int NID_OPERATIONAL) {
        // Acknowledgement

        log("Received knowledge from train " + NID_OPERATIONAL);

        // TODO Respond to Train?

        // TODO Forward to TMS?
    }

    public void handleMessage(Message_150 message, int NID_OPERATIONAL) {
        // End Of Mission

        log("Received Mission End message from train " + NID_OPERATIONAL);

        // TODO Respond to Train?

        // TODO Forward to TMS
        Payload_11 payload_11 = new Payload_11(new TrainInfo(message.NID_ENGINE, NID_OPERATIONAL, message.T_TRAIN));
        _localBus.post(new SendTMSMessageEvent(_moduleID, _tmsEndpoint, new Message_11(registeredTMS, _rbcIDString, payload_11)));
    }

    public void handleMessage(Message_155 message, int NID_OPERATIONAL) {
        // Initiation Of A Communication Session

        log("Received communication initiation from train " + NID_OPERATIONAL);

        // TODO Respond to Train
        List<TrackPacket> packets = new ArrayList<>();
        packets.add(createPacket_57(0));
        packets.add(createPacket_58());
        Message_24 message_24 = assembleMessage_24(false, 0, packets);

        _localBus.post(new SendETCSMessageEvent(_moduleID, _messageSenderID, message_24, "mr;T=" + NID_OPERATIONAL));
        log("Sending MA Request Parameters and Position Report Parameters");

        // TODO Forward to TMS
        Payload_10 payload_10 = new Payload_10(new TrainInfo(message.NID_ENGINE, NID_OPERATIONAL, message.T_TRAIN));
        _localBus.post(new SendTMSMessageEvent(_moduleID, _tmsEndpoint, new Message_10(registeredTMS, _rbcIDString, payload_10)));
    }

    private void log(String msg) {
        _localBus.post(new ToLogEvent(_moduleID, "log", msg));
    }

    private void log(Exception e) {
        _localBus.post(new ExceptionEvent(_moduleID, "log", new NotCausedByAEvent(), e));
    }

    private void logDebug(String msg) {
        _localBus.post(new ToLogDebugEvent(_moduleID, "log", msg));
    }

}
