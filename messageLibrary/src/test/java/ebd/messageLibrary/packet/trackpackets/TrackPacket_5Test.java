package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_5Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_5(), "[5:8][0:2][69:13][0:2][0:15]0[0:14]0[0:2][0:6][0:5]"),
                Arguments.of("Q_DIR: Min", new Packet_5(0,0, new Packet_5.Packet_5_Link()), "[5:8][0:2][69:13][0:2][0:15]0[0:14]0[0:2][0:6][0:5]"),
                Arguments.of("Q_DIR: Max", new Packet_5(3,0, new Packet_5.Packet_5_Link()), "[5:8][3:2][69:13][0:2][0:15]0[0:14]0[0:2][0:6][0:5]"),
                Arguments.of("Q_SCALE: Min", new Packet_5(0, 0, new Packet_5.Packet_5_Link()), "[5:8][0:2][69:13][0:2][0:15]0[0:14]0[0:2][0:6][0:5]"),
                Arguments.of("Q_SCALE: Max", new Packet_5(0, 3, new Packet_5.Packet_5_Link()), "[5:8][0:2][69:13][3:2][0:15]0[0:14]0[0:2][0:6][0:5]"),

                Arguments.of("link: D_LINK: Min", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0)), "[5:8][0:2][69:13][0:2][0:15]0[0:14]0[0:2][0:6][0:5]"),
                Arguments.of("link: D_LINK: Max", new Packet_5(0, 0, new Packet_5.Packet_5_Link(32767, false, 0, 0, false, 0, 0)), "[5:8][0:2][69:13][0:2][32767:15]0[0:14]0[0:2][0:6][0:5]"),
                Arguments.of("link: Q_NEWCOUNTRY: False", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0)), "[5:8][0:2][69:13][0:2][0:15]0[0:14]0[0:2][0:6][0:5]"),
                Arguments.of("link: Q_NEWCOUNTRY: True", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, true, 0, 0, false, 0, 0)), "[5:8][0:2][79:13][0:2][0:15]1[0:10][0:14]0[0:2][0:6][0:5]"),
                Arguments.of("link: NID_C: Min", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, true, 0, 0, false, 0, 0)), "[5:8][0:2][79:13][0:2][0:15]1[0:10][0:14]0[0:2][0:6][0:5]"),
                Arguments.of("link: NID_C: Max", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, true, 1023, 0, false, 0, 0)), "[5:8][0:2][79:13][0:2][0:15]1[1023:10][0:14]0[0:2][0:6][0:5]"),
                Arguments.of("link: NID_BG: Min", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0)), "[5:8][0:2][69:13][0:2][0:15]0[0:14]0[0:2][0:6][0:5]"),
                Arguments.of("link: NID_BG: Max", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 16383, false, 0, 0)), "[5:8][0:2][69:13][0:2][0:15]0[16383:14]0[0:2][0:6][0:5]"),
                Arguments.of("link: Q_LINKORIENTATION: False", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0)), "[5:8][0:2][69:13][0:2][0:15]0[0:14]0[0:2][0:6][0:5]"),
                Arguments.of("link: Q_LINKORIENTATION: True", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, true, 0, 0)), "[5:8][0:2][69:13][0:2][0:15]0[0:14]1[0:2][0:6][0:5]"),
                Arguments.of("link: Q_LINKREACTION: Min", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0)), "[5:8][0:2][69:13][0:2][0:15]0[0:14]0[0:2][0:6][0:5]"),
                Arguments.of("link: Q_LINKREACTION: Max", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 3, 0)), "[5:8][0:2][69:13][0:2][0:15]0[0:14]0[3:2][0:6][0:5]"),
                Arguments.of("link: Q_LOCACC: Min", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0)), "[5:8][0:2][69:13][0:2][0:15]0[0:14]0[0:2][0:6][0:5]"),
                Arguments.of("link: Q_LOCACC: Max", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 63)), "[5:8][0:2][69:13][0:2][0:15]0[0:14]0[0:2][63:6][0:5]"),

                Arguments.of("links: Empty", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: 1 Element", fill(new Packet_5(), new Packet_5.Packet_5_Link(), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: D_LINK: Min", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: D_LINK: Max", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(32767, false, 0, 0, false, 0, 0), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[32767:15]0[0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: Q_NEWCOUNTRY: False", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: Q_NEWCOUNTRY: True", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, true, 0, 0, false, 0, 0), 1), "[5:8][0:2][118:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]1[0:10][0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: NID_C: Min", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, true, 0, 0, false, 0, 0), 1), "[5:8][0:2][118:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]1[0:10][0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: NID_C: Max", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, true, 1023, 0, false, 0, 0), 1), "[5:8][0:2][118:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]1[1023:10][0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: NID_BG: Min", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: NID_BG: Max", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 16383, false, 0, 0), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[16383:14]0[0:2][0:6]*1}"),
                Arguments.of("links: Q_LINKORIENTATION: False", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: Q_LINKORIENTATION: True", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, true, 0, 0), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[0:14]1[0:2][0:6]*1}"),
                Arguments.of("links: Q_LINKREACTION: Min", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: Q_LINKREACTION: Max", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, false, 3, 0), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[0:14]0[3:2][0:6]*1}"),
                Arguments.of("links: Q_LOCACC: Min", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[0:14]0[0:2][0:6]*1}"),
                Arguments.of("links: Q_LOCACC: Max", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 63), 1), "[5:8][0:2][108:13][0:2][0:15]0[0:14]0[0:2][0:6][1:5]{[0:15]0[0:14]0[0:2][63:6]*1}"),
                Arguments.of("links: 1+ Elements", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 0), 2), "[5:8][0:2][147:13][0:2][0:15]0[0:14]0[0:2][0:6][2:5]{[0:15]0[0:14]0[0:2][0:6]*2}"),
                Arguments.of("links: Max Elements", fill(new Packet_5(0, 0, new Packet_5.Packet_5_Link()), new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 23), 31), "[5:8][0:2][1278:13][0:2][0:15]0[0:14]0[0:2][0:6][31:5]{[0:15]0[0:14]0[0:2][23:6]*31}"),

                Arguments.of("all", new Packet_5(2, 1, new Packet_5.Packet_5_Link(8223, true, 139, 7522, true, 3, 20)), "[5:8][2:2][79:13][1:2][8223:15]1[139:10][7522:14]1[3:2][20:6][0:5]")
         );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_5(4,0, new Packet_5.Packet_5_Link()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("Q_SCALE: Overflow", new Packet_5(0, 4, new Packet_5.Packet_5_Link()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("link: D_LINK: Overflow", new Packet_5(0, 0, new Packet_5.Packet_5_Link(32768, false, 0, 0, false, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                // Link: Q_NEWCOUNTRY is a boolean -> no overflow test needed
                Arguments.of("link: NID_C: Overflow", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, true, 1024, 0, false, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("link: NID_BG: Overflow", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 16384, false, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                // Link: Q_LINKORIENTATION is a boolean -> no overflow test needed
                Arguments.of("link: Q_LINKREACTION: Overflow", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 4, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("link: Q_LOCACC: Overflow", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 64)), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("links: D_LINK: Overflow", new Packet_5(0, 0, new Packet_5.Packet_5_Link(32768, false, 0, 0, false, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                // Links: Q_NEWCOUNTRY is a boolean -> no overflow test needed
                Arguments.of("links: NID_C: Overflow", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, true, 1024, 0, false, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("links: NID_BG: Overflow", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 16384, false, 0, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                // Links: Q_LINKORIENTATION is a boolean -> no overflow test needed
                Arguments.of("links: Q_LINKREACTION: Overflow", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 4, 0)), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("links: Q_LOCACC: Overflow", new Packet_5(0, 0, new Packet_5.Packet_5_Link(0, false, 0, 0, false, 0, 64)), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

    public static Packet_5 fill(Packet_5 packet_5, Packet_5.Packet_5_Link link, int count) {
        assert(count < 32);
        for(int i = 0; i < count; i++) {
            packet_5.links.add(link);
        }
        return packet_5;
    }

}