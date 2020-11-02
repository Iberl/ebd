package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_138Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_138(), "[138:8][0:2][53:13][0:15][0:15]"),
                Arguments.of("Q_DIR: Min", new Packet_138(0, 0, 0), "[138:8][0:2][53:13][0:15][0:15]"),
                Arguments.of("Q_DIR: Max", new Packet_138(3, 0, 0), "[138:8][3:2][53:13][0:15][0:15]"),
                Arguments.of("D_STARTREVERSE: Min", new Packet_138(0, 0, 0), "[138:8][0:2][53:13][0:15][0:15]"),
                Arguments.of("D_STARTREVERSE: Max", new Packet_138(0, 32767, 0), "[138:8][0:2][53:13][32767:15][0:15]"),
                Arguments.of("L_REVERSEAREA: Min", new Packet_138(0, 0, 0), "[138:8][0:2][53:13][0:15][0:15]"),
                Arguments.of("L_REVERSEAREA: Max", new Packet_138(0, 0, 32767), "[138:8][0:2][53:13][0:15][32767:15]"),
                Arguments.of("all", new Packet_138(1, 842, 6328), "[138:8][01:2][53:13][842:15][6328:15]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_138(4, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("D_STARTREVERSE: Overflow", new Packet_138(0, 32768, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("L_REVERSEAREA: Overflow", new Packet_138(0, 0, 32768), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}