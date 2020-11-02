package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_133Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_133(), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("Q_DIR: Min", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("Q_DIR: Max", new Packet_133(3, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][3:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("Q_SCALE: Min", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("Q_SCALE: Max", new Packet_133(0, 3, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][3:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("Q_RIU: False", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("Q_RIU: True", new Packet_133(0, 0, true, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]1[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("NID_C_RIU: Min", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("NID_C_RIU: Max", new Packet_133(0, 0, false, 1023, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[1023:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("NID_RIU: Min", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("NID_RIU: Max", new Packet_133(0, 0, false, 0, 16383, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][16383:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("NID_RADIO: Min", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("NID_RADIO: Max", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(-1L), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][-1:64][0:15][0:10][0:14]"),
                Arguments.of("D_INFILL: Min", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("D_INFILL: Max", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 32767, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][32767:15][0:10][0:14]"),
                Arguments.of("NID_C_BG: Min", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("NID_C_BG: Max", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 1023, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][1023:10][0:14]"),
                Arguments.of("NID_BG: Min", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][0:14]"),
                Arguments.of("NID_BG: Max", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 16383), "[133:8][0:2][153:13][0:2]0[0:10][0:14][0:64][0:15][0:10][16383:14]"),
                Arguments.of("all", new Packet_133(2, 3, true, 1002, 11133, new BinaryCodedDecimal(-9234L), 6233, 93, 1623), "[133:8][2:2][153:13][3:2]1[1002:10][11133:14][-9234:64][6233:15][93:10][1623:14]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_133(4, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("Q_SCALE: Overflow", new Packet_133(0, 4, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                // Q_RIU is a boolean -> no overflow test needed
                Arguments.of("NID_C_RIU: Overflow", new Packet_133(0, 0, false, 1024, 0, new BinaryCodedDecimal(), 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_RIU: Overflow", new Packet_133(0, 0, false, 0, 16384, new BinaryCodedDecimal(), 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                // NID_RADIO is in BCD format -> no overflow test needed
                Arguments.of("D_INFILL: Overflow", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 32768, 0, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_C_BG: Overflow", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 1024, 0), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("NID_BG: Overflow", new Packet_133(0, 0, false, 0, 0, new BinaryCodedDecimal(), 0, 0, 16384), new IllegalArgumentException("Invalid value for given bit length."))
        );
    }

}