package ebd.globalUtils.speedInterventionLevel;

public enum SpeedInterventionLevel {
    /**
     * Speed is uncritical
     */
    NO_INTERVENTION,

    /**
     * Speed will become to high in 9s
     */
    INDICATION,

    /**
     * Speed will become to high
     */
    WARNING,

    /**
     * Speed is to high, apply service breaks
     */
    APPLY_SERVICE_BREAKS,

    /**
     * Speed is far to high, apply emergency breaks
      */
    APPLY_EMERGENCY_BREAKS
}
