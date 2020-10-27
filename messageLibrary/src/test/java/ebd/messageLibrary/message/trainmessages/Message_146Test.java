package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessageTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_146Test extends TrainMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_146(), "[146:8][14:10][0:32][0:24][0:32]"),
                Arguments.of("T_TRAIN: Min", new Message_146(0L, 0, 0L), "[146:8][14:10][0:32][0:24][0:32]"),
                Arguments.of("T_TRAIN: Max", new Message_146(4294967295L, 0, 0L), "[146:8][14:10][4294967295:32][0:24][0:32]"),
                Arguments.of("NID_ENGINE: Min", new Message_146(0L, 0, 0L), "[146:8][14:10][0:32][0:24][0:32]"),
                Arguments.of("NID_ENGINE: Max", new Message_146(0L, 16777215, 0L), "[146:8][14:10][0:32][16777215:24][0:32]"),
                Arguments.of("T_TRAIN_RQST: Min", new Message_146(0L, 0, 0L), "[146:8][14:10][0:32][0:24][0:32]"),
                Arguments.of("T_TRAIN_RQST: Max", new Message_146(0L, 0, 4294967295L), "[146:8][14:10][0:32][0:24][4294967295:32]"),

                Arguments.of("all", new Message_146(97235L, 623982, 83629L), "[146:8][14:10][97235:32][623982:24][83629:32]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_146(4294967296L, 0, 0L), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_ENGINE: Overflow", new Message_146(0L, 16777216, 0L), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("T_TRAIN_RQST: Overflow", new Message_146(0L, 0, 4294967296L), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

}