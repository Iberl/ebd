package ebd.messageLibrary.serialization;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

import static ebd.messageLibrary.util.BitUtil.byteCount;
import static ebd.messageLibrary.util.BitUtil.copyBits;
import static org.junit.jupiter.api.Assertions.*;

class BitStreamReaderTest {

    // Required Fields and Functions

    int iterations = 1000;
    int upperbound = 10000;
    Random random = new Random();

    /** Generates random positive integers with upper bound as max value */
    Iterator<Integer> inputIntGen = new Iterator<Integer>() {

        int current;
        int count;

        @Override
        public boolean hasNext() {
            current = random.nextInt(upperbound);
            if(current == 0) current++;
            return count < iterations;
        }

        @Override
        public Integer next() {
            count += 1;
            return current;
        }
    };

    /** Generates random positive long */
    Iterator<Long> inputLongGen = new Iterator<Long>() {

        long current;
        int count;

        @Override
        public boolean hasNext() {
            current = Math.abs(random.nextLong());
            if(current == 0) current++;
            return count < iterations;
        }

        @Override
        public Long next() {
            count += 1;
            return current;
        }
    };


    // Tests

    /**
     * Class containing Tests for the Function {@link BitStreamReader#seek(int)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    class seekTests {

        /**
         * Tests the Function {@link BitStreamReader#seek(int)} on correct Inputs
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        public Stream<DynamicTest> seekTest() {
            // Generates display names like: Seek Position: 168
            Function<Integer, String> displayNameGen = (input) -> "Seek Position " + input;

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> {
                BitStreamReader reader;
                if(input == 0) reader = new BitStreamReader(new byte[]{0}, input);
                else reader = new BitStreamReader(new byte[byteCount(input)], input);
                reader.seek(0);
                assertEquals(0, reader.position());
                reader.seek(input);
                assertEquals(input, reader.position());
                reader.seek(input >> 1);
                assertEquals(input >> 1, reader.position());
            };

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }

        /**
         * Tests the Function {@link BitStreamReader#seek(int)} on negative Inputs
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> seekErrorNegative() {
            // Generates display names like: Negative Position: -822
            Function<Integer, String> displayNameGen = (input) -> "Negative Position " + -input;

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> {
                BitStreamReader reader = new BitStreamReader(new byte[byteCount(input)], input);
                assertThrows(IndexOutOfBoundsException.class, () -> reader.seek(-input));
            };

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }

        /**
         * Tests the Function {@link BitStreamReader#seek(int)} on Inputs
         * larger than the size of the {@link BitStreamReader}
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> seekErrorTooLarge() {
            // Generates display names like: Large Position: 822
            Function<Integer, String> displayNameGen = (input) -> "Large Position " + -input;

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> {
                BitStreamReader reader = new BitStreamReader(new byte[byteCount(input)], input);
                assertThrows(IndexOutOfBoundsException.class, () -> reader.seek(input + 1));
            };

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }
    }

    /**
     * Class containing Tests for the Function {@link BitStreamReader#readBits(int)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    class writeBitsTests {

        /**
         * Logic for testing the Function {@link BitStreamWriter#writeBits(byte[], int)}
         *
         * @param input
         * 			number of bits to write in BitStreamWriter
         * @param writer
         * 			(CanBeNull) BitStreamWriter to test on
         *
         * @return Modified or new BitStreamWriter
         *
         * @author Christopher Bernjus
         */
        BitStreamWriter readBitsTest(int input, BitStreamWriter writer) {
            // Prepare BitStreamWriter
            if(writer == null) writer = new BitStreamWriter();
            byte[] data = writer.data();
            int size = writer.size();

            // Write Bits on BitStreamWriter
            int capacity = byteCount(input);
            byte[] bits = new byte[capacity];
            random.nextBytes(bits);
            bits[bits.length - 1] &= -1 << ((8 - (input & 7)) & 7);
            writer.writeBits(bits, input);

            // Prepare BitStreamReader
            BitStreamReader reader = new BitStreamReader(writer.data(), writer.size());

            // Combine input data and written bits into the expected byte array
            byte[] expected = new byte[byteCount(size + input)];
            System.arraycopy(data, 0, expected, 0, data.length);
            copyBits(bits, 0, expected, size, input);

            // Check on bits
            assertArrayEquals(expected, reader.readBits(size + input));
            return writer;
        }

        // Tests for minimal input -> writeBitTest()

