package ebd.trainData.util.availableAcceleration;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.etcsPacketConverters.GradientProfileConverter;
import ebd.globalUtils.enums.MovementState;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class AvailableAcceleration {
    private final ConfigHandler ch = ConfigHandler.getInstance();

    private final EventBus eventBus;

    private final RouteDataVolatile rdv;

    private ForwardSpline speedUpCurve;

    private ForwardSpline serviceBreakingCurve;

    private ForwardSpline emergencyBreakingCurve;

    private ForwardSpline normalBreakingCurve;

    private ForwardSpline resistanceCurve;

    private ForwardSpline accGradientProfile;

    private double accelerationModification = 1d;

    private double breakingModification = 1d;

    private MovementState awaitedMoveState = MovementState.UNCHANGED;
    private MovementState curMoveState = MovementState.UNCHANGED;

    private long timeAtLastChange = 0;
    private double curTimeToChange = 0;

    public AvailableAcceleration(EventBus eventBus){
        this.eventBus = eventBus;
        this.eventBus.register(this);
        this.rdv = this.eventBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
        this.accGradientProfile = GradientProfileConverter.packet21ToAccGP(this.rdv.getPacket_21(),this.rdv.getCurrentGradient());
        updateCurves();
    }

    /**
     * Returns the available acceleration for a certain speed and {@link MovementState}
     * @param currentSpeed in [m/s]
     * @param tripDistance in [m], starting at the reference location of the gradient profile
     * @return acceleration in [m/(s^2)]
     * @throws IllegalArgumentException Thrown if an unknown MovementState is applied.
     */
    public double getAcceleration(double currentSpeed, double tripDistance, MovementState movementState)
                        throws IllegalArgumentException {
        switch (movementState){
            case UNCHANGED:
            case HALTING:
            case CRUISE:
                return 0d; //TODO Check if 0 is possible
            case ACCELERATING:
                double acceleration = speedUpCurve.getPointOnCurve(currentSpeed) * accelerationModification;
                acceleration += resistanceCurve.getPointOnCurve(currentSpeed);
                acceleration -= accGradientProfile.getPointOnCurve(tripDistance);
                return acceleration;
            case NORMAL_BREAKING:
                double normalDeceleration = - normalBreakingCurve.getPointOnCurve(currentSpeed) * breakingModification;
                normalDeceleration += resistanceCurve.getPointOnCurve(currentSpeed);
                normalDeceleration -= accGradientProfile.getPointOnCurve(tripDistance);
                return  normalDeceleration;
            case SERVICE_BREAKING:
                double serviceDeceleration = - serviceBreakingCurve.getPointOnCurve(currentSpeed) * breakingModification;
                serviceDeceleration += resistanceCurve.getPointOnCurve(currentSpeed);
                serviceDeceleration -= accGradientProfile.getPointOnCurve(tripDistance);
                return  serviceDeceleration;
            case EMERGENCY_BREAKING:
                double emergencyDeceleration = - emergencyBreakingCurve.getPointOnCurve(currentSpeed);
                emergencyDeceleration += resistanceCurve.getPointOnCurve(currentSpeed);
                emergencyDeceleration -= accGradientProfile.getPointOnCurve(tripDistance);
                return  emergencyDeceleration;
            case COASTING:
                return resistanceCurve.getPointOnCurve(currentSpeed) - accGradientProfile.getPointOnCurve(tripDistance);
            default:
                throw new IllegalArgumentException("This MovementState was not caught by AvailableAcceleration");
        }
    }

    public void updateCurves() {
        this.speedUpCurve = AccelerationPowerCurveCalculator.calculate(this.eventBus);
        this.normalBreakingCurve = BreakingPowerCurveCalculator.calculateNormalBreakingPower(this.eventBus);
        this.serviceBreakingCurve = BreakingPowerCurveCalculator.calculateServiceBreakingPower(this.eventBus);
        this.emergencyBreakingCurve = BreakingPowerCurveCalculator.calculateEmergencyBreakingPower(this.eventBus);
        this.resistanceCurve = ResistanceCurveCalculator.calculate(this.eventBus);
    }

    @Subscribe
    public void updateGradientProfile(NewRouteDataVolatileEvent nrdve){
        this.accGradientProfile = GradientProfileConverter.packet21ToAccGP(this.rdv.getPacket_21(),this.rdv.getCurrentGradient());
    }

    /**
     * Calculates the current available acceleration based on the time since last change of the movement state and the
     * riseTimes and fallTimes set in the ConfigHandler, with the maximal value given by the current available power and
     * the modification value.
     * @param currentSpeed current Speed
     * @param movementState current
     * @return Acceleration in m/s^2
     */
    private double getTimeBasedAcc(double currentSpeed, MovementState movementState){
        double timeSinceChange = System.currentTimeMillis() - this.timeAtLastChange;

        double curAcc = switch (this.curMoveState){
            case ACCELERATING -> speedUpCurve.getPointOnCurve(currentSpeed);
            case NORMAL_BREAKING -> -normalBreakingCurve.getPointOnCurve(currentSpeed);
            case SERVICE_BREAKING -> -serviceBreakingCurve.getPointOnCurve(currentSpeed);
            case EMERGENCY_BREAKING -> -emergencyBreakingCurve.getPointOnCurve(currentSpeed);
            default -> 0;
        };

        double curModification = switch (this.curMoveState){
            case ACCELERATING -> this.accelerationModification;
            default -> this.breakingModification;
        };

        if(this.awaitedMoveState != movementState) {//Detecting a switch in requested movement
            this.timeAtLastChange = System.currentTimeMillis();
            this.awaitedMoveState = movementState;

            double timeToChange = switch (this.awaitedMoveState){
                case ACCELERATING -> ch.accFallTime;
                case NORMAL_BREAKING, SERVICE_BREAKING, EMERGENCY_BREAKING -> ch.breakFallTime;
                default -> 0;
            };
            double timeMod = this.curTimeToChange == 0 ? 0 : Math.min(timeSinceChange / this.curTimeToChange, 1);
            this.curTimeToChange = timeToChange * timeMod * curModification;

            timeSinceChange = 0;
        }

        if(timeSinceChange >= this.curTimeToChange && this.curMoveState == this.awaitedMoveState){
            return curAcc * curModification;
        }
        else if(timeSinceChange >= this.curTimeToChange && this.curMoveState != this.awaitedMoveState){
            this.curMoveState = this.awaitedMoveState;
            this.timeAtLastChange = System.currentTimeMillis();
            this.curTimeToChange = switch (this.awaitedMoveState){
                case ACCELERATING -> ch.accRiseTime;
                case NORMAL_BREAKING, SERVICE_BREAKING, EMERGENCY_BREAKING -> ch.breakRiseTime;
                default -> 0;
            };
            return 0;
        }
        else if(timeSinceChange < this.curTimeToChange && this.curMoveState == this.awaitedMoveState){
            double timeBasedMod = (this.curTimeToChange == 0) ? 1 : Math.min(timeSinceChange / this.curTimeToChange, 1);
            return Math.min(curAcc * timeBasedMod, curAcc * curModification);
        }
        else {
            double timeBasedMod = (this.curTimeToChange == 0) ? 0 : Math.min(1 - (timeSinceChange / this.curTimeToChange), 0);
            return Math.min(curAcc * timeBasedMod, curAcc * curModification);
        }
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
