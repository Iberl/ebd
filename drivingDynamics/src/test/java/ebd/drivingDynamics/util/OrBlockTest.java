package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrBlockTest {

    @Test
    void eval() throws DDBadDataException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{ \"andBlocks\" : [{\"conditions\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}]}]}");
        OrBlock orBlock = new OrBlock(jsonObject);
        System.out.println(orBlock.eval());
        assertFalse(orBlock.eval());
    }
}