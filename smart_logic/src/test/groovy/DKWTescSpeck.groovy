import de.ibw.tms.ma.physical.TrackElementStatus
import de.ibw.tms.plan.elements.model.PlanData
import de.ibw.tms.trackplan.viewmodel.TranslationModel
import ebd.SlConfigHandler
import ebd.TescModul
import ebd.ibw.sessions.TescSession
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @since 2021-03-17
 * @version 1.0
 *
 */
class DKWTescSpeck extends Specification {
    @Shared sEWExisting = "11W45";
    @Shared sDKWExisting = "12W19";
    @Shared sDKWPARALLEL = "12W20";
    @Shared EWleft = new TrackElementStatus();
    @Shared EWright = new TrackElementStatus();
    @Shared Unknown = new TrackElementStatus();
    @Shared INVALIDA = new TrackElementStatus();
    @Shared INVALIDB = new TrackElementStatus();
    @Shared EWleftright = new TrackElementStatus();



   def "DKW check: set State on simulated EBD on DKW with Valid status for DWK-Weiche"() {
            given:

        SlConfigHandler.getInstance().useInfrastructureServer = useInfra;
        TranslationModel.TrackplanEnvironment.CurrentEnvironment =
                TranslationModel.TrackplanEnvironment.MartinsteinWithoutBalisenEnv
        def TescSession dummySession = Mock(TescSession) {

        }

        TescModul.getInstance().session = dummySession
        PlanData.getInstance();
        EWleft.statusList.clear();
        EWleft.statusList.add(TrackElementStatus.Status.LEFT);
        EWleft.statusList.add(TrackElementStatus.Status.LEFT);
        EWright.statusList.clear();
        EWright.statusList.add(TrackElementStatus.Status.RIGHT);
        EWright.statusList.add(TrackElementStatus.Status.RIGHT);
        Unknown.statusList.clear()
        Unknown.statusList.add(TrackElementStatus.Status.UNKNOWN);
        Unknown.statusList.add(TrackElementStatus.Status.UNKNOWN);
        INVALIDA.statusList.clear();
        INVALIDA.statusList.add(TrackElementStatus.Status.UNKNOWN);
        INVALIDA.statusList.add(TrackElementStatus.Status.LEFT);
        INVALIDB.statusList.clear();
        INVALIDB.statusList.add(TrackElementStatus.Status.RIGHT);
        INVALIDB.statusList.add(TrackElementStatus.Status.UNKNOWN);
        EWleftright.statusList.clear();
        EWleftright.statusList.add(TrackElementStatus.Status.LEFT);
        EWleftright.statusList.add(TrackElementStatus.Status.RIGHT);

        when:
        TescModul.getInstance().setState(a, b)
        then:
        callCount * dummySession.set(sDKWExisting + POS_KIND as String, TESC_DKW_DIGITLower)
        callCount * dummySession.set(sDKWPARALLEL + POS_KIND as String, TESC_DKW_DIGITHigher)

        expect:
        TescModul.getInstance().setState(a, b) == c
        where:
        a           | b         | c     | TESC_DKW_DIGITLower | TESC_DKW_DIGITHigher  |  useInfra  | POS_KIND | callCount
        sDKWExisting | EWleft    | true  | 1                  | 1                   |  false     | "I"     |  1
        sDKWPARALLEL | EWright    | false | 2                 | 2                       |  true      | "S"   |    0
        sDKWExisting | Unknown    | true | 0                  | 0                       |  false     | "I"   |    1
        sDKWPARALLEL | INVALIDA    | false  | 1              |  0                       |    false     | "I"   |  0
        sDKWExisting | INVALIDB    | false | 2              |   0                       |    true      | "S"   |  0
        sDKWPARALLEL | Unknown    | false | 0              |     0                       |  false     | "I"   |    0
        sDKWExisting | EWleftright    | true  | 1             | 2                       |  false     | "I"   |  1


    }






}
