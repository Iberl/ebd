package ebd.rbc_tms.payload;

import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.Constants;
import ebd.rbc_tms.util.TrainInfo;

import java.util.Objects;

/**
 * Payload Used In A {@link ebd.rbc_tms.message.Message_10}
 *
 * @author Christopher Bernjus
 */
public class Payload_10 extends Payload {

    /** {@link TrainInfo} */
    public TrainInfo trainInfo;


    // Constructor

    /**
     * Constructs A {@link Payload_10} Object
     *
     * @param trainInfo {@link TrainInfo}
     *
     * @author Christopher Bernjus
     */
    public Payload_10(TrainInfo trainInfo) {
        this.trainInfo = trainInfo;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_10{" + "trainInfo=" + trainInfo.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_10 that = (Payload_10) o;
        return Objects.equals(trainInfo, that.trainInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_LOGIN, trainInfo);
    }

}
