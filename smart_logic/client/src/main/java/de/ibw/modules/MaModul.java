package de.ibw.modules;

import de.ibw.tms.entities.CheckMovementPermissionDAO;
import de.ibw.tms.intf.TmsMessage;
import de.ibw.tms.intf.TmsMovementPermissionRequest;
import de.ibw.util.ThreadedRepo;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Verwaltet Movement Permission Anfragen, die gestellt wurden.
 * Dadurch koennen Antworten der smartLogic ueber die Kommunikations-Id mit einem Request in Verbindung gebracht werden.
 */
public class MaModul {

    private static MaModul instance = null;

    /**
     * Singleton dieser Klasse
     * @return MaModul
     */
    public static MaModul getInstance() {
        if(instance == null) instance = new MaModul();
        return instance;
    }

    private ThreadedRepo<UUID, CheckMovementPermissionDAO> requestedMovmentPermissionRepo = new ThreadedRepo<>();

    /**
     * speichert einen Permission Request ueber die Kommunikations-Id
     * @param mpr - Movement Permission Request der gehalten werden soll.
     */
    public void addMovementPermissionAuthorityRequest(CheckMovementPermissionDAO mpr) {
        requestedMovmentPermissionRepo.update(mpr.uuid, mpr);
    }
}
