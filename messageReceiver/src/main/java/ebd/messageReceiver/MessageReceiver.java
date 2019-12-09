package ebd.messageReceiver;

import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedTelegramEvent;
import ebd.globalUtils.events.SerializedBitstreamEvent;
import ebd.globalUtils.events.messageReceiver.MessageReceiverExceptionEvent;
import ebd.messageLibrary.message.Message;
import ebd.messageLibrary.message.Telegram;
import ebd.messageLibrary.serialization.BitStreamReader;
import ebd.messageLibrary.serialization.Serializer;
import ebd.messageLibrary.util.exception.BitLengthOutOfBoundsException;
import ebd.messageLibrary.util.exception.ClassNotSupportedException;
import ebd.messageLibrary.util.exception.MissingInformationException;
import ebd.messageLibrary.util.exception.ValueNotSupportedException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Arrays;

/**
 * Class for receiving messages from RBC
 *
 * @version 2.0
 * @author Christopher Bernjus
 */
public class MessageReceiver {

	// ----------------
	// Message Receiver
	// ----------------

	protected EventBus globalBus = EventBus.getDefault();
	protected EventBus localBus;

	/** ID of this message receiver module */
	private String mrID = "mr";
	/** ID of the local entity (train|rbc) */
	public String localID;
	/** ID of the module to send received messages to (default "all") */
	public String managerID = "all";
	/** Indicates the direction of Communication */
	public boolean traintoTrack = false;


	// Constructor

	/**
	 * Constructs an MessageReceiver Module
	 *
	 * @param localBus
	 *          The EventBus for in-train communication
	 * @param localID
	 *          ID of the local entity (train|rbc)
	 * @param managerID
	 * 			ID of the module to send received messages to (default "all")
	 * @param trainToTrack
	 * 			Indicates the direction of communication
	 *
	 * @author Christopher Bernjus
	 */
	public MessageReceiver(EventBus localBus, String localID, String managerID, boolean trainToTrack) {
		this.localBus = localBus;
		this.localID = localID;
		this.managerID = managerID;
		this.traintoTrack = trainToTrack;

		this.globalBus.register(this);
	}


	// Methods

	/**
	 * Receives an Message or Telegram and sends it to the local Bus
	 *
	 * @param event
	 *          Received {@link SerializedBitstreamEvent} over the globalBus
	 */
	@Subscribe(threadMode = ThreadMode.ASYNC)
	public void receive(SerializedBitstreamEvent event) {
		if(!event.targets.contains(mrID + (traintoTrack ? ";R=" : ";T=") + localID) && !event.targets.contains("all")) return;

		try {
			BitStreamReader bitstream = event.bitstream;

			if(event.isTelegram) {
				Telegram telegram = Serializer.deserializeTelegram(bitstream);

				localBus.post(new ReceivedTelegramEvent(mrID, Arrays.asList(managerID), telegram, event.source));
			} else {
				Message message = Serializer.deserializeMessage(bitstream, event.trainToTrack);

				localBus.post(new ReceivedMessageEvent(mrID, Arrays.asList(managerID), message, event.source));
			}

		} catch(ClassNotSupportedException e) {
			globalBus.post(new MessageReceiverExceptionEvent(event.source, Arrays.asList(managerID), event, e));

		} catch(MissingInformationException e) {
			globalBus.post(new MessageReceiverExceptionEvent(event.source, Arrays.asList(managerID), event, e));

		} catch(BitLengthOutOfBoundsException e) {
			globalBus.post(new MessageReceiverExceptionEvent(event.source, Arrays.asList(managerID), event, e));

		} catch(ValueNotSupportedException e) {
			globalBus.post(new MessageReceiverExceptionEvent(event.source, Arrays.asList(managerID), event, e));

		}
	}

	public void unregister() {
		globalBus.unregister(this);
	}

}
