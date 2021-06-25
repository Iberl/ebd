package ebd.internal.payload;

import ebd.internal.message.Message_12;
import ebd.internal.util.Constants;
import ebd.internal.util.annotations.CanBeNull;
import ebd.internal.Payload;

import java.util.Objects;

/**
 * Payload Used In A {@link Message_12}
 *
 * @author Christopher Bernjus
 */
public class Payload_12 extends Payload {

    /** Time Based On Midnight 01.01.1970 */
    @CanBeNull
    public Long time_base;

    /** Time Scaling Factor */
    public int time_factor;


    // Constructor

    /**
     * Constructs A {@link Payload_01} Object
     *
     * @param time_base {@link Payload_01#time_base}
     * @param time_factor {@link Payload_01#time_factor}
     *
     * @author Christopher Bernjus
     */
    public Payload_12(Long time_base, int time_factor) {
        this.time_base = time_base;
        this.time_factor = time_factor;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_12{" + "time_base=" + time_base + ", time_factor=" + time_factor + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_12 that = (Payload_12) o;
        return time_factor == that.time_factor && Objects.equals(time_base, that.time_base);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_TIME_CHANGE, time_base, time_factor);
    }

}
