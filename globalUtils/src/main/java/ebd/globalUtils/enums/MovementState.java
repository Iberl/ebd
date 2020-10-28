package ebd.globalUtils.enums;

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
     * The train is braking with reduced breaks.
     */
    NORMAL_BREAKING,

    /**
     * The train is breaking with the service breaks
     */
    SERVICE_BREAKING,

    /**
     * The train is breaking with the emergency breaks
     */
    EMERGENCY_BREAKING,

    /**
     * The train is keeping its speed constant
     */
    CRUISE,

    /**
     * The train is not applying any force and is rolling out
     */
    COASTING,

    /**
     * The train has the same movement state as before
     */
    UNCHANGED
}