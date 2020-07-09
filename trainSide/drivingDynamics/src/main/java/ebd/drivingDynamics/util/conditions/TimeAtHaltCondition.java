package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.conditions.abstracts.Condition;
import ebd.drivingDynamics.util.conditions.helper.ComparisonParser;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.appTime.AppTime;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

/**
 * A time at halt condition compares the time standing still to a fixed time.
 * The way it compares the the values are defined in the {@link JSONObject}<br>
 * <p>The <b>type</b> of this condition is "t_atHalt"</p>
 * <p>The <b>op</b> key contains a string that determine the kind of comparison. Allowed values are: "<", "<=", ">=", ">"</p>
 * <p>The <b>value</b> key contains a fixed time value in [s] equal or greater then 0 s. </p>
 * <p>Example: The condition should evaluate to true if the train standing still for more then 40.5 s.
 * The JSON string would look like this:<br>
 *     {"type" : "t_atHalt", "priority": 1, "condition" : {"op" : ">", "value" : 40.5 }}<br>
 *         The value of "condition" is passed to the constructor<br></p>
 * @author Lars Schulze-Falck
 */
public class TimeAtHaltCondition extends Condition {

    private final TrainDataVolatile trainDataVolatile;
    private long timeAt0Speed; //in [ms]
    private double timeValue; //in [ms]
    private BiFunction<Double,Double, Boolean> comparator;

    /**
     * A time at halt condition compares the time standing still to a fixed time.
     * The way it compares the the values are defined in the {@link JSONObject}<br>
     * <p>The <b>type</b> of this condition is "t_atHalt"</p>
     * <p>The <b>op</b> key contains a string that determine the kind of comparison. Allowed values are: "<", "<=", ">=", ">"</p>
     * <p>The <b>value</b> key contains a fixed time value in [s] equal or greater then 0 s. </p>
     * <p>Example: The condition should evaluate to true if the train standing still for more then 40.5 s.
     * The JSON string would look like this:<br>
     *     {"type" : "t_atHalt", "condition" : {"op" : ">", "value" : 40.5 }}<br>
     *         The value of "condition" is passed to the constructor<br></p>
     *
     * @param jsonObject the value of "condition" of the upper level json object
     * @param localEventBus The local {@link EventBus} of the train.
     */
    public TimeAtHaltCondition(JSONObject jsonObject, EventBus localEventBus) {
        super(localEventBus);
        this.trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
    }

    @Override
    public boolean eval() {
        double deltaT = (double)(AppTime.currentTimeMillis() - this.timeAt0Speed);
        return  this.comparator.apply(deltaT, this.timeValue);
    }

    @Subscribe
    public void trainData(NewTrainDataVolatileEvent ntdve){
        if(this.trainDataVolatile.getCurrentSpeed() == 0){
            this.timeAt0Speed = AppTime.currentTimeMillis();
        }
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){

            Object tempObject = jsonObject.get("value");
            if(tempObject instanceof Long){
                this.timeValue = ((Long)tempObject).doubleValue() * 1000; //to [ms]
            }
            else if(tempObject instanceof Double){
                this.timeValue = (Double)tempObject * 1000; //to [ms]
            }
            else throw new DDBadDataException("TimeAtHaltCondition value was not a number");

            if(this.timeValue < 0){
                throw new DDBadDataException("TimeAtHaltCondition value was not <= 0");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a TimeAtHaltCondition");

        if(jsonObject.keySet().contains("op")){
            String opCode = (String)jsonObject.get("op");
            this.comparator = ComparisonParser.parse(opCode);
        }
        else throw new DDBadDataException("The key 'op' was missing for a TimeAtHaltCondition");
    }
}
