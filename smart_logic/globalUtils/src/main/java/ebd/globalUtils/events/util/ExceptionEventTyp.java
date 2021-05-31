package ebd.globalUtils.events.util;

public enum ExceptionEventTyp {

    /**
     *The exception has to be logged, but not handled.
     */
    WARNING,

    /**
     *The exception can be handled inside this instance of a train.
     */
    NONCRITICAL,

    /**
     *The exception can not be handled inside this instance of a train.
     */
    CRITICAL,

    /**
     *The exception can not be handled inside the program.
     */
    FATAL
}
