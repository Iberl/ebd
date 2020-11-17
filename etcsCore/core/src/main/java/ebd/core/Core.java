package ebd.core;


import ebd.core.util.clients.InfrastructureClient;
import ebd.core.util.events.LoadEvent;
import ebd.core.util.handler.InputHandler;
import ebd.core.util.server.ATOServer;
import ebd.core.util.server.DMIServer;
import ebd.core.util.server.GUIServer;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.configHandler.TrainsHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.tmsDummy.TMSDummyStartEvent;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.logging.Logging;
import ebd.radioBlockCenter.RadioBlockCenter;
import ebd.core.util.handler.ScenarioEventHandler;
import ebd.core.util.events.ScenarioExceptionEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;


public class Core implements Runnable {




    private final EventBus globalEventBus;
    private final Thread szenarioThread = new Thread(this);
    private final ConfigHandler ch;
    private final TrainsHandler iFH;

    private final ScenarioEventHandler szenarioEventHandler;
    private final InputHandler inputHandler;
    private Logging logger;

    /*
    Sockets
     */
    private InfrastructureClient infrastructureClient;

    /*
    Server Sockets
     */
    private GUIServer guiServer;
    private DMIServer dmiServer;
    private ATOServer atoServer;

    /*
    TrackSide
     */
    private RadioBlockCenter rbc = null;

    /*
    TrainSide
     */
    private TrainManager tm = null;

    public Core() {
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
        this.szenarioEventHandler = new ScenarioEventHandler();

        this.ch = ConfigHandler.getInstance();
        this.iFH = TrainsHandler.getInstance();
        try {
            this.logger = new Logging();
            this.infrastructureClient = new InfrastructureClient();
            this.dmiServer = new DMIServer();
            if(ch.allowGUI) this.guiServer = new GUIServer();
            if(ch.allowATO) this.atoServer = new ATOServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.inputHandler = new InputHandler();

        System.out.println("This is the virtual environment for the ETCS@EBD project");

        szenarioThread.start();
        if(ch.autoStart) load(new LoadEvent("scenario", "scenario"));
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            InterruptedException ie = new InterruptedException("TSM was interrupted: " + e.getMessage());
            ie.setStackTrace(e.getStackTrace());
            this.globalEventBus.post(new ScenarioExceptionEvent("scenario", "Core",
                    new NotCausedByAEvent(),ie));
        }
        Runtime.getRuntime().exit(0);
    }

    public void join(){
        try {
            this.szenarioThread.join();
        } catch (InterruptedException e) {
            InterruptedException ie = new InterruptedException("TSM was interrupted: " + e.getMessage());
            ie.setStackTrace(e.getStackTrace());
            this.globalEventBus.post(new ScenarioExceptionEvent("szenario", "Core",
                    new NotCausedByAEvent(),ie));
        }
    }

    /**
     * Reacts to a {@link DisconnectEvent} and stops the clock.
     * @param de a {@link DisconnectEvent}
     */
    @Subscribe
    public void disconnect(DisconnectEvent de){
        if(!validTarget(de.target)){
            return;
        }
        synchronized (this){
            this.notify();
        }
        globalEventBus.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void load(LoadEvent loe){
        System.out.println("Welcome to the ETCS Train and RBC simulation");

        String msg = "ETCS start up";
        EventBus.getDefault().post(new ToLogEvent("glb", "log", msg));

        this.rbc = new RadioBlockCenter(1);

        try {
            this.tm = new TrainManager();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!ConfigHandler.getInstance().useTMSServer) EventBus.getDefault().post(new TMSDummyStartEvent("glb", "tms"));
    }

    private boolean validTarget(String target) {

        if(target.contains("scenario") || target.contains("all")){
            return true;
        }

        return false;
    }
}
