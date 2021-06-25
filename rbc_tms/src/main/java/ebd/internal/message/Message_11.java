package ebd.internal.message;

import ebd.internal.Message;
import ebd.internal.payload.Payload_11;

import java.util.UUID;

/**
 * ID: 11 <br>
 * Name: Log Out <br>
 * Description: Train Left RBC Supervised Area <br>
 * Sender: RBC
 *
 * @author Christopher Bernjus
 */
public class Message_11 extends Message<Payload_11> {

    // Constructors

    /**
     * Constructs A {@link Message_11} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_11}
     *
     * @author Christopher Bernjus
     */
    public Message_11(String tms_id, String rbc_id, Payload_11 payload) {
        super(11, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_11} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_11}
     *
     * @author Christopher Bernjus
     */
    public Message_11(UUID uuid, String tms_id, String rbc_id, Payload_11 payload) {
        super(11, uuid, tms_id, rbc_id, payload);
    }

}
