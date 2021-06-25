package ebd.internal.message;

import ebd.internal.payload.Payload_01;
import ebd.internal.Message;

import java.util.UUID;

/**
 * ID: 01 <br>
 * Name: Register <br>
 * Description: Initialization Of Communication <br>
 * Sender: RBC, TMS
 *
 * @author Christopher Bernjus
 */
public class Message_01 extends Message<Payload_01> {

    // Constructors

    /**
     * Constructs A {@link Message_01} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_01}
     *
     * @author Christopher Bernjus
     */
    public Message_01(String tms_id, String rbc_id, Payload_01 payload) {
        super(1, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_01} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_01}
     *
     * @author Christopher Bernjus
     */
    public Message_01(UUID uuid, String tms_id, String rbc_id, Payload_01 payload) {
        super(1, uuid, tms_id, rbc_id, payload);
    }

}
