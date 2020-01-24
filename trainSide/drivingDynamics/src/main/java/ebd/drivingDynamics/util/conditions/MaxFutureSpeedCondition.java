package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.events.DrivingDynamicsExceptionEvent;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Spline;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.simple.JSONObject;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

/**
 * A max future speed condition compares the a maximum allowed speed in the future to a given speed.<br>
 * <b>This condition ignores possible accelerations and decelerations</b><br>
 * The way it compares the the values are defined in the {@link JSONObject}<br>
 * <p>The <b>type</b> of this condition is "v_t_m"</p>
 * <p>The <b>op</b> key contains a string that determine the kind of comparison. Allowed values are: "<", "<=", ">=", ">"</p>
 * <p>The <b>value</b> key contains a speed in [k/m] in the range of [0, 600]</p>
 * <p>The <b>value_t</b> key contains a time in seconds a which the maximum allowed speed is compared</p>
 * <p>
 *      Example: The condition should evaluate to true if the trains max speed in 120 seconds is slower than 50 km/h
 *      The JSON string would look like this:<br>
 *           {"type" : "v_t_m", "condition" : {"op" : "<", "value" : 50, "value_t" = 120 }}<br>
 *       The value of "condition" is passed to this class<br>
 * </p>
 *
 * @author Lars Schulze-Falck
 */
public class MaxFutureSpeedCondition extends Condition {
    /**
     * In [m/s]
     */
    private double totalSpeed;
    private BiFunction<Double,Double, Boolean> comparator;

    /**
     * in [s]
     */
    double time;

    private Spline tripProfile;
    /**
     * in [m]
     */
    private double maxTripSectionDistance;

    private List<String> exceptionTargets = Collections.singletonList("all");

    /**
     * @param localEventBus The local {@link EventBus} of the train.
     */
    public MaxFutureSpeedCondition(JSONObject jsonObject, EventBus localEventBus) throws DDBadDataException {
        super(localEventBus);
        this.localEventBus.register(this);
        fromJSON(jsonObject);
    }

    @Override
    public boolean eval() {
        if(this.tripProfile == null){
            return false;
        }

        double curSpeed = trainDataVolatile.getCurrentSpeed();
        double curSecDis = trainDataVolatile.getCurTripSectionDistance();
        double maxSpeed;
        if((curSecDis + curSpeed * this.time) > this.maxTripSectionDistance){
            maxSpeed = 0;
        }
        else {
            maxSpeed = tripProfile.getPointOnCurve((curSecDis + curSpeed * this.time));
        }

        return this.comparator.apply(maxSpeed,this.totalSpeed);
    }

    /**
     * This method updates the trip profile. This can become necessary should a new one become available. This does
     * <b>not</b> require the train to be at standstill.
     * @param utpe {@link DDUpdateTripProfileEvent}
     */
    @Subscribe
    public void updateTripProfile(DDUpdateTripProfileEvent utpe){
        if(!(utpe.targets.contains("dd") || utpe.targets.contains("all"))){
            return;
        }
        this.tripProfile = utpe.tripProfile;

        if(this.tripProfile instanceof BackwardSpline){
            BackwardSpline backwardSpline = (BackwardSpline)this.tripProfile;
            this.maxTripSectionDistance = backwardSpline.getHighestXValue();
        }
        else if(this.tripProfile instanceof ForwardSpline){
            this.maxTripSectionDistance = Double.MAX_VALUE;
        }
        else{
            IllegalArgumentException iAE = new IllegalArgumentException("The trip profile used an unsupported implementation of Spline");
            this.localEventBus.post(new DrivingDynamicsExceptionEvent("dd", this.exceptionTargets, utpe, iAE));
        }
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.containsKey("value")){
            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                this.totalSpeed = (Long)tempObject / 3.6;
            }
            else if(tempObjectName.equals("Double")){
                this.totalSpeed = (Double)tempObject / 3.6;
            }
            else throw new DDBadDataException("MaxFutureSpeedCondition value was not a number");

            if(this.totalSpeed < 0 || this.totalSpeed > 167){
                throw new DDBadDataException("MaxFutureSpeedCondition Value was not in the range [0, 600] km/h");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a MaxFutureSpeedCondition");

        if(jsonObject.containsKey("op")){
            String opCode = (String)jsonObject.get("op");
            this.comparator = ComparisonParser.parse(opCode);
        }
        else throw new DDBadDataException("The key 'op' was missing for a MaxFutureSpeedCondition");

        if(jsonObject.containsKey("value_t")){
            Object tempObject = jsonObject.get("value_t");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                this.time = (Long)tempObject;
            }
            else if(tempObjectName.equals("Double")){
                this.time = (Double)tempObject;
            }
            else throw new DDBadDataException("MaxFutureSpeedCondition value was not a number");
        }
        else throw new DDBadDataException("The key 'value_t' was missing for a MaxFutureSpeedCondition");

    }
}