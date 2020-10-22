package ebd.core.util.server;

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

public class ATOServer implements Runnable {

    private final Thread atoServerThread;

    private final ServerSocket serverSocket;
    private ATOClientWorker clientWorker = null;

    private boolean running = true;

    public ATOServer() throws IOException {
        this.atoServerThread = new Thread(this);
        this.serverSocket = new ServerSocket(Integer.parseInt(ConfigHandler.getInstance().atoServerPort));
        this.atoServerThread.start();
    }

    /**
     * Accepts one incoming connection at a time.
     */
    @Override
    public void run() {
        while(this.running){
            try {
                Socket client = this.serverSocket.accept();
                if (clientWorker == null || !this.clientWorker.isAlive()){
                    this.clientWorker = new ATOClientWorker(client);
                }
                else if(!this.clientWorker.isConnected()){
                    this.clientWorker.stop();
                    this.clientWorker = new ATOClientWorker(client);
                }
                else {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace(); //TODO Error Handeling
            }
        }
        if(clientWorker != null && this.clientWorker.isAlive()){
            try {
                this.clientWorker.stop();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.running = false;
    }
}
