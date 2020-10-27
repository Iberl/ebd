package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_52Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_52(), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_52(3, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), "[52:8][3:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_52(0, 3, false, 0, new Packet_52.Packet_52_BreakingInfo()), "[52:8][0:2][86:13][3:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("Q_TRACKINIT: False", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("Q_TRACKINIT: True", new Packet_52(0, 0, true, 0, new Packet_52.Packet_52_BreakingInfo()), "[52:8][0:2][41:13][0:2]1[0:15]"),
                Arguments.of("D_TRACKINIT: Min", new Packet_52(0, 0, true, 0, new Packet_52.Packet_52_BreakingInfo()), "[52:8][0:2][41:13][0:2]1[0:15]"),
                Arguments.of("D_TRACKINIT: Max", new Packet_52(0, 0, true, 32767, new Packet_52.Packet_52_BreakingInfo()), "[52:8][0:2][41:13][0:2]1[32767:15]"),
                
                Arguments.of("breakingInfo: D_PBD: Min", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0)), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("breakingInfo: D_PBD: Max", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(32767, false, 0, false, 0, 0)), "[52:8][0:2][86:13][0:2]0[32767:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("breakingInfo: Q_GDIR: False", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0)), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("breakingInfo: Q_GDIR: True", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, true, 0, false, 0, 0)), "[52:8][0:2][86:13][0:2]0[0:15]1[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("breakingInfo: G_PBDSR: Min", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0)), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("breakingInfo: G_PBDSR: Max", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 255, false, 0, 0)), "[52:8][0:2][86:13][0:2]0[0:15]0[255:8]0[0:15][0:15][0:5]"),
                Arguments.of("breakingInfo: Q_PBDSR: False", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0)), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("breakingInfo: Q_PBDSR: True", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 0, true, 0, 0)), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]1[0:15][0:15][0:5]"),
                Arguments.of("breakingInfo: D_PBDSR: Min", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0)), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("breakingInfo: D_PBDSR: Max", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 32767, 0)), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[32767:15][0:15][0:5]"),
                Arguments.of("breakingInfo: L_PBDSR: Min", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0)), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("breakingInfo: L_PBDSR: Max", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 32767)), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][32767:15][0:5]"),

                Arguments.of("breakingInfos: Empty", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), "[52:8][0:2][86:13][0:2]0[0:15]0[0:8]0[0:15][0:15][0:5]"),
                Arguments.of("breakingInfos: 1 Element", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]0[0:8]0[0:15][0:15]*1}"),
                Arguments.of("breakingInfos: D_PBD: Min", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]0[0:8]0[0:15][0:15]*1}"),
                Arguments.of("breakingInfos: D_PBD: Max", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(32767, false, 0, false, 0, 0), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[32767:15]0[0:8]0[0:15][0:15]*1}"),
                Arguments.of("breakingInfos: Q_GDIR: False", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]0[0:8]0[0:15][0:15]*1}"),
                Arguments.of("breakingInfos: Q_GDIR: True", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, true, 0, false, 0, 0), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]1[0:8]0[0:15][0:15]*1}"),
                Arguments.of("breakingInfos: G_PBDSR: Min", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]0[0:8]0[0:15][0:15]*1}"),
                Arguments.of("breakingInfos: G_PBDSR: Max", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 255, false, 0, 0), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]0[255:8]0[0:15][0:15]*1}"),
                Arguments.of("breakingInfos: Q_PBDSR: False", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]0[0:8]0[0:15][0:15]*1}"),
                Arguments.of("breakingInfos: Q_PBDSR: True", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, true, 0, 0), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]0[0:8]1[0:15][0:15]*1}"),
                Arguments.of("breakingInfos: D_PBDSR: Min", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]0[0:8]0[0:15][0:15]*1}"),
                Arguments.of("breakingInfos: D_PBDSR: Max", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 32767, 0), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]0[0:8]0[32767:15][0:15]*1}"),
                Arguments.of("breakingInfos: L_PBDSR: Min", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]0[0:8]0[0:15][0:15]*1}"),
                Arguments.of("breakingInfos: L_PBDSR: Max", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 32767), 1), "[52:8][0:2][141:13][0:2]0[0:15]0[0:8]0[0:15][0:15][1:5]{[0:15]0[0:8]0[0:15][32767:15]*1}"),
                Arguments.of("breakingInfos: 1+ Elements", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0), 2), "[52:8][0:2][196:13][0:2]0[0:15]0[0:8]0[0:15][0:15][2:5]{[0:15]0[0:8]0[0:15][0:15]*2}"),
                Arguments.of("breakingInfos: Max Elements", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 0), 31), "[52:8][0:2][1791:13][0:2]0[0:15]0[0:8]0[0:15][0:15][31:5]{[0:15]0[0:8]0[0:15][0:15]*31}"),

                Arguments.of("all", fill(new Packet_52(1, 1, false, 0, new Packet_52.Packet_52_BreakingInfo(6283, false, 253, true, 6159, 9841)), new Packet_52.Packet_52_BreakingInfo(3957, true, 34, false, 7284, 18223), 1), "[52:8][1:2][141:13][1:2]0[6283:15]0[253:8]1[6159:15][9841:15][1:5]{[3957:15]1[34:8]0[7284:15][18223:15]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_52(4, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_52(0, 4, false, 0, new Packet_52.Packet_52_BreakingInfo()), new IllegalArgumentException("Invalid value for given bit length")),
                // Q_TRACKINIT is a boolean -> no overflow test needed
                Arguments.of("D_TRACKINIT: Overflow", new Packet_52(0, 0, true, 32768, new Packet_52.Packet_52_BreakingInfo()), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("breakingInfo: D_PBD: Overflow", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(32768, false, 0, false, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                // breakingInfo: Q_GDIR is a boolean -> no overflow test needed
                Arguments.of("breakingInfo: G_PBDSR: Overflow", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 256, false, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                // breakingInfo: Q_PBDSR is a boolean -> no overflow test needed
                Arguments.of("breakingInfo: D_PBDSR: Overflow", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 32768, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("breakingInfo: L_PBDSR: Overflow", new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 32768)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("breakingInfos: D_PBD: Overflow", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(32768, false, 0, false, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                // breakingInfos: Q_GDIR is a boolean -> no overflow test needed
                Arguments.of("breakingInfos: G_PBDSR: Overflow", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 256, false, 0, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                // breakingInfos: Q_PBDSR is a boolean -> no overflow test needed
                Arguments.of("breakingInfos: D_PBDSR: Overflow", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 32768, 0), 1), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("breakingInfos: L_PBDSR: Overflow", fill(new Packet_52(0, 0, false, 0, new Packet_52.Packet_52_BreakingInfo()), new Packet_52.Packet_52_BreakingInfo(0, false, 0, false, 0, 32768), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_52 fill(Packet_52 packet_52, Packet_52.Packet_52_BreakingInfo breakingInfo, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_52.breakingInfos.add(breakingInfo);
        }
        return packet_52;
    }
    
}