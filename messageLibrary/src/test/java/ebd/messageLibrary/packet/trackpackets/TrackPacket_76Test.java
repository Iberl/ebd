package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_76Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_76(), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("Q_DIR: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("Q_DIR: Max", new Packet_76(3, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][3:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("Q_SCALE: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("Q_SCALE: Max", new Packet_76(0, 3, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][3:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("Q_TEXTCLASS: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("Q_TEXTCLASS: Max", new Packet_76(0, 0, 3, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][3:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("Q_TEXTDISPLAY: False", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("Q_TEXTDISPLAY: True", new Packet_76(0, 0, 0, true, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]1[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("D_TEXTDISPLAY: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("D_TEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 32767, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[32767:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),

                Arguments.of("startevent: M_MODETEXTDISPLAY: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(0, 0, 0), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("startevent: M_MODETEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(15, 0, 0), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][15:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("startevent: M_LEVELTEXTDISPLAY: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(0, 0, 0), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("startevent: M_LEVELTEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(0, 7, 0), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][7:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("startevent: NID_NTC: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(0, 1, 0), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][100:13][0:2][0:2]0[0:15][0:4][1:3][0:8][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("startevent: NID_NTC: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(0, 1, 255), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][100:13][0:2][0:2]0[0:15][0:4][1:3][255:8][0:15][0:10][0:4][0:3][0:2][0:8]"),

                Arguments.of("L_TEXTDISPLAY: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("L_TEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 32767, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][32767:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("T_TEXTDISPLAY: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("T_TEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 1023, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][1023:10][0:4][0:3][0:2][0:8]"),

                Arguments.of("endevent: M_MODETEXTDISPLAY: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(0, 0, 0), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("endevent: M_MODETEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(15, 0, 0), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][15:4][0:3][0:2][0:8]"),
                Arguments.of("endevent: M_LEVELTEXTDISPLAY: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(0, 0, 0), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("endevent: M_LEVELTEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(0, 7, 0), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][7:3][0:2][0:8]"),
                Arguments.of("endevent: NID_NTC: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(0, 1, 0), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][100:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][1:3][0:8][0:2][0:8]"),
                Arguments.of("endevent: NID_NTC: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(0, 1, 255), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][100:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][1:3][255:8][0:2][0:8]"),

                Arguments.of("Q_TEXTCONFIRM: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("Q_TEXTCONFIRM: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 3, false, false, 0, 0, 0, 0), "[76:8][0:2][94:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][3:2]00[0:8]"),
                Arguments.of("Q_CONFTEXTDISPLAY: False", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 2, false, false, 0, 0, 0, 0), "[76:8][0:2][94:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][2:2]00[0:8]"),
                Arguments.of("Q_CONFTEXTDISPLAY: True", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 1, true, false, 0, 0, 0, 0), "[76:8][0:2][94:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][1:2]10[0:8]"),
                Arguments.of("Q_TEXTREPORT: False", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 2, false, false, 0, 0, 0, 0), "[76:8][0:2][94:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][2:2]00[0:8]"),
                Arguments.of("Q_TEXTREPORT: True", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 1, false, true, 0, 0, 0, 0), "[76:8][0:2][126:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][1:2]01[0:8][0:10][0:14][0:8]"),
                Arguments.of("NID_TEXTMESSAGE: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 2, false, true, 0, 0, 0, 0), "[76:8][0:2][126:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][2:2]01[0:8][0:10][0:14][0:8]"),
                Arguments.of("NID_TEXTMESSAGE: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 1, false, true, 255, 0, 0, 0), "[76:8][0:2][126:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][1:2]01[255:8][0:10][0:14][0:8]"),
                Arguments.of("NID_C: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 2, false, true, 0, 0, 0, 0), "[76:8][0:2][126:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][2:2]01[0:8][0:10][0:14][0:8]"),
                Arguments.of("NID_C: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 1, false, true, 0, 1023, 0, 0), "[76:8][0:2][126:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][1:2]01[0:8][1023:10][0:14][0:8]"),
                Arguments.of("NID_RBC: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 2, false, true, 0, 0, 0, 0), "[76:8][0:2][126:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][2:2]01[0:8][0:10][0:14][0:8]"),
                Arguments.of("NID_RBC: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 1, false, true, 0, 0, 16383, 0), "[76:8][0:2][126:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][1:2]01[0:8][0:10][16383:14][0:8]"),
                Arguments.of("Q_TEXT: Min", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][0:8]"),
                Arguments.of("Q_TEXT: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 255), "[76:8][0:2][92:13][0:2][0:2]0[0:15][0:4][0:3][0:15][0:10][0:4][0:3][0:2][255:8]"),

                Arguments.of("all", new Packet_76(1, 2, 2, true, 8925, new TextPacket.TextPacket_Event(12, 1, 234), 6235, 846, new TextPacket.TextPacket_Event(8, 1, 192), 2, false, true, 67, 999, 12486, 177), "[76:8][1:2][142:13][2:2][2:2]1[8925:15][12:4][1:3][234:8][6235:15][846:10][8:4][1:3][192:8][2:2]01[67:8][999:10][12486:14][177:8]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Max", new Packet_76(4, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Max", new Packet_76(0, 4, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_TEXTCLASS: Max", new Packet_76(0, 0, 4, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_TEXTDISPLAY is a boolean -> no overflow test needed
                Arguments.of("D_TEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 32768, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("startevent: M_MODETEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(16, 0, 0), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("startevent: M_LEVELTEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(0, 8, 0), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("startevent: NID_NTC: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(0, 1, 256), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("L_TEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 32768, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("T_TEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 1024, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("endevent: M_MODETEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(16, 0, 0), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("endevent: M_LEVELTEXTDISPLAY: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(0, 8, 0), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("endevent: NID_NTC: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(0, 1, 256), 0, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("Q_TEXTCONFIRM: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 4, false, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_CONFTEXTDISPLAY is a boolean -> no overflow test needed
                // Q_TEXTREPORT is a boolean -> no overflow test needed
                Arguments.of("NID_TEXTMESSAGE: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 1, false, true, 256, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_C: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 1, false, true, 0, 1024, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_RBC: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 1, false, true, 0, 0, 16384, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_TEXT: Max", new Packet_76(0, 0, 0, false, 0, new TextPacket.TextPacket_Event(), 0, 0, new TextPacket.TextPacket_Event(), 0, false, false, 0, 0, 0, 256), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

}