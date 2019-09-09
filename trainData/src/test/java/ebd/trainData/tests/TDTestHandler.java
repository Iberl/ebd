package ebd.trainData.tests;

import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import ebd.trainData.util.events.TrainDataExceptionEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class TDTestHandler {

    public TrainDataVolatile trainDataVolatile = null;

    public TDTestHandler(){
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void newTrainData(NewTrainDataVolatileEvent ntde){
        this.trainDataVolatile = ntde.trainDataVolatile;
        System.out.println("New Data recieved");
    }

    @Subscribe
    public void newTrainDataPerma(NewTrainDataPermaEvent trainDataPermaEvent){
        TrainDataPerma trainDataPerma = trainDataPermaEvent.trainDataPerma;
        System.out.println(String.format("Got new TrainDataPerma with ID %s", trainDataPerma.getId()));
    }

    @Subscribe
    public void exception(TrainDataExceptionEvent tdee){
        tdee.exception.printStackTrace();
    }
}
