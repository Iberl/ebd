package ebd.routeData;

import ebd.globalUtils.location.Location;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.messageLibrary.packet.trackpackets.Packet_27;
import ebd.messageLibrary.packet.trackpackets.Packet_65;
import org.jetbrains.annotations.Nullable;

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

    public RouteDataVolatile(){}

    /*
    Getter
     */
    public Location getRefLocation() {
        return refLocation;
    }

    public Packet_15 getPacket_15() {
        return packet_15;
    }

    public Packet_21 getPacket_21() {
        return packet_21;
    }

    protected void setPacket_21(Packet_21 packet_21) {
        this.packet_21 = packet_21;
    }

    public Packet_27 getPacket_27() {
        return packet_27;
    }

    protected void setPacket_27(Packet_27 packet_27) {
        this.packet_27 = packet_27;
    }

    public List<Packet_65> getPacket_65() {
        return packet_65;
    }

    protected void setPacket_65(List<Packet_65> packet_65) {
        this.packet_65 = packet_65;
    }
}
