package ebd.speedSupervisionModule;


import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.NormalEvent;
import ebd.speedSupervisionModule.util.events.SsmReportEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class TestHandler {

    private EventBus eventBus;

    public TestHandler(EventBus eventBus){
        this.eventBus = eventBus;
        this.eventBus.register(this);
    }

    @Subscribe
    public void exception(ExceptionEvent ee){
        ee.exception.printStackTrace();
    }

    @Subscribe
    public void normalEvent(NormalEvent ne){
        if(!ne.getClass().getSimpleName().contains("SsmReportEvent")){
            System.out.println(ne.getClass().getSimpleName());
        }
    }

    @Subscribe
    public void report(SsmReportEvent sre){
        System.out.println("Speed Intervention Level_ " + sre.interventionLevel);
    }
}
