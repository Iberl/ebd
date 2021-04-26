package safety

import data.ComposedRouteDataProvider
import de.ibw.feed.Balise
import de.ibw.history.TrackAndOccupationManager
import de.ibw.history.data.ComposedRoute
import de.ibw.smart.logic.safety.SafetyLogic
import de.ibw.tms.ma.MovementAuthority
import de.ibw.tms.ma.location.SpotLocationIntrinsic
import de.ibw.tms.ma.mob.MovableObject
import de.ibw.tms.ma.mob.common.NID_ENGINE
import de.ibw.tms.ma.mob.position.SafeMOBPosition
import de.ibw.tms.ma.occupation.MAOccupation
import de.ibw.tms.ma.occupation.MARequestOccupation
import de.ibw.tms.ma.occupation.Occupation
import de.ibw.tms.ma.occupation.VehicleOccupation
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection
import de.ibw.tms.plan.elements.model.PlanData
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph
import de.ibw.tms.trackplan.viewmodel.TranslationModel
import ebd.SlConfigHandler
import ebd.rbc_tms.util.MA
import ebd.rbc_tms.util.PositionInfo
import org.apache.commons.text.translate.OctalUnescaper
import plan_pro.modell.signalbegriffe_ril_301._1_9.MsRt
import spock.lang.Specification
import trackAndOccupationManager.ManagerSpecification

import javax.print.attribute.standard.MediaSize
import javax.sound.midi.Track
import java.security.InvalidParameterException

/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @since 2021-04-21
 * @version 1.0
 *
 */
class RouteIsNonBlockCheck extends Specification {


    def "collisionsDetectedPositiveTest1"() {
        given:
        int distanceBetweenBaliseAndBeginOfMa = 40; // Meter

        int distanceFromBaliseToNewPos = 290; // Meter
        int trainLength = 50;
        int trainSpeed = 70; //km/h
        int v_train = 70 / 5;
        int inidEngine = 4; // tested nid
        int otherEngine = 1 // dummy nid


        ManagerSpecification.resetTrackManager();
        SlConfigHandler.getInstance().useInfrastructureServer = false;
        TranslationModel.TrackplanEnvironment.CurrentEnvironment = TranslationModel.TrackplanEnvironment.KaefWilhelmstalEnv;
        PlanData.getInstance();
        ComposedRouteDataProvider dataProvider = new ComposedRouteDataProvider();
        ComposedRoute CR = new ComposedRouteDataProvider().generateComposedRoute(lOfElments, trackOrd,
                startperc as double, endperc as double)

        MovableObject MobObject = Stub(MovableObject);
        MovementAuthority ma = Spy(new MovementAuthority());
        ma.getMOB() >> MobObject;
        MobObject.getMA() >> ma;

        SafeMOBPosition SafePosition = new SafeMOBPosition();
        ArrayList<TrackEdgeSection> sectionList = new ArrayList<>();
        SpotLocationIntrinsic begin = new SpotLocationIntrinsic();
        begin.setIntrinsicCoord(0.0d);
        SpotLocationIntrinsic end = new SpotLocationIntrinsic();
        end.setIntrinsicCoord(1.0d);


        MAOccupation MaStub = Stub(MAOccupation.class);
        ArrayList<TrackEdgeSection> testedSections = new ArrayList<>()
        TrackEdgeSection TES = new TrackEdgeSection();
        MovableObject OtherObject = Stub(MovableObject);
        OtherObject.getNid_Engine() >> new NID_ENGINE(otherEngine)




        MARequestOccupation Mao = new MARequestOccupation(CR, ma, true)

        MaStub.getTargetMoveableObject() >> OtherObject
        MaStub.getTrackEdgeSections() >> Mao.getTrackEdgeSections()




        TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                MAOccupation.class, MaStub)


        SafetyLogic MUT = SafetyLogic.getSmartSafety();



        expect:
        MUT.checkIfRouteIsNonBlocked(Mao) == expectation

