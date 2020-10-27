package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.NumberOfDigits;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 3 <br>
 * Type: Train To Track <br>
 * Description: Onboard Telephone Numbers <br>
 * Transmitted To: RBC <br>
 * Lists: numbers
 *
 * @author Christopher Bernjus
 */
public class Packet_3 extends TrainPacket {

    /** Subclass For Handling Iterated Numbers */
    public static class Packet_3_Number {

        /** {@link ETCSVariables#NID_RADIO} */
        @NumberOfDigits(16)
        @OrderIndex(0)
        public BinaryCodedDecimal NID_RADIO = ETCSVariables.NID_RADIO;


        // Constructors

        /**
         * Constructs An Empty {@link Packet_3_Number}
         *
         * @author Christopher Bernjus
         */
        public Packet_3_Number() {}

        /**
         * Constructs A {@link Packet_3_Number}
         *
         * @param NID_RADIO
         *         {@link ETCSVariables#NID_RADIO}
         */
        public Packet_3_Number(BinaryCodedDecimal NID_RADIO) {
            this.NID_RADIO = NID_RADIO;
        }


        // Other Functions

        @Override
        public boolean equals(Object object) {
            if(this == object) return true;
            if(object == null || getClass() != object.getClass()) return false;
            Packet_3_Number that = (Packet_3_Number) object;
            return Objects.equals(NID_RADIO, that.NID_RADIO);
        }

        @Override
        public String toString() {
            return "Packet_3_Number{"
                   + "NID_RADIO=" + NID_RADIO.toString()
                   + '}';
        }

    }

    // -------------------------
    // Onboard Telephone Numbers
    // -------------------------

    /** List Of {@link Packet_3_Number}s */
    @OrderIndex(2)
    @ItemType(Packet_3_Number.class)
    public List<Packet_3_Number> numbers = new ArrayList<>();


    // Constructors

    /**
     * Constructs A {@link Packet_3}
     *
     * @author Christopher Bernjus
     */
    public Packet_3() {
        super(3);
    }


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        if(!super.equals(object)) return false;
        Packet_3 packet_3 = (Packet_3) object;
        return numbers.equals(packet_3.numbers);
    }

    @Override
    public String toString() {
        return "Packet_3{"
               + "NID_PACKET=" + NID_PACKET
               + ", L_PACKET=" + L_PACKET
               + ", numbers=" + numbers.toString()
               + '}';
    }

}
