package ebd.drivingDynamics.util.conditions.helper;

import ebd.drivingDynamics.util.conditions.abstracts.Condition;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;
import ebd.globalUtils.events.speedDistanceSupervision.SsmReportEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.simple.JSONObject;

/**
 * This compares the current {@link SpeedInterventionLevel} to a given one.<br>
 * <p>The <b>type</b> of this condition is "sss"</p>
 * <p>The <b>value</b> key contains one of the following values: <br>
 *     "RELEASE_SPEED_SUPERVISION"<br>
 *     "CEILING_SPEED_SUPERVISION"<br>
 *     "TARGET_SPEED_SUPERVISION"<br>
 *         </p>
 * <p>Example: The condition should evaluate to true if the train is in the speed supervision state CEILING_SPEED_SUPERVISION.
 * The full JSON string would look like this:<br>
 *     {"type" : "sss", "condition" : {"value" : "CEILING_SPEED_SUPERVISION" }}<br>
 *      The value of "condition" is passed to the constructor<br></p>
 * @author Lars Schulze-Falck
 */
public class SpeedSupervisorStateCondition extends Condition {

    private SpeedSupervisionState value;
    private SpeedSupervisionState currentLevel = SpeedSupervisionState.NOT_SET;

    public SpeedSupervisorStateCondition(JSONObject jsonObject, EventBus eventBus) throws DDBadDataException {
        super(eventBus);
        fromJSON(jsonObject);
    }

    @Override
    public boolean eval() {
        return value.equals(currentLevel);
    }

    @Subscribe
    public void speedInterventionLevel(SsmReportEvent smre){
        this.currentLevel = smre.supervisionState;
    }

    /**
     *
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @throws DDBadDataException
     */
    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){

            String valueString = (String)jsonObject.get("value");
            switch (valueString.toUpperCase()){
                case "RELEASE_SPEED_SUPERVISION":
                    this.value = SpeedSupervisionState.RELEASE_SPEED_SUPERVISION;
                    break;
                case "CEILING_SPEED_SUPERVISION":
                    this.value = SpeedSupervisionState.CEILING_SPEED_SUPERVISION;
                    break;
                case "TARGET_SPEED_SUPERVISION":
                    this.value = SpeedSupervisionState.TARGET_SPEED_SUPERVISION;
                    break;
                default:
                    throw new DDBadDataException("No valid entry for key 'value' in a SpeedSupervisorStateCondition " + valueString);
            }

        }
        else throw new DDBadDataException("The key 'value' was missing for a SpeedSupervisorStateCondition");
    }
}
