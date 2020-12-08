package de.ibw.smart.logic.intf;

import de.ibw.tms.ma.RbcMA;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * Inzwischen nicht mehr verwendet deswegen nicht weiter dokumentiert.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
 */
public class MaServer {
    private static int iPort = 22222;


    public static void main(String[] args) {
        if (args.length == 1) {
            iPort = Integer.getInteger(args[0]);
        }

        try {
            MaServer server = new MaServer(iPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final ExecutorService pool;
    final ServerSocket serverSocket;
    int poolSize = 4;
    //Liefert einen Thread-Pool für maximal poolSize Threads

    public MaServer(int iPort) throws IOException {
        this.iPort = iPort;
        pool = Executors.newFixedThreadPool(poolSize);
        serverSocket = new ServerSocket(iPort);
        Thread t1 = new Thread(new MaService(pool, serverSocket));
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

    public void getRbcMa() throws IOException, ClassNotFoundException {
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(iPort);
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
            java.net.Socket clientSocket = serverSocket.accept(); // blockiert, bis sich ein Client angemeldet hat
            System.out.println("Socket accepted...");

            ObjectInputStream inFromClient = new ObjectInputStream(new BufferedInputStream(
                    clientSocket.getInputStream()));
            RbcMA MaMsg = null;
            MaMsg = (RbcMA) inFromClient.readObject();
            System.out.println(MaMsg.sTrainId);
        }

    }

    private class MaService implements Runnable {
        private final ServerSocket serverSocket;
        private final ExecutorService pool;

        public MaService(ExecutorService pool, ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
            this.pool = pool;
        }

        public void run() { // run the service
            try {
                while (true) {
                    Socket cs = serverSocket.accept();  //warten auf Client-Anforderung

                    //starte den Handler-Thread zur Realisierung der Client-Anforderung
                    pool.execute(new MaHandler(serverSocket, cs));
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

    private class MaHandler implements Runnable {
        private final Socket client;
        private final ServerSocket serverSocket;

        public MaHandler(ServerSocket serverSocket,Socket client) { //Server/Client-Socket
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
                RbcMA Ma= (RbcMA) objectStream.readObject();
                System.out.println(Ma.sTrainId);

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

