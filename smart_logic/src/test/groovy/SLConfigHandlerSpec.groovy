import ebd.SlConfigHandler
import spock.lang.Specification

import java.security.InvalidParameterException

class SLConfigHandlerSpec extends Specification {
    def "loaded properties file not existing"() {

        setup:
            SlConfigHandler.setAppPropFileName("rubish");




        when:
         SlConfigHandler.getInstance();

        then:
        thrown(InvalidParameterException)
    }
    def "everything fine"() {

        setup:
        SlConfigHandler.setAppPropFileName("application.properties");




        when:
        SlConfigHandler.getInstance();

        then:
        notThrown(InvalidParameterException)
    }
}
