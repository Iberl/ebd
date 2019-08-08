package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotalSpeedConditionTest {

    @Test
    void eval() throws DDBadDataException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{ \"op\" : \">\", \"value\" : 25.0 }");
        TotalSpeedCondition totalSpeedCondition = new TotalSpeedCondition(jsonObject);
        //System.out.println(totalSpeedCondition.eval());
        assertFalse(totalSpeedCondition.eval());
    }
}