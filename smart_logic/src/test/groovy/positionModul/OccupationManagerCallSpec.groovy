package positionModul

import data.ComposedRouteDataProvider
import de.ibw.history.PositionData
import de.ibw.history.PositionModul
import de.ibw.history.TrackAndOccupationManager
import de.ibw.history.data.ComposedRoute
import de.ibw.history.data.PositionEnterType
import de.ibw.tms.ma.MovementAuthority
import de.ibw.tms.ma.mob.MovableObject
import de.ibw.tms.ma.mob.common.NID_ENGINE
import de.ibw.tms.ma.mob.position.MOBPosition
import de.ibw.tms.ma.mob.position.MOBPositionClasses
import de.ibw.tms.ma.mob.position.SafeMOBPosition
import de.ibw.tms.ma.occupation.MAOccupation
import de.ibw.tms.ma.occupation.VehicleOccupation
import de.ibw.tms.plan.elements.model.PlanData
import de.ibw.tms.trackplan.viewmodel.TranslationModel
import ebd.rbc_tms.util.PositionInfo
import spock.lang.Specification

/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @since 2021-04-06
 * @version 1.0
 *
 */
class OccupationManagerCallSpec extends Specification {


    def "addNewPositonOnExistingMaRouteCheck"() {
        given:
        int dummyBaliseId = 12778;
        int distanceBetweenBaliseAndBeginOfMa = 40; // Meter

        int distanceFromBaliseToNewPos = 290; // Meter
        int trainLength = 50;
        int trainSpeed = 70; //km/h
        int v_train = 70 / 5;
        int inidEngine = 4;

        def lOfElments = [100, 200, 100];
        def trackOrd = [0, 0, 1]
        def startperc = 0.75;
        def endperc =  0.75;


        TranslationModel.TrackplanEnvironment.CurrentEnvironment = TranslationModel.TrackplanEnvironment.KaefWilhelmstalEnv;
        PlanData.getInstance();

        PositionInfo PI = new PositionInfo(1,dummyBaliseId, null, distanceFromBaliseToNewPos,1,1,0,0,1, trainLength,
                v_train, 1, 0, 0, null);
        PositionData PosDataInput = new PositionData(1L, 1L , null, PI);
        PosDataInput.nid_engine = inidEngine;

        PositionInfo PreviousPosition = new PositionInfo(1,dummyBaliseId, null, distanceBetweenBaliseAndBeginOfMa,1,1,0,0,1, trainLength,
                v_train, 1, 0, 0, null);
        PositionData StartMaPosition = new PositionData(1L, 1L , null, PreviousPosition);
        StartMaPosition.nid_engine = inidEngine;


        ComposedRoute Route = new ComposedRouteDataProvider().generateComposedRoute(lOfElments, trackOrd,
                startperc as double, endperc as double);

        Route.setStartPosition(StartMaPosition, inidEngine);
        NID_ENGINE nid_engine = new NID_ENGINE(inidEngine);
        MOBPositionClasses positionClasses = new SafeMOBPosition();
        MOBPosition mobPos = new MOBPosition(positionClasses);
        MovableObject MobObject = new MovableObject(nid_engine, mobPos);
        MovementAuthority ma = new MovementAuthority();
        MobObject.setMA(ma);



        PositionModul MUT = Spy(PositionModul.getInstance());




        MUT.getRouteOfNidEngine(4) >> Route

        MUT.addPositionData(PosDataInput, PositionEnterType.ENTERED_VIA_POSITION_REPORT);

        expect:
        // Track And Occupation Manger received 1 VehicleOccupation and 1 MAOccupation
        TrackAndOccupationManager.getReadOnly(VehicleOccupation.class, MobObject).getAll().iterator().next().size() == 1;
        TrackAndOccupationManager.getReadOnly(MAOccupation.class, MobObject).getAll().iterator().next().size() == 1;




    }
}
