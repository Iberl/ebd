package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_68Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_68(), "[68:8][0:2][65:13][0:2]0[0:15][0:15][0:4][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), "[68:8][0:2][65:13][0:2]0[0:15][0:15][0:4][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_68(3, 0, false, 0, new Packet_68.Packet_68_Condition()), "[68:8][3:2][65:13][0:2]0[0:15][0:15][0:4][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), "[68:8][0:2][65:13][0:2]0[0:15][0:15][0:4][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_68(0, 3, false, 0, new Packet_68.Packet_68_Condition()), "[68:8][0:2][65:13][3:2]0[0:15][0:15][0:4][0:5]"),
                Arguments.of("Q_TRACKINIT: False", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), "[68:8][0:2][65:13][0:2]0[0:15][0:15][0:4][0:5]"),
                Arguments.of("Q_TRACKINIT: True", new Packet_68(0, 0, true, 0, new Packet_68.Packet_68_Condition()), "[68:8][0:2][41:13][0:2]1[0:15]"),
                Arguments.of("D_TRACKINIT: Min", new Packet_68(0, 0, true, 0, new Packet_68.Packet_68_Condition()), "[68:8][0:2][41:13][0:2]1[0:15]"),
                Arguments.of("D_TRACKINIT: Max", new Packet_68(0, 0, true, 32767, new Packet_68.Packet_68_Condition()), "[68:8][0:2][41:13][0:2]1[32767:15]"),
                
                Arguments.of("condition: D_TRACKCOND: Min", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition(0, 0, 0)), "[68:8][0:2][65:13][0:2]0[0:15][0:15][0:4][0:5]"),
                Arguments.of("condition: D_TRACKCOND: Max", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition(32767, 0, 0)), "[68:8][0:2][65:13][0:2]0[32767:15][0:15][0:4][0:5]"),
                Arguments.of("condition: L_TRACKCOND: Min", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition(0, 0, 0)), "[68:8][0:2][65:13][0:2]0[0:15][0:15][0:4][0:5]"),
                Arguments.of("condition: L_TRACKCOND: Max", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition(0, 32767, 0)), "[68:8][0:2][65:13][0:2]0[0:15][32767:15][0:4][0:5]"),
                Arguments.of("condition: M_TRACKCOND: Min", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition(0, 0, 0)), "[68:8][0:2][65:13][0:2]0[0:15][0:15][0:4][0:5]"),
                Arguments.of("condition: M_TRACKCOND: Max", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition(0, 0, 15)), "[68:8][0:2][65:13][0:2]0[0:15][0:15][15:4][0:5]"),
                
                Arguments.of("conditions: Empty", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), "[68:8][0:2][65:13][0:2]0[0:15][0:15][0:4][0:5]"),
                Arguments.of("conditions: 1 Element", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(), 1), "[68:8][0:2][99:13][0:2]0[0:15][0:15][0:4][1:5]{[0:15][0:15][0:4]*1}"),
                Arguments.of("conditions: D_TRACKCOND: Min", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(0, 0, 0), 1), "[68:8][0:2][99:13][0:2]0[0:15][0:15][0:4][1:5]{[0:15][0:15][0:4]*1}"),
                Arguments.of("conditions: D_TRACKCOND: Max", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(32767, 0, 0), 1), "[68:8][0:2][99:13][0:2]0[0:15][0:15][0:4][1:5]{[32767:15][0:15][0:4]*1}"),
                Arguments.of("conditions: L_TRACKCOND: Min", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(0, 0, 0), 1), "[68:8][0:2][99:13][0:2]0[0:15][0:15][0:4][1:5]{[0:15][0:15][0:4]*1}"),
                Arguments.of("conditions: L_TRACKCOND: Max", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(0, 32767, 0), 1), "[68:8][0:2][99:13][0:2]0[0:15][0:15][0:4][1:5]{[0:15][32767:15][0:4]*1}"),
                Arguments.of("conditions: M_TRACKCOND: Min", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(0, 0, 0), 1), "[68:8][0:2][99:13][0:2]0[0:15][0:15][0:4][1:5]{[0:15][0:15][0:4]*1}"),
                Arguments.of("conditions: M_TRACKCOND: Max", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(0, 0, 15), 1), "[68:8][0:2][99:13][0:2]0[0:15][0:15][0:4][1:5]{[0:15][0:15][15:4]*1}"),
                Arguments.of("conditions: 1+ Elements", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(0, 0, 0), 2), "[68:8][0:2][133:13][0:2]0[0:15][0:15][0:4][2:5]{[0:15][0:15][0:4]*2}"),
                Arguments.of("conditions: Max Elements", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(0, 0, 0), 31), "[68:8][0:2][1119:13][0:2]0[0:15][0:15][0:4][31:5]{[0:15][0:15][0:4]*31}"),

                Arguments.of("all", fill(new Packet_68(1, 1, false, 0, new Packet_68.Packet_68_Condition(5428, 9826, 12)), new Packet_68.Packet_68_Condition(6183, 1272, 7), 1), "[68:8][1:2][99:13][1:2]0[5428:15][9826:15][12:4][1:5]{[6183:15][1272:15][7:4]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Max", new Packet_68(4, 0, false, 0, new Packet_68.Packet_68_Condition()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Max", new Packet_68(0, 4, false, 0, new Packet_68.Packet_68_Condition()), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_TRACKINIT is a boolean -> no overflow test needed
                Arguments.of("D_TRACKINIT: Max", new Packet_68(0, 0, true, 32768, new Packet_68.Packet_68_Condition()), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("condition: D_TRACKCOND: Max", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition(32768, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("condition: L_TRACKCOND: Max", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition(0, 32768, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("condition: M_TRACKCOND: Max", new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition(0, 0, 16)), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("conditions: D_TRACKCOND: Max", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(32768, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("conditions: L_TRACKCOND: Max", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(0, 32768, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("conditions: M_TRACKCOND: Max", fill(new Packet_68(0, 0, false, 0, new Packet_68.Packet_68_Condition()), new Packet_68.Packet_68_Condition(0, 0, 16), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_68 fill(Packet_68 packet_68, Packet_68.Packet_68_Condition condition, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_68.conditions.add(condition);
        }
        return packet_68;
    }
    
}