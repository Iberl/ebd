package ebd.internal.message;

import ebd.internal.MessageTestBase;
import ebd.internal.payload.Payload_25;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_25Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_25("tms_123", "rbc_123", new Payload_25(0, 0, false, 0)), "Message_25_TestCase_00")
        );
    }

}