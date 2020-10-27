package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_40;
import ebd.messageLibrary.packet.trackpackets.Packet_80;
import ebd.messageLibrary.util.exception.MissingInformationException;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_9Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_9(), "[9:8][18:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("T_TRAIN: Min", new Message_9(0L, false, 0, new Packet_15(), null), "[9:8][18:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("T_TRAIN: Max", new Message_9(4294967295L, false, 0, new Packet_15(), null), "[9:8][18:10][4294967295:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("M_ACK: False", new Message_9(0L, false, 0, new Packet_15(), null), "[9:8][18:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("M_ACK: True", new Message_9(0L, true, 0, new Packet_15(), null), "[9:8][18:10][0:32]1[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("NID_LRBG: Min", new Message_9(0L, false, 0, new Packet_15(), null), "[9:8][18:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("NID_LRBG: Max", new Message_9(0L, false, 16777215, new Packet_15(), null), "[9:8][18:10][0:32]0[16777215:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("packet_80: Null", new Message_9(0L, false, 0, new Packet_15(), null), "[9:8][18:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]*0}"),
                Arguments.of("packet_80: Set", new Message_9(0L, false, 0, new Packet_15(), new Packet_80()), "[9:8][29:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]*1}"),

                Arguments.of("packets: Empty", new Message_9(), "[9:8][18:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[40:8][0:2][50:13][0:2][0:15][0:10]*0}"),
                Arguments.of("packets: 1 Element", fill(new Message_9(), new Packet_40(), 1), "[9:8][24:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[40:8][0:2][50:13][0:2][0:15][0:10]*1}"),
                Arguments.of("packets: 1+ Elements", fill(new Message_9(), new Packet_40(), 2), "[9:8][31:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[40:8][0:2][50:13][0:2][0:15][0:10]*2}"),
                Arguments.of("packets: Max Elements", fill(new Message_9(), new Packet_40(), 31), "[9:8][212:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[40:8][0:2][50:13][0:2][0:15][0:10]*31}"),

                Arguments.of("all", new Message_9(42967295L, true, 187215, new Packet_15(), new Packet_80()), "[9:8][29:10][42967295:32]1[187215:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_9(4294967296L, false, 0, new Packet_15()), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_9(0L, false, 16777216, new Packet_15()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("packet_15: Null", new Message_9(0L, false, 0, null), new MissingInformationException("packet_15 is set to null"))
                // packet_80 can be null -> no null test needed
        );
    }

    public static Message_9 fill(Message_9 message_9, TrackPacket trackPacket, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            message_9.packets.add(trackPacket);
        }
        return message_9;
    }

}