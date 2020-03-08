package ebd.szenario.util.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GUIPipeDistribution implements Runnable {

    private Thread guiPDThread;
    private PipedInputStream pipedInputStream;
    private BufferedReader bufferedReader;
    private Map<String, Map<Integer, List<GUIClientWorker>>> clientMap;


    private boolean running = true;

    public GUIPipeDistribution(PipedInputStream pis, Map<String, Map<Integer, List<GUIClientWorker>>> clientMap){
        this.pipedInputStream = pis;
        this.bufferedReader = new BufferedReader(new InputStreamReader(pipedInputStream));
        this.clientMap = clientMap;
        this.guiPDThread = new Thread(this);
        this.guiPDThread.start();
    }

    @Override
    public void run() {
        while(this.running ){
            try {
                String line = bufferedReader.readLine();
                distribute(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void distribute(String line) {
        String[] lineSplit = line.split(" ");
        if(lineSplit.length < 3) {
            lineSplit = Arrays.copyOf(lineSplit, 4);
            lineSplit[2] = "all";
        }
        switch (lineSplit[2].toLowerCase()){
            case "rbc":
            case "trn":
                sendTo(line, lineSplit[2], lineSplit[3]);
                break;
            case "gb":
                sendToGB(line);
                break;
            default:
                sendToAll(line);
        }

    }

    private void sendTo(String line, String name, String id){
        int entityID = Integer.parseInt(id.replaceAll("[^0-9]", ""));
        String entityName = name.toLowerCase();
        if(this.clientMap.get(entityName).containsKey(entityID)){
            for(GUIClientWorker gcw : this.clientMap.get(entityName).get(entityID)){
                gcw.sendString(line);
            }
        }
        sendToAll(line);
    }

    private void sendToGB(String line){
        for(GUIClientWorker gcw : this.clientMap.get("gb").get(0)){
            gcw.sendString(line);
        }
        sendToAll(line);
    }

    private void sendToAll(String line){
        for(GUIClientWorker gcw : this.clientMap.get("all").get(0)){
            gcw.sendString(line);
        }
    }

    public void stop() {
        this.running = false;
    }
}
