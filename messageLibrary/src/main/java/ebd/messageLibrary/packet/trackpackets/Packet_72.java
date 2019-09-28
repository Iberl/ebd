package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 72 <br>
 * Type: Track To Train <br>
 * Description: Sending Plain Text Messages <br>
 * Transmitted By: Balise, RBC <br>
 * Subclasses: Event <br>
 * Elements: startevent, endevent
 *
 * @author Christopher Bernjus
 */
@OrderLength(21)
public class Packet_72 extends TextPacket {

    // ---------------------------
    // Sending Plain Text Messages
    // ---------------------------

    /** {@link ETCSVariables#X_TEXT} */
    @OrderIndex(20)
    @ItemType(Byte.class)
    public List<Byte> X_TEXT = new ArrayList<>();


    // Constructors

    /**
     * Constructs An Empty {@link Packet_72}
     *
     * @author Christopher Bernjus
     */
    public Packet_72() { super(72); }

    /**
     * Constructs A {@link Packet_72}
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
    public Packet_72(int NID_PACKET, int Q_DIR, int Q_SCALE, int Q_TEXTCLASS, boolean Q_TEXTDISPLAY, int D_TEXTDISPLAY, TextPacket_Event startevent, int L_TEXTDISPLAY, int T_TEXTDISPLAY, TextPacket_Event endevent, int Q_TEXTCONFIRM, boolean Q_CONFTEXTDISPLAY, boolean Q_TEXTREPORT, int NID_TEXTMESSAGE, int NID_C, int NID_RBC) {
        super(NID_PACKET, Q_DIR, Q_SCALE, Q_TEXTCLASS, Q_TEXTDISPLAY, D_TEXTDISPLAY, startevent, L_TEXTDISPLAY, T_TEXTDISPLAY, endevent, Q_TEXTCONFIRM, Q_CONFTEXTDISPLAY, Q_TEXTREPORT, NID_TEXTMESSAGE, NID_C, NID_RBC);
    }
}
