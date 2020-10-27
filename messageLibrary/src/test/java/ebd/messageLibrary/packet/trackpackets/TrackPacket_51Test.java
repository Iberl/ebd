package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_51Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_51(), "[51:8][0:2][67:13][0:2]0[0:15][0:15]0[0:5][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), "[51:8][0:2][67:13][0:2]0[0:15][0:15]0[0:5][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_51(3, 0, false, 0, new Packet_51.Packet_51_Restriction()), "[51:8][3:2][67:13][0:2]0[0:15][0:15]0[0:5][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), "[51:8][0:2][67:13][0:2]0[0:15][0:15]0[0:5][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_51(0, 3, false, 0, new Packet_51.Packet_51_Restriction()), "[51:8][0:2][67:13][3:2]0[0:15][0:15]0[0:5][0:5]"),
                Arguments.of("Q_TRACKINIT: False", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), "[51:8][0:2][67:13][0:2]0[0:15][0:15]0[0:5][0:5]"),
                Arguments.of("Q_TRACKINIT: True", new Packet_51(0, 0, true, 0, new Packet_51.Packet_51_Restriction()), "[51:8][0:2][41:13][0:2]1[0:15]"),
                Arguments.of("D_TRACKINIT: Min", new Packet_51(0, 0, true, 0, new Packet_51.Packet_51_Restriction()), "[51:8][0:2][41:13][0:2]1[0:15]"),
                Arguments.of("D_TRACKINIT: Max", new Packet_51(0, 0, true, 32767, new Packet_51.Packet_51_Restriction()), "[51:8][0:2][41:13][0:2]1[32767:15]"),

                Arguments.of("restriction: D_AXLELOAD: Min", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction(0, 0,false)), "[51:8][0:2][67:13][0:2]0[0:15][0:15]0[0:5][0:5]"),
                Arguments.of("restriction: D_AXLELOAD: Max", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction(32767, 0, false)), "[51:8][0:2][67:13][0:2]0[32767:15][0:15]0[0:5][0:5]"),
                Arguments.of("restriction: L_AXLELOAD: Min", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction(0, 0, false)), "[51:8][0:2][67:13][0:2]0[0:15][0:15]0[0:5][0:5]"),
                Arguments.of("restriction: L_AXLELOAD: Max", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction(0, 32767, false)), "[51:8][0:2][67:13][0:2]0[0:15][32767:15]0[0:5][0:5]"),
                Arguments.of("restriction: Q_FRONT: False", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction(0, 0, false)), "[51:8][0:2][67:13][0:2]0[0:15][0:15]0[0:5][0:5]"),
                Arguments.of("restriction: Q_FRONT: True", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction(0, 0, true)), "[51:8][0:2][67:13][0:2]0[0:15][0:15]1[0:5][0:5]"),
                Arguments.of("restriction: axleloads: Empty", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), "[51:8][0:2][67:13][0:2]0[0:15][0:15]0[0:5][0:5]"),
                Arguments.of("restriction: axleloads: 1 Element", new Packet_51(0, 0, false, 0, fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(), 1)), "[51:8][0:2][81:13][0:2]0[0:15][0:15]0[1:5]{[0:7][0:7]*1}[0:5]"),
                Arguments.of("restriction: axleloads: M_AXLELOADCAT: Min", new Packet_51(0, 0, false, 0, fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 0), 1)), "[51:8][0:2][81:13][0:2]0[0:15][0:15]0[1:5]{[0:7][0:7]*1}[0:5]"),
                Arguments.of("restriction: axleloads: M_AXLELOADCAT: Max", new Packet_51(0, 0, false, 0, fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(127, 0), 1)), "[51:8][0:2][81:13][0:2]0[0:15][0:15]0[1:5]{[127:7][0:7]*1}[0:5]"),
                Arguments.of("restriction: axleloads: V_AXLELOAD: Min", new Packet_51(0, 0, false, 0, fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 0), 1)), "[51:8][0:2][81:13][0:2]0[0:15][0:15]0[1:5]{[0:7][0:7]*1}[0:5]"),
                Arguments.of("restriction: axleloads: V_AXLELOAD: Max", new Packet_51(0, 0, false, 0, fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 127), 1)), "[51:8][0:2][81:13][0:2]0[0:15][0:15]0[1:5]{[0:7][127:7]*1}[0:5]"),
                Arguments.of("restriction: axleloads: 1+ Elements", new Packet_51(0, 0, false, 0, fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 0), 2)), "[51:8][0:2][95:13][0:2]0[0:15][0:15]0[2:5]{[0:7][0:7]*2}[0:5]"),
                Arguments.of("restriction: axleloads: Max Elements", new Packet_51(0, 0, false, 0, fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 0), 31)), "[51:8][0:2][501:13][0:2]0[0:15][0:15]0[31:5]{[0:7][0:7]*31}[0:5]"),

                Arguments.of("restrictions: Empty", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), "[51:8][0:2][67:13][0:2]0[0:15][0:15]0[0:5][0:5]"),
                Arguments.of("restrictions: 1 Element", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(), 1), "[51:8][0:2][103:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[0:5]*1}"),
                Arguments.of("restrictions: D_AXLELOAD: Min", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(0, 0, false), 1), "[51:8][0:2][103:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[0:5]*1}"),
                Arguments.of("restrictions: D_AXLELOAD: Max", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(32767, 0, false), 1), "[51:8][0:2][103:13][0:2]0[0:15][0:15]0[0:5][1:5]{[32767:15][0:15]0[0:5]*1}"),
                Arguments.of("restrictions: L_AXLELOAD: Min", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(0, 0, false), 1), "[51:8][0:2][103:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[0:5]*1}"),
                Arguments.of("restrictions: L_AXLELOAD: Max", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(0, 32767, false), 1), "[51:8][0:2][103:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][32767:15]0[0:5]*1}"),
                Arguments.of("restrictions: Q_FRONT: False", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(0, 0, false), 1), "[51:8][0:2][103:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[0:5]*1}"),
                Arguments.of("restrictions: Q_FRONT: True", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(0, 0, true), 1), "[51:8][0:2][103:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]1[0:5]*1}"),
                Arguments.of("restrictions: axleloads: Empty", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(), 1), "[51:8][0:2][103:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[0:5]*1}"),
                Arguments.of("restrictions: axleloads: 1 Element", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 0), 1), 1), "[51:8][0:2][117:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[1:5]{[0:7][0:7]*1}*1}"),
                Arguments.of("restrictions: axleloads: M_AXLELOADCAT: Min", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 0), 1), 1), "[51:8][0:2][117:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[1:5]{[0:7][0:7]*1}*1}"),
                Arguments.of("restrictions: axleloads: M_AXLELOADCAT: Max", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(127, 0), 1), 1), "[51:8][0:2][117:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[1:5]{[127:7][0:7]*1}*1}"),
                Arguments.of("restrictions: axleloads: V_AXLELOAD: Min", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 0), 1), 1), "[51:8][0:2][117:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[1:5]{[0:7][0:7]*1}*1}"),
                Arguments.of("restrictions: axleloads: V_AXLELOAD: Max", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 127), 1), 1), "[51:8][0:2][117:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[1:5]{[0:7][127:7]*1}*1}"),
                Arguments.of("restrictions: axleloads: 1+ Elements", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 0), 2), 1), "[51:8][0:2][131:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[2:5]{[0:7][0:7]*2}*1}"),
                Arguments.of("restrictions: axleloads: Max Elements", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 0), 31), 1), "[51:8][0:2][537:13][0:2]0[0:15][0:15]0[0:5][1:5]{[0:15][0:15]0[31:5]{[0:7][0:7]*31}*1}"),
                Arguments.of("restrictions: 1+ Elements", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(0, 0, false), 2), "[51:8][0:2][139:13][0:2]0[0:15][0:15]0[0:5][2:5]{[0:15][0:15]0[0:5]*2}"),
                Arguments.of("restrictions: Max Elements", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(0, 0, false), 31), "[51:8][0:2][1183:13][0:2]0[0:15][0:15]0[0:5][31:5]{[0:15][0:15]0[0:5]*31}"),

                Arguments.of("all", fill(new Packet_51(2, 1, false, 0, fill(new Packet_51.Packet_51_Restriction(6253, 9251, true), new Packet_51.Packet_51_Axleload(73, 34), 1)), fill(new Packet_51.Packet_51_Restriction(1543, 3458, true), new Packet_51.Packet_51_Axleload(58, 93), 1), 1), "[51:8][2:2][131:13][1:2]0[6253:15][9251:15]1[1:5]{[73:7][34:7]*1}[1:5]{[1543:15][3458:15]1[1:5]{[58:7][93:7]*1}*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_51(4, 0, false, 0, new Packet_51.Packet_51_Restriction()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_51(0, 4, false, 0, new Packet_51.Packet_51_Restriction()), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_TRACKINIT is a boolean -> no overflow test needed
                Arguments.of("D_TRACKINIT: Overflow", new Packet_51(0, 0, true, 32768, new Packet_51.Packet_51_Restriction()), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("restriction: D_AXLELOAD: Overflow", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction(32768, 0, false)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("restriction: L_AXLELOAD: Overflow", new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction(0, 32768, false)), new IllegalArgumentException("Invalid value for given bit length")),
                // restriction: Q_FRONT is a boolean -> no overflow test needed
                Arguments.of("restriction: axleloads: M_AXLELOADCAT: Overflow", new Packet_51(0, 0, false, 0, fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(128, 0), 1)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("restriction: axleloads: V_AXLELOAD: Overflow", new Packet_51(0, 0, false, 0, fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 128), 1)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("restrictions: D_AXLELOAD: Overflow", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(32768, 0, false), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("restrictions: L_AXLELOAD: Overflow", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), new Packet_51.Packet_51_Restriction(0, 32768, false), 1), new IllegalArgumentException("Invalid value for given bit length")),
                // restrictions: Q_FRONT is a boolean -> no overflow test needed
                Arguments.of("restrictions: axleloads: M_AXLELOADCAT: Overflow", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(128, 0), 1), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("restrictions: axleloads: V_AXLELOAD: Overflow", fill(new Packet_51(0, 0, false, 0, new Packet_51.Packet_51_Restriction()), fill(new Packet_51.Packet_51_Restriction(), new Packet_51.Packet_51_Axleload(0, 128), 1), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_51.Packet_51_Restriction fill(Packet_51.Packet_51_Restriction restriction, Packet_51.Packet_51_Axleload axleload, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            restriction.axleloads.add(axleload);
        }
        return restriction;
    }

    public static Packet_51 fill(Packet_51 packet_51, Packet_51.Packet_51_Restriction restriction, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_51.restrictions.add(restriction);
        }
        return packet_51;
    }

}