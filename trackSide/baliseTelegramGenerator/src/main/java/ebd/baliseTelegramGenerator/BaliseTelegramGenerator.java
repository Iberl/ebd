package ebd.baliseTelegramGenerator;

import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.messageSender.SendTelegramEvent;
import ebd.globalUtils.events.trainStatusMananger.PositionEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import javafx.util.Pair;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.*;

public class BaliseTelegramGenerator {

	// x Checks Position of Trains
	// x Manages List Of Trains (one Train)
	// x Sends Telegram if Balise (BaliseGroup) is driven over
	// x Handles EventBus and MS

	MessageSender ms = new MessageSender(new EventBus(), "btg1", false);

	ListOfBalises listOfBalises;

	// trainID, lastknownPosition, lastsentPosition
	Map<String, Pair<Position, Integer>> positions = new HashMap<>();

	// Constructors


	// TODO RBC ID
	public BaliseTelegramGenerator(ListOfBalises listOfBalises) {
		EventBus.getDefault().register(this);
		this.listOfBalises = listOfBalises;
	}


	// Methods

	private void sendTelegram(String trainId) {
		Position lastKnownPosition = positions.get(trainId).getKey();
		Integer lastSendingBalise = positions.get(trainId).getValue();
		Object[] bgs = listOfBalises.getBaliseGroups().stream()
				.filter(bg -> bg.getLocation().getIdOfPrevious().equals(lastKnownPosition.getLocation().getId()))
				.filter(bg -> bg.getLocation().getDistanceToPrevious() >= lastKnownPosition.getIncrement()).toArray();

		assert(bgs.length <= 1);
		if(bgs.length == 1) {
			ms.send(new SendTelegramEvent("btg1", Collections.singletonList("ms"), ((BaliseGroup) bgs[0]).generateTelegramFor(0), Collections.singletonList(trainId)));
			System.out.println("Send Telegram Event sent");
		} else System.out.println("nothing to send");
	}

	@Subscribe(threadMode = ThreadMode.ASYNC)
	public void receivePosition(PositionEvent event) {
		System.out.println("Position Event received " + event);
		String src = event.source;

		if(!(event.position.getLocation() instanceof InitalLocation)) {
			Pair<Position, Integer> pair = positions.keySet().contains(src) ? positions.get(src) : new Pair(event.position, ETCSVariables.NID_BG);
			positions.put(src, pair);

			sendTelegram(src);
		}
	}

	@Subscribe
	public void disconnect(DisconnectEvent event) { EventBus.getDefault().unregister(this); }

}
