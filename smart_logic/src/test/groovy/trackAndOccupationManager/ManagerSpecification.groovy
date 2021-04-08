package trackAndOccupationManager

import data.ComposedRouteDataProvider
import de.ibw.history.TrackAndOccupationManager
import de.ibw.history.data.ComposedRoute
import de.ibw.tms.etcs.ETCS_DISTANCE
import de.ibw.tms.ma.MARequest
import de.ibw.tms.ma.MovementAuthority
import de.ibw.tms.ma.mob.MovableObject
import de.ibw.tms.ma.mob.position.MOBPosition
import de.ibw.tms.ma.mob.position.SafeMOBPosition
import de.ibw.tms.ma.occupation.MAOccupation
import de.ibw.tms.ma.occupation.MARequestOccupation
import de.ibw.tms.ma.occupation.Occupation
import de.ibw.tms.ma.occupation.VehicleOccupation
import de.ibw.tms.ma.occupation.intf.IMoveable
import de.ibw.tms.ma.positioned.elements.TrackEdge
import de.ibw.util.ThreadedRepo
import spock.lang.Specification

import java.lang.reflect.Field
/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @since 2021-04-07
 * @version 1.0
 *
 */
class ManagerSpecification extends Specification {

    static void setStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);
        field.set(null, newValue);
    }
    static void resetTrackManager() {
        setStatic(TrackAndOccupationManager.class.getDeclaredField("Storage"), new ThreadedRepo<>());
        setStatic(TrackAndOccupationManager.class.getDeclaredField("VehicleOccStorage"), new TrackAndOccupationManager.VehicleStorage());
    }


    def "getReadOnlyTest"() {
        given:
        resetTrackManager();
        ComposedRouteDataProvider provider = new ComposedRouteDataProvider();
        ComposedRoute CR = provider.generateComposedRoute(lOfElments, trackOrd, startperc as double, endperc as double);
        ETCS_DISTANCE NoDistance = new ETCS_DISTANCE();
        NoDistance.sDistance = 0;

        ArrayList<Occupation> occupations = new ArrayList<>();
        ArrayList<Class> occupationTypes = new ArrayList<>();

        occupations.add(new MAOccupation());
        occupationTypes.add(MAOccupation.class);
        occupations.add(new MARequestOccupation());
        occupationTypes.add(MARequestOccupation.class);
        occupations.add(new VehicleOccupation());
        occupationTypes.add(VehicleOccupation.class);
        occupations.add(new MARequestOccupation());
        occupationTypes.add(MARequestOccupation.class)


        MovableObject MobObject = Stub(MovableObject);
        MovementAuthority ma = Spy(new MovementAuthority());
        ma.getMOB() >> MobObject;
        MobObject.getMA() >> ma;

        ArrayList<Occupation> expectation = new ArrayList<>();



        for(int i = 0; i< occupations.size(); i++) {
            Occupation O = Spy( CR.createSubRoute(NoDistance, NoDistance, 1, occupations.get(i)));
            ((IMoveable )O).getTargetMoveableObject() >> MobObject
            System.out.println(O.getId());
            expectation.add(O);

            TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
            occupationTypes.get(i), O);

        }

        expect:
        ThreadedRepo<TrackEdge, ArrayList<Occupation>> result =  TrackAndOccupationManager.getReadOnly(
                VehicleOccupation.class, null);

        result.getAll().iterator().next().get(0).getId() == expectation.get(2).getId();
        ThreadedRepo<TrackEdge, ArrayList<Occupation>> result2 = TrackAndOccupationManager.getReadOnly(
                MAOccupation.class, MobObject);
        result2.getAll().iterator().next().get(0).getId() == expectation.get(0).getId();
        ThreadedRepo<TrackEdge, ArrayList<Occupation>> result3 = TrackAndOccupationManager.getReadOnly(
                MARequestOccupation.class, MobObject);

        // Mobile Object is updating old request so size remains 1 not two
        result3.getAll().iterator().next().size() == 1;




        where:
        lOfElments      | trackOrd   | startperc    | endperc | startMeter  | endMeter | scale | limits
        [100]           | [1]        | 0.2          | 0.6     | 20          | 70       | 0     | [[0.22, 0.53]]
        [0, 30]         | [0, 0]     | 0.2          | 0       | 3           | 24       | 1     | [[0.8, 0.9] ]
        [100, 200]      | [1, 1]     | 0            | 1       | 250         | 20       | 1     | [[ 0.75, 0.9 ]]
        [100, 200]      | [1, 1]     | 0            | 1       |  50         | 20      | 1     | [[ 0.5 , 1 ],[0, 0.9]]
        [100, 200, 100] | [1, 0, 1]  | 0.5          | 0.5     | 275         | 25      | 1     | [ [ 0.25, 0.25 ] ]
        [100, 200, 100] | [0, 0, 1]  | 0.75         | 0.75    | 50          | 50      | 1     | [[0, 0.25],[0,1],[0, 0.25]]
    }


    def "operationTest"() {
        given:
        resetTrackManager();
        ComposedRouteDataProvider provider = new ComposedRouteDataProvider();
        ComposedRoute CR = provider.generateComposedRoute(lOfElments, trackOrd, startperc as double, endperc as double);
        ETCS_DISTANCE NoDistance = new ETCS_DISTANCE();
        NoDistance.sDistance = 0;

        ArrayList<Occupation> occupations = new ArrayList<>();
        ArrayList<Class> occupationTypes = new ArrayList<>();

        occupations.add(new MAOccupation());
        occupationTypes.add(MAOccupation.class);
        occupations.add(new MARequestOccupation());
        occupationTypes.add(MARequestOccupation.class);
        occupations.add(new VehicleOccupation());
        occupationTypes.add(VehicleOccupation.class);
        occupations.add(new MARequestOccupation());
        occupationTypes.add(MARequestOccupation.class)


        MovableObject MobObject = Stub(MovableObject);
        MovementAuthority ma = Spy(new MovementAuthority());
        ma.getMOB() >> MobObject;
        MobObject.getMA() >> ma;

        new MARequest(ma, occupations.get(1) as MARequestOccupation)
        new MARequest(ma, occupations.get(3) as MARequestOccupation)


        ((MAOccupation)occupations.get(0)).setMA(ma);


        ArrayList<Occupation> expectation = new ArrayList<>();



        for(int i = 0; i< occupations.size(); i++) {
            Occupation O = Spy( CR.createSubRoute(NoDistance, NoDistance, 1, occupations.get(i)));
            ((IMoveable )O).getTargetMoveableObject() >> MobObject
            System.out.println(O.getId());
            expectation.add(O);

            TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                    occupationTypes.get(i), O);

        }
        /*SafeMOBPosition NewPosition = new SafeMOBPosition();
        NewPosition.defineNewVehiclePosition(CR.getRouteLength().subtract(10), CR, NoDistance,1);
        //MOBPosition newMobPosition = new MOBPosition(NewPosition);
        NewPosition.setOccupation(occupations.get(2) as VehicleOccupation)
        ETCS_DISTANCE NoEndOffset = new ETCS_DISTANCE();
        NoEndOffset.sDistance = 0;
*/
        Occupation ToDeleteOcc = expectation.get(deleteIndex);
        Class deleteType = occupationTypes.get(deleteIndex);

        TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.RemoveOperation,
                deleteType, ToDeleteOcc
        )

        expect:
        switch (deleteIndex) {
            case 0: {
                TrackAndOccupationManager.getReadOnly(deleteType,MobObject).getAll().iterator().next().size() == 0
                break;
            }
            case 1: {
                TrackAndOccupationManager.getReadOnly(deleteType,MobObject).getAll().iterator().next().get(0) == occupations.get(3);
                break;
            }
            case 2: {
                TrackAndOccupationManager.getReadOnly(deleteType,MobObject).getAll().iterator().next().size() == 0
                break;
            }
            case 3: {
                TrackAndOccupationManager.getReadOnly(deleteType,MobObject).getAll().iterator().next().size() == 0
                break;
            }
        }










        where:
        lOfElments      | trackOrd   | startperc    | endperc | startMeter  | endMeter | scale | limits                 | deleteIndex
        [100]           | [1]        | 0.2          | 0.6     | 20          | 70       | 0     | [[0.22, 0.53]]         | 0
        [0, 30]         | [0, 0]     | 0.2          | 0       | 3           | 24       | 1     | [[0.8, 0.9] ]          | 1
        [100, 200]      | [1, 1]     | 0            | 1       | 250         | 20       | 1     | [[ 0.75, 0.9 ]]        | 2
        [100, 200]      | [1, 1]     | 0            | 1       |  50         | 20      | 1     | [[ 0.5 , 1 ],[0, 0.9]]  | 3
        [100, 200, 100] | [1, 0, 1]  | 0.5          | 0.5     | 275         | 25      | 1     | [ [ 0.25, 0.25 ] ]      | 0
        [100, 200, 100] | [0, 0, 1]  | 0.75         | 0.75    | 50          | 50      | 1     | [[0, 0.25],[0,1],[0, 0.25]] | 1
    }


}
