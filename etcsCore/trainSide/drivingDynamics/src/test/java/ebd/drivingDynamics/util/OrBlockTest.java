package ebd.drivingDynamics.util;

import ebd.drivingDynamics.Testhandler;
import ebd.drivingDynamics.util.conditions.conditionBlocks.OrBlock;
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

class OrBlockTest {
    @BeforeAll
    static void setTrainDataVolatile(){
        Testhandler testhandler = new Testhandler();
        ConfigHandler.getInstance().useTrainConfiguratorTool = false;
        TrainData trainData = new TrainData( EventBus.getDefault(), 1620, 192, 2181);
    }


    void evalSimple() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"orBlock\" : [{\"type\" : \"v_rel\", \"condition\" : { \"op\" : \">\", \"value\" : 25.0, \"curveBase\" : \"trip\" }}]}");
        OrBlock orBlock = new OrBlock(jsonObject, EventBus.getDefault());
        //System.out.println(orBlock.eval());
        assertFalse(orBlock.eval());
    }


    void eval() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"orBlock\" : [{\"orBlock\" : [{\"type\" : \"v_rel\", \"condition\" : { \"op\" : \">\", \"value\" : 25.0, \"curveBase\" : \"trip\" }}]}, {\"orBlock\" : [{\"type\" : \"v_rel\", \"condition\" : { \"op\" : \">\", \"value\" : 25.0, \"curveBase\" : \"trip\" }}]}]}");
        OrBlock orBlock = new OrBlock(jsonObject, EventBus.getDefault());
        //System.out.println(orBlock.eval());
        assertFalse(orBlock.eval());
    }


    void evalComplex() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"orBlock\" : [{\"orBlock\" : [{\"type\" : \"v_rel\", \"condition\" : { \"op\" : \">\", \"value\" : 25.0, \"curveBase\" : \"trip\" }}]}, {\"orBlock\" : [{\"orBlock\" : [{\"type\" : \"v_rel\", \"condition\" : { \"op\" : \">\", \"value\" : 25.0, \"curveBase\" : \"trip\" }}]}]}]}");
        OrBlock orBlock = new OrBlock(jsonObject, EventBus.getDefault());
        //System.out.println(orBlock.eval());
        assertFalse(orBlock.eval());
    }
}