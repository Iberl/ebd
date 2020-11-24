package ebd.ibw;


import de.disposim.dbd.example.client.ExampleSession;
import de.disposim.dbd.io.SessionClosedException;
import de.disposim.dbd.io.StreamClosedException;
import de.disposim.dbd.packet.IllegalNameLengthException;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.ibw.sessions.TescSession;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

public class SlDbdClient {

    ExampleSession SmartSession;

    public SlDbdClient() throws UnknownHostException, IOException {
        String sHost;
        int iPort;
        if(!ConfigHandler.getInstance().useInfrastructureServer) {
            sHost = "localhost";
            iPort = 1436;
        } else {
            sHost = ConfigHandler.getInstance().ipToInfrastructureServer;
            iPort = Integer.parseInt(ConfigHandler.getInstance().portOfInfrastructureServer);
        }
        SmartSession = new ExampleSession(new Socket(sHost, iPort));
        new Thread() {
            @Override
            public void run() {
                try {
                    SmartSession.listen();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (StreamClosedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            SmartSession.set("12W5I", 1);
        } catch (SessionClosedException e) {
            e.printStackTrace();
        } catch (IllegalNameLengthException e) {
            e.printStackTrace();
        }
        try {
            SmartSession.query("TEST");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (SessionClosedException e) {
            e.printStackTrace();
        } catch (IllegalNameLengthException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            SlDbdClient Cl = new SlDbdClient();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true);
    }
}
