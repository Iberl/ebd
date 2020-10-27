package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * Superclass For Packet_72 And Packet_76
 *
 * Type: Track To Train <br>
 * Subclasses: Event <br>
 * Elements: startevent, endevent
 *
 * @author Christopher Bernjus
 */
public abstract class TextPacket extends TrackPacketSCALE {

    /** Subclass For Handling Start- and Endevents */
    public static class TextPacket_Event {

        /** {@link ETCSVariables#M_MODETEXTDISPLAY} */
        @BitLength(4)
        @OrderIndex(0)
        public int M_MODETEXTDISPLAY = ETCSVariables.M_MODETEXTDISPLAY;

        /** {@link ETCSVariables#M_LEVELTEXTDISPLAY} */
        @BitLength(3)
        @OrderIndex(1)
        public int M_LEVELTEXTDISPLAY = ETCSVariables.M_LEVELTEXTDISPLAY;

            /** {@link ETCSVariables#NID_NTC} */
            @BitLength(8)
            @OrderIndex(2)
            @IfEqual(field = "M_LEVELTEXTDISPLAY", value = ETCSVariables.M_LEVELTEXTDISPLAY_NTC)
            public int NID_NTC = ETCSVariables.NID_NTC;


        // Constructors

        /**
         * Constructs An Empty {@link TextPacket_Event}
         *
         * @author Christopher Bernjus
         */
        public TextPacket_Event() {}

        /**
         * Constructs A {@link TextPacket_Event}
         *
         * @param M_MODETEXTDISPLAY
         *            {@link ETCSVariables#M_MODETEXTDISPLAY}
         * @param M_LEVELTEXTDISPLAY
         *            {@link ETCSVariables#M_LEVELTEXTDISPLAY}
         * @param NID_NTC
         *            {@link ETCSVariables#NID_NTC}
         *
         * @author Christopher Bernjus
         */
        public TextPacket_Event(int M_MODETEXTDISPLAY, int M_LEVELTEXTDISPLAY, int NID_NTC) {
            this.M_MODETEXTDISPLAY = M_MODETEXTDISPLAY;
            this.M_LEVELTEXTDISPLAY = M_LEVELTEXTDISPLAY;
            this.NID_NTC = NID_NTC;
        }


        // Other Functions

        @Override
        public boolean equals(Object object) {
            if(this == object) return true;
            if(object == null || getClass() != object.getClass()) return false;
            TextPacket_Event that = (TextPacket_Event) object;
            return M_MODETEXTDISPLAY == that.M_MODETEXTDISPLAY && M_LEVELTEXTDISPLAY == that.M_LEVELTEXTDISPLAY && NID_NTC == that.NID_NTC;
        }

        @Override
        public String toString() {
            return "TextPacket_Event{"
                   + "M_MODETEXTDISPLAY=" + M_MODETEXTDISPLAY + ", M_LEVELTEXTDISPLAY=" + M_LEVELTEXTDISPLAY
                   + ", NID_NTC=" + NID_NTC
                   + '}';
        }

    }


    // -----------
    // Text Packet
    // -----------

    /** {@link ETCSVariables#Q_TEXTCLASS} */
    @BitLength(2)
    @OrderIndex(4)
    public int Q_TEXTCLASS = ETCSVariables.Q_TEXTCLASS;

    /** {@link ETCSVariables#Q_TEXTDISPLAY} */
    @BitLength(1)
    @OrderIndex(5)
    public boolean Q_TEXTDISPLAY = ETCSVariables.Q_TEXTDISPLAY;

    /** {@link ETCSVariables#Q_TEXTCLASS} */
    @BitLength(15)
    @OrderIndex(6)
    public int D_TEXTDISPLAY = ETCSVariables.D_TEXTDISPLAY;

    /** {@link TextPacket_Event} */
    @OrderIndex(7)
    public TextPacket_Event startevent = new TextPacket_Event();

    /** {@link ETCSVariables#Q_TEXTCLASS} */
    @BitLength(15)
    @OrderIndex(8)
    public int L_TEXTDISPLAY = ETCSVariables.L_TEXTDISPLAY;

    /** {@link ETCSVariables#Q_TEXTCLASS} */
    @BitLength(10)
    @OrderIndex(9)
    public int T_TEXTDISPLAY = ETCSVariables.T_TEXTDISPLAY;

    /** {@link TextPacket_Event} */
    @OrderIndex(10)
    public TextPacket_Event endevent = new TextPacket_Event();

    /** {@link ETCSVariables#Q_TEXTCONFIRM} */
    @BitLength(2)
    @OrderIndex(11)
    public int Q_TEXTCONFIRM = ETCSVariables.Q_TEXTCONFIRM;

        /** {@link ETCSVariables#Q_CONFTEXTDISPLAY} */
        @BitLength(1)
        @OrderIndex(12)
        @IfNotEqual(field = "Q_TEXTCONFIRM", value = ETCSVariables.Q_TEXTCONFIRM_NO_CONF)
        public boolean Q_CONFTEXTDISPLAY = ETCSVariables.Q_CONFTEXTDISPLAY;

