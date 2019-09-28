import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Logging{

    private Logger logger;
    private EventBus eventBus;
    private String logPrefix;
    static String logDateTime;
    static Handler fileHandlerAll;

    static {
        //format of logs is defined in resources/logging.properties
        System.setProperty("java.util.logging.config.file", "resources/logging.properties");
        File logDirectory = new File("log/");
        if(!logDirectory.exists()){
            logDirectory.mkdir();
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmmss");
        logDateTime = LocalDateTime.now().format(dateTimeFormatter);
        try {
            fileHandlerAll = new FileHandler("log/" + logDateTime +" AllEventBuses.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * initializes a logger and registers it on a given EventBus, output in files and on console
     * @param eventBus
     * @param trainID with up to five digits
     * @throws IOException
     */
    public Logging(EventBus eventBus, int trainID) throws IOException {
        String trainIDwlZeros = String.format("%05d", trainID);
        logPrefix = "LB" + trainIDwlZeros;
        logger = Logger.getLogger(logPrefix);
        logger.addHandler(fileHandlerAll);
        Handler fileHandler = new FileHandler("log/" + logDateTime + " " + logPrefix + ".log");
        logger.addHandler(fileHandler);
        this.eventBus = eventBus;
        this.eventBus.register(this);

    }

    /**
     * initializes a logger and registers it on the global EventBus, output in files and on console
     * @throws IOException
     */
    public Logging() throws IOException {
        logPrefix = "     GB";
        logger = Logger.getLogger("GlobalEventBus");
        logger.addHandler(fileHandlerAll);
        Handler fileHandler = new FileHandler("log/" + logDateTime + " GB.log");
        logger.addHandler(fileHandler);
        eventBus = EventBus.getDefault();
        eventBus.register(this);
    }

    /**
     * log when ExceptionEvent occurred
     * @param exceptionEvent
     */
    @Subscribe
    public void onExceptionEvent(ExceptionEvent exceptionEvent){
        logger.log(Level.SEVERE, logPrefix + ": " + exceptionEvent.source + ": ExceptionEvent occurred", exceptionEvent.exception);
    }

    /**
     * log when NormalEvent occurred
     * @param normalEvent
     */
    @Subscribe
    public void onNormalEvent(NormalEvent normalEvent){
        if(!normalEvent.getClass().getName().equals("ebd.globalUtils.events.logger.ToLogEvent")) {
            logger.fine(logPrefix + ": " + normalEvent.source + ": " + normalEvent.getClass().getSimpleName() + " occurred");
        }
    }

    /**
     * log when ToLogEvent occurred
     * @param toLogEvent
     */
    @Subscribe
    public void onToLogEvent(ToLogEvent toLogEvent){
        logger.info(logPrefix + ": " + toLogEvent.source + ": " + toLogEvent.msg);
    }
}