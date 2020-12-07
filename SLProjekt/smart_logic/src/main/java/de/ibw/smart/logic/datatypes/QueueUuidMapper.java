package de.ibw.smart.logic.datatypes;

import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.util.ThreadedRepo;

import java.util.UUID;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
/**
 * Diese Klasse verwaltet Warteschlangen f&uuml;r eine Nachricht-UUID (Komminikationsverlauf). Die UUID wird f&uuml;r die Kommunitkation zum RBC verwendet. Man kann dadurch registrieren ob ein RBC schon eine Nachricht empfangen hat, weil dann ein Acknowledge gesendet wird.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
 */
public class QueueUuidMapper {

    private ThreadedRepo<UUID, SynchronousQueue<Boolean>> queue4UUid = new ThreadedRepo<>();

    /**
     * Diese Methode f&uuml;gt eine neue Warteschlange f&uuml;r eine UUID zur Verwaltung ein.
     * @param uuid - Id des Kommunikationsverlaufs
     */
    public void createQueue(UUID uuid) {
        queue4UUid.update(uuid, new SynchronousQueue<>());
    }

    /**
     * Diese Methode wartet bis zu einem Timeout auf ein Acknowledge und gibt Erfolg oder eine Fehlen einer Antowort als
     * Boolean zurück.
     * @param uuid - Id der verfolgten Kommunikation
     * @return Boolean - ist Acknowledge eingegangen
     * @throws InterruptedException - wird geworfen, wenn beim poll der Warteschlange es Interrupt gab
     */
    public Boolean poll(UUID uuid) throws InterruptedException {
        Boolean b = queue4UUid.getModel(uuid).poll(SmartLogic.TIMEOUT_SETTING_WAITING_MA_ACK_IN_SECONDS, TimeUnit.SECONDS);
        return b;
    }

    /**
     * Diese Methode schreibt den Eingang eines Acknowledge in die Warteschlange der gegebenen UUID als Boolean
     * @param uuid - Der Kommunikationsverlauf
     * @param b - Der Erfolg eines Acknowledge
     * @throws InterruptedException - wird geworfen wenn beim offer ein Interrupt erfolgt
     */
    public void offer(UUID uuid, Boolean b) throws InterruptedException {
        queue4UUid.getModel(uuid).offer(b, SmartLogic.TIMEOUT_SETTING_WAITING_MA_ACK_IN_SECONDS, TimeUnit.SECONDS);
    }
}
