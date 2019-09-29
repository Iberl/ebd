package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

public class RelativeSpeedCondition extends Condition {

    private Double speedPercentage;
    private BiFunction<Double,Double, Boolean> comparator;

    public RelativeSpeedCondition(JSONObject jsonObject, EventBus eventBus) throws DDBadDataException {
        super(eventBus);
        fromJSON(jsonObject);
    }

    @Override
    public boolean eval() {
        TrainDataVolatile trainDataVolatile = localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        if(trainDataVolatile.getCurrentMaxSpeed() == null || trainDataVolatile.getCurrentSpeed() == null){
            return false;
        }

        double maxSpeed = trainDataVolatile.getCurrentMaxSpeed() * speedPercentage;
        double curSpeed = trainDataVolatile.getCurrentSpeed();

        return comparator.apply(curSpeed,maxSpeed);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){
            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                speedPercentage = (Long)tempObject / 100d;
            }
            else if(tempObjectName.equals("Double")){
                speedPercentage = (Double)tempObject / 100;
            }
            else throw new DDBadDataException("RelativeSpeedCondition value was not a number");

            if(speedPercentage < 0 || speedPercentage > 1){
                throw new DDBadDataException("RelativeSpeedCondition Value was not in the range [0, 100]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a RelativeSpeedCondition");

        if(jsonObject.keySet().contains("op")){
            String opCode = (String)jsonObject.get("op");
            this.comparator = ComparisonSelector.comparisonSelector(opCode);
        }
        else throw new DDBadDataException("The key 'op' was missing for a RelativeSpeedCondition");
    }
}
