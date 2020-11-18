package ebd.baliseTelegramGenerator;

import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_0;
import ebd.messageLibrary.util.ETCSVariables;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static ebd.messageLibrary.util.ETCSVariables.*;

public class Balise {

    // x Model of a Eurobalise
    // x Holds simple information contained in just one balise

	//TODO Q_UPDOWN

    private int M_DUP;

    public int M_MCOUNT;

    @Nullable
    public Packet_0 packet_0 = null;

    public List<TrackPacket> packets = new ArrayList<TrackPacket>();


    // Constructors

    public Balise() {}

    public Balise(int M_DUP, int M_MCOUNT, @Nullable Packet_0 packet_0) {
        this.M_DUP = M_DUP;
        this.M_MCOUNT = M_MCOUNT;
        this.packet_0 = packet_0;
    }

    // methods

    public boolean isDuplicate() {
        return M_DUP > 0 && M_DUP <= 3;
    }

    public int getM_DUP() { return M_DUP; }

    public boolean setM_DUP(int M_DUP) {
        switch(M_DUP) {
            case M_DUP_NO_DUPLICATE:
            	this.M_DUP = M_DUP;
                return true;
            case M_DUP_NEXT_BALISE:
                if(this.M_DUP == ETCSVariables.M_DUP_PREV_BALISE) { return false; }
                this.M_DUP = M_DUP;
                return true;
            case M_DUP_PREV_BALISE:
                if(this.M_DUP == ETCSVariables.M_DUP_NEXT_BALISE) { return false; }
                this.M_DUP = M_DUP;
                return true;
            default: return false;
        }
    }

}
