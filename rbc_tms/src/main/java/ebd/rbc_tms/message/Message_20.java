package ebd.rbc_tms.message;

import ebd.rbc_tms.Message;
import ebd.rbc_tms.payload.Payload_20;

import java.util.UUID;

/**
 * ID: 20 <br>
 * Name: Position Report Request <br>
 * Description: Request Position Update For A Train <br>
 * Sender: TMS
 *
 * @author Christopher Bernjus
 */
public class Message_20 extends Message<Payload_20> {

    // Constructors

    /**
     * Constructs A {@link Message_20} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_20}
     *
     * @author Christopher Bernjus
     */
    public Message_20(String tms_id, String rbc_id, Payload_20 payload) {
        super(20, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_20} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_20}
     *
     * @author Christopher Bernjus
     */
    public Message_20(UUID uuid, String tms_id, String rbc_id, Payload_20 payload) {
        super(20, uuid, tms_id, rbc_id, payload);
    }

}
