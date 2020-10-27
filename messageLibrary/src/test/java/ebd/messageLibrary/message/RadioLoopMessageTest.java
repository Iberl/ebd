package ebd.messageLibrary.message;

import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_12;
import ebd.messageLibrary.packet.trackpackets.Packet_72;
import ebd.messageLibrary.packet.trackpackets.Packet_76;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class RadioLoopMessageTest extends RadioLoopMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new RadioLoopMessage(), "0[0:7]0[0:10][0:14][255:8]"),
                Arguments.of("Q_UPDOWN: False", new RadioLoopMessage(false, 0, false, 0, 0), "0[0:7]0[0:10][0:14][255:8]"),
                Arguments.of("Q_UPDOWN: True", new RadioLoopMessage(true, 0, false, 0, 0), "1[0:7]0[0:10][0:14][255:8]"),
                Arguments.of("M_VERSION: Min", new RadioLoopMessage(false, 0, false, 0, 0), "0[0:7]0[0:10][0:14][255:8]"),
                Arguments.of("M_VERSION: Max", new RadioLoopMessage(false, 127, false, 0, 0), "0[127:7]0[0:10][0:14][255:8]"),
                Arguments.of("Q_MEDIA: False", new RadioLoopMessage(false, 0, false, 0, 0), "0[0:7]0[0:10][0:14][255:8]"),
                Arguments.of("Q_MEDIA: True", new RadioLoopMessage(false, 0, true, 0, 0), "0[0:7]1[0:10][0:14][255:8]"),
                Arguments.of("NID_C: Min", new RadioLoopMessage(false, 0, false, 0, 0), "0[0:7]0[0:10][0:14][255:8]"),
                Arguments.of("NID_C: Max", new RadioLoopMessage(false, 0, false, 1023, 0), "0[0:7]0[1023:10][0:14][255:8]"),
                Arguments.of("NID_LOOP: Min", new RadioLoopMessage(false, 0, false, 0, 0), "0[0:7]0[0:10][0:14][255:8]"),
                Arguments.of("NID_LOOP: Max", new RadioLoopMessage(false, 0, false, 0, 16383), "0[0:7]0[0:10][16383:14][255:8]"),
                Arguments.of("packets: Empty", new RadioLoopMessage(false, 0, false, 0, 0), "0[0:7]0[0:10][0:14][255:8]"),
                Arguments.of("packets: 1 Element", fill(new RadioLoopMessage(), new Packet_12(), 1), "0[0:7]0[0:10][0:14]{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}[255:8]"),
                Arguments.of("packets: 1+ Elements", fill(new RadioLoopMessage(), new Packet_12(), 2), "0[0:7]0[0:10][0:14]{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*2}[255:8]"),
                Arguments.of("packets: Max Elements", fill(new RadioLoopMessage(), new Packet_76(), 31), "0[0:7]0[0:10][0:14]{[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]*31}[255:8]"),
                Arguments.of("all", fill(new RadioLoopMessage(true, 45, true, 823, 2950), new Packet_72(), 5), "1[45:7]1[823:10][2950:14]{[72:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]*5}[255:8]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                // Q_UPDOWN is a boolean -> no overflow test needed
                Arguments.of("M_VERSION: Overflow", new RadioLoopMessage(false, 128, false, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_MEDIA is a boolean -> no overflow test needed
                Arguments.of("NID_C: Overflow", new RadioLoopMessage(false, 0, false, 1024, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_LOOP: Overflow", new RadioLoopMessage(false, 0, false, 0, 16384), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

    public static RadioLoopMessage fill(RadioLoopMessage radioLoopMessage, TrackPacket trackPacket, int count) {
        assert (count < 32);
        for(int i = 0; i < count; i++) {
            radioLoopMessage.packets.add(trackPacket);
        }
        return radioLoopMessage;
    }

}