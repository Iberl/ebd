package de.ibw.modules;

import de.ibw.tms.entities.CheckMovementPermissionDAO;
import de.ibw.tms.intf.TmsMessage;
import de.ibw.tms.intf.TmsMovementPermissionRequest;
import de.ibw.util.ThreadedRepo;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MaModul {

    private static MaModul instance = null;


    public static MaModul getInstance() {
        if(instance == null) instance = new MaModul();
        return instance;
    }

    private ThreadedRepo<UUID, CheckMovementPermissionDAO> requestedMovmentPermissionRepo = new ThreadedRepo<>();

    public void addMovementPermissionAuthorityRequest(CheckMovementPermissionDAO mpr) {
        requestedMovmentPermissionRepo.update(mpr.uuid, mpr);
    }
}
