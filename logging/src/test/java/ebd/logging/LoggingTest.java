package ebd.logging;

import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.events.logger.ToLogDebugEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Arrays;

public class LoggingTest{

    private static Event cause;
    private static String causeTarget;
    private static String exceptionTarget;
    private static Exception exception;
    private static ExceptionEvent exceptionEvent;

    private static String normalTarget;
    private static NormalEvent normalEvent;

    private static String toLogTarget;
    private static ToLogEvent toLogEvent;

    private static String clockTickTarget;
    private static ClockTickEvent clockTickEvent;

    private static String toLogDebugTarget;
    private static ToLogDebugEvent toLogDebugEvent;

    /**
     * logs an ExceptionEvent, a general NormalEvent, a ToLogEvent and a ClockTickEvent which are posted on
     * a local EventBus and a global EventBus
     * @param args
     */
    public static void main(String[] args) throws IOException {
        EventBus localBus = new EventBus();
        new Logging(localBus, 4711, "TRN");
        new Logging();
        localBus.post(generateExceptionEvent());
        localBus.post(generateNormalEvent());
        localBus.post(generateToLogEvent());
        localBus.post(generateClockTickEvent());
        localBus.post(generateToLogDebugEvent());
        EventBus.getDefault().post(generateExceptionEvent());
        EventBus.getDefault().post(generateNormalEvent());
        EventBus.getDefault().post(generateToLogEvent());
        EventBus.getDefault().post(generateClockTickEvent());
        EventBus.getDefault().post(generateToLogDebugEvent());
    }

    /**
     * generates an ExceptionEvent
     * @return an ExceptionEvent
     */
    private static ExceptionEvent generateExceptionEvent(){
        causeTarget = "causeTarget1";
        cause = new Event("Source of cause", causeTarget);
        exception = new Exception();
        exceptionTarget = "exceptionTarget1";
        exceptionEvent = new ExceptionEvent("source of ExceptionEvent", exceptionTarget, cause, exception);
        return exceptionEvent;
    }

    /**
     * generates a NormalEvent
     * @return a NormalEvent
     */
    private static NormalEvent generateNormalEvent(){
        normalTarget = "normalTarget1";
        normalEvent = new NormalEvent("source of NormalEvent", normalTarget);
        return normalEvent;
    }

    /**
     * generates a ToLogEvent
     * @return a ToLogEvent
     */
    private static ToLogEvent generateToLogEvent(){
        toLogTarget = "logTarget1";
        toLogEvent = new ToLogEvent("source of ToLogEvent", toLogTarget, "logmessage");
        return toLogEvent;
    }

    /**
     * generates a ClockTickEvent (a special NormalEvent)
     * @return a ClockTickEvent
     */
    private static ClockTickEvent generateClockTickEvent(){
        clockTickTarget = "clockTickTarget1";
        clockTickEvent = new ClockTickEvent("source of ClockTickEvent", clockTickTarget, 0, 0);
        return clockTickEvent;
    }

    private static ToLogDebugEvent generateToLogDebugEvent() {
         toLogDebugTarget = "logDebugTarget1";
        toLogDebugEvent = new ToLogDebugEvent("source of ToLogDebugEvent", toLogDebugTarget, "debugmessage");
        return toLogDebugEvent;
    }
}