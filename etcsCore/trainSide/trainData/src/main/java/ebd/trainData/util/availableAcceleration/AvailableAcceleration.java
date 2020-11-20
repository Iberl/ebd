package ebd.trainData.util.availableAcceleration;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.etcsPacketConverters.GradientProfileConverter;
import ebd.globalUtils.enums.MovementState;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Knot;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
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

    private double timeAtLastChange = 0;
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
        //If positiv, trackDeceleration slows the train down. If negativ, speeds it up.
        double trackDeceleration = resistanceCurve.getPointOnCurve(currentSpeed) + accGradientProfile.getPointOnCurve(tripDistance);
        switch (movementState){
            case HALTING -> {
                if(currentSpeed == 0) return 0; //The trains was able to stop, so it will be able to stand still.

                double maxAcc = getMaxAcc(currentSpeed, MovementState.SERVICE_BREAKING);
                if(trackDeceleration < 0 && maxAcc > trackDeceleration) {
                    System.out.println("Couldn't break, gradient was to big"); //Train can not stand still
                    return getTimeBasedAcc(currentSpeed,MovementState.SERVICE_BREAKING) - trackDeceleration;
                }
                //Train can halt, breaking in progress
                return getTimeBasedAcc(currentSpeed, MovementState.SERVICE_BREAKING);

            }
            case CRUISE -> {
                double maxAcc = getMaxAcc(currentSpeed, MovementState.ACCELERATING);
                if(maxAcc > trackDeceleration) return getTimeBasedAcc(currentSpeed, movementState);
                else return getTimeBasedAcc(currentSpeed,movementState) - trackDeceleration;
            }
            default -> {
                return getTimeBasedAcc(currentSpeed,movementState) - trackDeceleration;
            }
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
        RouteDataVolatile rdv = nrdve.routeDataVolatile;
        Packet_21 packet21 = rdv.getPacket_21();
        if(packet21 == null) {
            ForwardSpline fs = new ForwardSpline(0);
            fs.addKnotToCurve(new Knot(0d,rdv.getCurrentGradient() * GradientProfileConverter.GRAD_TO_ACC_FACTOR));
            this.accGradientProfile = fs;
        }
        else this.accGradientProfile = GradientProfileConverter.packet21ToAccGP(packet21,rdv.getCurrentGradient());
    }

    /**
     * Calculates the current available acceleration based on the time since last change of the movement state and the
     * riseTimes and fallTimes set in the ConfigHandler, with the maximal value given by the current available power and
     * the modification value.<br>
     *     To archive this for different MovementStates, there are two phases of transitioning.
     *     First the power of the current MovementState is reduced, until it reaches 0 (phase one). Then the MovementState is switched
     *     to the new MovementState and the power is increased until full power is archived (phase two).<br>
     * For simplicity, it is assumed that the power rises and falls linear through the rise and fall times.
     * @param currentSpeed current Speed
     * @param movementState current
     * @return Acceleration in m/s^2
     */
    private double getTimeBasedAcc(double currentSpeed, MovementState movementState){
        System.out.println("-----");
        double timeSinceChange = System.currentTimeMillis() - this.timeAtLastChange;

        double curMaxAcc = getMaxAcc(currentSpeed, this.curMoveState);

        double curModification = switch (this.curMoveState){
            case ACCELERATING -> this.accelerationModification;
            case NORMAL_BREAKING, SERVICE_BREAKING, EMERGENCY_BREAKING -> this.breakingModification;
            default -> 1;
        };
        boolean change = this.awaitedMoveState != movementState && movementState != MovementState.UNCHANGED;
        if (change && this.awaitedMoveState != this.curMoveState){

            this.awaitedMoveState = movementState;
            //Detecting a switch in requested movement, being already in phase one, so only the target is changed
            if(movementState != this.curMoveState) this.awaitedMoveState = movementState;
            //Detecting a switch in requested movement, being in phase one but change directly into phase 2
            else {
                double timeToChange = switch (this.curMoveState) {
                    case ACCELERATING -> ch.accRiseTime;
                    case NORMAL_BREAKING, SERVICE_BREAKING -> ch.breakRiseTime;
                    case EMERGENCY_BREAKING -> ch.emBreakRiseTime;
                    default -> 0;
                };
                //
                timeSinceChange = timeToChange * Math.min(1, timeSinceChange/this.curTimeToChange);
                this.curTimeToChange = timeToChange;
                this.timeAtLastChange = System.currentTimeMillis() - timeSinceChange;
            }
        }
        else if(change) {
            //Detecting a switch in requested movement, starting transition phase one
            this.timeAtLastChange = System.currentTimeMillis() / 1000.0;
            this.awaitedMoveState = movementState;

            double timeToChange = switch (this.curMoveState){
                case ACCELERATING -> ch.accFallTime;
                case NORMAL_BREAKING, SERVICE_BREAKING -> ch.breakFallTime;
                case EMERGENCY_BREAKING -> ch.emBreakFallTime;
                default -> 0;
            };
            /*
             timeMod is the percentage of the completion of the last change. If the last change was only half completed,
             it should only take half the time to change it again. This is a reasonable simplification.
            */
            double timeMod = this.curTimeToChange == 0 ? 0 : Math.min(timeSinceChange / this.curTimeToChange, 1);
            /*
             curTimeToChange is the time we need to for phase one. The full time needed for a change
             from full power to 0 power has to be modified, because we could either not have completed a previous
             transition phase or we do not use full power.
             */
            this.curTimeToChange = timeToChange * Math.min(timeMod, curModification);

            System.out.println("CurT: " + this.curTimeToChange);

            timeSinceChange = 0;
        }

        System.out.println("awaitedMoveState: " + this.awaitedMoveState);
        System.out.println("curMoveState: " + this.curMoveState);
        System.out.println("timeSinceChange: " + timeSinceChange);

        if(timeSinceChange >= this.curTimeToChange && this.curMoveState == this.awaitedMoveState){
            System.out.println("case1");
            //MovementState has been transitioned to full power, phase two is complete
            return curMaxAcc * curModification;
        }
        else if(timeSinceChange >= this.curTimeToChange && this.curMoveState != this.awaitedMoveState){
            System.out.println("case2");
            //Transition from current MovementState to awaited MovementState has been reached, starting phase two
            this.curMoveState = this.awaitedMoveState;
            this.timeAtLastChange = System.currentTimeMillis() / 1000.0;
            this.curTimeToChange = switch (this.awaitedMoveState){
                case ACCELERATING -> ch.accRiseTime;
                case NORMAL_BREAKING, SERVICE_BREAKING -> ch.breakRiseTime;
                case EMERGENCY_BREAKING -> ch.emBreakRiseTime;
                default -> 0;
            };
            System.out.println("CurT2: " + this.curTimeToChange);
            return 0;
        }
        else if(timeSinceChange < this.curTimeToChange && this.curMoveState == this.awaitedMoveState){
            System.out.println("case3");
            System.out.println("CurT2: " + this.curTimeToChange);
            System.out.println("CurTS: " + timeSinceChange);
            //Operating in phase two.
            double timeBasedMod = (this.curTimeToChange == 0) ? 1 : Math.min(timeSinceChange / this.curTimeToChange, 1);
            System.out.println("tbasedMod: " + timeBasedMod);
            System.out.println("curMaxAcc: " + curMaxAcc);
            return curMaxAcc * Math.min(timeBasedMod, curModification);
        }
        else {
            System.out.println("case4");
            //Operating in phase one.
            System.out.println("CurT2: " + this.curTimeToChange);
            System.out.println("CurTS: " + timeSinceChange);
            System.out.println("curMaxAcc: " + curMaxAcc);
            double timeBasedMod = (this.curTimeToChange == 0) ? 0 : Math.max(1 - (timeSinceChange / this.curTimeToChange), 0);
            return curMaxAcc * Math.min(timeBasedMod, curModification);
        }
    }

    private double getMaxAcc(double currentSpeed, MovementState ms){
        return switch (ms){
            case ACCELERATING -> speedUpCurve.getPointOnCurve(currentSpeed);
            case NORMAL_BREAKING -> -normalBreakingCurve.getPointOnCurve(currentSpeed);
            case SERVICE_BREAKING -> -serviceBreakingCurve.getPointOnCurve(currentSpeed);
            case EMERGENCY_BREAKING -> -emergencyBreakingCurve.getPointOnCurve(currentSpeed);
            default -> 0;
        };
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
        if(accelerationModification > 0) this.accelerationModification = accelerationModification;
    }

    public void setBreakingModification(double breakingModification) {
        this.breakingModification = breakingModification;
    }
}
