package de.ibw.smart.logic;


import de.ibw.util.DefaultRepo;
import ebd.ConfigHandler;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.logging.Logging;
import ebd.szenario.util.server.GUIServer;
import org.greenrobot.eventbus.EventBus;

import javax.swing.tree.ExpandVetoException;
import java.awt.im.InputContext;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class EventBusManager {
    private final EventBus LocalBus;
    private Logging logger;

    private static DefaultRepo<Integer, EventBusManager> tmsBusById = new DefaultRepo<>();
    private static DefaultRepo<Integer, EventBusManager> smartLogicBusById = new DefaultRepo<>();

    public static EventBusManager registerOrGetBus(int id, boolean isTMS) throws IOException {
        DefaultRepo<Integer, EventBusManager> scopedRepo = null;
        EventBusManager EBM = null;
        if(isTMS) {
            scopedRepo = tmsBusById;
        } else { scopedRepo = smartLogicBusById; }
        EBM  = scopedRepo.getModel(id);
        if (null == EBM) {
            String prefix = "tms ";
            if(!isTMS) {
                prefix = "sl ";
            }
           EBM = new EventBusManager(id, prefix);
           scopedRepo.update(id, EBM);
        }
        return EBM;


    }

    public EventBusManager(int id, String prefix) throws IOException {
        LocalBus = new EventBus();
        logger = new Logging(LocalBus, id, prefix);
    }
    public void log(String sMsg, String sModuleId) {
        new Thread() {
            public void run() {

                EventBusManager.this.LocalBus.post(new ToLogEvent(sModuleId, "log", sMsg));

            }
        }.start();
    }

    public static void startLogGuiServer(boolean bIsTMS) throws Exception {
        Integer iServerPort = null;
        EventBusManager BusManager = null;
        if(bIsTMS) {
            iServerPort = Integer.parseInt(ConfigHandler.getInstance().portOfGUIServer4TMS);

        } else {
            iServerPort = Integer.parseInt(ConfigHandler.getInstance().portOfGUIServer4SL);
        }
        BusManager = EventBusManager.registerOrGetBus(1, bIsTMS);
        GUIServer UiServer = new GUIServer(BusManager.LocalBus, iServerPort);
    }

    public static void main(String args[]) throws Exception {
        int iGuiServerPortTms = Integer.parseInt(ConfigHandler.getInstance().portOfGUIServer4TMS);
        int iGuiServerPortSl = Integer.parseInt(ConfigHandler.getInstance().portOfGUIServer4SL);
        EventBusManager ebmTms = EventBusManager.registerOrGetBus(1, true);
        EventBusManager ebmSl = EventBusManager.registerOrGetBus(1, false);

        GUIServer UiServerTms = new GUIServer(ebmTms.LocalBus, iGuiServerPortTms);
        GUIServer UiServerSl = new GUIServer(ebmSl.LocalBus, iGuiServerPortSl);




        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ebmTms.log("Test Message: blabla", "RBC-MODUL");
                ebmSl.log("Test Message: albert", "SL-Tool");
            }
        },  30000,30000);



    }


}
