package clienthandler

import data.MovementPermissionRequestProvider
import de.disposim.dbd.trainpos.TrainPosition
import de.ibw.handler.ClientHandler
import de.ibw.history.PositionData
import de.ibw.history.PositionModul
import de.ibw.history.TrackAndOccupationManager
import de.ibw.history.data.PositionEnterType
import de.ibw.tms.etcs.ETCS_DISTANCE
import de.ibw.tms.etcs.ETCS_SPEED
import de.ibw.tms.intf.SmartClientHandler
import de.ibw.tms.intf.TmsMovementPermissionRequest
import de.ibw.tms.intf.cmd.CheckMovementPermission
import de.ibw.tms.ma.DangerPoint
import de.ibw.tms.ma.MovementAuthority
import de.ibw.tms.ma.RbcMaAdapter
import de.ibw.tms.ma.Route
import de.ibw.tms.ma.dynamic.RouteSection
import de.ibw.tms.ma.mob.MovableObject
import de.ibw.tms.ma.mob.common.NID_ENGINE
import de.ibw.tms.ma.mob.position.MOBPosition
import de.ibw.tms.ma.mob.position.MOBPositionClasses
import de.ibw.tms.ma.mob.position.SafeMOBPosition
import de.ibw.tms.ma.occupation.MAOccupation
import de.ibw.tms.ma.occupation.MARequestOccupation
import de.ibw.tms.ma.occupation.Occupation
import de.ibw.tms.ma.positioned.elements.TrackEdge
import de.ibw.tms.plan.elements.model.PlanData
import de.ibw.tms.plan_pro.adapter.PlanProTmsAdapter
import de.ibw.util.ThreadedRepo
import ebd.rbc_tms.util.EOA
import ebd.rbc_tms.util.GradientProfile
import ebd.rbc_tms.util.MA
import ebd.rbc_tms.util.ModeProfile
import ebd.rbc_tms.util.PositionInfo
import ebd.rbc_tms.util.SpeedProfile
import ebd.rbc_tms.util.TrainInfo
import io.netty.channel.ChannelHandlerContext
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

            PlanData.getInstance();
            ClientHandler MUT = Spy(new ClientHandler(null));
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
            PositionData TrainPosition = new PositionData(1L, 1L, TI, Info);
            PositionModul.getInstance().addPositionData(TrainPosition, PositionEnterType.ENTERED_VIA_POSITION_REPORT);


            MUT.sendCommand(new MovementPermissionRequestProvider().getTestRequest());
        expect:

        TrackAndOccupationManager.RequestManager.getAll().size() == 1;

        TrackAndOccupationManager.getReadOnly(MARequestOccupation.class, MobObject).getAll().iterator().next().size() == 1


    }
}
