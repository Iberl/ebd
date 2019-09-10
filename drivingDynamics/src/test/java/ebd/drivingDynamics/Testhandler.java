package ebd.drivingDynamics;

import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.NormalEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Testhandler {

    public Testhandler(){
        EventBus.getDefault().register(this);
    }
    public Testhandler(EventBus eb){eb.register(this);}

    @Subscribe
    public void except(ExceptionEvent ee){
        ee.exception.getMessage();
        ee.exception.printStackTrace();
    }

    @Subscribe
    public void normalEvent(NormalEvent ne){
        if(!ne.getClass().getSimpleName().equals("NewTrainDataVolatileEvent")){
            System.out.println(ne.getClass().getSimpleName());
        }
    }

    @Subscribe
    public void ntdv(NewTrainDataVolatileEvent ntdv){
        System.out.println("NTDV: " + ntdv.getClass().getSimpleName());
    }
}
