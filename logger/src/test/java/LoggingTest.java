import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.NormalEvent;
import org.greenrobot.eventbus.EventBus;

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

    /**
     * logs an exceptionEvent and a normalEvent after initializing a new logging object
     * @param args
     */
    public static void main(String[] args){
        new Logging(EventBus.getDefault());
        logExceptionEvent();
        logNormalEvent();
    }

    /**
     * sends an exceptionEvent to global event bus
     */
    public static void logExceptionEvent(){
        EventBus.getDefault().post(generateExceptionEvent());
    }

    /**
     * sends an normalEvent to global event bus
     */
    public static void logNormalEvent(){
        EventBus.getDefault().post(generateNormalEvent());
    }

    /**
     * generates an exceptionEvent
     * @return exceptionEvent
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
     * generates a normalEvent
     * @return normalEvent
     */
    private static NormalEvent generateNormalEvent(){
        normalTargets = Arrays.asList("normalTarget1", "normalTarget2");
        normalEvent = new NormalEvent("source of NormalEvent", normalTargets);
        return normalEvent;
    }
}