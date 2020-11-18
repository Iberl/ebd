package ebd.core.util.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class manages socket connected to {@link GUIServer}
 */
public class GUIClientWorker{


    private final Socket client;
    private final PrintWriter out;

    /**
     * Constructs and starts a thread of itself.
     * @param client The client socket.
     */
    public GUIClientWorker(Socket client) throws IOException {
        this.client = client;
        this.out = new PrintWriter(client.getOutputStream(), true);

    }

    /**
     * Sends a string to the client
     * @param string String to send.
     */
    public void sendString(String string){
        if(!this.client.isClosed()) this.out.println(string);
    }
}
