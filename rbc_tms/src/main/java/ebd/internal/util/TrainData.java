package ebd.internal.util;

import ebd.internal.message.Message_13;
import ebd.internal.util.annotations.CanBeNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Train Data Used In {@link Message_13}
 *
 * @author Christopher Bernjus
 */
public class TrainData {

    /** Subclass For Handling Traction Systems */
    public static class TractionSystem {

        /** {@link ETCSVariables#M_VOLTAGE} */
        public int m_voltage;

        /** {@link ETCSVariables#NID_CTRACTION} */
        @CanBeNull
        public Integer nid_ctraction;


        // Constructor

        /**
         * Constructs A {@link TractionSystem} Object
         *
         * @param m_voltage {@link TractionSystem#m_voltage}
         * @param nid_ctraction {@link TractionSystem#nid_ctraction}
         *
         * @author Christopher Bernjus
         */
        public TractionSystem(int m_voltage, int nid_ctraction) {
            this.m_voltage = m_voltage;
            this.nid_ctraction = nid_ctraction;
        }


        // Functions

        @Override
        public String toString() {
            return "TractionSystem{" + "m_voltage=" + m_voltage + ", nid_ctraction=" + (nid_ctraction == null ? "null" : nid_ctraction) + '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            TractionSystem that = (TractionSystem) o;
            return m_voltage == that.m_voltage && Objects.equals(nid_ctraction, that.nid_ctraction);
        }

        @Override
        public int hashCode() {
            return Objects.hash(m_voltage, nid_ctraction);
        }

    }

    /** Subclass For Handling National Systems */
    public static class NationalSystem {

        /** {@link ETCSVariables#NID_NTC} */
        public int nid_ntc;


        // Constructor

        /**
         * Constructs A {@link NationalSystem} Object
         *
         * @param nid_ntc {@link NationalSystem#nid_ntc}
         *
         * @author Christopher Bernjus
         */
        public NationalSystem(int nid_ntc) {
            this.nid_ntc = nid_ntc;
        }


        // Functions

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            NationalSystem that = (NationalSystem) o;
            return nid_ntc == that.nid_ntc;
        }

        @Override
        public int hashCode() {
            return Objects.hash(nid_ntc);
        }

    }


    // Train Data

    /** {@link ETCSVariables#NC_CDTRAIN} */
    public int nc_cdtrain;

    /** {@link ETCSVariables#NC_TRAIN} */
    public int nc_train;

    /** {@link ETCSVariables#L_TRAIN} */
    public int l_train;

    /** {@link ETCSVariables#V_MAXTRAIN} */
    public int v_maxtrain;

    /** {@link ETCSVariables#M_LOADINGGAUGE} */
    public int m_loadinggauge;

    /** {@link ETCSVariables#M_AXLELOADCAT} */
    public int m_axleloadcat;

    /** {@link ETCSVariables#M_AIRTIGHT} */
    public int m_airtight;

    /** {@link ETCSVariables#N_AXLE} */
    public int n_axle;

    /** List Of {@link TractionSystem}s */
    public List<TractionSystem> tractionSystems = new ArrayList<>();

    /** List Of {@link NationalSystem}s */
    public List<NationalSystem> nationalSystems = new ArrayList<>();


    // Constructors

    /**
     * Constructs A {@link TrainData} Object With Empty Lists
     *
     * @param nc_cdtrain {@link TrainData#nc_cdtrain}
     * @param nc_train {@link TrainData#nc_train}
     * @param l_train {@link TrainData#l_train}
     * @param v_maxtrain {@link TrainData#v_maxtrain}
     * @param m_loadinggauge {@link TrainData#m_loadinggauge}
     * @param m_axleloadcat {@link TrainData#m_axleloadcat}
     * @param m_airtight {@link TrainData#m_airtight}
     * @param n_axle {@link TrainData#n_axle}
     *
     * @author Christopher Bernjus
     */
    public TrainData(int nc_cdtrain, int nc_train, int l_train, int v_maxtrain, int m_loadinggauge, int m_axleloadcat, int m_airtight, int n_axle) {
        this.nc_cdtrain = nc_cdtrain;
        this.nc_train = nc_train;
        this.l_train = l_train;
        this.v_maxtrain = v_maxtrain;
        this.m_loadinggauge = m_loadinggauge;
        this.m_axleloadcat = m_axleloadcat;
        this.m_airtight = m_airtight;
        this.n_axle = n_axle;
    }

    /**
     * Constructs A {@link TrainData} Object With Given Lists
     *
     * @param nc_cdtrain {@link TrainData#nc_cdtrain}
     * @param nc_train {@link TrainData#nc_train}
     * @param l_train {@link TrainData#l_train}
     * @param v_maxtrain {@link TrainData#v_maxtrain}
     * @param m_loadinggauge {@link TrainData#m_loadinggauge}
     * @param m_axleloadcat {@link TrainData#m_axleloadcat}
     * @param m_airtight {@link TrainData#m_airtight}
     * @param n_axle {@link TrainData#n_axle}
     * @param tractionSystems List Of {@link TractionSystem}s
     * @param nationalSystems List Of {@link NationalSystem}s
     *
     * @author Christopher Bernjus
     */
    public TrainData(int nc_cdtrain, int nc_train, int l_train, int v_maxtrain, int m_loadinggauge, int m_axleloadcat, int m_airtight, int n_axle,
                     List<TractionSystem> tractionSystems, List<NationalSystem> nationalSystems) {
        this.nc_cdtrain = nc_cdtrain;
        this.nc_train = nc_train;
        this.l_train = l_train;
        this.v_maxtrain = v_maxtrain;
        this.m_loadinggauge = m_loadinggauge;
        this.m_axleloadcat = m_axleloadcat;
        this.m_airtight = m_airtight;
        this.n_axle = n_axle;
        this.tractionSystems = tractionSystems;
        this.nationalSystems = nationalSystems;
    }


    // Functions

    @Override
    public String toString() {
        return "TrainData{" + "nc_cdtrain=" + nc_cdtrain + ", nc_train=" + nc_train + ", l_train=" + l_train + ", v_maxtrain=" + v_maxtrain +
               ", m_loadinggauge=" + m_loadinggauge + ", m_axleloadcat=" + m_axleloadcat + ", m_airtight=" + m_airtight + ", n_axle=" + n_axle +
               ", tractionSystems=" + tractionSystems.toString() + ", nationalSystems=" + nationalSystems.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        TrainData trainData = (TrainData) o;
        return nc_cdtrain == trainData.nc_cdtrain && nc_train == trainData.nc_train && l_train == trainData.l_train &&
               v_maxtrain == trainData.v_maxtrain && m_loadinggauge == trainData.m_loadinggauge && m_axleloadcat == trainData.m_axleloadcat &&
               m_airtight == trainData.m_airtight && n_axle == trainData.n_axle && tractionSystems.equals(trainData.tractionSystems) &&
               nationalSystems.equals(trainData.nationalSystems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nc_cdtrain, nc_train, l_train, v_maxtrain, m_loadinggauge, m_axleloadcat, m_airtight, n_axle, tractionSystems,
                            nationalSystems);
    }

}
