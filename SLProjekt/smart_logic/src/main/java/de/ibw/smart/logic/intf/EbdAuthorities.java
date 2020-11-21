package de.ibw.smart.logic.intf;

import de.ibw.tms.etcs.*;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.physical.EdgeOfMap;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.topologie.ApplicationDirection;

import java.util.ArrayList;
/**
 * Inzwischen nicht mehr verwendet deswegen nicht weiter dokumentiert.
 * @deprecated
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
 */
public class EbdAuthorities {
    public static RbcMA EbdMa;
    private static Chainage LeftChainage = new Chainage(0);
    private static Chainage ChTrail = new Chainage(700);
    private static Chainage DrivingChainage = new Chainage(300);


    private static de.ibw.tms.ma.location.SpotLocation BeginLocation;
    private static de.ibw.tms.ma.location.SpotLocation EndLocation;
    private static de.ibw.tms.ma.location.SpotLocation EndOfAuthorityLocation;

    private static EoA eoa;
    private static SectionOfLine Section = new SectionOfLine();

    private static SSP SpeedProfile = new SSP();

    public static void generateEbdMa() {
        EbdMa = new RbcMA("7733");

        generateTrack();


        generateEoA();
        generateGradientProfile();
        generateSpeedProfile();
        generateSupervisedLocation();
        generateTrainMovement();

    }

    private static void generateTrainMovement() {
        TrainMovement TrainMove = new TrainMovement();
        EbdMa.setTrainMovement(TrainMove);
    }

    private static void generateSupervisedLocation() {




    }

    private static void generateSpeedProfile() {

        generateOneSpeedSegment();
        EbdMa.setSpeedProfile(SpeedProfile);
        SpeedProfile.setMovementAuthority(EbdMa);

    }

    private static void generateOneSpeedSegment() {
        NC_CDDIFF nc_cddiff = new NC_CDDIFF();
        nc_cddiff.bDiff = 0;
        NC_DIFF nc_diff = new NC_DIFF();
        nc_diff.bDiff = 0;
        ETCS_SPEED etcsSpeed = new ETCS_SPEED();
        etcsSpeed.bSpeed = 30;

        ETCS_SPEED etcsSpeedEnd = new ETCS_SPEED();
        etcsSpeedEnd.bSpeed = 0;

        //SpeedChange SCbegin = new SpeedChange(LeftChainage, T, Section);

        //SpeedChange SCend = new SpeedChange(DrivingChanage, T, Section);

        SpeedSegment NormalSegment = new SpeedSegment(BeginLocation, EndOfAuthorityLocation, ApplicationDirection.BOTH);
        NormalSegment.setNc_CDDIFF(nc_cddiff);
        NormalSegment.setNc_DIFF(nc_diff);
        //NormalSegment.setSpeedChangeEnd(SCbegin);
        NormalSegment.setV_STATIC(etcsSpeed);
        NormalSegment.setSsp(SpeedProfile);

        SpeedSegment EndSegment =
                new SpeedSegment(EndOfAuthorityLocation, EndOfAuthorityLocation, ApplicationDirection.BOTH);

        EndSegment.setNc_CDDIFF(nc_cddiff);
        EndSegment.setNc_DIFF(nc_diff);
        //EndSegment.setSpeedChangeEnd(SCbegin);
        EndSegment.setV_STATIC(etcsSpeedEnd);
        EndSegment.setSsp(SpeedProfile);

        ArrayList<SpeedSegment> segmentList = new ArrayList<SpeedSegment>();
        segmentList.add(NormalSegment);
        segmentList.add(EndSegment);

        SpeedProfile.setSpeedSegments(segmentList);

    }

    public static void generateEoA() {

        ETCS_DISTANCE etcs_distance = new ETCS_DISTANCE();
        etcs_distance.sDistance = 300;

        //ETCS_TIMER etcs_timer = new ETCS_TIMER();
        //etcs_timer.sTimer

        // left to right rails


    }

    private static void generateTrack() {
        EdgeOfMap LeftEnd = new EdgeOfMap("Left EBD");

    }

    public static void generateGradientProfile() {



    }

}
