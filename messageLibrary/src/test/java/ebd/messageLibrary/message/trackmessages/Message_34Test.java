package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_34Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_34(), "[34:8][16:10][0:32]0[0:24][0:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("T_TRAIN: Min", new Message_34(0L, false, 0, 0, 0, 0, 0, 0), "[34:8][16:10][0:32]0[0:24][0:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("T_TRAIN: Max", new Message_34(4294967295L, false, 0, 0, 0, 0, 0,0), "[34:8][16:10][4294967295:32]0[0:24][0:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("M_ACK: False", new Message_34(0L, false, 0, 0, 0, 0, 0, 0), "[34:8][16:10][0:32]0[0:24][0:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("M_ACK: True", new Message_34(0L, true, 0, 0, 0, 0, 0, 0), "[34:8][16:10][0:32]1[0:24][0:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("NID_LRBG: Min", new Message_34(0L, false, 0, 0, 0, 0, 0, 0), "[34:8][16:10][0:32]0[0:24][0:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("NID_LRBG: Max", new Message_34(0L, false, 16777215, 0, 0, 0, 0, 0), "[34:8][16:10][0:32]0[16777215:24][0:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("Q_SCALE: Min", new Message_34(0L, false, 0, 0, 0, 0, 0, 0), "[34:8][16:10][0:32]0[0:24][0:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("Q_SCALE: Max", new Message_34(0L, false, 0, 3, 0, 0, 0, 0), "[34:8][16:10][0:32]0[0:24][3:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("D_REF: Min", new Message_34(0L, false, 0, 0, -32768, 0, 0, 0), "[34:8][16:10][0:32]0[0:24][0:2][-32768:16][0:2][0:15][0:15]"),
                Arguments.of("D_REF: Max", new Message_34(0L, false, 0, 0, 32767, 0, 0, 0), "[34:8][16:10][0:32]0[0:24][0:2][32767:16][0:2][0:15][0:15]"),
                Arguments.of("Q_DIR: Min", new Message_34(0L, false, 0, 0, 0, 0, 0, 0), "[34:8][16:10][0:32]0[0:24][0:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("Q_DIR: Max", new Message_34(0L, false, 0, 0, 0, 3, 0, 0), "[34:8][16:10][0:32]0[0:24][0:2][0:16][3:2][0:15][0:15]"),
                Arguments.of("D_TAFDISPLAY: Min", new Message_34(0L, false, 0, 0, 0, 0, 0, 0), "[34:8][16:10][0:32]0[0:24][0:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("D_TAFDISPLAY: Max", new Message_34(0L, false, 0, 0, 0, 0, 32767, 0), "[34:8][16:10][0:32]0[0:24][0:2][0:16][0:2][32767:15][0:15]"),
                Arguments.of("L_TAFDISPLAY: Min", new Message_34(0L, false, 0, 0, 0, 0, 0, 0), "[34:8][16:10][0:32]0[0:24][0:2][0:16][0:2][0:15][0:15]"),
                Arguments.of("L_TAFDISPLAY: Max", new Message_34(0L, false, 0, 0, 0, 0, 0, 32767), "[34:8][16:10][0:32]0[0:24][0:2][0:16][0:2][0:15][32767:15]"),

                Arguments.of("all", new Message_34(42967295L, true, 187215, 1, -13943, 0, 0, 0), "[34:8][16:10][42967295:32]1[187215:24][1:2][-13943:16][0:2][0:15][0:15]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_34(4294967296L, false, 0, 0, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_34(0L, false, 16777216, 0, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Message_34(0L, false, 0, 4, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_REF: Overflow", new Message_34(0L, false, 0, 0, 32768, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_REF: Negative Overflow", new Message_34(0L, false, 0, 0, -32769, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_DIR: Overflow", new Message_34(0L, false, 0, 0, 0, 4, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_TAFDISPLAY: Overflow", new Message_34(0L, false, 0, 0, 0, 0, 32768, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("L_TAFDISPLAY: Overflow", new Message_34(0L, false, 0, 0, 0, 0, 0, 32768), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

}