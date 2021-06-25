package ebd.internal.message;

import ebd.internal.Message;
import ebd.internal.payload.Payload_24;

import java.util.UUID;

/**
 * ID: 24 <br>
 * Name: Unconditional Emergency Stop <br>
 * Description: Sending An Unconditional Emergency Stop Order <br>
 * Sender: TMS
 *
 * @author Christopher Bernjus
 */
public class Message_24 extends Message<Payload_24> {

    // Constructors

    /**
     * Constructs A {@link Message_24} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_24}
     *
     * @author Christopher Bernjus
     */
    public Message_24(String tms_id, String rbc_id, Payload_24 payload) {
        super(24, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_24} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_24}
     *
     * @author Christopher Bernjus
     */
    public Message_24(UUID uuid, String tms_id, String rbc_id, Payload_24 payload) {
        super(24, uuid, tms_id, rbc_id, payload);
    }

}
