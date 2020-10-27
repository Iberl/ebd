package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_67Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_67(), "[67:8][0:2][60:13][0:2][0:15][0:15][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), "[67:8][0:2][60:13][0:2][0:15][0:15][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_67(3, 0, new Packet_67.Packet_67_Condition()), "[67:8][3:2][60:13][0:2][0:15][0:15][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), "[67:8][0:2][60:13][0:2][0:15][0:15][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_67(0, 3, new Packet_67.Packet_67_Condition()), "[67:8][0:2][60:13][3:2][0:15][0:15][0:5]"),

                Arguments.of("condition: D_TRACKCOND: Min", new Packet_67(0, 0, new Packet_67.Packet_67_Condition(0, 0)), "[67:8][0:2][60:13][0:2][0:15][0:15][0:5]"),
                Arguments.of("condition: D_TRACKCOND: Max", new Packet_67(0, 0, new Packet_67.Packet_67_Condition(32767, 0)), "[67:8][0:2][60:13][0:2][32767:15][0:15][0:5]"),
                Arguments.of("condition: L_TRACKCOND: Min", new Packet_67(0, 0, new Packet_67.Packet_67_Condition(0, 0)), "[67:8][0:2][60:13][0:2][0:15][0:15][0:5]"),
                Arguments.of("condition: L_TRACKCOND: Max", new Packet_67(0, 0, new Packet_67.Packet_67_Condition(0, 32767)), "[67:8][0:2][60:13][0:2][0:15][32767:15][0:5]"),

                Arguments.of("conditions: Empty", new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), "[67:8][0:2][60:13][0:2][0:15][0:15][0:5]"),
                Arguments.of("conditions: 1 Element", fill(new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), new Packet_67.Packet_67_Condition(), 1), "[67:8][0:2][90:13][0:2][0:15][0:15][1:5]{[0:15][0:15]*1}"),
                Arguments.of("conditions: D_TRACKCOND: Min", fill(new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), new Packet_67.Packet_67_Condition(0, 0), 1), "[67:8][0:2][90:13][0:2][0:15][0:15][1:5]{[0:15][0:15]*1}"),
                Arguments.of("conditions: D_TRACKCOND: Max", fill(new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), new Packet_67.Packet_67_Condition(32767, 0), 1), "[67:8][0:2][90:13][0:2][0:15][0:15][1:5]{[32767:15][0:15]*1}"),
                Arguments.of("conditions: L_TRACKCOND: Min", fill(new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), new Packet_67.Packet_67_Condition(0, 0), 1), "[67:8][0:2][90:13][0:2][0:15][0:15][1:5]{[0:15][0:15]*1}"),
                Arguments.of("conditions: L_TRACKCOND: Max", fill(new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), new Packet_67.Packet_67_Condition(0, 32767), 1), "[67:8][0:2][90:13][0:2][0:15][0:15][1:5]{[0:15][32767:15]*1}"),
                Arguments.of("conditions: 1+ Elements", fill(new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), new Packet_67.Packet_67_Condition(7429, 0), 2), "[67:8][0:2][120:13][0:2][0:15][0:15][2:5]{[7429:15][0:15]*2}"),
                Arguments.of("conditions: Max Elements", fill(new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), new Packet_67.Packet_67_Condition(0, 8424), 31), "[67:8][0:2][990:13][0:2][0:15][0:15][31:5]{[0:15][8424:15]*31}"),

                Arguments.of("all", fill(new Packet_67(2, 1, new Packet_67.Packet_67_Condition(472, 9127)), new Packet_67.Packet_67_Condition(1313, 742), 1), "[67:8][2:2][90:13][1:2][472:15][9127:15][1:5]{[1313:15][742:15]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_67(4, 0, new Packet_67.Packet_67_Condition()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_67(0, 4, new Packet_67.Packet_67_Condition()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("condition: D_TRACKCOND: Overflow", new Packet_67(0, 0, new Packet_67.Packet_67_Condition(32768, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("condition: L_TRACKCOND: Overflow", new Packet_67(0, 0, new Packet_67.Packet_67_Condition(0, 32768)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("conditions: D_TRACKCOND: Overflow", fill(new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), new Packet_67.Packet_67_Condition(32768, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("conditions: L_TRACKCOND: Overflow", fill(new Packet_67(0, 0, new Packet_67.Packet_67_Condition()), new Packet_67.Packet_67_Condition(0, 32768), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_67 fill(Packet_67 packet_67, Packet_67.Packet_67_Condition condition, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_67.conditions.add(condition);
        }
        return packet_67;
    }

}