package ebd.logging;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.events.logger.ToLogDebugEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.logging.util.handler.PipeHandler;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;


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
        System.out.println(logDirectory.getAbsolutePath());
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
        logPrefix = String.format("%-9s", "GB");
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

        String endsection = exceptionEvent.source + ": ExceptionEvent occurred. " + exceptionEvent.exception.getMessage();

        logger.log(Level.SEVERE, logPrefix + ": " + endsection, exceptionEvent.exception);

    }

    /**
     * log when NormalEvent occurred
     * @param normalEvent
     */
    @Subscribe
    public void onNormalEvent(NormalEvent normalEvent) {
        if (!normalEvent.getClass().getName().equals("ebd.globalUtils.events.logger.ToLogEvent")) {
            String padSrc = String.format("%4s", normalEvent.source); //Inserted by LSF
            if (logPrefix.equals(String.format("%-9s", "GB"))) {
                logger.fine(logPrefix + ": " + padSrc + ": " + normalEvent.getClass().getSimpleName() + " occurred");
            }
            else if (logPrefix.equals("RBC 00001")) {
                logger.fine(logPrefix + ": " + padSrc + ": " + normalEvent.getClass().getSimpleName() + " occurred");
            }
            else if (logPrefix.equals("TRN 00192")){
                logger.fine(logPrefix + ": " + padSrc + ": " + normalEvent.getClass().getSimpleName() + " occurred");
            }
            else {
                logger.fine(logPrefix + ": " + padSrc + ": " + normalEvent.getClass().getSimpleName() + " occurred");
            }
        }
    }

    /**
     * log when ToLogEvent occurred
     * @param toLogEvent
     */
    @Subscribe
    public void onToLogEvent(ToLogEvent toLogEvent){
        String padSrc = String.format("%3s", toLogEvent.source); //Inserted by LSF
        if (logPrefix.equals(String.format("%-9s", "GB"))) {
            logger.info(logPrefix + ": " + padSrc + ": " + toLogEvent.msg);
        }
        else if (logPrefix.equals("RBC 00001")) {
            logger.info(logPrefix + ": " + padSrc + ": " + toLogEvent.msg);
        }
        else if (logPrefix.equals("TRN 00192")){
            logger.info(logPrefix + ": " + padSrc + ": " + toLogEvent.msg);
        }
        else {
            logger.info(logPrefix + ": " + padSrc + ": " + toLogEvent.msg);
        }
    }

/*    *//**
     * log when ToLogDebugEvent occurred
     * @param toLogDebugEvent
     *//*
    @Subscribe
    public void toLogDebugEvent(ToLogDebugEvent toLogDebugEvent){
        String padSrc = String.format("%3s", toLogDebugEvent.source); //Inserted by LSF
        logger.fine(toLogDebugEvent.msg);
    }*/
}