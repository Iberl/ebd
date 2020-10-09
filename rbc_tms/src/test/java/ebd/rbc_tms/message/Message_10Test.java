package ebd.rbc_tms.message;

import ebd.rbc_tms.MessageTestBase;
import ebd.rbc_tms.payload.Payload_10;
import ebd.rbc_tms.util.TrainInfo;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_10Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_10("tms_123", "rbc_123", new Payload_10(new TrainInfo(0, 0, 0L))), "Message_10_TestCase_00")
        );
    }

}