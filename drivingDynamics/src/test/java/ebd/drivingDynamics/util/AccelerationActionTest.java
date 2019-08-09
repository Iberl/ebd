package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccelerationActionTest {

    @Test
    void test() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{ \"value\" : 10 , \"conditions\" : {\"orBlock\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}]}}");
        AccelerationAction accelerationAction = new AccelerationAction(jsonObject);
        assertFalse(accelerationAction.eval());
        assertEquals(10d, accelerationAction.getAccelerationPercentage());
    }

}