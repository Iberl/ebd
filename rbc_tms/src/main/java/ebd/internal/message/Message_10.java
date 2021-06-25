package ebd.internal.message;

import ebd.internal.Message;
import ebd.internal.payload.Payload_10;

import java.util.UUID;

/**
 * ID: 10 <br>
 * Name: Log In <br>
 * Description: New Train Entered RBC Supervised Area <br>
 * Sender: RBC
 *
 * @author Christopher Bernjus
 */
public class Message_10 extends Message<Payload_10> {

    // Constructors

    /**
     * Constructs A {@link Message_10} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_10}
     *
     * @author Christopher Bernjus
     */
    public Message_10(String tms_id, String rbc_id, Payload_10 payload) {
        super(10, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_10} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_10}
     *
     * @author Christopher Bernjus
     */
    public Message_10(UUID uuid, String tms_id, String rbc_id, Payload_10 payload) {
        super(10, uuid, tms_id, rbc_id, payload);
    }

}
