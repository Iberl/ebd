package ebd.internal.message;

import ebd.internal.Message;
import ebd.internal.payload.Payload_02;

import java.util.UUID;

/**
 * ID: 02 <br>
 * Name: Unregister <br>
 * Description: Ending A Communication <br>
 * Sender: RBC, TMS
 *
 * @author Christopher Bernjus
 */
public class Message_02 extends Message<Payload_02> {

    // Constructors

    /**
     * Constructs A {@link Message_02} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_02}
     *
     * @author Christopher Bernjus
     */
    public Message_02(String tms_id, String rbc_id, Payload_02 payload) {
        super(2, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_02} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_02}
     *
     * @author Christopher Bernjus
     */
    public Message_02(UUID uuid, String tms_id, String rbc_id, Payload_02 payload) {
        super(2, uuid, tms_id, rbc_id, payload);
    }

}
