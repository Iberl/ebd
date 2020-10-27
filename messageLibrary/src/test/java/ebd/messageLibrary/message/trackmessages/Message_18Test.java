package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_18Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_18(), "[18:8][10:10][0:32]0[0:24][0:4]"),
                Arguments.of("T_TRAIN: Min", new Message_18(0L, false, 0, 0), "[18:8][10:10][0:32]0[0:24][0:4]"),
                Arguments.of("T_TRAIN: Max", new Message_18(4294967295L, false, 0, 0), "[18:8][10:10][4294967295:32]0[0:24][0:4]"),
                Arguments.of("M_ACK: False", new Message_18(0L, false, 0, 0), "[18:8][10:10][0:32]0[0:24][0:4]"),
                Arguments.of("M_ACK: True", new Message_18(0L, true, 0, 0), "[18:8][10:10][0:32]1[0:24][0:4]"),
                Arguments.of("NID_LRBG: Min", new Message_18(0L, false, 0, 0), "[18:8][10:10][0:32]0[0:24][0:4]"),
                Arguments.of("NID_LRBG: Max", new Message_18(0L, false, 16777215, 0), "[18:8][10:10][0:32]0[16777215:24][0:4]"),
                Arguments.of("NID_EM: Min", new Message_18(0L, false, 0, 0), "[18:8][10:10][0:32]0[0:24][0:4]"),
                Arguments.of("NID_EM: Max", new Message_18(0L, false, 0, 15), "[18:8][10:10][0:32]0[0:24][15:4]"),

                Arguments.of("all", new Message_18(42967295L, true, 187215, 13), "[18:8][10:10][42967295:32]1[187215:24][13:4]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_18(4294967296L, false, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_18(0L, false, 16777216, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_EM: Overflow", new Message_18(0L, false, 0, 16), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }
    
}