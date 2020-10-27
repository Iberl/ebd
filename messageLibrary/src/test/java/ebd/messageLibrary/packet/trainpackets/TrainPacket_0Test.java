package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrainPacket_0Test extends TrainPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_0(), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_SCALE: Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_SCALE: Max", new Packet_0(3,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][3:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("NID_LRBG: Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("NID_LRBG: Max", new Packet_0(0,16777215,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][16777215:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("D_LRBG: Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("D_LRBG: Max", new Packet_0(0,0,32767,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][32767:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DIRLRBG: Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DIRLRBG: Max", new Packet_0(0,0,0,3,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][3:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DLRBG: Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DLRBG: Max", new Packet_0(0,0,0,0,3,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][3:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("L_DOUBTOVER: Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("L_DOUBTOVER: Max", new Packet_0(0,0,0,0,0,32767,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][32767:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("L_DOUBTUNDER: Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("L_DOUBTUNDER: Max", new Packet_0(0,0,0,0,0,0,32767,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][32767:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_LENGTH: Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_LENGTH: Max", new Packet_0(0,0,0,0,0,0,0,3,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][3:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_LENGTH/L_TRAININIT: Min", new Packet_0(0,0,0,0,0,0,0,1,0,0,0,0,0,0), "[0:8][129:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][1:2][0:15][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_LENGTH/L_TRAININIT: Max", new Packet_0(0,0,0,0,0,0,0,2,32767,0,0,0,0,0), "[0:8][129:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][2:2][32767:15][0:7][0:2][0:4][0:3]"),
                Arguments.of("V_TRAIN : Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("V_TRAIN : Max", new Packet_0(0,0,0,0,0,0,0,0,0,127,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][127:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DIRTRAIN : Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("Q_DIRTRAIN : Max", new Packet_0(0,0,0,0,0,0,0,0,0,0,3,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][3:2][0:4][0:3]"),
                Arguments.of("M_MODE : Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("M_MODE : Max", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,15,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][15:4][0:3]"),
                Arguments.of("M_LEVEL : Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,0,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]"),
                Arguments.of("M_LEVEL : Max", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,7,0), "[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][7:3]"),
                Arguments.of("M_LEVEL/NID_NTC : Min", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,1,0), "[0:8][122:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][1:3][0:8]"),
                Arguments.of("M_LEVEL/NID_NTC : Max", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,1,255), "[0:8][122:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][1:3][255:8]"),
                Arguments.of("all", new Packet_0(2,23456,8362,1,2,5197,7631,2,12830,37,1,10,1,255), "[0:8][137:13][2:2][23456:24][8362:15][1:2][2:2][5197:15][7631:15][2:2][12830:15][37:7][1:2][10:4][1:3][255:8]")
                );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_SCALE: Overflow", new Packet_0(4,0,0,0,0,0,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_LRBG: Overflow", new Packet_0(0,16777216,0,0,0,0,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_LRBG: Overflow", new Packet_0(0,0,32768,0,0,0,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_DIRLRBG: Overflow", new Packet_0(0,0,0,4,0,0,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_DLRBG: Overflow", new Packet_0(0,0,0,0,4,0,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("L_DOUBTOVER: Overflow", new Packet_0(0,0,0,0,0,32768,0,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("L_DOUBTUNDER: Overflow", new Packet_0(0,0,0,0,0,0,32768,0,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_LENGTH: Overflow", new Packet_0(0,0,0,0,0,0,0,4,0,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_LENGTH/L_TRAININIT: Overflow", new Packet_0(0,0,0,0,0,0,0,2,32768,0,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("V_TRAIN : Overflow", new Packet_0(0,0,0,0,0,0,0,0,0,128,0,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_DIRTRAIN : Overflow", new Packet_0(0,0,0,0,0,0,0,0,0,0,4,0,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_MODE : Overflow", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,16,0,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_LEVEL : Overflow", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,8,0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_LEVEL/NID_NTC : Overflow", new Packet_0(0,0,0,0,0,0,0,0,0,0,0,0,1,256), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

}