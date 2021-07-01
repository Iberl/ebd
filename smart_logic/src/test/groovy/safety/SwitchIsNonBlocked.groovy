package safety

import data.ComposedRouteDataProvider
import de.ibw.history.TrackAndOccupationManager
import de.ibw.history.data.ComposedRoute
import de.ibw.smart.logic.EventBusManager
import de.ibw.smart.logic.intf.SmartLogic
import de.ibw.smart.logic.intf.messages.DbdRequestReturnPayload
import de.ibw.smart.logic.intf.messages.ITypable
import de.ibw.smart.logic.intf.messages.SmartServerMessage
import de.ibw.smart.logic.safety.SafetyLogic
import de.ibw.tms.intf.cmd.CheckDbdCommand
import de.ibw.tms.ma.MovementAuthority
import de.ibw.tms.ma.location.SpotLocationIntrinsic
import de.ibw.tms.ma.mob.MovableObject
import de.ibw.tms.ma.occupation.MARequestOccupation
import de.ibw.tms.ma.occupation.intf.IMoveable
import de.ibw.tms.ma.physical.MoveableTrackElement
import de.ibw.tms.ma.physical.TrackElementStatus
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler
import de.ibw.tms.plan.elements.model.PlanData
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph
import de.ibw.tms.trackplan.viewmodel.TranslationModel
import ebd.SlConfigHandler
import ebd.TescModul
import org.apache.poi.hssf.record.RightMarginRecord
import spock.lang.Specification
import trackAndOccupationManager.ManagerSpecification



/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @since 2021-04-29
 * @version 1.0
 *
 */
class SwitchIsNonBlocked extends Specification {


    def "SWITCH_NOT_CHANGEABLE"() {
        given:

        ManagerSpecification.resetTrackManager();
        EventBusManager.registerOrGetBus(77, false);
        SlConfigHandler.getInstance().useInfrastructureServer = false;
        TranslationModel.TrackplanEnvironment.CurrentEnvironment = TranslationModel.TrackplanEnvironment.KaefWilhelmstalEnv;
        PlanData.getInstance();
        String sLabel = "11W12";
        SafetyLogic MUT = SafetyLogic.getSmartSafety();
        TescModul.getInstance().putNewState(sLabel, 1);
        MoveableTrackElement MTE = TescModul.MoveableTrackElementAccess.getElementById(sLabel)
        TopologyGraph.Node N = ISwitchHandler.getNodeInfoBySwitchId(sLabel).get(0)
        ArrayList<TopologyGraph.Edge> edges = new ArrayList<>();
        edges.addAll(N.inEdges);
        edges.addAll(N.outEdges);
        MARequestOccupation MAR = Stub(MARequestOccupation.class);
        MovableObject MobObject = Stub(MovableObject);

        TescModul stubTESC = Stub(TescModul.class);
        stubTESC.setState(_,_) >> true
        TescModul.instance = stubTESC


        MovementAuthority ma = Spy(new MovementAuthority());
        ma.getMOB() >> MobObject;
        MobObject.getMA() >> ma;
        ((IMoveable)MAR).getTargetMoveableObject() >> MobObject
        ArrayList<TrackEdgeSection> sectionList = new ArrayList<>();
        for(TopologyGraph.Edge E : edges) {
            TrackEdgeSection TES = new TrackEdgeSection();
            TES.setTrackEdge(E);
            SpotLocationIntrinsic begin = new SpotLocationIntrinsic();
            SpotLocationIntrinsic end = new SpotLocationIntrinsic();
            if(E.getRefNode() == N) {
                begin.setIntrinsicCoord(0.0d);
                end.setIntrinsicCoord(0.1d);

            } else {
                begin.setIntrinsicCoord(0.9d);
                end.setIntrinsicCoord(1.0d);
            }
            TES.setBegin(begin)
            TES.setEnd(end);
            sectionList.add(TES);
        }
        MAR.getTrackEdgeSections() >> sectionList
        TrackElementStatus Status = new TrackElementStatus();
        Status.statusList = new ArrayList<>();
        Status.statusList.add(TrackElementStatus.Status.RIGHT);
        CheckDbdCommand cmd = new CheckDbdCommand(sLabel, Status,1L );



        TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                MARequestOccupation.class, MAR);


