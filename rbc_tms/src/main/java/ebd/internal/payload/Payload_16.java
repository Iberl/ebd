package ebd.internal.payload;

import ebd.internal.message.Message_16;
import ebd.internal.Payload;
import ebd.internal.util.Constants;
import ebd.internal.util.PositionInfo;
import ebd.internal.util.TrainInfo;

import java.util.Objects;

/**
 * Payload for A {@link Message_16}
 *
 * @author Christopher Bernjus
 */
public class Payload_16 extends Payload {

    /** {@link TrainInfo} */
    public TrainInfo trainInfo;

    /** {@link PositionInfo} */
    public PositionInfo positionInfo;


    // Constructor

    /**
     * Constructs A {@link Payload_16} Object
     *
     * @param trainInfo {@link TrainInfo}
     * @param positionInfo {@link PositionInfo}
     *
     * @author Christopher Bernjus
     */
    public Payload_16(TrainInfo trainInfo, PositionInfo positionInfo) {
        this.trainInfo = trainInfo;
        this.positionInfo = positionInfo;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_16{" + "trainInfo=" + trainInfo.toString() + ", positionInfo=" + positionInfo.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_16 that = (Payload_16) o;
        return Objects.equals(trainInfo, that.trainInfo) && Objects.equals(positionInfo, that.positionInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_SH_REQUEST, trainInfo, positionInfo);
    }

}
