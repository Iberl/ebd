package ebd.szenario.util.server;

import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.trainStatusManager.util.events.TsmExceptionEvent;

import java.io.*;
import java.net.Socket;
import java.util.Collections;

public class GUIClientWorker implements Runnable{

    private Thread guiClientWorker;
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public GUIClientWorker(Socket client) throws IOException {
        this.guiClientWorker = new Thread(this);
        this.client = client;
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.out = new PrintWriter(client.getOutputStream(), true);
        this.guiClientWorker.start();
    }

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

    public void sendString(String string){
        this.out.println(string);
    }
}
