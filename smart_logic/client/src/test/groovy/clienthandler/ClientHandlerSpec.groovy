package clienthandler

import data.MovementPermissionRequestProvider
import de.ibw.handler.ClientHandler
import de.ibw.history.PositionData
import de.ibw.history.PositionModul
import de.ibw.history.TrackAndOccupationManager
import de.ibw.history.data.PositionEnterType
import de.ibw.smart.logic.EventBusManager
import de.ibw.tms.intf.SmartClientHandler
import de.ibw.tms.ma.MovementAuthority
import de.ibw.tms.ma.mob.MovableObject
import de.ibw.tms.ma.mob.common.NID_ENGINE
import de.ibw.tms.ma.mob.position.MOBPosition
import de.ibw.tms.ma.mob.position.MOBPositionClasses
import de.ibw.tms.ma.mob.position.SafeMOBPosition
import de.ibw.tms.ma.occupation.MARequestOccupation
import de.ibw.tms.plan.elements.model.PlanData
import ebd.internal.util.PositionInfo
import ebd.internal.util.TrainInfo
import spock.lang.Specification


import java.lang.reflect.Field
import java.util.concurrent.SynchronousQueue

/**
 * @auther iberl@verkehr.tu-darmstadt.de
 * @version 1.0
 * @since 2021-04-13
 *
 */
class ClientHandlerSpec extends Specification {


    private static SynchronousQueue<String> getTmsQueue(ClientHandler CH) {
        if(queue == null) {

            Field queueField = SmartClientHandler.class.getDeclaredField("tmsCommandQueue");
            queueField.setAccessible(true);
            queue = queueField.get(CH) as SynchronousQueue<String>;
        }
        return queue
    }

    private static SynchronousQueue<String> queue = null;



    def "sendMovementPermissionRequest"() {
        given:
            EventBusManager.RootEventBusManger = EventBusManager.registerOrGetBus(77, true);
            PlanData.getInstance();
            ClientHandler MUT = Spy(new ClientHandler(null, iRetryTime));
            SynchronousQueue queue = getTmsQueue(MUT);

            new Thread() {
                @Override
                void run() {
                    while(true) {
                        queue.take()
                    }
                }
            }.start();

            NID_ENGINE nid_engine = new NID_ENGINE(1);
            MOBPositionClasses positionClasses = new SafeMOBPosition();
            MOBPosition mobPos = new MOBPosition(positionClasses);
            MovableObject MobObject = new MovableObject(nid_engine, mobPos);
            MovementAuthority ma = new MovementAuthority();
            MobObject.setMA(ma);
            MovableObject.ObjectRepo.update(new NID_ENGINE(1), MobObject);
            PositionInfo Info = new PositionInfo(1, 12778, null, 1, 1, 1,
                    1, 1, 1, 50, 1,1,1,
                    1, null);
            TrainInfo TI = new TrainInfo(1,1, 1L);
            PositionData TrainPosition = new PositionData(1L, 1L, 1, Info);
            PositionModul.getInstance().addPositionData(TrainPosition, PositionEnterType.ENTERED_VIA_POSITION_REPORT);


            MUT.sendCommand(new MovementPermissionRequestProvider().getTestRequest());
        expect:

        TrackAndOccupationManager.RequestManager.getAll().size() == 1;

        TrackAndOccupationManager.getReadOnly(MARequestOccupation.class, MobObject).getAll().iterator().next().size() == 1


    }
}
