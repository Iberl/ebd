package ebd.messageLibrary;

public class TestSuite {

	public static void main(String[] args) {

		System.out.println("Testing Packets:");
		System.out.println("----------------");
		System.out.println();

		PacketTest.main(args);


		System.out.println();
		System.out.println("Testing Messages:");
		System.out.println("-----------------");
		System.out.println();

		MessageTest.main(args);

		System.out.println();
		System.out.println("Testing Telegrams:");
		System.out.println("------------------");
		System.out.println();

		TelegramTest.main(args);

	}
}