package ebd.messageReceiver;

import ebd.globalUtils.events.messageLibrary.MessageEvent;
import ebd.globalUtils.events.messageReceiver.MessageReceiverExceptionEvent;
import ebd.messageLibrary.message.Message;
import ebd.messageLibrary.serialization.BitStreamReader;
import ebd.messageLibrary.serialization.Serializer;
import ebd.messageLibrary.util.exception.BitLengthOutOfBoundsException;
import ebd.messageLibrary.util.exception.ClassNotSupportedException;
import ebd.messageLibrary.util.exception.MissingInformationException;
import ebd.messageLibrary.util.exception.ValueNotSupportedException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Arrays;

/**
 * Class for receiving messages from RBC
 *
 * @author Christopher Bernjus
 */
public class MessageReceiver {

	// ----------------
	// Message Receiver
	// ----------------

	protected EventBus globalBus = EventBus.getDefault();
	protected EventBus localBus;

	/** ID of the train */
	public String trainID;
	/** ID of this message receiver module */
	public String messageReceiverID;


	// Constructor

	/**
	 * Constructs an MessageSender Module
	 *
	 * @param localBus
	 *          The EventBus for in-train communication
	 * @param trainID
	 *          ID of the train
	 * @param mrID
	 *          ID of the new message receiver module
	 */
	public MessageReceiver(EventBus localBus, String trainID, String mrID) {
		this.localBus = localBus;
		this.trainID = trainID;
		this.messageReceiverID = mrID;

		this.globalBus.register(this);
	}


	// Methods

	/**
	 * Receives an Message and sends it to the local Bus
	 *
	 * @param event
	 *          Received {@link MessageEvent} over the globalBus
	 */
	@Subscribe
	public void receive(MessageEvent event) {
		if(!event.targets.contains(trainID)) return;

		try {
			byte[] bits = (byte[]) event.content;
			Message message = Serializer.deserialize(new BitStreamReader(bits, bits.length), false);

			localBus.post(message);

		} catch(ClassNotSupportedException e) {
			globalBus.post(new MessageReceiverExceptionEvent(event.source, Arrays.asList(messageReceiverID), event, e));

		} catch(MissingInformationException e) {
			globalBus.post(new MessageReceiverExceptionEvent(event.source, Arrays.asList(messageReceiverID), event, e));

		} catch(BitLengthOutOfBoundsException e) {
			globalBus.post(new MessageReceiverExceptionEvent(event.source, Arrays.asList(messageReceiverID), event, e));

		} catch(ValueNotSupportedException e) {
			globalBus.post(new MessageReceiverExceptionEvent(event.source, Arrays.asList(messageReceiverID), event, e));

		}

	}

	public void unregister() {
		globalBus.unregister(this);
	}

}
