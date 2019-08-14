package ebd.drivingDynamics;

import ebd.globalUtils.position.Position;

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
     * Current movement state as defined in {@link ebd.drivingDynamics.util.MovementStates}
     */
    private Enum movementState;

    public DynamicState(double time, Position position, double speed, double acceleration, Enum movementState) {
        this.time = time;
        this.position = position;
        this.speed = speed;
        this.acceleration = acceleration;
        this.movementState = movementState;
    }

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
     * Current movement state as defined in {@link ebd.drivingDynamics.util.MovementStates}
     */
    public Enum getMovementState() {
        return movementState;
    }
}
