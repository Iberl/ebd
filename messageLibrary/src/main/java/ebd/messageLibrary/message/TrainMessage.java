package ebd.messageLibrary.message;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * Superclass For All Train To Track Messages
 *
 * @author Christopher Bernjus
 */
public abstract class TrainMessage extends Message {

    // ------------------------
    // Train Message Superclass
    // ------------------------

    /** {@link ETCSVariables#NID_ENGINE} */
    @BitLength(24)
    @OrderIndex(3)
    public int NID_ENGINE = ETCSVariables.NID_ENGINE;


    // Constructors

    /**
     * Constructs An Empty {@link TrackMessage}
     *
     * @param NID_MESSAGE
     *         {@link ETCSVariables#NID_MESSAGE}
     *
     * @author Christopher Bernjus
     */
    public TrainMessage(int NID_MESSAGE) {
        super(NID_MESSAGE);
    }

    /**
     * Constructs A {@link TrackMessage}
     *
     * @param NID_MESSAGE
     *         {@link ETCSVariables#NID_MESSAGE}
     * @param T_TRAIN
     *         {@link ETCSVariables#T_TRAIN}
     * @param NID_ENGINE
     *         {@link ETCSVariables#NID_LRBG}
     *
     * @author Christopher Bernjus
     */
    public TrainMessage(int NID_MESSAGE, long T_TRAIN, int NID_ENGINE) {
        super(NID_MESSAGE, T_TRAIN);
        this.NID_ENGINE = NID_ENGINE;
    }


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        if(!super.equals(object)) return false;
        TrainMessage that = (TrainMessage) object;
        return NID_ENGINE == that.NID_ENGINE;
    }

}
