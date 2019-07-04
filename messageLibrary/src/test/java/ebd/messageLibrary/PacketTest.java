package ebd.messageLibrary;

import ebd.messageLibrary.packet.trackpackets.Packet_57;
import ebd.messageLibrary.serialization.BitStreamReader;
import ebd.messageLibrary.serialization.BitStreamWriter;
import ebd.messageLibrary.serialization.Serializer;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageLibrary.util.exception.*;

public class PacketTest {

	public static void main(String[] args) {

		// -----------
		// SENDER SIDE
		// -----------


		// Creating a new Packet_57 with full constructor
		Packet_57 packet = new Packet_57(ETCSVariables.Q_DIR_NOMINAL, 2, 3,4);

		System.out.println("The Packet:");
		System.out.println(packet.toString());

		// Create a new BitStreamWriter, which will hold the serialized information
		BitStreamWriter writer = new BitStreamWriter();

		try {
			// Serialize the created packet into the BitStreamWriter
			Serializer.serialize(packet, writer);

			// Handle all occurring Exceptions
		} catch (MissingInformationException e) {
			e.printStackTrace();
		} catch (FieldTypeNotSupportedException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("was serialized into:");
		System.out.println(writer.toString());


		// ------------
		// TRANSMISSION of the writer object
		// ------------


		// -------------
		// RECEIVER SIDE
		// -------------


		// Create a new Reader from the incoming information
		BitStreamReader reader = new BitStreamReader(writer.data(), writer.size());

		Object receivedPacket = null;

		try {
			// Deserialize the received BitStream into an JAVA objet
			receivedPacket = Serializer.deserialize(reader, false);

			// Handle all occurring Exceptions
		} catch (ClassNotSupportedException e) {
			e.printStackTrace();
		} catch (MissingInformationException e) {
			e.printStackTrace();
		} catch (BitLengthOutOfBoundsException e) {
			e.printStackTrace();
		} catch (ValueNotSupportedException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("The Packet:");
		System.out.println(receivedPacket.toString());
		System.out.println("was received");
	}


}
