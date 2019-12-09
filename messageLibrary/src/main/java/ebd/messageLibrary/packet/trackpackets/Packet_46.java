package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 46 <br>
 * Type: Track To Train <br>
 * Description: Conditional Level Transition Order <br>
 * Transmitted By: Balise <br>
 * Subclasses: Level <br>
 * Elements: level <br>
 * Lists: levels
 *
 * @author Christopher Bernjus
 */
@OrderLength(5)
public class Packet_46 extends TrackPacketDIR {

    /** Subclass For Handling Iterated Levels */
    @OrderLength(2)
    public static class Packet_46_Level {

        /** {@link ETCSVariables#M_LEVELTR} */
        @BitLength(3)
        @OrderIndex(0)
        public int M_LEVELTR = ETCSVariables.M_LEVELTR;

        /** {@link ETCSVariables#NID_NTC} */
        @BitLength(8)
        @OrderIndex(1)
        public int NID_NTC = ETCSVariables.NID_NTC;


        // Constructors

        /**
         * Constructs An Empty {@link Packet_46_Level}
         *
         * @author Christopher Bernjus
         */
        public Packet_46_Level() {}

        /**
         * Constructs A {@link Packet_46_Level}
         *
         * @param M_LEVELTR
         *            {@link ETCSVariables#M_LEVELTR}
         * @param NID_NTC
         *            {@link ETCSVariables#NID_NTC}
         */
        public Packet_46_Level(int M_LEVELTR, int NID_NTC) {
            this.M_LEVELTR = M_LEVELTR;
            this.NID_NTC = NID_NTC;
        }
    }

    // ----------------------------------
    // Conditional Level Transition Order
    // ----------------------------------

    /** First {@link Packet_46_Level} */
    @OrderIndex(3)
    public Packet_46_Level level = new Packet_46_Level();

    /** List Of Additional {@link Packet_46_Level} */
    @OrderIndex(4)
    @ItemType(Packet_46_Level.class)
    public List<Packet_46_Level> levels = new ArrayList<>();


    // Constructors

    /**
     * Constructs An Empty {@link Packet_46}
     *
     * @author Christopher Bernjus
     */
    public Packet_46() { super(46); }

    /**
     * Constructs A {@link Packet_46}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     * @param level
     *            {@link Packet_46_Level}
     *
     * @author Christopher Bernjus
     */
    public Packet_46(int Q_DIR, Packet_46_Level level) {
        super(46, Q_DIR);
        this.level = level;
    }
}
