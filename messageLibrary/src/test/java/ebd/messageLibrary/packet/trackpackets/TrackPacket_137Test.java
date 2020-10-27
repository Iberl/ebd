package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_137Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_137(), "[137:8][0:2][24:13]0"),
                Arguments.of("Q_DIR: Min", new Packet_137(0, false), "[137:8][0:2][24:13]0"),
                Arguments.of("Q_DIR: Max", new Packet_137(3, false), "[137:8][3:2][24:13]0"),
                Arguments.of("Q_SRSTOP: Min", new Packet_137(0, false), "[137:8][0:2][24:13]0"),
                Arguments.of("Q_SRSTOP: Max", new Packet_137(0, true), "[137:8][0:2][24:13]1"),
                Arguments.of("all", new Packet_137(2, false), "[137:8][2:2][24:13]0")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_137(4, false), new IllegalArgumentException("Invalid value for given bit length."))
                // Q_SRSTOP is a boolean -> no overflow test needed
        );
    }

}