package ebd.rbc_tms.payload;

import com.google.gson.annotations.SerializedName;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.Constants;
import ebd.rbc_tms.util.ShortenMA;

import java.util.Objects;

/**
 * Payload for A {@link ebd.rbc_tms.message.Message_22}
 *
 * @author Christopher Bernjus
 */
public class Payload_22 extends Payload {

    /** {@link ETCSVariables#NID_ENGINE} */
    public int nid_engine;

    /** {@link ShortenMA} */
    @SerializedName(value = "ma")
    public ShortenMA shortenMA;


    // Constructor

    /**
     * Constructs A {@link Payload_22} Object
     *
     * @param nid_engine {@link Payload_22#nid_engine}
     * @param shortenMA {@link ShortenMA}
     */
    public Payload_22(int nid_engine, ShortenMA shortenMA) {
        this.nid_engine = nid_engine;
        this.shortenMA = shortenMA;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_22{" + "nid_engine=" + nid_engine + ", ma=" + shortenMA.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_22 that = (Payload_22) o;
        return nid_engine == that.nid_engine && Objects.equals(shortenMA, that.shortenMA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_REQUEST_TO_SHORTEN_MA, nid_engine, shortenMA);
    }

}
