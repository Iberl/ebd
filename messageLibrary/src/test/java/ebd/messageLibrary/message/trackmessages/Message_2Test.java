package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_42;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_2Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_2(), "[2:8][12:10][0:32]0[0:24][0:2][0:15]"),
                Arguments.of("T_TRAIN: Min", new Message_2(0L, false, 0, 0, 0), "[2:8][12:10][0:32]0[0:24][0:2][0:15]"),
                Arguments.of("T_TRAIN: Max", new Message_2(4294967295L, false, 0, 0, 0), "[2:8][12:10][4294967295:32]0[0:24][0:2][0:15]"),
                Arguments.of("M_ACK: False", new Message_2(0L, false, 0, 0, 0), "[2:8][12:10][0:32]0[0:24][0:2][0:15]"),
                Arguments.of("M_ACK: True", new Message_2(0L, true, 0, 0, 0), "[2:8][12:10][0:32]1[0:24][0:2][0:15]"),
                Arguments.of("NID_LRBG: Min", new Message_2(0L, false, 0, 0, 0), "[2:8][12:10][0:32]0[0:24][0:2][0:15]"),
                Arguments.of("NID_LRBG: Max", new Message_2(0L, false, 16777215, 0, 0), "[2:8][12:10][0:32]0[16777215:24][0:2][0:15]"),
                Arguments.of("Q_SCALE: Min", new Message_2(0L, false, 0, 0, 0), "[2:8][12:10][0:32]0[0:24][0:2][0:15]"),
                Arguments.of("Q_SCALE: Max", new Message_2(0L, false, 0, 3, 0), "[2:8][12:10][0:32]0[0:24][3:2][0:15]"),
                Arguments.of("D_SR: Min", new Message_2(0L, false, 0, 0, 0), "[2:8][12:10][0:32]0[0:24][0:2][0:15]"),
                Arguments.of("D_SR: Max", new Message_2(0L, false, 0, 0, 32767), "[2:8][12:10][0:32]0[0:24][0:2][32767:15]"),

                Arguments.of("packets: Empty", new Message_2(), "[2:8][12:10][0:32]0[0:24][0:2][0:15]{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*0}"),
                Arguments.of("packets: 1 Element", fill(new Message_2(), new Packet_42(), 1), "[2:8][26:10][0:32]0[0:24][0:2][0:15]{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*1}"),
                Arguments.of("packets: 1+ Elements", fill(new Message_2(), new Packet_42(), 2), "[2:8][40:10][0:32]0[0:24][0:2][0:15]{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*2}"),
                Arguments.of("packets: Max Elements", fill(new Message_2(), new Packet_42(), 71), "[2:8][1015:10][0:32]0[0:24][0:2][0:15]{[42:8][0:2][113:13]0[0:10][0:14][0:64]0*71}"),

                Arguments.of("all", new Message_2(42967295L, true, 187215, 2, 30214), "[2:8][12:10][42967295:32]1[187215:24][2:2][30214:15]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_2(4294967296L, false, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // M_ACK is a boolean -> no overflow test needed
                Arguments.of("NID_LRBG: Overflow", new Message_2(0L, false, 16777216, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Message_2(0L, false, 0, 4, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_SR: Overflow", new Message_2(0L, false, 0, 0, 32768), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

    public static Message_2 fill(Message_2 message_2, TrackPacket trackPacket, int count) {
        for(int i = 0; i < count; i++) {
            message_2.packets.add(trackPacket);
        }
        return message_2;
    }

}