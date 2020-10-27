package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_41Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_41(), "[41:8][0:2][63:13][0:2][0:15][0:3][0:15][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), "[41:8][0:2][63:13][0:2][0:15][0:3][0:15][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_41(3, 0, 0, new Packet_41.Packet_41_Level()), "[41:8][3:2][63:13][0:2][0:15][0:3][0:15][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), "[41:8][0:2][63:13][0:2][0:15][0:3][0:15][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_41(0, 3, 0, new Packet_41.Packet_41_Level()), "[41:8][0:2][63:13][3:2][0:15][0:3][0:15][0:5]"),
                Arguments.of("D_LEVELTR: Min", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), "[41:8][0:2][63:13][0:2][0:15][0:3][0:15][0:5]"),
                Arguments.of("D_LEVELTR: Max", new Packet_41(0, 0, 32767, new Packet_41.Packet_41_Level()), "[41:8][0:2][63:13][0:2][32767:15][0:3][0:15][0:5]"),

                Arguments.of("level: M_LEVELTR: Min", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level(0, 0, 0)), "[41:8][0:2][63:13][0:2][0:15][0:3][0:15][0:5]"),
                Arguments.of("level: M_LEVELTR: Max", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level(7, 0, 0)), "[41:8][0:2][63:13][0:2][0:15][7:3][0:15][0:5]"),
                Arguments.of("level: NID_NTC: Min", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level(1, 0, 0)), "[41:8][0:2][71:13][0:2][0:15][1:3][0:8][0:15][0:5]"),
                Arguments.of("level: NID_NTC: Max", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level(1, 255, 0)), "[41:8][0:2][71:13][0:2][0:15][1:3][255:8][0:15][0:5]"),
                Arguments.of("level: L_ACKLEVELTR: Min", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level(0, 0, 0)), "[41:8][0:2][63:13][0:2][0:15][0:3][0:15][0:5]"),
                Arguments.of("level: L_ACKLEVELTR: Max", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level(0, 0, 32767)), "[41:8][0:2][63:13][0:2][0:15][0:3][32767:15][0:5]"),

                Arguments.of("levels: Empty", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), "[41:8][0:2][63:13][0:2][0:15][0:3][0:15][0:5]"),
                Arguments.of("levels: 1 Element", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(), 1), "[41:8][0:2][81:13][0:2][0:15][0:3][0:15][1:5]{[0:3][0:15]*1}"),
                Arguments.of("levels: M_LEVELTR: Min", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(0, 0, 0), 1), "[41:8][0:2][81:13][0:2][0:15][0:3][0:15][1:5]{[0:3][0:15]*1}"),
                Arguments.of("levels: M_LEVELTR: Max", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(7, 0, 0), 1), "[41:8][0:2][81:13][0:2][0:15][0:3][0:15][1:5]{[7:3][0:15]*1}"),
                Arguments.of("levels: NID_NTC: Min", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(1, 0, 0), 1), "[41:8][0:2][89:13][0:2][0:15][0:3][0:15][1:5]{[1:3][0:8][0:15]*1}"),
                Arguments.of("levels: NID_NTC: Max", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(1, 255, 0), 1), "[41:8][0:2][89:13][0:2][0:15][0:3][0:15][1:5]{[1:3][255:8][0:15]*1}"),
                Arguments.of("levels: L_ACKLEVELTR: Min", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(0, 0, 0), 1), "[41:8][0:2][81:13][0:2][0:15][0:3][0:15][1:5]{[0:3][0:15]*1}"),
                Arguments.of("levels: L_ACKLEVELTR: Max", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(0, 0, 32767), 1), "[41:8][0:2][81:13][0:2][0:15][0:3][0:15][1:5]{[0:3][32767:15]*1}"),
                Arguments.of("levels: 1+ Elements", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(), 2), "[41:8][0:2][99:13][0:2][0:15][0:3][0:15][2:5]{[0:3][0:15]*2}"),
                Arguments.of("levels: Max Elements", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(), 31), "[41:8][0:2][621:13][0:2][0:15][0:3][0:15][31:5]{[0:3][0:15]*31}"),

                Arguments.of("all", fill(new Packet_41(2, 1, 3494, new Packet_41.Packet_41_Level(1, 95, 8353)), new Packet_41.Packet_41_Level(1, 222, 6232), 1), "[41:8][2:2][97:13][1:2][3494:15][1:3][95:8][8353:15][1:5]{[1:3][222:8][6232:15]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_41(4, 0, 0, new Packet_41.Packet_41_Level()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_41(0, 4, 0, new Packet_41.Packet_41_Level()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("D_LEVELTR: Overflow", new Packet_41(0, 0, 32768, new Packet_41.Packet_41_Level()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("level: M_LEVELTR: Overflow", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level(8, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("level: NID_NTC: Overflow", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level(1, 256, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("level: L_ACKLEVELTR: Overflow", new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level(0, 0, 32768)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("levels: M_LEVELTR: Overflow", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(8, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("levels: NID_NTC: Overflow", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(1, 256, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("levels: L_ACKLEVELTR: Overflow", fill(new Packet_41(0, 0, 0, new Packet_41.Packet_41_Level()), new Packet_41.Packet_41_Level(0, 0, 32768), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_41 fill(Packet_41 packet_41, Packet_41.Packet_41_Level level, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_41.levels.add(level);
        }
        return packet_41;
    }

}