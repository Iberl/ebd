package ebd.tmsDummy.handler;

import ebd.globalUtils.events.tmsDummy.NextCommandEvent;
import ebd.tmsDummy.command.ICommand;
import ebd.globalUtils.events.tmsDummy.EndOfMissionEvent;
import ebd.globalUtils.events.tmsDummy.NextCommandEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Objects;
import java.util.Queue;

public class CommandHandler implements Runnable {

    private EventBus eventBus = EventBus.getDefault();
    private String trainId;
    private Queue<ICommand> commands;
    private boolean containsEndCommand;

    public CommandHandler(String trainId, Queue<ICommand> commands) {
        this.trainId = trainId;
        this.commands = commands;
        eventBus.register(this);
    }

    @Override
    public void run() {
        next();
    }

    @Subscribe
    public void next(NextCommandEvent e) {
        if(!Objects.equals(e.target, trainId)) return;
        next();
    }

    private void next() {
        if(commands.isEmpty()) {
            eventBus.post(new EndOfMissionEvent(trainId));
            return;
        }
        ICommand command = commands.poll();
        command.visit(trainId);
    }

}
