package ebd.globalUtils.movementState;

/**
 * MovementState describes possible movement states a train can be in.
 *
 * @author Lars Schulze-Falck
 * @version 0.1
 */
public enum MovementState {

    /**
     * The train is stopped
     */
    HALTING,

    /**
     * The train is accelerating
     */
    ACCELERATING,

    /**
     * The train is breaking
     */
    BREAKING,

    /**
     * The train is keeping its speed constant
     */
    CRUISE,

    /**
     * The train is not applying any force and is rolling out
     */
    COASTING;
}