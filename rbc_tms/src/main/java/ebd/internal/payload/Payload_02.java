package ebd.internal.payload;

import ebd.internal.message.Message_01;
import ebd.internal.util.Constants;
import ebd.internal.Payload;

import java.util.Objects;

/**
 * Payload Used In A {@link Message_01}
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
