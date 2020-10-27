package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_2Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_2(), "[2:8][0:2][30:13][0:7]"),
                Arguments.of("Q_DIR: Min", new Packet_2(0, 0), "[2:8][0:2][30:13][0:7]"),
                Arguments.of("Q_DIR: Max", new Packet_2(3, 0), "[2:8][3:2][30:13][0:7]"),
                Arguments.of("M_VERSION: Min", new Packet_2(0,0), "[2:8][0:2][30:13][0:7]"),
                Arguments.of("M_VERSION: Max", new Packet_2(0, 127), "[2:8][0:2][30:13][127:7]"),
                Arguments.of("all", new Packet_2(2, 94), "[2:8][2:2][30:13][94:7]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_2(4, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_VERSION: Overflow", new Packet_2(0, 128), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }
}