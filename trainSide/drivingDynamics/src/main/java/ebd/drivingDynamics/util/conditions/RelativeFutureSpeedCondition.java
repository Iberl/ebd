package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.events.DrivingDynamicsExceptionEvent;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Spline;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.simple.JSONObject;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

/**
 * A future relative speed condition compares the current speed to a maximum allowed speed in the future.<br>
 * <b>This condition ignores possible accelerations and decelerations</b><br>
 * The way it compares the the values are defined in the {@link JSONObject}<br>
 * <p>The <b>type</b> of this condition is "v_rel"</p>
 * <p>The <b>op</b> key contains a string that determine the kind of comparison. Allowed values are: "<", "<=", ">=", ">"</p>
 * <p>The <b>value</b> key contains a percentage in the range of [0, 200] that modifies the maximum allowed speed before comparison</p>
 * <p>The <b>value_t</b> key contains a time in seconds a which the maximum allowed speed is compared</p>
 * <p>
 *      Example: The condition should evaluate to true if the train is currently slower than 50% of maximum speed in 120 seconds.
 *      The JSON string would look like this:<br>
 *           {"type" : "v_t_rel", "condition" : {"op" : "<", "value" : 50, "value_t" = 120 }}<br>
 *       The value of "condition" is passed to this function<br>
 * </p>
 *
 * @author Lars Schulze-Falck
 */
public class RelativeFutureSpeedCondition extends CurveBasedCondition{

    private double speedPercentage;
    private BiFunction<Double,Double, Boolean> comparator;
    /*
    Time in [s]
     */
    private double time;

    private Spline tripProfile;
    private double maxTripSectionDistance;

    private List<String> exceptionTargets = Collections.singletonList("all");

    /**
     * Builds an Instance out of a {@link JSONObject}
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus The local {@link EventBus} of the train.
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public RelativeFutureSpeedCondition(JSONObject jsonObject, EventBus localEventBus) throws DDBadDataException {
        super(localEventBus);
        this.localEventBus.register(this);
        fromJSON(jsonObject);
    }

    @Override
    public boolean eval() {
        if(this.tripProfile == null){
            return false;
        }

        double maxSpeed;
        switch (this.curveBase){
            case C30:
                maxSpeed = trainDataVolatile.getCurrentCoastingPhaseSpeed();
                //TODO wrong, needs a way to see breakingCurveGroup!
                break;
            case TRIP_PROFILE:
                double curSpeed = trainDataVolatile.getCurrentSpeed();
                double curSecDis = trainDataVolatile.getCurTripSectionDistance();

                if((curSecDis + curSpeed * this.time) > this.maxTripSectionDistance){
                    maxSpeed = 0;
                }
                else {
                    maxSpeed = this.tripProfile.getPointOnCurve((curSecDis + curSpeed * this.time));
                }
                break;
            default:
                maxSpeed = 0d;
                System.err.println(String.format("You have to add %s to this switch statement", this.curveBase));
        }
        double curSpeed = this.trainDataVolatile.getCurrentSpeed();

        return this.comparator.apply(curSpeed,maxSpeed * this.speedPercentage);
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
                this.speedPercentage = (Long)tempObject / 100d;
            }
            else if(tempObjectName.equals("Double")){
                this.speedPercentage = (Double)tempObject / 100;
            }
            else throw new DDBadDataException("RelativeFutureSpeedCondition value was not a number");

            if(speedPercentage < 0 || speedPercentage > 2){
                throw new DDBadDataException("RelativeFutureSpeedCondition Value was not in the range [0, 200]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a RelativeFutureSpeedCondition");

        if(jsonObject.containsKey("op")){
            String opCode = (String)jsonObject.get("op");
            this.comparator = ComparisonParser.parse(opCode);
        }
        else throw new DDBadDataException("The key 'op' was missing for a RelativeFutureSpeedCondition");

        if(jsonObject.containsKey("value_t")){
            Object tempObject = jsonObject.get("value_t");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                this.time = (Long)tempObject;
            }
            else if(tempObjectName.equals("Double")){
                this.time = (Double)tempObject;
            }
            else throw new DDBadDataException("RelativeFutureSpeedCondition value was not a number");
        }
        else throw new DDBadDataException("The key 'value_t' was missing for a RelativeFutureSpeedCondition");

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
