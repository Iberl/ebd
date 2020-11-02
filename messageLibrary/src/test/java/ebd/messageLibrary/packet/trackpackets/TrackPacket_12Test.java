package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_12Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_12(), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_DIR: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_DIR: Max", new Packet_12(3, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][3:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_SCALE: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_SCALE: Max", new Packet_12(0, 3, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][3:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("V_MAIN: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("V_MAIN: Max", new Packet_12(0, 0, 127, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][127:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("V_LOA: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("V_LOA: Max", new Packet_12(0, 0, 0, 127, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][127:7][0:10][0:5][0:15]0000"),
                Arguments.of("T_LOA: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("T_LOA: Max", new Packet_12(0, 0, 0, 0, 1023, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][1023:10][0:5][0:15]0000"),
                
                Arguments.of("sections: Empty", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("sections: 1 Element", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(), 1), "[12:8][0:2][89:13][0:2][0:7][0:7][0:10][1:5]{[0:15]0*1}[0:15]0000"),
                Arguments.of("sections: L_SECTION: Min", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(0, false, 0, 0), 1), "[12:8][0:2][89:13][0:2][0:7][0:7][0:10][1:5]{[0:15]0*1}[0:15]0000"),
                Arguments.of("sections: L_SECTION: Max", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(32767, false, 0, 0), 1), "[12:8][0:2][89:13][0:2][0:7][0:7][0:10][1:5]{[32767:15]0*1}[0:15]0000"),
                Arguments.of("sections: Q_SECTIONTIMER: False", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(0, false, 0, 0), 1), "[12:8][0:2][89:13][0:2][0:7][0:7][0:10][1:5]{[0:15]0*1}[0:15]0000"),
                Arguments.of("sections: Q_SECTIONTIMER: True", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(0, true, 0, 0), 1), "[12:8][0:2][114:13][0:2][0:7][0:7][0:10][1:5]{[0:15]1[0:10][0:15]*1}[0:15]0000"),
                Arguments.of("sections: T_SECTIONTIMER: Min", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(0, true, 0, 0), 1), "[12:8][0:2][114:13][0:2][0:7][0:7][0:10][1:5]{[0:15]1[0:10][0:15]*1}[0:15]0000"),
                Arguments.of("sections: T_SECTIONTIMER: Max", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(0, true, 1023, 0), 1), "[12:8][0:2][114:13][0:2][0:7][0:7][0:10][1:5]{[0:15]1[1023:10][0:15]*1}[0:15]0000"),
                Arguments.of("sections: D_SECTIONTIMERSTOPLOC: Min", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(0, true, 0, 0), 1), "[12:8][0:2][114:13][0:2][0:7][0:7][0:10][1:5]{[0:15]1[0:10][0:15]*1}[0:15]0000"),
                Arguments.of("sections: D_SECTIONTIMERSTOPLOC: Max", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(0, true, 0, 32767), 1), "[12:8][0:2][114:13][0:2][0:7][0:7][0:10][1:5]{[0:15]1[0:10][32767:15]*1}[0:15]0000"),
                Arguments.of("sections: 1+ Elements", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(1624, false, 0, 0), 2), "[12:8][0:2][105:13][0:2][0:7][0:7][0:10][2:5]{[1624:15]0*2}[0:15]0000"),
                Arguments.of("sections: Max Elements", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(9134, false, 0, 0), 31), "[12:8][0:2][569:13][0:2][0:7][0:7][0:10][31:5]{[9134:15]0*31}[0:15]0000"),

                Arguments.of("endsection: L_SECTION: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(0, false, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("endsection: L_SECTION: Max", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(32767, false, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][32767:15]0000"),
                Arguments.of("endsection: Q_SECTIONTIMER: False", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(0, false, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("endsection: Q_SECTIONTIMER: True", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(0, true, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][98:13][0:2][0:7][0:7][0:10][0:5][0:15]1[0:10][0:15]000"),
                Arguments.of("endsection: T_SECTIONTIMER: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(0, true, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][98:13][0:2][0:7][0:7][0:10][0:5][0:15]1[0:10][0:15]000"),
                Arguments.of("endsection: T_SECTIONTIMER: Max", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(0, true, 1023, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][98:13][0:2][0:7][0:7][0:10][0:5][0:15]1[1023:10][0:15]000"),
                Arguments.of("endsection: D_SECTIONTIMERSTOPLOC: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(0, true, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][98:13][0:2][0:7][0:7][0:10][0:5][0:15]1[0:10][0:15]000"),
                Arguments.of("endsection: D_SECTIONTIMERSTOPLOC: Max", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(0, true, 0, 32767), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][98:13][0:2][0:7][0:7][0:10][0:5][0:15]1[0:10][32767:15]000"),
                
                Arguments.of("Q_ENDTIMER: False", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_ENDTIMER: True", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), true, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][98:13][0:2][0:7][0:7][0:10][0:5][0:15]01[0:10][0:15]00"),
                Arguments.of("T_ENDTIMER: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), true, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][98:13][0:2][0:7][0:7][0:10][0:5][0:15]01[0:10][0:15]00"),
                Arguments.of("T_ENDTIMER: Max", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), true, 1023, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][98:13][0:2][0:7][0:7][0:10][0:5][0:15]01[1023:10][0:15]00"),
                Arguments.of("D_ENDTIMERSTARTLOC: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), true, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][98:13][0:2][0:7][0:7][0:10][0:5][0:15]01[0:10][0:15]00"),
                Arguments.of("D_ENDTIMERSTARTLOC: Max", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), true, 0, 32767, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][98:13][0:2][0:7][0:7][0:10][0:5][0:15]01[0:10][32767:15]00"),
                Arguments.of("Q_DANGERPOINT: False", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_DANGERPOINT: True", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, true, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][95:13][0:2][0:7][0:7][0:10][0:5][0:15]001[0:15][0:7]0"),
                Arguments.of("D_DP: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, true, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][95:13][0:2][0:7][0:7][0:10][0:5][0:15]001[0:15][0:7]0"),
                Arguments.of("D_DP: Max", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, true, 32767, 0, false, 0, 0, 0, 0), "[12:8][0:2][95:13][0:2][0:7][0:7][0:10][0:5][0:15]001[32767:15][0:7]0"),
                Arguments.of("V_RELEASEDP: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, true, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][95:13][0:2][0:7][0:7][0:10][0:5][0:15]001[0:15][0:7]0"),
                Arguments.of("V_RELEASEDP: Max", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, true, 0, 127, false, 0, 0, 0, 0), "[12:8][0:2][95:13][0:2][0:7][0:7][0:10][0:5][0:15]001[0:15][127:7]0"),
                Arguments.of("Q_OVERLAP: False", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[12:8][0:2][73:13][0:2][0:7][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_OVERLAP: True", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 0), "[12:8][0:2][120:13][0:2][0:7][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][0:7]"),
                Arguments.of("D_STARTOL: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 0), "[12:8][0:2][120:13][0:2][0:7][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][0:7]"),
                Arguments.of("D_STARTOL: Max", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 32767, 0, 0, 0), "[12:8][0:2][120:13][0:2][0:7][0:7][0:10][0:5][0:15]0001[32767:15][0:10][0:15][0:7]"),
                Arguments.of("T_OL: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 0), "[12:8][0:2][120:13][0:2][0:7][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][0:7]"),
                Arguments.of("T_OL: Max", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 0, 1023, 0, 0), "[12:8][0:2][120:13][0:2][0:7][0:7][0:10][0:5][0:15]0001[0:15][1023:10][0:15][0:7]"),
                Arguments.of("D_OL: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 0), "[12:8][0:2][120:13][0:2][0:7][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][0:7]"),
                Arguments.of("D_OL: Max", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 32767, 0), "[12:8][0:2][120:13][0:2][0:7][0:7][0:10][0:5][0:15]0001[0:15][0:10][32767:15][0:7]"),
                Arguments.of("V_RELEASEOL: Min", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 0), "[12:8][0:2][120:13][0:2][0:7][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][0:7]"),
                Arguments.of("V_RELEASEOL: Max", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 127), "[12:8][0:2][120:13][0:2][0:7][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][127:7]"),

                Arguments.of("all", fill(new Packet_12(2, 1, 82, 69, 628, new Packet_12.Packet_12_Section(9114, true, 157, 4290), true, 358, 9743, true, 5884, 66, true, 7255, 11, 8634, 29), new Packet_12.Packet_12_Section(331, true, 948, 327), 1), "[12:8][2:2][233:13][1:2][82:7][69:7][628:10][1:5]{[331:15]1[948:10][327:15]*1}[9114:15]1[157:10][4290:15]1[358:10][9743:15]1[5884:15][66:7]1[7255:15][11:10][8634:15][29:7]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_12(4, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_12(0, 4, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("V_MAIN: Overflow", new Packet_12(0, 0, 128, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("V_LOA: Overflow", new Packet_12(0, 0, 0, 128, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("T_LOA: Overflow", new Packet_12(0, 0, 0, 0, 1024, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("sections: L_SECTION: Overflow", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(32768, false, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                // sections: Q_SECTIONTIMER is a boolean -> no overflow test needed
                Arguments.of("sections: T_SECTIONTIMER: Overflow", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(0, true, 1024, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("sections: D_SECTIONTIMERSTOPLOC: Overflow", fill(new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_12.Packet_12_Section(0, true, 0, 32768), 1), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("endsection: L_SECTION: Overflow", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(32768, false, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // endsection: Q_SECTIONTIMER is a boolean -> no overflow test needed
                Arguments.of("endsection: T_SECTIONTIMER: Overflow", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(0, true, 1024, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("endsection: D_SECTIONTIMERSTOPLOC: Overflow", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(0, true, 0, 32768), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),

                // sections: Q_ENDTIMER is a boolean -> no overflow test needed
                Arguments.of("T_ENDTIMER: Overflow", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), true, 1024, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_ENDTIMERSTARTLOC: Overflow", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), true, 0, 32768, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // sections: Q_DANGERPOINT is a boolean -> no overflow test needed
                Arguments.of("D_DP: Overflow", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, true, 32768, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("V_RELEASEDP: Overflow", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, true, 0, 128, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // sections: Q_OVERLAP is a boolean -> no overflow test needed
                Arguments.of("D_STARTOL: Overflow", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 32768, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("T_OL: Overflow", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 0, 1024, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_OL: Overflow", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 32768, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("V_RELEASEOL: Overflow", new Packet_12(0, 0, 0, 0, 0, new Packet_12.Packet_12_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 128), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

    public static Packet_12 fill(Packet_12 packet_12, Packet_12.Packet_12_Section section, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_12.sections.add(section);
        }
        return packet_12;
    }
    
}