package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 76 <br>
 * Type: Track To Train <br>
 * Description: Sending Fixed Text Messages <br>
 * Transmitted By: Balise, RBC <br>
 * Subclasses: Event <br>
 * Elements: startevent, endevent
 *
 * @author Christopher Bernjus
 */
public class Packet_76 extends TextPacket {

    // ---------------------------
    // Sending Fixed Text Messages
    // ---------------------------

    /** {@link ETCSVariables#Q_TEXT} */
    @BitLength(8)
    @OrderIndex(17)
    public int Q_TEXT = ETCSVariables.Q_TEXT;


    // Constructors

    /**
     * Constructs An Empty {@link Packet_76}
     *
     * @author Christopher Bernjus
     */
    public Packet_76() { super(76); }

    /**
     * Constructs A {@link Packet_76}
     *
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
     * @param Q_TEXT
     *            {@link ETCSVariables#Q_TEXT}
     *
     * @author Christopher Bernjus
     */
    public Packet_76(int Q_DIR, int Q_SCALE, int Q_TEXTCLASS, boolean Q_TEXTDISPLAY, int D_TEXTDISPLAY, TextPacket_Event startevent, int L_TEXTDISPLAY, int T_TEXTDISPLAY, TextPacket_Event endevent, int Q_TEXTCONFIRM, boolean Q_CONFTEXTDISPLAY, boolean Q_TEXTREPORT, int NID_TEXTMESSAGE, int NID_C, int NID_RBC, int Q_TEXT) {
        super(76, Q_DIR, Q_SCALE, Q_TEXTCLASS, Q_TEXTDISPLAY, D_TEXTDISPLAY, startevent, L_TEXTDISPLAY, T_TEXTDISPLAY, endevent, Q_TEXTCONFIRM, Q_CONFTEXTDISPLAY, Q_TEXTREPORT, NID_TEXTMESSAGE, NID_C, NID_RBC);
        this.Q_TEXT = Q_TEXT;
    }


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        if(!super.equals(object)) return false;
        Packet_76 packet_76 = (Packet_76) object;
        return Q_TEXT == packet_76.Q_TEXT;
    }

    @Override
    public String toString() {
        return "Packet_76{"
               + "NID_PACKET=" + NID_PACKET
               + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
               + ", Q_SCALE=" + Q_SCALE
               + ", Q_TEXTCLASS=" + Q_TEXTCLASS + ", Q_TEXTDISPLAY=" + Q_TEXTDISPLAY + ", D_TEXTDISPLAY=" + D_TEXTDISPLAY
               + ", startevent=" + startevent.toString()
               + ", L_TEXTDISPLAY=" + L_TEXTDISPLAY + ", T_TEXTDISPLAY=" + T_TEXTDISPLAY
               + ", endevent=" + endevent.toString()
               + ", Q_TEXTCONFIRM=" + Q_TEXTCONFIRM + ", Q_CONFTEXTDISPLAY=" + Q_CONFTEXTDISPLAY + ", Q_TEXTREPORT=" + Q_TEXTREPORT
               + ", NID_TEXTMESSAGE=" + NID_TEXTMESSAGE + ", NID_C=" + NID_C + ", NID_RBC=" + NID_RBC
               + ", Q_TEXT=" + Q_TEXT
               + '}';
    }

}
