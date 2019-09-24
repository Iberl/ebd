package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;

import java.util.ArrayList;
import java.util.List;

import ebd.messageLibrary.util.ETCSVariables;

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

    /** List Of {@link ETCSVariables#NID_RADIO}s */
    @OrderIndex(1)
    @ItemType(Long.class)
    public List<Long> numbers = new ArrayList<Long>();

    /**
     * Constructs An Empty {@link Packet_3}
     *
     * @author Christopher Bernjus
     */
    public Packet_3() {
        super(3);
    }

}
