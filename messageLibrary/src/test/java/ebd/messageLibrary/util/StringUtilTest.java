package ebd.messageLibrary.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

/**
 * Contains Tests for Class {@link StringUtil}
 *
 * @author Christopher Bernjus
 */
class StringUtilTest {

    /**
     * Fills a given string with repeated string sections
     *
     * @param startString
     *          The initial string
     * @param repeatedString
     *          The repeated string
     * @param count
     *          The number of repetitions
     *
     * @return The filled string
     *
     * @author Christopher Bernjus
     */
    private String fill(String startString, String repeatedString, int count) {
        StringBuilder sb = new StringBuilder(startString);
        for(int i = 0; i < count; i++) {
            sb.append(repeatedString);
        }
        startString = sb.toString();
        return startString;
    }

    /**
     * Fills a given byte array with repeated byte array sections
     *
     * @param startBytes
     *                The initial byte Array
     * @param repeatedBytes
     *                The repeated byte Array
     * @param count
     *                The number of repetitions
     *
     * @return The filled byte array
     *
     * @author Christopher Bernjus
     */
    private byte[] fill(byte[] startBytes, byte[] repeatedBytes, int count) {
        byte[] bytes = new byte[startBytes.length + repeatedBytes.length * count];
        int i = 0;
        if(startBytes.length != 0) BitUtil.copyBits(startBytes, 0, bytes, i, startBytes.length);
        for(i += startBytes.length; i < count * repeatedBytes.length; i += repeatedBytes.length) {
            BitUtil.copyBits(repeatedBytes, 0, bytes, BitUtil.byteOffset(i), BitUtil.byteOffset(repeatedBytes.length));
        }
        return bytes;
    }

