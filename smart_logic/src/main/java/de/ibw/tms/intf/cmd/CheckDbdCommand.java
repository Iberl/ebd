package de.ibw.tms.intf.cmd;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.physical.TrackElementStatus;

import javax.xml.transform.sax.SAXResult;
import java.util.Objects;
import java.util.UUID;

/**
 * Dieser Befehl entsteht im TMS und weist die SL an diesen Weichenstellbefehl zu prüfen.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-12
 */
public class CheckDbdCommand extends Commands {

    /**
     * UUid
     */
    @Expose
    public UUID uuid;

    /**
     * Node-ID (Topologisch) der Weiche
     */
    @Expose
    public String sId;

    /**
     * Status der Weiche der gesetzt werden soll und von der SL gepr&uuml;ft werden soll
     */
    @Expose
    public TrackElementStatus TrackElementStatus;

    /**
     * Priorität des Befehls
     */
    @Expose
    public Long lPriority;

    /**
     * Erstellt einen Aufruf f&uuml;r Unterklassen bereit.
     *
     * @param lPriority long - Priority dieses Befehls im TMS Postausgang.
     */
    public CheckDbdCommand(String sId, TrackElementStatus Status , long lPriority) {
        super(lPriority);
        this.sId = sId;
        this.TrackElementStatus = Status;
        this.lPriority = lPriority;
        this.CommandType = Commands.S_CHECK_DBD_COMMAND;
        this.uuid = UUID.randomUUID();
    }


    public String printStatus() {
        StringBuilder sResult = new StringBuilder();
        if(TrackElementStatus == null) return "";
        if(TrackElementStatus.statusList.isEmpty()) return "";
        for(de.ibw.tms.ma.physical.TrackElementStatus.Status Stat : TrackElementStatus.statusList) {
            if(Stat == null) {
                sResult.append("E");
            } else if(Stat.equals(de.ibw.tms.ma.physical.TrackElementStatus.Status.LEFT)) {
                sResult.append("L");
            } else if(Stat.equals(de.ibw.tms.ma.physical.TrackElementStatus.Status.RIGHT)) {
                sResult.append("R");
            } else {
                sResult.append("U");
            }
        }
        return sResult.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckDbdCommand that = (CheckDbdCommand) o;
        return sId.equals(that.sId) &&
                TrackElementStatus == that.TrackElementStatus &&
                lPriority.equals(that.lPriority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, TrackElementStatus, lPriority);
    }

    @Override
    public String toString() {
        return "CheckDbdCommand{" +
                "sId='" + sId + '\'' +
                ", TrackElementStatus=" + TrackElementStatus +
                ", lPriority=" + lPriority +
                '}';
    }



}
