package ebd.trainData.tests;

import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.trainData.TrainData;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TrainDataTest {

    @Test
    public void mainTest() throws InterruptedException {

        TDTestHandler tdTestHandler = new TDTestHandler();

        TrainData trainData = new TrainData(EventBus.getDefault(),"http://localhost:8080/trainConfigurator","191");

        Thread.sleep(100);

        double value = 20;

        TrainDataChangeEvent trainDataChangeEvent = new TrainDataChangeEvent("main", new ArrayList<>(), "currentSpeed", value);

        EventBus.getDefault().post(trainDataChangeEvent);

        trainDataChangeEvent = new TrainDataChangeEvent("main", new ArrayList<>(), "currentSpeed", 10);

        EventBus.getDefault().post(trainDataChangeEvent);

        trainDataChangeEvent = new TrainDataChangeEvent("main", new ArrayList<>(), "currentSpeed", 15);

        EventBus.getDefault().post(trainDataChangeEvent);


        TrainDataPerma trainDataPerma = EventBus.getDefault().getStickyEvent(TrainDataPerma.class);
        System.out.println("TrainID: " + trainDataPerma.getId());


        TrainDataVolatile trainDataVolatile = EventBus.getDefault().getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        System.out.println("currentSpeed: " + trainDataVolatile.getCurrentSpeed());


    }

}