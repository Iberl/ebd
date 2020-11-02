package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacketTestBase;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrainPacket_3Test extends TrainPacketTestBase {

	public static Stream<Arguments> data() {
		return Stream.of(
				Arguments.of("default", new Packet_3(), "[3:8][26:13][0:5]"),

				Arguments.of("numbers: Empty", new Packet_3(), "[3:8][26:13][0:5]"),
				Arguments.of("numbers: 1 Element", fill(new Packet_3(), new Packet_3.Packet_3_Number(), 1), "[3:8][90:13][1:5]{[0:64]*1}"),
				Arguments.of("numbers: NID_RADIO: Min", fill(new Packet_3(), new Packet_3.Packet_3_Number(new BinaryCodedDecimal(0L, 16)), 1), "[3:8][90:13][1:5]{[0:64]*1}"),
				Arguments.of("numbers: NID_RADIO: Max", fill(new Packet_3(), new Packet_3.Packet_3_Number(new BinaryCodedDecimal(-1L)), 1), "[3:8][90:13][1:5]{[-1:64]*1}"),
				Arguments.of("numbers: 1+ Element", fill(new Packet_3(), new Packet_3.Packet_3_Number(new BinaryCodedDecimal(2L, 16)), 2), "[3:8][154:13][2:5]{[2:64]*2}"),
				Arguments.of("numbers: Max Element", fill(new Packet_3(), new Packet_3.Packet_3_Number(new BinaryCodedDecimal(45L, 16)), 31), "[3:8][2010:13][31:5]{[45:64]*31}"),

				Arguments.of("all", fill(new Packet_3(), new Packet_3.Packet_3_Number(new BinaryCodedDecimal(26421934L, 16)), 5), "[3:8][346:13][5:5]{[26421934:64]*5}")
		);
	}

	public static Stream<Arguments> errors() {
		return Stream.of(
				Arguments.of("No Error Tests", new Packet_3(), null)
				// numbers: NID_RADIO is in BCD format -> no overflow test needed
		);
	}


	public static Packet_3 fill(Packet_3 packet_3, Packet_3.Packet_3_Number number, int count) {
		assert(count < 32);
		for(int i = 0; i < count; i++) {
			packet_3.numbers.add(number);
		}
		return packet_3;
	}

}