package ebd.internal.message;

import ebd.internal.payload.Payload_14;
import ebd.internal.Message;

import java.util.UUID;

/**
 * ID: 14 <br>
 * Name: Position Report <br>
 * Description: Report The Current Train Position <br>
 * Sender: RBC
 *
 * @author Christopher Bernjus
 */
public class Message_14 extends Message<Payload_14> {

    // Constructors

    /**
     * Constructs A {@link Message_14} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_14}
     *
     * @author Christopher Bernjus
     */
    public Message_14(String tms_id, String rbc_id, Payload_14 payload) {
        super(14, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_14} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_14}
     *
     * @author Christopher Bernjus
     */
    public Message_14(UUID uuid, String tms_id, String rbc_id, Payload_14 payload) {
        super(14, uuid, tms_id, rbc_id, payload);
    }

}