        /**
         * Tests the Function {@link BitStreamReader#readBits(int)} on Random Data from Index 0
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> readBitsTestRandomData() {
            // Generates display names like: Read 243 Bits beginning at index: 0
            Function<Integer, String> displayNameGen = (input) -> "Read " + input + " bits beginning at index 0";

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> readBitsTest(input, null);

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }

        /**
         * Tests the Function {@link BitStreamReader#readBits(int)} on Random Data from Index 0
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> readBitsTestRandomIndex() {
            // Generates display names like: Read 243 Bits beginning at index: 0
            Function<Integer, String> displayNameGen = (input) -> "Read " + input + " bits beginning at index " + input;

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> {
                BitStreamWriter writer = readBitsTest(input, null);
                readBitsTest(input, writer);
            };

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }

        /**
         * Tests the Function {@link BitStreamReader#readBits(int)} with large Input
         *
         * @author Christopher Bernjus
         *//*
		@Test
		void readBitsTestMax() {
			readBitsTest(Integer.MAX_VALUE >> 1, null);
		}*/
    }

    /**
     * Tests the Function {@link BitStreamReader#readBit()}
     *
     * @author Christopher Bernjus
     */
    @Test
    void readBitTest() {
        BitStreamReader reader = new BitStreamReader(new byte[]{(byte) 0b01100000}, 4);
        assertEquals(false, reader.readBit());
        assertEquals(true, reader.readBit());
        assertEquals(true, reader.readBit());
        assertEquals(false, reader.readBit());
    }

    /**
     * Class containing Tests for the Function {@link BitStreamReader#readInt(int, boolean)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    class readIntTests {

        /**
         * Logic for testing the Function {@link BitStreamReader#readInt(int, boolean)}
         *
         * @param input
         * 			number to read from BitStreamReader
         * @param signed
         *          indicates the given number is signed
         *
         * @author Christopher Bernjus
         */
        void readIntTest(int input, boolean signed) {
            BitStreamWriter writer = new BitStreamWriter();
            int len = Integer.toBinaryString(input).length();
            int count = len + ((signed && input > 0) ? 32 - len : 0);
            writer.writeInt(input, count);

            BitStreamReader reader = new BitStreamReader(writer.data(), writer.size());
            assertEquals(input, reader.readInt(count, signed));
        }

        /**
         * Tests the Function {@link BitStreamReader#readInt(int, boolean)} with minimal value
         *
         * @author Christopher Bernjus
         */
        @Test
        void readIntTestMin() {
            readIntTest(Integer.MIN_VALUE, true);
        }

        /**
         * Tests the Function {@link BitStreamReader#readInt(int, boolean)} with 0
         *
         * @author Christopher Bernjus
         */
        @Test
        void readIntTest0() {
            readIntTest(0, true);
        }

        /**
         * Tests the Function {@link BitStreamReader#readInt(int, boolean)} with maximal value
         *
         * @author Christopher Bernjus
         */
        @Test
        void readIntTestMax() {
            readIntTest(Integer.MAX_VALUE, true);
        }

        /**
         * Tests the Function {@link BitStreamReader#readInt(int, boolean)} with Random Data
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> readIntTestRandom() {
            // Generates display names like: Read Int: 837
            Function<Integer, String> displayNameGen = (input) -> "Read Int: " + input;

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> readIntTest(input, false);

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }

        /**
         * Tests the Function {@link BitStreamReader#readInt(int, boolean)} with Random Negative Data
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> readIntTestRandomNegative() {
            // Generates display names like: Read Int: 837
            Function<Integer, String> displayNameGen = (input) -> "Read Int: " + -input;

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> readIntTest(-input, true);

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }

        /**
         * Logic for testing the Function {@link BitStreamReader#readInt(int, boolean)} with invalid length values
         *
         * @author Christopher Bernjus
         */
        @Test
        void readIntTestInvalidLength() {
            BitStreamReader reader = new BitStreamReader(new byte[] {0, 0}, 16);
            assertThrows(IllegalArgumentException.class, () -> {reader.readInt(-1, true);});
            assertThrows(IllegalArgumentException.class, () -> {reader.readInt(-10, false);});
            assertThrows(IllegalArgumentException.class, () -> {reader.readInt(33, true);});
            assertThrows(IllegalArgumentException.class, () -> {reader.readInt(54, false);});
        }

    }

    /**
     * Class containing Tests for the Function {@link BitStreamReader#readLong(int, boolean)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    class readLongTests {

        /**
         * Logic for testing the Function {@link BitStreamReader#readLong(int, boolean)}
         *
         * @param input
         * 			number to read from BitStreamReader
         * @param signed
         *          indicates the given number is signed
         *
         * @author Christopher Bernjus
         */
        void readLongTest(long input, boolean signed) {
            BitStreamWriter writer = new BitStreamWriter();
            int len = Long.toBinaryString(input).length();
            int count = len + ((signed && input > 0) ? 64 - len : 0);
            writer.writeLong(input, count);

            BitStreamReader reader = new BitStreamReader(writer.data(), writer.size());
            assertEquals(input, reader.readLong(count, signed));
        }

        /**
         * Tests the Function {@link BitStreamReader#readLong(int, boolean)} with minimal value
         *
         * @author Christopher Bernjus
         */
        @Test
        void readLongTestMin() {
            readLongTest(Long.MIN_VALUE, true);
        }

        /**
         * Tests the Function {@link BitStreamReader#readLong(int, boolean)} with 0
         *
         * @author Christopher Bernjus
         */
        @Test
        void readLongTest0() {
            readLongTest(0, true);
        }

        /**
         * Tests the Function {@link BitStreamReader#readLong(int, boolean)} with maximal value
         *
         * @author Christopher Bernjus
         */
        @Test
        void readLongTestMax() {
            readLongTest(Long.MAX_VALUE, true);
        }

        /**
         * Tests the Function {@link BitStreamReader#readLong(int, boolean)} with Random Data
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> readLongTestRandom() {
            // Generates display names like: Read Long: 837
            Function<Long, String> displayNameGen = (input) -> "Read Long: " + input;

            // Executes tests based on the current input value
            ThrowingConsumer<Long> testExecutor = (input) -> readLongTest(input, true);

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputLongGen, displayNameGen, testExecutor);
        }

        /**
         * Tests the Function {@link BitStreamReader#readLong(int, boolean)} with Random Data
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> readLongTestRandomNegative() {
            // Generates display names like: Read Long: 837
            Function<Long, String> displayNameGen = (input) -> "Read Long: " + -input;

            // Executes tests based on the current input value
            ThrowingConsumer<Long> testExecutor = (input) -> readLongTest(-input, true);

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputLongGen, displayNameGen, testExecutor);
        }

        /**
         * Logic for testing the Function {@link BitStreamReader#readLong(int, boolean)} with invalid length values
         *
         * @author Christopher Bernjus
         */
        @Test
        void readLongTestInvalidLength() {
            BitStreamReader reader = new BitStreamReader(new byte[] {0, 0}, 16);
            assertThrows(IllegalArgumentException.class, () -> {reader.readInt(-1, true);});
            assertThrows(IllegalArgumentException.class, () -> {reader.readInt(-135, false);});
            assertThrows(IllegalArgumentException.class, () -> {reader.readInt(65, true);});
            assertThrows(IllegalArgumentException.class, () -> {reader.readInt(97, false);});
        }

    }

    /**
     * Class containing Tests for the Function {@link BitStreamReader#position()}
     *
     * @author Christopher Bernjus
     */
    @Nested
    class positionTests {

        /**
         * Logic for testing the Function {@link BitStreamReader#position()} after reading
         *
         * @param count
         * 			number of bits to read from BitStreamReader
         * @param position
         * 			estimated position of the read head in BitStreamWriter after reading
         *
         * @author Christopher Bernjus
         */
        void positionTest(int count, int position) {
            BitStreamWriter writer = new BitStreamWriter();
            byte[] bits = new byte[Math.max(byteCount(count), 1)];
            writer.writeBits(bits, count);

            BitStreamReader reader = new BitStreamReader(writer.data(), writer.size());
            reader.readBits(count);
            assertEquals(position, reader.position());
        }

        /**
         * Logic for testing the Function {@link BitStreamWriter#position()} after seeking
         *
         * @param count
         * 			number of bits to write in BitStreamWriter
         * @param position
         * 			position after seeking through BitStreamWriter
         *
         * @author Christopher Bernjus
         */
        void positionSeekTest(int count, int position) {
            assert(position <= count);
            BitStreamWriter writer = new BitStreamWriter();
            byte[] bits = new byte[Math.max(byteCount(count), 1)];
            writer.writeBits(bits, count);

            BitStreamReader reader = new BitStreamReader(writer.data(), writer.size());
            reader.readBits(count);
            reader.seek(position);
            assertEquals(position, reader.position());
        }

        /**
         * Tests the Function {@link BitStreamReader#position()} with 0
         *
         * @author Christopher Bernjus
         */
        @Test
        void positionTest0() {
            positionTest(0, 0);
        }

        /**
         * Tests the Function {@link BitStreamReader#position()} on Random Data
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> positionTestRandom() {
            // Generates display names like: Check Position 634 After Reading
            Function<Integer, String> displayNameGen = (input) -> "Check Position " + input + " After Reading";

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> positionTest(input, input);

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }

        /**
         * Tests the Function {@link BitStreamReader#position()} after seeking on Random Data
         *
         * @author Christopher Bernjus
         */
        @TestFactory
        Stream<DynamicTest> positionSeekTestRandom() {
            // Generates display names like: Check Position 723 After Seeking
            Function<Integer, String> displayNameGen = (input) -> "Check Position " + input + " After Seeking";

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> positionSeekTest(input, random.nextInt(input));

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }
    }
}