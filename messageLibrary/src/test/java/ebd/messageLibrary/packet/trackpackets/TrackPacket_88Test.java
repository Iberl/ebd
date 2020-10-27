package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_88Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_88(), "[88:8][0:2][64:13][0:2][0:8][0:15][0:15]0"),
                Arguments.of("Q_DIR: Min", new Packet_88(0, 0, 0, 0, 0, false, 0, false, 0), "[88:8][0:2][64:13][0:2][0:8][0:15][0:15]0"),
                Arguments.of("Q_DIR: Max", new Packet_88(3, 0, 0, 0, 0, false, 0, false, 0), "[88:8][3:2][64:13][0:2][0:8][0:15][0:15]0"),
                Arguments.of("Q_SCALE: Min", new Packet_88(0, 0, 0, 0, 0, false, 0, false, 0), "[88:8][0:2][64:13][0:2][0:8][0:15][0:15]0"),
                Arguments.of("Q_SCALE: Max", new Packet_88(0, 3, 0, 0, 0, false, 0, false, 0), "[88:8][0:2][64:13][3:2][0:8][0:15][0:15]0"),
                Arguments.of("NID_LX: Min", new Packet_88(0, 0, 0, 0, 0, false, 0, false, 0), "[88:8][0:2][64:13][0:2][0:8][0:15][0:15]0"),
                Arguments.of("NID_LX: Max", new Packet_88(0, 0, 255, 0, 0, false, 0, false, 0), "[88:8][0:2][64:13][0:2][255:8][0:15][0:15]0"),
                Arguments.of("D_LX: Min", new Packet_88(0, 0, 0, 0, 0, false, 0, false, 0), "[88:8][0:2][64:13][0:2][0:8][0:15][0:15]0"),
                Arguments.of("D_LX: Max", new Packet_88(0, 0, 0, 32767, 0, false, 0, false, 0), "[88:8][0:2][64:13][0:2][0:8][32767:15][0:15]0"),
                Arguments.of("L_LX: Min", new Packet_88(0, 0, 0, 0, 0, false, 0, false, 0), "[88:8][0:2][64:13][0:2][0:8][0:15][0:15]0"),
                Arguments.of("L_LX: Max", new Packet_88(0, 0, 0, 0, 32767, false, 0, false, 0), "[88:8][0:2][64:13][0:2][0:8][0:15][32767:15]0"),
                Arguments.of("Q_LXSTATUS: False", new Packet_88(0, 0, 0, 0, 0, false, 0, false, 0), "[88:8][0:2][64:13][0:2][0:8][0:15][0:15]0"),
                Arguments.of("Q_LXSTATUS: True", new Packet_88(0, 0, 0, 0, 0, true, 0, false, 0), "[88:8][0:2][72:13][0:2][0:8][0:15][0:15]1[0:7]0"),
                Arguments.of("V_LX: Min", new Packet_88(0, 0, 0, 0, 0, true, 0, false, 0), "[88:8][0:2][72:13][0:2][0:8][0:15][0:15]1[0:7]0"),
                Arguments.of("V_LX: Max", new Packet_88(0, 0, 0, 0, 0, true, 127, false, 0), "[88:8][0:2][72:13][0:2][0:8][0:15][0:15]1[127:7]0"),
                Arguments.of("Q_STOPLX: False", new Packet_88(0, 0, 0, 0, 0, true, 0, false, 0), "[88:8][0:2][72:13][0:2][0:8][0:15][0:15]1[0:7]0"),
                Arguments.of("Q_STOPLX: True", new Packet_88(0, 0, 0, 0, 0, true, 0, true, 0), "[88:8][0:2][87:13][0:2][0:8][0:15][0:15]1[0:7]1[0:15]"),
                Arguments.of("L_STOPLX: Min", new Packet_88(0, 0, 0, 0, 0, true, 0, true, 0), "[88:8][0:2][87:13][0:2][0:8][0:15][0:15]1[0:7]1[0:15]"),
                Arguments.of("L_STOPLX; Max", new Packet_88(0, 0, 0, 0, 0, true, 0, true, 32767), "[88:8][0:2][87:13][0:2][0:8][0:15][0:15]1[0:7]1[32767:15]"),
                Arguments.of("all", new Packet_88(1, 2, 32, 2384, 6192, true, 123, true, 327), "[88:8][1:2][87:13][2:2][32:8][2384:15][6192:15]1[123:7]1[327:15]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_88(4, 0, 0, 0, 0, false, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("Q_SCALE: Overflow", new Packet_88(0, 4, 0, 0, 0, false, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_LX: Overflow", new Packet_88(0, 0, 256, 0, 0, false, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("D_LX: Overflow", new Packet_88(0, 0, 0, 32768, 0, false, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("L_LX: Overflow", new Packet_88(0, 0, 0, 0, 32768, false, 0, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                // Q_LXSTATUS is a boolean -> no overflow test needed
                Arguments.of("V_LX: Overflow", new Packet_88(0, 0, 0, 0, 0, true, 128, false, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                // Q_STOPLX is a boolean -> no overflow test needed
                Arguments.of("L_STOPLX: Overflow", new Packet_88(0, 0, 0, 0, 0, true, 0, true, 32768), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}