package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_143Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_143(), "[143:8][0:2][112:13]0[0:10][0:14][0:64]"),
                Arguments.of("Q_DIR: Min", new Packet_143(0, false, 0, 0, new BinaryCodedDecimal()), "[143:8][0:2][112:13]0[0:10][0:14][0:64]"),
                Arguments.of("Q_DIR: Max", new Packet_143(3, false, 0, 0, new BinaryCodedDecimal()), "[143:8][3:2][112:13]0[0:10][0:14][0:64]"),
                Arguments.of("Q_RIU: False", new Packet_143(0, false, 0, 0, new BinaryCodedDecimal()), "[143:8][0:2][112:13]0[0:10][0:14][0:64]"),
                Arguments.of("Q_RIU: True", new Packet_143(0, true, 0, 0, new BinaryCodedDecimal()), "[143:8][0:2][112:13]1[0:10][0:14][0:64]"),
                Arguments.of("NID_C: Min", new Packet_143(0, false, 0, 0, new BinaryCodedDecimal()), "[143:8][0:2][112:13]0[0:10][0:14][0:64]"),
                Arguments.of("NID_C: Max", new Packet_143(0, false, 1023, 0, new BinaryCodedDecimal()), "[143:8][0:2][112:13]0[1023:10][0:14][0:64]"),
                Arguments.of("NID_RIU: Min", new Packet_143(0, false, 0, 0, new BinaryCodedDecimal()), "[143:8][0:2][112:13]0[0:10][0:14][0:64]"),
                Arguments.of("NID_RIU: Max", new Packet_143(0, false, 0, 16383, new BinaryCodedDecimal()), "[143:8][0:2][112:13]0[0:10][16383:14][0:64]"),
                Arguments.of("NID_RADIO: Min", new Packet_143(0, false, 0, 0, new BinaryCodedDecimal()), "[143:8][0:2][112:13]0[0:10][0:14][0:64]"),
                Arguments.of("NID_RADIO: Max", new Packet_143(0, false, 0, 0, new BinaryCodedDecimal(-1L)), "[143:8][0:2][112:13]0[0:10][0:14][-1:64]"),
                Arguments.of("all", new Packet_143(1, true, 238, 4459, new BinaryCodedDecimal(549126L, 16)), "[143:8][1:2][112:13]1[238:10][4459:14][549126:64]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_143(4, false, 0, 0, new BinaryCodedDecimal()), new IllegalArgumentException("Invalid value for given bit length.")),
                // Q_RIU is a boolean -> no overflow test needed
                Arguments.of("NID_C: Overflow", new Packet_143(0, false, 1024, 0, new BinaryCodedDecimal()), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_RIU: Overflow", new Packet_143(0, false, 0, 16384, new BinaryCodedDecimal()), new IllegalArgumentException("Invalid value for given bit length."))
                // NID_RADIO is in BCD format -> no overflow test needed
        );
    }

}