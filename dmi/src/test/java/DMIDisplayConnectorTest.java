import ebd.dmi.ui.DMIDisplayConnector;
import ebd.globalUtils.events.dmi.DMIUpdateEvent;
import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;
import java.util.List;

public class DMIDisplayConnectorTest {

    private static List<String> dmiUpdateEventTargets;
    private static DMIUpdateEvent dmiUpdateEvent;
    private static DMIUpdateEvent dmiUpdateEvent2;

    public static void main(String[] args) throws InterruptedException {
        new DMIDisplayConnector(EventBus.getDefault());
        for (int currentSpeed = 0; currentSpeed <= 180; currentSpeed += 10) {
            EventBus.getDefault().post(generateDMIUpdateEvent(currentSpeed, 100, 200 - currentSpeed));
            Thread.sleep(1000);
        }
    }

    public static DMIUpdateEvent generateDMIUpdateEvent(double currentSpeed, double currentTargetSpeed, int targetDistance) throws InterruptedException {
        dmiUpdateEventTargets = Arrays.asList("a", "b");
        dmiUpdateEvent = new DMIUpdateEvent("source of DMIUpdateEvent", dmiUpdateEventTargets, currentSpeed, currentTargetSpeed, targetDistance);
        return dmiUpdateEvent;
    }

}
