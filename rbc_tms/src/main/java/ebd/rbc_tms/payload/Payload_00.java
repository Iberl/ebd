package ebd.rbc_tms.payload;

import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.Constants;
import ebd.rbc_tms.util.TrainInfo;
import ebd.rbc_tms.util.annotations.CanBeNull;

import java.util.Objects;

/**
 * Payload Used In A {@link ebd.rbc_tms.message.Message_00}
 *
 * @author Christopher Bernjus
 */
public class Payload_00 extends Payload {

    /** Error Code */
    public int errorCode;

    /** {@link TrainInfo} [Optional] */
    @CanBeNull
    public TrainInfo trainInfo;


    // Constructor

    /**
     * Constructs A {@link Payload_00} Object
     *
     * @param errorCode {@link Payload_00#errorCode}
     * @param trainInfo {@link TrainInfo} [Optional]
     *
     * @author Christopher Bernjus
     */
    public Payload_00(int errorCode, TrainInfo trainInfo) {
        this.errorCode = errorCode;
        this.trainInfo = trainInfo;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_00{" + "errorCode=" + errorCode + ", trainInfo=" + trainInfo.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_00 that = (Payload_00) o;
        return errorCode == that.errorCode && Objects.equals(trainInfo, that.trainInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_ERROR, errorCode, trainInfo);
    }

}
