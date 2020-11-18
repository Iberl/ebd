package de.ibw.smart.logic.intf;

import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.topologie.ApplicationDirection;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EbdAuthoritiesTest {



    void generateEbdMa() {
        EbdAuthorities.generateEbdMa();
        RbcMA MUT = EbdAuthorities.EbdMa;
        assertTrue(MUT.sTrainId.equals("7733"));
        EoA Eoa = MUT.getEndOfAuthority();
        //checkEoA(Eoa);
        GradientProfile GP = MUT.getGradientProfile();
        //checkGradient(GP);
        SSP SpeedProfile = MUT.getSpeedProfile();
        checkSpeed(SpeedProfile);
        SvL svl = MUT.getSuperviesedLocation();
        assertTrue(svl.getMovementAuthority() == MUT);
        assertTrue(svl.getVmax() == 35);
        assertNotNull(MUT.getTrainMovement());

    }

    private void checkSpeed(SSP SpeedMUT) {
        assertTrue(SpeedMUT.getMovementAuthority() == EbdAuthorities.EbdMa);

        List<SpeedSegment> speedList = SpeedMUT.getSpeedSegments();
        assertTrue(speedList.size() == 2);
        SpeedSegment segmentA = speedList.get(0);
        assertTrue(segmentA.getNc_CDDIFF().bDiff == 0);
        assertTrue(segmentA.getNc_DIFF().bDiff == 0);
        //assertNotNull(segmentA.getSpeedChangeEnd());
        assertTrue( segmentA.getSsp() == SpeedMUT);
        assertTrue(segmentA.getV_STATIC().bSpeed == 30);
        SpeedSegment segmentB = speedList.get(1);
        assertTrue(segmentB.getNc_CDDIFF().bDiff == 0);
        assertTrue(segmentB.getNc_DIFF().bDiff == 0);
        //assertNotNull(segmentB.getSpeedChangeEnd());
        assertTrue( segmentB.getSsp() == SpeedMUT);
        assertTrue(segmentB.getV_STATIC().bSpeed == 0);


    }
/*
    private void checkGradient(GradientProfile gpMUT) {
        assertTrue(gpMUT.getMovementAuthority() == EbdAuthorities.EbdMa);
        assertTrue(gpMUT.getSegmentList().size() == 1);
        GradientSegment A = gpMUT.getSegmentList().get(0);
        assertTrue(A.getG_A().bGradient == 0);
        assertTrue(A.getBegin().getChainage().getiMeters() == 0);
        assertTrue(A.getEnd().getChainage().getiMeters() == 700);
        assertTrue(A.getDirection() == ApplicationDirection.BOTH);
        assertTrue(A.isQ_GDIR());


    }

    void checkEoA(EoA eoaMUT) {
        assertNull(eoaMUT.getDangerPoint());
        assertNull(eoaMUT.getD_ENDTIMERSTARTLOC());
        assertNull(eoaMUT.getOverlap());
        assertTrue(eoaMUT.getQ_scale() == Q_SCALE.SCALE_1_M);
        assertFalse(eoaMUT.isQ_DANGERPOINT());
        assertFalse(eoaMUT.isQ_ENDTIMER());
        assertFalse(eoaMUT.isQ_OVERLAP());
        assertTrue(eoaMUT.getChainage().getiMeters() == 300);

    }
*/

}