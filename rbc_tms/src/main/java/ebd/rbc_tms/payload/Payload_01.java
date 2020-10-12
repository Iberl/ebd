package ebd.rbc_tms.payload;

import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.Constants;
import ebd.rbc_tms.util.annotations.CanBeNull;

import java.util.Objects;

/**
 * Payload Used In A {@link ebd.rbc_tms.message.Message_01}
 *
 * @author Christopher Bernjus
 */
public class Payload_01 extends Payload {

    /** Time Based On Midnight 01.01.1970 */
    @CanBeNull
    public Long time_base;

    /** Time Scaling Factor */
    public int time_factor;

    /** Supported Protocol Version */
    public String version;


    // Constructor

    /**
     * Constructs A {@link Payload_01} Object
     *
     * @param time_base {@link Payload_01#time_base}
     * @param time_factor {@link Payload_01#time_factor}
     * @param version {@link Payload_01#version}
     *
     * @author Christopher Bernjus
     */
    public Payload_01(Long time_base, int time_factor, String version) {
        this.time_base = time_base;
        this.time_factor = time_factor;
        this.version = version;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_01{" + "time_base=" + time_base + ", time_factor=" + time_factor + ", version='" + version + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_01 that = (Payload_01) o;
        return time_factor == that.time_factor && Objects.equals(time_base, that.time_base) && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_REGISTER, time_base, time_factor, version);
    }

}
