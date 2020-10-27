package ebd.messageLibrary.message;

import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_0;
import ebd.messageLibrary.packet.trackpackets.Packet_12;
import ebd.messageLibrary.packet.trackpackets.Packet_72;
import ebd.messageLibrary.packet.trackpackets.Packet_76;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TelegramTest extends TelegramTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Telegram(), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("Q_UPDOWN: False", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("Q_UPDOWN: True", new Telegram(true, 0, false, 0, 0, 0, 0, 0, 0, false), "1[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("M_VERSION: Min", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("M_VERSION: Max", new Telegram(false, 127, false, 0, 0, 0, 0, 0, 0, false), "0[127:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("Q_MEDIA: False", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("Q_MEDIA: True", new Telegram(false, 0, true, 0, 0, 0, 0, 0, 0, false), "0[0:7]1[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("N_PIG: Min", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("N_PIG: Max", new Telegram(false, 0, false, 7, 0, 0, 0, 0, 0, false), "0[0:7]0[7:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("N_TOTAL: Min", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("N_TOTAL: Max", new Telegram(false, 0, false, 0, 7, 0, 0, 0, 0, false), "0[0:7]0[0:3][7:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("M_DUP: Min", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("M_DUP: Max", new Telegram(false, 0, false, 0, 0, 3, 0, 0, 0, false), "0[0:7]0[0:3][0:3][3:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("M_MCOUNT: Min", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("M_MCOUNT: Max", new Telegram(false, 0, false, 0, 0, 0, 255, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][255:8][0:10][0:14]0[255:8]"),
                Arguments.of("NID_C: Min", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("NID_C: Max", new Telegram(false, 0, false, 0, 0, 0, 0, 1023, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][1023:10][0:14]0[255:8]"),
                Arguments.of("NID_BG: Min", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("NID_BG: Max", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 16383, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][16383:14]0[255:8]"),
                Arguments.of("Q_LINK: False", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("Q_LINK: True", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, true), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]1[255:8]"),
                Arguments.of("packet_0: null", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("packet_0: set", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false, new Packet_0()), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0{[0:8][0:6]*1}[255:8]"),
                Arguments.of("packets: Empty", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 0, false), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0[255:8]"),
                Arguments.of("packets: 1 Element", fill(new Telegram(), new Packet_12(), 1), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*1}[255:8]"),
                Arguments.of("packets: 1+ Elements", fill(new Telegram(), new Packet_12(), 2), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0{[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000*2}[255:8]"),
                Arguments.of("packets: Max Elements", fill(new Telegram(), new Packet_76(), 31), "0[0:7]0[0:3][0:3][0:2][0:8][0:10][0:14]0{[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]*31}[255:8]"),
                Arguments.of("all", fill(new Telegram(true, 45, true, 5, 3, 2, 234, 933, 5235, true, new Packet_0()), new Packet_72(), 5), "1[45:7]1[5:3][3:3][2:2][234:8][933:10][5235:14]1{[0:8][0:6]*1}{[72:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]*5}[255:8]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                // Q_UPDOWN is a boolean -> no overflow test needed
                Arguments.of("M_VERSION: Overflow", new Telegram(false, 128, false, 0, 0, 0, 0, 0, 0, false), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_MEDIA is a boolean -> no overflow test needed
                Arguments.of("N_PIG: Overflow", new Telegram(false, 0, false, 8, 0, 0, 0, 0, 0, false), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("N_TOTAL: Overflow", new Telegram(false, 0, false, 0, 8, 0, 0, 0, 0, false), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_DUP: Overflow", new Telegram(false, 0, false, 0, 0, 4, 0, 0, 0, false), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_MCOUNT: Overflow", new Telegram(false, 0, false, 0, 0, 0, 256, 0, 0, false), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_C: Overflow", new Telegram(false, 0, false, 0, 0, 0, 0, 1024, 0, false), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_BG: Overflow", new Telegram(false, 0, false, 0, 0, 0, 0, 0, 16384, false), new IllegalArgumentException("Invalid value for given bit length"))
                // Q_LINK is a boolean -> no overflow test needed
                // packet_0 can be null -> no null test needed
        );
    }


    public static Telegram fill(Telegram telegram, TrackPacket trackPacket, int count) {
        assert (count < 32);
        for(int i = 0; i < count; i++) {
            telegram.packets.add(trackPacket);
        }
        return telegram;
    }

}
