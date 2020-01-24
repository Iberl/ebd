package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

/**
 * A max speed condition compares the current maximum speed to a fixed speed.<br>
 * The way it compares the the values are defined in the {@link JSONObject}<br>
 * <p>The <b>type</b> of this condition is "v_m"</p>
 * <p>The <b>op</b> key contains a string that determine the kind of comparison. Allowed values are: "<", "<=", ">=", ">"</p>
 * <p>The <b>value</b> key contains a fixed speed value in the range of [0 km/h, 600 km/h] </p>
 * <p>Example: The condition should evaluate to true if the trains current  maximum speed is slower than 50 km/h.
 * The JSON string would look like this:<br>
 *     {"type" : "v_m", "condition" : {"op" : "<", "value" : 50 }}</p>
 * @author Lars Schulze-Falck
 */
public class MaxSpeedCondition extends Condition {

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
        double currentTargetSpeed = trainDataVolatile.getCurrentTargetSpeed();

        return comparator.apply(currentTargetSpeed,speedTotal);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){

            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                speedTotal = ((Long)tempObject).doubleValue() / 3.6; //To [m/s]
            }
            else if(tempObjectName.equals("Double")){
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
    }
}
