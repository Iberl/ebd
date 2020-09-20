package ebd.drivingDynamics;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DrivingProfileTest {

    @BeforeAll
    static void setTrainDataVolatile(){
        Testhandler testhandler = new Testhandler();
        TrainDataVolatile trainDataVolatile = new TrainDataVolatile(1620, 192, 2181, EventBus.getDefault());
        EventBus.getDefault().postSticky(new NewTrainDataVolatileEvent("test", "", trainDataVolatile));

    }


    void actionToTake() throws ParseException, DDBadDataException, IOException {
        DrivingStrategy drivingStrategy = new DrivingStrategy(EventBus.getDefault());
        assertEquals("BreakAction", drivingStrategy.actionToTake().getClass().getSimpleName());
    }
}