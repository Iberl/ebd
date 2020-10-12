package ebd.rbc_tms.message;

import ebd.rbc_tms.MessageTestBase;
import ebd.rbc_tms.payload.Payload_15;
import ebd.rbc_tms.util.PositionInfo;
import ebd.rbc_tms.util.TrainInfo;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_15Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_15("tms_123", "rbc_123", new Payload_15(new TrainInfo(0, 0, 0L), new PositionInfo(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 0)), "Message_15_TestCase_00")
        );
    }

}