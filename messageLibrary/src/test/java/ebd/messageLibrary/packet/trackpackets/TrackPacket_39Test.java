package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_39Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_39(), "[39:8][0:2][44:13][0:2][0:15][0:4]"),
                Arguments.of("Q_DIR: Min", new Packet_39(0, 0, 0, 0, 0), "[39:8][0:2][44:13][0:2][0:15][0:4]"),
                Arguments.of("Q_DIR: Max", new Packet_39(3, 0, 0, 0, 0), "[39:8][3:2][44:13][0:2][0:15][0:4]"),
                Arguments.of("Q_SCALE: Min", new Packet_39(0, 0, 0, 0, 0), "[39:8][0:2][44:13][0:2][0:15][0:4]"),
                Arguments.of("Q_SCALE: Max", new Packet_39(0, 3, 0, 0, 0), "[39:8][0:2][44:13][3:2][0:15][0:4]"),
                Arguments.of("D_TRACTION: Min", new Packet_39(0, 0, 0, 0, 0), "[39:8][0:2][44:13][0:2][0:15][0:4]"),
                Arguments.of("D_TRACTION: Max", new Packet_39(0, 0, 32767, 0, 0), "[39:8][0:2][44:13][0:2][32767:15][0:4]"),
                Arguments.of("M_VOLTAGE: Min", new Packet_39(0, 0, 0, 0, 0), "[39:8][0:2][44:13][0:2][0:15][0:4]"),
                Arguments.of("M_VOLTAGE: Max", new Packet_39(0, 0, 0, 15, 0), "[39:8][0:2][54:13][0:2][0:15][15:4][0:10]"),
                Arguments.of("NID_CTRACTION: Min", new Packet_39(0, 0, 0, 1, 0), "[39:8][0:2][54:13][0:2][0:15][1:4][0:10]"),
                Arguments.of("NID_CTRACTION: Max", new Packet_39(0, 0, 0, 2, 1023), "[39:8][0:2][54:13][0:2][0:15][2:4][1023:10]"),
                Arguments.of("all", new Packet_39(2, 1, 986, 8, 732), "[39:8][2:2][54:13][1:2][986:15][8:4][732:10]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_39(4, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("Q_SCALE: Overflow", new Packet_39(0, 4, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("D_TRACTION: Overflow", new Packet_39(0, 0, 32768, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("M_VOLTAGE: Overflow", new Packet_39(0, 0, 0, 16, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_CTRACTION: Overflow", new Packet_39(0, 0, 0, 1, 1024), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}