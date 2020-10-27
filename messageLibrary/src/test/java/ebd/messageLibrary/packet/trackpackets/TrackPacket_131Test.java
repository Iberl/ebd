package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_131Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_131(), "[131:8][0:2][129:13][0:2][0:15][0:10][0:14][0:64]0"),
                Arguments.of("Q_DIR: Min", new Packet_131(0, 0, 0, 0, 0, new BinaryCodedDecimal(), false), "[131:8][0:2][129:13][0:2][0:15][0:10][0:14][0:64]0"),
                Arguments.of("Q_DIR: Max", new Packet_131(3, 0, 0, 0, 0, new BinaryCodedDecimal(), false), "[131:8][3:2][129:13][0:2][0:15][0:10][0:14][0:64]0"),
                Arguments.of("Q_SCALE: Min", new Packet_131(0, 0, 0, 0, 0, new BinaryCodedDecimal(), false), "[131:8][0:2][129:13][0:2][0:15][0:10][0:14][0:64]0"),
                Arguments.of("Q_SCALE: Max", new Packet_131(0, 3, 0, 0, 0, new BinaryCodedDecimal(), false), "[131:8][0:2][129:13][3:2][0:15][0:10][0:14][0:64]0"),
                Arguments.of("D_RBCTR: Min", new Packet_131(0, 0, 0, 0, 0, new BinaryCodedDecimal(), false), "[131:8][0:2][129:13][0:2][0:15][0:10][0:14][0:64]0"),
                Arguments.of("D_RBCTR: Max", new Packet_131(0, 0, 32767, 0, 0, new BinaryCodedDecimal(), false), "[131:8][0:2][129:13][0:2][32767:15][0:10][0:14][0:64]0"),
                Arguments.of("NID_C: Min", new Packet_131(0, 0, 0, 0, 0, new BinaryCodedDecimal(), false), "[131:8][0:2][129:13][0:2][0:15][0:10][0:14][0:64]0"),
                Arguments.of("NID_C: Max", new Packet_131(0, 0, 0, 1023, 0, new BinaryCodedDecimal(), false), "[131:8][0:2][129:13][0:2][0:15][1023:10][0:14][0:64]0"),
                Arguments.of("NID_RBC: Min", new Packet_131(0, 0, 0, 0, 0, new BinaryCodedDecimal(), false), "[131:8][0:2][129:13][0:2][0:15][0:10][0:14][0:64]0"),
                Arguments.of("NID_RBC: Max", new Packet_131(0, 0, 0, 0, 16383, new BinaryCodedDecimal(), false), "[131:8][0:2][129:13][0:2][0:15][0:10][16383:14][0:64]0"),
                Arguments.of("NID_RADIO: Min", new Packet_131(0, 0, 0, 0, 0, new BinaryCodedDecimal(), false), "[131:8][0:2][129:13][0:2][0:15][0:10][0:14][0:64]0"),
                Arguments.of("NID_RADIO: Max", new Packet_131(0, 0, 0, 0, 0, new BinaryCodedDecimal(-1L), false), "[131:8][0:2][129:13][0:2][0:15][0:10][0:14][-1:64]0"),
                Arguments.of("Q_SLEEPSESSION: False", new Packet_131(0, 0, 0, 0, 0, new BinaryCodedDecimal(), false), "[131:8][0:2][129:13][0:2][0:15][0:10][0:14][0:64]0"),
                Arguments.of("Q_SLEEPSESSION: True", new Packet_131(0, 0, 0, 0, 0, new BinaryCodedDecimal(), true), "[131:8][0:2][129:13][0:2][0:15][0:10][0:14][0:64]1"),
                Arguments.of("all", new Packet_131(1, 2, 344, 421, 6474, new BinaryCodedDecimal(-234125L), true), "[131:8][1:2][129:13][2:2][344:15][421:10][6474:14][-234125:64]1")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_131(4, 0, 0, 0, 0, new BinaryCodedDecimal(), false), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("Q_SCALE: Overflow", new Packet_131(0, 4, 0, 0, 0, new BinaryCodedDecimal(), false), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("D_RBCTR: Overflow", new Packet_131(0, 0, 32768, 0, 0, new BinaryCodedDecimal(), false), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_C: Overflow", new Packet_131(0, 0, 0, 1024, 0, new BinaryCodedDecimal(), false), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_RBC: Overflow", new Packet_131(0, 0, 0, 0, 16384, new BinaryCodedDecimal(), false), new IllegalArgumentException("Invalid value for given bit length."))
                // NID_RADIO is in BCD format -> no overflow test needed
                // Q_SLEEPSESSION is a boolean -> overflow test not needed
        );
    }

}