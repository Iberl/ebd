package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_45Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_45(), "[45:8][10:10][0:32]0[0:24]0"),
                Arguments.of("T_TRAIN: Min", new Message_45(0L, false, 0, false), "[45:8][10:10][0:32]0[0:24]0"),
                Arguments.of("T_TRAIN: Max", new Message_45(4294967295L, false, 0, false), "[45:8][10:10][4294967295:32]0[0:24]0"),
                Arguments.of("M_ACK: False", new Message_45(0L, false, 0, false), "[45:8][10:10][0:32]0[0:24]0"),
                Arguments.of("M_ACK: True", new Message_45(0L, true, 0, false), "[45:8][10:10][0:32]1[0:24]0"),
                Arguments.of("NID_LRBG: Min", new Message_45(0L, false, 0, false), "[45:8][10:10][0:32]0[0:24]0"),
                Arguments.of("NID_LRBG: Max", new Message_45(0L, false, 16777215, false), "[45:8][10:10][0:32]0[16777215:24]0"),
                Arguments.of("Q_ORIENTATION: False", new Message_45(0L, false, 0, false), "[45:8][10:10][0:32]0[0:24]0"),
                Arguments.of("Q_ORIENTATION: True", new Message_45(0L, true, 0, true), "[45:8][10:10][0:32]1[0:24]1"),

                Arguments.of("all", new Message_45(42967295L, true, 187215, false), "[45:8][10:10][42967295:32]1[187215:24]")
         );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_45(4294967296L, false, 0, false), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_45(0L, false, 16777216, false), new IllegalArgumentException("Invalid value for given bit length"))
                // Q_ORIENTATION is a boolean -> no overflow test needed
        );
    }

}