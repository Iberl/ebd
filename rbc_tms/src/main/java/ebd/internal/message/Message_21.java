package ebd.internal.message;

import ebd.internal.payload.Payload_21;
import ebd.internal.Message;

import java.util.UUID;

/**
 * ID: 21 <br>
 * Name: MA <br>
 * Description: Sending A Movement Authority <br>
 * Sender: TMS
 *
 * @author Christopher Bernjus
 */
public class Message_21 extends Message<Payload_21> {

    // Constructors

    /**
     * Constructs A {@link Message_21} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_21}
     *
     * @author Christopher Bernjus
     */
    public Message_21(String tms_id, String rbc_id, Payload_21 payload) {
        super(21, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_21} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_21}
     *
     * @author Christopher Bernjus
     */
    public Message_21(UUID uuid, String tms_id, String rbc_id, Payload_21 payload) {
        super(21, uuid, tms_id, rbc_id, payload);
    }

}
