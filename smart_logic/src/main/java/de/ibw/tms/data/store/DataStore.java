package de.ibw.tms.data.store;

import de.ibw.util.DefaultRepo;
import de.ibw.util.ThreadedRepo;
import ebd.rbc_tms.payload.Payload_14;

import java.security.InvalidParameterException;
/**
 * Noch nicht implementiert
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class DataStore {
    private static DataStore instance;
    public static DataStore getInstance() {
        if(instance == null) {
            instance = new DataStore();
        }
        return instance;
    }



    private ThreadedRepo<Integer, Payload_14> PositionRepo = new ThreadedRepo<>();

    public synchronized DefaultRepo getPositionRepo() {
        return PositionRepo;
    }
    public synchronized void update(Payload_14 position) {
        Integer iNidEngine = null;
        try {
            iNidEngine = position.trainInfo.nid_engine;
        } catch(Exception E) {
            E.printStackTrace();
            throw new InvalidParameterException("Position Report not valid.");
        }

        PositionRepo.update(iNidEngine, position);
    }

}
