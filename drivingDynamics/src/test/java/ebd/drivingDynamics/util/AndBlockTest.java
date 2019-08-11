package ebd.drivingDynamics.util;

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

class AndBlockTest {
    @BeforeAll
    static void setTrainDataVolatile(){
        TrainDataVolatile trainDataVolatile = new TrainDataVolatile(null, 20d, 100d, null, null, null, null);
        EventBus.getDefault().postSticky(new NewTrainDataVolatileEvent("test", new ArrayList<String>(), trainDataVolatile));
    }

    @Test
    void evalSimple() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"andBlock\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}]}");
        AndBlock andBlock = new AndBlock(jsonObject, EventBus.getDefault());
        //System.out.println(andBlock.eval());
        assertFalse(andBlock.eval());
    }

    @Test
    void eval() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"andBlock\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}, {\"v\" : { \"op\" : \">\", \"value\" : 25.0 }}]}");
        AndBlock andBlock = new AndBlock(jsonObject, EventBus.getDefault());
        //System.out.println(andBlock.eval());
        assertFalse(andBlock.eval());
    }

    @Test
    void evalComplex() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"andBlock\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}, {\"andBlock\" : [{\"v_rel\" : { \"op\" : \">\", \"value\" : 25.0 }}]}]}");
        AndBlock andBlock = new AndBlock(jsonObject, EventBus.getDefault());
        //System.out.println(andBlock.eval());
        assertFalse(andBlock.eval());
    }
}