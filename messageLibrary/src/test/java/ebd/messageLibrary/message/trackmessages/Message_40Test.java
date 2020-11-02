package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_40Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_40(), "[40:8][10:10][0:32]0[0:24]"),
                Arguments.of("T_TRAIN: Min", new Message_40(0L, false, 0), "[40:8][10:10][0:32]0[0:24]"),
                Arguments.of("T_TRAIN: Max", new Message_40(4294967295L, false, 0), "[40:8][10:10][4294967295:32]0[0:24]"),
                Arguments.of("M_ACK: False", new Message_40(0L, false, 0), "[40:8][10:10][0:32]0[0:24]"),
                Arguments.of("M_ACK: True", new Message_40(0L, true, 0), "[40:8][10:10][0:32]1[0:24]"),
                Arguments.of("NID_LRBG: Min", new Message_40(0L, false, 0), "[40:8][10:10][0:32]0[0:24]"),
                Arguments.of("NID_LRBG: Max", new Message_40(0L, false, 16777215), "[40:8][10:10][0:32]0[16777215:24]"),

                Arguments.of("all", new Message_40(42967295L, true, 187215), "[40:8][10:10][42967295:32]1[187215:24]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_40(4294967296L, false, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_40(0L, false, 16777216), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

}