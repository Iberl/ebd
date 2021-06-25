package ebd.tmsDummy;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.tmsDummy.EndOfMissionEvent;
import ebd.globalUtils.events.tmsDummy.StopWaitingEvent;
import ebd.globalUtils.events.tmsDummy.TMSDummyStartEvent;
import ebd.tmsDummy.command.ICommand;
import ebd.tmsDummy.handler.CommandHandler;
import ebd.tmsDummy.handler.WaitingHandler;
import ebd.tmsDummy.util.exception.InvalidSequenceException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ebd.tmsDummy.util.Utils.log;

public class TMSSzenario {

    private String                       filename = ConfigHandler.getInstance().nameOfScenarioFile;;
    private Communicator                 communicator;
    private Map<String, Queue<ICommand>> sequences;

    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    public TMSSzenario() {
        try {
            communicator = new Communicator();
            communicator.start();

            sequences = Parser.parse(filename);
            System.out.println("Loading Scenario " + filename);

            EventBus.getDefault().register(this);
        } catch(InvalidSequenceException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void start(TMSDummyStartEvent e){
        if(!Objects.equals(e.target, "tms")) return;
        threadPool.execute(new WaitingHandler());

        for(String trainId : sequences.keySet()) {
            threadPool.execute(new CommandHandler(trainId, sequences.get(trainId)));
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void endOfMission(EndOfMissionEvent e) {
        if(!Objects.equals(e.target, "tms")) return;
        if(sequences.containsKey(e.source)) {
            log("Finished sequence for trainId " + e.source);
            sequences.remove(e.source);
            if(sequences.isEmpty()) {
                EventBus.getDefault().post(new StopWaitingEvent());
            }
        }
    }

}
