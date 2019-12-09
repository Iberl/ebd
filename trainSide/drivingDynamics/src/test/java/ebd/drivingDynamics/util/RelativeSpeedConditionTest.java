package ebd.drivingDynamics.util;


import ebd.drivingDynamics.util.conditions.RelativeSpeedCondition;
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

class RelativeSpeedConditionTest {
    @BeforeAll
    static void setTrainDataVolatile(){
        TrainDataVolatile trainDataVolatile = new TrainDataVolatile(null, 6d, 28d, null, null, null, null, null, null, null);
        EventBus.getDefault().postSticky(new NewTrainDataVolatileEvent("test", new ArrayList<String>(), trainDataVolatile));
    }

    @Test
    void evalFalse() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{ \"op\" : \">\", \"value\" : 25.0 }");
        RelativeSpeedCondition relativeSpeedCondition = new RelativeSpeedCondition(jsonObject, EventBus.getDefault());
        //System.out.println(relativeSpeedCondition.eval());
        assertFalse(relativeSpeedCondition.eval());
    }

    @Test
    void evalTrue() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{ \"op\" : \"<\", \"value\" : 25.0 }");
        RelativeSpeedCondition relativeSpeedCondition = new RelativeSpeedCondition(jsonObject, EventBus.getDefault());
        //System.out.println(relativeSpeedCondition.eval());
        assertTrue(relativeSpeedCondition.eval());
    }
}