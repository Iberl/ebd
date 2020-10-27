package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_42;
import ebd.messageLibrary.util.exception.MissingInformationException;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_3Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_3(), "[3:8][18:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("T_TRAIN: Min", new Message_3(0L, false, 0, new Packet_15()), "[3:8][18:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("T_TRAIN: Max", new Message_3(4294967295L, false, 0, new Packet_15()), "[3:8][18:10][4294967295:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("M_ACK: False", new Message_3(0L, false, 0, new Packet_15()), "[3:8][18:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("M_ACK: True", new Message_3(0L, true, 0, new Packet_15()), "[3:8][18:10][0:32]1[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("NID_LRBG: Min", new Message_3(0L, false, 0, new Packet_15()), "[3:8][18:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("NID_LRBG: Max", new Message_3(0L, false, 16777215, new Packet_15()), "[3:8][18:10][0:32]0[16777215:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),

                Arguments.of("packets: Empty", new Message_3(), "[3:8][18:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*0}"),
                Arguments.of("packets: 1 Element", fill(new Message_3(), new Packet_42(), 1), "[3:8][32:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*1}"),
                Arguments.of("packets: 1+ Elements", fill(new Message_3(), new Packet_42(), 2), "[3:8][46:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*2}"),
                Arguments.of("packets: Max Elements", fill(new Message_3(), new Packet_42(), 31), "[3:8][456:10][0:32]0[0:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*31}"),

                Arguments.of("all", new Message_3(42967295L, true, 187215, new Packet_15()), "[3:8][18:10][42967295:32]1[187215:24]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_3(4294967296L, false, 0, new Packet_15()), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_3(0L, false, 16777216, new Packet_15()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("packet_15: Null", new Message_3(0L, false, 0, null), new MissingInformationException("packet_15 is set to null"))
        );
    }

    public static Message_3 fill(Message_3 message_3, TrackPacket trackPacket, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            message_3.packets.add(trackPacket);
        }
        return message_3;
    }

}