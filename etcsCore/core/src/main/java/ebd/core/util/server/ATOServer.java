package ebd.core.util.server;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.DisconnectEvent;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ATOServer implements Runnable {

    private final Thread atoServerThread;

    private final ServerSocket serverSocket;
    private ATOClientWorker clientWorker = null;

    private boolean running = true;

    public ATOServer() throws IOException {
        this.atoServerThread = new Thread(this);
        this.serverSocket = new ServerSocket(Integer.parseInt(ConfigHandler.getInstance().atoServerPort));

        Runtime.getRuntime().addShutdownHook(new Thread(this::stop));

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
                if(running) e.printStackTrace(); //We only care about exceptions that occur while the server should run
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
        try {
            this.running = false;
            this.serverSocket.close();
            if(this.clientWorker != null) this.clientWorker.stop();
        } catch (IOException ignored) {}
    }
}
