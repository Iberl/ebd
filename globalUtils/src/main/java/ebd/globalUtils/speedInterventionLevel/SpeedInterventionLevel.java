package ebd.globalUtils.speedInterventionLevel;

public enum SpeedInterventionLevel {
    /**
     * Speed is uncritical
     */
    NO_INTERVENTION,

    /**
     * Speed may become to high
     */
    INDICATION,

    /**
     * Speed will become to high soon
     */
    PERMITTED_SPEED,

    /**
     * Speed will become to high very soon
     */
    WARNING,

    /**
     * As required by SRS 3.13
     * Signals the need to cut of traction.
     */
    CUT_OFF_TRACTION,

    /**
     * Speed will become to high, service breaks will be applied automatically
     */
    APPLY_SERVICE_BREAKS,

    /**
     * Speed is to high, danger point is passed, etc., emergency breaks will be applied automatically
      */
    APPLY_EMERGENCY_BREAKS
}
