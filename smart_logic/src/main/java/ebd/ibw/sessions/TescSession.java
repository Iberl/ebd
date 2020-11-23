package ebd.ibw.sessions;

import de.disposim.dbd.example.client.ExampleSession;
import de.disposim.dbd.example.client.Subscription;
import de.disposim.dbd.io.ClientSession;
import de.disposim.dbd.io.SessionClosedException;
import de.disposim.dbd.io.StreamClosedException;
import de.disposim.dbd.packet.IllegalNameLengthException;
import de.disposim.dbd.packetlistener.UpdateHandler;
import ebd.TescModul;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

public class TescSession extends Thread {

    private static final Logger log = LoggerFactory.getLogger(ExampleSession.class);
    private final ClientSession cl;
    private Vector<UpdateListener> updateListeners = new Vector();


    public TescSession(Socket server) throws UnknownHostException, IOException {
        this.cl = new ClientSession(server, new UpdateHandler() {
            public void onUpdate(String name, int value) {
                TescSession.this.updateListeners.forEach((l) -> {
                    l.onUpdate(name, value);
                });
            }
        });
        this.updateListeners.add(new UpdateListener() {
            public void onUpdate(String name, int value) {
                System.out.println("Listener done: " + name + " " + value);
                TescModul.getInstance().putNewState(name, value);

            }
        });
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.listen();
            }
        } catch (IOException | StreamClosedException e) {
            e.printStackTrace();
        }
    }


    public void query(String name) throws InterruptedException, ExecutionException, IOException, SessionClosedException, IllegalNameLengthException {
        this.cl.sendQuery(name);
    }

    public Subscription subscribe(String name) throws InterruptedException, ExecutionException, IOException, SessionClosedException, IllegalNameLengthException {
        this.cl.sendSubscribe(name);
        return new Subscription(name, 0);
    }

    public void set(String name, int value) throws IOException, SessionClosedException, IllegalNameLengthException {
        this.cl.sendSet(name, value);
    }

    public void listen() throws IOException, StreamClosedException {
        this.cl.listen();
    }

    public void close() {
        this.cl.close();
    }

    public void endsession() throws IOException, SessionClosedException {
        this.cl.sendEndSession();
    }

    interface UpdateListener {
        void onUpdate(String name, int value);
    }

}
