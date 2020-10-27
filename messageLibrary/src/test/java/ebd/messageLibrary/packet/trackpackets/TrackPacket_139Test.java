package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_139Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_139(), "[139:8][0:2][45:13][0:15][0:7]"),
                Arguments.of("Q_DIR: Min", new Packet_139(0, 0, 0), "[139:8][0:2][45:13][0:15][0:7]"),
                Arguments.of("Q_DIR: Max", new Packet_139(3, 0, 0), "[139:8][3:2][45:13][0:15][0:7]"),
                Arguments.of("D_REVERSE: Min", new Packet_139(0, 0, 0), "[139:8][0:2][45:13][0:15][0:7]"),
                Arguments.of("D_REVERSE: Max", new Packet_139(0, 32767, 0), "[139:8][0:2][45:13][32767:15][0:7]"),
                Arguments.of("V_REVERSE: Min", new Packet_139(0, 0, 0), "[139:8][0:2][45:13][0:15][0:7]"),
                Arguments.of("V_REVERSE: Max", new Packet_139(0, 0, 127), "[139:8][0:2][45:13][0:15][127:7]"),
                Arguments.of("all", new Packet_139(1, 556, 78), "[139:8][1:2][45:13][556:15][78:7]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_139(4, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("D_REVERSE: Overflow", new Packet_139(0, 32768, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("V_REVERSE: Overflow", new Packet_139(0, 0, 128), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }
    
}