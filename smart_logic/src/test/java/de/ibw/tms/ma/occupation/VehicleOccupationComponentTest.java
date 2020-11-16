package de.ibw.tms.ma.occupation;

import de.ibw.history.PositionModul;
import de.ibw.main.SmartLogicClient;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.smart.logic.safety.SafetyLogic;
import de.ibw.tms.intf.SmartClient;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.util.DefaultRepo;
import ebd.core.Core;
import ebd.core.util.events.LoadEvent;
import ebd.globalUtils.configHandler.ConfigHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VehicleOccupationComponentTest {

    private SmartLogicClient SC = new SmartLogicClient();
    private Core C = null;

    @Spy
    PositionModul PosMod = PositionModul.getInstance();

    private class smartLogicThread extends Thread {
        @Override
        public void run() {
            SmartLogic.main(null);
        }
    }
    private class RbcThread extends Thread {
        @Override
        public void run() {

            if (ConfigHandler.getInstance() == null){
                System.out.println("Config Handler could not be opened");
                System.exit(0);
            }
            C = new Core();
            C.load(new LoadEvent("szenario", "szenario"));
        }
    }

    @Test
    public void initTestEnv() throws InterruptedException {
        new smartLogicThread().start();
        Thread.sleep(3000);
        SC.start();
        Thread.sleep(3000);
        new RbcThread().start();
        Thread.sleep(4000);
        assertTrue(PosMod.getCurrentPositions().size() > 0,
                "Es wurden keine Züge registriert FEHLER." );
        System.out.println("Vehicle Report Count: " + PosMod.getCurrentPositions().size());
        VehicleOccupation VO = new ArrayList<>(PosMod.getCurrentPositions()).get(0);
        testprint(VO);
    }

    private void testprint(VehicleOccupation vo) {
        SpotLocationIntrinsic begin = (SpotLocationIntrinsic) vo.getBegin().getLocation();
        SpotLocationIntrinsic end = (SpotLocationIntrinsic) vo.getEnd().getLocation();
        System.out.println("Beginfactor: " + begin.getIntrinsicCoord());
        System.out.println("Endfactor: " + end.getIntrinsicCoord());
        TrackEdgeSection TES = vo.getTrackEdgeSections().get(0);
        assertEquals(TES.getBegin(), begin);
        assertEquals(TES.getEnd(), end);
    }


}