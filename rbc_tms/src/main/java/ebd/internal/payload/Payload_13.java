package ebd.internal.payload;

import ebd.internal.message.Message_13;
import ebd.internal.Payload;
import ebd.internal.util.Constants;
import ebd.internal.util.PositionInfo;
import ebd.internal.util.TrainData;
import ebd.internal.util.TrainInfo;

import java.util.Objects;

/**
 * Payload Used In A {@link Message_13}
 *
 * @author Christopher Bernjus
 */
public class Payload_13 extends Payload {

    /** {@link TrainInfo} */
    public TrainInfo trainInfo;

    /** {@link PositionInfo} */
    public PositionInfo positionInfo;

    /** {@link TrainData} */
    public TrainData trainData;


    // Constructor

    /**
     * Constructs A {@link Payload_13} Object
     *
     * @param trainInfo {@link TrainInfo}
     * @param positionInfo {@link PositionInfo}
     * @param trainData {@link TrainData}
     *
     * @author Christopher Bernjus
     */
    public Payload_13(TrainInfo trainInfo, PositionInfo positionInfo, TrainData trainData) {
        this.trainInfo = trainInfo;
        this.positionInfo = positionInfo;
        this.trainData = trainData;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_13{" + "trainInfo=" + trainInfo.toString() + ", positionInfo=" + positionInfo.toString() + ", trainData=" + trainData.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_13 that = (Payload_13) o;
        return Objects.equals(trainInfo, that.trainInfo) && Objects.equals(positionInfo, that.positionInfo) &&
               Objects.equals(trainData, that.trainData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_TRAIN_DATA, trainInfo, positionInfo, trainData);
    }

}
