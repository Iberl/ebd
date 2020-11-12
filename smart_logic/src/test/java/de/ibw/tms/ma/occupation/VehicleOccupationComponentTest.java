package de.ibw.tms.ma.occupation;

import de.ibw.main.SmartLogicClient;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.smart.logic.safety.SafetyLogic;
import de.ibw.tms.intf.SmartClient;
import de.ibw.util.DefaultRepo;
import ebd.core.Core;
import ebd.core.util.events.LoadEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleOccupationComponentTest {

    private SmartLogicClient SC = new SmartLogicClient();
    private Core C = new Core();

    private class smartLogicThread extends Thread {
        @Override
        public void run() {
            SmartLogic.main(null);
        }
    }
    private class RbcThread extends Thread {
        @Override
        public void run() {
            C.load(new LoadEvent("szenario", "szenario"));
        }
    }

    @Test
    public void initTestEnv() throws InterruptedException {
        new smartLogicThread().start();
        Thread.sleep(3000);
        SC.start();
        Thread.sleep(3000);
        //new RbcThread().start();
        while(true);


    }


}