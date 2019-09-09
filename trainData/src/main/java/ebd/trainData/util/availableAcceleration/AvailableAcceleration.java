package ebd.trainData.util.availableAcceleration;

import ebd.globalUtils.etcsPacketToSplineConverters.GradientProfileConverter;
import ebd.globalUtils.movementState.MovementState;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class AvailableAcceleration {

    private EventBus eventBus;

    private double accelerationModification = 1d;

    private double breakingModification = 1d;

    private ForwardSpline speedUpCurve;

    private ForwardSpline breakingPowerCurve;

    private ForwardSpline emergencyBreakingPowerCurve;

    private ForwardSpline resistanceCurve;

    private ForwardSpline gradientProfile;

    public AvailableAcceleration(EventBus eventBus){
        this.eventBus = eventBus;
        this.eventBus.register(this);
        RouteDataVolatile rdv = this.eventBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
        this.gradientProfile = GradientProfileConverter.package21ToGP(rdv.getPacket_21(),rdv.getCurrentGradient());
        updateCurves();
    }


    public AvailableAcceleration(ForwardSpline speedUpCurve, ForwardSpline breakingPowerCurve, ForwardSpline resistanceCurve) {
        this.speedUpCurve = speedUpCurve;
        this.breakingPowerCurve = breakingPowerCurve;
        this.resistanceCurve = resistanceCurve;
    }

    /**
     * Returns the available acceleration for a certain speed and {@link MovementState}
     * @param currentSpeed in [m/s]
     * @param tripDistance in [m], starting at the reference location of the gradient profile
     * @return acceleration in [m/(s^2)]
     */
    public double getAcceleration(double currentSpeed, double tripDistance, MovementState movementState){
        switch (movementState){
            case HALTING:
            case CRUISE:
                return 0d;
            case ACCELERATING:
                double acceleration = speedUpCurve.getPointOnCurve(currentSpeed) * accelerationModification;
                acceleration += resistanceCurve.getPointOnCurve(currentSpeed);
                acceleration -= gradientProfile.getPointOnCurve(tripDistance);
                return acceleration;
            case BREAKING:
                double deceleration = - breakingPowerCurve.getPointOnCurve(currentSpeed) * breakingModification;
                deceleration += resistanceCurve.getPointOnCurve(currentSpeed);
                deceleration -= gradientProfile.getPointOnCurve(tripDistance);
                return  deceleration;
            case COASTING:
                return resistanceCurve.getPointOnCurve(currentSpeed) - gradientProfile.getPointOnCurve(tripDistance);
            default:
                throw new IllegalArgumentException("This MovementState was not caught by AvailableAcceleration");
        }
    }

    public void updateCurves() {
        this.speedUpCurve = AccelerationPowerCurveCalculator.calculate(this.eventBus);
        this.breakingPowerCurve = BreakingPowerCurveCalculator.calculateBreakingPower(this.eventBus);
        this.emergencyBreakingPowerCurve = BreakingPowerCurveCalculator.calculateEmergencyBreakingPower(this.eventBus);
        this.resistanceCurve = ResistanceCurveCalculator.calculate(this.eventBus);
    }

    @Subscribe
    public void updateGradientProfile(NewRouteDataVolatileEvent nrdve){
        RouteDataVolatile rdv = nrdve.routeDataVolatile;
        this.gradientProfile = GradientProfileConverter.package21ToGP(rdv.getPacket_21(),rdv.getCurrentGradient());
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
