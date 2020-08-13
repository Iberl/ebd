package ebd.dbd.client.extension;

import info.dornbach.dbdclient.DBDClient;
/**
 * Wrapper-Classe, sie benutzt den Anlagen-Client und dient nicht zur Simulation der Anlage
 * !Achtung die Anlage kann wirklich bedient werden.
 *
 * Es implementiert das Interface zum Wechsel zwischen Echtanwendung und Simulation der Anlage
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-08
 */
public class RealDbdClient extends DBDClient implements IDbdClientInterface {

}
