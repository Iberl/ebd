package ebd.rbc_tms.payload;

import ebd.messageLibrary.util.ETCSVariables;
import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.Constants;
import ebd.rbc_tms.util.PositionInfo;
import ebd.rbc_tms.util.TrainInfo;

import java.util.Objects;

/**
 * Payload for A {@link ebd.rbc_tms.message.Message_15}
 *
 * @author Christopher Bernjus
 */
public class Payload_15 extends Payload {

    /** {@link TrainInfo} */
    public TrainInfo trainInfo;

    /** {@link PositionInfo} */
    public PositionInfo positionInfo;

    /** {@link ETCSVariables#Q_MARQSTREASON} */
    public int q_marqstreason;


    // Constructor

    /**
     * Constructs A {@link Payload_15} Object
     *
     * @param trainInfo {@link TrainInfo}
     * @param positionInfo {@link PositionInfo}
     * @param q_marqstreason {@link Payload_15#q_marqstreason}
     *
     * @author Christopher Bernjus
     */
    public Payload_15(TrainInfo trainInfo, PositionInfo positionInfo, int q_marqstreason) {
        this.trainInfo = trainInfo;
        this.positionInfo = positionInfo;
        this.q_marqstreason = q_marqstreason;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_15{" + "trainInfo=" + trainInfo.toString() + ", positionInfo=" + positionInfo.toString() + ", q_marqstreason=" + q_marqstreason + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_15 that = (Payload_15) o;
        return q_marqstreason == that.q_marqstreason && Objects.equals(trainInfo, that.trainInfo) && Objects.equals(positionInfo, that.positionInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_MA_REQUEST, trainInfo, positionInfo, q_marqstreason);
    }

}