    /**
     * Class containing Tests for the Function {@link StringUtil#toISO88591_List(String)} on selected Test Cases
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class toISO88591_ListTests {

        /**
         * Tests the Function {@link StringUtil#toISO88591_List(String)} on Random Data
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("toISO88591_ListTestData")
        public void toISO88591_ListTest(String testname, String s, byte[] expectedBytes) {
            List<Byte> actualByteList = StringUtil.toISO88591_List(s);
            byte[] actualBytes = new byte[actualByteList.size()];

            int i = 0;
            for(Byte b: actualByteList) {
                actualBytes[i] = b;
                i += 1;
            }

            System.out.println(Arrays.toString(expectedBytes));
            System.out.println(Arrays.toString(actualBytes));

            assertArrayEquals(expectedBytes, actualBytes);
        }

        /**
         * Supplies the Testcases for {@link StringUtilTest.toISO88591_ListTests#toISO88591_ListTest(String, String, byte[])}
         *
         * @author Christopher Bernjus
         */
        public Stream<Arguments> toISO88591_ListTestData() {
            return Stream.of(
                    Arguments.of("Empty", "", new byte[]{}),
                    Arguments.of("Lowercase: abc", "abc", new byte[]{97, 98, 99}),
                    Arguments.of("Uppercase: ABC", "ABC", new byte[]{65, 66, 67}),
                    Arguments.of("Numbers: 1234567890", "1234567890", new byte[]{49, 50, 51, 52, 53, 54, 55, 56, 57, 48}),
                    Arguments.of("Spaces: '   '", "   ", new byte[]{32, 32, 32}),
                    Arguments.of("Special: %&(),;.:#!?", "%&(),;.:#!?", new byte[]{37, 38, 40, 41, 44, 59, 46, 58, 35, 33, 63}),
                    Arguments.of("Full: C255= repeated", fill("", "C255=", 51), fill(new byte[]{}, new byte[]{67, 50, 53, 53, 61}, 51))
            );
        }

    }

    /**
     * Class containing Tests for the Function {@link StringUtil#toISO88591_Byte(char)} on selected Test Cases
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class toISO88591_ByteTests {

        /**
         * Tests the Function {@link StringUtil#toISO88591_Byte(char)} on Random Data
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("toISO88591_ByteTestData")
        public void toISO88591_ByteTest(String testname, char c, byte expected) {

            byte actual = StringUtil.toISO88591_Byte(c);

            System.out.println(expected);
            System.out.println(actual);

            assertEquals(expected, actual);
        }

        /**
         * Supplies the Testcases for {@link StringUtilTest.toISO88591_ByteTests#toISO88591_ByteTest(String, char, byte)}
         *
         * @author Christopher Bernjus
         */
        public Stream<Arguments> toISO88591_ByteTestData() {
            return Stream.of(
                    Arguments.of("Lowercase: x", 'x', ((byte) 120)),
                    Arguments.of("Lowercase: y", 'y', ((byte) 121)),
                    Arguments.of("Lowercase: z", 'z', ((byte) 122)),
                    Arguments.of("Uppercase", 'X', ((byte) 88)),
                    Arguments.of("Uppercase", 'Y', ((byte) 89)),
                    Arguments.of("Uppercase", 'Z', ((byte) 90)),
                    Arguments.of("Number: 1", '1', ((byte) 49)),
                    Arguments.of("Number: 1", '2', ((byte) 50)),
                    Arguments.of("Number: 1", '4', ((byte) 52)),
                    Arguments.of("Number: 1", '5', ((byte) 53)),
                    Arguments.of("Number: 1", '7', ((byte) 55)),
                    Arguments.of("Number: 1", '0', ((byte) 48)),
                    Arguments.of("Space", ' ', ((byte) 32)),
                    Arguments.of("Special: %", '%', ((byte) 37)),
                    Arguments.of("Special: &", '&', ((byte) 38)),
                    Arguments.of("Special: (", '(', ((byte) 40)),
                    Arguments.of("Special: }", '}', ((byte) 125)),
                    Arguments.of("Special: ,", ',', ((byte) 44)),
                    Arguments.of("Special: ;", ';', ((byte) 59)),
                    Arguments.of("Special: #", '#', ((byte) 35)),
                    Arguments.of("Special: !", '!', ((byte) 33)),
                    Arguments.of("Special: ?", '?', ((byte) 63))
            );
        }

    }

    /**
     * Class containing Tests for the Function {@link StringUtil#toISO88591_String(List)} on selected Test Cases
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class toISO88591_String {

        /**
         * Tests the Function {@link StringUtil#toISO88591_List(String)} on Random Data
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("toISO88591_ListTestData")
        public void toISO88591_ListTest(String testname, byte[] bytes, String expected) {

            List<Byte> list = new ArrayList<>();
            for(byte b: bytes) list.add(b);

            String actual = StringUtil.toISO88591_String(list);

            System.out.println(expected);
            System.out.println(actual);

            assertEquals(expected, actual);
        }

        /**
         * Supplies the Testcases for {@link StringUtilTest.toISO88591_ListTests#toISO88591_ListTest(String, String, byte[])}
         *
         * @author Christopher Bernjus
         */
        public Stream<Arguments> toISO88591_ListTestData() {
            return Stream.of(
                    Arguments.of("Empty", new byte[]{}, ""),
                    Arguments.of("Lowercase: abc", new byte[]{97, 98, 99}, "abc"),
                    Arguments.of("Uppercase: ABC", new byte[]{65, 66, 67}, "ABC"),
                    Arguments.of("Numbers: 1234567890", new byte[]{49, 50, 51, 52, 53, 54, 55, 56, 57, 48}, "1234567890"),
                    Arguments.of("Spaces: '   '", new byte[]{32, 32, 32}, "   "),
                    Arguments.of("Special: %&(),;.:#!?", new byte[]{37, 38, 40, 41, 44, 59, 46, 58, 35, 33, 63}, "%&(),;.:#!?"),
                    Arguments.of("Full: C255= repeated", fill(new byte[]{}, new byte[]{67, 50, 53, 53, 61}, 51), fill("", "C255=", 51))
            );
        }

    }

    /**
     * Class containing Tests for the Function {@link StringUtil#toISO88591_Char(Byte)} on selected Test Cases
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class toISO88591_Char {

        /**
         * Tests the Function {@link StringUtil#toISO88591_Byte(char)} on Random Data
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("toISO88591_ByteTestData")
        public void toISO88591_ByteTest(String testname, byte b, char expected) {

            char actual = StringUtil.toISO88591_Char(b);

            System.out.println(expected);
            System.out.println(actual);

            assertEquals(expected, actual);
        }

        /**
         * Supplies the Testcases for {@link StringUtilTest.toISO88591_ByteTests#toISO88591_ByteTest(String, char, byte)}
         *
         * @author Christopher Bernjus
         */
        public Stream<Arguments> toISO88591_ByteTestData() {
            return Stream.of(
                    Arguments.of("Lowercase: x", ((byte) 120), 'x'),
                    Arguments.of("Lowercase: y", ((byte) 121), 'y'),
                    Arguments.of("Lowercase: z", ((byte) 122), 'z'),
                    Arguments.of("Uppercase", ((byte) 88), 'X'),
                    Arguments.of("Uppercase", ((byte) 89), 'Y'),
                    Arguments.of("Uppercase", ((byte) 90), 'Z'),
                    Arguments.of("Number: 1", ((byte) 49), '1'),
                    Arguments.of("Number: 1", ((byte) 50), '2'),
                    Arguments.of("Number: 1", ((byte) 52), '4'),
                    Arguments.of("Number: 1", ((byte) 53), '5'),
                    Arguments.of("Number: 1", ((byte) 55), '7'),
                    Arguments.of("Number: 1", ((byte) 48), '0'),
                    Arguments.of("Space", ((byte) 32), ' '),
                    Arguments.of("Special: %", ((byte) 37), '%'),
                    Arguments.of("Special: &", ((byte) 38), '&'),
                    Arguments.of("Special: (", ((byte) 40), '('),
                    Arguments.of("Special: }", ((byte) 125), '}'),
                    Arguments.of("Special: ,", ((byte) 44), ','),
                    Arguments.of("Special: ;", ((byte) 59), ';'),
                    Arguments.of("Special: #", ((byte) 35), '#'),
                    Arguments.of("Special: !", ((byte) 33), '!'),
                    Arguments.of("Special: ?", ((byte) 63), '?')
            );
        }

    }

}