package ebd.core.util.clients;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.core.StopTrainEvent;
import ebd.globalUtils.events.core.TerminateTrainEvent;
import ebd.globalUtils.events.core.UpdatingInfrastructureEvent;
import ebd.globalUtils.events.logger.ToLogDebugEvent;
import ebd.globalUtils.events.trainStatusMananger.ChangeInfrastructureDirectionEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a intermediary between {@link ebd.trainStatusManager.util.socketConnectors.InfrastructureClientConnector}
 * and the EBD infrastructure server. It listens to {@link UpdatingInfrastructureEvent} and sends the content over a
 * socket connection to the server.
 */
public class InfrastructureClient {
    private final EventBus globalEventBus;

    private final String ip;
    private final int port;
    private Socket socket;
    private PrintWriter out;

    /**
     * Contains a list of infrastructure IDs
     */
    private final List<Integer> registeredTrains = new ArrayList<>();

    /**
     * If simulated, do not connect to any servers
     */
    private final boolean useInfrastructureServer;

    /**
     * Constructs this class. Only connects to the infrastructure server if useInfrastructureServer in {@link ConfigHandler} is
     * set to true.
     * @throws IOException if {@link Socket#connect(SocketAddress)} fails
     */
    public InfrastructureClient() throws IOException {
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
        ConfigHandler ch = ConfigHandler.getInstance();
        this.ip = ch.ipToInfrastructureServer;
        this.port = Integer.parseInt(ch.portOfInfrastructureServer);
        this.useInfrastructureServer = ch.useInfrastructureServer;

        if(this.useInfrastructureServer) connect();
    }

    /**
     * Listens to {@link UpdatingInfrastructureEvent} and sends the content to the Infrastructure Server
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void updateEvent(UpdatingInfrastructureEvent uie){
        if(!this.useInfrastructureServer || !validTarget(uie.target)){
            return;
        }
        int trainID = uie.infrastructureID;

        if(!this.registeredTrains.contains(trainID)){
            this.registeredTrains.add(trainID);
            init(trainID);
        }
        gok(trainID, uie.speedInKmh);
        String msg = "Send: gok " + trainID + " " + uie.speedInKmh;
        this.globalEventBus.post(new ToLogDebugEvent("ic", "log", msg));
    }

    @Subscribe
    public void changeDirection(ChangeInfrastructureDirectionEvent cide){
        if(!this.useInfrastructureServer || !validTarget(cide.target)){
            return;
        }

        int trainID = cide.infrastructureID;
        if(trainID == -1 || !this.registeredTrains.contains(trainID)) return;

        switchDirection(trainID);
    }

    /**
     * Listens to {@link TerminateTrainEvent} and sends the content to the Infrastructure Server to terminate the train
     */
    @Subscribe
    public void stopTrain(StopTrainEvent tte){
        if(!this.useInfrastructureServer || !validTarget(tte.target)){
            return;
        }

        int trainID = tte.infrastructureID;
        if(trainID == -1 || !this.registeredTrains.contains(trainID)) return;

        stop(trainID);
        this.registeredTrains.remove(Integer.valueOf(trainID));
    }

    /**
     * Listens to {@link TerminateTrainEvent} and sends the content to the Infrastructure Server to terminate the train
     */
    @Subscribe
    public void terminateTrain(TerminateTrainEvent tte){
        if(!this.useInfrastructureServer || !validTarget(tte.target)){
            return;
        }

        int trainID = tte.infrastructureID;
        if(trainID == -1 || !this.registeredTrains.contains(trainID)) return;

        terminate(trainID);
        this.registeredTrains.remove(Integer.valueOf(trainID));
    }

    /**
     * Listens to {@link DisconnectEvent} and disconnect this from the global event bus
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void disconnect(DisconnectEvent de){
        if(!validTarget(de.target)){
            return;
        }
        synchronized (this.registeredTrains){
            for(int train : this.registeredTrains){
                stop(train);
            }
        }

        this.globalEventBus.unregister(this);
    }

    /**
     * Closes the socket connection.
     * @throws IOException If {@link Socket#close()} fails.
     */
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
            socket.setOption(StandardSocketOptions.TCP_NODELAY, true);
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

    private void send(String format, Object... params) {
        PrintWriter out = this.out;
        if (out != null) {
            synchronized (out) {
                out.printf(format, params);
                out.println();
                out.flush();

                if (!out.checkError()) {
                    //System.out.println("Command \"" + String.format(format, params).toUpperCase(Locale.ENGLISH) + "\" sent to FST.");
                }
                else {
                    try {
                        reconnect();
                    } catch (IOException e) {
                        System.err.println("Could not reconnect to Fahrsteuerung: " + e.getLocalizedMessage());
                    }
                }
            }
        }
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
     * Switches the direction of the train, only works when the train is stopped.
     * @param address Tfz-Adresse
     */
    private void switchDirection(Integer address){
        send("rich %s", address);
    }

    /**
     * Stops the train.
     *
     * @param address Tfz-Adresse
     */
    private void stop(Integer address) {
        send("stop %s", address);
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
     * True if this Instance is a vaild target of the event
     * @param target the target list a the event
     * @return True if this instance is a vaild target of the event
     */
    private boolean validTarget(String target){

        if(target.contains("szenario") || target.contains("all")){
            return true;
        }
        return false;
    }
}
