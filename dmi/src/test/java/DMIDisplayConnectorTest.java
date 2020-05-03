import ebd.dmi.ui.DMIDisplayConnector;
import ebd.globalUtils.events.dmi.DMIUpdateEvent;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;
import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;

public class DMIDisplayConnectorTest {

    private static String dmiUpdateEventTarget;
    private static DMIUpdateEvent dmiUpdateEvent;

    public static void main(String[] args) throws InterruptedException {
        new DMIDisplayConnector(EventBus.getDefault());

        double currentTargetSpeed = 150/3.6;
        SpeedInterventionLevel speedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
        SpeedSupervisionState speedSupervisionState = SpeedSupervisionState.CEILING_SPEED_SUPERVISION; //TODO Von LSF eingebaut.
        double currentIndSpeed = currentTargetSpeed - 30/3.6;
        double currentPermSpeed = currentTargetSpeed - 20/3.6;
        double currentWarnSpeed = currentTargetSpeed;
        double currentIntervSpeed = currentTargetSpeed + 10/3.6;

        for(double currentSpeed=100/3.6; currentSpeed < 400/3.6; currentSpeed++) {

            if (currentSpeed <= currentTargetSpeed - 30/3.6) {
                speedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
            } else if (currentTargetSpeed - 30/3.6 < currentSpeed && currentSpeed <= currentTargetSpeed) {
                speedInterventionLevel = SpeedInterventionLevel.INDICATION;
            } else if (currentTargetSpeed < currentSpeed && currentSpeed <= currentTargetSpeed + 10/3.6) {
                speedInterventionLevel = SpeedInterventionLevel.WARNING;
            } else if (currentTargetSpeed + 10/3.6 < currentSpeed && currentSpeed <= currentTargetSpeed + 20/3.6) {
                speedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            } else if (currentTargetSpeed + 20/3.6 < currentSpeed) {
                speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }

            EventBus.getDefault().post(generateDMIUpdateEvent(currentSpeed, currentTargetSpeed, 0, speedInterventionLevel, speedSupervisionState, currentIndSpeed, currentPermSpeed, currentWarnSpeed, currentIntervSpeed));
            Thread.sleep(300);
        }
//
//        EventBus.getDefault().post(generateDMIUpdateEvent(100/3.6, 150/3.6, 0, SpeedInterventionLevel.NO_INTERVENTION, 0, 0, 0));
//        Thread.sleep(1000);
//        EventBus.getDefault().post(generateDMIUpdateEvent(25, 27.7778, 0, SpeedInterventionLevel.INDICATION, 0, 0, 0));
//        Thread.sleep(1000);
//        EventBus.getDefault().post(generateDMIUpdateEvent(125/3.6, 120/3.6, 0, SpeedInterventionLevel.WARNING, 0, 0, 0));
//        Thread.sleep(1000);
//        EventBus.getDefault().post(generateDMIUpdateEvent(33.3333, 27.7778, 0, SpeedInterventionLevel.APPLY_SERVICE_BREAKS, 0, 0, 0));
//        Thread.sleep(1000);
//        EventBus.getDefault().post(generateDMIUpdateEvent(38.8889, 27.7778, 0, SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS, 0, 0, 0));
//        Thread.sleep(1000);
//        EventBus.getDefault().post(generateDMIUpdateEvent(300/3.6, 200/3.6, 0, SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS, 0, 0, 0));
//        Thread.sleep(1000);
//        EventBus.getDefault().post(generateDMIUpdateEvent(400/3.6, 300/3.6, 0, SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS, 0, 0, 0));
//        Thread.sleep(1000);
//        //EventBus.getDefault().post(generateDMIUpdateEvent(38.8889, 400/3.6, 0, SpeedInterventionLevel.NO_INTERVENTION, 0, 0, 0));
//        Thread.sleep(1000);
//        //EventBus.getDefault().post(generateDMIUpdateEvent(38.8889, 200/3.6, 0, SpeedInterventionLevel.NO_INTERVENTION, 0, 0, 0));

    }

    public static DMIUpdateEvent generateDMIUpdateEvent(double currentSpeed, double currentTargetSpeed, int targetDistance, SpeedInterventionLevel speedIntLevel, SpeedSupervisionState speedSupervisionState, double currentIndSpeed, double currentPermSpeed, double currentWarnSpeed, double currentIntervSpeed) throws InterruptedException {
        dmiUpdateEventTarget = "a";
        dmiUpdateEvent = new DMIUpdateEvent("source of DMIUpdateEvent", dmiUpdateEventTarget, currentSpeed, currentTargetSpeed, targetDistance, speedIntLevel, speedSupervisionState, currentIndSpeed, currentPermSpeed, currentWarnSpeed, currentIntervSpeed);
        return dmiUpdateEvent;
    }

}
