package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.conditions.abstracts.CurveBasedCondition;
import ebd.drivingDynamics.util.conditions.helper.ComparisonParser;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

/**
 * A relative speed condition compares the current speed to the current maximum allowed speed.<br>
 * The way it compares the the values are defined in the {@link JSONObject}<br>
 * <p>The <b>type</b> of this condition is "v_trel"</p>
 * <p>The <b>op</b> key contains a string that determine the kind of comparison. Allowed values are: "<", "<=", ">=", ">"</p>
 * <p>The <b>value</b> key contains a percentage in the range of [0, 200] that modifies the maximum allowed speed before comparison</p>
 * <p>The <b>curveBase</b> key contains the ID of the curve this condition operates on. Either "c30" or "trip" </p>
 * <p>
 *     Example: The condition should evaluate to true if the train is slower than 50% of the current maximum speed on the trip profile.
 *     The JSON string would look like this:<br>
 *     {"type" : "v_rel", "condition" : {"op" : "<", "value" : 50, "curveBase" : "trip" }}<br>
 *     The value of "condition" is passed to the constructor<br></p>
 * @author Lars Schulze-Falck
 */
public class RelativeSpeedCondition extends CurveBasedCondition {

    private Double speedPercentage;
    private BiFunction<Double,Double, Boolean> comparator;

    /**
     * Builds an Instance out of a {@link JSONObject}
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus The local {@link EventBus} of the train.
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public RelativeSpeedCondition(JSONObject jsonObject, EventBus localEventBus) throws DDBadDataException {
        super(localEventBus);
        fromJSON(jsonObject);
    }

    @Override
    public boolean eval() {

        double maxSpeed;
        switch (this.curveBase){
            case C30:
                maxSpeed = trainDataVolatile.getCurrentCoastingPhaseSpeed();
                break;
            case TRIP_PROFILE:
                maxSpeed = trainDataVolatile.getCurrentProfileMaxSpeed();
                break;
            default:
                maxSpeed = 0d;
                System.err.println(String.format("You have to add %s to this switch statement", this.curveBase));
        }
        double curSpeed = trainDataVolatile.getCurrentSpeed();

        return comparator.apply(curSpeed,maxSpeed * speedPercentage);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.containsKey("value")){
            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                speedPercentage = (Long)tempObject / 100d;
            }
            else if(tempObjectName.equals("Double")){
                speedPercentage = (Double)tempObject / 100;
            }
            else throw new DDBadDataException("RelativeSpeedCondition value was not a number");

            if(speedPercentage < 0 || speedPercentage > 2){
                throw new DDBadDataException("RelativeSpeedCondition Value was not in the range [0, 200]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a RelativeSpeedCondition");

        if(jsonObject.containsKey("op")){
            String opCode = (String)jsonObject.get("op");
            this.comparator = ComparisonParser.parse(opCode);
        }
        else throw new DDBadDataException("The key 'op' was missing for a RelativeSpeedCondition");

        if(jsonObject.containsKey("curveBase")){
            switch ((String) jsonObject.get("curveBase")){
                case "c30":
                    this.curveBase = CurveBase.C30;
                    break;
                case "trip":
                    this.curveBase = CurveBase.TRIP_PROFILE;
                    break;
                default:
                    this.curveBase = CurveBase.NOT_SET;
                    throw new DDBadDataException(String.format("Condition was formatted wrong, %s is not a valid curve base", jsonObject.get("curveBase")));
            }
        }
        else throw new DDBadDataException("The key curveBase was missing from a Condition");
    }
}
