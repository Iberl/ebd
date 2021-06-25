package ebd.internal.message;

import ebd.internal.MessageTestBase;
import ebd.internal.payload.Payload_24;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_24Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_24("tms_123", "rbc_123", new Payload_24(0, 0, false, 0)), "Message_24_TestCase_00")
        );
    }

}