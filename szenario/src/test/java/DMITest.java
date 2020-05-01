import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.dmi.DMIUpdateEvent;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;
import ebd.szenario.util.server.DMIServer;
import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DMITest {

    private EventBus globalEventBus;
    private DMIServer dmiServer;

    public DMITest() throws InterruptedException, IOException {
        this.globalEventBus = EventBus.getDefault();
        this.dmiServer = new DMIServer();
        Thread.sleep(10000);
        speedometerTest();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        if (ConfigHandler.getInstance() == null){
            System.out.println("Config Handler could not be opened");
            System.exit(0);
        }
        new DMITest();
    }

    private void speedometerTest() throws InterruptedException {
        speedometerPermittedSpeedTest();
        speedometerCSMTest();
        //speedometerTSMTest();
        speedometerRSMTest();
    }

    private void speedometerPermittedSpeedTest() throws InterruptedException {
        List testTargets;
        testTargets = Arrays.asList("testTarget1", "testtarget2");
        for (double currentPermSpeed = 0; currentPermSpeed < 400/3.6; currentPermSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 0, 0, 0, 0,SpeedInterventionLevel.NO_INTERVENTION, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 0, currentPermSpeed, currentPermSpeed + 10/3.6, currentPermSpeed + 20/3.6));
            System.out.println("currentPermSpeed: " + currentPermSpeed);
            Thread.sleep(1000);
        }
    }

    private void speedometerCSMTest() throws InterruptedException {
        List testTargets;
        testTargets = Arrays.asList("testTarget1", "testtarget2");
        
        //currentSpeed variable
        for(double currentSpeed = 0; currentSpeed <= 150/3.6; currentSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 0, SpeedInterventionLevel.NO_INTERVENTION, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentSpeed = 150/3.6; currentSpeed >= 0; currentSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 0, SpeedInterventionLevel.NO_INTERVENTION, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentSpeed = 0; currentSpeed <= 150/3.6; currentSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 0, SpeedInterventionLevel.INDICATION, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentSpeed = 150/3.6; currentSpeed >= 0; currentSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 0, SpeedInterventionLevel.INDICATION, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentSpeed = 0; currentSpeed <= 150/3.6; currentSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 0, SpeedInterventionLevel.WARNING, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentSpeed = 150/3.6; currentSpeed >= 0; currentSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 0, SpeedInterventionLevel.WARNING, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentSpeed = 0; currentSpeed <= 150/3.6; currentSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 0, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentSpeed = 150/3.6; currentSpeed >= 0; currentSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 0, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentSpeed = 0; currentSpeed <= 150/3.6; currentSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 0, SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentSpeed = 150/3.6; currentSpeed >= 0; currentSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 0, SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }


        //currentPermSpeed variable
        for(double currentPermSpeed = 0; currentPermSpeed <= 150/3.6; currentPermSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, 40/3.6, 0, 0, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, currentPermSpeed - 10/3.6, currentPermSpeed, currentPermSpeed + 10/3.6, currentPermSpeed + 20/3.6));
            Thread.sleep(1000);
        }

        for(double currentPermSpeed = 150/3.6; currentPermSpeed >= 0; currentPermSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, 40/3.6, 0, 0, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, currentPermSpeed - 10/3.6, currentPermSpeed, currentPermSpeed + 10/3.6, currentPermSpeed + 20/3.6));
            Thread.sleep(1000);
        }

        //targetSpeed variable
        for(double currentTargetSpeed = 0; currentTargetSpeed <= 100/3.6; currentTargetSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, currentTargetSpeed, 0, 0, SpeedInterventionLevel.INDICATION, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentTargetSpeed = 100/3.6; currentTargetSpeed >= 0; currentTargetSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, currentTargetSpeed, 0, 0, SpeedInterventionLevel.INDICATION, SpeedSupervisionState.CEILING_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }
    }

    private void speedometerTSMTest() throws InterruptedException {
        List testTargets;
        testTargets = Arrays.asList("testTarget1", "testtarget2");
        this.globalEventBus.post(new DMIUpdateEvent("test", testTargets, 0, 0, 0, 0, SpeedInterventionLevel.NO_INTERVENTION, SpeedSupervisionState.TARGET_SPEED_SUPERVISION, 50, 60, 70, 80));
        Thread.sleep(1000);

        //currentReleaseSpeed = 0

        //currentReleaseSpeed != 0
    }

    private void speedometerRSMTest() throws InterruptedException {
        List testTargets;
        testTargets = Arrays.asList("testTarget1", "testtarget2");

        //currentReleaseSpeed variable
        for(double currentReleaseSpeed = 0; currentReleaseSpeed <= 150/3.6; currentReleaseSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, 0, 0, currentReleaseSpeed, SpeedInterventionLevel.INDICATION, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentReleaseSpeed = 150/3.6; currentReleaseSpeed >= 0; currentReleaseSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, 0, 0, currentReleaseSpeed, SpeedInterventionLevel.INDICATION, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }


        for(double currentReleaseSpeed = 0; currentReleaseSpeed <= 150/3.6; currentReleaseSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, 0, 0, currentReleaseSpeed, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentReleaseSpeed = 150/3.6; currentReleaseSpeed >= 0; currentReleaseSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, 0, 0, currentReleaseSpeed, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentReleaseSpeed = 0; currentReleaseSpeed <= 150/3.6; currentReleaseSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, 0, 0, currentReleaseSpeed, SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentReleaseSpeed = 150/3.6; currentReleaseSpeed >= 0; currentReleaseSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, 0, 0, currentReleaseSpeed, SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }


        //currentPermSpeed variable
        for(double currentPermSpeed = 0; currentPermSpeed <= 150/3.6; currentPermSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, 0, 0, 100/3.6, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, currentPermSpeed - 10/3.6, currentPermSpeed, currentPermSpeed + 10/3.6, currentPermSpeed + 20/3.6));
            Thread.sleep(1000);
        }

        for(double currentPermSpeed = 150/3.6; currentPermSpeed >= 0; currentPermSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, 100/3.6, 0, 0, 100/3.6, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, currentPermSpeed - 10/3.6, currentPermSpeed, currentPermSpeed + 10/3.6, currentPermSpeed + 20/3.6));
            Thread.sleep(1000);
        }


        //currentSpeed variable
        for(double currentSpeed = 0; currentSpeed <= 150/3.6; currentSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 80/3.6, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentSpeed = 150/3.6; currentSpeed >= 0; currentSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 80/3.6, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        //TODO specifications for overspeedArc
        for(double currentSpeed = 0; currentSpeed <= 150/3.6; currentSpeed += 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 120/3.6, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }

        for(double currentSpeed = 150/3.6; currentSpeed >= 0; currentSpeed -= 10/3.6) {
            this.globalEventBus.post(new DMIUpdateEvent("test;T=2181", testTargets, currentSpeed, 0, 0, 120/3.6, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, SpeedSupervisionState.RELEASE_SPEED_SUPERVISION, 60 / 3.6, 100 / 3.6, 105 / 3.6, 110 / 3.6));
            Thread.sleep(1000);
        }
    }
}
