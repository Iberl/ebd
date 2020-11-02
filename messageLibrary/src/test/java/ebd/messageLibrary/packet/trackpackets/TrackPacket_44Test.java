package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import ebd.messageLibrary.util.userData.UserData_0;
import ebd.messageLibrary.util.userData.UserData_511;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_44Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_44(), "[44:8][0:2][49:13][0:9][0:8][0:9]"),
                Arguments.of("Q_DIR: Min", new Packet_44(0, 0, 0, new UserData_0()), "[44:8][0:2][49:13][0:9][0:8][0:9]"),
                Arguments.of("Q_DIR: Max", new Packet_44(3, 0, 0, new UserData_0()), "[44:8][3:2][49:13][0:9][0:8][0:9]"),
                Arguments.of("NID_XUSER: Min", new Packet_44(0, 0, 0, new UserData_0()), "[44:8][0:2][49:13][0:9][0:8][0:9]"),
                Arguments.of("NID_XUSER: Max", new Packet_44(0, 511, 0, new UserData_511()), "[44:8][0:2][49:13][511:9][0:8][511:9]"),
                Arguments.of("NID_NTC: Min", new Packet_44(0, 0, 0, new UserData_0()), "[44:8][0:2][49:13][0:9][0:8][0:9]"),
                Arguments.of("NID_NTC: Max", new Packet_44(0, 0, 255, new UserData_0()), "[44:8][0:2][49:13][0:9][255:8][0:9]")
                // userData too universal
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_44(4, 0, 0, new UserData_0()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_XUSER: Overflow", new Packet_44(0, 512, 0, new UserData_0()), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NID_NTC: Overflow", new Packet_44(0, 0, 256, new UserData_0()), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

}