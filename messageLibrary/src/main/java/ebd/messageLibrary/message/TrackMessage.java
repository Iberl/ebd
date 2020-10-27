package ebd.messageLibrary.message;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * Superclass For All Track To Train Messages
 *
 * @author Christopher Bernjus
 */
public abstract class TrackMessage extends Message {

    // ------------------------
    // Track Message Superclass
    // ------------------------

    /** {@link ETCSVariables#M_ACK} */
    @BitLength(1)
    @OrderIndex(3)
    public boolean M_ACK = ETCSVariables.M_ACK;

    /** {@link ETCSVariables#NID_LRBG} */
    @BitLength(24)
    @OrderIndex(4)
    public int NID_LRBG = ETCSVariables.NID_LRBG;


    // Constructors

    /**
     * Constructs An Empty {@link TrackMessage}
     *
     * @param NID_MESSAGE
     *         {@link ETCSVariables#NID_MESSAGE}
     *
     * @author Christopher Bernjus
     */
    public TrackMessage(int NID_MESSAGE) {
        super(NID_MESSAGE);
    }

    /**
     * Constructs A {@link TrackMessage}
     *
     * @param NID_MESSAGE
     *         {@link ETCSVariables#NID_MESSAGE}
     * @param T_TRAIN
     *         {@link ETCSVariables#T_TRAIN}
     * @param M_ACK
     *         {@link ETCSVariables#M_ACK}
     * @param NID_LRBG
     *         {@link ETCSVariables#NID_LRBG}
     *
     * @author Christopher Bernjus
     */
    public TrackMessage(int NID_MESSAGE, long T_TRAIN, boolean M_ACK, int NID_LRBG) {
        super(NID_MESSAGE, T_TRAIN);
        this.M_ACK = M_ACK;
        this.NID_LRBG = NID_LRBG;
    }


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        if(!super.equals(object)) return false;
        TrackMessage that = (TrackMessage) object;
        return M_ACK == that.M_ACK && NID_LRBG == that.NID_LRBG;
    }

}
