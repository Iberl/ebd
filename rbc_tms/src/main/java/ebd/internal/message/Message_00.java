package ebd.internal.message;

import ebd.internal.Message;
import ebd.internal.payload.Payload_00;

import java.util.UUID;

/**
 * ID: 00 <br>
 * Name: Error <br>
 * Description: Error Transmission <br>
 * Sender: RBC, TMS
 *
 * @author Christopher Bernjus
 */
public class Message_00 extends Message<Payload_00> {

    // Constructors

    /**
     * Constructs A {@link Message_00} With A Random UUID
     *
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_00}
     *
     * @author Christopher Bernjus
     */
    public Message_00(String tms_id, String rbc_id, Payload_00 payload) {
        super(0, tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message_00} With A Specific UUID
     *
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload_00}
     *
     * @author Christopher Bernjus
     */
    public Message_00(UUID uuid, String tms_id, String rbc_id, Payload_00 payload) {
        super(0, uuid, tms_id, rbc_id, payload);
    }

}
