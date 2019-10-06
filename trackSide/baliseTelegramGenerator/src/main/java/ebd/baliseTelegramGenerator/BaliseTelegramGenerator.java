package ebd.baliseTelegramGenerator;

import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.messageSender.SendTelegramEvent;
import ebd.globalUtils.events.trainStatusMananger.PositionEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.message.Telegram;
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

	EventBus localbus;

	ListOfBalises listOfBalises;

	// trainID, lastknownPosition, lastsentPosition
	Map<String, Pair<Position, Integer>> positions = new HashMap<>();

	// Constructors

	public BaliseTelegramGenerator(EventBus localbus, ListOfBalises listOfBalises) {
		EventBus.getDefault().register(this);
		this.localbus = localbus;
		this.listOfBalises = listOfBalises;
	}


	// Methods

	private void sendTelegram(String trainId) {
		Position lastKnownPosition = positions.get(trainId).getKey();
		Integer lastSendingBalise = positions.get(trainId).getValue();
		BaliseGroup nextBG = listOfBalises.getBaliseGroup(listOfBalises.getConnectionsOf(lastSendingBalise).getValue());

		if(lastKnownPosition.getIncrement() >= nextBG.getLocation().getDistanceToPrevious()) {
			localbus.post(new SendTelegramEvent("btg1", Collections.singletonList("ms"), nextBG.generateTelegramFor(0), Collections.singletonList(trainId)));
			positions.put(trainId, new Pair<>(lastKnownPosition, nextBG.getNID_BG()));
		}
	}

	private void sendInitialTelegram(String trainId) {
		Telegram telegram = listOfBalises.getBaliseGroup(0).generateTelegramFor(0);
		localbus.post(new SendTelegramEvent("btg1", Collections.singletonList("ms"), telegram, Collections.singletonList(trainId)));
		positions.put(trainId, new Pair<>(positions.get(trainId).getKey(), 0));
	}

	@Subscribe(threadMode = ThreadMode.ASYNC)
	public void receivePosition(PositionEvent event) {
		String trainID = event.source.split(";T=")[1];
		String src = "mr;T=" + trainID;

		if((event.position.getLocation() instanceof InitalLocation)) {
			positions.put(src, new Pair<>(new Position(0, true, new Location(0, 0, 0d)), null));
			sendInitialTelegram(src);
		} else {
			positions.put(src, new Pair<>(event.position, positions.get(src).getValue()));
			sendTelegram(src);
		}
	}

	@Subscribe
	public void disconnect(DisconnectEvent event) { EventBus.getDefault().unregister(this); }

}
