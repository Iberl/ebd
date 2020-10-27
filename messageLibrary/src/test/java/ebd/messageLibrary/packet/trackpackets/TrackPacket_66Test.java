package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_66Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_66(), "[66:8][0:2][31:13][0:8]"),
                Arguments.of("Q_DIR: Min", new Packet_66(0, 0), "[66:8][0:2][31:13][0:8]"),
                Arguments.of("Q_DIR: Max", new Packet_66(3, 0), "[66:8][3:2][31:13][0:8]"),
                Arguments.of("NID_TSR: Min", new Packet_66(0, 0), "[66:8][0:2][31:13][0:8]"),
                Arguments.of("NID_TSR: Max", new Packet_66(0, 255), "[66:8][0:2][31:13][255:8]"),
                Arguments.of("NID_TSR: Max", new Packet_66(2, 122), "[66:8][2:2][31:13][122:8]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_66(4, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_TSR: Overflow", new Packet_66(0, 256), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}