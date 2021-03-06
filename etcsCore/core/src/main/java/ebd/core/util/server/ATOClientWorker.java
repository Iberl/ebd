package ebd.core.util.server;

import ebd.globalUtils.configHandler.TrainsHandler;
import ebd.globalUtils.events.core.ATOEndEvent;
import ebd.globalUtils.events.core.ATOStartEvent;
import ebd.globalUtils.events.core.ATOToTrainUpdateEvent;
import ebd.globalUtils.events.core.TrainToAtoUpdateEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * This class manages socket connected to {@link GUIServer}
 */
public class ATOClientWorker implements Runnable{

    private final EventBus globalEventBus;
    private final Thread atoClientWorker;
    private final Socket client;
    private final PrintWriter out;
    private final BufferedReader in;

    private final TrainsHandler th = TrainsHandler.getInstance();
    private final List<String> connectedTrains;

    /**
     * Constructs and starts a thread of itself.
     * @param client The client socket.
     * @throws IOException
     */
    public ATOClientWorker(Socket client) throws IOException {
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
        this.client = client;
        this.out = new PrintWriter(client.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.connectedTrains = new ArrayList<String>();

        this.atoClientWorker = new Thread(this);
        this.atoClientWorker.start();
    }

    /**
     * Keeps thread from dying as long as the client is connected.
     */
    @Override
    public void run() {
        while(!this.client.isClosed()){
            try {
                String input = this.in.readLine();
                receiveString(input);
            } catch (IOException e) {
                if(!(e instanceof SocketException)) e.printStackTrace();
                break;
            }
        }
        for(String train : connectedTrains){
            String target = "dd;T=" + train;
            this.globalEventBus.post(new ATOEndEvent("core", target));
        }
    }

    /**
     * Sends information to ATO Control, without checking the validity of the string.
     * @param ttaue a {@link TrainToAtoUpdateEvent}
     */
    @Subscribe
    public void updateATO(TrainToAtoUpdateEvent ttaue){
        sendString(ttaue.information);
    }

    /**
     * see {@link Thread#isAlive()}
     * @return if {@link ATOClientWorker} is alive
     */
    public boolean isAlive(){
        return this.atoClientWorker.isAlive();
    }

    /**
     * Sends a string to the client
     * @param string String to send.
     */
    private synchronized void sendString(String string){
        if(!this.client.isClosed()) this.out.println(string);
    }

    /**
     * Sends a string to the train indicated in the string.
     * Format has to be: "id action [modifier]"
     * @param string String to send
     */
    private void receiveString(String string) {
        String[] split = string.split(" ");
        String etcsID = split[0];
        String target = "dd;T=" + etcsID;
        String action = split[1].toUpperCase(Locale.ROOT);
        switch (action){
            case "INIT" -> {
                this.connectedTrains.add(etcsID);
                this.globalEventBus.post(new ATOStartEvent("core", target));
            }
            case "TERM" -> {
                this.connectedTrains.remove(etcsID);
                this.globalEventBus.post(new ATOEndEvent("core", target));
            }
            case "EXIST" -> {
                boolean exists = !this.connectedTrains.contains(etcsID) && th.isRegistered(etcsID);
                sendString(etcsID + " exists=" + exists);
            }
            default -> this.globalEventBus.post(new ATOToTrainUpdateEvent("core", target, string));
        }
    }

    public boolean isConnected() {
        return this.client.isConnected() || this.client.isClosed() || this.out.checkError();
    }

    public void stop() throws IOException {
        this.client.close();
    }
}
