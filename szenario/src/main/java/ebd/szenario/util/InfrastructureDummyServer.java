package ebd.szenario.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class InfrastructureDummyServer implements Runnable {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    private Thread thisThread;

    public InfrastructureDummyServer(int port) throws IOException {
        this.thisThread = new Thread(this);
        setup(port);
    }

    @Override
    public void run() {
        String inputLine;
        while (true) {
            try {
                inputLine = in.readLine();
            } catch (IOException e) {
                System.out.println("Error in connection");
                e.printStackTrace();
                break;
            }
            if (inputLine == null) break;

            System.out.println(inputLine);

            if (inputLine.contains("term")) {
                break;
            }
        }

    }

    private void setup(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        this.thisThread.start();
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
