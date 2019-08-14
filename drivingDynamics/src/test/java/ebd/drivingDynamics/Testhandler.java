package ebd.drivingDynamics;

import ebd.globalUtils.events.ExceptionEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Testhandler {

    public Testhandler(){
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void except(ExceptionEvent ee){
        ee.exception.getMessage();
        ee.exception.printStackTrace();
    }
}
