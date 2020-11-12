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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FallingRelativeHysteresisConditionTest {

    @BeforeEach
    void setTrainDataVolatile(){
        Testhandler testhandler = new Testhandler();
        ConfigHandler.getInstance().useTrainConfiguratorTool = false;
        TrainData trainData = new TrainData( EventBus.getDefault(), 1620, 192, 2181);
        EventBus.getDefault().post(new TrainDataChangeEvent("test", "td", "currentProfileMaxSpeed", 100));
    }

    @Test
    public void eval() throws ParseException, DDBadDataException {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse("{\"v_Low\" : 65, \"v_High\" : 80, \"curveBase\" : \"trip\" }");
        FallingRelativeHysteresisCondition frhc = new FallingRelativeHysteresisCondition(EventBus.getDefault(), jsonObject);

        assertTrue(frhc.eval());

        EventBus.getDefault().post(new TrainDataChangeEvent("test", "td", "currentSpeed", 70));
        assertFalse(frhc.eval());

        EventBus.getDefault().post(new TrainDataChangeEvent("test", "td", "currentSpeed", 90));
        assertFalse(frhc.eval());

        EventBus.getDefault().post(new TrainDataChangeEvent("test", "td", "currentSpeed", 70));
        assertTrue(frhc.eval());

        EventBus.getDefault().post(new TrainDataChangeEvent("test", "td", "currentSpeed", 60));
        assertTrue(frhc.eval());

        EventBus.getDefault().post(new TrainDataChangeEvent("test", "td", "currentSpeed", 70));
        assertFalse(frhc.eval());

    }
}