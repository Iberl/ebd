package ebd.rbc_tms.message;

import ebd.rbc_tms.MessageTestBase;
import ebd.rbc_tms.payload.Payload_13;
import ebd.rbc_tms.util.PositionInfo;
import ebd.rbc_tms.util.TrainData;
import ebd.rbc_tms.util.TrainInfo;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_13Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_13("tms_123", "rbc_123", new Payload_13(new TrainInfo(0, 0, 0L), new PositionInfo(0, 0, 0, 0, 0, 0,0, 0,0,0, 0, 0, 0, 0, 0), new TrainData(0, 0, 0, 0, 0, 0, 0, 0))), "Message_13_TestCase_00")
        );
    }

}