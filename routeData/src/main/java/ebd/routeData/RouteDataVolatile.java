package ebd.routeData;

import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.location.Location;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.messageLibrary.packet.trackpackets.Packet_27;
import ebd.messageLibrary.packet.trackpackets.Packet_65;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lars Schulze-Falck
 */
public class RouteDataVolatile {

    /**
     * Reference Location to which all packets are relative to.
     */
    @Nullable
    protected volatile Location refLocation = null;
    /**
     * A {@link Packet_15} containing a movement authority
     */
    @Nullable
    protected volatile Packet_15 packet_15 = null;

    /**
     * A @{@link Packet_21} containing a gradient profile
     */
    @Nullable
    protected volatile Packet_21 packet_21 = null;

    /**
     * A {@link Packet_27} containing a static speed profile
     */
    @Nullable
    protected volatile Packet_27 packet_27 = null;

    /**
     * A list of @{@link Packet_65} containing Tempory Speed Restrictions
     */
    @Nullable
    protected volatile List<Packet_65> packet_65 = null;

    /**
     * Current gradient from an existing gradient profile or default value. In [0/00] (also called per mille).
     */
    protected volatile double currentGradient = 0d;

    public RouteDataVolatile(){}

    /**
     * Only For Testing!
     */
    @Deprecated
    public RouteDataVolatile(@Nullable Location refLocation, @Nullable Packet_15 packet_15, @Nullable Packet_21 packet_21, @Nullable Packet_27 packet_27, @Nullable List<Packet_65> packet_65) {
        NoSuchMethodException noSuchMethodException = new NoSuchMethodException("This Constructor is only for use in tests");
        ExceptionEvent exceptionEvent = new ExceptionEvent("RD", Arrays.asList(new String[]{"all"}), new NotCausedByAEvent(),noSuchMethodException, ExceptionEventTyp.WARNING);
        EventBus.getDefault().post(exceptionEvent);

        this.refLocation = refLocation;
        this.packet_15 = packet_15;
        this.packet_21 = packet_21;
        this.packet_27 = packet_27;
        this.packet_65 = packet_65;
    }

    /*
    Getter
     */

    /**
     * Reference Location to which all packets are relative to.
     */
    public Location getRefLocation() {
        return refLocation;
    }
    /**
     * A {@link Packet_15} containing a movement authority
     */
    public Packet_15 getPacket_15() {
        return packet_15;
    }
    /**
     * A @{@link Packet_21} containing a gradient profile
     */
    public Packet_21 getPacket_21() {
        return packet_21;
    }
    /**
     * A {@link Packet_27} containing a static speed profile
     */
    public Packet_27 getPacket_27() {
        return packet_27;
    }
    /**
     * A list of @{@link Packet_65} containing Tempory Speed Restrictions
     */
    public List<Packet_65> getPacket_65() {
        return packet_65;
    }
    /**
     * Current gradient from an existing gradient profile or default value. In [0/00] (also called per mille).
     */
    public double getCurrentGradient() {
        return currentGradient;
    }
}
