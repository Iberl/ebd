package ebd.globalUtils.speedSupervisionState;

/**
 * Represents the state of the speed supervision module (SSM), which can be either
 * ceiling speed supervision (CSS) or target speed supervision (TSS).<br>
 * In CSS, the SSM expects a constant maximum speed and checks, if this speed is not exceeded by
 * more than a given margin.<br>
 * In TSS, the SSM expect a constant reduction of the maximum speed and checks that a breaking curve is not
 * exceeded.
 */
public enum SpeedSupervisionState {
    /**
     * Null replacement value
     */
    NOT_SET,

    CEILING_SPEED_SUPERVISION,
    TARGET_SPEED_SUPERVISION
}
