package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_145Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_145(), "[145:8][0:2][23:13]"),
                Arguments.of("Q_DIR: Min", new Packet_145(0), "[145:8][0:2][23:13]"),
                Arguments.of("Q_DIR: Max", new Packet_145(3), "[145:8][3:2][23:13]"),
                Arguments.of("all", new Packet_145(2), "[145:8][2:2][23:13]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_145(4), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}