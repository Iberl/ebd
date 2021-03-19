package messages

import de.ibw.smart.logic.datatypes.QueueUuidMapper
import de.ibw.smart.logic.intf.messages.DbdRequestReturnPayload
import spock.lang.Specification

import java.security.InvalidParameterException

class DbdRequestReturnPayloadSpec extends Specification {
    def "set error state test"() {
        given:
        def MUT = new DbdRequestReturnPayload("test");
        MUT.setDbdSuccessfull();
        expect:
        MUT.setErrorState(failreason);
        MUT.getsFailreason() == failreason
        !MUT.isDbdCommandSuccessfull()
        where:
        failreason | mode
        "test fail" | ""
        "failed test" | ""
    }
    def "json parse test"() {
        given:
        def MUT = new DbdRequestReturnPayload(sid);
        MUT.setDbdSuccessfull();
        expect:
        MUT.setErrorState(failreason);
        MUT.getsFailreason() == failreason
        System.out.println(MUT.parseToJson());
        MUT.parseToJson().equals('{"type":"DBD_REQUEST_RETURN","dbdCommandSuccessfull":false,"sDbdCommandTargetName":"' +
                 sid + '","sFailreason":"' + failreason + '"}');
        MUT.setDbdSuccessfull();
        MUT.parseToJson().equals('{"type":"DBD_REQUEST_RETURN","dbdCommandSuccessfull":true,"sDbdCommandTargetName":"' +
                sid + '","sFailreason":""}');
        where:
        failreason | sid
        "test fail" | "test"
        "failed test" | "test 2"
    }
}
