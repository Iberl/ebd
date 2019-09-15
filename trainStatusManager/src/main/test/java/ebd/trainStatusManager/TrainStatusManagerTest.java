package ebd.trainStatusManager;

import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainStatusManagerTest {

    @Test
    public void tsmTest() throws InterruptedException {

        EventBus eventBus = new EventBus();
        Testhandler testhandler = new Testhandler(eventBus);
        TrainStatusManager trainStatusManager = new TrainStatusManager(eventBus, "t1",
                "r1", "u",
                "C:\\intellij-workspace\\etcs\\drivingDynamics\\src\\main\\resources\\Test.json");
        Thread.sleep(7000);
    }
}