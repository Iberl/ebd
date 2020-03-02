package ebd.szenario.util.server;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class GUIserver implements Runnable {

    private EventBus globalBus;
    private Thread guiServerThread;

    private ServerSocket serverSocket;
    private Map<String, Map<Integer,List<GUIClientWorker>>> map;

    private boolean running = true;

    public GUIserver() throws IOException {
        this.globalBus = EventBus.getDefault();
        this.globalBus.register(this);
        this.guiServerThread = new Thread(this);
        this.serverSocket = new ServerSocket(Integer.parseInt(ConfigHandler.getInstance().portOfGUIServer));
        setUpMap();
        guiServerThread.start();
    }



    @Override
    public void run() {
        while(running){
            try {
                Socket client = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String greeting = in.readLine();
                addGUIClientWorkerToMap(greeting, client);

            } catch (IOException e) {
                e.printStackTrace(); //TODO Error Handeling
            }
        }
    }



    @Subscribe
    public void disconnect(DisconnectEvent de){
        this.running = false;
        this.globalBus.unregister(this);
    }

    private void setUpMap() {
        this.map = new HashMap<>();
        this.map.put("rbc", new HashMap<>());
        this.map.put("tsm", new HashMap<>());
        this.map.put("gb", new HashMap<>());
        this.map.put("all", new HashMap<>());
    }

    private void addGUIClientWorkerToMap(String greeting, Socket client) throws IOException {
        String entityName = greeting.split(";")[0];
        Integer entityID = Integer.parseInt(greeting.split(";")[1]);
        if(this.map.containsKey(entityName)){
            Map<Integer, List<GUIClientWorker>> innerMap = this.map.get(entityName);
            if(innerMap.containsKey(entityID)){
                List<GUIClientWorker> innerList = innerMap.get(entityID);
                innerList.add(new GUIClientWorker(client));
            }
            else {
                ArrayList<GUIClientWorker> innerList = new ArrayList<>();
                innerList.add(new GUIClientWorker(client));
                innerMap.put(entityID,innerList);
            }
        }
        else {
            IllegalArgumentException iae = new IllegalArgumentException("Entity name " + entityName + " not found");
            EventBus.getDefault().post(new ExceptionEvent("szenario", Collections.singletonList("szenario"),
                    new NotCausedByAEvent(), iae, ExceptionEventTyp.WARNING));
        }
    }
}
