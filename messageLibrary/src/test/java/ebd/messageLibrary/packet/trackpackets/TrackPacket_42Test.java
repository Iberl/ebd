package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_42Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_42(), "[42:8][0:2][113:13]0[0:10][0:14][0:64]0"),
                Arguments.of("Q_DIR: Min", new Packet_42(0, false, 0, 0, new BinaryCodedDecimal(), false), "[42:8][0:2][113:13]0[0:10][0:14][0:64]0"),
                Arguments.of("Q_DIR: Max", new Packet_42(3, false, 0, 0, new BinaryCodedDecimal(), false), "[42:8][3:2][113:13]0[0:10][0:14][0:64]0"),
                Arguments.of("Q_RBC: False", new Packet_42(0, false, 0, 0, new BinaryCodedDecimal(), false), "[42:8][0:2][113:13]0[0:10][0:14][0:64]0"),
                Arguments.of("Q_RBC: True", new Packet_42(0, true, 0, 0, new BinaryCodedDecimal(), false), "[42:8][0:2][113:13]1[0:10][0:14][0:64]0"),
                Arguments.of("NID_C: Min", new Packet_42(0, false, 0, 0, new BinaryCodedDecimal(), false), "[42:8][0:2][113:13]0[0:10][0:14][0:64]0"),
                Arguments.of("NID_C: Max", new Packet_42(0, false, 1023, 0, new BinaryCodedDecimal(), false), "[42:8][0:2][113:13]0[1023:10][0:14][0:64]0"),
                Arguments.of("NID_RBC: Min", new Packet_42(0, false, 0, 0, new BinaryCodedDecimal(), false), "[42:8][0:2][113:13]0[0:10][0:14][0:64]0"),
                Arguments.of("NID_RBC: Max", new Packet_42(0, false, 0, 16383, new BinaryCodedDecimal(), false), "[42:8][0:2][113:13]0[0:10][16383:14][0:64]0"),
                Arguments.of("NID_RADIO: Min", new Packet_42(0, false, 0, 0, new BinaryCodedDecimal(), false), "[42:8][0:2][113:13]0[0:10][0:14][0:64]0"),
                Arguments.of("NID_RADIO: Max", new Packet_42(0, false, 0, 0, new BinaryCodedDecimal(-1L), false), "[42:8][0:2][113:13]0[0:10][0:14][-1:64]0"),
                Arguments.of("Q_SLEEPSESSION: False", new Packet_42(0, false, 0, 0, new BinaryCodedDecimal(), false), "[42:8][0:2][113:13]0[0:10][0:14][0:64]0"),
                Arguments.of("Q_SLEEPSESSION: True", new Packet_42(0, false, 0, 0, new BinaryCodedDecimal(), true), "[42:8][0:2][113:13]0[0:10][0:14][0:64]1"),
                Arguments.of("all", new Packet_42(2, true, 728, 9863, new BinaryCodedDecimal(128239682L, 16), true), "[42:8][2:2][113:13]1[728:10][9863:14][128239682:64]1")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_42(4, false, 0, 0, new BinaryCodedDecimal(), false), new IllegalArgumentException("Invalid value for given bit length.")),
                // Q_RBC is a boolean -> overflow test not needed
                Arguments.of("NID_C: Overflow", new Packet_42(0, false, 1024, 0, new BinaryCodedDecimal(), false), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_RBC: Overflow", new Packet_42(0, false, 0, 16384, new BinaryCodedDecimal(), false), new IllegalArgumentException("Invalid value for given bit length."))
                // NID_RADIO is in BCD format -> no overflow test needed
                // Q_SLEEPSESSION is a boolean -> overflow test not needed
        );
    }

}