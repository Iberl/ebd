package ebd.drivingDynamics.util;

import ebd.drivingDynamics.util.conditions.TotalSpeedCondition;
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

class TotalSpeedConditionTest {
    @BeforeAll
    static void setTrainDataVolatile(){
        TrainDataVolatile trainDataVolatile = new TrainDataVolatile(null, 6d, 28d, null, null, null, null, null, null, null);
        EventBus.getDefault().postSticky(new NewTrainDataVolatileEvent("test", "", trainDataVolatile));
    }

    @Test
    void eval() throws DDBadDataException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{ \"op\" : \">\", \"value\" : 25.0 }");
        TotalSpeedCondition totalSpeedCondition = new TotalSpeedCondition(jsonObject, EventBus.getDefault());
        //System.out.println(totalSpeedCondition.eval());
        assertFalse(totalSpeedCondition.eval());
    }
}