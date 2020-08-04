package de.ibw.tms.intf.cmd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.train.model.TrainModel;
import ebd.rbc_tms.util.exception.MissingInformationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CheckMovementAuthority extends Commands {

    @Expose
    public MaRequestWrapper MaRequest;
    @Expose
    public RbcMaAdapter MaAdapter;

    @Expose
    public UUID uuid;
    @Expose
    public String tms_id;
    @Expose
    public String rbc_id;
    @Expose
    public Long lPriority;



    public CheckMovementAuthority(long lPriority) {
        super(lPriority);
        this.lPriority = lPriority;
        this.CommandType = Commands.S_CHECK_MOVEMENT_AUTHORITY;
    }

    /**
     * Parse Command to String
     * @return String
     * @throws MissingInformationException
     */
    public String parseToJson() throws MissingInformationException {


            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            // Check For Correct Values
            // Only Accordingly Annotated Fields Aan Hold The Null Value
            // Lists Must Have A Minimum Of 1 Element
            //ClassAnalysis.checkValues(this);

            // Serialize Message
            return gson.toJson(this);

    }

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

    @Override
    public int hashCode() {
        return Objects.hash(CommandType, MaRequest, MaAdapter, uuid, tms_id, rbc_id, lPriority);
    }

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
