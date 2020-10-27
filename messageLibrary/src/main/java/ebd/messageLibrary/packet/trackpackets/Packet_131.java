package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.NumberOfDigits;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 131 <br>
 * Type: Track To Train <br>
 * Description: RBC Transition Order <br>
 * Transmitted By: Balise, RBC
 *
 * @author Christopher Bernjus
 */
public class Packet_131 extends TrackPacketSCALE {

    // --------------------
    // RBC Transition Order
    // --------------------

    /** {@link ETCSVariables#D_RBCTR} */
    @BitLength(15)
    @OrderIndex(4)
    public int D_RBCTR = ETCSVariables.D_RBCTR;

    /** {@link ETCSVariables#NID_C} */
    @BitLength(10)
    @OrderIndex(5)
    public int NID_C = ETCSVariables.NID_C;

    /** {@link ETCSVariables#NID_RBC} */
    @BitLength(14)
    @OrderIndex(6)
    public int NID_RBC = ETCSVariables.NID_RBC;

    /** {@link ETCSVariables#NID_RADIO} */
    @NumberOfDigits(16)
    @OrderIndex(7)
    public BinaryCodedDecimal NID_RADIO = ETCSVariables.NID_RADIO;

    /** {@link ETCSVariables#Q_SLEEPSESSION} */
    @BitLength(1)
    @OrderIndex(8)
    public boolean Q_SLEEPSESSION = ETCSVariables.Q_SLEEPSESSION;


    // Constructors

    /**
     * Constructs An Empty {@link Packet_131}
     *
     * @author Christopher Bernjus
     */
    public Packet_131() { super(131); }

    /**
     * Construct A {@link Packet_131}
     *
     *  @param Q_DIR
     *             {@link ETCSVariables#Q_DIR}
     * 	@param Q_SCALE
     * 	           {@link ETCSVariables#Q_SCALE}
     * @param D_RBCTR
     * 	           {@link ETCSVariables#D_RBCTR}
     * @param NID_C
     * 	           {@link ETCSVariables#NID_C}
     * @param NID_RBC
     * 	           {@link ETCSVariables#NID_RBC}
     * @param NID_RADIO
     * 	           {@link ETCSVariables#NID_RADIO}
     * @param Q_SLEEPSESSION
     * 	           {@link ETCSVariables#Q_SLEEPSESSION}
     *
     * @author Christopher Bernjus
     */
    public Packet_131(int Q_DIR, int Q_SCALE, int D_RBCTR, int NID_C, int NID_RBC, BinaryCodedDecimal NID_RADIO, boolean Q_SLEEPSESSION) {
        super(131, Q_DIR, Q_SCALE);
        this.D_RBCTR = D_RBCTR;
        this.NID_C = NID_C;
        this.NID_RBC = NID_RBC;
        this.NID_RADIO = NID_RADIO;
        this.Q_SLEEPSESSION = Q_SLEEPSESSION;
    }


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        if(!super.equals(object)) return false;
        Packet_131 that = (Packet_131) object;
        return D_RBCTR == that.D_RBCTR && NID_C == that.NID_C && NID_RBC == that.NID_RBC && Q_SLEEPSESSION == that.Q_SLEEPSESSION &&
               Objects.equals(NID_RADIO, that.NID_RADIO);
    }

    @Override
    public String toString() {
        return "Packet_131{"
               + "NID_PACKET=" + NID_PACKET
               + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
               + ", Q_SCALE=" + Q_SCALE
               + ", D_RBCTR=" + D_RBCTR + ", NID_C=" + NID_C + ", NID_RBC=" + NID_RBC
               + ", NID_RADIO=" + NID_RADIO.toString()
               + ", Q_SLEEPSESSION=" + Q_SLEEPSESSION
               + '}';
    }

}
