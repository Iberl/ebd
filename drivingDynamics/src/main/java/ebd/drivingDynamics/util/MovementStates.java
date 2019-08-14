package ebd.drivingDynamics.util;

public enum MovementStates {

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
    Costing;
}
