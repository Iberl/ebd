package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessageTestBase;
import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.Packet_1;
import ebd.messageLibrary.packet.trainpackets.Packet_4;
import ebd.messageLibrary.util.exception.MissingInformationException;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_132Test extends TrainMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_132(), "[132:8][25:10][0:32][0:24][0:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("T_TRAIN: Min", new Message_132(0L, 0, 0, new Packet_0()), "[132:8][25:10][0:32][0:24][0:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("T_TRAIN: Max", new Message_132(4294967295L, 0, 0, new Packet_0()), "[132:8][25:10][4294967295:32][0:24][0:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_ENGINE: Min", new Message_132(0L, 0, 0, new Packet_0()), "[132:8][25:10][0:32][0:24][0:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_ENGINE: Max", new Message_132(0L, 16777215, 0, new Packet_0()), "[132:8][25:10][0:32][16777215:24][0:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("Q_MARQSTREASON: Min", new Message_132(0L, 0, 0, new Packet_0()), "[132:8][25:10][0:32][0:24][0:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("Q_MARQSTREASON: Max", new Message_132(0L, 0, 3, new Packet_0()), "[132:8][25:10][0:32][0:24][3:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("positionPacket: Packet_0", new Message_132(0L, 0, 0, new Packet_0()), "[132:8][25:10][0:32][0:24][0:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("positionPacket: Packet_1", new Message_132(0L, 0, 0, new Packet_1()), "[132:8][28:10][0:32][0:24][0:5]{[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),

                Arguments.of("packets: Empty", new Message_132(), "[132:8][25:10][0:32][0:24][0:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}{[4:8][29:13][0:8]*0}"),
                Arguments.of("packets: 1 Element", fill(new Message_132(), new Packet_4(), 1), "[132:8][28:10][0:32][0:24][0:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}{[4:8][29:13][0:8]*1}"),
                Arguments.of("packets: 1+ Elements", fill(new Message_132(), new Packet_4(), 2), "[132:8][32:10][0:32][0:24][0:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}{[4:8][29:13][0:8]*2}"),
                Arguments.of("packets: Max Elements", fill(new Message_132(), new Packet_4(), 31), "[132:8][137:10][0:32][0:24][0:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}{[4:8][29:13][0:8]*31}"),

                Arguments.of("all", new Message_132(97235L, 623982, 12, new Packet_0()), "[132:8][25:10][97235:32][623982:24][12:5]{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}{[4:8][29:13][0:8]*0}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_132(4294967296L, 0, 0, new Packet_0()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_ENGINE: Overflow", new Message_132(0L, 16777216, 0, new Packet_0()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_MARQSTREASON: Overflow", new Message_132(0L, 0, 32, new Packet_0()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("positionPacket: Null", new Message_132(0L, 0, 0, null), new MissingInformationException("positionPacket is set to null"))
        );
    }

    public static Message_132 fill(Message_132 message_132, TrainPacket trainPacket, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            message_132.packets.add(trainPacket);
        }
        return message_132;
    }

}