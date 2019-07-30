package ebd.messageSender;

import ebd.globalUtils.events.messageLibrary.MessageEvent;
import ebd.globalUtils.events.messageSender.MessageSenderExceptionEvent;
import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.serialization.Serializer;
import ebd.messageLibrary.util.exception.FieldTypeNotSupportedException;
import ebd.messageLibrary.util.exception.MissingInformationException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Arrays;

/**
 * Class for sending messages from Train to RBC
 *
 * @author Christopher Bernjus
 */
public class MessageSender {

	// --------------
	// Message Sender
	// --------------

	protected EventBus globalBus = EventBus.getDefault();
	protected EventBus localBus;

	/** ID of the train */
	public String trainID;
	/** ID of the RBC to communicate with */
	public String rbcID;
	/** ID of this message sender module */
	public String messageSenderID;


	// Constructor

	/**
	 * Constructs an MessageSender Module
	 *
	 * @param localBus
	 *          The EventBus for in-train communication
	 * @param trainID
	 *          ID of the train
	 * @param rbcID
	 *          ID of the RBC to communicate with
	 * @param msID
	 *          ID of the new message sender module
	 */
	public MessageSender(EventBus localBus, String trainID, String rbcID, String msID) {
		this.localBus = localBus;
		this.trainID = trainID;
		this.rbcID = rbcID;
		this.messageSenderID = msID;

		this.localBus.register(this);
	}


	// Methods

	/**
	 * Sends Messages to the RBC over the global EventBus
	 *
	 * @param event
	 *          Received {@link MessageEvent} over the localBus
	 */
	@Subscribe
	public void send(MessageEvent event) {
		if(!event.targets.contains(messageSenderID)) return;

		try {
			TrainMessage message = (TrainMessage) event.content;
			byte[] serializedMessage = Serializer.serialize(message).data();

			globalBus.post(new MessageEvent(trainID, Arrays.asList(rbcID), serializedMessage));

		} catch(FieldTypeNotSupportedException e) {
			localBus.post(new MessageSenderExceptionEvent(messageSenderID, event.targets, event, e));

		} catch(MissingInformationException e) {
			localBus.post(new MessageSenderExceptionEvent(messageSenderID, event.targets, event, e));
		}
	}

	public void unregister() {
		localBus.unregister(this);
	}

}
