package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.conditions.abstracts.RelativeHysteresisCondition;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

public class FallingRelativeHysteresisCondition extends RelativeHysteresisCondition {

    /**
     * @param localEventBus The local {@link EventBus} of the train.
     * @param jsonObject
     */
    public FallingRelativeHysteresisCondition(EventBus localEventBus, JSONObject jsonObject) throws DDBadDataException {
        super(localEventBus, jsonObject);
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
