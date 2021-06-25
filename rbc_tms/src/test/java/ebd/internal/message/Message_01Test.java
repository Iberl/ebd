package ebd.internal.message;

import ebd.internal.MessageTestBase;
import ebd.internal.payload.Payload_01;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_01Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_01("tms_123", "rbc_123", new Payload_01(0L, 0, "1.0")), "Message_01_TestCase_00")
        );
    }

}