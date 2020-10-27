package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_57Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_57(), "[57:8][0:2][49:13][0:8][0:10][0:8]"),
                Arguments.of("Q_DIR: Min", new Packet_57(0, 0, 0, 0), "[57:8][0:2][49:13][0:8][0:10][0:8]"),
                Arguments.of("Q_DIR: Max", new Packet_57(3, 0, 0, 0), "[57:8][3:2][49:13][0:8][0:10][0:8]"),
                Arguments.of("T_MAR: Min", new Packet_57(0, 0, 0, 0), "[57:8][0:2][49:13][0:8][0:10][0:8]"),
                Arguments.of("T_MAR: Max", new Packet_57(0, 255, 0, 0), "[57:8][0:2][49:13][255:8][0:10][0:8]"),
                Arguments.of("T_TIMEOUTRQST: Min", new Packet_57(0, 0, 0, 0), "[57:8][0:2][49:13][0:8][0:10][0:8]"),
                Arguments.of("T_TIMEOUTRQST: Max", new Packet_57(0, 0, 1023, 0), "[57:8][0:2][49:13][0:8][1023:10][0:8]"),
                Arguments.of("T_CYCRQST: Min", new Packet_57(0, 0, 0, 0), "[57:8][0:2][49:13][0:8][0:10][0:8]"),
                Arguments.of("T_CYCRQST: Max", new Packet_57(0, 0, 0, 255), "[57:8][0:2][49:13][0:8][0:10][255:8]"),
                Arguments.of("all", new Packet_57(2, 84, 547,44), "[57:8][2:2][49:13][84:8][547:10][44:8]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_57(4, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("T_MAR: Overflow", new Packet_57(0, 256, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("T_TIMEOUTRQST: Overflow", new Packet_57(0, 0, 1024, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("T_CYCRQST: Overflow", new Packet_57(0, 0, 0, 256), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}