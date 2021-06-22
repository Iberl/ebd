package ebd.logging;

import ebd.SlConfigHandler;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.events.dmi.ToLogDeepDebugEvent;
import ebd.globalUtils.events.logger.ToLogDebugEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.logging.util.handler.PipeHandler;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;


public class Logging{

    private final Logger logger;
    private final EventBus eventBus;
    private final String logPrefix;
    static String logDateTime;
    static Handler fileHandlerAll;
    static Handler pipeHandler;

    static {
        //format of logs is defined in resources/logging.properties
        //File propertyFile = new File("configuration/logging.properties");
        try{

//                String pathToPropertyFile = Thread.currentThread().getContextClassLoader().getResource("logging.properties").getFile();
//                boolean createdDir = propertyFile.getParentFile().mkdir();
//                boolean createdFile = propertyFile.createNewFile();
//                if(!createdFile && !propertyFile.exists()){
//                    throw new IOException("logging.properties could not be created");
//                }
                InputStream is = Logging.class.getClassLoader().getResourceAsStream("logging.properties");
                //try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("logging.properties")) {

                    if(is == null) {
                        throw new IOException("The stream logging.properties could not be found");
                    }

//                    try (FileOutputStream outputStream = new FileOutputStream(propertyFile)) {
//                        int length;
//                        byte[] buffer = new byte[1024];
//                        while ((length = inputStream.read(buffer)) != -1) {
//                            outputStream.write(buffer, 0, length);
//                        }
//                    }catch (IOException ioe){
//                        throw new IOException("logging.properties could not be created. " + ioe.getMessage());
//                    }


        }catch (IOException e){
            e.printStackTrace();
        }


        //System.setProperty("java.util.logging.config.file", propertyFile.getPath());
        File logDirectory = new File("log/");
        System.out.println(logDirectory.getAbsolutePath());
        if(!logDirectory.exists()){
            logDirectory.mkdir();
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmmss");
        logDateTime = LocalDateTime.now().format(dateTimeFormatter);
        try {
            //fileHandlerAll = new FileHandler("log/" + logDateTime +" AllEventBuses.log");
            pipeHandler = new PipeHandler();
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
        //logger.addHandler(fileHandlerAll);
        logger.addHandler(pipeHandler);
        Handler fileHandler = new FileHandler("log/" + logDateTime + " " + logPrefix + ".log");
        fileHandler.setFormatter(new SimpleFormatter());

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
        logger.addHandler(pipeHandler);
        Handler fileHandler = new FileHandler("log/" + logDateTime + " GB.log");
        logger.addHandler(fileHandler);

        eventBus = EventBus.getDefault();
        eventBus.register(this);
    }

    /**
     * log when ExceptionEvent occurred
     * @param exceptionEvent
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onExceptionEvent(ExceptionEvent exceptionEvent){

        String endsection = exceptionEvent.source + ": ExceptionEvent occurred. "
                + exceptionEvent.exception.getMessage() + " With level: " + exceptionEvent.exceptionEventTyp;
        logger.log(Level.SEVERE, logPrefix + ": " + endsection, exceptionEvent.exception);

    }

    /**
     * log when NormalEvent occurred
     * @param normalEvent
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onNormalEvent(NormalEvent normalEvent) {
        if (!normalEvent.getClass().getName().equals("ebd.globalUtils.events.logger.ToLogEvent")) {
            String padSrc = String.format("%4s", normalEvent.source); //Inserted by LSF
            logger.finest(logPrefix + ": " + padSrc + ": " + normalEvent.getClass().getSimpleName() + " occurred");
        }
    }

    /**
     * log when ToLogEvent occurred
     * @param toLogEvent
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onToLogEvent(ToLogEvent toLogEvent){
        String padSrc = String.format("%3s", toLogEvent.source); //Inserted by LSF
        logger.info(logPrefix + ": " + padSrc + ": " + toLogEvent.msg);

    }

    /**
     * log when ToLogDebugEvent occurred
     * @param toLogDebugEvent
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void toLogDebugEvent(ToLogDebugEvent toLogDebugEvent){
        String padSrc = String.format("%3s", toLogDebugEvent.source); //Inserted by LSF
        logger.fine("debug: " + logPrefix + ": " + padSrc + ": " + toLogDebugEvent.msg);
    }

    /**
     * log when ToLogDeepDebugEvent occurred
     * @param toLogDebugEvent
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void toLogDeepDebugEvent(ToLogDeepDebugEvent toLogDebugEvent){
        String padSrc = String.format("%3s", toLogDebugEvent.source); //Inserted by LSF
        logger.finer("debug: " + logPrefix + ": " + padSrc + ": " + toLogDebugEvent.msg);
    }
}