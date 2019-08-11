package ebd.routeData;

import ebd.routeData.util.events.RouteDataExceptionEvent;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RouteData {

    private EventBus eventBus;
    private RouteDataVolatile routeDataVolatile = new RouteDataVolatile();

    private List<String> exceptionTargets = new ArrayList<>();
    private List<String> eventTargets = new ArrayList<>();

    public RouteData(EventBus eventBus) {
        this.eventBus = eventBus;
        this.eventBus.register(this);
        this.exceptionTargets.add("tsm;");
        this.eventTargets.add("all;");
    }


    @Subscribe
    public void changeInCourseData(RouteDataChangeEvent routeDataChangeEvent){
        for (Field field : routeDataVolatile.getClass().getDeclaredFields()){

            if (field.getName().equals(routeDataChangeEvent.fieldName)) {

                try {

                    field.set(routeDataVolatile, routeDataChangeEvent.fieldValue);
                    eventBus.postSticky(new NewRouteDataVolatileEvent("ttd;", eventTargets, this.routeDataVolatile));

                } catch (IllegalAccessException e) {
                    String msg = String.format("Field %s was not accessible. ", routeDataChangeEvent.fieldName);
                    msg += " " + e.getMessage();
                    IllegalAccessException exception = new IllegalAccessException(msg);
                    exception.setStackTrace(e.getStackTrace());
                    eventBus.post(new RouteDataExceptionEvent("ttd;", exceptionTargets, routeDataChangeEvent, exception));
                } catch (IllegalArgumentException e){
                    String msg = String.format("Passed fieldValue with type %s did not match field %s with the type %s.", routeDataChangeEvent.fieldValue.getClass(), field.getName(), field.getType());
                    msg += " " + e.getMessage();
                    IllegalArgumentException iAE = new IllegalArgumentException(msg);
                    iAE.setStackTrace(e.getStackTrace());
                    eventBus.post(new RouteDataExceptionEvent("ttd;", exceptionTargets, routeDataChangeEvent, iAE));
                }

                return;
            }
        }
        String msg = String.format("fieldName %s was not found in fields of %s", routeDataChangeEvent.fieldName, routeDataVolatile.getClass());
        IllegalArgumentException iAE = new IllegalArgumentException(msg);
        eventBus.post(new RouteDataExceptionEvent("ttd;", exceptionTargets, routeDataChangeEvent, iAE));
    }
}
