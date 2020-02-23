package ebd.szenario.util;

import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.trainStatusMananger.ContinueClockEvent;
import ebd.globalUtils.events.trainStatusMananger.PauseClockEvent;
import ebd.szenario.util.events.LoadFourEvent;
import ebd.szenario.util.events.LoadEvent;
import ebd.szenario.util.events.LoadThreeEvent;
import ebd.szenario.util.events.LoadTwoEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputHandler implements Runnable {

    private EventBus globalEventBus;
    private boolean shouldRun = true;

    private Thread ihThread = new Thread(this);

    public InputHandler(){
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
        ihThread.start();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(shouldRun){
            selectNext(scanner.next());
        }
    }

    private void selectNext(String next) {
        switch (next){
            case "quit":
                this.globalEventBus.post(new DisconnectEvent("szenario", Collections.singletonList("all")));
                System.exit(0);
                break;
            case "load":
                this.globalEventBus.post(new LoadEvent("szenario", Collections.singletonList("szenario")));
                break;
            case "load2":
                this.globalEventBus.post(new LoadTwoEvent("szenario", Collections.singletonList("szenario")));
                break;
            case "load3":
                this.globalEventBus.post(new LoadThreeEvent("szenario", Collections.singletonList("szenario")));
                break;
            case "load4":
                this.globalEventBus.post(new LoadFourEvent("szenario", Collections.singletonList("szenario")));
                break;
            case "pause":
                this.globalEventBus.post(new PauseClockEvent("szenario", Collections.singletonList("all")));
                break;
            case "continue":
                this.globalEventBus.post(new ContinueClockEvent("szenario", Collections.singletonList("all")));
                break;
            default:
                System.out.println("Could not understand input");
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
    @Subscribe
    public void disconnect(DisconnectEvent de){
        if(!validTarget(de.targets)){
            return;
        }
        synchronized (this){
            this.notify();
        }
        globalEventBus.unregister(this);
        this.shouldRun = false;
    }

    private boolean validTarget(List<String> targetList) {
        for(String target : targetList){
            if(target.contains("szenario") || target.contains("all")){
                return true;
            }
        }
        return false;
    }
}
