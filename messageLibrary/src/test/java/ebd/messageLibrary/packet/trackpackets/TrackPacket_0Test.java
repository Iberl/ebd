package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_0Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_0(), "[0:8][0:6]"),
                Arguments.of("NID_VBCMK: Min", new Packet_0(), "[0:8][0:6]"),
                Arguments.of("NID_VBCMK: Max", new Packet_0(63), "[0:8][63:6]"),
                Arguments.of("all", new Packet_0(23), "[0:8][23:6]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("NID_VBCMK: Overflow", new Packet_0(64), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }
}