package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_21Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_21(), "[21:8][0:2][54:13][0:2][0:15]0[0:8][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), "[21:8][0:2][54:13][0:2][0:15]0[0:8][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_21(3, 0, new Packet_21.Packet_21_Gradient()), "[21:8][3:2][54:13][0:2][0:15]0[0:8][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), "[21:8][0:2][54:13][0:2][0:15]0[0:8][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_21(0, 3, new Packet_21.Packet_21_Gradient()), "[21:8][0:2][54:13][3:2][0:15]0[0:8][0:5]"),
                
                Arguments.of("gradient: D_GRADIENT: Min", new Packet_21(0, 0, new Packet_21.Packet_21_Gradient(0, false, 0)), "[21:8][0:2][54:13][0:2][0:15]0[0:8][0:5]"),
                Arguments.of("gradient: D_GRADIENT: Max", new Packet_21(0, 0, new Packet_21.Packet_21_Gradient(32767, false, 0)), "[21:8][0:2][54:13][0:2][32767:15]0[0:8][0:5]"),
                Arguments.of("gradient: Q_GDIR: False", new Packet_21(0, 0, new Packet_21.Packet_21_Gradient(0, false, 0)), "[21:8][0:2][54:13][0:2][0:15]0[0:8][0:5]"),
                Arguments.of("gradient: Q_GDIR: True", new Packet_21(0, 0, new Packet_21.Packet_21_Gradient(0, true, 0)), "[21:8][0:2][54:13][0:2][0:15]1[0:8][0:5]"),
                Arguments.of("gradient: G_A: Min", new Packet_21(0, 0, new Packet_21.Packet_21_Gradient(0, false, 0)), "[21:8][0:2][54:13][0:2][0:15]0[0:8][0:5]"),
                Arguments.of("gradient: G_A: Max", new Packet_21(0, 0, new Packet_21.Packet_21_Gradient(0, false, 255)), "[21:8][0:2][54:13][0:2][0:15]0[255:8][0:5]"),

                Arguments.of("gradients: Empty", new Packet_21(), "[21:8][0:2][54:13][0:2][0:15]0[0:8][0:5]"),
                Arguments.of("gradients: 1 Element", fill(new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), new Packet_21.Packet_21_Gradient(), 1), "[21:8][0:2][78:13][0:2][0:15]0[0:8][1:5]{[0:15]0[0:8]*1}"),
                Arguments.of("gradients: D_GRADIENT: Min", fill(new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), new Packet_21.Packet_21_Gradient(0, false, 0), 1), "[21:8][0:2][78:13][0:2][0:15]0[0:8][1:5]{[0:15]0[0:8]*1}"),
                Arguments.of("gradients: D_GRADIENT: Max", fill(new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), new Packet_21.Packet_21_Gradient(32767, false, 0), 1), "[21:8][0:2][78:13][0:2][0:15]0[0:8][1:5]{[32767:15]0[0:8]*1}"),
                Arguments.of("gradients: Q_GDIR: False", fill(new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), new Packet_21.Packet_21_Gradient(0, false, 0), 1), "[21:8][0:2][78:13][0:2][0:15]0[0:8][1:5]{[0:15]0[0:8]*1}"),
                Arguments.of("gradients: Q_GDIR: True", fill(new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), new Packet_21.Packet_21_Gradient(0, true, 0), 1), "[21:8][0:2][78:13][0:2][0:15]0[0:8][1:5]{[0:15]1[0:8]*1}"),
                Arguments.of("gradients: G_A: Min", fill(new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), new Packet_21.Packet_21_Gradient(0, false, 0), 1), "[21:8][0:2][78:13][0:2][0:15]0[0:8][1:5]{[0:15]0[0:8]*1}"),
                Arguments.of("gradients: G_A: Max", fill(new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), new Packet_21.Packet_21_Gradient(0, false, 255), 1), "[21:8][0:2][78:13][0:2][0:15]0[0:8][1:5]{[0:15]0[255:8]*1}"),
                Arguments.of("gradients: 1+ Elements", fill(new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), new Packet_21.Packet_21_Gradient(), 2), "[21:8][0:2][102:13][0:2][0:15]0[0:8][2:5]{[0:15]0[0:8]*2}"),
                Arguments.of("gradients: Max Elements", fill(new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), new Packet_21.Packet_21_Gradient(), 31), "[21:8][0:2][798:13][0:2][0:15]0[0:8][31:5]{[0:15]0[0:8]*31}"),

                Arguments.of("all", fill(new Packet_21(1, 1, new Packet_21.Packet_21_Gradient(9812, true, 68)), new Packet_21.Packet_21_Gradient(4134, true, 88), 1), "[21:8][1:2][78:13][1:2][9812:15]1[68:8][1:5]{[4134:15]1[88:8]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Max", new Packet_21(4, 0, new Packet_21.Packet_21_Gradient()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Max", new Packet_21(0, 4, new Packet_21.Packet_21_Gradient()), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("gradient: D_GRADIENT: Max", new Packet_21(0, 0, new Packet_21.Packet_21_Gradient(32768, false, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                // gradient: Q_GDIR is a boolean -> no overflow test needed
                Arguments.of("gradient: G_A: Max", new Packet_21(0, 0, new Packet_21.Packet_21_Gradient(0, false, 256)), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("gradients: D_GRADIENT: Max", fill(new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), new Packet_21.Packet_21_Gradient(32768, false, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                // gradients: Q_GDIR is a boolean -> no overflow test needed
                Arguments.of("gradients: G_A: Max", fill(new Packet_21(0, 0, new Packet_21.Packet_21_Gradient()), new Packet_21.Packet_21_Gradient(0, false, 256), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

    public static Packet_21 fill(Packet_21 packet_21, Packet_21.Packet_21_Gradient gradient, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_21.gradients.add(gradient);
        }
        return packet_21;
    }

}