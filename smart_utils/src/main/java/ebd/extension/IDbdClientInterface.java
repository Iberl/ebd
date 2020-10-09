package ebd.extension;

import info.dornbach.dbdclient.DBDClient;
import info.dornbach.dbdclient.DBDListener;
import info.dornbach.dbdclient.Datagram;

import java.io.IOException;
import java.net.UnknownHostException;
/**
 * Interface eines DBD-Clients
 * Dient zum Simulieren der Anlage, wenn man nicht im EBD ist
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-08
 */
public interface IDbdClientInterface {

    void connect(String host, int port) throws UnknownHostException, IOException;

    void subscribeAndQuery(String name);

    int getValue(String name, int defaultValue);

    void setValue(String name, int value);



    void addDBDListener(DBDListener l);

    void addDBDListener(String name, DBDListener l);


    default void defaultEbdConect() throws IOException {
        this.connect("server1.ebd.signallabor.de", 1436);
    }

}
