package ebd.internal.message;

import ebd.internal.MessageTestBase;
import ebd.internal.payload.Payload_10;
import ebd.internal.util.TrainInfo;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_10Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_10("tms_123", "rbc_123", new Payload_10(new TrainInfo(0, 0, 0L))), "Message_10_TestCase_00")
        );
    }

}