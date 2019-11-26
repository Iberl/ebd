package ebd.trainStatusManager.util.socketClientsConnectors;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;

/**
 * //TODO Move up to main level of the program, use global events on this level
 */
public class InfrastructureClientConnector {

    EventBus localEventBus;

    private String ip;
    private int port;
    private Socket socket;
    private PrintWriter out;

    private final int etcsID;
    private final int updateMultiplier;
    private final int maxCarry;
    private int tickCounter = 0;
    private double carry = 0;
    private long lastTimeInMS = 0;


    public InfrastructureClientConnector(EventBus localEventBus, int etcsID) throws IOException {
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);
        ConfigHandler ch = ConfigHandler.getInstance();
        this.ip = ch.ipToInfrastructureServer;
        this.port = Integer.parseInt(ch.portOfInfrastructureServer);
        this.updateMultiplier = ch.infrastructureUpdateMultiplier;
        this.maxCarry = 3 * this.updateMultiplier * ch.trainClockTickInMS / 1000;

        this.etcsID = etcsID;

        connect();
        init(this.etcsID);

        this.lastTimeInMS = System.currentTimeMillis();
    }

    public void close() throws IOException {
        Socket socket = this.socket;
        if (socket != null) {
            socket.close();
        }
        this.socket = null;
        out = null;
    }

    private void connect() throws IOException {
        if(socket == null){
            socket = new Socket(ip, port);
            out = new PrintWriter(socket.getOutputStream());
        }
    }

    private void reconnect() throws IOException {
        if (socket != null) {
            close();
        }

        if (ip != null && port > 0) {
            connect();
        }
    }

    private boolean isConnected() {
        PrintWriter out = this.out;
        return socket != null && out != null && !out.checkError();
    }

    private void send(String cmd) {
        PrintWriter out = this.out;
        if (out != null) {
            out.println(cmd);
            if (!out.checkError()) {
                System.out.println("Command \"" + cmd.toUpperCase(Locale.ENGLISH) + "\" sent to FST.");
            } else {
                try {
                    reconnect();
                } catch (IOException e) {
                    System.err.println("Could not reconnect to Fahrsteuerung: " + e.getLocalizedMessage());
                }
            }
        }
    }

    private void send(String format, Object... params) {
        PrintWriter out = this.out;
        if (out != null) {
            synchronized (out) {
                out.printf(format, params);
                out.println();
                if (!out.checkError()) {
                    System.out.println("Command \"" + String.format(format, params).toUpperCase(Locale.ENGLISH) + "\" sent to FST.");
                } else {
                    try {
                        reconnect();
                    } catch (IOException e) {
                        System.err.println("Could not reconnect to Fahrsteuerung: " + e.getLocalizedMessage());
                    }
                }
            }
        }
    }

    private void setEmergencyStop(boolean emergencyStop) {
        send(emergencyStop ? "nh" : "nh-off");
    }

    /**
     * Fahrzeug am System anmelden. Es wird angehalten und die Richtung auf
     * Pfeilrichtung gesetzt. Funktion 0 wird aktiviert, 1 bis 4 werden
     * deaktiviert.
     *
     * @param address Tfz-Adresse
     */
    private void init(Integer address) {
        send("init %s", address);
    }

    /**
     * Fahrzeug vom System abmelden. Es wird angehalten und die Richtung auf
     * Pfeilrichtung gesetzt. Funktionen 0 bis 4 werden deaktiviert.
     * Funktioniert nur, wenn Fahrzeug steht.
     *
     * @param address Tfz-Adresse
     */
    private void terminate(Integer address) {
        send("term %s", address);
    }


    /**
     * Fahrzeug manuell fahren. Wenn keine Geschwindigkeitsinformationen fÃ¼r das
     * Fahrzeug vorhanden sind, wird ein Fehler ausgegeben und keine Aktion
     * ausgefÃ¼hrt.
     *
     * @param address Tfz-Adresse
     * @param velocity Geschwindigkeit in km/h
     */
    private void gok(Integer address, Integer velocity) {
        send("gok %s %s", address, velocity);
    }

    /**
     *
     */
    @Subscribe
    public void clockTick(ClockTickEvent cte){
        if(this.tickCounter <= this.updateMultiplier){
            this.tickCounter += 1;
            return;
        }

        long deltaTime = (this.lastTimeInMS - System.currentTimeMillis()) / 1000;
        this.lastTimeInMS = System.currentTimeMillis();

        this.tickCounter = 0;
        TrainDataVolatile trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        double curV = trainDataVolatile.getCurrentSpeed();
        curV = curV * 3.6; //To km/h

        /*
        To reduce rounding to integer errors, the difference between the the int and the double is carried over,
        weighted with the time spend between clock ticks and then added back in.
        Because a pause in the execution of the process could lead to errors and to great carries, a sanity check
        will be performed.
         */
        double weightedCarry = this.carry * deltaTime;

        if(weightedCarry > this.maxCarry ){
            weightedCarry = 0;
        }
        curV += weightedCarry;
        long curVlong = Math.round(curV);
        this.carry = (curV - curVlong) / deltaTime;

        gok(this.etcsID,(int)curVlong);
    }










}
