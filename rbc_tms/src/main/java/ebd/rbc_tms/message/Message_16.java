package ebd.rbc_tms.message;

import ebd.rbc_tms.Message;
import ebd.rbc_tms.payload.Payload_16;

import java.util.UUID;

/**
 * ID: 16 <br>
 * Name: SH Request <br>
 * Description: Request Allowance For Changing To Shunting Mode <br>
 * Sender: RBC
 *
 * @author Christopher Bernjus
 */
public class Message_16 extends Message<Payload_16> {

    // Constructors

    /**
     * Constructs A {@link Message_16} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_16}
     *
     * @author Christopher Bernjus
     */
    public Message_16(String tms_id, String rbc_id, Payload_16 payload) {
        super(16, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_16} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_16}
     *
     * @author Christopher Bernjus
     */
    public Message_16(UUID uuid, String tms_id, String rbc_id, Payload_16 payload) {
        super(16, uuid, tms_id, rbc_id, payload);
    }

}
