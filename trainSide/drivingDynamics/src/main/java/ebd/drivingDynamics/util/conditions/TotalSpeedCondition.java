package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

public class TotalSpeedCondition extends Condition {

    private Double speedTotal;
    private BiFunction<Double,Double, Boolean> comparator;

    public TotalSpeedCondition(JSONObject jsonObject, EventBus eventBus) throws DDBadDataException {
        super(eventBus);
        fromJSON(jsonObject);
    }

    @Override
    public boolean eval() {
        TrainDataVolatile trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        double curSpeed = trainDataVolatile.getCurrentSpeed();

        return comparator.apply(curSpeed,speedTotal);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){

            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                speedTotal = ((Long)tempObject).doubleValue() / 3.6; //To [m/s]
            }
            else if(tempObjectName.equals("Double")){
                speedTotal = (Double)tempObject / 3.6; //To [m/s]
            }
            else throw new DDBadDataException("TotalSpeedCondition value was not a number");

            if(speedTotal < 0 || speedTotal > 600){
                throw new DDBadDataException("TotalSpeedCondition Value was not in the range [0, 600]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a TotalSpeedCondition");

        if(jsonObject.keySet().contains("op")){
            String opCode = (String)jsonObject.get("op");
            this.comparator = ComparisonParser.parse(opCode);
        }
        else throw new DDBadDataException("The key 'op' was missing for a TotalSpeedCondition");
    }
}
