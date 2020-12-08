package de.ibw.schedule;

import de.ibw.main.SmartLogicClient;
import de.ibw.schedule.runner.PermissionRunnable;
import de.ibw.tms.entities.TimeTaskDAO;
import de.ibw.tms.entities.TimeTaskRepository;
import de.ibw.tms.entities.converter.CheckDbdCmdConverter;
import de.ibw.tms.entities.converter.CheckPermissionConverter;
import de.ibw.tms.intf.TmsDbdCommand;
import de.ibw.tms.intf.TmsMovementPermissionRequest;
import de.ibw.tms.intf.cmd.CheckDbdCommand;
import de.ibw.tms.intf.cmd.CheckMovementPermission;
import de.ibw.util.DefaultRepo;
import de.ibw.util.ThreadedRepo;
import ebd.rbc_tms.util.exception.MissingInformationException;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 03.12.2020
 */
public class TmsScheduler {

    private static long lTaskCounter = 1L;

    public static boolean started = false;

    private TimeTaskRepository TaskRepo;

    private ArrayList<TimeTaskDAO> tasks = new ArrayList<>();
    private ArrayList<TimeTaskDAO> todoTasks = new ArrayList<>();

    private ThreadedRepo<Long, ScheduledFuture> futureTasks = new ThreadedRepo();
    private TaskScheduler scheduler;
    private SmartLogicClient Client;

    private String sTmsId;
    private String sRbcId;





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


    public void cancelTask(long taskId) {
        boolean mayInterruptIfRunning = true;
        ScheduledFuture sf = futureTasks.getModel(taskId);
        sf.cancel(mayInterruptIfRunning);
    }


    public void start() throws MissingInformationException {
            if(started) return;
            started = true;
            Iterator<TimeTaskDAO> it = todoTasks.iterator();
            while(it.hasNext()) {
                TimeTaskDAO T = it.next();
                long lTime = (long) (T.SendTimeSinceStartInSeconds * 1000 + System.currentTimeMillis());
                Date dScheduledDate = new Date(lTime);

                if(T.CheckDbd != null) {
                    CheckDbdCommand DbdCmd = CheckDbdCmdConverter.convert(T.CheckDbd);
                    TmsDbdCommand CheckDBD = new TmsDbdCommand(this.sTmsId, this.sRbcId, DbdCmd);
                }

                CheckMovementPermission CheckTask = CheckPermissionConverter.convert(T.CheckPermission);
                TmsMovementPermissionRequest Tmp = new TmsMovementPermissionRequest(this.sTmsId, this.sRbcId, CheckTask);

                ScheduledFuture sf = null;
                try {
                    sf = scheduler.schedule(new PermissionRunnable(this, Client, Tmp, lTaskCounter), dScheduledDate);
                } catch (MissingInformationException e) {
                    e.printStackTrace();
                    futureTasks.update(lTaskCounter, sf);
                    lTaskCounter++;
                    throw new MissingInformationException(e.getMessage());
                }
                futureTasks.update(lTaskCounter, sf);
                lTaskCounter++;
                it.remove();
            }


    }



}
