package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_80Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_80(), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_80(3, 0, new Packet_80.Packet_80_MAMode()), "[80:8][3:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_80(0, 3, new Packet_80.Packet_80_MAMode()), "[80:8][0:2][85:13][3:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),

                Arguments.of("condition: D_MAMODE: Min", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false)), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("condition: D_MAMODE: Max", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(32767, 0, 0, 0, 0, false)), "[80:8][0:2][85:13][0:2][32767:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("condition: M_MAMODE: Min", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false)), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("condition: M_MAMODE: Max", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 3, 0, 0, 0, false)), "[80:8][0:2][85:13][0:2][0:15][3:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("condition: V_MAMODE: Min", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false)), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("condition: V_MAMODE: Max", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 127, 0, 0, false)), "[80:8][0:2][85:13][0:2][0:15][0:2][127:7][0:15][0:15]0[0:5]"),
                Arguments.of("condition: L_MAMODE: Min", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false)), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("condition: L_MAMODE: Max", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 0, 32767, 0, false)), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][32767:15][0:15]0[0:5]"),
                Arguments.of("condition: L_ACKMAMODE: Min", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false)), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("condition: L_ACKMAMODE: Max", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 32767, false)), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][32767:15]0[0:5]"),
                Arguments.of("condition: Q_MAMODE: False", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false)), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("condition: Q_MAMODE: True", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, true)), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]1[0:5]"),

                Arguments.of("conditions: Empty", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), "[80:8][0:2][85:13][0:2][0:15][0:2][0:7][0:15][0:15]0[0:5]"),
                Arguments.of("conditions: 1 Element", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][0:2][0:7][0:15][0:15]0*1}"),
                Arguments.of("conditions: D_MAMODE: Min", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][0:2][0:7][0:15][0:15]0*1}"),
                Arguments.of("conditions: D_MAMODE: Max", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(32767, 0, 0, 0, 0, false), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[32767:15][0:2][0:7][0:15][0:15]0*1}"),
                Arguments.of("conditions: M_MAMODE: Min", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][0:2][0:7][0:15][0:15]0*1}"),
                Arguments.of("conditions: M_MAMODE: Max", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 3, 0, 0, 0, false), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][3:2][0:7][0:15][0:15]0*1}"),
                Arguments.of("conditions: V_MAMODE: Min", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][0:2][0:7][0:15][0:15]0*1}"),
                Arguments.of("conditions: V_MAMODE: Max", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 127, 0, 0, false), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][0:2][127:7][0:15][0:15]0*1}"),
                Arguments.of("conditions: L_MAMODE: Min", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][0:2][0:7][0:15][0:15]0*1}"),
                Arguments.of("conditions: L_MAMODE: Max", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 32767, 0, false), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][0:2][0:7][32767:15][0:15]0*1}"),
                Arguments.of("conditions: L_ACKMAMODE: Min", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][0:2][0:7][0:15][0:15]0*1}"),
                Arguments.of("conditions: L_ACKMAMODE: Max", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 32767, false), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][0:2][0:7][0:15][32767:15]0*1}"),
                Arguments.of("conditions: Q_MAMODE: False", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][0:2][0:7][0:15][0:15]0*1}"),
                Arguments.of("conditions: Q_MAMODE: True", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, true), 1), "[80:8][0:2][140:13][0:2][0:15][0:2][0:7][0:15][0:15]0[1:5]{[0:15][0:2][0:7][0:15][0:15]1*1}"),
                Arguments.of("conditions: 1+ Elements", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false), 2), "[80:8][0:2][195:13][0:2][0:15][0:2][0:7][0:15][0:15]0[2:5]{[0:15][0:2][0:7][0:15][0:15]0*2}"),
                Arguments.of("conditions: Max Elements", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 0, false), 31), "[80:8][0:2][1790:13][0:2][0:15][0:2][0:7][0:15][0:15]0[31:5]{[0:15][0:2][0:7][0:15][0:15]0*31}"),

                Arguments.of("all", fill(new Packet_80(1, 1, new Packet_80.Packet_80_MAMode(6515, 1, 51, 27257, 7235, true)), new Packet_80.Packet_80_MAMode(18153, 3, 73, 8925, 12733, false), 1), "[80:8][1:2][140:13][1:2][06515:15][1:2][51:7][27257:15][07235:15]1[1:5]{[018153:15][3:2][73:7][8925:15][12733:15]0*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Max", new Packet_80(4, 0, new Packet_80.Packet_80_MAMode()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Max", new Packet_80(0, 4, new Packet_80.Packet_80_MAMode()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("condition: D_MAMODE: Max", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(32768, 0, 0, 0, 0, false)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("condition: M_MAMODE: Max", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 4, 0, 0, 0, false)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("condition: V_MAMODE: Max", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 128, 0, 0, false)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("condition: L_MAMODE: Max", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 0, 32768, 0, false)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("condition: L_ACKMAMODE: Max", new Packet_80(0, 0, new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 32768, false)), new IllegalArgumentException("Invalid value for given bit length")),
                // condition: Q_MAMODE is a boolean -> no overflow test needed
                Arguments.of("conditions: D_MAMODE: Max", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(32768, 0, 0, 0, 0, false), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("conditions: M_MAMODE: Max", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 4, 0, 0, 0, false), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("conditions: V_MAMODE: Max", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 128, 0, 0, false), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("conditions: L_MAMODE: Max", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 32768, 0, false), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("conditions: L_ACKMAMODE: Max", fill(new Packet_80(0, 0, new Packet_80.Packet_80_MAMode()), new Packet_80.Packet_80_MAMode(0, 0, 0, 0, 32768, false), 1), new IllegalArgumentException("Invalid value for given bit length"))
                // conditions: Q_MAMODE is a boolean -> no overflow test needed
        );
    }

    public static Packet_80 fill(Packet_80 packet_80, Packet_80.Packet_80_MAMode mode, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_80.modes.add(mode);
        }
        return packet_80;
    }

}