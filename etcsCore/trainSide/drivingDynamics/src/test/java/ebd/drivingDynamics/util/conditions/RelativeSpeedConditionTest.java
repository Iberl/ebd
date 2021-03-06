package ebd.drivingDynamics.util.conditions;


import ebd.drivingDynamics.Testhandler;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.trainData.TrainData;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RelativeSpeedConditionTest {
    @BeforeAll
    static void setTrainDataVolatile(){
        Testhandler testhandler = new Testhandler();
        ConfigHandler.getInstance().useTrainConfiguratorTool = false;
        TrainData trainData = new TrainData( EventBus.getDefault(), 1620, 192, 2181);
    }

    @Test
    void eval() throws ParseException, DDBadDataException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{ \"op\" : \">\", \"value\" : 25.0, \"curveBase\" : \"trip\" }");
        RelativeSpeedCondition relativeSpeedCondition = new RelativeSpeedCondition(jsonObject, EventBus.getDefault());
        assertFalse(relativeSpeedCondition.eval());

        EventBus.getDefault().post(new TrainDataChangeEvent("test", "td", "currentSpeed", 20));
        EventBus.getDefault().post(new TrainDataChangeEvent("test", "td", "currentProfileMaxSpeed", 40));

        assertTrue(relativeSpeedCondition.eval());
    }
}