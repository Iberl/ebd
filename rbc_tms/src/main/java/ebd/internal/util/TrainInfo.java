package ebd.internal.util;

import java.util.Objects;

/**
 * Validated Train Data Sent By Trains
 *
 * @author Christopher Bernjus
 */
public class TrainInfo {

    /** {@link ETCSVariables#NID_ENGINE} */
    public int nid_engine;

    /** {@link ETCSVariables#NID_OPERATIONAL} */
    public int nid_operational;

    /** {@link ETCSVariables#T_TRAIN} */
    public long t_train;


    // Constructor

    /**
     * Constructs A {@link TrainInfo} Object
     *
     * @param nid_engine {@link TrainInfo#nid_engine}
     * @param nid_operational {@link TrainInfo#nid_operational}
     * @param t_train {@link TrainInfo#t_train}
     *
     * @author Christopher Bernjus
     */
    public TrainInfo(int nid_engine, int nid_operational, long t_train) {
        this.nid_engine = nid_engine;
        this.nid_operational = nid_operational;
        this.t_train = t_train;
    }


    // Functions

    @Override
    public String toString() {
        return "TrainInfo{" + "nid_engine=" + nid_engine + ", nid_operational=" + nid_operational + ", t_train=" + t_train + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        TrainInfo trainInfo = (TrainInfo) o;
        return nid_engine == trainInfo.nid_engine && nid_operational == trainInfo.nid_operational && t_train == trainInfo.t_train;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nid_engine, nid_operational, t_train);
    }

}
