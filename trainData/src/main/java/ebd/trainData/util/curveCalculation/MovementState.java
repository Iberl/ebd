package ebd.trainData.util.curveCalculation;


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
