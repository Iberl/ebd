package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_90Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_90(), "[90:8][0:2][38:13]0[0:14]"),
                Arguments.of("Q_DIR: Min", new Packet_90(0, false, 0, 0), "[90:8][0:2][38:13]0[0:14]"),
                Arguments.of("Q_DIR: Max", new Packet_90(3, false, 0, 0), "[90:8][3:2][38:13]0[0:14]"),
                Arguments.of("Q_NEWCOUNTRY: False", new Packet_90(0, false, 0, 0), "[90:8][0:2][38:13]0[0:14]"),
                Arguments.of("Q_NEWCOUNTRY: True", new Packet_90(0, true, 0, 0), "[90:8][0:2][48:13]1[0:10][0:14]"),
                Arguments.of("NID_C: Min", new Packet_90(0, true, 0, 0), "[90:8][0:2][48:13]1[0:10][0:14]"),
                Arguments.of("NID_C: Max", new Packet_90(0, true, 1023, 0), "[90:8][0:2][48:13]1[1023:10][0:14]"),
                Arguments.of("NID_BG: Min", new Packet_90(0, false, 0, 0), "[90:8][0:2][38:13]0[0:14]"),
                Arguments.of("NID_BG: Max", new Packet_90(0, false, 0, 16383), "[90:8][0:2][38:13]0[16383:14]"),
                Arguments.of("all", new Packet_90(2, true, 584, 1383), "[90:8][2:2][48:13]1[584:10][1383:14]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_90(4, false, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                // Q_NEWCOUNTRY is a boolean -> no overflow test needed
                Arguments.of("NID_C: Overflow", new Packet_90(0, true, 1024, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_BG: Overflow", new Packet_90(0, false, 0, 16384), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}