package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessageTestBase;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.Packet_1;
import ebd.messageLibrary.util.exception.MissingInformationException;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_158Test extends TrainMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_158(), "[158:8][25:10][0:32][0:24][0:8]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("T_TRAIN: Min", new Message_158(0L, 0, 0, new Packet_0()), "[158:8][25:10][0:32][0:24][0:8]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("T_TRAIN: Max", new Message_158(4294967295L, 0, 0, new Packet_0()), "[158:8][25:10][4294967295:32][0:24][0:8]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_ENGINE: Min", new Message_158(0L, 0, 0, new Packet_0()), "[158:8][25:10][0:32][0:24][0:8]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_ENGINE: Max", new Message_158(0L, 16777215, 0, new Packet_0()), "[158:8][25:10][0:32][16777215:24][0:8]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_TEXTMESSAGE: Min", new Message_158(0L, 0, 0, new Packet_0()), "[158:8][25:10][0:32][0:24][0:8]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_TEXTMESSAGE: Max", new Message_158(0L, 0, 255, new Packet_0()), "[158:8][25:10][0:32][0:24][255:8]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("positionPacket: Packet_0", new Message_158(0L, 0, 0, new Packet_0()), "[158:8][25:10][0:32][0:24][0:8]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("positionPacket: Packet_1", new Message_158(0L, 0, 0, new Packet_1()), "[158:8][28:10][0:32][0:24][0:8]{[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),

                Arguments.of("all", new Message_158(97235L, 623982, 144, new Packet_1()), "[158:8][28:10][97235:32][623982:24][144:8]{[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_158(4294967296L, 0, 0, new Packet_0()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_ENGINE: Overflow", new Message_158(0L, 16777216, 0, new Packet_1()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_TEXTMESSAGE: Overflow", new Message_158(0L, 0, 256, new Packet_0()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("positionPacket: Null", new Message_158(0L, 0, 0, null), new MissingInformationException("positionPacket is set to null"))
        );
    }

}