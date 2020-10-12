package ebd.rbc_tms.message;

import ebd.rbc_tms.Message;
import ebd.rbc_tms.payload.Payload_25;

import java.util.UUID;

/**
 * ID: 25 <br>
 * Name: Revocation Of Emergency Stop <br>
 * Description: Revocation Of A Previous Sent Emergency Stop Order <br>
 * Sender: TMS
 *
 * @author Christopher Bernjus
 */
public class Message_25 extends Message<Payload_25> {

    // Constructors

    /**
     * Constructs A {@link Message_25} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_25}
     *
     * @author Christopher Bernjus
     */
    public Message_25(String tms_id, String rbc_id, Payload_25 payload) {
        super(25, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_25} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_25}
     *
     * @author Christopher Bernjus
     */
    public Message_25(UUID uuid, String tms_id, String rbc_id, Payload_25 payload) {
        super(25, uuid, tms_id, rbc_id, payload);
    }

}
