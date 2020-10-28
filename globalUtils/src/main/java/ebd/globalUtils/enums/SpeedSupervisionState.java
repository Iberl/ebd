package ebd.globalUtils.enums;

/**
 * Represents the state of the speed supervision module (SSM), which can be either
 * ceiling speed supervision mode (CSM), target speed supervision mode (TSM) or release speed supervision mode (RSM).<br>
 *     In CSM, the SSM expects a constant maximum speed and checks, if this speed is not exceeded by
 * more than a given margin.<br>
 *     In TSM, the SSM expect a constant reduction of the maximum speed and checks that a breaking curve is not
 * exceeded.<br>
 *     In RSM, the SSM only supervises the current release speed of the train.<br>
 */
public enum SpeedSupervisionState {
    /**
     * Null replacement value
     */
    NOT_SET,

    RELEASE_SPEED_SUPERVISION,
    CEILING_SPEED_SUPERVISION,
    TARGET_SPEED_SUPERVISION;
}
