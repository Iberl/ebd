import de.ibw.smart.logic.datatypes.QueueUuidMapper
import de.ibw.smart.logic.exceptions.SmartLogicException
import de.ibw.smart.logic.intf.SmartLogic
import ebd.TescModul
import spock.lang.Shared
import spock.lang.Specification

import java.security.InvalidParameterException

class QueueUuidMapperSpec extends Specification {
    @Shared resultAct = null;

    def "Invalid null poll check"() {
        given:
            def MUT = new QueueUuidMapper();
        when:
            MUT.poll(null)
        then:
            thrown(InvalidParameterException)
    }
    def "Invalid unknown uuid poll check"() {
        given:
        def MUT = new QueueUuidMapper();
        when:
        MUT.poll(new UUID(17L, 3L));
        then:
        thrown(InvalidParameterException)
    }

    def "Timout poll check"() {
        given:
        def MUT = new QueueUuidMapper();
        MUT.createQueue(new UUID(17L, 3L));
        SmartLogic.TIMEOUT_SETTING_WAITING_MA_ACK_IN_SECONDS = 2
        expect:
        MUT.poll(new UUID(17L, 3L)) == null

    }
    def "checkValidPoll"() {
        given:
        def MUT = new QueueUuidMapper();
        MUT.createQueue(new UUID(17L, 3L));
        SmartLogic.TIMEOUT_SETTING_WAITING_MA_ACK_IN_SECONDS = 60;




        expect:
        def pollThread = new Thread() {
            private boolean expected = null;
            public void setExpected( boolean b) {
                expected = b;
            }
            @Override
            void run() {
                resultAct = MUT.poll(new UUID(17L, 3L));
                resultAct == expected
            }
        }

        def offerThread = new Thread() {

            private boolean expected = null;
            public void setExpected( boolean b) {
                expected = b;
            }

            @Override
            void run() {
                MUT.offer(new UUID(17L, 3L), expected)
            }
        }

        pollThread.setExpected(resultExpected)
        pollThread.start();

        offerThread.setExpected(resultExpected)

        sleep(2000)

        offerThread.start()


        where:
            resultExpected | none
            true    | ""
            false   | ""



    }

    def "Invalid null offer check"() {
        given:
        def MUT = new QueueUuidMapper();
        when:
        MUT.offer(null, true)
        then:
        thrown(InvalidParameterException)
    }
    def "Invalid unknown uuid offer check"() {
        given:
        def MUT = new QueueUuidMapper();
        when:
        MUT.offer(new UUID(17L, 3L), true);
        then:
        thrown(InvalidParameterException)
    }

    def "Timout offer check"() {
        given:
        def MUT = new QueueUuidMapper();
        MUT.createQueue(new UUID(17L, 3L));
        SmartLogic.TIMEOUT_SETTING_WAITING_MA_ACK_IN_SECONDS = 2



    }
}
