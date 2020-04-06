package ebd.szenario.util.server;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.dmi.DMIUpdateEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DMIServer implements Runnable {

    private EventBus globalBus;
    private Thread dmiServerThread;

    private ServerSocket serverSocket;
    private Map<Integer, List<DMIClientWorker>> clientMap;

    private boolean running = true;

    public DMIServer() throws IOException {
        this.globalBus = EventBus.getDefault();
        this.globalBus.register(this);
        this.dmiServerThread = new Thread(this);
        this.serverSocket = new ServerSocket(Integer.parseInt(ConfigHandler.getInstance().dmiServerPort));
        this.clientMap = new HashMap<>();
        dmiServerThread.start();
    }

    /**
     * At first the server waits until a pipe to {@link ebd.logging.Logging} is established.
     * After that, it allows clients to connect.
     */
    @Override
    public void run() {
        while(this.running){
            try {
                Socket client = this.serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                int entityID = Integer.parseInt(in.readLine()); //TODO Absichern
                addDMIClientWorkerToMap(entityID, client);

            } catch (IOException e) {
                e.printStackTrace(); //TODO Error Handeling
            }
        }
    }

    private void addDMIClientWorkerToMap(int entityID, Socket client) throws IOException {
        if(this.clientMap.containsKey(entityID)){
            this.clientMap.get(entityID).add(new DMIClientWorker(client));
        }
        else {
            ArrayList<DMIClientWorker> innerList = new ArrayList<>();
            innerList.add(new DMIClientWorker(client));
            this.clientMap.put(entityID, innerList);
        }
    }

    @Subscribe
    public void send(DMIUpdateEvent dmiUpdateEvent) {
        String source = dmiUpdateEvent.source;
        String[] sourceComponents = source.split(";T=");
        int trainID = Integer.parseInt(sourceComponents[1]);
        if(this.clientMap.size() == 0 || this.clientMap.get(trainID) == null) return;
        //order as getter methods in DMIUpdateEvent
        String dmiParameters = dmiUpdateEvent.getCurrentSpeed() + " "
                + dmiUpdateEvent.getCurrentTargetSpeed() + " "
                + dmiUpdateEvent.getCurrentIndSpeed() + " "
                + dmiUpdateEvent.getCurrentPermSpeed() + " "
                + dmiUpdateEvent.getCurrentWarnSpeed() + " "
                + dmiUpdateEvent.getCurrentIntervSpeed() + " "
                + dmiUpdateEvent.getSpeedInterventionLevel() + " "
                + dmiUpdateEvent.getSpeedSupervisionState();

        for(DMIClientWorker dmiClientWorker : this.clientMap.get(trainID)) {
            dmiClientWorker.sendString(dmiParameters);
        }
    }
}
