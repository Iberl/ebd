package ebd.baliseTelegramGenerator;

import ebd.globalUtils.events.baliseTelegramGenerator.TriggerTelegramEvent;
import ebd.globalUtils.events.messageSender.SendTelegramEvent;
import ebd.messageLibrary.message.Telegram;
import ebd.messageSender.MessageSender;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

public class BaliseTelegramSender {

    // [ ] Create List of Telegrams
    // [x] Read List of Telegrams
    // [x] Manage List of Balises
    // => BTG

    // [x] Provide Trigger
    // [ ] Appropriate Error Events

    // Should BTG know the position of the Balise? - NO?
    // no group trigger - balises will be triggered seperately

    EventBus globalBus = EventBus.getDefault();

    private final MessageSender messageSender = new MessageSender(globalBus, "btg", false);

    private final Map<String, Telegram[]> telegramsByBalise;

    public BaliseTelegramSender(Map<String, Telegram[]> telegramsByBalise) {
        globalBus.register(this);
        this.telegramsByBalise = telegramsByBalise;
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    private void triggerTelegram(TriggerTelegramEvent e) {
        Telegram[] telegrams = telegramsByBalise.get(e.baliseId);
        for(Telegram telegram : telegrams) {
            messageSender.send(new SendTelegramEvent("btg", telegram, "mr;T=" + e.nid_operational));
        }
    }

    public Map<String, Telegram[]> getTelegramsByBalise() { return telegramsByBalise; }

    public void unregister() { globalBus.unregister(this); }

}
