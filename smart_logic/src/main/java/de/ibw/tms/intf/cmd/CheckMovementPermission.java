package de.ibw.tms.intf.cmd;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.trackplan.ui.Route;
import ebd.internal.util.exception.MissingInformationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
/**
 * Dieser Befehl entsteht im TMS und weist die smartLogic an, die beinhaltete MA zu pr&uuml;fen.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.10
 * @since 2020-06-16
 */
public class CheckMovementPermission extends Commands {
    public static long DEFAULT_PRIO = 3L;


    @Expose
    public Route route;

    @Expose
    public int iTrainId;




    /**
     * Nachricht an das RBC
     */

    @Expose
    public RbcMaAdapter MaAdapter;

    /**
     * Kommunikations UUid
     */

    @Expose
    public UUID uuid;

    /**
     * Id des TMS
     */

    @Expose
    public String tms_id;

    /**
     * Id des RBC
     */

    @Expose
    public String rbc_id;
    /**
     * Priority dieser Nachricht im Postausgang des TMS
     */
    @Expose
    public Long lPriority;


    /**
     * Dieser Konstruktor erstellt einen neuen leeren Check-Befehl mit einer Priority
     * @param lPriority long - Priority im TMS Postausgang
     */
    public CheckMovementPermission(long lPriority) {
        super(lPriority);
        this.lPriority = lPriority;
        this.CommandType = Commands.S_CHECK_MOVEMENT_PERMISSION;
    }
    public CheckMovementPermission() {
        super(DEFAULT_PRIO);
    }

    @Override
    public String toString() {
        return "CheckMovementPermission{" +
                "route=" + route +
                ", iTrainId=" + iTrainId +
                ", MaAdapter=" + MaAdapter +
                ", uuid=" + uuid +
                ", tms_id='" + tms_id + '\'' +
                ", rbc_id='" + rbc_id + '\'' +
                ", lPriority=" + lPriority +
                ", lPriority=" + lPriority +
                ", CommandType='" + CommandType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckMovementPermission that = (CheckMovementPermission) o;
        return iTrainId == that.iTrainId &&
                route.equals(that.route) &&
                MaAdapter.equals(that.MaAdapter) &&
                uuid.equals(that.uuid) &&
                tms_id.equals(that.tms_id) &&
                rbc_id.equals(that.rbc_id) &&
                lPriority.equals(that.lPriority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, iTrainId, MaAdapter, uuid, tms_id, rbc_id, lPriority);
    }


    public int getiTrainId() {
        return iTrainId;
    }

    public void setiTrainId(int iTrainId) {
        this.iTrainId = iTrainId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTms_id() {
        return tms_id;
    }

    public void setTms_id(String tms_id) {
        this.tms_id = tms_id;
    }

    public String getRbc_id() {
        return rbc_id;
    }

    public void setRbc_id(String rbc_id) {
        this.rbc_id = rbc_id;
    }

    public Long getlPriority() {
        return lPriority;
    }

    public void setlPriority(Long lPriority) {
        this.lPriority = lPriority;
    }

    //testmain
    public static void main(String[] args) throws MissingInformationException {
        CheckMovementPermission cma = getDummyMovementAuthorityCommand();
        System.out.println(cma.parseToJson());
    }

    /**
     * @deprecated
     * @return
     */
    public static CheckMovementPermission getDummyMovementAuthorityCommand() {
        CheckMovementPermission cma = new CheckMovementPermission(3L);
        //return null;




        MovementAuthority MA = new MovementAuthority();

        SSP ssp = new SSP();
        List<SpeedSegment> speedSegmentList = new ArrayList<>();
        de.ibw.tms.ma.location.SpotLocation sl = new SpotLocation(new Chainage(100), null,null);
        SpeedSegment speedSegment = new SpeedSegment(sl,sl, ApplicationDirection.BOTH);
        speedSegmentList.add(speedSegment);
        ssp.setSpeedSegments(speedSegmentList);
        MA.setSpeedProfile(ssp);



        return cma;


    }

}
