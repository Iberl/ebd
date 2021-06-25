package ebd.internal.message;

import ebd.internal.Message;
import ebd.internal.payload.Payload_15;

import java.util.UUID;

/**
 * ID: 15 <br>
 * Name: MA Request <br>
 * Description: Request A Movement Authority For A Train <br>
 * Sender: RBC
 *
 * @author Christopher Bernjus
 */
public class Message_15 extends Message<Payload_15> {

    // Constructors

    /**
     * Constructs A {@link Message_15} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_15}
     *
     * @author Christopher Bernjus
     */
    public Message_15(String tms_id, String rbc_id, Payload_15 payload) {
        super(15, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_15} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_15}
     *
     * @author Christopher Bernjus
     */
    public Message_15(UUID uuid, String tms_id, String rbc_id, Payload_15 payload) {
        super(15, uuid, tms_id, rbc_id, payload);
    }

}
