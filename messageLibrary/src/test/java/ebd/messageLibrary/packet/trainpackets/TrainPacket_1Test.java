package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrainPacket_1Test extends TrainPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_1(), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_SCALE: Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_SCALE: Max", new Packet_1(3,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][3:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("NID_LRBG: Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("NID_LRBG: Max", new Packet_1(0,16777215,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][16777215:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("NID_PRVLRBG: Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("NID_PRVLRBG: Max", new Packet_1(0,0,16777215,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][16777215:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("D_LRBG: Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("D_LRBG: Max", new Packet_1(0,0,0,32767,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][32767:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DIRLRBG: Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DIRLRBG: Max", new Packet_1(0,0,0,0,3,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][3:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DLRBG: Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DLRBG: Max", new Packet_1(0,0,0,0,0,3,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][3:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("L_DOUBTOVER: Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("L_DOUBTOVER: Max", new Packet_1(0,0,0,0,0,0,32767,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][32767:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("L_DOUBTUNDER: Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("L_DOUBTUNDER: Max", new Packet_1(0,0,0,0,0,0,0,32767,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][32767:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_LENGTH: Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_LENGTH: Max", new Packet_1(0,0,0,0,0,0,0,0,3,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][3:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_LENGTH/L_TRAININIT: Min", new Packet_1(0,0,0,0,0,0,0,0,1,0,0,0,0,0,0), "[1:8][153:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][1:2][0:15][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_LENGTH/L_TRAININIT: Max", new Packet_1(0,0,0,0,0,0,0,0,2,32767,0,0,0,0,0), "[1:8][153:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][2:2][32767:15][0:7][0:2][0:4][0:3]"),
                Arguments.of("V_TRAIN : Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("V_TRAIN : Max", new Packet_1(0,0,0,0,0,0,0,0,0,0,127,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][127:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DIRTRAIN : Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DIRTRAIN : Max", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,3,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][3:2][0:4][0:3]"),
                Arguments.of("M_MODE : Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("M_MODE : Max", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,15,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][15:4][0:3]"),
                Arguments.of("M_LEVEL : Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("M_LEVEL : Max", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,7,0), "[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][7:3]"),
                Arguments.of("M_LEVEL/NID_NTC : Min", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,1,0), "[1:8][146:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][1:3][0:8]"),
                Arguments.of("M_LEVEL/NID_NTC : Max", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,1,255), "[1:8][146:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][1:3][255:8]"),
                Arguments.of("all", new Packet_1(1,43657,76231,22428,2,1,9237,18252,2,30821,89,3,12,1,255), "[1:8][161:13][1:2][43657:24][76231:24][22428:15][2:2][1:2][9237:15][18252:15][2:2][30821:15][89:7][3:2][12:4][1:3][255:8]")
                );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_SCALE: Overflow", new Packet_1(4,0,0,0,0,0,0,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_LRBG: Overflow", new Packet_1(0,16777216,0,0,0,0,0,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_PRVLRBG: Overflow", new Packet_1(0,0,16777216,0,0,0,0,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_LRBG: Overflow", new Packet_1(0,0,0,32768,0,0,0,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_DIRLRBG: Overflow", new Packet_1(0,0,0,0,4,0,0,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_DLRBG: Overflow", new Packet_1(0,0,0,0,0,4,0,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("L_DOUBTOVER: Overflow", new Packet_1(0,0,0,0,0,0,32768,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("L_DOUBTUNDER: Overflow", new Packet_1(0,0,0,0,0,0,0,32768,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_LENGTH: Overflow", new Packet_1(0,0,0,0,0,0,0,0,4,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_LENGTH/L_TRAININIT: Overflow", new Packet_1(0,0,0,0,0,0,0,0,2,32768,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("V_TRAIN : Overflow", new Packet_1(0,0,0,0,0,0,0,0,0,0,128,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_DIRTRAIN : Overflow", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,4,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_MODE : Overflow", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,16,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_LEVEL : Overflow", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,8,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_LEVEL/NID_NTC : Overflow", new Packet_1(0,0,0,0,0,0,0,0,0,0,0,0,0,1,256), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

}