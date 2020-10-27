package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacketTestBase;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import ebd.messageLibrary.util.ETCSVariables;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrainPacket_5Test extends TrainPacketTestBase {

	public static Stream<Arguments> data() {
		return Stream.of(
				Arguments.of("default", new Packet_5(), "[5:8][53:13][0:32]"),
				Arguments.of("NID_OPERATIONAL: Min", new Packet_5(ETCSVariables.NID_OPERATIONAL), "[5:8][53:13][0:32]"),
				Arguments.of("NID_OPERATIONAL: Max", new Packet_5(new BinaryCodedDecimal(4294967295L, 8)), "[5:8][53:13][4294967295:32]"),
				Arguments.of("all", new Packet_5(new BinaryCodedDecimal(7621412L, 8)), "[5:8][53:13][7621412:32]")
		);
	}

	public static Stream<Arguments> errors() {
		return Stream.of(
				Arguments.of("No Errors", new Packet_5(), null)
		);
	}

}