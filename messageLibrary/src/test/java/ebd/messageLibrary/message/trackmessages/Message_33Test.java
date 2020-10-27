package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_42;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_33Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_33(), "[33:8][20:10][0:32]0[0:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("T_TRAIN: Min", new Message_33(0L, false, 0, 0, 0, new Packet_15()), "[33:8][20:10][0:32]0[0:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("T_TRAIN: Max", new Message_33(4294967295L, false, 0, 0, 0, new Packet_15()), "[33:8][20:10][4294967295:32]0[0:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("M_ACK: False", new Message_33(0L, false, 0, 0, 0, new Packet_15()), "[33:8][20:10][0:32]0[0:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("M_ACK: True", new Message_33(0L, true, 0, 0, 0, new Packet_15()), "[33:8][20:10][0:32]1[0:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("NID_LRBG: Min", new Message_33(0L, false, 0, 0, 0, new Packet_15()), "[33:8][20:10][0:32]0[0:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("NID_LRBG: Max", new Message_33(0L, false, 16777215, 0, 0, new Packet_15()), "[33:8][20:10][0:32]0[16777215:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("Q_SCALE: Min", new Message_33(0L, false, 0, 0, 0, new Packet_15()), "[33:8][20:10][0:32]0[0:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("Q_SCALE: Max", new Message_33(0L, false, 0, 3, 0, new Packet_15()), "[33:8][20:10][0:32]0[0:24][3:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("D_REF: Min", new Message_33(0L, false, 0, 0, -32768, new Packet_15()), "[33:8][20:10][0:32]0[0:24][0:2][-32768:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("D_REF: Max", new Message_33(0L, false, 0, 0, 32767, new Packet_15()), "[33:8][20:10][0:32]0[0:24][0:2][32767:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}"),

                Arguments.of("packets: Empty", new Message_33(), "[33:8][20:10][0:32]0[0:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*0}"),
                Arguments.of("packets: 1 Element", fill(new Message_33(), new Packet_42(), 1), "[33:8][34:10][0:32]0[0:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*1}"),
                Arguments.of("packets: 1+ Elements", fill(new Message_33(), new Packet_42(), 2), "[33:8][49:10][0:32]0[0:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*2}"),
                Arguments.of("packets: Max Elements", fill(new Message_33(), new Packet_42(), 31), "[33:8][458:10][0:32]0[0:24][0:2][0:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*31}"),

                Arguments.of("all", new Message_33(42967295L, true, 187215, 1, -13943, new Packet_15()), "[33:8][20:10][42967295:32]1[187215:24][1:2][-13943:16]{[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_33(4294967296L, false, 0, 0, 0, new Packet_15()), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_33(0L, false, 16777216, 0, 0, new Packet_15()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Message_33(0L, false, 0, 4, 0, new Packet_15()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_REF: Overflow", new Message_33(0L, false, 0, 0, -32769, new Packet_15()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_REF: Negative Overflow", new Message_33(0L, false, 0, 0, 32768, new Packet_15()), new IllegalArgumentException("Invalid negative value for given bit length"))
        );
    }

    public static Message_33 fill(Message_33 message_33, TrackPacket trackPacket, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            message_33.packets.add(trackPacket);
        }
        return message_33;
    }

}