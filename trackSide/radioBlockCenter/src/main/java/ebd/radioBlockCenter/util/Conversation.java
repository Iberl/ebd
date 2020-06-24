package ebd.radioBlockCenter.util;

import ebd.rbc_tms.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Keeps Track of Messages with the Same UUID
 *
 * @author Christopher Bernjus
 */
public class Conversation {

	/** List of Messages in Conversation */
	private List<Message> messages = new ArrayList<Message>();

	/** Assigned UUID */
	private UUID uuid;

	/** Indicates Whether the Conversation is Closed */
	private boolean closed = false;


	// Constructor

	/**
	 * Creates a New Open {@link Conversation}
	 *
	 * @param message Initial Message in Conversation
	 *
	 * @author Christopher Bernjus
	 */
	public Conversation(Message message) {
		this.uuid = message.getHeader().uuid;
		extend(message);
	}


	// Functions

	/** Adds a Message to the Conversation */
	public void extend(Message message) {
		if(!message.getHeader().uuid.equals(uuid)) {
			throw new IllegalArgumentException("The Message has a different uuid. Expected: " + uuid + "(actual: " + message.getHeader().uuid + ")");
		}
		messages.add(message);
	}

	/** Marks the Conversation as Closed */
	public void close() {
		closed = true;
	}


	// Getter

	public List<Message> getMessages() {
		return messages;
	}

	public UUID getUUID() {
		return uuid;
	}

	public boolean isClosed() {
		return closed;
	}

}
