package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_69Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_69(), "[69:8][0:2][67:13][0:2]0[0:15][0:15][0:4][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), "[69:8][0:2][67:13][0:2]0[0:15][0:15][0:4][0:2][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_69(3, 0, false, 0, new Packet_69.Packet_69_Platform()), "[69:8][3:2][67:13][0:2]0[0:15][0:15][0:4][0:2][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), "[69:8][0:2][67:13][0:2]0[0:15][0:15][0:4][0:2][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_69(0, 3, false, 0, new Packet_69.Packet_69_Platform()), "[69:8][0:2][67:13][3:2]0[0:15][0:15][0:4][0:2][0:5]"),
                Arguments.of("Q_TRACKINIT: False", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), "[69:8][0:2][67:13][0:2]0[0:15][0:15][0:4][0:2][0:5]"),
                Arguments.of("Q_TRACKINIT: True", new Packet_69(0, 0, true, 0, new Packet_69.Packet_69_Platform()), "[69:8][0:2][41:13][0:2]1[0:15]"),
                Arguments.of("D_TRACKINIT: Min", new Packet_69(0, 0, true, 0, new Packet_69.Packet_69_Platform()), "[69:8][0:2][41:13][0:2]1[0:15]"),
                Arguments.of("D_TRACKINIT: Max", new Packet_69(0, 0, true, 32767, new Packet_69.Packet_69_Platform()), "[69:8][0:2][41:13][0:2]1[32767:15]"),

                Arguments.of("platform: D_TRACKCOND: Min", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(0, 0, 0, 0)), "[69:8][0:2][67:13][0:2]0[0:15][0:15][0:4][0:2][0:5]"),
                Arguments.of("platform: D_TRACKCOND: Max", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(32767, 0, 0, 0)), "[69:8][0:2][67:13][0:2]0[32767:15][0:15][0:4][0:2][0:5]"),
                Arguments.of("platform: L_TRACKCOND: Min", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(0, 0, 0, 0)), "[69:8][0:2][67:13][0:2]0[0:15][0:15][0:4][0:2][0:5]"),
                Arguments.of("platform: L_TRACKCOND: Max", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(0, 32767, 0, 0)), "[69:8][0:2][67:13][0:2]0[0:15][32767:15][0:4][0:2][0:5]"),
                Arguments.of("platform: M_PLATFORM: Min", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(0, 0, 0, 0)), "[69:8][0:2][67:13][0:2]0[0:15][0:15][0:4][0:2][0:5]"),
                Arguments.of("platform: M_PLATFORM: Max", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(0, 0, 15, 0)), "[69:8][0:2][67:13][0:2]0[0:15][0:15][15:4][0:2][0:5]"),
                Arguments.of("platform: Q_PLATFORM: Min", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(0, 0, 0, 0)), "[69:8][0:2][67:13][0:2]0[0:15][0:15][0:4][0:2][0:5]"),
                Arguments.of("platform: Q_PLATFORM: Max", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(0, 0, 0, 3)), "[69:8][0:2][67:13][0:2]0[0:15][0:15][0:4][3:2][0:5]"),

                Arguments.of("platforms: Empty", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), "[69:8][0:2][67:13][0:2]0[0:15][0:15][0:4][0:2][0:5]"),
                Arguments.of("platforms: 1 Element", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(), 1), "[69:8][0:2][103:13][0:2]0[0:15][0:15][0:4][0:2][1:5]{[0:15][0:15][0:4][0:2]*1}"),
                Arguments.of("platforms: D_TRACKCOND: Min", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 0, 0, 0), 1), "[69:8][0:2][103:13][0:2]0[0:15][0:15][0:4][0:2][1:5]{[0:15][0:15][0:4][0:2]*1}"),
                Arguments.of("platforms: D_TRACKCOND: Max", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(32767, 0, 0, 0), 1), "[69:8][0:2][103:13][0:2]0[0:15][0:15][0:4][0:2][1:5]{[32767:15][0:15][0:4][0:2]*1}"),
                Arguments.of("platforms: L_TRACKCOND: Min", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 0, 0, 0), 1), "[69:8][0:2][103:13][0:2]0[0:15][0:15][0:4][0:2][1:5]{[0:15][0:15][0:4][0:2]*1}"),
                Arguments.of("platforms: L_TRACKCOND: Max", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 32767, 0, 0), 1), "[69:8][0:2][103:13][0:2]0[0:15][0:15][0:4][0:2][1:5]{[0:15][32767:15][0:4][0:2]*1}"),
                Arguments.of("platforms: M_PLATFORM: Min", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 0, 0, 0), 1), "[69:8][0:2][103:13][0:2]0[0:15][0:15][0:4][0:2][1:5]{[0:15][0:15][0:4][0:2]*1}"),
                Arguments.of("platforms: M_PLATFORM: Max", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 0, 15, 0), 1), "[69:8][0:2][103:13][0:2]0[0:15][0:15][0:4][0:2][1:5]{[0:15][0:15][15:4][0:2]*1}"),
                Arguments.of("platforms: Q_PLATFORM: Min", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 0, 0, 0), 1), "[69:8][0:2][103:13][0:2]0[0:15][0:15][0:4][0:2][1:5]{[0:15][0:15][0:4][0:2]*1}"),
                Arguments.of("platforms: Q_PLATFORM: Max", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 0, 0, 3), 1), "[69:8][0:2][103:13][0:2]0[0:15][0:15][0:4][0:2][1:5]{[0:15][0:15][0:4][3:2]*1}"),
                Arguments.of("platforms: 1+ Elements", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 0, 0, 0), 2), "[69:8][0:2][139:13][0:2]0[0:15][0:15][0:4][0:2][2:5]{[0:15][0:15][0:4][0:2]*2}"),
                Arguments.of("platforms: Max Elements", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 0, 0, 0), 31), "[69:8][0:2][1183:13][0:2]0[0:15][0:15][0:4][0:2][31:5]{[0:15][0:15][0:4][0:2]*31}"),

                Arguments.of("all", fill(new Packet_69(1, 1, false, 0, new Packet_69.Packet_69_Platform(5428, 9826, 12, 0)), new Packet_69.Packet_69_Platform(6183, 1272, 7, 0), 1), "[69:8][1:2][103:13][1:2]0[5428:15][9826:15][12:4][0:2][1:5]{[6183:15][1272:15][7:4][0:2]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Max", new Packet_69(4, 0, false, 0, new Packet_69.Packet_69_Platform()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Max", new Packet_69(0, 4, false, 0, new Packet_69.Packet_69_Platform()), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_TRACKINIT is a boolean -> no overflow test needed
                Arguments.of("D_TRACKINIT: Max", new Packet_69(0, 0, true, 32768, new Packet_69.Packet_69_Platform()), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("platform: D_TRACKCOND: Max", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(32768, 0, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("platform: L_TRACKCOND: Max", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(0, 32768, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("platform: M_TRACKCOND: Max", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(0, 0, 16, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("platform: Q_PLATFORM: Max", new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform(0, 0, 0, 4)), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("platforms: D_TRACKCOND: Max", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(32768, 0, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("platforms: L_TRACKCOND: Max", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 32768, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("platforms: M_TRACKCOND: Max", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 0, 16, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("platforms: Q_PLATFORM: Max", fill(new Packet_69(0, 0, false, 0, new Packet_69.Packet_69_Platform()), new Packet_69.Packet_69_Platform(0, 0, 0, 4), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_69 fill(Packet_69 packet_69, Packet_69.Packet_69_Platform platform, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_69.platforms.add(platform);
        }
        return packet_69;
    }
    
}