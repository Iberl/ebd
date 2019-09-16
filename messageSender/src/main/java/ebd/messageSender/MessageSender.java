package ebd.messageSender;

import ebd.globalUtils.events.messageSender.SendMessageEvent;
import ebd.globalUtils.events.messageSender.SendTelegramEvent;
import ebd.globalUtils.events.SerializedBitstreamEvent;
import ebd.globalUtils.events.messageSender.MessageSenderExceptionEvent;
import ebd.messageLibrary.serialization.Serializer;
import ebd.messageLibrary.util.exception.FieldTypeNotSupportedException;
import ebd.messageLibrary.util.exception.MissingInformationException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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
	 *          Received {@link SendMessageEvent} over the localBus
	 */
	@Subscribe
	public void send(SendMessageEvent event) {
		if(!event.targets.contains(msID)) return;

		try {
			byte[] bitstream = Serializer.serialize(event.message).data();

			globalBus.post(new SerializedBitstreamEvent(msID + ';' + localID, event.destinations, bitstream, trainToTrack, false));

		} catch(FieldTypeNotSupportedException e) {
			localBus.post(new MessageSenderExceptionEvent(msID, event.targets, event, e));

		} catch(MissingInformationException e) {
			localBus.post(new MessageSenderExceptionEvent(msID, event.targets, event, e));
		}
	}

	/**
	 * Sends Telegrams to a Train over the global EventBus
	 *
	 * @param event
	 *          Received {@link SendTelegramEvent} over the localBus
	 */
	@Subscribe
	public void send(SendTelegramEvent event) {
		if(!event.targets.contains(msID)) return;

		try {
			byte[] bitstream = Serializer.serialize(event.telegram).data();

			globalBus.post(new SerializedBitstreamEvent(msID + ';' + localID, event.destinations, bitstream, trainToTrack, true));

		} catch(FieldTypeNotSupportedException e) {
			localBus.post(new MessageSenderExceptionEvent(msID, event.targets, event, e));

		} catch(MissingInformationException e) {
			localBus.post(new MessageSenderExceptionEvent(msID, event.targets, event, e));
		}
	}

	public void unregister() {
		localBus.unregister(this);
	}

}