        System.out.println("EW_Lable" + sLabel);

        Boolean result = null;

        expect:
        new Thread() {
            @Override
            void run() {
                SmartServerMessage msg = SmartLogic.outputQueue.take();
                DbdRequestReturnPayload MsgFromSL = SmartServerMessage.generateFromSlJson(msg.getMsg()) as DbdRequestReturnPayload;
                result = MsgFromSL.dbdCommandSuccessfull
            }
        }.start();
        MUT.checkIfDbdElementIsNotBlocked(cmd)
        while(result == null) {
            Thread.sleep(3000)
        }
        result == false;



        where:
        lOfElments      | trackOrd   | startperc    | endperc | startMeter  | endMeter | scale | expectation
        [100, 200]      | [1, 1]     | 0.5          | 1       |  null         | null      | 1     | false
    }

    def "SWITCH_CHANGEABLE"() {
        given:

        ManagerSpecification.resetTrackManager();
        SlConfigHandler.getInstance().useInfrastructureServer = false;
        TranslationModel.TrackplanEnvironment.CurrentEnvironment = TranslationModel.TrackplanEnvironment.KaefWilhelmstalEnv;
        PlanData.getInstance();
        String sLabel = "11W12";
        SafetyLogic MUT = SafetyLogic.getSmartSafety();
        TescModul.getInstance().putNewState(sLabel, 1);
        MoveableTrackElement MTE = TescModul.MoveableTrackElementAccess.getElementById(sLabel)
        TopologyGraph.Node N = ISwitchHandler.getNodeInfoBySwitchId(sLabel).get(0)
        ArrayList<TopologyGraph.Edge> edges = new ArrayList<>();
        edges.addAll(N.inEdges);
        edges.addAll(N.outEdges);
        MARequestOccupation MAR = Stub(MARequestOccupation.class);
        MovableObject MobObject = Stub(MovableObject);

        TescModul stubTESC = Stub(TescModul.class);
        stubTESC.setState(_,_) >> true
        TescModul.instance = stubTESC

        MovementAuthority ma = Spy(new MovementAuthority());
        ma.getMOB() >> MobObject;
        MobObject.getMA() >> ma;
        ((IMoveable)MAR).getTargetMoveableObject() >> MobObject
        ArrayList<TrackEdgeSection> sectionList = new ArrayList<>();
        for(TopologyGraph.Edge E : edges) {
            TrackEdgeSection TES = new TrackEdgeSection();
            TES.setTrackEdge(E);
            SpotLocationIntrinsic begin = new SpotLocationIntrinsic();
            SpotLocationIntrinsic end = new SpotLocationIntrinsic();
            if(E.getRefNode() == N) {
                begin.setIntrinsicCoord(0.0d);
                end.setIntrinsicCoord(0.1d);

            } else {
                begin.setIntrinsicCoord(0.9d);
                end.setIntrinsicCoord(1.0d);
            }
            TES.setBegin(begin)
            TES.setEnd(end);
            sectionList.add(TES);
        }
        MAR.getTrackEdgeSections() >> sectionList
        TrackElementStatus Status = new TrackElementStatus();
        Status.statusList = new ArrayList<>();
        Status.statusList.add(TrackElementStatus.Status.RIGHT);
        CheckDbdCommand cmd = new CheckDbdCommand(sLabel, Status,1L );




        System.out.println("EW_Lable" + sLabel);

        Boolean result = null;

        expect:
        new Thread() {
            @Override
            void run() {
                SmartServerMessage msg = SmartLogic.outputQueue.take();
                DbdRequestReturnPayload MsgFromSL = SmartServerMessage.generateFromSlJson(msg.getMsg()) as DbdRequestReturnPayload;
                result = MsgFromSL.dbdCommandSuccessfull
            }
        }.start();
        MUT.checkIfDbdElementIsNotBlocked(cmd)
        while(result == null) {
            Thread.sleep(3000)
        }
        result == true;



        where:
        lOfElments      | trackOrd   | startperc    | endperc | startMeter  | endMeter | scale | expectation
        [100, 200]      | [1, 1]     | 0.5          | 1       |  null         | null      | 1     | false
    }
}
