package de.ibw.smart.logic.intf;


import de.ibw.tms.ma.RbcMA;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


@Deprecated
public class SendMaClient {

    public String sIp = "127.0.0.1"; //localhost
    public int iPort = 22222;
    public static RbcMA Ma = null;



    public static void main(String[] args) {
        SendMaClient client = new SendMaClient();
        if (args.length == 2) {
            client.sIp = args[0];
            client.iPort = Integer.getInteger(args[1]);

        }
        try {


            client.worker(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void worker(RbcMA MA) throws Exception {
        System.out.println("worker:" + Thread.currentThread());
        //Klasse die 'Callable' implementiert
        ClientHandler ch = new ClientHandler();
        ch.setMa(MA);
        boolean weiter = false;
        do {  //2 Durchläufe
            int j = 0;
            //call-Methode 'ch' von ClientHandler wird mit 'FutureTask' asynchron
            //abgearbeitet, das Ergebnis kann dann von der 'FutureTask' abgeholt
            //werden.
            FutureTask<String> ft = new FutureTask<String>((Callable<String>) ch);
            Thread tft = new Thread(ft);
            tft.start();

            //prüfe ob der Thread seine Arbeit getan hat
            while (!ft.isDone()) {
                j++;  //zähle die Thread-Wechsel
                Thread.yield();  //andere Threads (AndererThread) können drankommen
            }
            System.out.println("not isDone:" + j);
            System.out.println(ft.get());  //Ergebnis ausgeben

        } while (weiter);
    }


//    void sendMa() throws IOException {
//
//        java.net.Socket socket = new java.net.Socket(sIp, iPort); // verbindet sich mit Server
//        //String sendMessage = "Hello, world!";
//        writeMa();
//
//    }

    /*public void writeMa(RbcMA MaMsg) {
        try {
            // Create the socket
            Socket clientSocket = new Socket(sIp, iPort);
            // Create the input & output streams to the server
            ObjectOutputStream outToServer = new ObjectOutputStream(new BufferedOutputStream(
                    clientSocket.getOutputStream()));



            *//* Create The Message Object to send *//*

            if(MaMsg == null) {
                MaMsg = new RbcMA("3377");
            }
            outToServer.writeObject(null);

            *//* Send the Message Object to the server *//*
            outToServer.writeObject(MaMsg);

            *//* Retrive the Message Object from server *//*

            while (true) {
                sleep(1000);
            }

            //clientSocket.close();

        } catch (Exception e) {
            System.err.println("Client Error: " + e.getMessage());
            System.err.println("Localized: " + e.getLocalizedMessage());
            System.err.println("Stack Trace: " + e.getStackTrace());
        }
    }*/

    void writeMessage(java.net.Socket socket, String nachricht) throws IOException {
        PrintWriter printWriter =
                new PrintWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
        printWriter.print(nachricht);
        printWriter.flush();
    }


    private class ClientHandler implements Callable<String> {
        String ip = "127.0.0.1";  //localhost
        int port = 22222;
        RbcMA Ma = null;

        public void setMa(RbcMA ma) {
            Ma = ma;
        }

        public ClientHandler() {

        }

        public String call() throws Exception {  //run the service
            System.out.println("ClientHandler:" + Thread.currentThread());
            //verlängere künstlich die Bearbeitung der Anforderung, um das Wechselspiel
            //der Threads zu verdeutlichen
            Thread.sleep(2000);
            RequestServer(Ma);
            return "MaSend";
        }

        private void RequestServer(RbcMA MA) throws IOException {
            Socket socket = new Socket(ip, port);
            sendMoveAuthority(socket, MA);
            // empfange Nachricht
            //::::::
            socket.close();
        }

        private void sendMoveAuthority(Socket socket, RbcMA Ma) throws IOException {
            ObjectOutputStream OutputStream = new ObjectOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));
            if(Ma == null) {
                EbdAuthorities.generateEbdMa();
                OutputStream.writeObject(EbdAuthorities.EbdMa);
            } else {
                OutputStream.writeObject(Ma);
            }

            OutputStream.flush();
        }
    }
}

