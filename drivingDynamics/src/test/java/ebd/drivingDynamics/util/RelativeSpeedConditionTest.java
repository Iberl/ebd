package ebd.drivingDynamics.util;


import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelativeSpeedConditionTest {

    @Test
    void eval() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{ \"op\" : \">\", \"value\" : 25.0 }");
        RelativeSpeedCondition relativeSpeedCondition = new RelativeSpeedCondition(jsonObject, EventBus.getDefault());
        //System.out.println(relativeSpeedCondition.eval());
        assertFalse(relativeSpeedCondition.eval());
    }
}