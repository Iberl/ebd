package ebd.radioBlockCenter.util;


import java.io.*;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * class in SmartLogic/TMS sending Ma
 */
public class SocketClient<T, Resp> {

    public String ip = "127.0.0.1"; //localhost
    public int port = 22223;

    public LinkedBlockingQueue<Resp> outputQueue = new LinkedBlockingQueue<Resp>();

    public SocketClient() {
    }

    public void request(T message) throws Exception {

        System.out.println("worker:" + Thread.currentThread());

        ClientHandler ch = new ClientHandler();
        ch.set(message);

        //call-Methode 'ch' von ClientHandler wird mit 'FutureTask' asynchron abgearbeitet, das Ergebnis kann dann von der 'FutureTask' abgeholt werden.

        FutureTask<String> task = new FutureTask<>(ch);
        Thread thread = new Thread(task);
        thread.start();

        while(!task.isDone());

        System.out.println(task.get());

    }

    void writeMessage(Socket socket, String message) throws IOException {
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.print(message);
        printWriter.flush();
    }

    public static void main(String[] args) {
        SocketClient<String, String> client = new SocketClient<String, String>();
        if(args.length == 2) {
            client.ip = args[0];
            client.port = Integer.getInteger(args[1]);
        }

        try {
            client.request("ICE 12");
            while(true) {
                // Christopher hier kannst du den MA RBC abgreiffen
                System.out.println(client.outputQueue.take());
                // take blockiert die while schleife solange keine Elemente in der Queue sind
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Callable<String> {
        T message = null;

        public void set(T message) {
            this.message = message;
        }

        public ClientHandler() {
        }

        public String call() {
            System.out.println("ClientHandler:" + Thread.currentThread());
            try {
                Socket socket = new Socket(SocketClient.this.ip, SocketClient.this.port);
                send(socket, message);
                receive(socket);
                socket.close();
            } catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return "Request done";
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
}

