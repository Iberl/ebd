package de.ibw.smart.logic.datatypes;

import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.smart.logic.intf.SmartLogicTmsProxy;
import de.ibw.util.ThreadedRepo;

import java.util.UUID;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class QueueUuidMapper {

    private ThreadedRepo<UUID, SynchronousQueue<Boolean>> queue4UUid = new ThreadedRepo<>();
    public void createQueue(UUID uuid) {
        queue4UUid.update(uuid, new SynchronousQueue<>());
    }
    public Boolean poll(UUID uuid) throws InterruptedException {
        Boolean b = queue4UUid.getModel(uuid).poll(SmartLogic.TIMEOUT_SETTING_WAITING_MA_ACK_IN_SECONDS, TimeUnit.SECONDS);
        return b;
    }
    public void offer(UUID uuid, Boolean b) throws InterruptedException {
        queue4UUid.getModel(uuid).offer(b, SmartLogic.TIMEOUT_SETTING_WAITING_MA_ACK_IN_SECONDS, TimeUnit.SECONDS);
    }
}
