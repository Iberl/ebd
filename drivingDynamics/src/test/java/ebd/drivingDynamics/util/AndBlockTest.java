package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AndBlockTest {

    @Test
    void eval() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"conditions\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}]}");
        AndBlock andBlock = new AndBlock(jsonObject);
        //System.out.println(andBlock.eval());
        assertFalse(andBlock.eval());
    }
}