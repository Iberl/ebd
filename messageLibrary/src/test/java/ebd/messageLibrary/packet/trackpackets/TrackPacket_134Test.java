package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_134Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_134(), "[134:8][0:2][72:13][0:2][0:14][0:14][0:14]0[0:4]"),
                Arguments.of("Q_DIR: Min", new Packet_134(0, 0, 0, 0, 0, false, 0), "[134:8][0:2][72:13][0:2][0:14][0:14][0:14]0[0:4]"),
                Arguments.of("Q_DIR: Max", new Packet_134(3, 0, 0, 0, 0, false, 0), "[134:8][3:2][72:13][0:2][0:14][0:14][0:14]0[0:4]"),
                Arguments.of("Q_SCALE: Min", new Packet_134(0, 0, 0, 0, 0, false, 0), "[134:8][0:2][72:13][0:2][0:14][0:14][0:14]0[0:4]"),
                Arguments.of("Q_SCALE: Max", new Packet_134(0, 3, 0, 0, 0, false, 0), "[134:8][0:2][72:13][3:2][0:14][0:14][0:14]0[0:4]"),
                Arguments.of("NID_LOOP: Min", new Packet_134(0, 0, 0, 0, 0, false, 0), "[134:8][0:2][72:13][0:2][0:14][0:14][0:14]0[0:4]"),
                Arguments.of("NID_LOOP: Max", new Packet_134(0, 0, 16383, 0, 0, false, 0), "[134:8][0:2][72:13][0:2][16383:14][0:14][0:14]0[0:4]"),
                Arguments.of("D_LOOP: Min", new Packet_134(0, 0, 0, 0, 0, false, 0), "[134:8][0:2][72:13][0:2][0:14][0:14][0:14]0[0:4]"),
                Arguments.of("D_LOOP: Max", new Packet_134(0, 0, 0, 16383, 0, false, 0), "[134:8][0:2][72:13][0:2][0:14][16383:14][0:14]0[0:4]"),
                Arguments.of("L_LOOP: Min", new Packet_134(0, 0, 0, 0, 0, false, 0), "[134:8][0:2][72:13][0:2][0:14][0:14][0:14]0[0:4]"),
                Arguments.of("L_LOOP: Max", new Packet_134(0, 0, 0, 0, 16383, false, 0), "[134:8][0:2][72:13][0:2][0:14][0:14][16383:14]0[0:4]"),
                Arguments.of("Q_LOOPDIR: False", new Packet_134(0, 0, 0, 0, 0, false, 0), "[134:8][0:2][72:13][0:2][0:14][0:14][0:14]0[0:4]"),
                Arguments.of("Q_LOOPDIR: True", new Packet_134(0, 0, 0, 0, 0, true, 0), "[134:8][0:2][72:13][0:2][0:14][0:14][0:14]1[0:4]"),
                Arguments.of("Q_SSCODE: Min", new Packet_134(0, 0, 0, 0, 0, false, 0), "[134:8][0:2][72:13][0:2][0:14][0:14][0:14]0[0:4]"),
                Arguments.of("Q_SSCODE: Max", new Packet_134(0, 0, 0, 0, 0, false, 15), "[134:8][0:2][72:13][0:2][0:14][0:14][0:14]0[15:4]"),
                Arguments.of("all", new Packet_134(2, 2, 15000, 3070, 3238, false, 5), "[134:8][2:2][72:13][2:2][15000:14][3070:14][3238:14]0[5:4]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_134(4, 0, 0, 0, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("Q_SCALE: Overflow", new Packet_134(0, 4, 0, 0, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_LOOP: Overflow", new Packet_134(0, 0, 16384, 0, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("D_LOOP: Overflow", new Packet_134(0, 0, 0, 16384, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("L_LOOP: Overflow", new Packet_134(0, 0, 0, 0, 16384, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                // Q_LOOPDIR is a boolean -> no overflow test needed
                Arguments.of("Q_SSCODE: Overflow", new Packet_134(0, 0, 0, 0, 0, false, 16), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}