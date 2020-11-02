package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.Testhandler;
import ebd.drivingDynamics.util.conditions.TotalSpeedCondition;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
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

class TotalSpeedConditionTest {
    @BeforeAll
    static void setTrainDataVolatile(){
        Testhandler testhandler = new Testhandler();
        ConfigHandler.getInstance().useTrainConfiguratorTool = false;
        TrainData trainData = new TrainData( EventBus.getDefault(), 1620, 192, 2181);
    }


    void eval() throws DDBadDataException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{ \"op\" : \">\", \"value\" : 25.0 }");
        TotalSpeedCondition totalSpeedCondition = new TotalSpeedCondition(jsonObject, EventBus.getDefault());
        assertFalse(totalSpeedCondition.eval());

        EventBus.getDefault().post(new TrainDataChangeEvent("test", "td", "currentSpeed", 20));
        assertTrue(totalSpeedCondition.eval());
    }
}