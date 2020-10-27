package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_6;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_28Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_28(), "[28:8][14:10][0:32]0[0:24][0:32]"),
                Arguments.of("T_TRAIN: Min", new Message_28(0L, false, 0, 0), "[28:8][14:10][0:32]0[0:24][0:32]"),
                Arguments.of("T_TRAIN: Max", new Message_28(4294967295L, false, 0, 0), "[28:8][14:10][4294967295:32]0[0:24][0:32]"),
                Arguments.of("M_ACK: False", new Message_28(0L, false, 0, 0), "[28:8][14:10][0:32]0[0:24][0:32]"),
                Arguments.of("M_ACK: True", new Message_28(0L, true, 0, 0), "[28:8][14:10][0:32]1[0:24][0:32]"),
                Arguments.of("NID_LRBG: Min", new Message_28(0L, false, 0, 0), "[28:8][14:10][0:32]0[0:24][0:32]"),
                Arguments.of("NID_LRBG: Max", new Message_28(0L, false, 16777215, 0), "[28:8][14:10][0:32]0[16777215:24][0:32]"),
                Arguments.of("T_TRAIN_RQST: Min", new Message_28(0L, false, 0, 0L), "[28:8][14:10][0:32]0[0:24][0:32]"),
                Arguments.of("T_TRAIN_RQST: Max", new Message_28(0L, false, 0, 4294967295L), "[28:8][14:10][0:32]0[0:24][4294967295:32]"),

                Arguments.of("packets: Empty", new Message_28(), "[28:8][14:10][0:32]0[0:24][0:32][0:5]{[6:8][0:2][40:13]0[0:6][0:10]*0}"),
                Arguments.of("packets: 1 Element", fill(new Message_28(), new Packet_6(), 1), "[28:8][19:10][0:32]0[0:24][0:32]{[6:8][0:2][40:13]0[0:6][0:10]*1}"),
                Arguments.of("packets: 1+ Elements", fill(new Message_28(), new Packet_6(), 2), "[28:8][24:10][0:32]0[0:24][0:32]{[6:8][0:2][40:13]0[0:6][0:10]*2}"),
                Arguments.of("packets: Max Elements", fill(new Message_28(), new Packet_6(), 31), "[28:8][169:10][0:32]0[0:24][0:32]{[6:8][0:2][40:13]0[0:6][0:10]*31}"),
                
                Arguments.of("all", new Message_28(42967295L, true, 187215, 42948295L), "[28:8][14:10][42967295:32]1[187215:24][42948295:32]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_28(4294967296L, false, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_28(0L, false, 16777216, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("T_TRAIN_RQST: Overflow", new Message_28(0L, false, 0, 4294967296L), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

    public static Message_28 fill(Message_28 message_28, TrackPacket trackPacket, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            message_28.packets.add(trackPacket);
        }
        return message_28;
    }
    
}