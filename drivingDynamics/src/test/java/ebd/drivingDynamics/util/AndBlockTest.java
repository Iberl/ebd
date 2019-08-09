package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AndBlockTest {

    @Test
    void evalSimple() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"andBlock\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}]}");
        AndBlock andBlock = new AndBlock(jsonObject);
        //System.out.println(andBlock.eval());
        assertFalse(andBlock.eval());
    }

    @Test
    void eval() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"andBlock\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}, {\"v\" : { \"op\" : \">\", \"value\" : 25.0 }}]}");
        AndBlock andBlock = new AndBlock(jsonObject);
        //System.out.println(andBlock.eval());
        assertFalse(andBlock.eval());
    }

    @Test
    void evalComplex() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"andBlock\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}, {\"andBlock\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}]}]}");
        AndBlock andBlock = new AndBlock(jsonObject);
        //System.out.println(andBlock.eval());
        assertFalse(andBlock.eval());
    }
}