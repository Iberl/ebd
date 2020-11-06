package ebd.core.util.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class manages socket connected to {@link GUIServer}
 */
public class DMIClientWorker implements Runnable{

    private final Thread dmiClientWorker;
    private final Socket client;
    private final PrintWriter out;

    /**
     * Constructs and starts a thread of itself.
     * @param client The client socket.
     * @throws IOException
     */
    public DMIClientWorker(Socket client) throws IOException {
        this.dmiClientWorker = new Thread(this);
        this.client = client;
        this.out = new PrintWriter(client.getOutputStream(), true);
        this.dmiClientWorker.start();
    }

    /**
     * Keeps thread from dying as long as the client is connected.
     */
    @Override
    public void run() {
        while(!this.client.isClosed()){
            try {
                synchronized (this.dmiClientWorker){
                    this.dmiClientWorker.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Sends a string to the client
     * @param string String to send.
     */
    public synchronized void sendString(String string){
        if(!this.client.isClosed()) this.out.println(string);
    }
}
