package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_65Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_65(), "[65:8][0:2][71:13][0:2][0:8][0:15][0:15]0[0:7]"),
                Arguments.of("Q_DIR: Min", new Packet_65(0, 0, 0, 0, 0, false, 0), "[65:8][0:2][71:13][0:2][0:8][0:15][0:15]0[0:7]"),
                Arguments.of("Q_DIR: Max", new Packet_65(3, 0, 0, 0, 0, false, 0), "[65:8][3:2][71:13][0:2][0:8][0:15][0:15]0[0:7]"),
                Arguments.of("Q_SCALE: Min", new Packet_65(0, 0, 0, 0, 0, false, 0), "[65:8][0:2][71:13][0:2][0:8][0:15][0:15]0[0:7]"),
                Arguments.of("Q_SCALE: Max", new Packet_65(0, 3, 0, 0, 0, false, 0), "[65:8][0:2][71:13][3:2][0:8][0:15][0:15]0[0:7]"),
                Arguments.of("NID_TSR: Min", new Packet_65(0, 0, 0, 0, 0, false, 0), "[65:8][0:2][71:13][0:2][0:8][0:15][0:15]0[0:7]"),
                Arguments.of("NID_TSR: Max", new Packet_65(0, 0, 255, 0, 0, false, 0), "[65:8][0:2][71:13][0:2][255:8][0:15][0:15]0[0:7]"),
                Arguments.of("D_TSR: Min", new Packet_65(0, 0, 0, 0, 0, false, 0), "[65:8][0:2][71:13][0:2][0:8][0:15][0:15]0[0:7]"),
                Arguments.of("D_TSR: Max", new Packet_65(0, 0, 0, 32767, 0, false, 0), "[65:8][0:2][71:13][0:2][0:8][32767:15][0:15]0[0:7]"),
                Arguments.of("L_TSR: Min", new Packet_65(0, 0, 0, 0, 0, false, 0), "[65:8][0:2][71:13][0:2][0:8][0:15][0:15]0[0:7]"),
                Arguments.of("L_TSR: Max", new Packet_65(0, 0, 0, 0, 32767, false, 0), "[65:8][0:2][71:13][0:2][0:8][0:15][32767:15]0[0:7]"),
                Arguments.of("Q_FRONT: False", new Packet_65(0, 0, 0, 0, 0, false, 0), "[65:8][0:2][71:13][0:2][0:8][0:15][0:15]0[0:7]"),
                Arguments.of("Q_FRONT: True", new Packet_65(0, 0, 0, 0, 0, true, 0), "[65:8][0:2][71:13][0:2][0:8][0:15][0:15]1[0:7]"),
                Arguments.of("V_TSR: Min", new Packet_65(0, 0, 0, 0, 0, false, 0), "[65:8][0:2][71:13][0:2][0:8][0:15][0:15]0[0:7]"),
                Arguments.of("V_TSR: Max", new Packet_65(0, 0, 0, 0, 0, false, 127), "[65:8][0:2][71:13][0:2][0:8][0:15][0:15]0[127:7]"),
                Arguments.of("all", new Packet_65(2, 1, 231, 18314, 9245, true, 87), "[65:8][2:2][71:13][1:2][231:8][18314:15][9245:15]1[87:7]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_65(4, 0, 0, 0, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("Q_SCALE: Overflow", new Packet_65(0, 4, 0, 0, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_TSR: Overflow", new Packet_65(0, 0, 256, 0, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("D_TSR: Overflow", new Packet_65(0, 0, 0, 32768, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("L_TSR: Overflow", new Packet_65(0, 0, 0, 0, 32768, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                // Q_FRONT is a boolean -> overflow test not needed
                Arguments.of("V_TSR: Overflow", new Packet_65(0, 0, 0, 0, 0, false, 128), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}