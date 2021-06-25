package ebd.internal.message;

import ebd.internal.payload.Payload_23;
import ebd.internal.Message;

import java.util.UUID;

/**
 * ID: 23 <br>
 * Name: Conditional Emergency Stop <br>
 * Description: Sending A Conditional Emergency Stop Order <br>
 * Sender: TMS
 *
 * @author Christopher Bernjus
 */
public class Message_23 extends Message<Payload_23> {

    // Constructors

    /**
     * Constructs A {@link Message_23} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_23}
     *
     * @author Christopher Bernjus
     */
    public Message_23(String tms_id, String rbc_id, Payload_23 payload) {
        super(23, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_23} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_23}
     *
     * @author Christopher Bernjus
     */
    public Message_23(UUID uuid, String tms_id, String rbc_id, Payload_23 payload) {
        super(23, uuid, tms_id, rbc_id, payload);
    }

}
