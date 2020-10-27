package ebd.messageLibrary.packet;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class Packet_255Test extends TrainPacketTestBase {

	public static Stream<Arguments> data() {
		return Stream.of(
				Arguments.of("default", new Packet_255(), "[255:8]")
		);
	}

	public static Stream<Arguments> errors() {
		return Stream.of(Arguments.of("No Errors", new Packet_255(), null));
	}

}