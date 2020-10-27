package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrainPacket_9Test extends TrainPacketTestBase {

	public static Stream<Arguments> data() {
		return Stream.of(
				Arguments.of("default", new Packet_9(), "[9:8][45:13][0:24]"),
				Arguments.of("NID_LTRBG: Min", new Packet_9(0), "[9:8][45:13][0:24]"),
				Arguments.of("NID_LTRBG: Max", new Packet_9(16777215), "[9:8][45:13][16777215:24]"),
				Arguments.of("all", new Packet_9(96932), "[9:8][45:13][96932:24]")
		);
	}

	public static Stream<Arguments> errors() {
		return Stream.of(
				Arguments.of("NID_LTRBG: Overflow", new Packet_9(16777216), new IllegalArgumentException("Invalid value for given bit length."))
		);
	}

}