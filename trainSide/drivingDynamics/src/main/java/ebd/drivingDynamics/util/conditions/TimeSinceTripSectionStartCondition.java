package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.conditions.abstracts.Condition;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.appTime.AppTime;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

public class TimeSinceTripSectionStartCondition extends Condition {

    private final TrainDataVolatile trainDataVolatile;
    private long timeAt0Speed; //in [ms]
    private double timeValue; //in [ms]
    private BiFunction<Double,Double, Boolean> comparator;

    /**
     * @param localEventBus The local {@link EventBus} of the train.
     */
    public TimeSinceTripSectionStartCondition(EventBus localEventBus) {
        super(localEventBus);
        this.trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
    }

    @Override
    public boolean eval() {
        if(trainDataVolatile.getCurrentSpeed() == 0){
            this.timeAt0Speed = AppTime.currentTimeMillis();
            return false;
        }
        double deltaT = (double)(AppTime.currentTimeMillis() - this.timeAt0Speed);
        return  this.comparator.apply(deltaT, this.timeValue);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {

    }
}
