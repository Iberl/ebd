package ebd.radioBlockCenter;

import ebd.globalUtils.events.messageSender.SendETCSMessageEvent;
import ebd.globalUtils.events.radioBlockCenter.ReceivedTMSMessageEvent;
import ebd.globalUtils.events.radioBlockCenter.SendTMSMessageEvent;
import ebd.globalUtils.events.radioBlockCenter.SendTMSResponseEvent;
import ebd.messageLibrary.message.TrackMessage;
import ebd.radioBlockCenter.util.Constants;
import ebd.radioBlockCenter.util.Conversation;
import ebd.rbc_tms.Message;
import ebd.rbc_tms.message.*;
import ebd.rbc_tms.payload.Payload_00;
import ebd.rbc_tms.payload.Payload_21;
import ebd.rbc_tms.util.MA;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static ebd.radioBlockCenter.util.ETCSMessageAssembler.assembleMessage_3;
import static ebd.radioBlockCenter.util.ETCSMessageAssembler.assembleMessage_33;

public class TMSEndpoint {

    private final EventBus _localBus;

    private final int    _rbcID;
    private final String _rbcIDString;
    private final String _moduleID          = Constants.ID_TMS_ENDPOINT;
    private final String _tmsCommunicatorID = Constants.ID_TMS_COMMUNICATOR;
    private final String _messageSenderID   = Constants.ID_MESSAGE_SENDER;

    private String registeredTMS;

    private Map<UUID, Conversation> conversations = new HashMap<>();

    private Map<Integer, String> trainIDMap;


    // Constructor

    public TMSEndpoint(EventBus localBus, int rbcID, String registeredTMS, Map<Integer, String> trainIDMap) {
        this._localBus = localBus;
        this._rbcID = rbcID;
        this._rbcIDString = String.valueOf(rbcID);
        this.registeredTMS = registeredTMS;
        this.trainIDMap = trainIDMap;
        _localBus.register(this);
    }


    // Functions

    public void extendConversation(@NotNull Message message) {
        Message.Header header = message.getHeader();
        UUID           uuid   = header.uuid;
        Conversation   conversation;
		if(conversations.containsKey(uuid)) {
			conversation = conversations.get(uuid);
			conversation.extend(message);
		} else { conversation = new Conversation(message); }
        conversations.put(uuid, conversation);
    }

    public void closeConversation(UUID uuid) {
        if(conversations.containsKey(uuid)) {
            Conversation conversation;
            conversation = conversations.get(uuid);
            conversation.close();
            conversations.put(uuid, conversation);
        }
    }

    public boolean areAllConversationsClosed() {
        return conversations.values().stream().anyMatch(conversation -> !conversation.isClosed());
    }

    private void sendResponse(UUID uuid, int errorCode) {
        sendResponse(registeredTMS, uuid, errorCode);
    }

