package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_27Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_27(), "[27:8][0:2][58:13][0:2][0:15][0:7]0[0:5][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_27(0, 0, new Packet_27.Packet_27_Section()), "[27:8][0:2][58:13][0:2][0:15][0:7]0[0:5][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_27(3, 0, new Packet_27.Packet_27_Section()), "[27:8][3:2][58:13][0:2][0:15][0:7]0[0:5][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_27(0, 0, new Packet_27.Packet_27_Section()), "[27:8][0:2][58:13][0:2][0:15][0:7]0[0:5][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_27(0, 3, new Packet_27.Packet_27_Section()), "[27:8][0:2][58:13][3:2][0:15][0:7]0[0:5][0:5]"),
                
                Arguments.of("profile: D_STATIC: Min", new Packet_27(0, 0, new Packet_27.Packet_27_Section(0, 0, false)), "[27:8][0:2][58:13][0:2][0:15][0:7]0[0:5][0:5]"),
                Arguments.of("profile: D_STATIC: Max", new Packet_27(0, 0, new Packet_27.Packet_27_Section(32767, 0, false)), "[27:8][0:2][58:13][0:2][32767:15][0:7]0[0:5][0:5]"),
                Arguments.of("profile: V_STATIC: Min", new Packet_27(0, 0, new Packet_27.Packet_27_Section(0, 0, false)), "[27:8][0:2][58:13][0:2][0:15][0:7]0[0:5][0:5]"),
                Arguments.of("profile: V_STATIC: Max", new Packet_27(0, 0, new Packet_27.Packet_27_Section(0, 127, false)), "[27:8][0:2][58:13][0:2][0:15][127:7]0[0:5][0:5]"),
                Arguments.of("profile: Q_FRONT: False", new Packet_27(0, 0, new Packet_27.Packet_27_Section(0, 0, false)), "[27:8][0:2][58:13][0:2][0:15][0:7]0[0:5][0:5]"),
                Arguments.of("profile: Q_FRONT: True", new Packet_27(0, 0, new Packet_27.Packet_27_Section(0, 0, true)), "[27:8][0:2][58:13][0:2][0:15][0:7]1[0:5][0:5]"),

                Arguments.of("profile: sections: Empty", new Packet_27(0, 0, new Packet_27.Packet_27_Section(0, 0, false)), "[27:8][0:2][58:13][0:2][0:15][0:7]0[0:5][0:5]"),
                Arguments.of("profile: sections: 1 Element", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(), 1)), "[27:8][0:2][71:13][0:2][0:15][0:7]0[1:5]{[0:2][0:4][0:7]*1}[0:5]"),
                Arguments.of("profile: sections: Q_DIFF: Min", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 0), 1)), "[27:8][0:2][71:13][0:2][0:15][0:7]0[1:5]{[0:2][0:4][0:7]*1}[0:5]"),
                Arguments.of("profile: sections: Q_DIFF: Max", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(3, 0, 0, 0), 1)), "[27:8][0:2][67:13][0:2][0:15][0:7]0[1:5]{[3:2][0:7]*1}[0:5]"),
                Arguments.of("profile: sections: NC_CDDIFF: Min", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 0), 1)), "[27:8][0:2][71:13][0:2][0:15][0:7]0[1:5]{[0:2][0:4][0:7]*1}[0:5]"),
                Arguments.of("profile: sections: NC_CDDIFF: Max", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 15, 0, 0), 1)), "[27:8][0:2][71:13][0:2][0:15][0:7]0[1:5]{[0:2][15:4][0:7]*1}[0:5]"),
                Arguments.of("profile: sections: NC_DIFF: Min", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(1, 0, 0, 0), 1)), "[27:8][0:2][71:13][0:2][0:15][0:7]0[1:5]{[1:2][0:4][0:7]*1}[0:5]"),
                Arguments.of("profile: sections: NC_DIFF: Max", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(1, 0, 15, 0), 1)), "[27:8][0:2][71:13][0:2][0:15][0:7]0[1:5]{[1:2][15:4][0:7]*1}[0:5]"),
                Arguments.of("profile: sections: V_DIFF: Min", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 0), 1)), "[27:8][0:2][71:13][0:2][0:15][0:7]0[1:5]{[0:2][0:4][0:7]*1}[0:5]"),
                Arguments.of("profile: sections: V_DIFF: Max", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 127), 1)), "[27:8][0:2][71:13][0:2][0:15][0:7]0[1:5]{[0:2][0:4][127:7]*1}[0:5]"),
                Arguments.of("profile: sections: 1+ Elements", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 0), 2)), "[27:8][0:2][84:13][0:2][0:15][0:7]0[2:5]{[0:2][0:4][0:7]*2}[0:5]"),
                Arguments.of("profile: sections: Max Elements", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 0), 31)), "[27:8][0:2][461:13][0:2][0:15][0:7]0[31:5]{[0:2][0:4][0:7]*31}[0:5]"),

                Arguments.of("profiles: Empty", new Packet_27(0, 0, new Packet_27.Packet_27_Section()), "[27:8][0:2][58:13][0:2][0:15][0:7]0[0:5][0:5]"),
                Arguments.of("profiles: 1 Element", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(), 1), "[27:8][0:2][86:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[0:5]*1}"),

                Arguments.of("profiles: D_STATIC: Min", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(0, 0, false), 1), "[27:8][0:2][86:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[0:5]*1}"),
                Arguments.of("profiles: D_STATIC: Max", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(32767, 0, false), 1), "[27:8][0:2][86:13][0:2][0:15][0:7]0[0:5][1:5]{[32767:15][0:7]0[0:5]*1}"),
                Arguments.of("profiles: V_STATIC: Min", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(0, 0, false), 1), "[27:8][0:2][86:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[0:5]*1}"),
                Arguments.of("profiles: V_STATIC: Max", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(0, 127, false), 1), "[27:8][0:2][86:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][127:7]0[0:5]*1}"),
                Arguments.of("profiles: Q_FRONT: False", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(0, 0, false), 1), "[27:8][0:2][86:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[0:5]*1}"),
                Arguments.of("profiles: Q_FRONT: True", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(0, 0, true), 1), "[27:8][0:2][86:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]1[0:5]*1}"),

                Arguments.of("profiles: sections: Empty", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(0, 0, false), 1), "[27:8][0:2][86:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[0:5]*1}"),
                Arguments.of("profiles: sections: 1 Element", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(), 1), 1), "[27:8][0:2][99:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[1:5]{[0:2][0:4][0:7]*1}*1}"),
                Arguments.of("profiles: sections: Q_DIFF: Min", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 0), 1), 1), "[27:8][0:2][99:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[1:5]{[0:2][0:4][0:7]*1}*1}"),
                Arguments.of("profiles: sections: Q_DIFF: Max", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(3, 0, 0, 0), 1), 1), "[27:8][0:2][95:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[1:5]{[3:2][0:7]*1}*1}"),
                Arguments.of("profiles: sections: NC_CDDIFF: Min", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 0), 1), 1), "[27:8][0:2][99:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[1:5]{[0:2][0:4][0:7]*1}*1}"),
                Arguments.of("profiles: sections: NC_CDDIFF: Max", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 15, 0, 0), 1), 1), "[27:8][0:2][99:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[1:5]{[0:2][15:4][0:7]*1}*1}"),
                Arguments.of("profiles: sections: NC_DIFF: Min", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(1, 0, 0, 0), 1), 1), "[27:8][0:2][99:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[1:5]{[1:2][0:4][0:7]*1}*1}"),
                Arguments.of("profiles: sections: NC_DIFF: Max", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(1, 0, 15, 0), 1), 1), "[27:8][0:2][99:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[1:5]{[1:2][15:4][0:7]*1}*1}"),
                Arguments.of("profiles: sections: V_DIFF: Min", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 0), 1), 1), "[27:8][0:2][99:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[1:5]{[0:2][0:4][0:7]*1}*1}"),
                Arguments.of("profiles: sections: V_DIFF: Max", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 127), 1), 1), "[27:8][0:2][99:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[1:5]{[0:2][0:4][127:7]*1}*1}"),
                Arguments.of("profiles: sections: 1+ Elements", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 0), 2), 1), "[27:8][0:2][112:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[2:5]{[0:2][0:4][0:7]*2}*1}"),
                Arguments.of("profiles: sections: Max Elements", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 0), 31), 1), "[27:8][0:2][489:13][0:2][0:15][0:7]0[0:5][1:5]{[0:15][0:7]0[31:5]{[0:2][0:4][0:7]*31}*1}"),

                Arguments.of("profiles: 1+ Elements", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(0, 0, false), 2), "[27:8][0:2][114:13][0:2][0:15][0:7]0[0:5][2:5]{[0:15][0:7]0[0:5]*2}"),
                Arguments.of("profiles: Max Elements", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(0, 0, false), 31), "[27:8][0:2][926:13][0:2][0:15][0:7]0[0:5][31:5]{[0:15][0:7]0[0:5]*31}"),

                Arguments.of("all", fill(new Packet_27(1, 2, fill(new Packet_27.Packet_27_Section(31228, 63, true), new Packet_27.Packet_27_Category(1, 0, 3, 84), 1)), fill(new Packet_27.Packet_27_Section(29161, 59, false), new Packet_27.Packet_27_Category(0, 11, 0, 120), 1), 1), "[27:8][1:2][112:13][2:2][31228:15][63:7]1[1:5]{[1:2][3:4][84:7]*1}[1:5]{[29161:15][59:7]0[1:5]{[0:2][11:4][120:7]*1}*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_27(4, 0, new Packet_27.Packet_27_Section()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_27(0, 4, new Packet_27.Packet_27_Section()), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("profile: D_STATIC: Overflow", new Packet_27(0, 0, new Packet_27.Packet_27_Section(32768, 0, false)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("profile: V_STATIC: Overflow", new Packet_27(0, 0, new Packet_27.Packet_27_Section(0, 128, false)), new IllegalArgumentException("Invalid value for given bit length")),
                // profile: Q_FRONT is a boolean -> no overflow test needed

                Arguments.of("profile: sections: Q_DIFF: Overflow", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(4, 0, 0, 0), 1)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("profile: sections: NC_CDDIFF: Overflow", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 16, 0, 0), 1)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("profile: sections: NC_DIFF: Overflow", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(1, 0, 16, 0), 1)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("profile: sections: V_DIFF: Overflow", new Packet_27(0, 0, fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 128), 1)), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("profiles: D_STATIC: Overflow", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(32768, 0, false), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("profiles: V_STATIC: Overflow", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), new Packet_27.Packet_27_Section(0, 128, false), 1), new IllegalArgumentException("Invalid value for given bit length")),
                // profiles: Q_FRONT is a boolean -> no overflow test needed

                Arguments.of("profiles: sections: Q_DIFF: Overflow", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(4, 0, 0, 0), 1), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("profiles: sections: NC_CDDIFF: Overflow", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 16, 0, 0), 1), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("profiles: sections: NC_DIFF: Overflow", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(1, 0, 16, 0), 1), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("profiles: sections: V_DIFF: Overflow", fill(new Packet_27(0, 0, new Packet_27.Packet_27_Section()), fill(new Packet_27.Packet_27_Section(0, 0, false), new Packet_27.Packet_27_Category(0, 0, 0, 128), 1), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_27 fill(Packet_27 packet_27, Packet_27.Packet_27_Section profile, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_27.sections.add(profile);
        }
        return packet_27;
    }

    public static Packet_27.Packet_27_Section fill(Packet_27.Packet_27_Section profile, Packet_27.Packet_27_Category section, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            profile.categories.add(section);
        }
        return profile;
    }

}