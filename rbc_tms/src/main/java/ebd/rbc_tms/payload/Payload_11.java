package ebd.rbc_tms.payload;

import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.Constants;
import ebd.rbc_tms.util.TrainInfo;

import java.util.Objects;

/**
 * Payload Used In A {@link ebd.rbc_tms.message.Message_11}
 *
 * @author Christopher Bernjus
 */
public class Payload_11 extends Payload {

    /** {@link TrainInfo} */
    public TrainInfo trainInfo;


    // Constructor

    /**
     * Constructs A {@link Payload_11} Object
     *
     * @param trainInfo {@link TrainInfo}
     *
     * @author Christopher Bernjus
     */
    public Payload_11(TrainInfo trainInfo) {
        this.trainInfo = trainInfo;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_11{" + "trainInfo=" + trainInfo.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_11 that = (Payload_11) o;
        return Objects.equals(trainInfo, that.trainInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_LOGOUT, trainInfo);
    }

}
