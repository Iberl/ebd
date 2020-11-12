package ebd.tmsDummy.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static ebd.tmsDummy.util.Utils.log;
import static ebd.tmsDummy.util.Utils.logDebug;

public class TMSClientHandler implements Runnable {

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
            StringBuilder data = new StringBuilder();
            data.append(in.readLine());
            logDebug("Received: " + data.toString());
        } catch(IOException e) {
            logDebug("Problem occurred while reading input stream.");
            log(e);
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