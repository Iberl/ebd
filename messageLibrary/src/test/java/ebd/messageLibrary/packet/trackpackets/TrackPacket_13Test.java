package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_13Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_13(), "[13:8][0:2][75:13][0:2]0[0:14]0[0:14][0:15][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), "[13:8][0:2][75:13][0:2]0[0:14]0[0:14][0:15][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_13(3, 0, false, 0, 0, new Packet_13.Packet_13_Section()), "[13:8][3:2][75:13][0:2]0[0:14]0[0:14][0:15][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), "[13:8][0:2][75:13][0:2]0[0:14]0[0:14][0:15][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_13(0, 3, false, 0, 0, new Packet_13.Packet_13_Section()), "[13:8][0:2][75:13][3:2]0[0:14]0[0:14][0:15][0:5]"),
                Arguments.of("Q_NEWCOUNTRY: False", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), "[13:8][0:2][75:13][0:2]0[0:14]0[0:14][0:15][0:5]"),
                Arguments.of("Q_NEWCOUNTRY: True", new Packet_13(0, 0, true, 0, 0, new Packet_13.Packet_13_Section()), "[13:8][0:2][85:13][0:2]1[0:10][0:14]0[0:14][0:15][0:5]"),
                Arguments.of("NID_C: Min", new Packet_13(0, 0, true, 0, 0, new Packet_13.Packet_13_Section()), "[13:8][0:2][85:13][0:2]1[0:10][0:14]0[0:14][0:15][0:5]"),
                Arguments.of("NID_C: Max", new Packet_13(0, 0, true, 1023, 0, new Packet_13.Packet_13_Section()), "[13:8][0:2][85:13][0:2]1[1023:10][0:14]0[0:14][0:15][0:5]"),
                Arguments.of("NID_BG: Min", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), "[13:8][0:2][75:13][0:2]0[0:14]0[0:14][0:15][0:5]"),
                Arguments.of("NID_BG: Max", new Packet_13(0, 0, false, 0, 16383, new Packet_13.Packet_13_Section()), "[13:8][0:2][75:13][0:2]0[16383:14]0[0:14][0:15][0:5]"),

                Arguments.of("section: Q_NEWCOUNTRY: False", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section(false, 0, 0, 0)), "[13:8][0:2][75:13][0:2]0[0:14]0[0:14][0:15][0:5]"),
                Arguments.of("section: Q_NEWCOUNTRY: True", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section(true, 0, 0, 0)), "[13:8][0:2][85:13][0:2]0[0:14]1[0:10][0:14][0:15][0:5]"),
                Arguments.of("section: NID_C: Min", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section(true, 0, 0, 0)), "[13:8][0:2][85:13][0:2]0[0:14]1[0:10][0:14][0:15][0:5]"),
                Arguments.of("section: NID_C: Max", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section(true, 1023, 0, 0)), "[13:8][0:2][85:13][0:2]0[0:14]1[1023:10][0:14][0:15][0:5]"),
                Arguments.of("section: NID_BG: Min", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section(false, 0, 0, 0)), "[13:8][0:2][75:13][0:2]0[0:14]0[0:14][0:15][0:5]"),
                Arguments.of("section: NID_BG: Max", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section(false, 0, 16383, 0)), "[13:8][0:2][75:13][0:2]0[0:14]0[16383:14][0:15][0:5]"),
                Arguments.of("section: D_SR: Min", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section(false, 0, 0, 0)), "[13:8][0:2][75:13][0:2]0[0:14]0[0:14][0:15][0:5]"),
                Arguments.of("section: D_SR: Max", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section(false, 0, 0, 32767)), "[13:8][0:2][75:13][0:2]0[0:14]0[0:14][32767:15][0:5]"),

                Arguments.of("sections: Empty", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), "[13:8][0:2][75:13][0:2]0[0:14]0[0:14][0:15][0:5]"),
                Arguments.of("sections: 1 Element", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(false, 0, 0, 0), 1), "[13:8][0:2][105:13][0:2]0[0:14]0[0:14][0:15][1:5]{0[0:14][0:15]*1}"),
                Arguments.of("sections: Q_NEWCOUNTRY: False", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(false, 0, 0, 0), 1), "[13:8][0:2][105:13][0:2]0[0:14]0[0:14][0:15][1:5]{0[0:14][0:15]*1}"),
                Arguments.of("sections: Q_NEWCOUNTRY: True", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(true, 0, 0, 0), 1), "[13:8][0:2][115:13][0:2]0[0:14]0[0:14][0:15][1:5]{1[0:10][0:14][0:15]*1}"),
                Arguments.of("sections: NID_C: Min", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(true, 0, 0, 0), 1), "[13:8][0:2][115:13][0:2]0[0:14]0[0:14][0:15][1:5]{1[0:10][0:14][0:15]*1}"),
                Arguments.of("sections: NID_C: Max", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(true, 1023, 0, 0), 1), "[13:8][0:2][115:13][0:2]0[0:14]0[0:14][0:15][1:5]{1[1023:10][0:14][0:15]*1}"),
                Arguments.of("sections: NID_BG: Min", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(false, 0, 0, 0), 1), "[13:8][0:2][105:13][0:2]0[0:14]0[0:14][0:15][1:5]{0[0:14][0:15]*1}"),
                Arguments.of("sections: NID_BG: Max", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(false, 0, 16383, 0), 1), "[13:8][0:2][105:13][0:2]0[0:14]0[0:14][0:15][1:5]{0[16383:14][0:15]*1}"),
                Arguments.of("sections: D_SR: Min", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(false, 0, 0, 0), 1), "[13:8][0:2][105:13][0:2]0[0:14]0[0:14][0:15][1:5]{0[0:14][0:15]*1}"),
                Arguments.of("sections: D_SR: Max", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(false, 0, 0, 32767), 1), "[13:8][0:2][105:13][0:2]0[0:14]0[0:14][0:15][1:5]{0[0:14][32767:15]*1}"),
                Arguments.of("sections: 1+ Elements", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(false, 0, 0, 7336), 2), "[13:8][0:2][135:13][0:2]0[0:14]0[0:14][0:15][2:5]{0[0:14][7336:15]*2}"),
                Arguments.of("sections: Max Elements", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(false, 0, 2371, 0), 31), "[13:8][0:2][1005:13][0:2]0[0:14]0[0:14][0:15][31:5]{0[2371:14][0:15]*31}"),

                Arguments.of("all", fill(new Packet_13(2, 2, true, 232, 9235, new Packet_13.Packet_13_Section(true, 533, 6542, 28425)), new Packet_13.Packet_13_Section(true, 1004, 11258, 31941), 1), "[13:8][2:2][135:13][2:2]1[232:10][9235:14]1[533:10][6542:14][28425:15][1:5]{1[1004:10][11258:14][31941:15]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_13(4, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_13(0, 4, false, 0, 0, new Packet_13.Packet_13_Section()), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_NEWCOUNTRY is a boolean -> no overflow test needed
                Arguments.of("NID_C: Overflow", new Packet_13(0, 0, true, 1024, 0, new Packet_13.Packet_13_Section()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_BG: Overflow", new Packet_13(0, 0, false, 0, 16384, new Packet_13.Packet_13_Section()), new IllegalArgumentException("Invalid value for given bit length")),

                // sections: Q_NEWCOUNTRY is a boolean -> no overflow test needed
                Arguments.of("section: NID_C: Overflow", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section(true, 1024, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("section: NID_BG: Overflow", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section(false, 0, 16384, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("section: D_SR: Overflow", new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section(false, 0, 0, 32768)), new IllegalArgumentException("Invalid value for given bit length")),

                // sections: Q_NEWCOUNTRY is a boolean -> no overflow test needed
                Arguments.of("sections: NID_C: Overflow", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(true, 1024, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("sections: NID_BG: Overflow", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(false, 0, 16384, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("sections: D_SR: Overflow", fill(new Packet_13(0, 0, false, 0, 0, new Packet_13.Packet_13_Section()), new Packet_13.Packet_13_Section(false, 0, 0, 32768), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_13 fill(Packet_13 packet_13, Packet_13.Packet_13_Section section, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_13.sections.add(section);
        }
        return packet_13;
    }

}