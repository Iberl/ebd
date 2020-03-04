package ebd.szenario.util.server;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.logger.LogToGUIPipeEvent;
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
    private GUIPipeDistribution guiPipeDistribution = null;

    private ServerSocket serverSocket;
    private Map<String, Map<Integer,List<GUIClientWorker>>> clientMap;

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
        while (guiPipeDistribution == null){
            LogToGUIPipeEvent ltgpe = EventBus.getDefault().getStickyEvent(LogToGUIPipeEvent.class);
            if(ltgpe != null) {
                PipedInputStream pis = ltgpe.logPipedInputStream;
                this.guiPipeDistribution = new GUIPipeDistribution(pis, this.clientMap);
            }
        }
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


    /**
     *
     * @param de
     */
    @Subscribe
    public void disconnect(DisconnectEvent de){
        this.running = false;
        this.guiPipeDistribution.stop();
        this.globalBus.unregister(this);
    }

    /**
     * Sets up the map
     */
    private void setUpMap() {
        this.clientMap = new HashMap<>();
        this.clientMap.put("rbc", new HashMap<>());
        this.clientMap.put("tsm", new HashMap<>());
        this.clientMap.put("gb", new HashMap<>());
        this.clientMap.put("all", new HashMap<>());
    }

    /**
     * Adds a client worker to {@link this.clientMap}
     * @param greeting The greeting string send by the client
     * @param client The socket representing the client
     * @throws IOException
     */
    private void addGUIClientWorkerToMap(String greeting, Socket client) throws IOException {
        String entityName = greeting.split(";")[0];
        Integer entityID = Integer.parseInt(greeting.split(";")[1]);
        if(this.clientMap.containsKey(entityName)){
            Map<Integer, List<GUIClientWorker>> innerMap = this.clientMap.get(entityName);
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

    /**
     * Dummy to prevent warnings from {@link EventBus}
     */
    @Subscribe
    public void guiHandlerEvent(LogToGUIPipeEvent ghe){
    }
}
