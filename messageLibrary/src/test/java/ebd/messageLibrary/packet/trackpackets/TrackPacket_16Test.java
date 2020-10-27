package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_16Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_16(), "[16:8][0:2][40:13][0:2][0:15]"),
                Arguments.of("Q_DIR: Min", new Packet_16(0, 0, 0), "[16:8][0:2][40:13][0:2][0:15]"),
                Arguments.of("Q_DIR: Max", new Packet_16(3, 0, 0), "[16:8][3:2][40:13][0:2][0:15]"),
                Arguments.of("Q_SCALE: Min", new Packet_16(0, 0, 0), "[16:8][0:2][40:13][0:2][0:15]"),
                Arguments.of("Q_SCALE: Max", new Packet_16(0, 3, 0), "[16:8][0:2][40:13][3:2][0:15]"),
                Arguments.of("L_SECTION: Min", new Packet_16(0, 0, 0), "[16:8][0:2][40:13][0:2][0:15]"),
                Arguments.of("L_SECTION: Max", new Packet_16(0, 0, 32767), "[16:8][0:2][40:13][0:2][32767:15]"),
                Arguments.of("all", new Packet_16(1, 2, 6723), "[16:8][1:2][40:13][2:2][6723:15]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_16(4, 0,0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("Q_SCALE: Overflow", new Packet_16(0, 4,0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("L_SECTION: Overflow", new Packet_16(0, 0,32768), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}