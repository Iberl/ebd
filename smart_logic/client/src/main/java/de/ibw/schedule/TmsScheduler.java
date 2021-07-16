package de.ibw.schedule;

import de.ibw.main.SmartLogicClient;
import de.ibw.modules.MaModul;
import de.ibw.schedule.runner.PermissionRunnable;
import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.tms.entities.TimeTaskDAO;
import de.ibw.tms.entities.TimeTaskRepository;
import de.ibw.tms.entities.TmsJpaApp;
import de.ibw.tms.entities.converter.CheckDbdCmdConverter;
import de.ibw.tms.entities.converter.CheckPermissionConverter;
import de.ibw.tms.intf.TmsDbdCommand;
import de.ibw.tms.intf.TmsMessage;
import de.ibw.tms.intf.TmsMovementPermissionRequest;
import de.ibw.tms.intf.cmd.CheckDbdCommand;
import de.ibw.tms.intf.cmd.CheckMovementPermission;
import de.ibw.tms.intf.messenger.IMovementMessengerIntf;
import de.ibw.util.ThreadedRepo;
import ebd.internal.util.exception.MissingInformationException;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/**
 * Der TMS-Scheduler verwaltet die Szenario-Nachrichten, die an die smartLogic nach einen relativ zum Szenario-Start
 * bezogennen Zeitpunkt in Sekunden die Nachrichten schickt.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.10
 * @since 2021-06-30
 */
public class TmsScheduler {

    private static long lTaskCounter = 1L;

    /**
     * ein flag das anzeigt, ob der TMS-Scheduler bereits aktiv gestartet wurde
     */
    public static boolean started = false;

    private TimeTaskRepository TaskRepo;

    private ArrayList<TimeTaskDAO> tasks = new ArrayList<>();
    private ArrayList<TimeTaskDAO> todoTasks = new ArrayList<>();

    private ThreadedRepo<Long, ScheduledFuture> futureTasks = new ThreadedRepo();
    private TaskScheduler scheduler;
    private SmartLogicClient Client;

    private String sTmsId;
    private String sRbcId;

    /**
     * sends Message to smartLogic
     * @param requestMessage -- Message to be send
     */
    public void sendMessageTosmartLogic(TmsMessage requestMessage) {
        Client.CH.sendCommand(requestMessage);
        if(requestMessage instanceof TmsMovementPermissionRequest) {
            TmsJpaApp.TmsMessenger.log((IMovementMessengerIntf) requestMessage);
        }
    }


    /**
     * Schon im Konstruktor des TMS-Schedulers wird die Datenbank nach Befehlen gelesen und vorbereitet.
     * @param smartLogicClient - ein Client der Nachrichten an die smartLogic senden kann
     * @param timeTaskRepository - ein Repository das die Nachrichten der Datenbank haelt
     */
    public TmsScheduler(SmartLogicClient smartLogicClient, TimeTaskRepository timeTaskRepository)
                         {
        this.sTmsId = smartLogicClient.getsTmsId();
        this.sRbcId = smartLogicClient.getsRbcId();
        Client = smartLogicClient;
        this.TaskRepo = timeTaskRepository;
        ScheduledExecutorService localExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduler = new ConcurrentTaskScheduler(localExecutor);
        for(TimeTaskDAO T: this.TaskRepo.findAll()) {
            if(!tasks.contains(T)) {
                tasks.add(T);
                todoTasks.add(T);
            }
        }
    }

    /**
     * Entfernt eine Nachricht (nach senden) aus dem Scheduler.
     * Das unterbindet mehrmaliges senden der gleichen Nachricht
     * @param taskId - id der Nachricht
     */
    public void cancelTask(long taskId) {
        boolean mayInterruptIfRunning = true;
        ScheduledFuture sf = futureTasks.getModel(taskId);
        sf.cancel(mayInterruptIfRunning);
    }

    /**
     * Startet den Scheduler
     * @throws MissingInformationException -- wenn uebergebene Parameter invalid sind
     */
    public void start() throws MissingInformationException {
            if(started) return;
            started = true;
            Iterator<TimeTaskDAO> it = todoTasks.iterator();
            EventBusManager.RootEventBusManger.log("Tasks (count: " + todoTasks.size()  + " ) going to be scheduled",
                    SmartLogic.getsModuleId("TMS Scheduler"));
            while(it.hasNext()) {
                TimeTaskDAO T = it.next();
                long lTime = (long) (T.SendTimeSinceStartInSeconds * 1000 + System.currentTimeMillis());
                Date dScheduledDate = new Date(lTime);

                if(T.CheckDbd != null) {
                    CheckDbdCommand DbdCmd = CheckDbdCmdConverter.convert(T.CheckDbd);
                    TmsDbdCommand CheckDBD = new TmsDbdCommand(this.sTmsId, this.sRbcId, DbdCmd);
                    scheduleMessage(dScheduledDate, CheckDBD);
                }
                if(T.CheckPermission != null) {
                    CheckMovementPermission CheckTask = CheckPermissionConverter.convert(T.CheckPermission);
                    TmsMessage MPR = new TmsMovementPermissionRequest(this.sTmsId, this.sRbcId, CheckTask);
                    scheduleMessage(dScheduledDate, MPR);
                    MaModul.getInstance().addMovementPermissionAuthorityRequest(T.CheckPermission);

                }


            }
    }

    private void scheduleMessage(Date dScheduledDate, TmsMessage Tmp) throws MissingInformationException {
        ScheduledFuture sf = null;
        sf = scheduler.schedule(new PermissionRunnable(this, Client, Tmp, lTaskCounter), dScheduledDate);
        futureTasks.update(lTaskCounter, sf);
        lTaskCounter++;
    }


}
