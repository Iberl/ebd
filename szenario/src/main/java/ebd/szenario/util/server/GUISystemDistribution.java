package ebd.szenario.util.server;

import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.szenario.util.events.SzenarioExceptionEvent;
import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GUISystemDistribution implements Runnable {

    private Thread guiSDThread;
    private PipedInputStream pipedInputStream;
    private BufferedReader bufferedReader;
    private Map<String, Map<Integer, List<GUIClientWorker>>> clientMap;
    private String entityName;
    private boolean running = true;

    public GUISystemDistribution(PipedInputStream pipedInputStream,
                                 Map<String, Map<Integer, List<GUIClientWorker>>> clientMap,
                                 String entityName){

        this.pipedInputStream = pipedInputStream;
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.pipedInputStream));
        this.clientMap = clientMap;
        this.entityName = entityName;
        if(entityName.equalsIgnoreCase("s.err") || entityName.equalsIgnoreCase("s.out")){
            this.guiSDThread = new Thread(this);
            this.guiSDThread.start();
        }
        else{
            throw new IllegalArgumentException("entityName has to be 's.err' or 's.out'");
        }
    }

    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        while(this.running){
            try {
                String line = bufferedReader.readLine(); //TODO may be dangerous if someone decides to write to system.out with print!
                distribute(line);
            }
            catch (IOException e) {
                this.running = false;
                SzenarioExceptionEvent see = new SzenarioExceptionEvent("szenario",
                        Collections.singletonList("szenario"), new NotCausedByAEvent(), e, ExceptionEventTyp.WARNING);
                EventBus.getDefault().post(see);
            }
        }
    }

    private void distribute(String line) {
        List<GUIClientWorker> list = this.clientMap.get(this.entityName).get(0);
        for(GUIClientWorker gw : list){
            gw.sendString(line);
        }
    }
}
