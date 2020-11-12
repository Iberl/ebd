package ebd.rbc_tms.message;

import ebd.rbc_tms.MessageTestBase;
import ebd.rbc_tms.payload.Payload_22;
import ebd.rbc_tms.util.EOA;
import ebd.rbc_tms.util.LinkingProfile;
import ebd.rbc_tms.util.ModeProfile;
import ebd.rbc_tms.util.ShortenMA;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Message_22Test extends MessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_22("tms_123", "rbc_123", new Payload_22(0, new ShortenMA(false, 0, 0, 0, new EOA(0, 0, 0, 0, fill(new EOA.Section(0, false, 0, 0), 1), new EOA.EndTimer(0, 0), new EOA.DangerPoint(0, 0), new EOA.Overlap(0, 0, 0, 0)), new ModeProfile(0, 0, fill(new ModeProfile.Mode(0, 0, 0, 0, 0, false), 1)), new LinkingProfile(0, 0, fill(new LinkingProfile.Link(0, 0, 0, false, 0, 0), 1))))), "Message_22_TestCase_00")
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