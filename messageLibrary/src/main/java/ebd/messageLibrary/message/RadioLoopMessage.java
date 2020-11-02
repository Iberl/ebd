package ebd.messageLibrary.message;

import ebd.messageLibrary.packet.Packet_255;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.ListSize;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Radio Loop Message transmitted by each loop
 */
public class RadioLoopMessage {

    // -------------------------------------------
    // Radio Loop Message Transmitted By Each Loop
    // -------------------------------------------

    /** {@link ETCSVariables#Q_UPDOWN} */
    @BitLength(1)
    @OrderIndex(0)
    public boolean Q_UPDOWN = ETCSVariables.Q_UPDOWN;

    /** {@link ETCSVariables#M_VERSION} */
    @BitLength(7)
    @OrderIndex(1)
    public int M_VERSION = ETCSVariables.M_VERSION;

    /** {@link ETCSVariables#Q_MEDIA} */
    @BitLength(1)
    @OrderIndex(2)
    public boolean Q_MEDIA = ETCSVariables.Q_MEDIA;

    /** {@link ETCSVariables#NID_C} */
    @BitLength(10)
    @OrderIndex(3)
    public int NID_C = ETCSVariables.NID_C;

    /** {@link ETCSVariables#NID_LOOP} */
    @BitLength(14)
    @OrderIndex(4)
    public int NID_LOOP = ETCSVariables.NID_LOOP;

    /** List of {@link TrackPacket}s */
    @OrderIndex(11)
    @ItemType(TrackPacket.class)
    @ListSize(0)
    public List<TrackPacket> packets = new ArrayList<>();

    /** {@link Packet_255} */
    @OrderIndex(12)
    public Packet_255 PACKET_255 = new Packet_255();


    // Constructors

    /**
     * Constructs An Empty {@link RadioLoopMessage}
     *
     * @author Christopher Bernjus
     */
    public RadioLoopMessage() { }

    /**
     * Constructs A {@link RadioLoopMessage}
     *
     * @param Q_UPDOWN
     *         {@link ETCSVariables#Q_UPDOWN}
     * @param M_VERSION
     *         {@link ETCSVariables#M_VERSION}
     * @param Q_MEDIA
     *         {@link ETCSVariables#Q_MEDIA}
     * @param NID_C
     *         {@link ETCSVariables#NID_C}
     * @param NID_LOOP
     *         {@link ETCSVariables#NID_LOOP}
     *
     * @author Christopher Bernjus
     */
    public RadioLoopMessage(boolean Q_UPDOWN, int M_VERSION, boolean Q_MEDIA, int NID_C, int NID_LOOP) {
        this.Q_UPDOWN = Q_UPDOWN;
        this.M_VERSION = M_VERSION;
        this.Q_MEDIA = Q_MEDIA;
        this.NID_C = NID_C;
        this.NID_LOOP = NID_LOOP;
    }


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        RadioLoopMessage that = (RadioLoopMessage) object;
        return Q_UPDOWN == that.Q_UPDOWN && M_VERSION == that.M_VERSION && Q_MEDIA == that.Q_MEDIA && NID_C == that.NID_C &&
               NID_LOOP == that.NID_LOOP && packets.equals(that.packets) && Objects.equals(PACKET_255, that.PACKET_255);
    }

    @Override
    public String toString() {
        return "RadioLoopMessage{"
               + "Q_UPDOWN=" + Q_UPDOWN + ", M_VERSION=" + M_VERSION + ", Q_MEDIA=" + Q_MEDIA
               + ", NID_C=" + NID_C + ", NID_LOOP=" + NID_LOOP
               + ", packets=" + packets.toString()
               + ", PACKET_255=" + PACKET_255.toString()
               + '}';
    }

}
