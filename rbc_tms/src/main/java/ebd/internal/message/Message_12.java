package ebd.internal.message;

import ebd.internal.Message;
import ebd.internal.payload.Payload_12;

import java.util.UUID;

/**
 * ID: 12 <br>
 * Name: Time Change <br>
 * Description: Indicate Usage Of A New Time Factor <br>
 * Sender: RBC
 *
 * @author Christopher Bernjus
 */
public class Message_12 extends Message<Payload_12> {

    // Constructors

    /**
     * Constructs A {@link Message_12} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_12}
     *
     * @author Christopher Bernjus
     */
    public Message_12(String tms_id, String rbc_id, Payload_12 payload) {
        super(12, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_12} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_12}
     *
     * @author Christopher Bernjus
     */
    public Message_12(UUID uuid, String tms_id, String rbc_id, Payload_12 payload) {
        super(12, uuid, tms_id, rbc_id, payload);
    }

}
