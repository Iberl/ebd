package ebd.globalUtils.events;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

/**
 * Event containing the serialized information of an Message send over the global Eventbus
 *
 * @author Christopher Bernjus
 */
public class SerializedBitstreamEvent extends NormalEvent {

	/** The bitstream transferred by the event */
	public byte[] bitstream;
	/** Indicates the direction of the communication */
	public boolean trainToTrack;
	/** Indicates wether the transferred bitstream resembles a Telegram or a Message */
	public boolean isTelegram;

	/**
	 * Constructs an SerializedBitstreamEvent
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param targets
	 *          ID from all modules the event is adressed to
	 * @param bitstream
	 *          The transferred bitstream which holds the serialized Message
	 * @param trainToTrack
	 * 			Indicates the direction of the communication
	 * @param isTelegram
	 * 			Indicates wether the transferred bitstream resembles a Telegram or a Message
	 */
	public SerializedBitstreamEvent(String source, List<String> targets, byte[] bitstream, boolean trainToTrack, boolean isTelegram) {
		super(source, targets);
		this.bitstream = bitstream;
		this.trainToTrack = trainToTrack;
		this.isTelegram = isTelegram;
	}

}
