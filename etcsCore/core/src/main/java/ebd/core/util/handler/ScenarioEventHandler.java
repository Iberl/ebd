package ebd.core.util.handler;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.logger.LogToGUIPipeEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ScenarioEventHandler {

    EventBus globalEventBus;

    public ScenarioEventHandler(){
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
    }

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
                System.exit(-2);
                break;
        }
    }

    private void recover(ExceptionEvent ee) {
    }

    private void killTrain(ExceptionEvent ee) {
    }

}
