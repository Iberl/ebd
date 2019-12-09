package ebd.drivingDynamics;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DrivingProfileTest {

    @BeforeAll
    static void setTrainDataVolatile(){
        Testhandler testhandler = new Testhandler();
        ConfigHandler.getInstance().testing = true;
        TrainDataVolatile trainDataVolatile = new TrainDataVolatile(null, 33d, 34d, null, null, null, null, null, null, null);
        EventBus.getDefault().postSticky(new NewTrainDataVolatileEvent("test", new ArrayList<String>(), trainDataVolatile));

    }

    @Test
    void actionToTake() throws ParseException, DDBadDataException, IOException {
        DrivingProfile drivingProfile = new DrivingProfile(EventBus.getDefault());
        assertEquals("BreakAction", drivingProfile.actionToTake().getClass().getSimpleName());
    }
}