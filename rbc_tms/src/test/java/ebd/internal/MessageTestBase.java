package ebd.internal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import ebd.internal.util.exception.MissingInformationException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

import static com.google.gson.JsonParser.parseString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class MessageTestBase {

    private static Stream<Arguments> data() {return null;}

    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void testData(String testname, Message<Payload> message, String filename) {

        System.out.println("Test Message " + message.getHeader().type + ": " + testname);
        System.out.println("-------------");

        Gson gson = new Gson();

        // Parse Message
        JsonObject parsedJSON = null;
        String parsedString = null;
        try {
            parsedJSON = parseString(message.parseToJson()).getAsJsonObject();
            parsedString = parsedJSON.toString();
            System.out.println("Parsed JSON: " + parsedString);
        } catch(MissingInformationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            Message<Payload> generatedMessage = Message.generateFrom(parsedString);

            String generatedString = generatedMessage.parseToJson();
            System.out.println("Generated JSON: " + generatedString);

            assertEquals(message, generatedMessage, "Generated Messages do not match.");

            JsonObject generatedJSON = parseString(generatedMessage.parseToJson()).getAsJsonObject();
            assertEquals(parsedJSON, generatedJSON, "Parsed Messages do not match.");

        } catch(ClassNotFoundException e) {
            System.out.println("Class " + message.getClass().getName() + " could not be found.");
            e.printStackTrace();
        } catch(MissingInformationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        // Test Against Testcase
        // ---------------------

        // Read Testcase
        String filepath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("testcases/" + filename + ".json"))
                                 .getPath();
        StringBuilder testcaseSB = new StringBuilder();
        try {
            File    file   = new File(filepath);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                testcaseSB.append(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + ".json could not be read.");
            e.printStackTrace();
        }

        // Format Testcase
        JsonObject testcaseJson = parseString(testcaseSB.toString()).getAsJsonObject();
        String testcaseString = testcaseJson.toString();
        System.out.println("Testcase JSON: " + testcaseString);

        // Prepare Serialized Message
        // Replace Non-Testable Values (UUID, Timestamp)
        assert parsedString != null;
        String modifiedParsedString = parsedString.replaceAll(",\"uuid\":\"((([0-9]|[a-z])*-?)*)\"", "")
                                                  .replaceAll(",\"timestamp\":\\d*}", "}");
        JsonObject modifiedParsedJSON = parseString(modifiedParsedString).getAsJsonObject();
        System.out.println("Modified JSON: " + modifiedParsedString);

        // Test Testcase
        assertEquals(testcaseJson, modifiedParsedJSON, "Parsed Message Does Not Match Testcase " + filename);

    }

}
