package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessageTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_155Test extends TrainMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_155(), "[155:8][10:10][0:32][0:24]"),
                Arguments.of("T_TRAIN: Min", new Message_155(0L, 0), "[155:8][10:10][0:32][0:24]"),
                Arguments.of("T_TRAIN: Max", new Message_155(4294967295L, 0), "[155:8][10:10][4294967295:32][0:24]"),
                Arguments.of("NID_ENGINE: Min", new Message_155(0L, 0), "[155:8][10:10][0:32][0:24]"),
                Arguments.of("NID_ENGINE: Max", new Message_155(0L, 16777215), "[155:8][10:10][0:32][16777215:24]"),

                Arguments.of("all", new Message_155(97235L, 623982), "[155:8][10:10][97235:32][623982:24]")
                        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_155(4294967296L, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_ENGINE: Overflow", new Message_155(0L, 16777216), new IllegalArgumentException("Invalid value for given bit length"))
                        );
    }
    
}