package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_132Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_132(), "[132:8][0:2][24:13]0"),
                Arguments.of("Q_DIR: Min", new Packet_132(0, false), "[132:8][0:2][24:13]0"),
                Arguments.of("Q_DIR: Max", new Packet_132(3, false), "[132:8][3:2][24:13]0"),
                Arguments.of("Q_ASPECT: False", new Packet_132(0, false), "[132:8][0:2][24:13]0"),
                Arguments.of("Q_ASPECT: True", new Packet_132(0, true), "[132:8][0:2][24:13]1"),
                Arguments.of("all", new Packet_132(1, true), "[132:8][1:2][24:13]1")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_64(4), new IllegalArgumentException("Invalid value for given bit length."))
                // Q_ASPECT is a boolean -> no overflow test needed
        );
    }

}