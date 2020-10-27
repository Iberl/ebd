package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_180Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_180(), "[180:8][0:2][24:13]0"),
                Arguments.of("Q_DIR: Min", new Packet_180(0, false, 0), "[180:8][0:2][24:13]0"),
                Arguments.of("Q_DIR: Max", new Packet_180(3, false, 0), "[180:8][3:2][24:13]0"),
                Arguments.of("Q_LSSMA: False", new Packet_180(0, false, 0), "[180:8][0:2][24:13]0"),
                Arguments.of("Q_LSSMA: True", new Packet_180(0, true, 0), "[180:8][0:2][32:13]1[0:8]"),
                Arguments.of("T_LSSMA: Min", new Packet_180(0, true, 0), "[180:8][0:2][32:13]1[0:8]"),
                Arguments.of("T_LSSMA: Max", new Packet_180(0, true, 255), "[180:8][0:2][32:13]1[255:8]"),
                Arguments.of("all", new Packet_180(1, true, 147), "[180:8][1:2][32:13]1[147:8]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_180(4, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                // Q_LSSMA is a boolean -> no overflow test needed
                Arguments.of("T_LSSMA: Overflow", new Packet_180(0, true, 256), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}