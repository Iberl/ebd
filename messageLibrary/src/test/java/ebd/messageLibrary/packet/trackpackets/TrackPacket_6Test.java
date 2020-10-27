package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_6Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_6(), "[6:8][0:2][40:13]0[0:6][0:10]"),
                Arguments.of("Q_DIR: Min", new Packet_6(0, false, 0, 0, 0), "[6:8][0:2][40:13]0[0:6][0:10]"),
                Arguments.of("Q_DIR: Max", new Packet_6(3, false, 0, 0, 0), "[6:8][3:2][40:13]0[0:6][0:10]"),
                Arguments.of("Q_VBCO: False", new Packet_6(0, false, 0, 0, 0), "[6:8][0:2][40:13]0[0:6][0:10]"),
                Arguments.of("Q_VBCO: True", new Packet_6(0, true, 0, 0, 0), "[6:8][0:2][48:13]1[0:6][0:10][0:8]"),
                Arguments.of("NID_VBCMK: Min", new Packet_6(0, false, 0, 0, 0), "[6:8][0:2][40:13]0[0:6][0:10]"),
                Arguments.of("NID_VBCMK: Max", new Packet_6(0, false, 63, 0, 0), "[6:8][0:2][40:13]0[63:6][0:10]"),
                Arguments.of("NID_C: Min", new Packet_6(0, false, 0, 0, 0), "[6:8][0:2][40:13]0[0:6][0:10]"),
                Arguments.of("NID_C: Max", new Packet_6(0, false, 0, 1023, 0), "[6:8][0:2][40:13]0[0:6][1023:10]"),
                Arguments.of("T_VBC: Min", new Packet_6(0, true, 0, 0, 0), "[6:8][0:2][48:13]1[0:6][0:10][0:8]"),
                Arguments.of("T_VBC: Max", new Packet_6(0, true, 0, 0, 255), "[6:8][0:2][48:13]1[0:6][0:10][255:8]"),
                Arguments.of("all", new Packet_6(2, true, 43, 102, 53), "[6:8][2:2][48:13]1[43:6][102:10][53:8]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_6(4, false, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                // Q_VBCO is a boolean -> overflow test not needed
                Arguments.of("NID_VBCMK: Overflow", new Packet_6(0, false, 64, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_C: Overflow", new Packet_6(0, false, 0, 1024, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("T_VBC: Overflow", new Packet_6(0, true, 0, 0, 256), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}