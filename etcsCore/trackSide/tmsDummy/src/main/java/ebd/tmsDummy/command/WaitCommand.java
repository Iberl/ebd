package ebd.tmsDummy.command;

import ebd.globalUtils.events.tmsDummy.NextCommandEvent;
import ebd.globalUtils.events.tmsDummy.StartWaitingEvent;
import ebd.globalUtils.events.tmsDummy.StepEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import static ebd.tmsDummy.util.Utils.log;

public class WaitCommand implements ebd.tmsDummy.command.ICommand {

    EventBus eventBus = EventBus.getDefault();
    private String trainId;

    public WaitCommand() {
        eventBus.register(this);
    }

    public void visit(String trainId) {
        this.trainId = trainId;
        log(trainId + ": Waits on User Input");
        eventBus.post(new StartWaitingEvent(trainId));
        /*
        synchronized(this){
            try {
                this.wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

    @Subscribe
    public void step(StepEvent e) {
        if(!e.target.equals(trainId)) return;
        log(trainId + ": Continuing with next Command");
        eventBus.post(new NextCommandEvent(trainId));
        eventBus.unregister(this);
        /*synchronized(this){
            this.notify();
        }*/
    }
}
