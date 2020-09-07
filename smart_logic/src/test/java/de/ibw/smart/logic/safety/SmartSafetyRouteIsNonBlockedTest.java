package de.ibw.smart.logic.safety;

import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.smart.logic.safety.self.tests.TestUtil;
import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import ebd.rbc_tms.util.EOA;
import ebd.rbc_tms.util.ETCSVariables;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Die Smart-Logic hat ein Submodul, das pr&uuml;ft, ob blockierte Elemente vorhanden sind.
 * Dieser Test stellt die funktionale Korrektheit sicher
 */
class SmartSafetyRouteIsNonBlockedTest {



    @Test
    public void checkIfMainNullError() {
        initTestEnv();
        SmartSafety ModulUnderTest = SmartSafety.getSmartSafety();
        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListe =
            TestUtil.generateRandomContinousRoute(3, true);
        TopologyGraph.Edge E = (TopologyGraph.Edge) routenListe.get(0).getValue();
        TopologyGraph.Node N = (TopologyGraph.Node) routenListe.get(1).getValue();




        EOA eoa = new EOA(0,0, Q_SCALE.SCALE_1_M.flag, 0,null,null, null);
        eoa.sections = new ArrayList<>();
        eoa.sections.add(new EOA.Section(300,false,null,null));
        eoa.endTimer = new EOA.EndTimer(ETCSVariables.T_ENDTIMER_INFINITY, ETCSVariables.D_ENDTIMERSTARTLOC);
        EoaAdapter eoaAda = new EoaAdapter(eoa);

        RbcMaAdapter RbcMa = TestUtil.preserveMA4NonBlockedTest(eoaAda, Q_SCALE.SCALE_1_M.flag);
        MaRequestWrapper MRW = TestUtil.preserveRequest4NonBlockedTest(1,100d, E.sId,
               N.TopNodeId , 10);


        try {
            ModulUnderTest.checkIfRouteIsNonBlocked(null, RbcMa, routenListe);
            assertEquals("Exception", false);
        } catch(Exception Ex) {
            assert(true);
        }
        try {
            ModulUnderTest.checkIfRouteIsNonBlocked(MRW, RbcMa, null);
            assertEquals("Exception", false);
        } catch(Exception Ex) {
            assert(true);
        }
        try {
            ModulUnderTest.checkIfRouteIsNonBlocked(null, RbcMa, routenListe);
            assertEquals("Exception", false);
        } catch(Exception Ex) {
            assert(true);
        }
    }

    private void initTestEnv() {
        SmartLogic.main(null);

    }
}