package ebd.rbc_tms.payload;

import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.Constants;

import java.util.Objects;

/**
 * Payload Used In A {@link ebd.rbc_tms.message.Message_01}
 *
 * @author Christopher Bernjus
 */
public class Payload_02 extends Payload {

    // This Payload Holds No Values


    // Constructor

    /**
     * Constructs A {@link Payload_02} Object
     *
     * @author Christopher Bernjus
     */
    public Payload_02() {}


    // Functions

    @Override
    public String toString() {
        return "Payload_02{}";
    }

    @Override
    public boolean equals(Object o) {
        return (this == o) || (o != null && getClass() == o.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_UNREGISTER);
    }
}
