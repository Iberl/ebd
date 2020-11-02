package ebd.trainStatusManager;

import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.position.Position;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Testhandler {

    public Testhandler(){
        EventBus.getDefault().register(this);
    }
    public Testhandler(EventBus eb){eb.register(this);}

    @Subscribe
    public void except(ExceptionEvent ee){
        System.out.println(ee.exceptionEventTyp + ": " + ee.exception.getMessage());
        ee.exception.printStackTrace();
    }

    /*@Subscribe(threadMode = ThreadMode.ASYNC)
    public void normalEvent(NormalEvent ne){
        System.out.println(ne.getClass().getSimpleName());
    }*/

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void normalEvent(NormalEvent ne){
        if(!ne.getClass().getSimpleName().equals("NewTrainDataVolatileEvent")){
            System.out.println(ne.getClass().getSimpleName());
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void ntdv(NewTrainDataVolatileEvent ntdv){
        System.out.println("NTDV: " + ntdv.getClass().getSimpleName());
        System.out.println("     curMaxSpeed: " + ntdv.trainDataVolatile.getCurrentMaxSpeed());
        System.out.println("     curSpeed: " + ntdv.trainDataVolatile.getCurrentSpeed());
        Position tempPos = ntdv.trainDataVolatile.getCurrentPosition();
        if(tempPos != null){
            System.out.println("     curPos Loc: " + tempPos.getLocation());
            System.out.println("     curPos Inc: " + tempPos.getIncrement());
        }
    }
}
