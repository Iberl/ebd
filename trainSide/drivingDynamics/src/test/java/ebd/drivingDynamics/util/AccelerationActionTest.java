package ebd.drivingDynamics.util;

import ebd.drivingDynamics.Testhandler;
import ebd.drivingDynamics.util.actions.AccelerationAction;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccelerationActionTest {
    @BeforeAll
    static void setTrainDataVolatile(){
        Testhandler testhandler = new Testhandler();
        TrainDataVolatile trainDataVolatile = new TrainDataVolatile(null, 6d, 28d, null, null, null, null, null, null, null);
        EventBus.getDefault().postSticky(new NewTrainDataVolatileEvent("test", "", trainDataVolatile));
    }

    @Test
    void test() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{ \"value\" : 10 , \"conditions\" : {\"orBlock\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}]}}");
        AccelerationAction accelerationAction = new AccelerationAction(jsonObject, EventBus.getDefault(), 2);
        assertFalse(accelerationAction.eval());
        assertEquals(0.1, accelerationAction.getAccelerationPercentage());
    }

}