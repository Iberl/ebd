package ebd.rbc_tms.message;

import ebd.rbc_tms.MessageTestBase;
import ebd.rbc_tms.payload.Payload_12;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_12Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_12("tms_123", "rbc_123", new Payload_12(0L, 0)), "Message_12_TestCase_00")
        );
    }

}