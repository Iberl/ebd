package ebd.messageLibrary.message;

import ebd.messageLibrary.serialization.BitStreamReader;
import ebd.messageLibrary.serialization.BitStreamWriter;
import ebd.messageLibrary.serialization.Serializer;
import ebd.messageLibrary.util.exception.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public abstract class RadioLoopMessageTestBase {

    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void testData(String testname, RadioLoopMessage radioLoopMessage, String refData) {
        byte[] bitstream = BitStreamWriter.decode(refData).data();

        try {
            BitStreamWriter writer = Serializer.serialize(radioLoopMessage);

            System.err.println(Arrays.toString(bitstream));
            System.err.println(Arrays.toString(writer.data()));

            assertArrayEquals(bitstream, writer.data());

            BitStreamReader reader = new BitStreamReader(writer.data(), writer.size());

            RadioLoopMessage newRadioLoopMessage = Serializer.deserializeRadioLoopMessage(reader);

            assertEquals(radioLoopMessage, newRadioLoopMessage);

        } catch(FieldTypeNotSupportedException | MissingInformationException | NotSerializableException |
                ClassMalformedException | ValueNotSupportedException | ClassNotSupportedException |
                BitLengthOutOfBoundsException | NotDeserializableException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("errors")
    public void testErrors(String testname, RadioLoopMessage radioLoopMessage, Exception exception) {
        if(exception == null) return;
        assertThrows(exception.getClass(), () -> Serializer.serialize(radioLoopMessage));
    }

}
