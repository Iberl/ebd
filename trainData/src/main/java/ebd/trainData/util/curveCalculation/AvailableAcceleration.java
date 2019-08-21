package ebd.trainData.util.curveCalculation;

import ebd.globalUtils.movementState.MovementState;
import ebd.globalUtils.spline.ForwardSpline;
import org.greenrobot.eventbus.EventBus;

public class AvailableAcceleration {

    private double accelerationModification = 1d;

    private double breakingModification = 1d;

    private ForwardSpline speedUpCurve;

    private ForwardSpline breakingPowerCurve;

    private ForwardSpline resistanceCurve;

    public AvailableAcceleration(EventBus eventBus){
        updateCurves(eventBus);
    }


    public AvailableAcceleration(ForwardSpline speedUpCurve, ForwardSpline breakingPowerCurve, ForwardSpline resistanceCurve) {
        this.speedUpCurve = speedUpCurve;
        this.breakingPowerCurve = breakingPowerCurve;
        this.resistanceCurve = resistanceCurve;
    }

    /**
     * Returns the available acceleration for a certain speed and {@link MovementState}
     * @param currentSpeed in [m/s]
     * @return acceleration in [m/(s^2)]
     *
     * TODO Add gradient profile into mix
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

    public void updateCurves(EventBus eventBus) {
        this.speedUpCurve = AccelerationPowerCurveCalculator.calculate(eventBus);
        this.breakingPowerCurve = BreakingPowerCurveCalculator.calculate(eventBus);
        this.resistanceCurve = ResistanceCurveCalculator.calculate(eventBus);
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
