package ebd.rbc_tms.message;

import ebd.rbc_tms.MessageTestBase;
import ebd.rbc_tms.payload.Payload_20;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_20Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_20("tms_123", "rbc_123", new Payload_20(0)), "Message_20_TestCase_00")
        );
    }

}