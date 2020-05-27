package ebd.baliseTelegramGenerator;

import ebd.globalUtils.events.trainStatusMananger.PositionEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.Packet_0;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import static ebd.messageLibrary.util.ETCSVariables.*;

import java.util.Arrays;

class BaliseTelegramGeneratorTest {

	@Test
	void receivePosition() throws InterruptedException {
		EventBus localBus = new EventBus();
		TestHandler th = new TestHandler(localBus);
		ListOfBalises lob = new ListOfBalises(1, 12);
		lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 0, 0, 0, false, null));
		lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 1, 0, 500, false, null));
		lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 2, 1, 500, false, null));
		lob.getBaliseGroup(2).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));
		BaliseTelegramGenerator btg = new BaliseTelegramGenerator(localBus, lob);

		// TODO trainID
		EventBus.getDefault().post(new PositionEvent("mr;T=test", "btg", new Position(500d, true, new Location(1, 0, 10d))));
		System.out.println("Position Event sent");
		Thread.sleep(5000);
	}
}