package positionModul


import de.ibw.history.PositionData
import de.ibw.history.PositionModul
import de.ibw.history.data.PositionEnterType
import de.ibw.smart.logic.EventBusManager
import de.ibw.tms.plan.elements.model.PlanData
import de.ibw.tms.trackplan.viewmodel.TranslationModel
import ebd.SlConfigHandler
import ebd.internal.util.PositionInfo
import ebd.internal.util.TrainInfo
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

        EventBusManager.RootEventBusManger = EventBusManager.registerOrGetBus(77, false);
        int dummyBaliseId = 12778;

        PositionModul MUT = PositionModul.getInstance();
        //TrainInfo TestInfo = new TrainInfo(1,1,1L);
        SlConfigHandler.getInstance().useInfrastructureServer = false;
        TranslationModel.TrackplanEnvironment.CurrentEnvironment = TranslationModel.TrackplanEnvironment.KaefWilhelmstalEnv;
        PlanData.getInstance();
        PositionInfo TestPosition = new PositionInfo(1,dummyBaliseId,null, 0, 1, 1, 1, 1, 5 , 14, 1 , 1 , 1, 1, null)
        PositionData TestData = new PositionData(1L,1L,1, TestPosition)
        MUT.addPositionData(TestData, PositionEnterType.ENTERED_VIA_POSITION_REPORT);

        expect:
        MUT.getAllPositions().size() == 1




    }



}
