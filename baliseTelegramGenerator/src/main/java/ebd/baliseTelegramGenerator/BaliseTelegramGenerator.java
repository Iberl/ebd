package ebd.baliseTelegramGenerator;

import ebd.globalUtils.events.messageSender.SendTelegramEvent;
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
	// x Handles EventBus, MR and MS

	EventBus localbus = new EventBus();

	MessageSender ms = new MessageSender(localbus, "btg1", false);

	ListOfBalises listOfBalises;

	// trainID, lastknownPosition, lastsentPosition
	Map<String, Pair<Position, Integer>> positions = new HashMap<>();

	// Constructors


	public BaliseTelegramGenerator(ListOfBalises listOfBalises) {
		EventBus.getDefault().register(this);
		this.listOfBalises = listOfBalises;
	}


	// Methods

	private void sendTelegram(String trainId) {
		Position lastKnownPosition = positions.get(trainId).getKey();
		Integer lastSendingBalise = positions.get(trainId).getValue();
		BaliseGroup[] bgs = (BaliseGroup[]) listOfBalises.getBaliseGroups().stream()
				.filter(bg -> bg.getLocation().getIdOfPrevious().equals(lastKnownPosition.getLocation().getId()))
				.filter(bg -> bg.getLocation().getDistanceToPrevious() >= lastKnownPosition.getIncrement()).toArray();

		assert(bgs.length <= 1);
		if(bgs.length == 1) ms.send(new SendTelegramEvent("btg1", Collections.singletonList("mr;btg1"), bgs[0].generateTelegramFor(0), Collections.singletonList(trainId)));
	}

	@Subscribe(threadMode = ThreadMode.ASYNC)
	public void receivePosition(PositionEvent event) {
		String src = event.source;

		Pair<Position, Integer> pair = positions.keySet().contains(src) ? positions.get(src) : new Pair(event.position, ETCSVariables.NID_BG);
		positions.put(src, pair);

		sendTelegram(src);
	}

	@Subscribe
	public void disconnect(DisconnectEvent event) { EventBus.getDefault().unregister(this); }

}