        /** {@link ETCSVariables#Q_TEXTREPORT} */
        @BitLength(1)
        @OrderIndex(13)
        @IfNotEqual(field = "Q_TEXTCONFIRM", value = ETCSVariables.Q_TEXTCONFIRM_NO_CONF)
        public boolean Q_TEXTREPORT = ETCSVariables.Q_TEXTREPORT;

            /** {@link ETCSVariables#NID_TEXTMESSAGE} */
            @BitLength(8)
            @OrderIndex(14)
            @IfTrue("Q_TEXTREPORT")
            public int NID_TEXTMESSAGE = ETCSVariables.NID_TEXTMESSAGE;

            /** {@link ETCSVariables#NID_C} */
            @BitLength(10)
            @OrderIndex(15)
            @IfTrue("Q_TEXTREPORT")
            public int NID_C = ETCSVariables.NID_C;

            /** {@link ETCSVariables#NID_RBC} */
            @BitLength(14)
            @OrderIndex(16)
            @IfTrue("Q_TEXTREPORT")
            public int NID_RBC = ETCSVariables.NID_RBC;


    // Constructors

    /**
     * Constructs An Empty {@link TextPacket}
     *
     * @param NID_PACKET
     *            {@link ETCSVariables#NID_PACKET}
     *
     * @author Christopher Bernjus
     */
    public TextPacket(int NID_PACKET) {
        super(NID_PACKET);
    }

    /**
     * Constructs A {@link TextPacket}
     *
     * @param NID_PACKET
     *            {@link ETCSVariables#NID_PACKET}
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     * @param Q_SCALE
     *            {@link ETCSVariables#Q_SCALE}
     * @param Q_TEXTCLASS
     *            {@link ETCSVariables#Q_TEXTCLASS}
     * @param Q_TEXTDISPLAY
     *            {@link ETCSVariables#Q_TEXTDISPLAY}
     * @param D_TEXTDISPLAY
     *            {@link ETCSVariables#D_TEXTDISPLAY}
     * @param startevent
     *            {@link TextPacket_Event}
     * @param L_TEXTDISPLAY
     *            {@link ETCSVariables#L_TEXTDISPLAY}
     * @param T_TEXTDISPLAY
     *            {@link ETCSVariables#T_TEXTDISPLAY}
     * @param endevent
     *            {@link TextPacket_Event}
     * @param Q_TEXTCONFIRM
     *            {@link ETCSVariables#Q_TEXTCONFIRM}
     * @param Q_CONFTEXTDISPLAY
     *            {@link ETCSVariables#Q_CONFTEXTDISPLAY}
     * @param Q_TEXTREPORT
     *            {@link ETCSVariables#Q_TEXTREPORT}
     * @param NID_TEXTMESSAGE
     *            {@link ETCSVariables#NID_TEXTMESSAGE}
     * @param NID_C
     *            {@link ETCSVariables#NID_C}
     * @param NID_RBC
     *            {@link ETCSVariables#NID_RBC}
     *
     * @author Christopher Bernjus
     */
    public TextPacket(int NID_PACKET, int Q_DIR, int Q_SCALE, int Q_TEXTCLASS, boolean Q_TEXTDISPLAY, int D_TEXTDISPLAY, TextPacket_Event startevent, int L_TEXTDISPLAY, int T_TEXTDISPLAY, TextPacket_Event endevent, int Q_TEXTCONFIRM, boolean Q_CONFTEXTDISPLAY, boolean Q_TEXTREPORT, int NID_TEXTMESSAGE, int NID_C, int NID_RBC) {
        super(NID_PACKET, Q_DIR, Q_SCALE);
        this.Q_TEXTCLASS = Q_TEXTCLASS;
        this.Q_TEXTDISPLAY = Q_TEXTDISPLAY;
        this.D_TEXTDISPLAY = D_TEXTDISPLAY;
        this.startevent = startevent;
        this.L_TEXTDISPLAY = L_TEXTDISPLAY;
        this.T_TEXTDISPLAY = T_TEXTDISPLAY;
        this.endevent = endevent;
        this.Q_TEXTCONFIRM = Q_TEXTCONFIRM;
        this.Q_CONFTEXTDISPLAY = Q_CONFTEXTDISPLAY;
        this.Q_TEXTREPORT = Q_TEXTREPORT;
        this.NID_TEXTMESSAGE = NID_TEXTMESSAGE;
        this.NID_C = NID_C;
        this.NID_RBC = NID_RBC;
    }


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        if(!super.equals(object)) return false;
        TextPacket that = (TextPacket) object;
        return Q_TEXTCLASS == that.Q_TEXTCLASS && Q_TEXTDISPLAY == that.Q_TEXTDISPLAY && D_TEXTDISPLAY == that.D_TEXTDISPLAY &&
               L_TEXTDISPLAY == that.L_TEXTDISPLAY && T_TEXTDISPLAY == that.T_TEXTDISPLAY && Q_TEXTCONFIRM == that.Q_TEXTCONFIRM &&
               Q_CONFTEXTDISPLAY == that.Q_CONFTEXTDISPLAY && Q_TEXTREPORT == that.Q_TEXTREPORT && NID_TEXTMESSAGE == that.NID_TEXTMESSAGE &&
               NID_C == that.NID_C && NID_RBC == that.NID_RBC && Objects.equals(startevent, that.startevent) &&
               Objects.equals(endevent, that.endevent);
    }

}
