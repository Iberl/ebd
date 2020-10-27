package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessageTestBase;
import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.packet.trainpackets.Packet_4;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_159Test extends TrainMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_159(), "[159:8][10:10][0:32][0:24]"),
                Arguments.of("T_TRAIN: Min", new Message_159(0L, 0), "[159:8][10:10][0:32][0:24]"),
                Arguments.of("T_TRAIN: Max", new Message_159(4294967295L, 0), "[159:8][10:10][4294967295:32][0:24]"),
                Arguments.of("NID_ENGINE: Min", new Message_159(0L, 0), "[159:8][10:10][0:32][0:24]"),
                Arguments.of("NID_ENGINE: Max", new Message_159(0L, 16777215), "[159:8][10:10][0:32][16777215:24]"),

                Arguments.of("packets: Empty", new Message_159(), "[159:8][10:10][0:32][0:24]{[4:8][29:13][0:8]*0}"),
                Arguments.of("packets: 1 Element", fill(new Message_159(), new Packet_4(), 1), "[159:8][13:10][0:32][0:24]{[4:8][29:13][0:8]*1}"),
                Arguments.of("packets: 1+ Elements", fill(new Message_159(), new Packet_4(), 2), "[159:8][17:10][0:32][0:24]{[4:8][29:13][0:8]*2}"),
                Arguments.of("packets: Max Elements", fill(new Message_159(), new Packet_4(), 31), "[159:8][122:10][0:32][0:24]{[4:8][29:13][0:8]*31}"),

                Arguments.of("all", new Message_159(97235L, 623982), "[159:8][10:10][97235:32][623982:24]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_159(4294967296L, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_ENGINE: Overflow", new Message_159(0L, 16777216), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

    public static Message_159 fill(Message_159 message_159, TrainPacket trainPacket, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            message_159.packets.add(trainPacket);
        }
        return message_159;
    }

}