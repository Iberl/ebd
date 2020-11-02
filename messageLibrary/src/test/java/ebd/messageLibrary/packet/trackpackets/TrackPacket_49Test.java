package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_49Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_49(), "[49:8][0:2][28:13][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_49(0), "[49:8][0:2][28:13][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_49(3), "[49:8][3:2][28:13][0:5]"),

                Arguments.of("balises: Empty", new Packet_49(), "[49:8][0:2][28:13][0:5]"),
                Arguments.of("balises: 1 Element", fill(new Packet_49(), new BaliseListPacket.BaliseListPacket_Balise(), 1), "[49:8][0:2][43:13][1:5]{0[0:14]*1}"),
                Arguments.of("balises: Q_NEWCOUNTRY: False", fill(new Packet_49(), new BaliseListPacket.BaliseListPacket_Balise(false, 0, 0), 1), "[49:8][0:2][43:13][1:5]{0[0:14]*1}"),
                Arguments.of("balises: Q_NEWCOUNTRY: True", fill(new Packet_49(), new BaliseListPacket.BaliseListPacket_Balise(true, 0, 0), 1), "[49:8][0:2][53:13][1:5]{1[0:10][0:14]*1}"),
                Arguments.of("balises: NID_C: Min", fill(new Packet_49(), new BaliseListPacket.BaliseListPacket_Balise(true, 0, 0), 1), "[49:8][0:2][53:13][1:5]{1[0:10][0:14]*1}"),
                Arguments.of("balises: NID_C: Max", fill(new Packet_49(), new BaliseListPacket.BaliseListPacket_Balise(true, 1023, 0), 1), "[49:8][0:2][53:13][1:5]{1[1023:10][0:14]*1}"),
                Arguments.of("balises: NID_BG: Min", fill(new Packet_49(), new BaliseListPacket.BaliseListPacket_Balise(false, 0, 0), 1), "[49:8][0:2][43:13][1:5]{0[0:14]*1}"),
                Arguments.of("balises: NID_BG: Max", fill(new Packet_49(), new BaliseListPacket.BaliseListPacket_Balise(false, 0, 16383), 1), "[49:8][0:2][43:13][1:5]{0[16383:14]*1}"),
                Arguments.of("balises: 1+ Elements", fill(new Packet_49(), new BaliseListPacket.BaliseListPacket_Balise(false, 0, 0), 2), "[49:8][0:2][58:13][2:5]{0[0:14]*2}"),
                Arguments.of("balises: Max Elements", fill(new Packet_49(), new BaliseListPacket.BaliseListPacket_Balise(false, 0, 0), 31), "[49:8][0:2][493:13][31:5]{0[0:14]*31}"),

                Arguments.of("all", fill(new Packet_49(2), new BaliseListPacket.BaliseListPacket_Balise(true, 723, 5311), 1), "[49:8][2:2][53:13][1:5]{1[723:10][5311:14]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_49(4), new IllegalArgumentException("Invalid value for given bit length")),
                // balises: Q_NEWCOUNTRY is a boolean -> no overflow test needed
                Arguments.of("balises: NID_C: Overflow", fill(new Packet_49(), new BaliseListPacket.BaliseListPacket_Balise(true, 1024, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("balises: NID_BG: Overflow", fill(new Packet_49(), new BaliseListPacket.BaliseListPacket_Balise(false, 0, 16384), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_49 fill(Packet_49 packet_49, BaliseListPacket.BaliseListPacket_Balise balise, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_49.balises.add(balise);
        }
        return packet_49;
    }
}