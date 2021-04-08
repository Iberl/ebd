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
import de.ibw.tms.ma.occupation.Occupation
import de.ibw.tms.ma.physical.MoveableTrackElement
import de.ibw.tms.plan.elements.model.PlanData
import de.ibw.tms.trackplan.viewmodel.TranslationModel
import ebd.SlConfigHandler
import ebd.rbc_tms.util.MA
import ebd.rbc_tms.util.PositionInfo
import ebd.rbc_tms.util.TrainInfo
import spock.lang.Specification
/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @since 2021-04-06
 * @version 1.0
 *
 */
class AddPositionDataSpec extends Specification {



    def "defaultAddCheck"() {
        given:

        int dummyBaliseId = 12778;

        PositionModul MUT = PositionModul.getInstance();
        TrainInfo TestInfo = new TrainInfo(1,1,1L);
        SlConfigHandler.getInstance().useInfrastructureServer = false;
        TranslationModel.TrackplanEnvironment.CurrentEnvironment = TranslationModel.TrackplanEnvironment.KaefWilhelmstalEnv;
        PlanData.getInstance();
        PositionInfo TestPosition = new PositionInfo(1,dummyBaliseId,null, 0, 1, 1, 1, 1, 5 , null, 1 , 1 , 1, 1, null)
        PositionData TestData = new PositionData(1L,1L,TestInfo, TestPosition)
        MUT.addPositionData(TestData, PositionEnterType.ENTERED_VIA_POSITION_REPORT);

        expect:
        MUT.getAllPositions().size() == 1




    }



}
