package ebd.speedSupervisionModule;


import ebd.breakingCurveCalculator.BreakingCurveCalculator;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.bcc.BreakingCurveRequestEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.trainData.TrainData;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class SpeedSupervisionModuleTest {

    @Test
    public void ssmTest() throws InterruptedException {
        EventBus eventBus = new EventBus();
        TestHandler th = new TestHandler(eventBus);
        Thread thread = new Thread(new Clock(eventBus));
        thread.start();

        int[] tsp = {0,180,1800,180}; // in m and km/h
        double[] bp = {0,1}; // in m and m/ss
        int[] gp = {0,0}; // in m and 0/00

        SpeedSupervisionModule ssm = new SpeedSupervisionModule(eventBus);

        TrainData trainData = new TrainData(eventBus, 192);
        eventBus.post(new TrainDataChangeEvent("test", Collections.singletonList("td"),"currentSpeed", 51d));
        Location startLoc = new Location(0, ETCSVariables.NID_LRBG, 0d);
        Position startPos = new Position(0d,true,startLoc);
        Position curPos = new Position(10d,true,startLoc);
        eventBus.post(new TrainDataChangeEvent("test", Collections.singletonList("td"),"currentPosition", curPos));

        BreakingCurveCalculator bcc = new BreakingCurveCalculator(eventBus);


        Thread.sleep(3000);

        BCREgeneratorFromDataset generator = new BCREgeneratorFromDataset(tsp,bp,gp);
        BreakingCurveRequestEvent bcre = generator.generate();
        bcre.referencePosition = startPos;
        bcre.source = "test";
        bcre.targets = Collections.singletonList("bcc");
        eventBus.post(bcre);

        Thread.sleep(8000);
        eventBus.post(new DisconnectEvent("all", Collections.singletonList("all")));
    }

}