package ebd.rbc_tms.message;

import ebd.rbc_tms.MessageTestBase;
import ebd.rbc_tms.payload.Payload_21;
import ebd.rbc_tms.util.*;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Message_21Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_21("tms_123", "rbc_123", new Payload_21(0, new MA(false, 0, 0, 0, new EOA(0, 0, 0, 0, fill(new EOA.Section(0, false, 0, 0), 1), new EOA.EndTimer(0, 0), new EOA.DangerPoint(0, 0), new EOA.Overlap(0, 0, 0,0)), new GradientProfile(0, 0, fill(new GradientProfile.Gradient(0, false, 0), 1)), new SpeedProfile(0, 0, fill(new SpeedProfile.Section(0, 0, false, fill(new SpeedProfile.Section.Category(0, 0, 0, 0), 1)), 1)), new ModeProfile(0, 0, fill(new ModeProfile.Mode(0, 0, 0, 0, 0, false), 1)), new LinkingProfile(0, 0, fill(new LinkingProfile.Link(0, 0, 0, false, 0, 0), 1))))), "Message_21_TestCase_00")
        );
    }

    public static <T> List<T> fill(T elem, int n) {
        List<T> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(elem);
        }
        return list;
    }

}