package ebd.messageLibrary;

import ebd.messageLibrary.message.Telegram;
import ebd.messageLibrary.packet.trackpackets.Packet_0;
import ebd.messageLibrary.serialization.BitStreamReader;
import ebd.messageLibrary.serialization.BitStreamWriter;
import ebd.messageLibrary.serialization.Serializer;
import ebd.messageLibrary.util.exception.*;

public class TelegramTest {

	public static void main(String[] args) {

		// -----------
		// SENDER SIDE
		// -----------


		// Creating a new Telegram with full constructor
		Telegram telegram = new Telegram(true, 1, false, 1, 2, 3, 4, 5, 6, true);

		// Adding an optional Packet_0
		telegram.PACKET_0 = new Packet_0(4);

		System.out.println("The Telegram:");
		System.out.println(telegram.toString());

		// Create a new BitStreamWriter, which will hold the serialized information
		BitStreamWriter writer = new BitStreamWriter();

		try {
			// Serialize the created telegram into the BitStreamWriter
			Serializer.serialize(telegram, writer);

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

		Object receivedTelegram = null;

		try {
			// Deserialize the recieved BitStream into an JAVA objet
			receivedTelegram = Serializer.deserializeTelegram(reader);

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
		System.out.println("The Telegram:");
		System.out.println(receivedTelegram.toString());
		System.out.println("was received");
	}
}
