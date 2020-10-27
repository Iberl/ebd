package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacketTestBase;
import ebd.messageLibrary.util.userData.UserData_0;
import ebd.messageLibrary.util.userData.UserData_511;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrainPacket_44Test extends TrainPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_44(), "[44:8][39:13][0:9][0:9]"),
                Arguments.of("NID_XUSER: Min", new Packet_44(0, new UserData_0()), "[44:8][39:13][0:9][0:9]"),
                Arguments.of("NID_XUSER: Max", new Packet_44(511, new UserData_511()), "[44:8][39:13][511:9][511:9]")
                // userData too universal
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("NID_XUSER: Overflow", new Packet_44(512, new UserData_0()), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }

}