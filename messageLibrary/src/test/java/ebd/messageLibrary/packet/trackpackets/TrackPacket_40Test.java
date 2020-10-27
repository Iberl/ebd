package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_40Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_40(), "[40:8][0:2][50:13][0:2][0:15][0:10]"),
                Arguments.of("Q_DIR: Min", new Packet_40(0, 0, 0, 0), "[40:8][0:2][50:13][0:2][0:15][0:10]"),
                Arguments.of("Q_DIR: Max", new Packet_40(3, 0, 0, 0), "[40:8][3:2][50:13][0:2][0:15][0:10]"),
                Arguments.of("Q_SCALE: Min", new Packet_40(0, 0, 0, 0), "[40:8][0:2][50:13][0:2][0:15][0:10]"),
                Arguments.of("Q_SCALE: Max", new Packet_40(0, 3, 0, 0), "[40:8][0:2][50:13][3:2][0:15][0:10]"),
                Arguments.of("D_CURRENT: Min", new Packet_40(0, 0, 0, 0), "[40:8][0:2][50:13][0:2][0:15][0:10]"),
                Arguments.of("D_CURRENT: Max", new Packet_40(0, 0, 32767, 0), "[40:8][0:2][50:13][0:2][32767:15][0:10]"),
                Arguments.of("M_CURRENT: Min", new Packet_40(0, 0, 0, 0), "[40:8][0:2][50:13][0:2][0:15][0:10]"),
                Arguments.of("M_CURRENT: Max", new Packet_40(0, 0, 0, 1023), "[40:8][0:2][50:13][0:2][0:15][1023:10]"),
                Arguments.of("all", new Packet_40(2, 1, 7623, 136), "[40:8][2:2][50:13][1:2][7623:15][136:10]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_40(4, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("Q_SCALE: Overflow", new Packet_40(0, 4, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("D_CURRENT: Overflow", new Packet_40(0, 0, 32768, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("M_CURRENT: Overflow", new Packet_40(0, 0, 0, 1024), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}