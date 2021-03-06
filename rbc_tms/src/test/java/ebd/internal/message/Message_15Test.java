package ebd.internal.message;

import ebd.internal.MessageTestBase;
import ebd.internal.payload.Payload_15;
import ebd.internal.util.PositionInfo;
import ebd.internal.util.TrainInfo;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_15Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_15("tms_123", "rbc_123", new Payload_15(new TrainInfo(0, 0, 0L), new PositionInfo(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 0)), "Message_15_TestCase_00")
        );
    }

}