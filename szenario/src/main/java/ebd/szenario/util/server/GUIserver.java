package ebd.szenario.util.server;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.DisconnectEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class GUIserver implements Runnable {

    private EventBus globalBus;
    private Thread guiServerThread;

    private ServerSocket serverSocket;
    private BufferedReader in;
    private PrintWriter out;
    //private List<Socket> clientList;
    private Socket client;

    private boolean running = true;

    public GUIserver() throws IOException {
        this.globalBus = EventBus.getDefault();
        this.globalBus.register(this);
        this.guiServerThread = new Thread(this);
        listenSocket();
        guiServerThread.start();
    }

    @Override
    public void run() {
        while(running){
        }
    }

    @Subscribe
    public void disconnect(DisconnectEvent de){
        this.running = false;
        this.globalBus.unregister(this);
    }

    private void listenSocket() throws IOException {
        this.serverSocket = new ServerSocket(Integer.parseInt(ConfigHandler.getInstance().portOfGUIServer));
        this.client = serverSocket.accept();
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.out = new PrintWriter(client.getOutputStream());
    }
}
