package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_58Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_58(), "[58:8][0:2][56:13][0:2][0:8][0:15][0:3][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_58(0, 0, 0, 0, 0), "[58:8][0:2][56:13][0:2][0:8][0:15][0:3][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_58(3, 0, 0, 0, 0), "[58:8][3:2][56:13][0:2][0:8][0:15][0:3][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_58(0, 0, 0, 0, 0), "[58:8][0:2][56:13][0:2][0:8][0:15][0:3][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_58(0, 3, 0, 0, 0), "[58:8][0:2][56:13][3:2][0:8][0:15][0:3][0:5]"),
                Arguments.of("T_CYCLOC: Min", new Packet_58(0, 0, 0, 0, 0), "[58:8][0:2][56:13][0:2][0:8][0:15][0:3][0:5]"),
                Arguments.of("T_CYCLOC: Max", new Packet_58(0, 0, 255, 0, 0), "[58:8][0:2][56:13][0:2][255:8][0:15][0:3][0:5]"),
                Arguments.of("D_CYCLOC: Min", new Packet_58(0, 0, 0, 0, 0), "[58:8][0:2][56:13][0:2][0:8][0:15][0:3][0:5]"),
                Arguments.of("D_CYCLOC: Max", new Packet_58(0, 0, 0, 32767, 0), "[58:8][0:2][56:13][0:2][0:8][32767:15][0:3][0:5]"),
                Arguments.of("M_LOC: Min", new Packet_58(0, 0, 0, 0, 0), "[58:8][0:2][56:13][0:2][0:8][0:15][0:3][0:5]"),
                Arguments.of("M_LOC: Max", new Packet_58(0, 0, 0, 0, 7), "[58:8][0:2][56:13][0:2][0:8][0:15][7:3][0:5]"),

                Arguments.of("intervals: Empty", new Packet_58(), "[58:8][0:2][56:13][0:2][0:8][0:15][0:3][0:5]"),
                Arguments.of("intervals: 1 Element", fill(new Packet_58(0, 0, 0, 0, 0), new Packet_58.Packet_58_Interval(), 1), "[58:8][0:2][72:13][0:2][0:8][0:15][0:3][1:5]{[0:15]0*1}"),
                Arguments.of("intervals: D_LOC: Min", fill(new Packet_58(0, 0, 0, 0, 0), new Packet_58.Packet_58_Interval(0, false), 1), "[58:8][0:2][72:13][0:2][0:8][0:15][0:3][1:5]{[0:15]0*1}"),
                Arguments.of("intervals: D_LOC: Max", fill(new Packet_58(0, 0, 0, 0, 0), new Packet_58.Packet_58_Interval(32767, false), 1), "[58:8][0:2][72:13][0:2][0:8][0:15][0:3][1:5]{[32767:15]0*1}"),
                Arguments.of("intervals: Q_LGTLOC: False", fill(new Packet_58(0, 0, 0, 0, 0), new Packet_58.Packet_58_Interval(0, false), 1), "[58:8][0:2][72:13][0:2][0:8][0:15][0:3][1:5]{[0:15]0*1}"),
                Arguments.of("intervals: Q_LGTLOC: True", fill(new Packet_58(0, 0, 0, 0, 0), new Packet_58.Packet_58_Interval(0, true), 1), "[58:8][0:2][72:13][0:2][0:8][0:15][0:3][1:5]{[0:15]1*1}"),
                Arguments.of("intervals: 1+ Elements", fill(new Packet_58(0, 0, 0, 0, 0), new Packet_58.Packet_58_Interval(0, false), 2), "[58:8][0:2][88:13][0:2][0:8][0:15][0:3][2:5]{[0:15]0*2}"),
                Arguments.of("intervals: Max Elements", fill(new Packet_58(0, 0, 0, 0, 0), new Packet_58.Packet_58_Interval(0, true), 31), "[58:8][0:2][552:13][0:2][0:8][0:15][0:3][31:5]{[0:15]1*31}"),

                Arguments.of("all", fill(new Packet_58(1, 1, 63, 8257, 4), new Packet_58.Packet_58_Interval(23512, true), 1), "[58:8][1:2][72:13][1:2][63:8][8257:15][4:3][1:5]{[23512:15]1*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_58(4, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_58(0, 4, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("T_CYCLOC: Overflow", new Packet_58(0, 0, 256, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_CYCLOC: Overflow", new Packet_58(0, 0, 0, 32768, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_LOC: Overflow", new Packet_58(0, 0, 0, 0, 8), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("intervals: D_LOC: Overflow", fill(new Packet_58(0, 0, 0, 0, 0), new Packet_58.Packet_58_Interval(32768, false), 1), new IllegalArgumentException("Invalid value for given bit length"))
                // intervals: Q_LGTLOC is a boolean -> no overflow test needed
        );
    }


    public static Packet_58 fill(Packet_58 packet_58, Packet_58.Packet_58_Interval interval, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_58.intervals.add(interval);
        }
        return packet_58;
    }

}