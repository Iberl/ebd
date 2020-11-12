package de.ibw.tms.intf.cmd;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.train.model.TrainModel;
import ebd.rbc_tms.util.exception.MissingInformationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
/**
 * Dieser Befehl entsteht im TMS und weist die SL die beinhaltete MA zu pr&uuml;fen.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class CheckMovementAuthority extends Commands {

    /**
     * Ma to check
     */

    @Expose
    public MaRequestWrapper MaRequest;

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
    public CheckMovementAuthority(long lPriority) {
        super(lPriority);
        this.lPriority = lPriority;
        this.CommandType = Commands.S_CHECK_MOVEMENT_AUTHORITY;
    }



    /**
     * Std String widergabe
     * @return String - dieser Nachricht.
     */
    @Override
    public String toString() {
        return "CheckMovementAuthority{" +
                "MaRequest=" + MaRequest +
                ", MaAdapter=" + MaAdapter +
                ", uuid=" + uuid +
                ", tms_id='" + tms_id + '\'' +
                ", rbc_id='" + rbc_id + '\'' +
                ", lPriority=" + lPriority +
                '}';
    }

    /**
     * Hashcode dieser Nachricht
     * @return int - hashcode
     */

    @Override
    public int hashCode() {
        return Objects.hash(CommandType, MaRequest, MaAdapter, uuid, tms_id, rbc_id, lPriority);
    }

    /**
     * Vergleich ob dieser Befehl und o derselbe sei.
     * @param o {@link Object} - Vergleichsobject
     * @return boolean - ist dieser Befehl derselbe wie o
     */

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        CheckMovementAuthority that = (CheckMovementAuthority) o;
        return Objects.equals(CommandType, that.CommandType) && Objects.equals(MaRequest, that.MaRequest) &&
                Objects.equals(MaAdapter, that.MaAdapter) && Objects.equals(uuid, that.uuid) && Objects.equals(tms_id, that.tms_id) &&
                Objects.equals(rbc_id, that.rbc_id) && Objects.equals(lPriority, that.lPriority);
    }

    //testmain
    public static void main(String[] args) throws MissingInformationException {
        CheckMovementAuthority cma = getDummyMovementAuthorityCommand();
        System.out.println(cma.parseToJson());
    }

    public static CheckMovementAuthority getDummyMovementAuthorityCommand() {
        CheckMovementAuthority cma = new CheckMovementAuthority(3L);
        //return null;
        MARequest mar = new MARequest();



        MovementAuthority MA = new MovementAuthority();

        SSP ssp = new SSP();
        List<SpeedSegment> speedSegmentList = new ArrayList<>();
        SpotLocation sl = new SpotLocation(new Chainage(100), null,null);
        SpeedSegment speedSegment = new SpeedSegment(sl,sl, ApplicationDirection.BOTH);
        speedSegmentList.add(speedSegment);
        ssp.setSpeedSegments(speedSegmentList);
        MA.setSpeedProfile(ssp);

        mar.setMa(MA);
        TrainModel TM = TrainModel.getDefaultModel();
        cma.MaRequest = new MaRequestWrapper(mar);
        cma.MaRequest.Tm = TM;
        return cma;


    }

}
