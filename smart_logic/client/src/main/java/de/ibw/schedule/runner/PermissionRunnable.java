package de.ibw.schedule.runner;

import de.ibw.main.SmartLogicClient;
import de.ibw.schedule.TmsScheduler;
import de.ibw.tms.entities.TimeTaskDAO;
import de.ibw.tms.entities.TmsJpaApp;
import de.ibw.tms.intf.TmsMessage;
import de.ibw.tms.intf.TmsMovementPermissionRequest;
import de.ibw.tms.intf.messenger.IMovementMessengerIntf;
import ebd.rbc_tms.util.exception.MissingInformationException;

public class PermissionRunnable implements Runnable {
    private TmsScheduler scheduler;
    private SmartLogicClient client;
    private TmsMessage requestMessage;
    private long lTaskId;

    public PermissionRunnable(TmsScheduler tmsScheduler, SmartLogicClient client, TmsMessage T,
                              long lTaskCounter) throws MissingInformationException {
        this.scheduler = tmsScheduler;
        this.client = client;
        this.requestMessage = T;
        this.lTaskId = lTaskCounter;
    }



    @Override
    public void run() {

        try {
            client.CH.sendCommand(requestMessage);
            if(requestMessage instanceof TmsMovementPermissionRequest) {
                TmsJpaApp.TmsMessenger.log((IMovementMessengerIntf) requestMessage);
            }
        } catch (MissingInformationException e) {
            e.printStackTrace();

        }

        scheduler.cancelTask(lTaskId);

    }
}
