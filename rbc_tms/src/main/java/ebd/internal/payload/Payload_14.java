package ebd.internal.payload;

import ebd.internal.message.Message_14;
import ebd.internal.Payload;
import ebd.internal.util.Constants;
import ebd.internal.util.PositionInfo;
import ebd.internal.util.TrainInfo;

import java.util.Objects;

/**
 * Payload Used In A {@link Message_14}
 *
 * @author Christopher Bernjus
 */
public class Payload_14 extends Payload {

    /** {@link TrainInfo} */
    public TrainInfo trainInfo;

    /** {@link PositionInfo} */
    public PositionInfo positionInfo;


    // Constructor

    /**
     * Constructs A {@link Payload_14} Object
     *
     * @param trainInfo {@link TrainInfo}
     * @param positionInfo {@link PositionInfo}
     *
     * @author Christopher Bernjus
     */
    public Payload_14(TrainInfo trainInfo, PositionInfo positionInfo) {
        this.trainInfo = trainInfo;
        this.positionInfo = positionInfo;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_14{" + "trainInfo=" + trainInfo.toString() + ", positionInfo=" + positionInfo.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_14 that = (Payload_14) o;
        return Objects.equals(trainInfo, that.trainInfo) && Objects.equals(positionInfo, that.positionInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_POSITION_REPORT, trainInfo, positionInfo);
    }

}
