package ebd.drivingDynamics;

import ebd.globalUtils.enums.MovementState;
import ebd.globalUtils.position.Position;
import ebd.trainData.util.availableAcceleration.AvailableAcceleration;

public class DynamicState {

    /**
     * Internal memory of current mission time in [s]
     */
    private double time;

    /**
     * Current position
     */
    private Position position;

    /**
     * Memory of the total length of the trip in [m]
     */
    private double tripDistance;

    /**
     * Distance to the start of the current trip profile
     */
    private double distanceToStartOfProfile;

    /**
     * Current speed in [m/s]
     */
    private double speed;
    /**
     * Current acceleration in [m/(s^2)]
     */
    private double acceleration;

    private final AvailableAcceleration availableAcceleration;

    /**
     * The Dynamic state. Has to be newly set at each journeys starts, which can only be done while standing still.
     * @param position Current position
     * @param availableAcceleration the {@link AvailableAcceleration} of the train
     */
    public DynamicState(Position position, AvailableAcceleration availableAcceleration) {
        this.time = 0;
        this.position = position;
        this.tripDistance = 0;
        this.distanceToStartOfProfile = 0;
        this.speed = 0;
        this.acceleration = 0;
        this.availableAcceleration = availableAcceleration;
    }

    /**
     * Calculates the next state based on the passed time
     * @param deltaT passed time between two calls.
     */
    public void nextState(double deltaT){
        this.time += deltaT;
        this.acceleration = this.availableAcceleration.getAcceleration(this.speed, this.distanceToStartOfProfile);
        this.speed += this.acceleration * deltaT;
        if(this.speed < 0) this.speed = 0;
        this.position.setIncrement(this.position.getIncrement() + this.speed * deltaT);
        this.tripDistance += this.speed * deltaT;
        this.distanceToStartOfProfile += this.speed * deltaT;
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
     * Distance already driven on the current trip in [m]
     */
    public double getTripDistance() { return tripDistance; }

    /**
     *
     * @return Distance to the start of the current trip profile in [m]
     */
    public double getDistanceToStartOfProfile() {
        return distanceToStartOfProfile;
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

    public MovementState getMovementState(){
        return this.availableAcceleration.getTargetMoveState();
    }

    /*
    Setter
     */

    /**
     *
     * @param acceleration acceleration in [m/s^2]
     */
    public void  setAcceleration(double acceleration){
        this.acceleration = acceleration;
    }

    /**
     * Sets the movementState, which decides what acceleration (speed up or breaking) will be used
     * @param movementState see {@link MovementState}
     */
    public void setMovementState(MovementState movementState) {
        this.availableAcceleration.setTargetMoveState(movementState);
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
        this.availableAcceleration.setTargetAccelerationModification(accelerationModification);
    }

    /*
    Sets the modifier for the available breaking force
     */
    public void setBreakingModification(double breakingModification) {
        this.availableAcceleration.setTargetBreakingModification(breakingModification);
    }

    public void setDistanceToStartOfProfile(double distance){
        this.distanceToStartOfProfile = distance;
    }
}
