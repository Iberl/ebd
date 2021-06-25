package ebd.tmsDummy;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.tmsDummy.SendMessageToRBCEvent;
import ebd.internal.Message;
import ebd.internal.util.exception.MissingInformationException;
import ebd.tmsDummy.handler.TMSClientHandler;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ebd.tmsDummy.util.Utils.log;
import static ebd.tmsDummy.util.Utils.logDebug;

public class Communicator extends Thread {

    private final ConfigHandler config = Objects.requireNonNull(ConfigHandler.getInstance());

    private final String _ip            = config.ipToRBCServer;
    private final int    _rbcServerPort = config.portOfRBCServer;
    private final int    _tmsServerPort = config.portOfTMSServer;

    List<TMSClientHandler> clients = new ArrayList<>();

    ExecutorService threadPool = Executors.newCachedThreadPool();
    private boolean running =true;


    // Constructor

    public Communicator() {
        EventBus.getDefault().register(this);
    }

    public void run() {
        try {
            ServerSocket server = new ServerSocket(_tmsServerPort);

            while(this.running) {
                try {
                    Socket           client       = server.accept();
                    TMSClientHandler clientThread = new TMSClientHandler(client);
                    clients.add(clientThread);
                    threadPool.execute(clientThread);
                } catch(IOException e) {
                    log(e);
                    System.err.println("Could not establish connection with new client");
                    e.printStackTrace();
                }
            }
        } catch(IOException e) {
            System.err.println("TMS Communication Server could not be established on port " + _rbcServerPort);
            e.printStackTrace();
        }
    }

    public void kill(){
        this.running = false;
    }

    @Subscribe
    public void sendMessageToRBC(@NotNull SendMessageToRBCEvent event) {
        if(Objects.equals(event.target, "com")) send(event.message);
    }

    @SuppressWarnings("rawtypes")
    private void send(Message message) {
        try {
            Socket      socket      = new Socket(_ip, _rbcServerPort);
            PrintWriter output      = new PrintWriter(socket.getOutputStream(), true);
            String      messageJSON = message.parseToJson();
            output.println(messageJSON);

            logDebug("Sending: " + messageJSON);
            log("Sending message " + message.getHeader().type + " to RBC " + message.getHeader().tms_id);

            output.close();
            socket.close();
        } catch(IOException | MissingInformationException e) {
            e.printStackTrace();
        }
    }

}
