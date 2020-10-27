package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_12;
import ebd.messageLibrary.packet.trackpackets.Packet_136;
import ebd.messageLibrary.packet.trackpackets.Packet_42;
import ebd.messageLibrary.util.exception.MissingInformationException;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_37Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_37(), "[37:8][24:10][0:32]0[0:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("T_TRAIN: Min", new Message_37(0L, false, 0, new Packet_136(), new Packet_12()), "[37:8][24:10][0:32]0[0:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("T_TRAIN: Max", new Message_37(4294967295L, false, 0, new Packet_136(), new Packet_12()), "[37:8][24:10][4294967295:32]0[0:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("M_ACK: False", new Message_37(0L, false, 0, new Packet_136(), new Packet_12()), "[37:8][24:10][0:32]0[0:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("M_ACK: True", new Message_37(0L, true, 0, new Packet_136(), new Packet_12()), "[37:8][24:10][0:32]1[0:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("NID_LRBG: Min", new Message_37(0L, false, 0, new Packet_136(), new Packet_12()), "[37:8][24:10][0:32]0[0:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}"),
                Arguments.of("NID_LRBG: Max", new Message_37(0L, false, 16777215, new Packet_136(), new Packet_12()), "[37:8][24:10][0:32]0[16777215:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}"),

                Arguments.of("packets: Empty", new Message_37(), "[37:8][24:10][0:32]0[0:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*0}"),
                Arguments.of("packets: 1 Element", fill(new Message_37(), new Packet_42(), 1), "[37:8][38:10][0:32]0[0:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*1}"),
                Arguments.of("packets: 1+ Elements", fill(new Message_37(), new Packet_42(), 2), "[37:8][52:10][0:32]0[0:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*2}"),
                Arguments.of("packets: Max Elements", fill(new Message_37(), new Packet_42(), 31), "[37:8][462:10][0:32]0[0:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*31}"),

                Arguments.of("all", new Message_37(42967295L, true, 187215, new Packet_136(), new Packet_12()), "[37:8][24:10][42967295:32]1[187215:24]{[136:8][0:2][38:13]0[0:14]*1}{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_37(4294967296L, false, 0, new Packet_136(), new Packet_12()), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_37(0L, false, 16777216, new Packet_136(), new Packet_12()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("packet_136: Null", new Message_37(0L, false, 0, null, new Packet_12()), new MissingInformationException("packet_136 is set to null")),
                Arguments.of("packet_12: Null", new Message_37(0L, false, 0, new Packet_136(), null), new MissingInformationException("packet_12 is set to null"))
        );
    }

    public static Message_37 fill(Message_37 message_37, TrackPacket trackPacket, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            message_37.packets.add(trackPacket);
        }
        return message_37;
    }

}