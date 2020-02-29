package ebd.szenario.util.clients;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.szenario.TerminateTrainEvent;
import ebd.globalUtils.events.szenario.UpdatingInfrastructureEvent;
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
    private int trainNumber;

    /**
     * If simulated, do not connect to any servers
     */
    private boolean useInfrastructureServer;


    public InfrastructureClient() throws IOException {
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
        ConfigHandler ch = ConfigHandler.getInstance();
        this.ip = ch.ipToInfrastructureServer;
        this.port = Integer.parseInt(ch.portOfInfrastructureServer);
        this.useInfrastructureServer = ch.useInfrastructureServer;
        this.trainNumber = ch.etcsEngineAndInfrastructureID;

        if(this.useInfrastructureServer) connect();
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
                //System.out.println("Command \"" + cmd.toUpperCase(Locale.ENGLISH) + "\" sent to FST.");
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
                    //System.out.println("Command \"" + String.format(format, params).toUpperCase(Locale.ENGLISH) + "\" sent to FST.");
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
     * Signs the train into the system. It stops and the direction the train driving
     * direction will be set on nominal. Function 0 will be activated, 1 to 4 will be
     * deactivated.
     *
     * @param address Tfz-Adresse
     */
    private void init(Integer address) {
        send("init %s", address);
    }

    /**
     * Disconnects the train from the system. It stops and the direction the train driving
     * direction will be set on nominal. Function 0 to 4 will be
     * deactivated.
     * Only works if the train is standing still.
     *
     * @param address Tfz-Adresse
     */
    private void terminate(Integer address) {
        send("term %s", address);
    }


    /**
     * Manuel train drive based on speed. If the train on the infrastructure
     * has no saved speed information a warning will be displayed and no action
     * will be taken
     * @param address Tfz-Adresse
     * @param velocity Speed in km/h
     */
    private void gok(Integer address, Integer velocity) {
        send("gok %s %s", address, velocity);
    }

    /**
     * Manuel train drive
     *
     * @param address Tfz-Address
     * @param trainPowerLevel train power level in the range of 0 to 100
     */
    private void go(Integer address, Integer trainPowerLevel) {
        send("go %s %s", address, trainPowerLevel);
    }

    /**
     *
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void updateEvent(UpdatingInfrastructureEvent uie){
        if(!this.useInfrastructureServer || !validTarget(uie.targets)){
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
        if(uie.speedInKmh > 0 && uie.speedInKmh < 10){
            /*
            Necessary, because the infrastructure logic has a quirk. which sets the train power level to 0
            from 0 to 10 km/h and starts with two at 10 km/h.
            */
            go(trainID, 1);
        }
        else {
            gok(trainID, uie.speedInKmh);
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void terminateTrain(TerminateTrainEvent tte){
        if(!this.useInfrastructureServer || !validTarget(tte.targets)){
            return;
        }

        int trainID = getTrainIDFromSource(tte.source);
        if(trainID == -1 || !this.registeredTrains.contains(trainID)) return;

        terminate(trainID);
        this.registeredTrains.remove(trainID);
    }

    @Subscribe
    public void disconnect(DisconnectEvent de){
        if(!validTarget(de.targets)){
            return;
        }

        this.globalEventBus.unregister(this);
    }



    private int getTrainIDFromSource(String source){
        int etcsID = -1;
        //TODO: set train number by questioning the DBD database or by initialisation
        etcsID = this.trainNumber;
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
