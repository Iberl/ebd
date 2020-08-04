package de.ibw.smart.logic.intf;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * Class im RBC
 */
public abstract class SocketServer<T, Resp> implements IProcessRequest<T,Resp> {
    private static int iPort = 22222;



    final ExecutorService pool;
    final ServerSocket serverSocket;
    int poolSize = 4;
    //Liefert einen Thread-Pool für maximal poolSize Threads

    public SocketServer(int iPort) throws IOException {
        this.iPort = iPort;
        pool = Executors.newFixedThreadPool(poolSize);
        serverSocket = new ServerSocket(iPort);
        Thread t1 = new Thread(new ServiceImpl(pool, serverSocket));
        System.out.println("Start Listingen Movement Authorities, " +
                ", Thread: " + Thread.currentThread());
        t1.start();

        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    public void run() {
                        System.out.println("Strg+C, pool.shutdown");
                        pool.shutdown();  //keine Annahme von neuen Anforderungen
                        try {
                            //warte maximal 4 Sekunden auf Beendigung aller Anforderungen
                            pool.awaitTermination(4L, TimeUnit.SECONDS);
                            if (!serverSocket.isClosed()) {
                                System.out.println("ServerSocket close");
                                serverSocket.close();
                            }
                        } catch (IOException e) {
                        } catch (InterruptedException ei) {
                        }
                    }
                }
        );


    }

    public void getRequest() throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(iPort);
        this.listenToSmartLogic(serverSocket);

    }

    private String readMaFromSmartLogic(Socket socketFromSmartLogic) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                                socketFromSmartLogic.getInputStream()));
        char[] buffer = new char[200];
        int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
        String nachricht = new String(buffer, 0, anzahlZeichen);
        return nachricht;
    }

    private void listenToSmartLogic(ServerSocket serverSocket) throws IOException, ClassNotFoundException {

        while (true) {
            Socket clientSocket = serverSocket.accept(); // blockiert, bis sich ein Client angemeldet hat
            System.out.println("Socket accepted...");

            ObjectInputStream inFromClient = new ObjectInputStream(new BufferedInputStream(
                    clientSocket.getInputStream()));
            T RequestMsg = null;
            RequestMsg = (T) inFromClient.readObject();

        }

    }

    private class ServiceImpl implements Runnable {
        private final ServerSocket serverSocket;
        private final ExecutorService pool;

        public ServiceImpl(ExecutorService pool, ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
            this.pool = pool;
        }

        public void run() { // run the service
            try {
                while (true) {
                    Socket cs = serverSocket.accept();  //warten auf Client-Anforderung

                    //starte den Handler-Thread zur Realisierung der Client-Anforderung
                    pool.execute(new RequestHandler(serverSocket, cs));
                }
            } catch (IOException ex) {
                System.out.println("--- Interrupt MaService-run");
            } finally {
                System.out.println("--- Ende MaService(pool.shutdown)");
                pool.shutdown();  //keine Annahme von neuen Anforderungen
                try {
                    //warte maximal 4 Sekunden auf Beendigung aller Anforderungen
                    pool.awaitTermination(4L, TimeUnit.SECONDS);
                    if (!serverSocket.isClosed()) {
                        System.out.println("--- Ende MaService:ServerSocket close");
                        serverSocket.close();
                    }
                } catch (IOException e) {
                } catch (InterruptedException ei) {
                }
            }
        }
    }

    private class RequestHandler implements Runnable {
        private final Socket client;
        private final ServerSocket serverSocket;

        public RequestHandler(ServerSocket serverSocket, Socket client) { //Server/Client-Socket
                this.client = client;
                this.serverSocket = serverSocket;

            }
        public void run() {
            StringBuffer sb = new StringBuffer();
            PrintWriter out = null;
            try {
                // read and service request on client
                System.out.println( "running service, " + Thread.currentThread() );


                BufferedInputStream bufferedStream = new BufferedInputStream(
                                client.getInputStream());
                ObjectInputStream objectStream = new ObjectInputStream(bufferedStream);

                //---------------  hier sind die Daten Christopher ------------//
                T Request= (T) objectStream.readObject();
                Resp R = processRequest(Request);
                if(R != null) {
                    BufferedOutputStream outputStream = new BufferedOutputStream(
                        client.getOutputStream()
                    );
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(R);
                    objectOutputStream.flush();
                }

            } catch (IOException | ClassNotFoundException e) {System.out.println("IOException, Handler-run");
            e.printStackTrace();}
            finally {
                //out.println(sb);  //Rückgabe Ergebnis an den Client
                if ( !client.isClosed() ) {
                    System.out.println("****** Handler:Client close");
                    try {
                        client.close();
                    } catch ( IOException e ) { }
                }
            }
        }  //Ende run

    }
}

