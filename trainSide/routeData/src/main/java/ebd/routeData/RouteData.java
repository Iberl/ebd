package ebd.routeData;

import ebd.globalUtils.events.routeData.RouteDataMultiChangeEvent;
import ebd.routeData.util.events.RouteDataExceptionEvent;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RouteData {

    private EventBus eventBus;
    private RouteDataVolatile routeDataVolatile = new RouteDataVolatile();

    private String exceptionTarget = "tsm";
    private String eventTarget = "all";

    public RouteData(EventBus eventBus) {
        this.eventBus = eventBus;
        this.eventBus.register(this);
        this.eventBus.postSticky(new NewRouteDataVolatileEvent("rd", this.eventTarget,this.routeDataVolatile));
    }

    /**
     * Updates {@link RouteDataVolatile}
     * @param routeDataChangeEvent {@link RouteDataChangeEvent}
     */
    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void changeInRouteData(RouteDataChangeEvent routeDataChangeEvent){
        try {
            changingRoutDataVolatile(routeDataChangeEvent.fieldName,routeDataChangeEvent.fieldValue);
            eventBus.postSticky(new NewRouteDataVolatileEvent("rd;", eventTarget, this.routeDataVolatile));
        } catch (IllegalAccessException | IllegalArgumentException e) {
            this.eventBus.post(new RouteDataExceptionEvent("rd",this.exceptionTarget,routeDataChangeEvent,e));
        }
    }

    @Subscribe
    public void changesInRouteData(RouteDataMultiChangeEvent routeDataMultiChangeEvent){
        Map<String,Object> namesToValues = routeDataMultiChangeEvent.fieldNamesToFieldValues;
        try{
            for (String key : namesToValues.keySet()){
                changingRoutDataVolatile(key,namesToValues.get(key));
            }
            eventBus.postSticky(new NewRouteDataVolatileEvent("rd;", eventTarget, this.routeDataVolatile));
        } catch (IllegalAccessException | IllegalArgumentException e) {
            this.eventBus.post(new RouteDataExceptionEvent("rd",this.exceptionTarget,routeDataMultiChangeEvent,e));
        }

    }

    /**
     *  Updates RoutDataVolatile
     * @param fieldName valid field name of {@link RouteDataVolatile}
     * @param fieldValue valid field value
     * @throws IllegalAccessException If the field could not be accessed
     * @throws IllegalArgumentException If the field name or value where invalid
     */
    private void changingRoutDataVolatile(String fieldName, Object fieldValue)
            throws IllegalAccessException, IllegalArgumentException {
        for (Field field : routeDataVolatile.getClass().getDeclaredFields()){

            if (field.getName().equals(fieldName)) {

                try {

                    field.set(routeDataVolatile, fieldValue);

                } catch (IllegalAccessException e) {
                    String msg = String.format("Field %s was not accessible. ", fieldName);
                    msg += " " + e.getMessage();
                    IllegalAccessException iAccE = new IllegalAccessException(msg);
                    iAccE.setStackTrace(e.getStackTrace());
                    throw iAccE;
                } catch (IllegalArgumentException e){
                    String msg = String.format("Passed fieldValue with type %s did not match field %s with the type %s.", fieldValue.getClass(), field.getName(), field.getType());
                    msg += " " + e.getMessage();
                    IllegalArgumentException iAE = new IllegalArgumentException(msg);
                    iAE.setStackTrace(e.getStackTrace());
                    throw iAE;
                }
                return;
            }
        }
        String msg = String.format("fieldName %s was not found in fields of %s", fieldName, routeDataVolatile.getClass());
        throw new IllegalArgumentException(msg);
    }
}
