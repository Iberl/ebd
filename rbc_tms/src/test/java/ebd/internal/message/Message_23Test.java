package ebd.internal.message;

import ebd.internal.MessageTestBase;
import ebd.internal.payload.Payload_23;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_23Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_23("tms_123", "rbc_123", new Payload_23(0,0,false,0,0,0,0,0)), "Message_23_TestCase_00")
        );
    }

}