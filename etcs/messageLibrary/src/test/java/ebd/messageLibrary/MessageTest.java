package ebd.messageLibrary;

import ebd.messageLibrary.message.trackmessages.Message_2;
import ebd.messageLibrary.packet.trainpackets.Packet_4;
import ebd.messageLibrary.serialization.BitStreamReader;
import ebd.messageLibrary.serialization.BitStreamWriter;
import ebd.messageLibrary.serialization.Serializer;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageLibrary.util.exception.*;

public class MessageTest {

	public static void main(String[] args) {

		// -----------
		// SENDER SIDE
		// -----------


		// Creating a new Message_2 with full constructor
		Message_2 message = new Message_2(1, true, 3, 4, 5);

		// Adding an optional Packet_4
		message.packets.add(new Packet_4(ETCSVariables.M_ERROR_SAFE_CONNECTION));

		System.out.println("The Message:");
		System.out.println(message.toString());

		// Create a new BitStreamWriter, which will hold the serialized information
		BitStreamWriter writer = new BitStreamWriter();

		try {
			// Serialize the created message into the BitStreamWriter
			Serializer.serialize(message, writer);

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

		Object receivedMessage = null;

		try {
			// Deserialize the recieved BitStream into an JAVA objet
			receivedMessage = Serializer.deserialize(reader, false);

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
		System.out.println("The Message:");
		System.out.println(receivedMessage.toString());
		System.out.println("was received");
	}


}
