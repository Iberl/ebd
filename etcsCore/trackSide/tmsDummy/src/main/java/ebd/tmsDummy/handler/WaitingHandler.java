package ebd.tmsDummy.handler;

import ebd.globalUtils.events.tmsDummy.StartWaitingEvent;
import ebd.globalUtils.events.tmsDummy.StepEvent;
import ebd.globalUtils.events.tmsDummy.StopWaitingEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WaitingHandler implements Runnable {

    private EventBus eventBus = EventBus.getDefault();
    private Scanner  scanner  = new Scanner(System.in);

    private final List<String> trainIds = new LinkedList<>();
    private boolean running = true;

    public WaitingHandler() {
        eventBus.register(this);
    }

    @Override
    public void run() {
        while(running) {
            while(!trainIds.isEmpty()) {
                boolean found = false;
                String line = scanner.nextLine();
                for(String trainId : trainIds) {
                    if(line.equals(trainId)) {
                        eventBus.post(new StepEvent(trainId));
                        trainIds.remove(trainId);
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    System.out.println("The given trainId (" + line + ") is not waiting for input");
                    printAvailableBreakpoints();
                }
            }
        }
    }

    @Subscribe
    public void startWaiting(StartWaitingEvent e) {
        if(!e.target.equals("tms")) return;
        synchronized(trainIds) {
            trainIds.add(e.source);
            printAvailableBreakpoints();
        }
    }

    @Subscribe
    public void stopWaiting(StopWaitingEvent e) {
        running = false;
    }

    private void printAvailableBreakpoints() {
        System.out.println("Currently waiting trains: " + trainIds.toString());
    }

}