        where:
        lOfElments      | trackOrd   | startperc    | endperc | startMeter  | endMeter | scale | expectation
        [100, 200]      | [1, 1]     | 0.5          | 1       |  null         | null      | 1     | false

    }
    def "collisionsDetectedPositiveTest2"() {
        given:
        int distanceBetweenBaliseAndBeginOfMa = 40; // Meter

        int distanceFromBaliseToNewPos = 290; // Meter
        int trainLength = 50;
        int trainSpeed = 70; //km/h
        int v_train = 70 / 5;
        int inidEngine = 4; // tested nid
        int otherEngine = 1 // dummy nid


        ManagerSpecification.resetTrackManager();
        SlConfigHandler.getInstance().useInfrastructureServer = false;
        TranslationModel.TrackplanEnvironment.CurrentEnvironment = TranslationModel.TrackplanEnvironment.KaefWilhelmstalEnv;
        PlanData.getInstance();
        ComposedRouteDataProvider dataProvider = new ComposedRouteDataProvider();
        ComposedRoute CR = new ComposedRouteDataProvider().generateComposedRoute(lOfElments, trackOrd,
                startperc as double, endperc as double)

        MovableObject MobObject = Stub(MovableObject);
        MovementAuthority ma = Spy(new MovementAuthority());
        ma.getMOB() >> MobObject;
        MobObject.getMA() >> ma;

        SafeMOBPosition SafePosition = new SafeMOBPosition();
        ArrayList<TrackEdgeSection> sectionList = new ArrayList<>();
        SpotLocationIntrinsic begin = new SpotLocationIntrinsic();
        begin.setIntrinsicCoord(0.0d);
        SpotLocationIntrinsic end = new SpotLocationIntrinsic();
        end.setIntrinsicCoord(1.0d);


        MAOccupation MaStub = Stub(MAOccupation.class);
        ArrayList<TrackEdgeSection> testedSections = new ArrayList<>()
        TrackEdgeSection TES = new TrackEdgeSection();
        MovableObject OtherObject = Stub(MovableObject);
        OtherObject.getNid_Engine() >> new NID_ENGINE(otherEngine)




        MARequestOccupation Mao = new MARequestOccupation(CR, ma, true)

        TrackEdgeSection tocopy = Mao.getTrackEdgeSections().get(0);
        TrackEdgeSection tocopy2 = Mao.getTrackEdgeSections().get(1);

        TrackEdgeSection noCollisionSec = new TrackEdgeSection();
        SpotLocationIntrinsic nColBegin = new SpotLocationIntrinsic();
        nColBegin.setIntrinsicCoord(0.0d);
        SpotLocationIntrinsic nColEnd = new SpotLocationIntrinsic();
        nColEnd.setIntrinsicCoord(0.20d);
        noCollisionSec.setTrackEdge(tocopy.getTrackEdge())
        noCollisionSec.setBegin(nColBegin);
        noCollisionSec.setEnd(nColEnd);

        TrackEdgeSection OccupatedSection1 = new TrackEdgeSection();
        SpotLocationIntrinsic occBegin1 = new SpotLocationIntrinsic();
        occBegin1.setIntrinsicCoord(0.25d);
        SpotLocationIntrinsic occEnd1 = new SpotLocationIntrinsic();
        occEnd1.setIntrinsicCoord(0.75d);
        OccupatedSection1.trackEdge = tocopy.trackEdge;
        OccupatedSection1.setBegin(occBegin1);
        OccupatedSection1.setEnd(occEnd1);

        TrackEdgeSection OccupatedSection2 = new TrackEdgeSection();
        SpotLocationIntrinsic occBegin2 = new SpotLocationIntrinsic();
        occBegin1.setIntrinsicCoord(0.5d);
        SpotLocationIntrinsic occEnd2 = new SpotLocationIntrinsic();
        occEnd1.setIntrinsicCoord(0.9d);
        OccupatedSection2.trackEdge = tocopy2.trackEdge;
        OccupatedSection2.setBegin(occBegin2);
        OccupatedSection2.setEnd(occEnd2);

        ArrayList<TrackEdgeSection> occSection1 = new ArrayList<>();
        ArrayList<TrackEdgeSection> occSection2 = new ArrayList<>();
        ArrayList<TrackEdgeSection> noOccSection = new ArrayList<>();

        noOccSection.add(noCollisionSec);


        occSection1.add(OccupatedSection1);
        occSection2.add(OccupatedSection2);


        MaStub.getTargetMoveableObject() >> OtherObject
        MaStub.getTrackEdgeSections() >> occSection1
        MAOccupation MaStub2 = Stub(MAOccupation.class);
        MaStub2.getTargetMoveableObject() >> OtherObject
        MaStub2.getTrackEdgeSections() >> occSection2

        MAOccupation MaStub3 = Stub(MAOccupation.class);
        MaStub3.getTargetMoveableObject() >> OtherObject
        MaStub3.getTrackEdgeSections() >> noOccSection



        TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                MAOccupation.class, MaStub)


        SafetyLogic MUT = SafetyLogic.getSmartSafety();



        expect:
        MUT.checkIfRouteIsNonBlocked(Mao) == expectation
        ManagerSpecification.resetTrackManager();
        TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                MAOccupation.class, MaStub2)
        MUT.checkIfRouteIsNonBlocked(Mao) == expectation
        ManagerSpecification.resetTrackManager();
        TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                MAOccupation.class, MaStub3)
        MUT.checkIfRouteIsNonBlocked(Mao) == !expectation

        where:
        lOfElments      | trackOrd   | startperc    | endperc | startMeter  | endMeter | scale | expectation
        [100, 200]      | [1, 1]     | 0.5          | 1       |  null       | null     | 1     | false

    }

    def "trackManagerIsEmptyTest"() {
        given:
        ManagerSpecification.resetTrackManager();
        ComposedRouteDataProvider dataProvider = new ComposedRouteDataProvider();
        ComposedRoute CR = new ComposedRouteDataProvider().generateComposedRoute(lOfElments, trackOrd,
                startperc as double, endperc as double)

        MovableObject MobObject = Stub(MovableObject);
        MovementAuthority ma = Spy(new MovementAuthority());
        ma.getMOB() >> MobObject;
        MobObject.getMA() >> ma;

        MARequestOccupation Mao = new MARequestOccupation(CR, ma, true)
        SafetyLogic MUT = SafetyLogic.getSmartSafety();

        expect:
        MUT.checkIfRouteIsNonBlocked(Mao) == expectation






        where:
        lOfElments      | trackOrd   | startperc    | endperc | startMeter  | endMeter | scale | expectation
        [100]           | [1]        | 0.2          | 0.6     | 20          | 70       | 0     | true
        [0, 30]         | [0, 0]     | 0.2          | 0       | 3           | 24       | 1     | true
        [100, 200]      | [1, 1]     | 0            | 1       | 250         | 20       | 1     | true
        [100, 200]      | [1, 1]     | 0            | 1       |  50         | 20      | 1     | true
        [100, 200, 100] | [1, 0, 1]  | 0.5          | 0.5     | 275         | 25      | 1     | true
        [100, 200, 100] | [0, 0, 1]  | 0.75         | 0.75    | 50          | 50      | 1     | true



    }

    def "occupationOnOtherTrackEdge"() {
        given:

        int dummyBaliseId = 12778;
        int distanceBetweenBaliseAndBeginOfMa = 40; // Meter

        int distanceFromBaliseToNewPos = 290; // Meter
        int trainLength = 50;
        int trainSpeed = 70; //km/h
        int v_train = 70 / 5;
        int inidEngine = 4; // tested nid
        int otherEngine = 1 // dummy nid


        ManagerSpecification.resetTrackManager();
        SlConfigHandler.getInstance().useInfrastructureServer = false;
        TranslationModel.TrackplanEnvironment.CurrentEnvironment = TranslationModel.TrackplanEnvironment.KaefWilhelmstalEnv;
        PlanData.getInstance();
        ComposedRouteDataProvider dataProvider = new ComposedRouteDataProvider();
        ComposedRoute CR = new ComposedRouteDataProvider().generateComposedRoute(lOfElments, trackOrd,
                startperc as double, endperc as double)

        MovableObject MobObject = Stub(MovableObject);
        MovementAuthority ma = Spy(new MovementAuthority());
        ma.getMOB() >> MobObject;
        MobObject.getMA() >> ma;

        SafeMOBPosition SafePosition = new SafeMOBPosition();
        ArrayList<TrackEdgeSection> sectionList = new ArrayList<>();
        SpotLocationIntrinsic begin = new SpotLocationIntrinsic();
        begin.setIntrinsicCoord(0.0d);
        SpotLocationIntrinsic end = new SpotLocationIntrinsic();
        end.setIntrinsicCoord(1.0d);
        PositionInfo PI = new PositionInfo(1,dummyBaliseId, null, distanceFromBaliseToNewPos,1,1,0,0,1, trainLength,
                v_train, 1, 0, 0, null);
        VehicleOccupation VO = VehicleOccupation.generateVehicleOccupation(PI, new NID_ENGINE(inidEngine), SafePosition,
        sectionList, begin, end)

        MAOccupation MaStub = Stub(MAOccupation.class);
        ArrayList<TrackEdgeSection> testedSections = new ArrayList<>()
        TrackEdgeSection TES = new TrackEdgeSection();
        int nid_lrbg = 12778;
        Balise LrbgBalise = Balise.baliseByNid_bg.getModel(nid_lrbg);
        if(LrbgBalise == null) throw new InvalidParameterException("LrbgBalise not found (Nid):" + nid_lrbg);
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(LrbgBalise.getTopPositionOfDataPoint().getIdentitaet().getWert());
        MovableObject OtherObject = Stub(MovableObject);

        OtherObject.getNid_Engine() >> new NID_ENGINE(otherEngine)


        ArrayList<TrackEdgeSection> otherSections = new ArrayList<>();
        TrackEdgeSection otherSection = new TrackEdgeSection();
        otherSection.setTrackEdge(E);
        otherSection.setBegin(begin);
        otherSection.setEnd(end);
        otherSections.add(otherSection);



                MaStub.getTargetMoveableObject() >> OtherObject
                MaStub.getTrackEdgeSections() >> otherSections


        TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                VehicleOccupation.class, VO);

        TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                MAOccupation.class, MaStub)

        MARequestOccupation Mao = new MARequestOccupation(CR, ma, true)
        SafetyLogic MUT = SafetyLogic.getSmartSafety();

        expect:
        MUT.checkIfRouteIsNonBlocked(Mao) == expectation






        where:
        lOfElments      | trackOrd   | startperc    | endperc | startMeter  | endMeter | scale | expectation
        [100]           | [1]        | 0.2          | 0.6     | 20          | 70       | 0     | true
        [0, 30]         | [0, 0]     | 0.2          | 0       | 3           | 24       | 1     | true
        [100, 200]      | [1, 1]     | 0            | 1       | 250         | 20       | 1     | true
        [100, 200]      | [1, 1]     | 0            | 1       |  50         | 20      | 1     | true
        [100, 200, 100] | [1, 0, 1]  | 0.5          | 0.5     | 275         | 25      | 1     | true
        [100, 200, 100] | [0, 0, 1]  | 0.75         | 0.75    | 50          | 50      | 1     | true



    }
}
