package ebd.internal.message;

import ebd.internal.MessageTestBase;
import ebd.internal.payload.Payload_02;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_02Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_02("tms_123", "rbc_123", new Payload_02()), "Message_02_TestCase_00")
        );
    }

}