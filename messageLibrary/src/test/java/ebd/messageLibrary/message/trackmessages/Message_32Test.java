package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_32Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_32(), "[32:8][11:10][0:32]0[0:24][0:7]"),
                Arguments.of("T_TRAIN: Min", new Message_32(0L, false, 0, 0), "[32:8][11:10][0:32]0[0:24][0:7]"),
                Arguments.of("T_TRAIN: Max", new Message_32(4294967295L, false, 0, 0), "[32:8][11:10][4294967295:32]0[0:24][0:7]"),
                Arguments.of("M_ACK: False", new Message_32(0L, false, 0, 0), "[32:8][11:10][0:32]0[0:24][0:7]"),
                Arguments.of("M_ACK: True", new Message_32(0L, true, 0, 0), "[32:8][11:10][0:32]1[0:24][0:7]"),
                Arguments.of("NID_LRBG: Min", new Message_32(0L, false, 0, 0), "[32:8][11:10][0:32]0[0:24][0:7]"),
                Arguments.of("NID_LRBG: Max", new Message_32(0L, false, 16777215, 0), "[32:8][11:10][0:32]0[16777215:24][0:7]"),
                Arguments.of("M_VERSION: Min", new Message_32(0L, false, 0, 0), "[32:8][11:10][0:32]0[0:24][0:7]"),
                Arguments.of("M_VERSION: Max", new Message_32(0L, false, 0, 127), "[32:8][11:10][0:32]0[0:24][127:7]"),

                Arguments.of("all", new Message_32(42967295L, true, 187215, 45), "[32:8][11:10][42967295:32]1[187215:24][45:7]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_32(4294967296L, false, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_32(0L, false, 16777216, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_VERSION: Overflow", new Message_32(0L, false, 0, 128), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }
    
}