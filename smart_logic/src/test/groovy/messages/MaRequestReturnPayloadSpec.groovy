package messages


import de.ibw.smart.logic.intf.messages.DbdRequestReturnPayload
import de.ibw.smart.logic.intf.messages.MaRequestReturnPayload
import spock.lang.Specification

class MaRequestReturnPayloadSpec extends Specification {

    def "json parse test"() {
        given:
        def MUT = new MaRequestReturnPayload("test");

        expect:


        System.out.println(MUT.parseToJson());

        where:
        failreason | mode
        "test fail" | ""
        "failed test" | ""
    }
}
