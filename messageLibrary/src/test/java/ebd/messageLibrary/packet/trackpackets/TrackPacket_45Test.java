package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_45Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_45(), "[45:8][0:2][47:13][0:24]"),
                Arguments.of("Q_DIR: Min", new Packet_45(0, 0), "[45:8][0:2][47:13][0:24]"),
                Arguments.of("Q_DIR: Max", new Packet_45(3, 0), "[45:8][3:2][47:13][0:24]"),
                Arguments.of("NID_MN: Min", new Packet_45(0, 0), "[45:8][0:2][47:13][0:24]"),
                Arguments.of("NID_MN: Max", new Packet_45(0, 16777215), "[45:8][0:2][47:13][16777215:24]"),
                Arguments.of("all", new Packet_45(3, 34352), "[45:8][3:2][47:13][34352:24]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_45(4, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_MN: Overflow", new Packet_45(0, 16777216), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}