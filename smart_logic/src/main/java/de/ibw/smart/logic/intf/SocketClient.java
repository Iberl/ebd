package de.ibw.smart.logic.intf;


import java.io.*;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * class in SmartLogic/TMS sending Ma
 */
public class SocketClient<T, Resp> {

    public String sIp = "127.0.0.1"; //localhost
    public int iPort = 22223;
    //take operator
    public LinkedBlockingQueue<Resp> OutputQueue = new LinkedBlockingQueue<Resp>();


    public SocketClient() {

    }

    public SocketClient(String sIp, int iPort) {
        if(sIp != null) {
            this.sIp = sIp;

        }
        this.iPort = iPort;
    }


    public static void main(String[] args) {
        SocketClient<String, String> client = new SocketClient<String, String>();
        if (args.length == 2) {
            client.sIp = args[0];
            client.iPort = Integer.getInteger(args[1]);

        }
        try {


            client.worker("ICE 12");
            while(true) {
                // Christopher hier kannst du den MA RBC abgreiffen
                System.out.println(client.OutputQueue.take());
                // take blockiert die while schleife solange keine Elemente in der Queue sind
            }




        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void worker(T Send) throws Exception, EOFException {
        System.out.println("worker:" + Thread.currentThread());
        //Klasse die 'Callable' implementiert
        ClientHandler ch = new ClientHandler();
        ch.setMa(Send);
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

    void writeMessage(Socket socket, String nachricht) throws IOException {
        PrintWriter printWriter =
                new PrintWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
        printWriter.print(nachricht);
        printWriter.flush();
    }


    private class ClientHandler implements Callable<String> {
        String ip = SocketClient.this.sIp;  //localhost
        int port = SocketClient.this.iPort;
        T ToSend = null;

        public void setMa(T ToSend) {
            this.ToSend = ToSend;
        }

        public ClientHandler() {

        }

        public String call() throws Exception, EOFException {  //run the service
            System.out.println("ClientHandler:" + Thread.currentThread());
            //verlängere künstlich die Bearbeitung der Anforderung, um das Wechselspiel
            //der Threads zu verdeutlichen
            Thread.sleep(2000);
            RequestServer(ToSend);
            return "Request done";
        }

        private void RequestServer(T ToSend) throws IOException, ClassNotFoundException {
            Socket socket = new Socket(ip, port);
            send(socket, ToSend);
            // empfange Nachricht
            try {
                receive(socket);
            } catch (EOFException EOF) {
                EOF.printStackTrace();
                // Christoher hier falls keine MA mehr vorliegt auf TMS Seite
            }
            //::::::
            socket.close();
        }

        private void receive(Socket socket) throws IOException, ClassNotFoundException, EOFException {
            ObjectInputStream InStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            OutputQueue.add((Resp) InStream.readObject());
        }

        private void send(Socket socket, T ToSend) throws IOException {
            ObjectOutputStream OutputStream = new ObjectOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));
            if(ToSend == null) {
                EbdAuthorities.generateEbdMa();
                OutputStream.writeObject(EbdAuthorities.EbdMa);
            } else {
                OutputStream.writeObject(ToSend);
            }

            OutputStream.flush();
        }
    }
}

