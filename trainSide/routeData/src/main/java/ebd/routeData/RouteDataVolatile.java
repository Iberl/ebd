package ebd.routeData;

import ebd.globalUtils.location.Location;
import ebd.messageLibrary.packet.trackpackets.*;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

/**
 * @author Lars Schulze-Falck
 */
public class RouteDataVolatile {
    //TODO Respect SRS 3 A.3.6
    //TODO Respect SRS 3 A.3.4
    /**
     * Reference Location to which all packets are relative to, updated by the MessageHandler in TSM.
     */
    @Nullable
    protected volatile Location refLocation = null;
    /**
     * A {@link Packet_15} containing a movement authority, updated by the MessageHandler in TSM
     */
    @Nullable
    protected volatile Packet_15 packet_15 = null;

    /**
     * A @{@link Packet_21} containing a gradient profile, updated by the MessageHandler in TSM
     */
    @Nullable
    protected volatile Packet_21 packet_21 = null;

    /**
     * A {@link Packet_27} containing a static speed profile, updated by the MessageHandler in TSM
     */
    @Nullable
    protected volatile Packet_27 packet_27 = null;

    /**
     * A list of @{@link Packet_65} containing Tempory Speed Restrictions, updated by the MessageHandler in TSM
     */
    @Nullable
    protected volatile List<Packet_65> packet_65 = null;

    /**
     * A {@link Packet_80} containing a mode profile, updated by the the MessageHandler in TSM
     */
    protected volatile Packet_80 packet_80 = null;

    /**
     * Current gradient from an existing gradient profile or default value. In [0/00] (also called per mille).
     */
    protected volatile double currentGradient = 0d;

    /**
     * True if this is the last movement authority before end of mission
     * //TODO Should be replaced by something more fitting
     */
    protected volatile boolean lastMABeforeEndOfMission = false;

    /**
     * Linking Information, updated by the MessageHandler in TSM
     */
    @Nullable
    protected volatile HashMap<Integer, Location> linkingInformation = null;

    public RouteDataVolatile() {
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
     * A {@link Packet_21} containing a gradient profile
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
     * A list of {@link Packet_65} containing Tempory Speed Restrictions
     */
    public List<Packet_65> getPacket_65() {
        return packet_65;
    }

    /**
     * @return A {@link Packet_80} containing a mode profile, updated by the the MessageHandler in TSM
     */
    public Packet_80 getPacket_80() {
        return packet_80;
    }

    /**
     * Current gradient from an existing gradient profile or default value. In [0/00] (also called per mille).
     */
    public double getCurrentGradient() {
        return currentGradient;
    }

    /**
     * True if this is the last movement authority before end of mission
     * //TODO Should be replaced by something more fitting
     */
    public boolean isLastMABeforeEndOfMission() {
        return lastMABeforeEndOfMission;
    }

    /**
     * Linking Information
     */
    public HashMap<Integer, Location> getLinkingInformation() {
        return linkingInformation;
    }
}