    private void sendResponse(String tmsID, UUID uuid, int errorCode) {
        Payload_00 payload_00 = new Payload_00(errorCode, null);
        Message_00 message_00 = new Message_00(uuid, tmsID, _rbcIDString, payload_00);

        extendConversation(message_00);
        _localBus.post(new SendTMSResponseEvent(_moduleID, "tmsCommunicator", message_00));
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void sendMessage(SendTMSMessageEvent event) {
        if(!Objects.equals(event.target, _moduleID)) return;

        extendConversation(event.message);
        _localBus.post(new SendTMSMessageEvent(_moduleID, _tmsCommunicatorID, event.message));
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void receiveMessage(ReceivedTMSMessageEvent event) {
        if(!Objects.equals(event.target, _moduleID)) return;

        Message message = event.message;

        extendConversation(message);
        Message.Header header = message.getHeader();

        // Check whether TMS is registered
        if(!Objects.equals(header.tms_id, registeredTMS)) {
            sendResponse(header.tms_id, header.uuid, 1);
            closeConversation(header.uuid);
        }

        // Check whether MessageType is accepted
        int messageType = header.type;
        if(messageType >= 10 && messageType < 20) {
            // TODO cant throw => post exception event
            sendResponse(header.uuid, 2);
            throw new IllegalArgumentException("Received Invalid Message Type");
        }

        // Handle Message
        try {
            Method method = this.getClass().getDeclaredMethod("handleMessage", message.getClass());
            method.invoke(this, message);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.err.println("The received message type is not supported.");
            e.printStackTrace();
        }
    }

    /**
     * Handles Incoming {@link Message_00}s
     *
     * @param message
     *         Received {@link Message_00}
     *
     * @author Christopher Bernjus
     */
    public void handleMessage(Message_00 message) {
        // "Error" Messages
        // TODO Handle Response
        Conversation conversation = conversations.get(message.getHeader().uuid);
        int          type         = message.getHeader().type;
        switch(type) {
            case 0: {
                // Accepted
                // TODO Differentiations needed?
                conversation.close();
            }
        }
    }

    /**
     * Handles Incoming {@link Message_01}s
     *
     * @param message
     *         Received {@link Message_01}
     *
     * @author Christopher Bernjus
     */
    public void handleMessage(@NotNull Message_01 message) {
        // "Register" Messages
        Message.Header header = message.getHeader();

        if(Objects.equals(registeredTMS, "") || Objects.equals(registeredTMS, header.tms_id)) {
            registeredTMS = header.tms_id;
            sendResponse(header.uuid, 0);
        } else {
            sendResponse(header.uuid, 1);
        }
    }

    /**
     * Handles Incoming {@link Message_02}s
     *
     * @param message
     *         Received {@link Message_02}
     *
     * @author Christopher Bernjus
     */
    public void handleMessage(@NotNull Message_02 message) {
        // "Unregister" Messages
        Message.Header header = message.getHeader();

        if(Objects.equals(registeredTMS, header.tms_id) && areAllConversationsClosed()) {
            registeredTMS = "";
            sendResponse(header.tms_id, header.uuid, 0);
            conversations.clear();
        } else {
            sendResponse(header.tms_id, header.uuid, 1);
        }
    }

	/**
	 * Handles Incoming {@link Message_20}s
	 *
	 * @param message Received {@link Message_20}
	 *
	 * @author Christopher Bernjus
	 */
	public void handleMessage(@NotNull Message_20 message) {
		// "Position Report Request" Messages
		// TODO Handle PositionReportRequest
		throw new UnsupportedOperationException();
	}

    /**
     * Handles Incoming {@link Message_21}s
     *
     * @param message
     *         Received {@link Message_21}
     *
     * @author Christopher Bernjus
     */
    public void handleMessage(@NotNull Message_21 message) {
        // "MA" Messages
        Payload_21 payload = message.getPayload();
        MA         ma      = payload.ma;

        TrackMessage etcsMessage;
        if(ma.d_ref == null) {
            etcsMessage = assembleMessage_3(ma.m_ack, ma.nid_lrbg, ma.q_dir, ma.q_scale, ma.eoa, ma.speedProfile, ma.gradientProfile,
                                            ma.linkingProfile, ma.modeProfile);
        } else {
            etcsMessage = assembleMessage_33(ma.m_ack, ma.nid_lrbg, ma.q_dir, ma.q_scale, ma.d_ref, ma.eoa, ma.speedProfile, ma.gradientProfile,
                                             ma.linkingProfile, ma.modeProfile);
        }
        System.out.println("ETCSMessage: " + etcsMessage.toString());
        System.out.println("WHAT? " + trainIDMap.get(payload.nid_engine));
		_localBus.post(new SendETCSMessageEvent(_moduleID, _messageSenderID, etcsMessage, "mr;T=" + trainIDMap.get(payload.nid_engine)));
	}

    /**
     * Handles Incoming {@link Message_22}s
     *
     * @param message
     *         Received {@link Message_22}
     *
     * @author Christopher Bernjus
     */
    public void handleMessage(@NotNull Message_22 message) {
        // "Request To Shorten MA" Messages
        // TODO Handle Request to Shorten MA
        throw new UnsupportedOperationException();
    }

    /**
     * Handles Incoming {@link Message_23}s
     *
     * @param message
     *         Received {@link Message_23}
     *
     * @author Christopher Bernjus
     */
    public void handleMessage(@NotNull Message_23 message) {
        // "Conditional Emergency Stop" Messages
        // TODO Handle Conditional EM Stop
        throw new UnsupportedOperationException();
    }

    /**
     * Handles Incoming {@link Message_24}s
     *
     * @param message
     *         Received {@link Message_24}
     *
     * @author Christopher Bernjus
     */
    public void handleMessage(@NotNull Message_24 message) {
        // "Unconditional Emergency Stop" Messages
        // TODO Handle Unconditional EM Stop
        throw new UnsupportedOperationException();
    }

    /**
     * Handles Incoming {@link Message_25}s
     *
     * @param message
     *         Received {@link Message_25}
     *
     * @author Christopher Bernjus
     */
    public void handleMessage(@NotNull Message_25 message) {
        // "Revocation Of Emergency Stop" Messages
        // TODO Handle Revocation of EM Stop
        throw new UnsupportedOperationException();
    }

}
