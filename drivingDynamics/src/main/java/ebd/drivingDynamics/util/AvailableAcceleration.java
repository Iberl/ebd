package ebd.drivingDynamics.util;

import ebd.globalUtils.spline.ForwardSpline;

public class AvailableAcceleration {

    private ForwardSpline speedUpCurve;

    private ForwardSpline breakingPowerCurve;

    private ForwardSpline resistanceCurve;

    public AvailableAcceleration(ForwardSpline speedUpCurve, ForwardSpline breakingPowerCurve, ForwardSpline resistanceCurve) {
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
                return speedUpCurve.getPointOnCurve(currentSpeed) + resistanceCurve.getPointOnCurve(currentSpeed);
            case BREAKING:
                return - breakingPowerCurve.getPointOnCurve(currentSpeed) + resistanceCurve.getPointOnCurve(currentSpeed);
            case COASTING:
                return resistanceCurve.getPointOnCurve(currentSpeed);
            default:
                throw new IllegalArgumentException("This MovementState was not caught by AvailableAcceleration");
        }
    }


}
