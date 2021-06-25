package ebd.internal.message;

import ebd.internal.Message;
import ebd.internal.payload.Payload_22;

import java.util.UUID;

/**
 * ID: 22 <br>
 * Name: Request To Shorten MA <br>
 * Description: Request A Train To Shorten A Previous Sent MA <br>
 * Sender: TMS
 *
 * @author Christopher Bernjus
 */
public class Message_22 extends Message<Payload_22> {

    // Constructors

    /**
     * Constructs A {@link Message_22} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_22}
     *
     * @author Christopher Bernjus
     */
    public Message_22(String tms_id, String rbc_id, Payload_22 payload) {
        super(22, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_22} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_22}
     *
     * @author Christopher Bernjus
     */
    public Message_22(UUID uuid, String tms_id, String rbc_id, Payload_22 payload) {
        super(22, uuid, tms_id, rbc_id, payload);
    }

}
