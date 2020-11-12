package ebd.tmsDummy;

import ebd.rbc_tms.util.exception.MissingInformationException;
import ebd.tmsDummy.Communicator;
import ebd.tmsDummy.Parser;
import ebd.tmsDummy.command.ICommand;
import ebd.tmsDummy.handler.CommandHandler;
import ebd.tmsDummy.handler.ConfigHandler;
import ebd.tmsDummy.handler.WaitingHandler;
import ebd.globalUtils.events.tmsDummy.EndOfMissionEvent;
import ebd.globalUtils.events.tmsDummy.StopWaitingEvent;
import ebd.tmsDummy.util.exception.InvalidSequenceException;
import ebd.logging.Logging;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ebd.tmsDummy.util.Utils.log;

public class Szenario {

    private String                       filename;
    private Communicator communicator;
    private Map<String, Queue<ICommand>> sequences;

    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    public void run(String[] args) throws MissingInformationException, IOException, InvalidSequenceException {
        if(args.length <= 0) args = new String[]{ConfigHandler.getInstance().scenario};
        EventBus.getDefault().register(this);

        new Logging();
        communicator = new Communicator();
        communicator.start();

        filename = args[0];
        System.out.println("Loading Szenario " + filename);
        sequences = Parser.parse(filename);

        System.out.println("Welcome to the TMS Dummy");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if(scanner.next().equals("load")) { break; } else System.out.println("Could not understand input");
        }

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
                if(Objects.requireNonNull(ConfigHandler.getInstance()).shutdown) {
                    try {
                        log("TMS Dummy begins shutdown");
                        communicator.kill();
                        communicator.join();
                    } catch(InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    shutdown();
                }
            }
        }
    }


    private void shutdown() {
        log("Szenario " + filename + " ended");
        log("TMS Dummy was shut down");
        System.exit(0);
    }

}
