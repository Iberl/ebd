package ebd.szenario.util.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.List;
import java.util.Map;

public class GUIPipeDistribution implements Runnable {

    private Thread guiPDThread;
    private PipedInputStream pipedInputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private Map<String, Map<Integer, List<GUIClientWorker>>> clientMap;


    private boolean running = true;

    public GUIPipeDistribution(PipedInputStream pis, Map<String, Map<Integer, List<GUIClientWorker>>> clientMap){
        this.pipedInputStream = pis;
        this.inputStreamReader = new InputStreamReader(pipedInputStream);
        this.bufferedReader = new BufferedReader(new InputStreamReader(pipedInputStream));
        this.clientMap = clientMap;
        this.guiPDThread = new Thread(this);
        this.guiPDThread.start();
    }

    @Override
    public void run() {
        while(this.running ){
            try {
                //System.out.println(pipedInputStream.available());
                //System.out.println(pipedInputStream.read());
                //System.out.println(inputStreamReader.read());
                String line = bufferedReader.readLine();
                System.out.println(line);
                //distribute(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void distribute(String line) {
        System.out.println(line);
        String[] lineSplit = line.split(" ");
        /*for (String s : lineSplit){
            System.out.println("Split: " + s);
        }
*/

    }

    public void stop() {
        this.running = false;
    }
}
