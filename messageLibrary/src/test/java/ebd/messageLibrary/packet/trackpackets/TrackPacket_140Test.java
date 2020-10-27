package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacketTestBase;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import ebd.messageLibrary.util.ETCSVariables;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrackPacket_140Test extends TrackPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_140(), "[140:8][0:2][55:13][0:32]"),
                Arguments.of("Q_DIR: Min", new Packet_140(0, ETCSVariables.NID_OPERATIONAL), "[140:8][0:2][55:13][0:32]"),
                Arguments.of("Q_DIR: Max", new Packet_140(3, ETCSVariables.NID_OPERATIONAL), "[140:8][3:2][55:13][0:32]"),
                Arguments.of("NID_OPERATIONAL: Min", new Packet_140(0, ETCSVariables.NID_OPERATIONAL), "[140:8][0:2][55:13][0:32]"),
                Arguments.of("NID_OPERATIONAL: Max", new Packet_140(0, new BinaryCodedDecimal(-1L, 8)), "[140:8][0:2][55:13][-1:32]"),
                Arguments.of("all", new Packet_140(2, new BinaryCodedDecimal(-13649L, 8)), "[140:8][2:2][55:13][-13649:32]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("Q_DIR: Overflow", new Packet_140(4, ETCSVariables.NID_OPERATIONAL), new IllegalArgumentException("Invalid value for given bit length."))
                // NID_OPERATIONAL is in BCD format -> no overflow test needed
        );
    }

}