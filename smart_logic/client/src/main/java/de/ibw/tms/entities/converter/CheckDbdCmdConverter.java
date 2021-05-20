package de.ibw.tms.entities.converter;

import de.ibw.tms.entities.DbdCommandDAO;
import de.ibw.tms.intf.cmd.CheckDbdCommand;
import de.ibw.tms.ma.physical.TrackElementStatus;

import java.util.ArrayList;

/**
 * Ein Konverter - er setzt den Datenbank-TESC-Befehl in eine Klasse um, die ueber das Netzwerk and die smartLogic
 * geschickt werden kann
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.0
 * @since 2021-05-20
 */
public class CheckDbdCmdConverter {

    /**
     * konvertiert Datenbank-Object in ein Netzwerk-Object fuer TESC-Befehle um
     * @param dbdCmdOfDB - das Datenbank-TESC-Objekt
     * @return - generelles Object für TESC-Befehle
     */
    public static CheckDbdCommand convert(DbdCommandDAO dbdCmdOfDB) {
        if(dbdCmdOfDB == null) return null;
        TrackElementStatus TES = new TrackElementStatus();
        TES.statusList = dbdCmdOfDB.statusList;
        CheckDbdCommand Cmd = new CheckDbdCommand(dbdCmdOfDB.sId, TES, dbdCmdOfDB.lPriority);
        Cmd.uuid = dbdCmdOfDB.uuid;
        return Cmd;
    }

}
