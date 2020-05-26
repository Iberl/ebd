package ebd.drivingDynamics.util.conditions;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.drivingDynamics.util.conditions.abstracts.CurveBasedCondition;
import ebd.drivingDynamics.util.conditions.helper.ComparisonParser;
import ebd.drivingDynamics.util.events.DrivingDynamicsExceptionEvent;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Spline;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

/**
 * A max future speed condition compares the a maximum allowed speed in the future to a given speed.<br>
 * <b>This condition ignores possible accelerations and decelerations</b><br>
 * The way it compares the the values are defined in the {@link JSONObject}<br>
 * <p>The <b>type</b> of this condition is "v_t_m"</p>
 * <p>The <b>op</b> key contains a string that determine the kind of comparison. Allowed values are: "<", "<=", ">=", ">"</p>
 * <p>The <b>value</b> key contains a speed in [k/m] in the range of [0, 600]</p>
 * <p>The <b>value_t</b> key contains a time in seconds a which the maximum allowed speed is compared</p>
 * <p>The <b>curveBase</b> key contains the ID of the curve this condition operates on. Either "c30" or "trip" </p>
 * <p>
 *      Example: The condition should evaluate to true if the trains max speed in 120 seconds is slower than 50 km/h on
 *      the trip profil.
 *      The JSON string would look like this:<br>
 *           {"type" : "v_t_m", "condition" : {"op" : "<", "value" : 50, "value_t" : 120, "curveBase" : "trip"}}<br>
 *       The value of "condition" is passed to this class<br>
 * </p>
 *
 * @author Lars Schulze-Falck
 */
public class MaxFutureSpeedCondition extends CurveBasedCondition {
    private String exceptionTarget = "all";
    private BiFunction<Double,Double, Boolean> comparator;
    private Spline tripProfile;

    /**
     * In [m/s]
     */
    private double totalSpeed;

    /**
     * in [s]
     */
    double time;

    /**
     * in [m]
     */
    private double maxBreakinCurveDistance;
    private double maxTripSectionDistance;
    private BreakingCurve c30Curve;


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
        double maxSpeed;
        double curSpeed = trainDataVolatile.getCurrentSpeed();
        double curSecDis = trainDataVolatile.getCurTripSectionDistance();
        switch (this.curveBase){

            case C30:
                if((curSecDis + curSpeed * this.time) > this.maxBreakinCurveDistance){
                    maxSpeed = 0;
                }
                else {
                    maxSpeed = this.c30Curve.getPointOnCurve((curSecDis + curSpeed * this.time));
                }
                break;
            case TRIP_PROFILE:
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

        return this.comparator.apply(maxSpeed,this.totalSpeed);
    }

    /**
     * This method updates the trip profile. This can become necessary should a new one become available. This does
     * <b>not</b> require the train to be at standstill.
     * @param utpe {@link DDUpdateTripProfileEvent}
     */
    @Subscribe
    public void updateTripProfile(DDUpdateTripProfileEvent utpe){
        if(!vaildEventTarget(utpe.target)) return;
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
            this.localEventBus.post(new DrivingDynamicsExceptionEvent("dd", this.exceptionTarget, utpe, iAE));
        }
    }

    @Subscribe
    public void newBreakingCurveGroup(NewBreakingCurveEvent nbce){
        if(!vaildEventTarget(nbce.target)) return;
        this.c30Curve = nbce.breakingCurveGroup.getServiceCoastingPhaseCurve();
        this.maxBreakinCurveDistance = this.c30Curve.getHighestXValue();

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

    private boolean vaildEventTarget(String eventTarget){
        if((eventTarget.contains("dd") || eventTarget.contains("all"))){
            return true;
        }
        return false;
    }
}
