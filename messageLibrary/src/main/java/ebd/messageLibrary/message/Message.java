package ebd.messageLibrary.message;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.NotToBeDeserialized;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * Superclass For All Radio Messages
 *
 * @author Christopher Bernjus
 */
public abstract class Message {

    // ------------------------
    // Radio Message Superclass
    // ------------------------

    /** {@link ETCSVariables#NID_MESSAGE} */
    @BitLength(8)
    @OrderIndex(0)
    @NotToBeDeserialized
    public int NID_MESSAGE;

    /** {@link ETCSVariables#L_MESSAGE} */
    @BitLength(10)
    @OrderIndex(1)
    public int L_MESSAGE = ETCSVariables.L_MESSAGE;

    /** {@link ETCSVariables#T_TRAIN} */
    @BitLength(32)
    @OrderIndex(2)
    public long T_TRAIN = ETCSVariables.T_TRAIN;


    // Constructor

    /**
     * Constructs An Empty {@link Message}
     *
     * @param NID_MESSAGE
     *         {@link ETCSVariables#NID_MESSAGE}
     *
     * @author Christopher Bernjus
     */
    public Message(int NID_MESSAGE) {
        this.NID_MESSAGE = NID_MESSAGE;
    }

    /**
     * Constructs A {@link Message}
     *
     * @param NID_MESSAGE
     *         {@link ETCSVariables#NID_MESSAGE}
     * @param T_TRAIN
     *         {@link ETCSVariables#T_TRAIN}
     *
     * @author Christopher Bernjus
     */
    public Message(int NID_MESSAGE, long T_TRAIN) {
        this.NID_MESSAGE = NID_MESSAGE;
        this.T_TRAIN = T_TRAIN;
    }


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Message message = (Message) object;
        return NID_MESSAGE == message.NID_MESSAGE && T_TRAIN == message.T_TRAIN;
    }

    @Override
    public int hashCode() {
        return Objects.hash(NID_MESSAGE);
    }

}
