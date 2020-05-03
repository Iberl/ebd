package ebd.radioBlockCenter.util;


import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.logger.ToLogEvent;
import org.greenrobot.eventbus.EventBus;

import java.io.*;
import java.net.Socket;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

public class SocketClient<T, Resp> {

    private class SocketClientHandler implements Callable<String> {
        T message = null;

        public void set(T message) {
            this.message = message;
        }

        public SocketClientHandler() {
        }

        public String call() {

            if(configHandler.debug) log("ClientHandler: " + Thread.currentThread());
            try {
                Socket socket = new Socket(SocketClient.this.ip, SocketClient.this.port);
                send(socket, message);
                receive(socket);
                socket.close();
            } catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return "Request done"; // TODO: Logger possible?
        }

        private void receive(Socket socket) throws IOException, ClassNotFoundException {
            ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            outputQueue.add((Resp) inputStream.readObject());
        }

        private void send(Socket socket, T message) throws IOException {
            ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            outputStream.writeObject(message);
            outputStream.flush();
        }
    }

    private ConfigHandler configHandler = ConfigHandler.getInstance();
    private EventBus globalbus = EventBus.getDefault();

    private String moduleID;

    public String ip = configHandler.ipToTMSServer;
    public int port = Integer.parseInt(configHandler.portOfTMSServer);

    public LinkedBlockingQueue<Resp> outputQueue = new LinkedBlockingQueue<Resp>();

    public SocketClient(String moduleID) {
        this.moduleID = moduleID;
    }

    public void request(T message) throws Exception {

        if(configHandler.debug) log("worker:" + Thread.currentThread());

        SocketClientHandler clientHandler = new SocketClientHandler();
        clientHandler.set(message);

        //call-Methode 'ch' von ClientHandler wird mit 'FutureTask' asynchron abgearbeitet, das Ergebnis kann dann von der 'FutureTask' abgeholt werden.

        FutureTask<String> task = new FutureTask<>(clientHandler);
        Thread thread = new Thread(task);
        thread.start();

        while(!task.isDone()); // TODO: Potential endless loop

        if(configHandler.debug) log(task.get());

    }

    private void log(String msg) {
        globalbus.post(new ToLogEvent(moduleID, "log", msg));
    }
}

