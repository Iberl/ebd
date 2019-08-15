package ebd.drivingDynamics.util;

import ebd.drivingDynamics.util.curveCalculation.AccelerationPowerCurveCalculator;
import ebd.drivingDynamics.util.curveCalculation.BreakingPowerCurveCalculator;
import ebd.drivingDynamics.util.curveCalculation.ResistanceCurveCalculator;
import ebd.globalUtils.events.Event;
import ebd.globalUtils.spline.ForwardSpline;
import org.greenrobot.eventbus.EventBus;

public class AvailableAcceleration {

    private double accelerationModification = 1d;

    private double breakingModification = 1d;

    private EventBus eventBus;

    private ForwardSpline speedUpCurve;

    private ForwardSpline breakingPowerCurve;

    private ForwardSpline resistanceCurve;

    public AvailableAcceleration(EventBus eventBus){
        this.eventBus = eventBus;
        calculateCurves();
    }


    public AvailableAcceleration(EventBus eventBus, ForwardSpline speedUpCurve, ForwardSpline breakingPowerCurve, ForwardSpline resistanceCurve) {
        this.eventBus = eventBus;
        this.speedUpCurve = speedUpCurve;
        this.breakingPowerCurve = breakingPowerCurve;
        this.resistanceCurve = resistanceCurve;
    }

    /**
     * Returns the available acceleration for a certain speed and {@link MovementState}
     * @param currentSpeed in [m/s]
     * @return acceleration in [m/(s^2)]
     */
    public double getAcceleration(double currentSpeed, MovementState movementState){
        switch (movementState){
            case HALTING:
            case CRUISE:
                return 0d;
            case ACCELERATING:
                return speedUpCurve.getPointOnCurve(currentSpeed) * accelerationModification + resistanceCurve.getPointOnCurve(currentSpeed);
            case BREAKING:
                return - breakingPowerCurve.getPointOnCurve(currentSpeed) * breakingModification + resistanceCurve.getPointOnCurve(currentSpeed);
            case COASTING:
                return resistanceCurve.getPointOnCurve(currentSpeed);
            default:
                throw new IllegalArgumentException("This MovementState was not caught by AvailableAcceleration");
        }
    }

    private void calculateCurves() {
        this.speedUpCurve = AccelerationPowerCurveCalculator.calculate(this.eventBus);
        this.breakingPowerCurve = BreakingPowerCurveCalculator.calculate(this.eventBus);
        this.resistanceCurve = ResistanceCurveCalculator.calculate(this.eventBus);

    }

    /*
    Getter
     */

    public double getAccelerationModification() {
        return accelerationModification;
    }

    public double getBreakingModification() {
        return breakingModification;
    }

    /*
    Setter
     */

    public void setAccelerationModification(double accelerationModification) {
        this.accelerationModification = accelerationModification;
    }

    public void setBreakingModification(double breakingModification) {
        this.breakingModification = breakingModification;
    }
}
