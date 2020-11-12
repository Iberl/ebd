package ebd.tmsDummy.util;

import ebd.globalUtils.events.tmsDummy.ExceptionEvent;
import ebd.globalUtils.events.logger.ToLogDebugEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import org.greenrobot.eventbus.EventBus;

public class Utils {

    private static EventBus eventBus = EventBus.getDefault();

    public static void log(String msg) {
        eventBus.post(new ToLogEvent("tms", "log", msg));
    }

    public static void log(Exception e) {
        eventBus.post(new ExceptionEvent("tms", "log", e));
    }

    public static void logDebug(String msg) {
        eventBus.post(new ToLogDebugEvent("tms", "log", msg));
    }
}
