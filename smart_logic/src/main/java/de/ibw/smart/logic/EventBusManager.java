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

/**
 * Diese Komponente verwaltet Logging GUI Server und das Logging der SL und des TMS
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-08-27
 */

public class EventBusManager {
    private final EventBus LocalBus;
    private Logging logger;
    private boolean isTMS = false;


    private static DefaultRepo<Integer, EventBusManager> tmsBusById = new DefaultRepo<>();
    private static DefaultRepo<Integer, EventBusManager> smartLogicBusById = new DefaultRepo<>();

    /**
     * Factory Methode, die einen EventBusManager generiert, falls das Modul noch keinen Manager besitzt.
     * Falls ein Manager schon generiert wurde, wird dieser widergegeben.
     * @param id int - ModulId
     * @param isTMS boolean - ist das Modul ein TMS
     * @return EventBusManager - gibt den Manager fur das Modul der id wider
     * @throws IOException - falls es Probleme zum Logger gibt, kann eine Exception erfolgen.
     */
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
           EBM.isTMS = isTMS;
           scopedRepo.update(id, EBM);
        }
        return EBM;


    }

    private EventBusManager(int id, String prefix) throws IOException {
        LocalBus = new EventBus();
        logger = new Logging(LocalBus, id, prefix);
    }

    /**
     * Logt eine Nachricht untern Nennung des angegebenen Untermoduls
     * @param sMsg {@link String} - Nachricht, die geloggt werden soll
     * @param sModuleId - {@link String} - Name des Untermoduls, bzw. Komponente.
     */
    public void log(String sMsg, String sModuleId) {
        new Thread() {
            public void run() {

                EventBusManager.this.LocalBus.post(new ToLogEvent(sModuleId, "log", sMsg));

            }
        }.start();
    }

    /**
     * Startet den GUI-Server unter dem der GUI-Client die Nachrichten abrufen kann.
     * Der GUI server untersucht TMS oder SL Modul der ID "1", deswegen wurde die 1 fest codiert.
     * @param bIsTMS boolean - ist der Server innerhalb des TMS
     * @throws Exception - wirft eine Exception wenn der GUIServer nicht generiert werden kann
     */
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

    /**
     * Test Main method
     * @param args - not used
     * @throws Exception - test
     */
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
