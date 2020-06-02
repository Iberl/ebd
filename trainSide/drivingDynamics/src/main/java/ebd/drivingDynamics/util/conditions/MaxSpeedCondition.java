package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.conditions.abstracts.CurveBasedCondition;
import ebd.drivingDynamics.util.conditions.helper.ComparisonParser;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

/**
 * A max speed condition compares the current maximum speed to a fixed speed.<br>
 * The way it compares the the values are defined in the {@link JSONObject}<br>
 * <p>The <b>type</b> of this condition is "v_m"</p>
 * <p>The <b>op</b> key contains a string that determine the kind of comparison. Allowed values are: "<", "<=", ">=", ">"</p>
 * <p>The <b>value</b> key contains a fixed speed value in the range of [0 km/h, 600 km/h] </p>
 * <p>The <b>curveBase</b> key contains the ID of the curve this condition operates on. Either "c30" or "trip" </p>
 * <p>
 *     Example: The condition should evaluate to true if the trains current  maximum speed on the trip
 *     profile is slower than 50 km/h.
 *      The JSON string would look like this:<br>
 *     {"type" : "v_m", "condition" : {"op" : "<", "value" : 50, "curveBase" : "trip" }}</p>
 * @author Lars Schulze-Falck
 */
public class MaxSpeedCondition extends CurveBasedCondition {

    private Double speedTotal;
    private BiFunction<Double,Double, Boolean> comparator;

    /**
     * @param localEventBus The local {@link EventBus} of the train.
     */
    public MaxSpeedCondition(JSONObject jsonObject, EventBus localEventBus) throws DDBadDataException {
        super(localEventBus);
        fromJSON(jsonObject);
    }

    @Override
    public boolean eval() {

        double maxSpeed;
        switch (this.curveBase){
            case C30:
                maxSpeed = this.trainDataVolatile.getCurrentCoastingPhaseSpeed();
                break;
            case TRIP_PROFILE:
                maxSpeed = this.trainDataVolatile.getCurrentProfileTargetSpeed();
                break;
            default:
                maxSpeed = 0d;
                System.err.println(String.format("You have to add %s to this switch statement", this.curveBase));
                System.exit(-1);
        }

        return comparator.apply(maxSpeed,speedTotal);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){

            Object tempObject = jsonObject.get("value");
            if(tempObject instanceof Long){
                speedTotal = ((Long)tempObject).doubleValue() / 3.6; //To [m/s]
            }
            else if(tempObject instanceof Double){
                speedTotal = (Double)tempObject / 3.6; //To [m/s]
            }
            else throw new DDBadDataException("MaxSpeedCondition value was not a number");

            if(speedTotal < 0 || speedTotal > (600 / 3.6)){
                throw new DDBadDataException("MaxSpeedCondition Value was not in the range [0, 600] km/h");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a MaxSpeedCondition");

        if(jsonObject.keySet().contains("op")){
            String opCode = (String)jsonObject.get("op");
            this.comparator = ComparisonParser.parse(opCode);
        }
        else throw new DDBadDataException("The key 'op' was missing for a MaxSpeedCondition");

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
