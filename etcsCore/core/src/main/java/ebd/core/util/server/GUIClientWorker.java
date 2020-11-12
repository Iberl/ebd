package ebd.core.util.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class manages socket connected to {@link GUIServer}
 */
public class GUIClientWorker implements Runnable{

    private Thread guiClientWorker;
    private Socket client;
    private PrintWriter out;

    /**
     * Constructs and starts a thread of itself.
     * @param client The client socket.
     * @throws IOException
     */
    public GUIClientWorker(Socket client) throws IOException {
        this.guiClientWorker = new Thread(this);
        this.client = client;
        this.out = new PrintWriter(client.getOutputStream(), true);
        this.guiClientWorker.start();
    }

    /**
     * Keeps thread from dying as long as the client is connected.
     */
    @Override
    public void run() {
        while(!this.client.isClosed()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Sends a string to the client
     * @param string String to send.
     */
    public void sendString(String string){
        if(!this.client.isClosed()) this.out.println(string);
    }
}
