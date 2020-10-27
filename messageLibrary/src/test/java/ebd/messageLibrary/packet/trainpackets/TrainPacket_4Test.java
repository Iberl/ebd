package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;


class TrainPacket_4Test extends TrainPacketTestBase {

	public static Stream<Arguments> data() {
		return Stream.of(
				Arguments.of("default", new Packet_4(), "[4:8][29:13][0:8]"),
				Arguments.of("M_ERROR: Min", new Packet_4(0), "[4:8][29:13][0:8]"),
				Arguments.of("M_ERROR: Max", new Packet_4(255), "[4:8][29:13][255:8]"),
				Arguments.of("all", new Packet_4(145), "[4:8][29:13][145:8]")
		);
	}

	public static Stream<Arguments> errors() {
		return Stream.of(
				Arguments.of("M_ERROR: Overflow", new Packet_4(256), new IllegalArgumentException("Invalid value for given bit length"))
		);
	}

}