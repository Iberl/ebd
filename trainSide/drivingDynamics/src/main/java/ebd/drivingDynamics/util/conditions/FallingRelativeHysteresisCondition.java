package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.conditions.abstracts.RelativeHysteresisCondition;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * A falling relative hysterese condition evaluates to true on the falling leg of a hysterese curve.
 * In other words, it evaluates to false if the speed is above or equal v_High or if it raises from a value lower then v_Low
 * to a value higher then v_Low. It evaluates to true in all other cases.
 * This condition takes relative values of a chosen curve as v_Low and v_High.<br>
 * <p>The <b>type</b> of this condition is "v_Hrel:L"</p>
 * <p>The <b>v_Low</b> key contains a percentage in the range of [0, 200] that modifies the maximum allowed speed before comparison and
 *                      forms the lower split point of the hysteresis</p>
 * <p>The <b>v_High</b> key contains a percentage in the range of [0, 200] that modifies the maximum allowed speed before comparison and
 *                      forms the higher split point of the hysteresis</p>
 * <p>The <b>curveBase</b> key contains the ID of the curve this condition operates on. Either "c30" or "trip" </p>
 * <p>
 *     Example: The condition should evaluate to true if the train is breaks from over 80% of the current maximum speed on the trip profile
 *     to under 80%. It should evaluate to false if it speeds up from under 65% to over 65%.
 *     The JSON string would look like this:<br>
 *     {"type" : "v_Hrel_L", "priority": 1, "condition" : {"v_Low" : 65, "v_High" : 80, "curveBase" : "trip" }}<br>
 *     The value of "condition" is passed to the constructor<br></p>
 * @author Lars Schulze-Falck
 */
public class FallingRelativeHysteresisCondition extends RelativeHysteresisCondition {

    /**
     * @param localEventBus The local {@link EventBus} of the train.
     * @param jsonObject The value of "condition" in a type "v_Hrel_L" condition
     */
    public FallingRelativeHysteresisCondition(EventBus localEventBus, JSONObject jsonObject) throws DDBadDataException {
        super(localEventBus, jsonObject);
        this.raising = true;
    }

    @Override
    public boolean eval() {
        boolean result = false;
        double curSpeed = trainDataVolatile.getCurrentSpeed();
        double curSpeedLow;
        double curSpeedHigh;
        switch (this.curveBase){
            case C30:
                curSpeedLow = trainDataVolatile.getCurrentCoastingPhaseSpeed() * this.vLowPercentage;
                curSpeedHigh = trainDataVolatile.getCurrentCoastingPhaseSpeed() * this.vHighPercentage;
                break;
            case TRIP_PROFILE:
                curSpeedLow = trainDataVolatile.getCurrentProfileMaxSpeed() * this.vLowPercentage;
                curSpeedHigh = trainDataVolatile.getCurrentProfileMaxSpeed() * this.vHighPercentage;
                break;
            default:
                curSpeedLow = 0d;
                curSpeedHigh = 0d;
                System.err.println(String.format("You have to add %s to this switch statement", this.curveBase));
        }

        if (curSpeed >= curSpeedHigh){
            this.raising = false;
        }
        else if(curSpeed <= curSpeedLow){
            this.raising = true;
            result = true;
        }
        else if (curSpeed > curSpeedLow && curSpeed < curSpeedHigh && !raising){
            result = true;
        }

        return result;
    }
}
