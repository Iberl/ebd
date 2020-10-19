package ebd.szenario.util.handler;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.logger.LogToGUIPipeEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SzenarioEventHandler {

    EventBus globalEventBus;

    public SzenarioEventHandler(){
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
    }


    /**
     * Dummy to prevent warnings from {@link EventBus}
     */
    @Subscribe
    public void dummyHandler(LogToGUIPipeEvent ghe){}

    /**
     * ExceptionHandler
     */
    @Subscribe
    public void exceptionHandler(ExceptionEvent ee){
        if(ConfigHandler.getInstance().debug){
            ee.exception.printStackTrace();
        }
        switch (ee.exceptionEventTyp){//TODO Fill with functional code
            case WARNING: //Ignore it, logging is already happening in ebd.Logging
                break;
            case NONCRITICAL: //Recover
                recover(ee);
                break;
            case CRITICAL: //Kill that train
                killTrain(ee);
                break;
            case FATAL: //Kill the process
                System.err.println(ee.exception.getMessage());
                ee.exception.printStackTrace();
                System.exit(-1);
                break;
        }
    }

    private void recover(ExceptionEvent ee) {
    }

    private void killTrain(ExceptionEvent ee) {
    }

}
