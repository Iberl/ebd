import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.NormalEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Logging{

    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private EventBus eventBus;

    public Logging(EventBus eventBus){
        this.eventBus = eventBus;
        this.eventBus.register(this);
    }

    /**
     * logs an exceptionEvent
     * @param exceptionEvent
     */
    @Subscribe
    public void onExceptionEvent(ExceptionEvent exceptionEvent){
        logger.log(Level.SEVERE, "ExceptionEvent recognized" + System.lineSeparator()
                + "source: " + exceptionEvent.source + System.lineSeparator()
                + "targets: " + exceptionEvent.targets + System.lineSeparator()
                + "cause in: " + exceptionEvent.cause.source + System.lineSeparator()
                + "exceptionEventTyp: " + exceptionEvent.exceptionEventTyp, exceptionEvent.exception);
    }

    /**
     * logs a normalEvent
     * @param normalEvent
     */
    @Subscribe
    public void onNormalEvent(NormalEvent normalEvent){
        logger.info("NormalEvent recognized" + System.lineSeparator()
                + "source: " + normalEvent.source + System.lineSeparator()
                + "targets: " + normalEvent.targets);
    }
}