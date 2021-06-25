package ebd.internal.message;

import ebd.internal.MessageTestBase;
import ebd.internal.payload.Payload_16;
import ebd.internal.util.PositionInfo;
import ebd.internal.util.TrainInfo;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_16Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_16("tms_123", "rbc_123", new Payload_16(new TrainInfo(0, 0, 0L), new PositionInfo(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))), "Message_16_TestCase_00")
        );
    }

}