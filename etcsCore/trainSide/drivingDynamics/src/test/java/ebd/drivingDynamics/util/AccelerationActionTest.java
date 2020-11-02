package ebd.drivingDynamics.util;

import ebd.drivingDynamics.Testhandler;
import ebd.drivingDynamics.util.actions.AccelerationAction;
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

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccelerationActionTest {
    @BeforeAll
    static void setTrainDataVolatile(){
        Testhandler testhandler = new Testhandler();
        ConfigHandler.getInstance().useTrainConfiguratorTool = false;
        TrainData trainData = new TrainData( EventBus.getDefault(), 1620, 192, 2181);
    }


    void test() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{ \"value\" : 10 , \"conditions\" : {\"orBlock\" : [{\"type\" : \"v\", \"condition\" : { \"op\" : \"<\", \"value\" : 25.0 }}]}}");
        AccelerationAction accelerationAction = new AccelerationAction(jsonObject, EventBus.getDefault(), 2);
        assertTrue(accelerationAction.eval());
        assertEquals(0.1, accelerationAction.getAccelerationPercentage());
    }

}