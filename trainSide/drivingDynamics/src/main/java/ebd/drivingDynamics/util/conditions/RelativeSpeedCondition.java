package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

/**
 * A relative speed condition compares the current speed to the current maximum allowed speed.<br>
 * The way it compares the the values are defined in the {@link JSONObject}<br>
 * <p>The <b>type</b> of this condition is "v_trel"</p>
 * <p>The <b>op</b> key contains a string that determine the kind of comparison. Allowed values are: "<", "<=", ">=", ">"</p>
 * <p>The <b>value</b> key contains a percentage in the range of [0, 200] that modifies the maximum allowed speed before comparison</p>
 * <p>Example: The condition should evaluate to true if the train is slower than 50% of the current maximum speed.
 * The JSON string would look like this:<br>
 *     {"type" : "v_rel", "condition" : {"op" : "<", "value" : 50 }}</p>
 * @author Lars Schulze-Falck
 */
public class RelativeSpeedCondition extends Condition {

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
        TrainDataVolatile trainDataVolatile = localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;

        double maxSpeed = trainDataVolatile.getCurrentTargetSpeed() * speedPercentage;
        double curSpeed = trainDataVolatile.getCurrentSpeed();

        return comparator.apply(curSpeed,maxSpeed);
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
    }
}
