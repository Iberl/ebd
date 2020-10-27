package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_39Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_39(), "[39:8][10:10][0:32]0[0:24]"),
                Arguments.of("T_TRAIN: Min", new Message_39(0L, 0), "[39:8][10:10][0:32]0[0:24]"),
                Arguments.of("T_TRAIN: Max", new Message_39(4294967295L, 0), "[39:8][10:10][4294967295:32]0[0:24]"),
                // MACK is always set to false -> no test needed
                Arguments.of("NID_LRBG: Min", new Message_39(0L, 0), "[39:8][10:10][0:32]0[0:24]"),
                Arguments.of("NID_LRBG: Max", new Message_39(0L, 16777215), "[39:8][10:10][0:32]0[16777215:24]"),

                Arguments.of("all", new Message_39(42967295L, 187215), "[39:8][10:10][42967295:32]0[187215:24]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_39(4294967296L, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_39(0L, 16777216), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

}