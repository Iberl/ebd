package ebd.messageLibrary.packet;

import ebd.messageLibrary.serialization.BitStreamReader;
import ebd.messageLibrary.serialization.BitStreamWriter;
import ebd.messageLibrary.serialization.Serializer;
import ebd.messageLibrary.util.exception.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public abstract class TrackPacketTestBase {

	@ParameterizedTest(name = "{0}")
	@MethodSource("data")
	public void testData(String testname, Packet packet, String refData) {
		byte[] bitstream = BitStreamWriter.decode(refData).data();

		try {

			BitStreamWriter writer = Serializer.serialize(packet);

			System.err.println(Arrays.toString(bitstream));
			System.err.println(Arrays.toString(writer.data()));

			assertArrayEquals(bitstream, writer.data());

			BitStreamReader reader = new BitStreamReader(writer.data(), writer.size());

			Packet newPacket = Serializer.deserializePacket(reader, false);

			assertEquals(packet, newPacket);

		} catch(FieldTypeNotSupportedException | MissingInformationException | ValueNotSupportedException |
				ClassNotSupportedException | BitLengthOutOfBoundsException | NotSerializableException |
				ClassMalformedException | NotDeserializableException e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest(name = "{0}")
	@MethodSource("errors")
	public void testErrors(String testname, Packet packet, Exception exception) {
		if(exception == null) return;
		assertThrows(exception.getClass(), () -> Serializer.serialize(packet));
	}

}
