package ebd.szenario.util.server;

import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.szenario.util.events.SzenarioExceptionEvent;
import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.*;

public class GUIPipeDistribution implements Runnable {

    private Thread guiPDThread;
    private PipedInputStream pipedInputStream;
    private BufferedReader bufferedReader;
    private Map<String, Map<Integer, List<GUIClientWorker>>> clientMap;


    private boolean running = true;

    /**
     * Constructs an instance and starts a thread of itself.
     * @param pis Input pipe connected to a output pipe in {@link ebd.logging.Logging}
     * @param clientMap Map containing {@link GUIClientWorker} from {@link GUIServer}
     */
    public GUIPipeDistribution(PipedInputStream pis, Map<String, Map<Integer, List<GUIClientWorker>>> clientMap){
        this.pipedInputStream = pis;
        this.bufferedReader = new BufferedReader(new InputStreamReader(pipedInputStream));
        this.clientMap = clientMap;
        this.guiPDThread = new Thread(this);
        this.guiPDThread.start();
    }

    /**
     * Reads the wrapped piped input stream from {@link ebd.logging.Logging}
     */
    @Override
    public void run() {
        while(this.running){
            try {
                String line = this.bufferedReader.readLine();
                distribute(line);
            }
            catch (IOException e) {
                if(this.running){
                    SzenarioExceptionEvent see = new SzenarioExceptionEvent("szenario",
                            "szenario", new NotCausedByAEvent(), e, ExceptionEventTyp.WARNING);
                    EventBus.getDefault().post(see);
                    this.running = false;
                }
            }
        }
    }

    /**
     * Terminates the thread.
     */
    public void stop() {
        this.running = false;
    }

    /**
     * Parses the line and passes it to the right method
     * @param line Line read from input stream
     */
    private void distribute(String line) { //TODO More stable distribution that does not depend on formatting of the string
        String[] lineSplit = line.split(" ");

        if(lineSplit.length < 3) {
            lineSplit = Arrays.copyOf(lineSplit, 4);
            lineSplit[1] = "all";
            lineSplit[2] = "0";
        }
        else {
            handleSL(line, lineSplit[2]);
            lineSplit[1] = lineSplit[1].replaceAll("[^a-bA-Z]", "");
        }
        switch (lineSplit[1].toLowerCase()){
            case "rbc":
            case "trn":
                sendTo(line, lineSplit[1], Integer.parseInt(lineSplit[2].replaceAll("[^0-9]", "")));
                break;

            case "gb":
                sendToGB(line);
                break;
            default:
                sendToAll(line);
        }

    }

    private void handleSL(String line, String entity) {
        switch (entity.toLowerCase()) {
            case "sl":
                sendTo(line, "sl", 1);
                break;
            case "tms":
                sendTo(line, "tms", 1);
                break;
        }
    }

    /**
     * Sends a string to all client workers that map to name and id and to all {@link GUIClientWorker} mapped to 'all'.
     * @param line String to send on
     * @param entityName Map to send the string to.
     * @param entityID List of clientworker to send the string to.
     */
    private void sendTo(String line, String entityName, int entityID){
        entityName = entityName.toLowerCase();
        if(this.clientMap.get(entityName).containsKey(entityID)){
            for(GUIClientWorker gcw : this.clientMap.get(entityName).get(entityID)){
                gcw.sendString(line);
            }
        }
        sendToAll(line);
    }

    /**
     * Sends a String to all {@link GUIClientWorker} mapped to 'gb' and 'all'
     * @param line String to send on
     */
    private void sendToGB(String line){
        for(GUIClientWorker gcw : this.clientMap.get("gb").get(0)){
            gcw.sendString(line);
        }
        sendToAll(line);
    }

    /**
     * Sends a String to all {@link GUIClientWorker} mapped to 'all'
     * @param line String to send on
     */
    private void sendToAll(String line){
        for(GUIClientWorker gcw : this.clientMap.get("all").get(0)){
            gcw.sendString(line);
        }
    }
}
