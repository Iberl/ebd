package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.conditions.abstracts.Condition;
import ebd.drivingDynamics.util.conditions.helper.ComparisonParser;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;
import ebd.speedAndDistanceSupervisionModule.util.events.SsmReportEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

/**
 * This compares the current {@link ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel} to a given one.<br>
 * <p>The <b>type</b> of this condition is "sil"</p>
 * <p>The <b>value</b> key contains one of the following values: <br>
 *     "NO_INTERVENTION"<br>
 *     "INDICATION"<br>
 *     "PERMITTED_SPEED"<br>
 *     "WARNING"<br>
 *     "CUT_OFF_TRACTION"<br>
 *     "APPLY_SERVICE_BREAKS"<br>
 *     "APPLY_EMERGENCY_BREAKS"<br>
 *         </p>
 * <p>Example: The condition should evaluate to true if the train is in the speed intervention level OVERSPEED.
 * The full JSON string would look like this:<br>
 *     {"type" : "sil", "condition" : {"value" : "OVERSPEED" }}<br>
 *      The value of "condition" is passed to the constructor<br></p>
 * @author Lars Schulze-Falck
 */
public class SpeedInterventionLevelCondition extends Condition {

    private SpeedInterventionLevel value;
    private SpeedInterventionLevel currentLevel = SpeedInterventionLevel.NOT_SET;

    public SpeedInterventionLevelCondition(JSONObject jsonObject, EventBus eventBus) throws DDBadDataException {
        super(eventBus);
        fromJSON(jsonObject);
    }

    @Override
    public boolean eval() {
        return value.equals(currentLevel);
    }

    @Subscribe
    public void speedInterventionLevel(SsmReportEvent smre){
        this.currentLevel = smre.interventionLevel;
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
            switch (valueString.toUpperCase()) {
                case "NO_INTERVENTION" -> this.value = SpeedInterventionLevel.NO_INTERVENTION;
                case "INDICATION" -> this.value = SpeedInterventionLevel.INDICATION;
                case "OVERSPEED" -> this.value = SpeedInterventionLevel.OVERSPEED;
                case "WARNING" -> this.value = SpeedInterventionLevel.WARNING;
                case "APPLY_SERVICE_BREAKS" -> this.value = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
                case "APPLY_EMERGENCY_BREAKS" -> this.value = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
                default -> throw new DDBadDataException("No valid entry for key 'value' in a SpeedInterventionLevelCondition: " + valueString);
            }

        }
        else throw new DDBadDataException("The key 'value' was missing for a SpeedInterventionLevelCondition");
    }
}
