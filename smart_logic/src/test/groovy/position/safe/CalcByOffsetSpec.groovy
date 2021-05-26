package position.safe

import data.ComposedRouteDataProvider
import data.ScenarioDataProvider
import de.ibw.history.PositionData
import de.ibw.history.PositionModul
import de.ibw.history.TrackAndOccupationManager
import de.ibw.history.data.PositionEnterType
import de.ibw.tms.ma.mob.MovableObject
import de.ibw.tms.ma.mob.common.NID_ENGINE
import de.ibw.tms.ma.occupation.Occupation
import de.ibw.tms.ma.occupation.VehicleOccupation
import de.ibw.tms.ma.physical.MoveableTrackElement
import de.ibw.tms.ma.positioned.elements.TrackEdge
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection
import de.ibw.tms.plan.elements.model.PlanData
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph
import de.ibw.util.ThreadedRepo
import ebd.TescModul
import ebd.internal.util.PositionInfo
import ebd.internal.util.TrainInfo
import spock.lang.Specification
import trackAndOccupationManager.ManagerSpecification

class CalcByOffsetSpec extends Specification {

    ScenarioDataProvider scenarioDataProvider = null;

    /*def "calcByOffsetScenario1"() {
        given:

        PlanData.getInstance()

        SafeMOBPosition MUT = new SafeMOBPosition();
        TmsMovementPermissionRequest request1 = new MovementPermissionRequestProvider().getTestRequest();
        CheckMovementPermission permissionPayload = request1.getPayload() as CheckMovementPermission;
        NID_ENGINE nid_engine = new NID_ENGINE(permissionPayload.iTrainId);
        BigDecimal dNewOffset = BigDecimal.valueOf(offsetMeter);
        PositionInfo positionInfo = new PositionInfo(1, nid_lrbg, null, 1,
                1, q_dir_lrgb,
                1, 1, 1, trainlength, 1, 1, 1,
                1, null);
        SmartLogicException ExceptionHandler = null;

        PositionData PD = new PositionData(1, 1,
                new TrainInfo(1, 1, 1), positionInfo);

        // Mocks and Stubs
        *//*
        TrackElementStatus statusOfAllSwitch = Stub(TrackElementStatus);
        ArrayList<TrackElementStatus.Status> dummyStat = new ArrayList<>();
        dummyStat.add(TrackElementStatus.Status.LEFT);
        statusOfAllSwitch.statusList = dummyStat;
        MoveableTrackElement SwitchStub = Stub(MoveableTrackElement);
        SwitchStub.getCurrentStatus() >> statusOfAllSwitch
        *//*

        PositionModul PM = Spy(PositionModul.getInstance());
        PM.getCurrentPosition(1) >> PD;
        PositionModul.setInstance(PM);
        ComposedRoute CR = null;
        try {
            CR = MUT.calcByOffset(nid_engine, dNewOffset, positionInfo, isReverse);
        } catch (SmartLogicException SLE) {
            ExceptionHandler = SLE;
        }


        expect:
        System.out.println("Intrinsic-Factor: " + CR.getLastSpot().intrinsicCoord);
        CR.getLastSpot().intrinsicCoord > 0;

        where:
        testid | offsetMeter | nid_lrbg | q_dir_lrgb | trainlength | isReverse
        1      | 7           | 12778    | 1          | 3           | false
    }
*/
    def "integrationTest"() {
        given:
        PlanData.getInstance();

        if(scenarioDataProvider == null) {
            scenarioDataProvider = new ScenarioDataProvider();
        }
        TescModul.getInstance();

        ManagerSpecification.resetTrackManager();

        ThreadedRepo<String, MoveableTrackElement> ElementStateByIdRepository = new ThreadedRepo<>();

        for(String sid : scenarioDataProvider.getScenario1Train1List()) {
            ElementStateByIdRepository.update(sid,
                    scenarioDataProvider.getElementByDbd("CR1", 1, sid))
        }
        new ComposedRouteDataProvider().
                setStatic(TescModul.class, "ElementStateByIdRepository", ElementStateByIdRepository)





        PositionInfo positionInfo = new PositionInfo(1, nid_lrbg, null, offsetMeter,
                1, q_dir_lrgb,
                1, 1, 1, trainlength, 1, 1, 1,
                1, null);


        PositionData PD = new PositionData(1, 1,
                new TrainInfo(1, 1, 1), positionInfo);

        PositionModul.getInstance().addPositionData(PD, PositionEnterType.ENTERED_VIA_POSITION_REPORT)


        expect:
        MovableObject MO = MovableObject.ObjectRepo.getModel(new NID_ENGINE(1))
        ThreadedRepo<TrackEdge, ArrayList<Occupation>> result = TrackAndOccupationManager.getReadOnly(VehicleOccupation.class, MO);
        VehicleOccupation resultOcc = result.getAll().iterator().next().get(0) as VehicleOccupation;
        System.out.println("TEST " + testid + ": EdgeCount: " + resultOcc.getTrackEdgeSections().size());
        for(int i = 0; i < resultOcc.getTrackEdgeSections().size(); i++) {
                TrackEdgeSection TES = resultOcc.getTrackEdgeSections().get(i);
                TopologyGraph.Edge E = TES.getTrackEdge();
                System.out.println("TES " + i + ": SectionLength: " + E.dTopLength + " EDGE_ID: " + E.getRefId());
                System.out.println("TES " + i + ": Begin (%)" + TES.getBegin().intrinsicCoord);
                System.out.println("TES " + i + ": END (%)" + TES.getEnd().intrinsicCoord);

        }


        where:
        testid | offsetMeter | nid_lrbg | q_dir_lrgb | trainlength | isReverse
        1      | 7           | 12778    | 1          | 3           | false
        2      | 150         | 12778    | 1          | 70          | false
        3      | 300         | 12778    | 1          | 120         | false
        4      | 1150        | 12778    | 1          | 1000        | false
        5      | 2300        | 12778    | 1          | 1000        | false
        6      | 3100        | 12778    | 1          | 1000        | false
        7      | 2900        | 12778    | 1          | 2000        | false
    }




}
