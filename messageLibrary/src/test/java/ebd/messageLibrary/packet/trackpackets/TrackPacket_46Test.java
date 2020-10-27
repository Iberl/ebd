package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_46Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_46(), "[46:8][0:2][39:13][0:3][0:8][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_46(0, new Packet_46.Packet_46_Level()), "[46:8][0:2][39:13][0:3][0:8][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_46(3, new Packet_46.Packet_46_Level()), "[46:8][3:2][39:13][0:3][0:8][0:5]"),

                Arguments.of("level: M_LEVELTR: Min", new Packet_46(0, new Packet_46.Packet_46_Level(0, 0)), "[46:8][0:2][39:13][0:3][0:8][0:5]"),
                Arguments.of("level: M_LEVELTR: Max", new Packet_46(0, new Packet_46.Packet_46_Level(7, 0)), "[46:8][0:2][39:13][7:3][0:8][0:5]"),
                Arguments.of("level: NID_NTC: Min", new Packet_46(0, new Packet_46.Packet_46_Level(0, 0)), "[46:8][0:2][39:13][0:3][0:8][0:5]"),
                Arguments.of("level: NID_NTC: Max", new Packet_46(0, new Packet_46.Packet_46_Level(0, 255)), "[46:8][0:2][39:13][0:3][255:8][0:5]"),

                Arguments.of("levels: Empty", fill(new Packet_46(0, new Packet_46.Packet_46_Level(0, 0)), new Packet_46.Packet_46_Level(0, 0), 1), "[46:8][0:2][50:13][0:3][0:8][1:5]{[0:3][0:8]*1}"),
                Arguments.of("levels: 1 Element", fill(new Packet_46(0, new Packet_46.Packet_46_Level()), new Packet_46.Packet_46_Level(), 1), "[46:8][0:2][50:13][0:3][0:8][1:5]{[0:3][0:8]*1}"),
                Arguments.of("levels: M_LEVELTR: Min", fill(new Packet_46(0, new Packet_46.Packet_46_Level(0, 0)), new Packet_46.Packet_46_Level(0, 0), 1), "[46:8][0:2][50:13][0:3][0:8][1:5]{[0:3][0:8]*1}"),
                Arguments.of("levels: M_LEVELTR: Max", fill(new Packet_46(0, new Packet_46.Packet_46_Level(0, 0)), new Packet_46.Packet_46_Level(7, 0), 1), "[46:8][0:2][50:13][0:3][0:8][1:5]{[7:3][0:8]*1}"),
                Arguments.of("levels: NID_NTC: Min", fill(new Packet_46(0, new Packet_46.Packet_46_Level(0, 0)), new Packet_46.Packet_46_Level(0, 0), 1), "[46:8][0:2][50:13][0:3][0:8][1:5]{[0:3][0:8]*1}"),
                Arguments.of("levels: NID_NTC: Max", fill(new Packet_46(0, new Packet_46.Packet_46_Level(0, 0)), new Packet_46.Packet_46_Level(0, 255), 1), "[46:8][0:2][50:13][0:3][0:8][1:5]{[0:3][255:8]*1}"),
                Arguments.of("levels: 1+ Elements", fill(new Packet_46(0, new Packet_46.Packet_46_Level(0, 0)), new Packet_46.Packet_46_Level(0, 0), 2), "[46:8][0:2][61:13][0:3][0:8][2:5]{[0:3][0:8]*2}"),
                Arguments.of("levels: Max Elements", fill(new Packet_46(0, new Packet_46.Packet_46_Level(0, 0)), new Packet_46.Packet_46_Level(0, 0), 31), "[46:8][0:2][380:13][0:3][0:8][31:5]{[0:3][0:8]*31}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Max", new Packet_46(4, new Packet_46.Packet_46_Level()), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("level: M_LEVELTR: Max", new Packet_46(0, new Packet_46.Packet_46_Level(8, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("level: NID_NTC: Max", new Packet_46(0, new Packet_46.Packet_46_Level(0, 256)), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("levels: M_LEVELTR: Max", fill(new Packet_46(0, new Packet_46.Packet_46_Level(0, 0)), new Packet_46.Packet_46_Level(8, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("levels: NID_NTC: Max", fill(new Packet_46(0, new Packet_46.Packet_46_Level(0, 0)), new Packet_46.Packet_46_Level(0, 256), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

    public static Packet_46 fill(Packet_46 packet_46, Packet_46.Packet_46_Level level, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_46.levels.add(level);
        }
        return packet_46;
    }

}