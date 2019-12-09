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

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";

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
    public Logging(EventBus eventBus, int trainID, String prefix) throws IOException {
        String trainIDwlZeros = String.format("%05d", trainID);
        logPrefix = prefix + trainIDwlZeros;
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
        if(logPrefix == "     GB") {
            logger.log(Level.SEVERE, ANSI_BLUE + logPrefix + ": " + exceptionEvent.source + ": ExceptionEvent occurred" + ANSI_RESET, exceptionEvent.exception);
        }
        else {
            logger.log(Level.SEVERE, ANSI_RED + logPrefix + ": " + exceptionEvent.source + ": ExceptionEvent occurred" + ANSI_RESET, exceptionEvent.exception);
        }
    }

    /**
     * log when NormalEvent occurred
     * @param normalEvent
     */
    @Subscribe
    public void onNormalEvent(NormalEvent normalEvent) {
        if (!normalEvent.getClass().getName().equals("ebd.globalUtils.events.logger.ToLogEvent")) {
            if (logPrefix == "     GB") {
                logger.fine(ANSI_BLUE + logPrefix + ": " + normalEvent.source + ": " + normalEvent.getClass().getSimpleName() + " occurred" + ANSI_RESET);
            } else {
                logger.fine(ANSI_RED + logPrefix + ": " + normalEvent.source + ": " + normalEvent.getClass().getSimpleName() + " occurred" + ANSI_RESET);
            }
        }
    }

    /**
     * log when ToLogEvent occurred
     * @param toLogEvent
     */
    @Subscribe
    public void onToLogEvent(ToLogEvent toLogEvent){
        if (logPrefix == "     GB") {
            logger.info(ANSI_BLUE + logPrefix + ": " + toLogEvent.source + ": " + toLogEvent.msg + ANSI_RESET);
        }
        else {
            logger.info(ANSI_RED + logPrefix + ": " + toLogEvent.source + ": " + toLogEvent.msg + ANSI_RESET);
        }
    }
}