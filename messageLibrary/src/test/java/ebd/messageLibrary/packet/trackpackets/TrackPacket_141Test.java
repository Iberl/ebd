package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_141Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_141(), "[141:8][0:2][32:13]0[0:8]"),
                Arguments.of("Q_DIR: Min", new Packet_141(0, false, 0), "[141:8][0:2][32:13]0[0:8]"),
                Arguments.of("Q_DIR: Max", new Packet_141(3, false, 0), "[141:8][3:2][32:13]0[0:8]"),
                Arguments.of("Q_GDIR: False", new Packet_141(0, false, 0), "[141:8][0:2][32:13]0[0:8]"),
                Arguments.of("Q_GDIR: True", new Packet_141(0, true, 0), "[141:8][0:2][32:13]1[0:8]"),
                Arguments.of("G_TSR: Min", new Packet_141(0, false, 0), "[141:8][0:2][32:13]0[0:8]"),
                Arguments.of("G_TSR: Max", new Packet_141(0, false, 255), "[141:8][0:2][32:13]0[255:8]"),
                Arguments.of("all", new Packet_141(3, false, 156), "[141:8][3:2][32:13]0[156:8]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_141(4, false,0), new IllegalArgumentException("Invalid value for given bit length.")),
                // Q_GDIR is a boolean -> no overflow needed
                Arguments.of("G_TSR: Overflow", new Packet_141(0, false, 256), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}