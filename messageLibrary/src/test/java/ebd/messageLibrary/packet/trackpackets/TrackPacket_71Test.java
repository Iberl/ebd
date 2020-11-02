package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_71Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_71(), "[71:8][0:2][56:13][0:2][0:15][0:15]0"),
                Arguments.of("Q_DIR: Min", new Packet_71(0, 0, 0, 0, false), "[71:8][0:2][56:13][0:2][0:15][0:15]0"),
                Arguments.of("Q_DIR: Max", new Packet_71(3, 0, 0, 0, false), "[71:8][3:2][56:13][0:2][0:15][0:15]0"),
                Arguments.of("Q_SCALE: Min", new Packet_71(0, 0, 0, 0, false), "[71:8][0:2][56:13][0:2][0:15][0:15]0"),
                Arguments.of("Q_SCALE: Max", new Packet_71(0, 3, 0, 0, false), "[71:8][0:2][56:13][3:2][0:15][0:15]0"),
                Arguments.of("D_ADHESION: Min", new Packet_71(0, 0, 0, 0, false), "[71:8][0:2][56:13][0:2][0:15][0:15]0"),
                Arguments.of("D_ADHESION: Max", new Packet_71(0, 0, 32767, 0, false), "[71:8][0:2][56:13][0:2][32767:15][0:15]0"),
                Arguments.of("L_ADHESION: Min", new Packet_71(0, 0, 0, 0, false), "[71:8][0:2][56:13][0:2][0:15][0:15]0"),
                Arguments.of("L_ADHESION: Max", new Packet_71(0, 0, 0, 32767, false), "[71:8][0:2][56:13][0:2][0:15][32767:15]0"),
                Arguments.of("M_ADHESION: False", new Packet_71(0, 0, 0, 0, false), "[71:8][0:2][56:13][0:2][0:15][0:15]0"),
                Arguments.of("M_ADHESION: True", new Packet_71(0, 0, 0, 0, true), "[71:8][0:2][56:13][0:2][0:15][0:15]1"),
                Arguments.of("M_ADHESION: True", new Packet_71(1, 2, 4635, 6263, true), "[71:8][1:2][56:13][2:2][4635:15][6263:15]1")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_71(4, 0, 0, 0, false), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("Q_SCALE: Overflow", new Packet_71(0, 4, 0, 0, false), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("D_ADHESION: Overflow", new Packet_71(0, 0, 32768, 0, false), new IllegalArgumentException("Invalid value for given bit length.")),
                Arguments.of("L_ADHESION: Overflow", new Packet_71(0, 0, 0, 32768, false), new IllegalArgumentException("Invalid value for given bit length."))
                // M_ADHESION is a boolean -> no overflow test needed
        );
    }

}