package ebd.radioBlockCenter;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.logger.ToLogDebugEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.radioBlockCenter.ReceivedTMSMessageEvent;
import ebd.globalUtils.events.radioBlockCenter.SendTMSMessageEvent;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.messageLibrary.message.trackmessages.Message_2;
import ebd.radioBlockCenter.util.Constants;
import ebd.radioBlockCenter.util.RBCModule;
import ebd.rbc_tms.Message;
import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.exception.MissingInformationException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TMSCommunicator extends Thread {

    private class TMSServer extends Thread {

        public void run() {

        }

    }

    private class TMSClientHandler implements Runnable {

        private Socket         client;
        private BufferedReader in;
        private PrintWriter    out;

        public TMSClientHandler(Socket clientSocket) throws IOException {
            this.client = clientSocket;
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                while(true) {
                    StringBuilder data = new StringBuilder();
                    // TODO SocketException
                    data.append(in.readLine());
                    logDebug("RBC received: " + data.toString());

                    try {
                        // Generate Message
                        Message<Payload> message = Message.generateFrom(data.toString());
                        log("Received Message " + message.getHeader().type + " from " + message.getHeader().tms_id);
                        _localBus.post(new ReceivedTMSMessageEvent(_moduleID, _tmsEndpointID, message));
                    } catch(ClassNotFoundException e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                        in.close();
                        client.close();
                    }
                    // TODO Timeout?
                }
            } catch(IOException e) {
                System.err.println("Problem occurred while reading input stream.");
                e.printStackTrace();
            } finally {
                out.close();
                try {
                    in.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private ConfigHandler config = ConfigHandler.getInstance();
    private EventBus _localBus;

    private final String _moduleID      = Constants.ID_TMS_COMMUNICATOR;
    private final String _tmsEndpointID = Constants.ID_TMS_ENDPOINT;

    private final String _ip            = config.ipToTMSServer;
    private final int    _tmsServerPort = config.portOfTMSServer;
    private final int    _rbcServerPort = config.portOfRBCServer;

    List<TMSClientHandler> clients = new ArrayList<>();

    ExecutorService threadPool = Executors.newCachedThreadPool();


    // Constructor

    public TMSCommunicator(EventBus localBus) {
        this._localBus = localBus;
        _localBus.register(this);
    }

    public void run() {
        try {
            ServerSocket server = new ServerSocket(_rbcServerPort);

            while(true) {
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

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void sendMessage(@NotNull SendTMSMessageEvent event) {
        if(!Objects.equals(event.target, _moduleID)) return;

        // TODO Queue
        try {
            Socket socket = new Socket(_ip, _tmsServerPort);
            // TODO Connection Exception?
            PrintWriter output      = new PrintWriter(socket.getOutputStream(), true);
            String      messageJSON = event.message.parseToJson();
            log("RBC sending: " + messageJSON);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder  data  = new StringBuilder();
            // TODO Multiple input lines possible ?
            data.append(input.readLine());

            log("RBC received: " + data.toString());
            Message response = Message.generateFrom(data.toString());

            _localBus.post(new ReceivedTMSMessageEvent(_moduleID, _tmsEndpointID, response));

            output.close();
            input.close();
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(MissingInformationException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void log(String msg) {
        _localBus.post(new ToLogEvent(_moduleID, "log", msg));
    }

    private void log(Exception e) {
        _localBus.post(new ExceptionEvent(_moduleID, "log", new NotCausedByAEvent(), e));
    }

    private void logDebug(String msg) {
        _localBus.post(new ToLogDebugEvent(_moduleID, "log", msg));
    }

}
