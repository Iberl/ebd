package ebd.core.util.handler;

import ebd.core.util.events.LoadEvent;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.trainStatusMananger.ContinueClockEvent;
import ebd.globalUtils.events.trainStatusMananger.PauseClockEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Scanner;

public class InputHandler implements Runnable {

    private final EventBus globalEventBus;
    private boolean shouldRun = true;

    private final Thread ihThread = new Thread(this);
    private final Scanner scanner;

    public InputHandler(){
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
        this.scanner = new Scanner(System.in);
        ihThread.start();
    }

    @Override
    public void run() {
        while(this.shouldRun && this.scanner.hasNext()){
            selectNext(this.scanner.next());
        }
    }

    private void selectNext(String next) {
        switch (next) {
            case "quit", "q", "end", "stop" -> this.globalEventBus.post(new DisconnectEvent("scenario", "all"));
            case "load" -> this.globalEventBus.post(new LoadEvent("scenario", "scenario"));
            case "pause" -> this.globalEventBus.post(new PauseClockEvent("scenario", "all"));
            case "continue" -> this.globalEventBus.post(new ContinueClockEvent("scenario", "all"));
            default -> System.out.println("Could not understand input");
        }
    }

    public void join(){
        try {
            this.ihThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reacts to a {@link DisconnectEvent} and stops the clock.
     * @param de a {@link DisconnectEvent}
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void disconnect(DisconnectEvent de){
        if(!validTarget(de.target)){
            return;
        }
        this.globalEventBus.unregister(this);
        this.shouldRun = false;
        this.scanner.close();
    }

    private boolean validTarget(String target) {

        if(target.contains("szenario") || target.contains("all")){
            return true;
        }
        return false;
    }
}
