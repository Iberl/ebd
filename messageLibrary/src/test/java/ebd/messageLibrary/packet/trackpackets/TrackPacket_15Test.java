package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_15Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_15(), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_DIR: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_DIR: Max", new Packet_15(3, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][3:2][66:13][0:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_SCALE: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_SCALE: Max", new Packet_15(0, 3, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][3:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("V_LOA: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("V_LOA: Max", new Packet_15(0, 0, 127, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][127:7][0:10][0:5][0:15]0000"),
                Arguments.of("T_LOA: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("T_LOA: Max", new Packet_15(0, 0, 0, 1023, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][1023:10][0:5][0:15]0000"),

                Arguments.of("sections: Empty", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5]{[0:15]0*0}[0:15]0000"),
                Arguments.of("sections: 1 Element", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(), 1), "[15:8][0:2][82:13][0:2][0:7][0:10][1:5]{[0:15]0*1}[0:15]0000"),
                Arguments.of("sections: L_SECTION: Min", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(0, false, 0, 0), 1), "[15:8][0:2][82:13][0:2][0:7][0:10][1:5]{[0:15]0*1}[0:15]0000"),
                Arguments.of("sections: L_SECTION: Max", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(32767, false, 0, 0), 1), "[15:8][0:2][82:13][0:2][0:7][0:10][1:5]{[32767:15]0*1}[0:15]0000"),
                Arguments.of("sections: Q_SECTIONTIMER: Min", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(0, false, 0, 0), 1), "[15:8][0:2][82:13][0:2][0:7][0:10][1:5]{[0:15]0*1}[0:15]0000"),
                Arguments.of("sections: Q_SECTIONTIMER: Max", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(0, true, 0, 0), 1), "[15:8][0:2][107:13][0:2][0:7][0:10][1:5]{[0:15]1[0:10][0:15]*1}[0:15]0000"),
                Arguments.of("sections: T_SECTIONTIMER: Min", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(0, true, 0, 0), 1), "[15:8][0:2][107:13][0:2][0:7][0:10][1:5]{[0:15]1[0:10][0:15]*1}[0:15]0000"),
                Arguments.of("sections: T_SECTIONTIMER: Max", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(0, true, 1023, 0), 1), "[15:8][0:2][107:13][0:2][0:7][0:10][1:5]{[0:15]1[1023:10][0:15]*1}[0:15]0000"),
                Arguments.of("sections: D_SECTIONTIMERSTOPLOC: Min", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(0, true, 0, 0), 1), "[15:8][0:2][107:13][0:2][0:7][0:10][1:5]{[0:15]1[0:10][0:15]*1}[0:15]0000"),
                Arguments.of("sections: D_SECTIONTIMERSTOPLOC: Max", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(0, true, 0, 32767), 1), "[15:8][0:2][107:13][0:2][0:7][0:10][1:5]{[0:15]1[0:10][32767:15]*1}[0:15]0000"),
                Arguments.of("sections: 1+ Elements", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(0, true, 0, 0), 2), "[15:8][0:2][148:13][0:2][0:7][0:10][2:5]{[0:15]1[0:10][0:15]*2}[0:15]0000"),
                Arguments.of("sections: Max Elements", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(), 31), "[15:8][0:2][562:13][0:2][0:7][0:10][31:5]{[0:15]0*31}[0:15]0000"),

                Arguments.of("endsection: L_SECTION: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(0, false, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("endsection: L_SECTION: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(32767, false, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5][32767:15]0000"),
                Arguments.of("endsection: Q_SECTIONTIMER: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(0, false, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("endsection: Q_SECTIONTIMER: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(0, true, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][91:13][0:2][0:7][0:10][0:5][0:15]1[0:10][0:15]000"),
                Arguments.of("endsection: T_SECTIONTIMER: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(0, true, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][91:13][0:2][0:7][0:10][0:5][0:15]1[0:10][0:15]000"),
                Arguments.of("endsection: T_SECTIONTIMER: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(0, true, 1023, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][91:13][0:2][0:7][0:10][0:5][0:15]1[1023:10][0:15]000"),
                Arguments.of("endsection: D_SECTIONTIMERSTOPLOC: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(0, true, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][91:13][0:2][0:7][0:10][0:5][0:15]1[0:10][0:15]000"),
                Arguments.of("endsection: D_SECTIONTIMERSTOPLOC: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(0, true, 0, 32767), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][91:13][0:2][0:7][0:10][0:5][0:15]1[0:10][32767:15]000"),

                Arguments.of("Q_ENDTIMER: False", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_ENDTIMER: True", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), true, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][91:13][0:2][0:7][0:10][0:5][0:15]01[0:10][0:15]00"),
                Arguments.of("T_ENDTIMER: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), true, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][91:13][0:2][0:7][0:10][0:5][0:15]01[0:10][0:15]00"),
                Arguments.of("T_ENDTIMER: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), true, 1023, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][91:13][0:2][0:7][0:10][0:5][0:15]01[1023:10][0:15]00"),
                Arguments.of("D_ENDTIMERSTARTLOC: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), true, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][91:13][0:2][0:7][0:10][0:5][0:15]01[0:10][0:15]00"),
                Arguments.of("D_ENDTIMERSTARTLOC: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), true, 0, 32767, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][91:13][0:2][0:7][0:10][0:5][0:15]01[0:10][32767:15]00"),
                Arguments.of("Q_DANGERPOINT: False", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_DANGERPOINT: True", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, true, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][88:13][0:2][0:7][0:10][0:5][0:15]001[0:15][0:7]0"),
                Arguments.of("D_DP: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, true, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][88:13][0:2][0:7][0:10][0:5][0:15]001[0:15][0:7]0"),
                Arguments.of("D_DP: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, true, 32767, 0, false, 0, 0, 0, 0), "[15:8][0:2][88:13][0:2][0:7][0:10][0:5][0:15]001[32767:15][0:7]0"),
                Arguments.of("V_RELEASEDP: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, true, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][88:13][0:2][0:7][0:10][0:5][0:15]001[0:15][0:7]0"),
                Arguments.of("V_RELEASEDP: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, true, 0, 127, false, 0, 0, 0, 0), "[15:8][0:2][88:13][0:2][0:7][0:10][0:5][0:15]001[0:15][127:7]0"),
                Arguments.of("Q_OVERLAP: False", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), "[15:8][0:2][66:13][0:2][0:7][0:10][0:5][0:15]0000"),
                Arguments.of("Q_OVERLAP: True", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 0), "[15:8][0:2][113:13][0:2][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][0:7]"),
                Arguments.of("D_STARTOL: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 0), "[15:8][0:2][113:13][0:2][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][0:7]"),
                Arguments.of("D_STARTOL: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 32767, 0, 0, 0), "[15:8][0:2][113:13][0:2][0:7][0:10][0:5][0:15]0001[32767:15][0:10][0:15][0:7]"),
                Arguments.of("T_OL: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 0), "[15:8][0:2][113:13][0:2][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][0:7]"),
                Arguments.of("T_OL: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 0, 1023, 0, 0), "[15:8][0:2][113:13][0:2][0:7][0:10][0:5][0:15]0001[0:15][1023:10][0:15][0:7]"),
                Arguments.of("D_OL: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 0), "[15:8][0:2][113:13][0:2][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][0:7]"),
                Arguments.of("D_OL: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 32767, 0), "[15:8][0:2][113:13][0:2][0:7][0:10][0:5][0:15]0001[0:15][0:10][32767:15][0:7]"),
                Arguments.of("V_RELEASEOL: Min", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 0), "[15:8][0:2][113:13][0:2][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][0:7]"),
                Arguments.of("V_RELEASEOL: Max", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 127), "[15:8][0:2][113:13][0:2][0:7][0:10][0:5][0:15]0001[0:15][0:10][0:15][127:7]"),

                Arguments.of("all", fill(new Packet_15(3, 3, 127, 1023, new Packet_15.Packet_15_Section(32767, true, 1023, 32767), true, 1023, 32767, true, 32767, 127, true, 32767, 1023, 32767, 127), new Packet_15.Packet_15_Section(32767, true, 1023, 32767), 1), "[15:8][3:2][226:13][3:2][127:7][1023:10][1:5]{[32767:15]1[1023:10][32767:15]*1}[32767:15]1[1023:10][32767:15]1[1023:10][32767:15]1[32767:15][127:7]1[32767:15][1023:10][32767:15][127:7]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_15(4, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_15(0, 4, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("V_LOA: Overflow", new Packet_15(0, 0, 128, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("T_LOA: Overflow", new Packet_15(0, 0, 0, 1024, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("sections: L_SECTION: Overflow", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(32768, false, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                // sections: Q_SECTIONTIMER is a boolean -> no overflow test needed
                Arguments.of("sections: T_SECTIONTIMER: Overflow", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(0, true, 1024, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("sections: D_SECTIONTIMERSTOPLOC: Overflow", fill(new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new Packet_15.Packet_15_Section(0, true, 0, 32768), 1), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("endsection: L_SECTION: Overflow", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(32768, false, 0, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // endsection: Q_SECTIONTIMER is a boolean -> no overflow test needed
                Arguments.of("endsection: T_SECTIONTIMER: Overflow", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(0, true, 1024, 0), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("endsection: D_SECTIONTIMERSTOPLOC: Overflow", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(0, true, 0, 32768), false, 0, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),

                // Q_ENDTIMER is a boolean -> no overflow test needed
                Arguments.of("T_ENDTIMER: Overflow", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), true, 1024, 0, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_ENDTIMERSTARTLOC: Overflow", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), true, 0, 32768, false, 0, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_DANGERPOINT is a boolean -> no overflow test needed
                Arguments.of("D_DP: Overflow", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, true, 32768, 0, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("V_RELEASEDP: Overflow", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, true, 0, 128, false, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_OVERLAP is a boolean -> no overflow test needed
                Arguments.of("D_STARTOL: Overflow", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 32768, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("T_OL: Overflow", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 0, 1024, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_OL: Overflow", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 32768, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("V_RELEASEOL: Overflow", new Packet_15(0, 0, 0, 0, new Packet_15.Packet_15_Section(), false, 0, 0, false, 0, 0, true, 0, 0, 0, 128), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_15 fill(Packet_15 packet_15, Packet_15.Packet_15_Section section, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_15.sections.add(section);
        }
        return packet_15;
    }

}