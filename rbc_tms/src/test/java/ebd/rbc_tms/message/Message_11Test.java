package ebd.rbc_tms.message;

import ebd.rbc_tms.MessageTestBase;
import ebd.rbc_tms.payload.Payload_11;
import ebd.rbc_tms.util.TrainInfo;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_11Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_11("tms_123", "rbc_123", new Payload_11(new TrainInfo(0, 0, 0L))), "Message_11_TestCase_00")
        );
    }

}