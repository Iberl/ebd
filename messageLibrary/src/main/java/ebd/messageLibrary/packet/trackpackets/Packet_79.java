package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 5 <br>
 * Type: Track To Train <br>
 * Description: Geographical Position Information <br>
 * Transmitted By: Balise, RBC <br>
 * Subclasses: Position <br>
 * Elements: position <br>
 * Lists: positions
 *
 * @author Christopher Bernjus
 */
public class Packet_79 extends TrackPacketSCALE {

    public static class Packet_79_Position {

        /** {@link ETCSVariables#Q_NEWCOUNTRY} */
        @BitLength(1)
        @OrderIndex(0)
        public boolean Q_NEWCOUNTRY = ETCSVariables.Q_NEWCOUNTRY;

        /** {@link ETCSVariables#NID_C} */
        @BitLength(10)
        @OrderIndex(1)
        public int NID_C = ETCSVariables.NID_C;

        /** {@link ETCSVariables#NID_BG} */
        @BitLength(14)
        @OrderIndex(2)
        public int NID_BG = ETCSVariables.NID_BG;

        /** {@link ETCSVariables#D_POSOFF} */
        @BitLength(15)
        @OrderIndex(3)
        public int D_POSOFF = ETCSVariables.D_POSOFF;

        /** {@link ETCSVariables#Q_MPOSITION} */
        @BitLength(1)
        @OrderIndex(4)
        public boolean Q_MPOSITION = ETCSVariables.Q_MPOSITION;

        /** {@link ETCSVariables#M_POSITION} */
        @BitLength(24)
        @OrderIndex(5)
        public int M_POSITION = ETCSVariables.M_POSITION;


        // Constructors

        /**
         * Constructs An Empty {@link Packet_79_Position}
         *
         * @author Christopher Bernjus
         */
        public Packet_79_Position() {}

        /**
         * Constructs A {@link Packet_79_Position}
         *
         * @param Q_NEWCOUNTRY
         *            {@link ETCSVariables#Q_NEWCOUNTRY}
         * @param NID_C
         *            {@link ETCSVariables#NID_C}
         * @param NID_BG
         *            {@link ETCSVariables#NID_BG}
         * @param D_POSOFF
         *            {@link ETCSVariables#D_POSOFF}
         * @param Q_MPOSITION
         *            {@link ETCSVariables#Q_MPOSITION}
         * @param M_POSITION
         *            {@link ETCSVariables#M_POSITION}
         */
        public Packet_79_Position(boolean Q_NEWCOUNTRY, int NID_C, int NID_BG, int D_POSOFF, boolean Q_MPOSITION, int M_POSITION) {
            this.Q_NEWCOUNTRY = Q_NEWCOUNTRY;
            this.NID_C = NID_C;
            this.NID_BG = NID_BG;
            this.D_POSOFF = D_POSOFF;
            this.Q_MPOSITION = Q_MPOSITION;
            this.M_POSITION = M_POSITION;
        }
    }

    // ---------------------------------
    // Geographical Position Information
    // ---------------------------------

    /** First {@link Packet_79_Position} */
    @OrderIndex(4)
    public Packet_79_Position position = new Packet_79_Position();

    /** List Of Additional {@link Packet_79_Position} */
    @OrderIndex(5)
    @ItemType(Packet_79_Position.class)
    public List<Packet_79_Position> positions = new ArrayList<>();


    // Constructors

    /**
     * Constructs An Empty {@link Packet_79}
     *
     * @author Christopher Bernjus
     */
    public Packet_79() { super(79); }

    /**
     * Constructs A {@link Packet_79}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     * @param Q_SCALE
     *            {@link ETCSVariables#Q_SCALE}
     * @param position
     *            {@link Packet_79_Position}
     */
    public Packet_79(int Q_DIR, int Q_SCALE, Packet_79_Position position) {
        super(79, Q_DIR, Q_SCALE);
        this.position = position;
    }
}
