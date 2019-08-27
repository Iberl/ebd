package ebd.drivingDynamics;

import ebd.globalUtils.movementState.MovementState;
import ebd.globalUtils.position.Position;
import ebd.trainData.util.curveCalculation.AvailableAcceleration;

public class DynamicState {

    /**
     * Current mission time in [s]
     */
    private double time;

    /**
     * Current position
     */
    private Position position;

    /**
     * Current speed in [m/s]
     */
    private double speed;

    /**
     * Current acceleration in [m/(s^2)]
     */
    private double acceleration;

    /**
     * Current movement state as defined in {@link MovementState}
     */
    private MovementState movementState;


    private AvailableAcceleration availableAcceleration;

    public DynamicState(double time, Position position, double speed, double acceleration, MovementState movementState, AvailableAcceleration availableAcceleration) {
        this.time = time;
        this.position = position;
        this.speed = speed;
        this.acceleration = acceleration;
        this.movementState = movementState;
        this.availableAcceleration = availableAcceleration;
    }

    public void nextState(double deltaT){
        this.time = time + deltaT;
        this.acceleration = availableAcceleration.getAcceleration(this.speed, this.movementState);
        this.speed = this.acceleration * deltaT;
        this.position.setIncrement(this.position.getIncrement() + this.speed * deltaT);
    }

    /*
    Getters
     */

    /**
     * Current mission time in [s]
     */
    public double getTime() {
        return time;
    }

    /**
     * Current position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Current speed in [m/s]
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Current acceleration in [m/(s^2)]
     */
    public double getAcceleration() {
        return acceleration;
    }

    /**
     * Current movement state as defined in {@link MovementState}
     */
    public Enum getMovementState() {
        return movementState;
    }

    /*
    Setter
     */

    /**
     * Sets the movementState, which decides what acceleration (speed up or breaking) will be used
     * @param movementState see {@link MovementState}
     */
    public void setMovementState(MovementState movementState) {
        this.movementState = movementState;
    }

    /**
     * Sets the position
     * @param position see {@link Position}
     */
    public void setPosition(Position position){
        this.position = position;
    }

    /*
    Sets the modifier for the available acceleration force
     */
    public void setAccelerationModification(double accelerationModification) {
        this.availableAcceleration.setAccelerationModification(accelerationModification);
    }

    /*
    Sets the modifier for the available breaking force
     */
    public void setBreakingModification(double breakingModification) {
        this.availableAcceleration.setBreakingModification(breakingModification);
    }
}
