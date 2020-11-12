package de.ibw.tms.intf.cmd;

import com.google.gson.annotations.Expose;
import de.ibw.tms.plan.elements.BranchingSwitch;
import ebd.rbc_tms.util.exception.MissingInformationException;

import java.util.Objects;

/**
 * Dieser Befehl entsteht im TMS und weist die SL an diesen Weichenstellbefehl zu prüfen.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-12
 */
public class CheckDbdCommand extends Commands {



    /**
     * Node-ID (Topologisch) der Weiche
     */
    @Expose
    public String sId;

    /**
     * Status der Weiche der gesetzt werden soll und von der SL gepr&uuml;ft werden soll
     */
    @Expose
    public BranchingSwitch.SwitchStatus SwitchStatus;

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
    public CheckDbdCommand(String sCrossoverEbdName, String sId, BranchingSwitch.SwitchStatus Status , long lPriority) {
        super(lPriority);
        this.sId = sId;
        this.SwitchStatus = Status;
        this.lPriority = lPriority;
        this.CommandType = Commands.S_CHECK_DBD_COMMAND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckDbdCommand that = (CheckDbdCommand) o;
        return sId.equals(that.sId) &&
                SwitchStatus == that.SwitchStatus &&
                lPriority.equals(that.lPriority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, SwitchStatus, lPriority);
    }

    @Override
    public String toString() {
        return "CheckDbdCommand{" +
                "sId='" + sId + '\'' +
                ", SwitchStatus=" + SwitchStatus +
                ", lPriority=" + lPriority +
                '}';
    }

    public static void main(String[] args) throws MissingInformationException {
        CheckDbdCommand DbdCmd = new CheckDbdCommand("TestW12","123", BranchingSwitch.SwitchStatus.LEFT, 1L);
        System.out.println(DbdCmd.parseToJson());
    }

}
