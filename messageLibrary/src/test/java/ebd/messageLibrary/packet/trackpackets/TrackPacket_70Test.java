package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_70Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_70(), "[70:8][0:2][56:13][0:2]0[0:15][0:2][0:8][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), "[70:8][0:2][56:13][0:2]0[0:15][0:2][0:8][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_70(3, 0, false, 0, new Packet_70.Packet_70_Characteristic()), "[70:8][3:2][56:13][0:2]0[0:15][0:2][0:8][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), "[70:8][0:2][56:13][0:2]0[0:15][0:2][0:8][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_70(0, 3, false, 0, new Packet_70.Packet_70_Characteristic()), "[70:8][0:2][56:13][3:2]0[0:15][0:2][0:8][0:5]"),
                Arguments.of("Q_TRACKINIT: False", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), "[70:8][0:2][56:13][0:2]0[0:15][0:2][0:8][0:5]"),
                Arguments.of("Q_TRACKINIT: True", new Packet_70(0, 0, true, 0, new Packet_70.Packet_70_Characteristic()), "[70:8][0:2][41:13][0:2]1[0:15]"),
                Arguments.of("D_TRACKINIT: Min", new Packet_70(0, 0, true, 0, new Packet_70.Packet_70_Characteristic()), "[70:8][0:2][41:13][0:2]1[0:15]"),
                Arguments.of("D_TRACKINIT: Max", new Packet_70(0, 0, true, 32767, new Packet_70.Packet_70_Characteristic()), "[70:8][0:2][41:13][0:2]1[32767:15]"),

                Arguments.of("characteristic: D_SUITABILITY: Min", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 0, 0, 0, 0, 0)), "[70:8][0:2][56:13][0:2]0[0:15][0:2][0:8][0:5]"),
                Arguments.of("characteristic: D_SUITABILITY: Max", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(32767, 0, 0, 0, 0, 0)), "[70:8][0:2][56:13][0:2]0[32767:15][0:2][0:8][0:5]"),
                Arguments.of("characteristic: Q_SUITABILITY: Min", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 0, 0, 0, 0, 0)), "[70:8][0:2][56:13][0:2]0[0:15][0:2][0:8][0:5]"),
                Arguments.of("characteristic: Q_SUITABILITY: Max", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 3, 0, 0, 0, 0)), "[70:8][0:2][48:13][0:2]0[0:15][3:2][0:5]"),
                Arguments.of("characteristic: M_LINEGAUGE: Min", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 0, 0, 0, 0, 0)), "[70:8][0:2][56:13][0:2]0[0:15][0:2][0:8][0:5]"),
                Arguments.of("characteristic: M_LINEGAUGE: Max", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 0, 255, 0, 0, 0)), "[70:8][0:2][56:13][0:2]0[0:15][0:2][255:8][0:5]"),
                Arguments.of("characteristic: M_AXLELOADCAT: Min", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 1, 0, 0, 0, 0)), "[70:8][0:2][55:13][0:2]0[0:15][1:2][0:7][0:5]"),
                Arguments.of("characteristic: M_AXLELOADCAT: Max", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 1, 0, 127, 0, 0)), "[70:8][0:2][55:13][0:2]0[0:15][1:2][127:7][0:5]"),
                Arguments.of("characteristic: M_VOLTAGE: Min", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 0, 0)), "[70:8][0:2][52:13][0:2]0[0:15][2:2][0:4][0:5]"),
                Arguments.of("characteristic: M_VOLTAGE: Max", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 15, 0)), "[70:8][0:2][62:13][0:2]0[0:15][2:2][15:4][0:10][0:5]"),
                Arguments.of("characteristic: NID_CTRACTION: Min", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 1, 0)), "[70:8][0:2][62:13][0:2]0[0:15][2:2][1:4][0:10][0:5]"),
                Arguments.of("characteristic: NID_CTRACTION: Max", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 1, 1023)), "[70:8][0:2][62:13][0:2]0[0:15][2:2][1:4][1023:10][0:5]"),

                Arguments.of("characteristics: Empty", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), "[70:8][0:2][56:13][0:2]0[0:15][0:2][0:8][0:5]"),
                Arguments.of("characteristics: 1 Element", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(), 1), "[70:8][0:2][81:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][0:2][0:8]*1}"),
                Arguments.of("characteristics: D_SUITABILITY: Min", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 0, 0, 0, 0, 0), 1), "[70:8][0:2][81:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][0:2][0:8]*1}"),
                Arguments.of("characteristics: D_SUITABILITY: Max", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(32767, 0, 0, 0, 0, 0), 1), "[70:8][0:2][81:13][0:2]0[0:15][0:2][0:8][1:5]{[32767:15][0:2][0:8]*1}"),
                Arguments.of("characteristics: Q_SUITABILITY: Min", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 0, 0, 0, 0, 0), 1), "[70:8][0:2][81:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][0:2][0:8]*1}"),
                Arguments.of("characteristics: Q_SUITABILITY: Max", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 3, 0, 0, 0, 0), 1), "[70:8][0:2][73:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][3:2]*1}"),
                Arguments.of("characteristics: M_LINEGAUGE: Min", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 0, 0, 0, 0, 0), 1), "[70:8][0:2][81:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][0:2][0:8]*1}"),
                Arguments.of("characteristics: M_LINEGAUGE: Max", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 0, 255, 0, 0, 0), 1), "[70:8][0:2][81:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][0:2][255:8]*1}"),
                Arguments.of("characteristics: M_AXLELOADCAT: Min", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 1, 0, 0, 0, 0), 1), "[70:8][0:2][80:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][1:2][0:7]*1}"),
                Arguments.of("characteristics: M_AXLELOADCAT: Max", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 1, 0, 127, 0, 0), 1), "[70:8][0:2][80:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][1:2][127:7]*1}"),
                Arguments.of("characteristics: M_VOLTAGE: Min", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 0, 0), 1), "[70:8][0:2][77:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][2:2][0:4]*1}"),
                Arguments.of("characteristics: M_VOLTAGE: Max", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 15, 0), 1), "[70:8][0:2][87:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][2:2][15:4][0:10]*1}"),
                Arguments.of("characteristics: NID_CTRACTION: Min", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 1, 0), 1), "[70:8][0:2][87:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][2:2][1:4][0:10]*1}"),
                Arguments.of("characteristics: NID_CTRACTION: Max", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 1, 1023), 1), "[70:8][0:2][87:13][0:2]0[0:15][0:2][0:8][1:5]{[0:15][2:2][1:4][1023:10]*1}"),
                Arguments.of("characteristics: 1+ Elements", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 0, 0, 0, 0, 0), 2), "[70:8][0:2][106:13][0:2]0[0:15][0:2][0:8][2:5]{[0:15][0:2][0:8]*2}"),
                Arguments.of("characteristics: Max Elements", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 0, 0, 0, 0, 0), 31), "[70:8][0:2][831:13][0:2]0[0:15][0:2][0:8][31:5]{[0:15][0:2][0:8]*31}"),

                Arguments.of("all", fill(new Packet_70(1, 1, false, 0, new Packet_70.Packet_70_Characteristic(5498, 2, 0, 0, 4, 842)), new Packet_70.Packet_70_Characteristic(6183, 1, 0, 14, 0, 0), 1), "[70:8][1:2][86:13][1:2]0[5498:15][2:2][4:4][842:10][1:5]{[6183:15][1:2][14:7]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_70(4, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_70(0, 4, false, 0, new Packet_70.Packet_70_Characteristic()), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_TRACKINIT is a boolean -> no overflow test needed
                Arguments.of("D_TRACKINIT: Overflow", new Packet_70(0, 0, true, 32768, new Packet_70.Packet_70_Characteristic()), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("characteristic: D_SUITABILITY: Overflow", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(32768, 0, 0, 0, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("characteristic: Q_SUITABILITY: Overflow", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 4, 0, 0, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("characteristic: M_LINEGAUGE: Overflow", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 0, 256, 0, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("characteristic: M_AXLELOADCAT: Overflow", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 1, 0, 128, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("characteristic: M_VOLTAGE: Overflow", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 16, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("characteristic: NID_CTRACTION: Overflow", new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 1, 1024)), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("characteristics: D_SUITABILITY: Overflow", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(32768, 0, 0, 0, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("characteristics: Q_SUITABILITY: Overflow", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 4, 0, 0, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("characteristics: M_LINEGAUGE: Overflow", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 0, 256, 0, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("characteristics: M_AXLELOADCAT: Overflow", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 1, 0, 128, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("characteristics: M_VOLTAGE: Overflow", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 16, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("characteristics: NID_CTRACTION: Overflow", fill(new Packet_70(0, 0, false, 0, new Packet_70.Packet_70_Characteristic()), new Packet_70.Packet_70_Characteristic(0, 2, 0, 0, 1, 1024), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_70 fill(Packet_70 Packet_70, Packet_70.Packet_70_Characteristic characteristic, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            Packet_70.characteristics.add(characteristic);
        }
        return Packet_70;
    }
    
}