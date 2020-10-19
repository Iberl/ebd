package ebd.szenario.util.server;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.Event;
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

/**
 * This GUIServer organises connecting GUI clients. It creates a {@link GUIClientWorker} for every client and maps them
 * depending on the greeting the clients provides.<br>
 * {@link GUIPipeDistribution} then uses this map to serve the clients with data.
 */
public class GUIServer implements Runnable {

    private EventBus globalBus;
    private Thread guiServerThread;
    private GUIPipeDistribution guiPipeDistribution = null;

    private ServerSocket serverSocket;
    private Map<String, Map<Integer,List<GUIClientWorker>>> clientMap;

    private boolean running = true;

    /**
     * Constructs the GUIServer and starts a thread of itself.
     * @throws IOException Should initialization of ServerSocket run into problems
     */
    public GUIServer() throws IOException {
        this.globalBus = EventBus.getDefault();
        this.globalBus.register(this);
        this.guiServerThread = new Thread(this);
        this.serverSocket = new ServerSocket(Integer.parseInt(ConfigHandler.getInstance().portOfGUIServer));
        setUpMap();
        guiServerThread.start();
    }

    public GUIServer(EventBus eBus, int iPort) throws Exception {
        this.globalBus = eBus;
        this.globalBus.register(this);
        this.guiServerThread = new Thread(this);
        this.serverSocket = new ServerSocket(iPort);
        setUpMap();
        guiServerThread.start();

    }


    /**
     * At first the server waits until a pipe to {@link ebd.logging.Logging} is established.
     * After that, it allows clients to connect.
     */
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
                String greeting = in.readLine(); //TODO Absichern
                addGUIClientWorkerToMap(greeting, client);

            } catch (IOException e) {
                e.printStackTrace(); //TODO Error Handeling
            }
        }
    }


    /**
     * Listens to a global disconnect event and terminates.
     * @param de {@link DisconnectEvent}
     */
    @Subscribe
    public void disconnect(DisconnectEvent de) throws IOException {
        this.running = false;
        this.guiPipeDistribution.stop();
        this.globalBus.unregister(this);
        this.serverSocket.close();
    }

    /**
     * Sets up the map
     */
    private void setUpMap() {
        this.clientMap = new HashMap<>();
        this.clientMap.put("sl", new HashMap<>());
        this.clientMap.put("tms", new HashMap<>());
        this.clientMap.put("rbc", new HashMap<>());
        this.clientMap.put("trn", new HashMap<>());
        this.clientMap.put("gb", new HashMap<>());
        this.clientMap.put("all", new HashMap<>());

        this.clientMap.get("tms").put(1, new ArrayList<>());
        this.clientMap.get("sl").put(1, new ArrayList<>());
        this.clientMap.get("gb").put(0, new ArrayList<>());
        this.clientMap.get("all").put(0, new ArrayList<>());
    }

    /**
     * Adds a client worker to {@link this.clientMap}
     * @param greeting The greeting string send by the client
     * @param client The socket representing the client
     * @throws IOException If there is a problem while writing to a client or closing the client.
     */
    private void addGUIClientWorkerToMap(String greeting, Socket client) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        if(!greeting.contains(";")){
            bw.write("The greeting has to be of the form 'entityName;entityID'. Could not connect");
            client.close();
            return;
        }
        String entityName = greeting.split(";")[0];

        int entityID;
        if(entityName.equals("all") || entityName.equals("gb")){//both "all" and "gb" only have one list on 0
            entityID = 0;
        }
        else {
            entityID = Integer.parseInt(greeting.split(";")[1].replaceAll("[^0-9]", ""));
        }

        if(this.clientMap.containsKey(entityName)){
            Map<Integer, List<GUIClientWorker>> innerMap = this.clientMap.get(entityName);
            if(innerMap.containsKey(entityID)){
                innerMap.get(entityID).add(new GUIClientWorker(client));
            }
            else {
                ArrayList<GUIClientWorker> innerList = new ArrayList<>();
                innerList.add(new GUIClientWorker(client));
                innerMap.put(entityID,innerList);
            }
        }
        else {
            bw.write("The greeting has to be of the form 'entityName;entityID' and the entityName has to be " +
                    "'trn', 'rbc', 'gb' or 'all'. Could not connect");
            client.close();
            IllegalArgumentException iae = new IllegalArgumentException("Entity name " + entityName + " not found");
            EventBus.getDefault().post(new ExceptionEvent("szenario", "szenario",
                    new NotCausedByAEvent(), iae, ExceptionEventTyp.WARNING));
        }
    }
}
