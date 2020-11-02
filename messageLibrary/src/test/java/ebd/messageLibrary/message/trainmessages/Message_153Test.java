package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessageTestBase;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.Packet_1;
import ebd.messageLibrary.util.exception.MissingInformationException;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_153Test extends TrainMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_153(), "[153:8][27:10][0:32][0:24][0:10][0:14]0{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("T_TRAIN: Min", new Message_153(0L, 0, 0, 0, false, new Packet_0()), "[153:8][27:10][0:32][0:24][0:10][0:14]0{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("T_TRAIN: Max", new Message_153(4294967295L, 0, 0, 0, false, new Packet_0()), "[153:8][27:10][4294967295:32][0:24][0:10][0:14]0{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_ENGINE: Min", new Message_153(0L, 0, 0, 0, false, new Packet_0()), "[153:8][27:10][0:32][0:24][0:10][0:14]0{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_ENGINE: Max", new Message_153(0L, 16777215, 0, 0, false, new Packet_0()), "[153:8][27:10][0:32][16777215:24][0:10][0:14]0{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_C: Min", new Message_153(0L, 0, 0, 0, false, new Packet_0()), "[153:8][27:10][0:32][0:24][0:10][0:14]0{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_C: Max", new Message_153(0L, 0, 1023, 0,  false, new Packet_0()), "[153:8][27:10][0:32][0:24][1023:10][0:14]0{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_BG: Min", new Message_153(0L, 0, 0, 0, false, new Packet_0()), "[153:8][27:10][0:32][0:24][0:10][0:14]0{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("NID_BG: Max", new Message_153(0L, 0, 0, 16383, false, new Packet_0()), "[153:8][27:10][0:32][0:24][0:10][16383:14]0{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("Q_INFILL: False", new Message_153(0L, 0, 0, 0, false, new Packet_0()), "[153:8][27:10][0:32][0:24][0:10][0:14]0{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("Q_INFILL: True", new Message_153(0L, 0, 0, 0, true, new Packet_0()), "[153:8][27:10][0:32][0:24][0:10][0:14]1{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("positionPacket: Packet_0", new Message_153(0L, 0, 0, 0, false, new Packet_0()), "[153:8][27:10][0:32][0:24][0:10][0:14]0{[0:8][114:13][0:2][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),
                Arguments.of("positionPacket: Packet_1", new Message_153(0L, 0, 0, 0, false, new Packet_1()), "[153:8][30:10][0:32][0:24][0:10][0:14]0{[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}"),

                Arguments.of("all", new Message_153(97235L, 623982, 675, 9267, true, new Packet_1()), "[153:8][30:10][97235:32][623982:24][675:10][9267:14]1{[1:8][138:13][0:2][0:24][0:24][0:15][0:2][0:2][0:15][0:15][0:2][0:7][0:2][0:4][0:3]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("T_TRAIN: Overflow", new Message_153(4294967296L, 0, 0, 0, false, new Packet_0()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_ENGINE: Overflow", new Message_153(0L, 16777216, 0, 0, false, new Packet_1()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_EM: Overflow", new Message_153(0L, 0, 1024, 0, false, new Packet_0()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_EMERGENCYSTOP: Overflow", new Message_153(0L, 0, 0, 16384, false, new Packet_0()), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_INFILL is a boolean -> no overflow test needed
                Arguments.of("positionPacket: Null", new Message_153(0L, 0, 0, 0, false, null), new MissingInformationException("positionPacket is set to null"))
        );
    }

}