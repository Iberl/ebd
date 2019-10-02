import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoggingTest{

    private static Event cause;
    private static List<String> causeTargets;
    private static List<String> exceptionTargets;
    private static Exception exception;
    private static ExceptionEvent exceptionEvent;

    private static List<String> normalTargets;
    private static NormalEvent normalEvent;

    private static List<String> toLogTargets;
    private static ToLogEvent toLogEvent;

    private static List<String> clockTickTargets;
    private static ClockTickEvent clockTickEvent;

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
        EventBus.getDefault().post(generateExceptionEvent());
        EventBus.getDefault().post(generateNormalEvent());
        EventBus.getDefault().post(generateToLogEvent());
        EventBus.getDefault().post(generateClockTickEvent());
    }

    /**
     * generates an ExceptionEvent
     * @return an ExceptionEvent
     */
    private static ExceptionEvent generateExceptionEvent(){
        causeTargets = Arrays.asList("causeTarget1", "causeTarget2");
        cause = new Event("Source of cause", causeTargets);
        exception = new Exception();
        exceptionTargets = Arrays.asList("exceptionTarget1", "exceptionTarget2");
        exceptionEvent = new ExceptionEvent("source of ExceptionEvent", exceptionTargets, cause, exception);
        return exceptionEvent;
    }

    /**
     * generates a NormalEvent
     * @return a NormalEvent
     */
    private static NormalEvent generateNormalEvent(){
        normalTargets = Arrays.asList("normalTarget1", "normalTarget2");
        normalEvent = new NormalEvent("source of NormalEvent", normalTargets);
        return normalEvent;
    }

    /**
     * generates a ToLogEvent
     * @return a ToLogEvent
     */
    private static ToLogEvent generateToLogEvent(){
        toLogTargets = Arrays.asList("logTarget1", "logTarget2");
        toLogEvent = new ToLogEvent("source of ToLogEvent", toLogTargets, "logmessage");
        return toLogEvent;
    }

    /**
     * generates a ClockTickEvent (a special NormalEvent)
     * @return a ClockTickEvent
     */
    private static ClockTickEvent generateClockTickEvent(){
        clockTickTargets = Arrays.asList("clockTickTarget1", "clockTickTarget2");
        clockTickEvent = new ClockTickEvent("source of ClockTickEvent", clockTickTargets);
        return clockTickEvent;
    }
}