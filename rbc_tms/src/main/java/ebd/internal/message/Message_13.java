package ebd.internal.message;

import ebd.internal.payload.Payload_13;
import ebd.internal.Message;

import java.util.UUID;

/**
 * ID: 13 <br>
 * Name: Train Data <br>
 * Description: Transmit Validated Train Data Information <br>
 * Sender: RBC
 *
 * @author Christopher Bernjus
 */
public class Message_13 extends Message<Payload_13> {

    // Constructors

    /**
     * Constructs A {@link Message_13} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_13}
     *
     * @author Christopher Bernjus
     */
    public Message_13(String tms_id, String rbc_id, Payload_13 payload) {
        super(13, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_13} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_13}
     *
     * @author Christopher Bernjus
     */
    public Message_13(UUID uuid, String tms_id, String rbc_id, Payload_13 payload) {
        super(13, uuid, tms_id, rbc_id, payload);
    }

}
