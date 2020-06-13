package ebd.drivingDynamics.util;

import ebd.drivingDynamics.Testhandler;
import ebd.drivingDynamics.util.conditions.conditionBlocks.AndBlock;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.trainData.TrainData;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AndBlockTest {
    @BeforeAll
    static void setTrainDataVolatile(){
        Testhandler testhandler = new Testhandler();
        ConfigHandler.getInstance().useTrainConfiguratorTool = false;
        TrainData trainData = new TrainData( EventBus.getDefault(), 1620, 192, 2181);
    }

    @Test
    void evalSimple() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"andBlock\" : [{\"type\" : \"v\", \"condition\" : { \"op\" : \">\", \"value\" : 25.0 }}]}");
        AndBlock andBlock = new AndBlock(jsonObject, EventBus.getDefault());
        //System.out.println(andBlock.eval());
        assertFalse(andBlock.eval());
    }

    @Test
    void eval() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"andBlock\" : [{\"type\" : \"v\", \"condition\" : { \"op\" : \">\", \"value\" : 25.0 }}, {\"type\" : \"v\", \"condition\" : { \"op\" : \"<\", \"value\" : 25.0 }}]}");
        AndBlock andBlock = new AndBlock(jsonObject, EventBus.getDefault());
        //System.out.println(andBlock.eval());
        assertFalse(andBlock.eval());
    }

    @Test
    void evalComplex() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"andBlock\" : [{\"type\" : \"v\", \"condition\" : { \"op\" : \">\", \"value\" : 25.0 }}, {\"andBlock\" : [{\"type\" : \"v\", \"condition\" : { \"op\" : \">\", \"value\" : 25.0 }}]}]}");
        AndBlock andBlock = new AndBlock(jsonObject, EventBus.getDefault());
        //System.out.println(andBlock.eval());
        assertFalse(andBlock.eval());
    }
}