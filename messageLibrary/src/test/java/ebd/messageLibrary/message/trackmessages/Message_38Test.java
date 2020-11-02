package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessageTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class Message_38Test extends TrackMessageTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Message_38(), "[38:8][10:10][4294967295:32]0[16777215:24]"),
                // T_TRAIN is always set to unknown -> no test needed
                Arguments.of("M_ACK: False", new Message_38(false), "[38:8][10:10][4294967295:32]0[16777215:24]"),
                Arguments.of("M_ACK: True", new Message_38(true), "[38:8][10:10][4294967295:32]1[16777215:24]"),
                // NID_LRBG is always set to unknown -> no test needed

                Arguments.of("all", new Message_38(true), "[38:8][10:10][4294967295:32]1[16777215:24]")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("No Tests needed for Message 38", new Message_38(), null)
                // T_TRAIN is always set to unknown -> no error test needed
                // M_ACK is a boolean -> no overflow test needed
                // NID_LRBG is always set to unknown -> no error test needed
        );
    }

}