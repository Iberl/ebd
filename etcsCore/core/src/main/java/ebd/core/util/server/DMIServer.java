package ebd.core.util.server;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.dmi.DMISpeedUpdateEvent;
import ebd.globalUtils.events.dmi.DMIUpdateEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
                int entityID = Integer.parseInt(in.readLine());
                addDMIClientWorkerToMap(entityID, client);

            } catch (IOException e) {
                if(this.running) e.printStackTrace();
            }
        }
    }

    @Subscribe
    public void send(DMISpeedUpdateEvent dmiSpeedUpdateEvent) {
        String source = dmiSpeedUpdateEvent.source;
        String[] sourceComponents = source.split(";T=");
        int entityID = Integer.parseInt(sourceComponents[1]);
        if(this.clientMap.size() == 0 || this.clientMap.get(entityID) == null) return;
        //order as getter methods in DMISpeedUpdateEvent
        String dmiParameters = dmiSpeedUpdateEvent.getCurrentSpeed() + " "
                + dmiSpeedUpdateEvent.getCurrentTargetSpeed() + " "
                + dmiSpeedUpdateEvent.getCurrentReleaseSpeed() + " "
                + dmiSpeedUpdateEvent.getCurrentIndSpeed() + " "
                + dmiSpeedUpdateEvent.getCurrentPermSpeed() + " "
                + dmiSpeedUpdateEvent.getCurrentWarnSpeed() + " "
                + dmiSpeedUpdateEvent.getCurrentIntervSpeed() + " "
                + dmiSpeedUpdateEvent.getSpeedInterventionLevel() + " "
                + dmiSpeedUpdateEvent.getSpeedSupervisionState() + " "
                + dmiSpeedUpdateEvent.getTripDistance();
        for(DMIClientWorker dmiClientWorker : this.clientMap.get(entityID)) {
            dmiClientWorker.sendString(dmiParameters);
        }
    }

    @Subscribe
    public void send(DMIUpdateEvent dmiUpdateEvent){
        String source = dmiUpdateEvent.source;
        String[] sourceComponents = source.split(";T=");
        int entityID = Integer.parseInt(sourceComponents[1]);
        if(this.clientMap.size() == 0 || this.clientMap.get(entityID) == null) return;

        for(DMIClientWorker dmiClientWorker : this.clientMap.get(entityID)){
            dmiClientWorker.sendString(dmiUpdateEvent.dmiUpdateString);
            //dmiClientWorker.sendString("gp 0.0,0.0;100.0,-5.0;300,2.0;1000,0.0;1500,1.0;4000,-3.0");
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void disconnect(DisconnectEvent de){
        try {
            this.globalBus.unregister(this);
            this.running = false;
            this.serverSocket.close();
        } catch (IOException ignored) {} //We are closing down and do not care about exceptions at this state
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
}
