package de.ibw.smart.logic.intf;

import de.ibw.tms.etcs.*;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.physical.EdgeOfMap;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.physical.Trail;
import de.ibw.tms.ma.topologie.ApplicationDirection;

import java.util.ArrayList;
/**
 * Inzwischen nicht mehr verwendet deswegen nicht weiter dokumentiert.
 *
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
    private static Trail T;

    private static SpotLocation BeginLocation;
    private static SpotLocation EndLocation;
    private static SpotLocation EndOfAuthorityLocation;

    private static EoA eoa;
    private static SectionOfLine Section = new SectionOfLine();

    private static SSP SpeedProfile = new SSP();

    public static void generateEbdMa() {
        EbdMa = new RbcMA("7733");

        generateTrack();
        BeginLocation = new SpotLocation(LeftChainage,T, Section);
        EndLocation = new SpotLocation(ChTrail, T, Section);
        EndOfAuthorityLocation = new SpotLocation(DrivingChainage, T, Section);

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
        SvL svl = new SvL(DrivingChainage, T, Section);
        svl.setVmax(35);
        svl.setMovementAuthority(EbdMa);
        EbdMa.setSuperviesedLocation(svl);



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

        SpeedChange SCbegin = new SpeedChange(LeftChainage, T, Section);

        //SpeedChange SCend = new SpeedChange(DrivingChanage, T, Section);

        SpeedSegment NormalSegment = new SpeedSegment(BeginLocation, EndOfAuthorityLocation, ApplicationDirection.BOTH);
        NormalSegment.setNc_CDDIFF(nc_cddiff);
        NormalSegment.setNc_DIFF(nc_diff);
        NormalSegment.setSpeedChangeEnd(SCbegin);
        NormalSegment.setV_STATIC(etcsSpeed);
        NormalSegment.setSsp(SpeedProfile);

        SpeedSegment EndSegment =
                new SpeedSegment(EndOfAuthorityLocation, EndOfAuthorityLocation, ApplicationDirection.BOTH);

        EndSegment.setNc_CDDIFF(nc_cddiff);
        EndSegment.setNc_DIFF(nc_diff);
        EndSegment.setSpeedChangeEnd(SCbegin);
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

        eoa = new EoA(DrivingChainage,T, Section);

        eoa.setD_ENDTIMERSTARTLOC(null);
        //eoa.s
        eoa.setDangerPoint(null);
        eoa.setOverlap(null);
        eoa.setQ_DANGERPOINT(false);
        eoa.setQ_ENDTIMER(false);
        eoa.setQ_OVERLAP(false);
        eoa.setQ_scale(Q_SCALE.SCALE_1_M);
        eoa.setV_EMA(27);
        eoa.setT_ENDTIMER(null);
        EbdMa.setEndOfAuthority(eoa);
    }

    private static void generateTrack() {
        EdgeOfMap LeftEnd = new EdgeOfMap("Left EBD");
        LeftEnd.setChainageBeginn(LeftChainage);
        LeftEnd.setChainageEnd(LeftChainage);
        EdgeOfMap RightEnd = new EdgeOfMap("Right - EBD");
        T = new Trail(LeftChainage, ChTrail, LeftEnd, RightEnd, ApplicationDirection.BOTH,150, ApplicationDirection.BOTH, new TrackElementStatus());
    }

    public static void generateGradientProfile() {

        GradientSegment SegmentA = new GradientSegment(BeginLocation,EndLocation, ApplicationDirection.BOTH);
        ETCS_GRADIENT normalGradient = new ETCS_GRADIENT();
        normalGradient.bGradient = 0;
        SegmentA.setGradient(normalGradient, true);
        GradientProfile GP = new GradientProfile(EbdMa);

        GP.addSegment(SegmentA);
        EbdMa.setGradientProfile(GP);

    }

}
