package ebd.baliseTelegramGenerator;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.messageReceiver.MessageReceiver;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class TestHandler {

	MessageReceiver mr;
	private EventBus localBus;

	public TestHandler(EventBus localBus){

		this.localBus = localBus;
		this.localBus.register(this);
		mr = new MessageReceiver(this.localBus, "test", "test2", true);
	}

	@Subscribe
	public void mr(ReceivedMessageEvent rme){
		System.out.println("tuut");
	}

	@Subscribe
	public void normalEvent(NormalEvent ne){
		if(ne instanceof ReceivedMessageEvent) return;
		System.out.println("Got " + ne.getClass().getSimpleName());
	}
}
