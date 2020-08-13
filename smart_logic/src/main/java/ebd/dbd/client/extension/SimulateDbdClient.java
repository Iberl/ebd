package ebd.dbd.client.extension;

import de.ibw.util.DefaultRepo;
import info.dornbach.dbdclient.DBDListener;

import java.io.IOException;
import java.net.UnknownHostException;
/**
 *
 * Es implementiert das Interface zum Wechsel zwischen Echtanwendung und Simulation der Anlage
 * Diese Klasse simuliert die Anlage
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-08
 */
public class SimulateDbdClient implements IDbdClientInterface {
    DefaultRepo<String, Integer> StatusRepository = new DefaultRepo<>();


    SimulateDbdClient(DefaultRepo<String, Integer> fakeRepo) {
        this.StatusRepository = fakeRepo;
    }

    /**
     * unused
     * @param host
     * @param port
     * @throws UnknownHostException
     * @throws IOException
     */

    @Override
    public void connect(String host, int port) throws UnknownHostException, IOException {
        return;
    }

    /**
     * unused
     * @param name
     */

    @Override
    public void subscribeAndQuery(String name) {
        return;
    }

    /**
     * Gibt werte aus der internen Datenhaltung wider. Keine Daten der Anlage
     * @param name String - angefordertes Object der Simulierten Anlage
     * @param defaultValue int - Wert der Anforderung
     * @return int
     */
    @Override
    public int getValue(String name, int defaultValue) {
        Integer iResult = StatusRepository.getModel(name);
        if(iResult == null) return 0;
        return iResult;
    }

    /**
     * &Auml;ndert Wert in der internen Datenhaltung
     * @param name String - zu &auml;nderndes Object der Simulierten Anlage
     * @param value int - neuer Wert der simulierten Anlage
     */

    @Override
    public void setValue(String name, int value) {
        this.StatusRepository.update(name,value);
    }

    /**
     * unused
     * @param l
     */
    @Override
    public void addDBDListener(DBDListener l) {

    }

    /**
     * unused
     * @param name
     * @param l
     */

    @Override
    public void addDBDListener(String name, DBDListener l) {

    }
}
