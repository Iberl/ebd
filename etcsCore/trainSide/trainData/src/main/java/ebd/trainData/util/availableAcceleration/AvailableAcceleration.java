package ebd.trainData.util.availableAcceleration;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.etcsPacketConverters.GradientProfileConverter;
import ebd.globalUtils.enums.MovementState;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
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

    private ForwardSpline risingJoltCurve;

    private ForwardSpline fallingJoltCurve;

    private ForwardSpline emergencyRisingJoltCurve;

    private ForwardSpline emergencyFallingJoltCurve;

    private double targetAccelerationModification = 1d;

    private double targetBreakingModification = 1d;

    private double curTargetMod = 0;

    private double curMod = 0;

    private MovementState targetMoveState = MovementState.HALTING;

    private MovementState curMoveState = MovementState.HALTING;

    public AvailableAcceleration(EventBus eventBus){
        this.eventBus = eventBus;
        this.rdv = this.eventBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
        this.accGradientProfile = GradientProfileConverter.packet21ToAccGP(this.rdv.getPacket_21(),this.rdv.getCurrentGradient());

        this.risingJoltCurve = new ForwardSpline(0);
        this.risingJoltCurve.addKnotToCurve(new Knot(-1d, 1d/ch.breakFallTime));
        this.risingJoltCurve.addKnotToCurve(new Knot(0d, 1d/ch.accRiseTime));

        this.fallingJoltCurve = new ForwardSpline(0);
        this.fallingJoltCurve.addKnotToCurve(new Knot(-1d, 1d/ch.breakRiseTime));
        this.fallingJoltCurve.addKnotToCurve(new Knot(0d, 1d/ch.accFallTime));

        this.emergencyRisingJoltCurve = new ForwardSpline(0);
        this.emergencyRisingJoltCurve.addKnotToCurve(new Knot(-1d, 1d/ch.emBreakFallTime));
        this.emergencyRisingJoltCurve.addKnotToCurve(new Knot(0d, 1d/ch.accRiseTime));

        this.emergencyFallingJoltCurve = new ForwardSpline(0);
        this.emergencyFallingJoltCurve.addKnotToCurve(new Knot(-1d, 1d/ch.emBreakRiseTime));
        this.emergencyFallingJoltCurve.addKnotToCurve(new Knot(0d, 1d/ch.accFallTime));

        updateCurves();

        this.eventBus.register(this);
    }

    /**
     * Returns the available acceleration for a certain speed and {@link MovementState}
     * @param currentSpeed in [m/s]
     * @param tripDistance in [m], starting at the reference location of the gradient profile
     * @return acceleration in [m/(s^2)]
     * @throws IllegalArgumentException Thrown if an unknown MovementState is applied.
     */
    public double getAcceleration(double currentSpeed, double tripDistance)
                        throws IllegalArgumentException {
        //If positiv, trackDeceleration slows the train down. If negativ, speeds it up.
        double trackDeceleration = resistanceCurve.getPointOnCurve(currentSpeed) + accGradientProfile.getPointOnCurve(tripDistance);
        switch (this.curMoveState){
            case HALTING -> {
                if(currentSpeed == 0) return 0; //The trains was able to stop, so it will be able to stand still.

                double maxAcc = getMaxAcc(currentSpeed, MovementState.SERVICE_BREAKING);
                if(trackDeceleration < 0 && maxAcc > trackDeceleration) {
                    System.out.println("Couldn't break, gradient was to big"); //Train can not stand still
                    return getTimeBasedAcc(currentSpeed) - trackDeceleration;
                }
                //Train can halt, breaking in progress
                return getTimeBasedAcc(currentSpeed);

            }
            case CRUISE -> {
                double maxAcc = getMaxAcc(currentSpeed, MovementState.ACCELERATING);
                if(maxAcc > trackDeceleration) return getTimeBasedAcc(currentSpeed);
                else return getTimeBasedAcc(currentSpeed) - trackDeceleration;
            }
            default -> {
                return getTimeBasedAcc(currentSpeed) - trackDeceleration;
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
    public void clockTick(ClockTickEvent cte){
        double deltaT = cte.deltaT;

        switch (this.targetMoveState){

            case HALTING, CRUISE, COASTING -> {
                if(this.curMod == 0) this.curMoveState = this.targetMoveState;
                this.curTargetMod = 0;
            }
            case ACCELERATING -> {
                if(this.curMod > 0) this.curMoveState = this.targetMoveState;
                this.curTargetMod = this.targetAccelerationModification;
            }
            case NORMAL_BREAKING, SERVICE_BREAKING -> {
                if(this.curMod < 0) this.curMoveState = this.targetMoveState;
                this.curTargetMod = -this.targetBreakingModification;
            }
            default -> {
                String msg = "Illegal MovementState reached";
                IllegalArgumentException iae = new IllegalArgumentException(msg);
                this.eventBus.post(new ExceptionEvent("td", "tsm", iae, ExceptionEventTyp.FATAL));
            }
        }

        if(this.curMoveState == MovementState.EMERGENCY_BREAKING) {
            if (this.curMod > this.curTargetMod) {
                double jolt = emergencyFallingJoltCurve.getPointOnCurve(this.curMod);
                double nextMod = this.curMod - jolt * deltaT;
                this.curMod = Math.max(this.curTargetMod, nextMod);
            } else if (this.curMod < this.curTargetMod) {
                double jolt = emergencyRisingJoltCurve.getPointOnCurve(this.curMod);
                double nextMod = this.curMod + jolt * deltaT;
                this.curMod = Math.min(this.curTargetMod, nextMod);
            }
        }
        else {
            if (this.curMod > this.curTargetMod) {
                double jolt = fallingJoltCurve.getPointOnCurve(this.curMod);
                double nextMod = this.curMod - jolt * deltaT;
                this.curMod = Math.max(this.curTargetMod, nextMod);
            } else if (this.curMod < this.curTargetMod) {
                double jolt = risingJoltCurve.getPointOnCurve(this.curMod);
                double nextMod = this.curMod + jolt * deltaT;
                this.curMod = Math.min(this.curTargetMod, nextMod);
            }
        }
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
     * For simplicity, it is assumed that the power rises and falls linear through the rise and fall times.
     * @return Acceleration in m/s^2
     */
    private double getTimeBasedAcc(double currentSpeed){
        return Math.abs(this.curMod) * getMaxAcc(currentSpeed, this.curMoveState);
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

    public MovementState getTargetMoveState(){
        return this.targetMoveState;
    }

    public double getTargetAccelerationModification() {
        return targetAccelerationModification;
    }

    public double getTargetBreakingModification() {
        return targetBreakingModification;
    }

    /*
    Setter
     */

    public void setTargetMoveState(MovementState targetMoveState){
        if(targetMoveState == MovementState.UNCHANGED) return;
        this.targetMoveState = targetMoveState;
    }

    public void setTargetAccelerationModification(double targetAccelerationModification) {
        if(targetAccelerationModification > 0) this.targetAccelerationModification = targetAccelerationModification;
    }

    public void setTargetBreakingModification(double targetBreakingModification) {
        if(targetBreakingModification > 0) this.targetBreakingModification = targetBreakingModification;
    }
}
