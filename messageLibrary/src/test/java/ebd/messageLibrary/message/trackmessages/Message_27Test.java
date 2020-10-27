package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_27Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_27(), "[27:8][14:10][0:32]0[0:24][0:32]"),
                Arguments.of("T_TRAIN: Min", new Message_27(0L, false, 0, 0), "[27:8][14:10][0:32]0[0:24][0:32]"),
                Arguments.of("T_TRAIN: Max", new Message_27(4294967295L, false, 0, 0), "[27:8][14:10][4294967295:32]0[0:24][0:32]"),
                Arguments.of("M_ACK: False", new Message_27(0L, false, 0, 0), "[27:8][14:10][0:32]0[0:24][0:32]"),
                Arguments.of("M_ACK: True", new Message_27(0L, true, 0, 0), "[27:8][14:10][0:32]1[0:24][0:32]"),
                Arguments.of("NID_LRBG: Min", new Message_27(0L, false, 0, 0), "[27:8][14:10][0:32]0[0:24][0:32]"),
                Arguments.of("NID_LRBG: Max", new Message_27(0L, false, 16777215, 0), "[27:8][14:10][0:32]0[16777215:24][0:32]"),
                Arguments.of("T_TRAIN_RQST: Min", new Message_27(0L, false, 0, 0L), "[27:8][14:10][0:32]0[0:24][0:32]"),
                Arguments.of("T_TRAIN_RQST: Max", new Message_27(0L, false, 0, 4294967295L), "[27:8][14:10][0:32]0[0:24][4294967295:32]"),

                Arguments.of("all", new Message_27(42967295L, true, 187215, 42948295L), "[27:8][14:10][42967295:32]1[187215:24][42948295:32]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_27(4294967296L, false, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_27(0L, false, 16777216, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("T_TRAIN_RQST: Overflow", new Message_27(0L, false, 0, 4294967296L), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

}