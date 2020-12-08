package de.ibw.tms.entities.converter;

import de.ibw.tms.entities.DbdCommandDAO;
import de.ibw.tms.intf.cmd.CheckDbdCommand;
import de.ibw.tms.ma.physical.TrackElementStatus;

public class CheckDbdCmdConverter {

    public static CheckDbdCommand convert(DbdCommandDAO dbdCmdOfDB) {
        if(dbdCmdOfDB == null) return null;
        TrackElementStatus TES = new TrackElementStatus();
        TES.statusList = dbdCmdOfDB.statusList;
        CheckDbdCommand Cmd = new CheckDbdCommand(dbdCmdOfDB.sId, TES, dbdCmdOfDB.lPriority);
        Cmd.uuid = dbdCmdOfDB.uuid;
        return Cmd;
    }

}
