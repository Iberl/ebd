package ebd.szenario.util;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.szenario.TerminateTrainEvent;
import ebd.globalUtils.events.szenario.UpdatingInfrastructureEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class InfrastructureClient {
    private EventBus globalEventBus;

    private String ip;
    private int port;
    private Socket socket;
    private PrintWriter out;

    private List<Integer> registeredTrains = new ArrayList();


    public InfrastructureClient() throws IOException {
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
        ConfigHandler ch = ConfigHandler.getInstance();
        this.ip = ch.ipToInfrastructureServer;
        this.port = Integer.parseInt(ch.portOfInfrastructureServer);

        connect();
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
        } //TODO Do not chat IOexception
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
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void updateEvent(UpdatingInfrastructureEvent uie){
        if(!validTarget(uie.targets)){
            return;
        }
        int trainID = getTrainIDFromSource(uie.source);

        if(trainID == -1){
            return;
        }

        if(!registeredTrains.contains(trainID)){
            registeredTrains.add(trainID);
            init(trainID);
        }

        gok(trainID, uie.speedInKmh);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void terminateTrain(TerminateTrainEvent tte){
        this.globalEventBus.unregister(this);

        if(!validTarget(tte.targets)){
            return;
        }
        int trainID = getTrainIDFromSource(tte.source);

        if(trainID == -1 || !this.registeredTrains.contains(trainID)) return;

        terminate(trainID);
        this.registeredTrains.remove(trainID);
    }

    @Subscribe
    public void disconnect(DisconnectEvent de){


    }



    private int getTrainIDFromSource(String source){
        int etcsID = -1;
        if(!source.contains("T=")){
           return -1;
        }

        String[] split = source.split(";");
        String numbers;
        for(String part : split){

            if(part.contains("T=")) {
                numbers = part.replaceAll("[^0-9]", "");
                etcsID = Integer.parseInt(numbers);
            }

        }
        return etcsID;
    }

    /**
     * True if this Instance is a vaild target of the event
     * @param targetList the target list a the event
     * @return True if this instance is a vaild target of the event
     */
    private boolean validTarget(List<String> targetList){

        for(String target : targetList){
            if(target.contains("szenario") || target.contains("all")){
                return true;
            }
        }
        return false;
    }
}
