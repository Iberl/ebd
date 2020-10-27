package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_15Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_15(), "[15:8][15:10][0:32]0[0:24][0:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("T_TRAIN: Min", new Message_15(0L, false, 0, 0, 0, 0, 0, 0), "[15:8][15:10][0:32]0[0:24][0:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("T_TRAIN: Max", new Message_15(4294967295L, false, 0, 0, 0, 0, 0, 0), "[15:8][15:10][4294967295:32]0[0:24][0:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("M_ACK: False", new Message_15(0L, false, 0, 0, 0, 0, 0, 0), "[15:8][15:10][0:32]0[0:24][0:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("M_ACK: True", new Message_15(0L, true, 0, 0, 0, 0, 0, 0), "[15:8][15:10][0:32]1[0:24][0:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("NID_LRBG: Min", new Message_15(0L, false, 0, 0, 0, 0, 0, 0), "[15:8][15:10][0:32]0[0:24][0:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("NID_LRBG: Max", new Message_15(0L, false, 16777215, 0, 0, 0, 0, 0), "[15:8][15:10][0:32]0[16777215:24][0:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("NID_EM: Min", new Message_15(0L, false, 0, 0, 0, 0, 0, 0), "[15:8][15:10][0:32]0[0:24][0:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("NID_EM: Max", new Message_15(0L, false, 0, 15, 0, 0, 0, 0), "[15:8][15:10][0:32]0[0:24][15:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("Q_SCALE: Min", new Message_15(0L, false, 0, 0, 0, 0, 0, 0), "[15:8][15:10][0:32]0[0:24][0:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("Q_SCALE: Max", new Message_15(0L, false, 0, 0, 3, 0, 0, 0), "[15:8][15:10][0:32]0[0:24][0:4][3:2][0:16][0:2][0:15]"),
                Arguments.of("D_REF: Min", new Message_15(0L, false, 0, 0, 0, -32768, 0, 0), "[15:8][15:10][0:32]0[0:24][0:4][0:2][-32768:16][0:2][0:15]"),
                Arguments.of("D_REF: Max", new Message_15(0L, false, 0, 0, 0, 32767, 0, 0), "[15:8][15:10][0:32]0[0:24][0:4][0:2][32767:16][0:2][0:15]"),
                Arguments.of("Q_DIR: Min", new Message_15(0L, false, 0, 0, 0, 0, 0, 0), "[15:8][15:10][0:32]0[0:24][0:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("Q_DIR: Max", new Message_15(0L, false, 0, 0, 0, 0, 3, 0), "[15:8][15:10][0:32]0[0:24][0:4][0:2][0:16][3:2][0:15]"),
                Arguments.of("D_EMERGENCYSTOP: Min", new Message_15(0L, false, 0, 0, 0, 0, 0, 0), "[15:8][15:10][0:32]0[0:24][0:4][0:2][0:16][0:2][0:15]"),
                Arguments.of("D_EMERGENCYSTOP: Max", new Message_15(0L, false, 0, 0, 0, 0, 0, 32767), "[15:8][15:10][0:32]0[0:24][0:4][0:2][0:16][0:2][32767:15]"),

                Arguments.of("all", new Message_15(42967295L, true, 187215, 9, 2, 12415, 1, 22316), "[15:8][15:10][42967295:32]1[187215:24][9:4][2:2][12415:16][1:2][22316:15]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_15(4294967296L, false, 0, 0, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_15(0L, false, 16777216, 0, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_EM: Overflow", new Message_15(0L, false, 0, 16, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Message_15(0L, false, 0, 0, 4, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_REF: Negative Overflow", new Message_15(0L, false, 0, 0, 0, -32769, 0, 0), new IllegalArgumentException("Invalid negative value for given bit length")),
                Arguments.of("D_REF: Overflow", new Message_15(0L, false, 0, 0, 0, 32768, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_DIR: Overflow", new Message_15(0L, false, 0, 0, 0, 0, 4, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_EMERGENCYSTOP: Overflow", new Message_15(0L, false, 0, 0, 0, 0, 0, 32768), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

}