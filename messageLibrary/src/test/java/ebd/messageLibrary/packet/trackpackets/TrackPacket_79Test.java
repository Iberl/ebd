package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import ebd.messageLibrary.util.MathUtil;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_79Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_79(), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_79(0, 0, new Packet_79.Packet_79_Position()), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_79(3, 0, new Packet_79.Packet_79_Position()), "[79:8][3:2][95:13][0:2]0[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_79(0, 0, new Packet_79.Packet_79_Position()), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_79(0, 3, new Packet_79.Packet_79_Position()), "[79:8][0:2][95:13][3:2]0[0:10][0:14][0:15]0[0:24][0:5]"),

                Arguments.of("position: Q_NEWCOUNTRY: False", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0)), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("position: Q_NEWCOUNTRY: True", new Packet_79(0, 0, new Packet_79.Packet_79_Position(true, 0, 0, 0, false, 0)), "[79:8][0:2][95:13][0:2]1[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("position: NID_C: Min", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0)), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("position: NID_C: Max", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 1023, 0, 0, false, 0)), "[79:8][0:2][95:13][0:2]0[1023:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("position: NID_BG: Min", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0)), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("position: NID_BG: Max", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 16383, 0, false, 0)), "[79:8][0:2][95:13][0:2]0[0:10][16383:14][0:15]0[0:24][0:5]"),
                Arguments.of("position: D_POSOFF: Min", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0)), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("position: D_POSOFF: Max", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 0, 32767, false, 0)), "[79:8][0:2][95:13][0:2]0[0:10][0:14][32767:15]0[0:24][0:5]"),
                Arguments.of("position: Q_MPOSITION: False", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0)), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("position: Q_MPOSITION: True", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 0, 0, true, 0)), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]1[0:24][0:5]"),
                Arguments.of("position: M_POSITION: Min", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0)), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("position: M_POSITION: Max", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 0, 0, false, MathUtil.toSignedInteger(16777215))), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]0[16777215:24][0:5]"),

                Arguments.of("positions: Empty", new Packet_79(0, 0, new Packet_79.Packet_79_Position()), "[79:8][0:2][95:13][0:2]0[0:10][0:14][0:15]0[0:24][0:5]"),
                Arguments.of("positions: 1 Element", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[0:10][0:14][0:15]0[0:24]*1}"),
                Arguments.of("positions: Q_NEWCOUNTRY: False", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[0:10][0:14][0:15]0[0:24]*1}"),
                Arguments.of("positions: Q_NEWCOUNTRY: True", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(true, 0, 0, 0, false, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{1[0:10][0:14][0:15]0[0:24]*1}"),
                Arguments.of("positions: NID_C: Min", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[0:10][0:14][0:15]0[0:24]*1}"),
                Arguments.of("positions: NID_C: Max", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 1023, 0, 0, false, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[1023:10][0:14][0:15]0[0:24]*1}"),
                Arguments.of("positions: NID_BG: Min", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[0:10][0:14][0:15]0[0:24]*1}"),
                Arguments.of("positions: NID_BG: Max", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 16383, 0, false, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[0:10][16383:14][0:15]0[0:24]*1}"),
                Arguments.of("positions: D_POSOFF: Min", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[0:10][0:14][0:15]0[0:24]*1}"),
                Arguments.of("positions: D_POSOFF: Max", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 32767, false, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[0:10][0:14][32767:15]0[0:24]*1}"),
                Arguments.of("positions: Q_MPOSITION: False", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[0:10][0:14][0:15]0[0:24]*1}"),
                Arguments.of("positions: Q_MPOSITION: True", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, true, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[0:10][0:14][0:15]1[0:24]*1}"),
                Arguments.of("positions: M_POSITION: Min", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[0:10][0:14][0:15]0[0:24]*1}"),
                Arguments.of("positions: M_POSITION: Max", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, false, MathUtil.toSignedInteger(16777215)), 1), "[79:8][0:2][160:13][0:2]0[0:10][0:14][0:15]0[0:24][1:5]{0[0:10][0:14][0:15]0[16777215:24]*1}"),
                Arguments.of("positions: 1+ Elements", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0), 2), "[79:8][0:2][225:13][0:2]0[0:10][0:14][0:15]0[0:24][2:5]{0[0:10][0:14][0:15]0[0:24]*2}"),
                Arguments.of("positions: Max Elements", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, false, 0), 31), "[79:8][0:2][2110:13][0:2]0[0:10][0:14][0:15]0[0:24][31:5]{0[0:10][0:14][0:15]0[0:24]*31}"),

                Arguments.of("all", fill(new Packet_79(1, 2, new Packet_79.Packet_79_Position(true, 628, 8156, 22584, false, MathUtil.toSignedInteger(1625216))), new Packet_79.Packet_79_Position(false, 527, 13649, 31843, true, MathUtil.toSignedInteger(1121662)), 1), "[79:8][1:2][160:13][2:2]1[628:10][8156:14][22584:15]0[1625216:24][1:5]{0[527:10][13649:14][31843:15]1[1121662:24]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_79(4, 0, new Packet_79.Packet_79_Position()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_79(0, 4, new Packet_79.Packet_79_Position()), new IllegalArgumentException("Invalid value for given bit length")),
                // position: Q_NEWCOUNTRY is a boolean -> no overflow test needed
                Arguments.of("position: NID_C: Overflow", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 1024, 0, 0, false, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("position: NID_BG: Overflow", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 16384, 0, false, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("position: D_POSOFF: Overflow", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 0, 32768, false, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                // position: Q_MPOSITION is a boolean -> no overflow test needed
                Arguments.of("position: M_POSITION: Overflow", new Packet_79(0, 0, new Packet_79.Packet_79_Position(false, 0, 0, 0, false, MathUtil.toSignedInteger(16777216))), new IllegalArgumentException("Invalid value for given bit length")),
                // position: Q_NEWCOUNTRY is a boolean -> no overflow test needed
                Arguments.of("position: NID_C: Overflow", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 1024, 0, 0, false, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("position: NID_BG: Overflow", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 16384, 0, false, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("position: D_POSOFF: Overflow", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 32768, false, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                // position: Q_MPOSITION is a boolean -> no overflow test needed
                Arguments.of("position: M_POSITION: Overflow", fill(new Packet_79(0, 0, new Packet_79.Packet_79_Position()), new Packet_79.Packet_79_Position(false, 0, 0, 0, false, MathUtil.toSignedInteger(16777216)), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_79 fill(Packet_79 packet_79, Packet_79.Packet_79_Position position, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_79.positions.add(position);
        }
        return packet_79;
    }

}