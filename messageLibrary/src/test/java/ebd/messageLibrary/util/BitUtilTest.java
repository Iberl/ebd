package ebd.messageLibrary.util;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.ThrowingConsumer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

import static ebd.messageLibrary.util.BitUtil.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

/**
 * Contains Tests for Class {@link BitUtil}
 *
 * @author Christopher Bernjus
 */
class BitUtilTest {

    // Required Fields and Functions

    final int iterations = 20;
    Random random = new Random();

    /**
     * Generates random positive integers between 0 and 10000
     */
    Iterator<Integer> inputIntGen = new Iterator<Integer>() {

        int current;
        int count;

        @Override
        public boolean hasNext() {
            current = random.nextInt(10000);
            return count < iterations;
        }

        @Override
        public Integer next() {
            count += 1;
            return current;
        }
    };

    /**
     * Class containing Tests for the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} on selected Test Cases
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class copyBitsTests {

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with empty src array
         *
         * @author Christopher Bernjus
         */
        @Test
        void copyBitsTestEmptySrc() {
            byte[] dst = new byte[]{10};
            copyBits(new byte[1], 0, dst, 0, 0);
            byte[] expDst = new byte[]{10};
            assertArrayEquals(expDst, dst);
        }

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with empty dst array
         *
         * @author Christopher Bernjus
         */
        @Test
        void copyBitsTestEmptyDst() {
            // Copy 0 bits
            byte[] src = new byte[]{11};
            byte[] dst = new byte[1];
            copyBits(src, 0, dst, 0, 0);
            byte[] expDst = new byte[1];
            assertArrayEquals(expDst, dst);

            // Copy 14 bits
            src = new byte[]{11, 3};
            dst = new byte[2];
            copyBits(src, 0, dst, 0, 14);
            expDst = new byte[]{11, 0};
            assertArrayEquals(expDst, dst);

            // Copy all bits
            dst = new byte[2];
            copyBits(src, 0, dst, 0, 16);
            expDst = new byte[]{11, 3};
            assertArrayEquals(expDst, dst);
        }

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with empty src and dst arrays
         *
         * @author Christopher Bernjus
         */
        @Test
        void copyBitsTestEmptyBoth() {
            byte[] dst = new byte[1];
            copyBits(new byte[1], 0, dst, 0, 0);
            byte[] expDst = new byte[1];
            assertArrayEquals(expDst, dst);
        }

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with SrcOffset = 0
         *
         * @author Christopher Bernjus
         */
        @Test
        void copyBitsTestSrcOffset0() {
            byte[] src = new byte[]{-1};
            byte[] dst = new byte[]{0};
            copyBits(src, 0, dst, 0, 2);
            byte[] expDst = new byte[]{(byte) 0b11000000};
            assertArrayEquals(expDst, dst);

            copyBits(src, 0, dst, 2, 3);
            expDst = new byte[]{(byte) 0b11111000};
            assertArrayEquals(expDst, dst);
        }

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with Random SrcOffset Values
         *
         * @author Christopher Bernjus
         *//*
        @RepeatedTest(iterations)
        void copyBitsTestSrcOffsetRandom() {}*/

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with SrcOffset = Length
         *
         * @author Christopher Bernjus
         */
        @Test
        void copyBitsTestSrcOffsetLength() {
            byte[] src = new byte[]{-1};
            byte[] dst = new byte[]{0};
            copyBits(src, 7, dst, 0, 0);
            byte[] expDst = new byte[]{0};
            assertArrayEquals(expDst, dst);
        }

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with DstOffset = 0
         *
         * @author Christopher Bernjus
         */
        @Test
        void copyBitsTestDstOffset0() {
            byte[] src = new byte[]{-1};
            byte[] dst = new byte[]{0};
            copyBits(src, 0, dst, 0, 2);
            byte[] expDst = new byte[]{(byte) 0b11000000};
            assertArrayEquals(expDst, dst);

            copyBits(src, 2, dst, 0, 3);
            expDst = new byte[]{(byte) 0b11100000};
            assertArrayEquals(expDst, dst);
        }

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with Random DstOffset Values
         *
         * @author Christopher Bernjus
         *//*
        @RepeatedTest(iterations)
        void copyBitsTestDstOffsetRandom() {}*/

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with DstOffset = Length
         *
         * @author Christopher Bernjus
         */
        @Test
        void copyBitsTestDstOffsetLength() {
            byte[] src = new byte[]{-1};
            byte[] dst = new byte[]{0};
            copyBits(src, 3, dst, 7, 0);
            byte[] expDst = new byte[]{0};
            assertArrayEquals(expDst, dst);
        }

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with Count = 0 on Multiple Cases
         *
         * @author Christopher Bernjus
         */
        @Test
        void copyBitsTestCount0() {
            byte[] src = new byte[]{-1};
            byte[] dst = new byte[]{0};
            copyBits(src, 0, dst, 0, 0);
            byte[] expDst = new byte[]{(byte) 0b00000000};
            assertArrayEquals(expDst, dst);

            copyBits(src, 2, dst, 0, 0);
            expDst = new byte[]{(byte) 0b00000000};
            assertArrayEquals(expDst, dst);

            copyBits(src, 0, dst, 2, 0);
            expDst = new byte[]{(byte) 0b00000000};
            assertArrayEquals(expDst, dst);

            copyBits(src, 2, dst, 5, 0);
            expDst = new byte[]{(byte) 0b00000000};
            assertArrayEquals(expDst, dst);
        }

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with Random Count Values
         *
         * @author Christopher Bernjus
         *//*
        @RepeatedTest(iterations)
        void copyBitsTestCountRandom() {}*/

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} with Count = Length
         *
         * @author Christopher Bernjus
         */
        @Test
        void copyBitsTestCountLength() {
            byte[] src = new byte[]{-1};
            byte[] dst = new byte[]{0};
            copyBits(src, 0, dst, 0, 8);
            byte[] expDst = new byte[]{-1};
            assertArrayEquals(expDst, dst);
        }

        // Exceptions

        /**
         * Tests the Function {@link BitUtil#copyBits(byte[], int, byte[], int, int)} on Exceptions
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("copyBitsTestExceptionsData")
        public void copyBitsTestExceptions(String testname, byte[] src, int srcOffset, byte[] dst, int dstOffset, int count, Exception exception, String message) {
            assertThrows(exception.getClass(), () -> copyBits(src, srcOffset, dst, dstOffset, count), message);
        }

        /**
         * Supplies the Testcases for {@link copyBitsTests#copyBitsTestExceptions(String, byte[], int, byte[], int, int, Exception, String)}
         *
         * @author Christopher Bernjus
         */
        public Stream<Arguments> copyBitsTestExceptionsData() {
            byte[] arr = new byte[]{0};
            return Stream.of(
                    Arguments.of("Invalid Count: -1", arr, 0, arr, 0, -1, new IllegalArgumentException(), "Count must be positive."),
                    Arguments.of("Invalid Count: -255", arr, 0, arr, 0, -255, new IllegalArgumentException(), "Count must be positive."),
                    Arguments.of("Invalid Count: MIN_VALUE", arr, 0, arr, 0, Integer.MIN_VALUE, new IllegalArgumentException(), "Count must be positive."),
                    Arguments.of("Invalid Src Array: Null", null, 0, arr, 0, 0, new IllegalArgumentException(), "Source and destination arrays can not be null or empty."),
                    Arguments.of("Invalid Src Array: Empty", new byte[0], 0, arr, 0, 0, new IllegalArgumentException(), "Source and destination arrays can not be null or empty."),
                    Arguments.of("Invalid Dst Array: Null", arr, 0, null, 0, 0, new IllegalArgumentException(), "Source and destination arrays can not be null or empty."),
                    Arguments.of("Invalid Dst Array: Empty", arr, 0, new byte[0], 0, 0, new IllegalArgumentException(), "Source and destination arrays can not be null or empty."),
                    Arguments.of("Invalid Src And Dst Arrays: Null", null, 0, null, 0, 0, new IllegalArgumentException(), "Source and destination arrays can not be null or empty."),
                    Arguments.of("Invalid SrcOffset: Negative", arr, -1, arr, 0, 0, new IndexOutOfBoundsException(), "Invalid source array offset."),
                    Arguments.of("Invalid SrcOffset: Out Of Bounds", arr, 9, arr, 0, 0, new IndexOutOfBoundsException(),"Invalid source array offset."),
                    Arguments.of("Invalid SrcOffset: Count - Out Of Bounds", arr, 5, arr, 0, 8, new IndexOutOfBoundsException(),"Invalid source array offset."),
                    Arguments.of("Invalid DstOffset: Negative", arr, 0, arr, -1, 0, new IndexOutOfBoundsException(),"Invalid destination array offset."),
                    Arguments.of("Invalid DstOffset: Out Of Bounds", arr, 0, arr, 12, 0, new IndexOutOfBoundsException(),"Invalid destination array offset."),
                    Arguments.of("Invalid DstOffset: Count - Out Of Bounds", arr, 0, arr, 6, 5, new IndexOutOfBoundsException(),"Invalid destination array offset.")
             );
        }

    }

    /**
     * Class containing Tests for the Function {@link BitUtil#byteOffset(int)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    class byteOffsetTests {

        /**
         * Tests the Function {@link BitUtil#byteOffset(int)} on Random Data
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> byteOffsetTest() {
            // Generates display names like: Byte Offset: 168
            Function<Integer, String> displayNameGen = (input) -> "Byte Offset: " + input;

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> assertEquals(input * 8, byteOffset(input));

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }

    }

    /**
     * Class containing Tests for the Function {@link BitUtil#byteIndex(int)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    class byteIndexTests {

        /**
         * Tests the Function {@link BitUtil#byteIndex(int)} on Random Data
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> byteIndexTest() {
            // Generates display names like: Byte Index: 168
            Function<Integer, String> displayNameGen = (input) -> "Byte Index: " + input;

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> assertEquals(input / 8, byteIndex(input));

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }

    }

    /**
     * Class containing Tests for the Function {@link BitUtil#bitIndex(int)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class bitIndexTests {

        /**
         * Tests the Function {@link BitUtil#bitIndex(int)} on selected Test Cases
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("bitIndexData")
        void bitIndexTest(String testname, int input, int output) {
            assertEquals(output, bitIndex(input));
        }

        /**
         * Provides the Test Cases for the Function {@link BitUtil#bitIndex(int)}
         */
        Stream<Arguments> bitIndexData() {
            return Stream.of(
                    Arguments.of("Bit Index: 0", 0, 0),
                    Arguments.of("Bit Index: 1", 1, 1),
                    Arguments.of("Bit Index: 2", 2, 2),
                    Arguments.of("Bit Index: 3", 3, 3),
                    Arguments.of("Bit Index: 4", 4, 4),
                    Arguments.of("Bit Index: 5", 5, 5),
                    Arguments.of("Bit Index: 6", 6, 6),
                    Arguments.of("Bit Index: 7", 7, 7),
                    Arguments.of("Bit Index: 8", 8, 0),
                    Arguments.of("Bit Index: 9", 9, 1),
                    Arguments.of("Bit Index: 10", 10, 2),
                    Arguments.of("Bit Index: 11", 11, 3),
                    Arguments.of("Bit Index: 12", 12, 4),
                    Arguments.of("Bit Index: 13", 13, 5),
                    Arguments.of("Bit Index: 14", 14, 6),
                    Arguments.of("Bit Index: 15", 15, 7),
                    Arguments.of("Bit Index: 6144", 6144, 0),
                    Arguments.of("Bit Index: 7473", 7473, 1),
                    Arguments.of("Bit Index: 5426", 5426, 2),
                    Arguments.of("Bit Index: 1995", 1995, 3),
                    Arguments.of("Bit Index: 3028", 3028, 4),
                    Arguments.of("Bit Index: 437", 437, 5),
                    Arguments.of("Bit Index: 5710", 5710, 6),
                    Arguments.of("Bit Index: 5031", 5031, 7)
            );
        }

    }

    /**
     * Class containing Tests for the Function {@link BitUtil#bitMask(int)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class bitMaskTests {

        /**
         * Tests the Function {@link BitUtil#bitMask(int)} on selected Test Cases
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("bitMaskData")
        void bitMaskTest(String testname, int input, int output) {
            assertEquals(output, bitMask(input));
        }

        /**
         * Provides the Test Cases for the Function {@link BitUtil#bitMask(int)}
         */
        Stream<Arguments> bitMaskData() {
            return Stream.of(
                    Arguments.of("Bit Mask: 0", 0, 0b10000000),
                    Arguments.of("Bit Mask: 1", 1, 0b01000000),
                    Arguments.of("Bit Mask: 2", 2, 0b00100000),
                    Arguments.of("Bit Mask: 3", 3, 0b00010000),
                    Arguments.of("Bit Mask: 4", 4, 0b00001000),
                    Arguments.of("Bit Mask: 5", 5, 0b00000100),
                    Arguments.of("Bit Mask: 6", 6, 0b00000010),
                    Arguments.of("Bit Mask: 7", 7, 0b00000001),
                    Arguments.of("Bit Mask: 8", 8, 0b10000000),
                    Arguments.of("Bit Mask: 9", 9, 0b01000000),
                    Arguments.of("Bit Mask: 10", 10, 0b00100000),
                    Arguments.of("Bit Mask: 11", 11, 0b00010000),
                    Arguments.of("Bit Mask: 12", 12, 0b00001000),
                    Arguments.of("Bit Mask: 13", 13, 0b00000100),
                    Arguments.of("Bit Mask: 14", 14, 0b00000010),
                    Arguments.of("Bit Mask: 15", 15, 0b00000001),
                    Arguments.of("Bit Mask: 7584", 7584, 0b10000000),
                    Arguments.of("Bit Mask: 2785", 2785, 0b01000000),
                    Arguments.of("Bit Mask: 6770", 6770, 0b00100000),
                    Arguments.of("Bit Mask: 5019", 5019, 0b00010000),
                    Arguments.of("Bit Mask: 1340", 1340, 0b00001000),
                    Arguments.of("Bit Mask: 3741", 3741, 0b00000100),
                    Arguments.of("Bit Mask: 5022", 5022, 0b00000010),
                    Arguments.of("Bit Mask: 4639", 4639, 0b00000001)
            );
        }

    }

    /**
     * Class containing Tests for the Function {@link BitUtil#byteCount(int)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class byteCountTests {

        /**
         * Tests the Function {@link BitUtil#byteCount(int)} on selected Test Cases
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("byteCountData")
        void byteCountTest(String testname, int input, int output) {
            assertEquals(output, byteCount(input));
        }

        /**
         * Provides the Test Cases for the Function {@link BitUtil#byteCount(int)}
         */
        Stream<Arguments> byteCountData() {
            return Stream.of(
                    Arguments.of("Byte Count: 0", 0, 0),
                    Arguments.of("Byte Count: 1", 1, 1),
                    Arguments.of("Byte Count: 2", 2, 1),
                    Arguments.of("Byte Count: 3", 3, 1),
                    Arguments.of("Byte Count: 4", 4, 1),
                    Arguments.of("Byte Count: 5", 5, 1),
                    Arguments.of("Byte Count: 6", 6, 1),
                    Arguments.of("Byte Count: 7", 7, 1),
                    Arguments.of("Byte Count: 8", 8, 1),
                    Arguments.of("Byte Count: 9", 9, 2),
                    Arguments.of("Byte Count: 10", 10, 2),
                    Arguments.of("Byte Count: 11", 11, 2),
                    Arguments.of("Byte Count: 12", 12, 2),
                    Arguments.of("Byte Count: 13", 13, 2),
                    Arguments.of("Byte Count: 14", 14, 2),
                    Arguments.of("Byte Count: 15", 15, 2),
                    Arguments.of("Byte Count: 16", 16, 2),
                    Arguments.of("Byte Count: 17", 17, 3),
                    Arguments.of("Byte Count: 7576", 7576, 947),
                    Arguments.of("Byte Count: 6569", 6569, 822),
                    Arguments.of("Byte Count: 3746", 3746, 469),
                    Arguments.of("Byte Count: 3027", 3027, 379),
                    Arguments.of("Byte Count: 1780", 1780, 223),
                    Arguments.of("Byte Count: 3061", 3061, 383),
                    Arguments.of("Byte Count: 1598", 1598, 200),
                    Arguments.of("Byte Count: 6103", 6103, 763)
            );
        }

    }

    /**
     * Class containing Tests for the Function {@link BitUtil#trailBits(int)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class trailBitsTests {

        /**
         * Tests the Function {@link BitUtil#trailBits(int)} on selected Test Cases
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("trailBitsData")
        void trailBitsTest(String testname, int input, int output) {
            assertEquals(output, trailBits(input));
        }

        /**
         * Provides the Test Cases for the Function {@link BitUtil#trailBits(int)}
         */
        Stream<Arguments> trailBitsData() {
            return Stream.of(
                    Arguments.of("Trail Bits: 0", 0, 0),
                    Arguments.of("Trail Bits: 1", 1, 7),
                    Arguments.of("Trail Bits: 2", 2, 6),
                    Arguments.of("Trail Bits: 3", 3, 5),
                    Arguments.of("Trail Bits: 4", 4, 4),
                    Arguments.of("Trail Bits: 5", 5, 3),
                    Arguments.of("Trail Bits: 6", 6, 2),
                    Arguments.of("Trail Bits: 7", 7, 1),
                    Arguments.of("Trail Bits: 8", 8, 0),
                    Arguments.of("Trail Bits: 9", 9, 7),
                    Arguments.of("Trail Bits: 10", 10, 6),
                    Arguments.of("Trail Bits: 11", 11, 5),
                    Arguments.of("Trail Bits: 12", 12, 4),
                    Arguments.of("Trail Bits: 13", 13, 3),
                    Arguments.of("Trail Bits: 14", 14, 2),
                    Arguments.of("Trail Bits: 15", 15, 1),
                    Arguments.of("Trail Bits: 16", 16, 0),
                    Arguments.of("Trail Bits: 17", 17, 7),
                    Arguments.of("Trail Bits: 5273", 5273, 7),
                    Arguments.of("Trail Bits: 6569", 1970, 6),
                    Arguments.of("Trail Bits: 3746", 6115, 5),
                    Arguments.of("Trail Bits: 3027", 300, 4),
                    Arguments.of("Trail Bits: 1780", 3013, 3),
                    Arguments.of("Trail Bits: 3061", 1798, 2),
                    Arguments.of("Trail Bits: 1598", 783, 1),
                    Arguments.of("Trail Bits: 6103", 3864, 0)
            );
        }

    }

    /**
     * Class containing Tests for the Function {@link BitUtil#min(int...)} on selected Test Cases
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class minTests {

        /**
         * Tests the Function {@link BitUtil#min(int...)} on no input
         *
         * @author Christopher Bernjus
         */
        @Test
        void minTest0P() { assertThrows(IndexOutOfBoundsException.class, BitUtil::min); }

        /**
         * Tests the Function {@link BitUtil#min(int...)} on min single input
         *
         * @author Christopher Bernjus
         */
        @Test
        void minTest1PMin() { assertEquals(Integer.MIN_VALUE, min(Integer.MIN_VALUE)); }

        /**
         * Tests the Function {@link BitUtil#min(int...)} on 0
         *
         * @author Christopher Bernjus
         */
        @Test
        void minTest1P0() { assertEquals(0, min(0)); }

        /**
         * Tests the Function {@link BitUtil#min(int...)} on random single input
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void minTest1PRandom() {
            int num = random.nextInt();
            assertEquals(num, min(num));
        }

        /**
         * Tests the Function {@link BitUtil#min(int...)} on max single input
         *
         * @author Christopher Bernjus
         */
        @Test
        void minTest1PMax() { assertEquals(Integer.MAX_VALUE, min(Integer.MAX_VALUE)); }

        /**
         * Tests the Function {@link BitUtil#min(int...)} on random data with the min at 1st place
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void minTest2PRandomFirst() {
            int num1 = random.nextInt();
            int num2 = random.nextInt(Math.abs(num1));
            if(num1 < 0) assertEquals(num1, min(num1, num2));
            else assertEquals(num2, min(num2, num1));
        }

        /**
         * Tests the Function {@link BitUtil#min(int...)} on random data with the min at 2nd place
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void minTest2PRandomSecond() {
            int num1 = random.nextInt();
            int num2 = random.nextInt(Math.abs(num1));
            if(num1 < 0) assertEquals(num1, min(num1, num2));
            else assertEquals(num2, min(num2, num1));
        }

        /**
         * Tests the Function {@link BitUtil#min(int...)} on random data with 2 same values
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void minTest2PRandomEqual() {
            int num = random.nextInt();
            assertEquals(num, min(num, num));
        }

        /**
         * Tests the Function {@link BitUtil#min(int...)} on random data with the min at 1st place
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void minTest3PRandomFirst() {
            int num1 = random.nextInt();
            int num2 = random.nextInt(Math.abs(num1));
            int num3 = random.nextInt(Math.abs(num2));
            if(num1 < 0) assertEquals(num1, min(num1, num2, num3));
            else assertEquals(num3, min(num3, num1, num2));
        }

        /**
         * Tests the Function {@link BitUtil#min(int...)} on random data with the min at 2nd place
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void minTest3PRandomSecond() {
            int num1 = random.nextInt();
            int num2 = random.nextInt(Math.abs(num1));
            int num3 = random.nextInt(Math.abs(num2));
            if(num1 < 0) assertEquals(num1, min(num2, num1, num3));
            else assertEquals(num3, min(num1, num3, num2));
        }

        /**
         * Tests the Function {@link BitUtil#min(int...)} on random data with the min at 3rd place
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void minTest3PRandomThird() {
            int num1 = random.nextInt();
            int num2 = random.nextInt(Math.abs(num1));
            int num3 = random.nextInt(Math.abs(num2));
            if(num1 < 0) assertEquals(num1, min(num3, num2, num1));
            else assertEquals(num3, min(num2, num1, num3));
        }

        /**
         * Tests the Function {@link BitUtil#min(int...)} on random data with 3 same values
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void minTest3PRandomEqual() {
            int num = random.nextInt();
            assertEquals(num, min(num, num, num));
        }
    }

    /**
     * Class containing Tests for the Function {@link BitUtil#max(int...)} on selected Test Cases
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class maxTests {

        /**
         * Tests the Function {@link BitUtil#max(int...)} on no input
         *
         * @author Christopher Bernjus
         */
        @Test
        void maxTest0P() { assertThrows(IndexOutOfBoundsException.class, BitUtil::max); }

        /**
         * Tests the Function {@link BitUtil#max(int...)} on max single input
         *
         * @author Christopher Bernjus
         */
        @Test
        void maxTest1PMIN() { assertEquals(Integer.MIN_VALUE, max(Integer.MIN_VALUE)); }

        /**
         * Tests the Function {@link BitUtil#max(int...)} on 0
         *
         * @author Christopher Bernjus
         */
        @Test
        void maxTest1P0() { assertEquals(0, max(0)); }

        /**
         * Tests the Function {@link BitUtil#max(int...)} on random single input
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void maxTest1PRandom() {
            int num = random.nextInt();
            assertEquals(num, max(num));
        }

        /**
         * Tests the Function {@link BitUtil#max(int...)} on max single input
         *
         * @author Christopher Bernjus
         */
        @Test
        void maxTest1PMax() { assertEquals(Integer.MAX_VALUE, max(Integer.MAX_VALUE)); }

        /**
         * Tests the Function {@link BitUtil#max(int...)} on random data with the max at 1st place
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void maxTest2PRandomFirst() {
            int num1 = random.nextInt();
            int num2 = random.nextInt(Math.abs(num1));
            if(num1 >= 0) assertEquals(num1, max(num1, num2));
            else assertEquals(num2, max(num2, num1));
        }

        /**
         * Tests the Function {@link BitUtil#max(int...)} on random data with the max at 2nd place
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void maxTest2PRandomSecond() {
            int num1 = random.nextInt();
            int num2 = random.nextInt(Math.abs(num1));
            if(num1 >= 0) assertEquals(num1, max(num1, num2));
            else assertEquals(num2, max(num2, num1));
        }

        /**
         * Tests the Function {@link BitUtil#max(int...)} on random data with 2 same values
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void maxTest2PRandomEqual() {
            int num = random.nextInt();
            assertEquals(num, max(num, num));
        }

        /**
         * Tests the Function {@link BitUtil#max(int...)} on random data with the max at 1st place
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void maxTest3PRandomFirst() {
            int num1 = random.nextInt();
            int num2 = random.nextInt(Math.abs(num1));
            int num3 = random.nextInt(Math.abs(num2));
            if(num1 >= 0) assertEquals(num1, max(num1, num2, num3));
            else assertEquals(num2, max(num2, num1, num3));
        }

        /**
         * Tests the Function {@link BitUtil#max(int...)} on random data with the max at 2nd place
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void maxTest3PRandomSecond() {
            int num1 = random.nextInt();
            int num2 = random.nextInt(Math.abs(num1));
            int num3 = random.nextInt(Math.abs(num2));
            if(num1 >= 0) assertEquals(num1, max(num2, num1, num3));
            else assertEquals(num2, max(num1, num2, num3));
        }

        /**
         * Tests the Function {@link BitUtil#max(int...)} on random data with the max at 3rd place
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void maxTest3PRandomThird() {
            int num1 = random.nextInt();
            int num2 = random.nextInt(Math.abs(num1));
            int num3 = random.nextInt(Math.abs(num2));
            if(num1 >= 0) assertEquals(num1, max(num3, num2, num1));
            else assertEquals(num2, max(num3, num1, num2));
        }

        /**
         * Tests the Function {@link BitUtil#max(int...)} on random data with 3 same values
         *
         * @author Christopher Bernjus
         */
        @RepeatedTest(iterations)
        void maxTest3PRandomEqual() {
            int num = random.nextInt();
            assertEquals(num, max(num, num, num));
        }
    }

    /**
     * Class containing Tests for the Function {@link BitUtil#format(byte[])}
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class formatTests {

        /**
         * Tests the Function {@link BitUtil#format(byte[])} on selected Test Cases
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("formatData")
        void formatTest(String testname, byte[] input, String output) {
            assertEquals(output, format(input));
        }

        /**
         * Provides the Test Cases for the Function {@link BitUtil#format(byte[])}
         *
         * @return
         */
        Stream<Arguments> formatData() {
            return Stream.of(
                    Arguments.of("Array Empty", new byte[]{}, ""),
                    Arguments.of("Array Only 0s", new byte[]{0}, "00000000"),
                    Arguments.of("Array Only 1s", new byte[]{-1}, "11111111"),
                    Arguments.of("Array Length 1", new byte[]{32}, "00100000"),
                    Arguments.of("Array Length 2", new byte[]{64, 12}, "01000000 00001100"),
                    Arguments.of("Array Length 3", new byte[]{4, 75, 114}, "00000100 01001011 01110010"),
                    Arguments.of("Array Length 16", new byte[]{40, 34, 27, 125}, "00101000 00100010 00011011 01111101")
            );
        }
    }
}