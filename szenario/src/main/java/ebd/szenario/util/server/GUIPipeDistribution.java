package ebd.szenario.util.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.List;
import java.util.Map;

public class GUIPipeDistribution implements Runnable {

    private PipedInputStream pipedInputStream;
    private BufferedReader bufferedReader;
    private Map<String, Map<Integer, List<GUIClientWorker>>> clientMap;
    private boolean running = true;

    public GUIPipeDistribution(PipedInputStream pis, Map<String, Map<Integer, List<GUIClientWorker>>> clientMap){
        this.pipedInputStream = pis;
        this.bufferedReader = new BufferedReader(new InputStreamReader(pipedInputStream));
        this.clientMap = clientMap;
    }

    @Override
    public void run() {
        while(this.running){
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
        for (String s : lineSplit){
            System.out.println("Split: " + s);
        }


    }

    public void stop() {
        this.running = false;
    }
}
