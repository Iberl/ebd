package ebd.messageSender;

import ebd.globalUtils.events.messageSender.SendETCSMessageEvent;
import ebd.globalUtils.events.messageSender.SendTelegramEvent;
import ebd.globalUtils.events.SerializedBitstreamEvent;
import ebd.globalUtils.events.messageSender.MessageSenderExceptionEvent;
import ebd.messageLibrary.serialization.BitStreamReader;
import ebd.messageLibrary.serialization.BitStreamWriter;
import ebd.messageLibrary.serialization.Serializer;
import ebd.messageLibrary.util.exception.ClassMalformedException;
import ebd.messageLibrary.util.exception.FieldTypeNotSupportedException;
import ebd.messageLibrary.util.exception.MissingInformationException;
import ebd.messageLibrary.util.exception.NotSerializableException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Class for sending messages from Train to RBC
 *
 * @version 2.0
 * @author Christopher Bernjus
 */
public class MessageSender {

	// --------------
	// Message Sender
	// --------------

	protected EventBus globalBus = EventBus.getDefault();
	protected EventBus localBus;

	/** ID of this message sender module */
	private String msID = "ms";
	/** ID of the local entity (train|rbc) */
	public String localID;
	/** Indicates the direction of communication */
	public boolean trainToTrack;


	// Constructor

	/**
	 * Constructs an MessageSender Module
	 *
	 * @param localBus
	 *          The EventBus for in-train communication
	 * @param localID
	 * 			ID of the local entity (train|rbc)
	 * @param trainToTrack
	 * 			Indicates the direction of communication
	 */
	public MessageSender(EventBus localBus, String localID, boolean trainToTrack) {
		this.localBus = localBus;
		this.localID = localID;
		this.trainToTrack = trainToTrack;

		this.localBus.register(this);
	}


	// Methods

	/**
	 * Sends Messages to the RBC over the global EventBus
	 *
	 * @param event
	 *          Received {@link SendETCSMessageEvent} over the localBus
	 */
	@Subscribe(threadMode = ThreadMode.ASYNC)
	public void send(SendETCSMessageEvent event) {
		if(!event.target.contains(msID)) return;

		try {
			BitStreamWriter writer = Serializer.serialize(event.message);
			BitStreamReader bitstream = new BitStreamReader(writer.data(), writer.size());

			//System.out.println("Message wird gesendet: " + event.message.NID_MESSAGE + " to " + event.destination);
			globalBus.post(new SerializedBitstreamEvent(msID + (trainToTrack ? ";T=" : ";R=") + localID, event.destination, bitstream, trainToTrack, false));

		} catch(FieldTypeNotSupportedException e) {
			localBus.post(new MessageSenderExceptionEvent(msID, event.target, event, e));

		} catch(MissingInformationException e) {
			localBus.post(new MessageSenderExceptionEvent(msID, event.target, event, e));
		} catch(NotSerializableException e) {
			e.printStackTrace();
		} catch(ClassMalformedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sends Telegrams to a Train over the global EventBus
	 *
	 * @param event
	 *          Received {@link SendTelegramEvent} over the localBus
	 */
	@Subscribe(threadMode = ThreadMode.ASYNC)
	public void send(SendTelegramEvent event) {
		if(!event.target.contains(msID)) return;

		try {
			BitStreamWriter writer = Serializer.serialize(event.telegram);
			BitStreamReader bitstream = new BitStreamReader(writer.data(), writer.size());

			globalBus.post(new SerializedBitstreamEvent(msID + ';' + localID, event.destination, bitstream, trainToTrack, true));

		} catch(FieldTypeNotSupportedException e) {
			localBus.post(new MessageSenderExceptionEvent(msID, event.target, event, e));

		} catch(MissingInformationException e) {
			localBus.post(new MessageSenderExceptionEvent(msID, event.target, event, e));
		} catch(NotSerializableException e) {
			e.printStackTrace();
		} catch(ClassMalformedException e) {
			e.printStackTrace();
		}
	}

	public void unregister() {
		localBus.unregister(this);
	}

}
