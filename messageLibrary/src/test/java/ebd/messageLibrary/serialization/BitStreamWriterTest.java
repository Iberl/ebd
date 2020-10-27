package ebd.messageLibrary.serialization;

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
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

/**
 * Contains Tests for Class {@link BitStreamWriter}
 *
 * @author Christopher Bernjus
 */
class BitStreamWriterTest {

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

	/**
	 * @param str
	 * 			String to pad with leading 0s
	 * @param size
	 * 			Size of the entire padded string
	 * @return Padded string with leading 0s
	 *
	 * @author Christopher Bernjus
	 */
	public String leftPadZeros(String str, int size) {
		if(size <= 0) return str;
		return String.format("%1$" + size + "s", str).replace(' ', '0');
	}

	/**
	 * @param str
	 * 			String to pad with trailing 0s
	 * @param size
	 * 			Size of the entire padded string
	 * @return Padded string with trailing 0s
	 *
	 * @author Christopher Bernjus
	 */
	public String rightPadZeros(String str, int size) {
		if(size <= 0) return str;
		return String.format("%1$-" + size + "s", str).replace(' ', '0');
	}


	// Tests

	/**
	 * Class containing Tests for the Function {@link BitStreamWriter#seek(int)}
	 *
	 * @author Christopher Bernjus
	 */
	@Nested
	class seekTests {

		/**
		 * Tests the Function {@link BitStreamWriter#seek(int)} on correct Inputs
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		public Stream<DynamicTest> seekTest() {
			// Generates display names like: Seek Position: 168
			Function<Integer, String> displayNameGen = (input) -> "Seek Position " + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Integer> testExecutor = (input) -> {
				int capacity = byteCount(input);
				BitStreamWriter writer = new BitStreamWriter(capacity);
				byte[] bits = new byte[capacity];
				writer.writeBits(bits, input);
				writer.seek(0);
				assertEquals(0, writer.position());
				writer.seek(input - 1);
				assertEquals(input - 1, writer.position());
				writer.seek(input >> 1);
				assertEquals(input >> 1, writer.position());
			};

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#seek(int)} on negative Inputs
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> seekErrorNegative() {
			// Generates display names like: Negative Position: -822
			Function<Integer, String> displayNameGen = (input) -> "Negative Position " + -input;

			// Executes tests based on the current input value
			ThrowingConsumer<Integer> testExecutor = (input) -> {
				BitStreamWriter writer = new BitStreamWriter();
				byte[] bits = new byte[]{0};
				writer.writeBits(bits, 8);
				assertThrows(IndexOutOfBoundsException.class, () -> writer.seek(-input));
			};

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#seek(int)} on Inputs
		 * larger than the size of the {@link BitStreamWriter}
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> seekErrorTooLarge() {
			// Generates display names like: Large Position: 1000
			Function<Integer, String> displayNameGen = (input) -> "Large Position " + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Integer> testExecutor = (input) -> {
				assumeTrue(input >= 8);
				BitStreamWriter writer = new BitStreamWriter();
				byte[] bits = new byte[]{0};
				writer.writeBits(bits, 8);
				assertThrows(IndexOutOfBoundsException.class, () -> writer.seek(input + 1));
			};

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
		}

	}

	/**
	 * Class containing Tests for the Function {@link BitStreamWriter#writeBits(byte[], int)}
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
		BitStreamWriter writeBitsTest(int input, BitStreamWriter writer) {
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

			// Combine input data and written bits into the expected byte array
			byte[] expected = new byte[byteCount(size + input)];
			System.arraycopy(data, 0, expected, 0, data.length);
			copyBits(bits, 0, expected, size, input);

			// Check on bits and size
			assertEquals(size + input, writer.size());
			assertArrayEquals(expected, writer.data());
			return writer;
		}

		// Tests for minimal input -> writeBitTest()

		/**
		 * Tests the Function {@link BitStreamWriter#writeBits(byte[], int)} on Random Data from Index 0
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> writeBitsTestRandomData() {
			// Generates display names like: Write 243 Bits beginning at index: 0
			Function<Integer, String> displayNameGen = (input) -> "Write " + input + " bits beginning at index 0";

			// Executes tests based on the current input value
			ThrowingConsumer<Integer> testExecutor = (input) -> writeBitsTest(input, null);

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeBits(byte[], int)} on Random Data from Index 0
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> writeBitsTestRandomIndex() {
			// Generates display names like: Write 243 Bits beginning at index: 0
			Function<Integer, String> displayNameGen = (input) -> "Write " + input + " bits beginning at index " + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Integer> testExecutor = (input) -> {
				BitStreamWriter writer = writeBitsTest(input, null);
				writeBitsTest(input, writer);
			};

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeBits(byte[], int)} with large Input
		 *
		 * @author Christopher Bernjus
		 *//*
		@Test
		void writeBitsTestMax() {
			writeBitsTest(Integer.MAX_VALUE >> 1, null);
		}*/
	}

    /**
     * Tests the Function {@link BitStreamWriter#writeBit(boolean)}
     *
     * @author Christopher Bernjus
     */
    @Test
    void writeBitTest() {
        // Create a new BitStreamWriter instance
        BitStreamWriter writer = new BitStreamWriter();

        // Testcase: false (0)
        writer.writeBit(false);
        assertArrayEquals(new byte[]{0b00000000}, writer.data());

        // Testcase: true (1)
        writer.writeBit(true);
        assertArrayEquals(new byte[]{0b01000000}, writer.data());
    }

	/**
	 * Class containing Tests for the Function {@link BitStreamWriter#writeInt(int, int)}
	 *
	 * @author Christopher Bernjus
	 */
	@Nested
	class writeIntTests {

		/**
		 * Returns the needed bit length to describe the given integer value in bits
		 *
		 * @param input
		 * 			given input as integer value
		 *
		 * @author Christopher Bernjus
		 */
		int getBitLengthOf(int input) {
			if(input == 0) return 0;
			return (int) Math.min(Math.round(Math.log(Math.abs(input)) / Math.log(2) + 1), 32);
		}

		/**
		 * Logic for testing the Function {@link BitStreamWriter#writeInt(int, int)}
		 *
		 * @param input
		 * 			number to write in BitStreamWriter
		 *
		 * @author Christopher Bernjus
		 */
		void writeIntTest(int input) {
			BitStreamWriter writer = new BitStreamWriter();
			int count = getBitLengthOf(input);
			writer.writeInt(input, count);

			String expected = Integer.toBinaryString(input);
			if(count <= expected.length()) expected = expected.substring(expected.length() - count);
			expected = leftPadZeros(expected, count);
			expected = rightPadZeros(expected, (byteCount(count) * 8));
			assertEquals(expected, format(writer.data()).replace(" ", ""));
		}

		/**
		 * Logic for testing the Function {@link BitStreamWriter#writeInt(int, int)} with invalid values
		 *
		 * @param input
		 * 			number to write in BitStreamWriter
		 * @param signed
		 * 			indicates whether the input is signed or not
		 *
		 * @author Christopher Bernjus
		 */
		void writeIntTestInvalid(int input, boolean signed) {
			BitStreamWriter writer = new BitStreamWriter();
			assertThrows(IllegalArgumentException.class, () -> writer.writeInt(input, -random.nextInt(1000) - 1, signed));

			int count = Math.max(getBitLengthOf(input) - 2, 0);
			if(count != 0) assertThrows(IllegalArgumentException.class, () -> writer.writeInt(input, count, signed), "Invalid value for given bit length.");
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeInt(int, int)} with minimal value
		 *
		 * @author Christopher Bernjus
		 */
		@Test
		void writeIntTestMin() {
			writeIntTest(Integer.MIN_VALUE);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeInt(int, int)} with 0
		 *
		 * @author Christopher Bernjus
		 */
		@Test
		void writeIntTest0() {
			writeIntTest(0);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeInt(int, int)} with maximal value
		 *
		 * @author Christopher Bernjus
		 */
		@Test
		void writeIntTestMax() {
			writeIntTest(Integer.MAX_VALUE);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeInt(int, int)} with Random Data
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> writeIntTestRandom() {
			// Generates display names like: Write Int: 837
			Function<Integer, String> displayNameGen = (input) -> "Write Int: " + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Integer> testExecutor = (input) -> writeIntTest(input);

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeInt(int, int)} with Random Negative Data
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> writeIntTestRandomNegative() {
			// Generates display names like: Write Int: 837
			Function<Integer, String> displayNameGen = (input) -> "Write Int: -" + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Integer> testExecutor = (input) -> writeIntTest(-input);

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeInt(int, int)} with Random Data
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> writeIntTestInvalidRandom() {
			// Generates display names like: Write Int: 837
			Function<Integer, String> displayNameGen = (input) -> "Write Int: " + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Integer> testExecutor = (input) -> writeIntTestInvalid(input, false);

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeInt(int, int)} with Random Negative Data
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> writeIntTestInvalidRandomNegative() {
			// Generates display names like: Write Int: 837
			Function<Integer, String> displayNameGen = (input) -> "Write Int: -" + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Integer> testExecutor = (input) -> writeIntTestInvalid(-input - 2, true);

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
		}
	}

	/**
	 * Class containing Tests for the Function {@link BitStreamWriter#writeLong(long, int)}
	 *
	 * @author Christopher Bernjus
	 */
	@Nested
	class writeLongTests {

		/**
		 * Returns the needed bit length to describe the given long value in bits
		 *
		 * @param input
		 * 			given input as long value
		 *
		 * @author Christopher Bernjus
		 */
		int getBitLengthOf(long input) {
			if(input == 0) return 0;
			return (int) Math.min(Math.round(Math.log(Math.abs(input)) / Math.log(2) + 1), 64);
		}

		/**
		 * Logic for testing the Function {@link BitStreamWriter#writeLong(long, int)}
		 *
		 * @param input
		 * 			number to write in BitStreamWriter
		 *
		 * @author Christopher Bernjus
		 */
		void writeLongTest(long input) {
			BitStreamWriter writer = new BitStreamWriter();
			int count = getBitLengthOf(input);
			writer.writeLong(input, count);

			String expected = Long.toBinaryString(input);
			if(count <= expected.length()) expected = expected.substring(expected.length() - count);
			expected = leftPadZeros(expected, count);
			expected = rightPadZeros(expected, (byteCount(count) * 8));
			assertEquals(expected, format(writer.data()).replace(" ", ""));
		}

		/**
		 * Logic for testing the Function {@link BitStreamWriter#writeInt(int, int)} with invalid values
		 *
		 * @param input
		 * 			number to write in BitStreamWriter
		 * @param signed
		 * 			indicates whether the input is signed or not
		 *
		 * @author Christopher Bernjus
		 */
		void writeLongTestInvalid(long input, boolean signed) {
			BitStreamWriter writer = new BitStreamWriter();
			assertThrows(IllegalArgumentException.class, () -> writer.writeLong(input, -random.nextInt(1000) - 1, signed));

			int count = Math.max(getBitLengthOf(input) - 2, 0);
			if(count != 0) assertThrows(IllegalArgumentException.class, () -> writer.writeLong(input, count, signed), "Invalid value for given bit length.");
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeLong(long, int)} with minimal value
		 *
		 * @author Christopher Bernjus
		 */
		@Test
		void writeLongTestMin() {
			writeLongTest(Long.MIN_VALUE);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeLong(long, int)} with 0
		 *
		 * @author Christopher Bernjus
		 */
		@Test
		void writeLongTest0() {
			writeLongTest(0);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeLong(long, int)} with maximal value
		 *
		 * @author Christopher Bernjus
		 */
		@Test
		void writeLongTestMax() {
			writeLongTest(Long.MAX_VALUE);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeLong(long, int)} with Random Data
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> writeLongTestRandom() {
			// Generates display names like: Write Long: 837
			Function<Long, String> displayNameGen = (input) -> "Write Long: " + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Long> testExecutor = (input) -> writeLongTest(input);

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputLongGen, displayNameGen, testExecutor);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeLong(long, int)} with Random Negative Data
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> writeLongTestRandomNegative() {
			// Generates display names like: Write Long: 837
			Function<Long, String> displayNameGen = (input) -> "Write Long: -" + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Long> testExecutor = (input) -> writeLongTest(-input);

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputLongGen, displayNameGen, testExecutor);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeLong(long, int)} with Random Data
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> writeLongTestInvalidRandom() {
			// Generates display names like: Write Long: 837
			Function<Long, String> displayNameGen = (input) -> "Write Long: " + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Long> testExecutor = (input) -> writeLongTestInvalid(input + 1, false);

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputLongGen, displayNameGen, testExecutor);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#writeLong(long, int)} with Random Negative Data
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> writeLongTestInvalidRandomNegative() {
			// Generates display names like: Write Long: 837
			Function<Long, String> displayNameGen = (input) -> "Write Long: -" + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Long> testExecutor = (input) -> writeLongTestInvalid(-input - 2, true);

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputLongGen, displayNameGen, testExecutor);
		}
	}

    /**
     * Class containing Tests for the Function {@link BitStreamWriter#data()}
     *
     * @author Christopher Bernjus
     */
    @Nested
    class dataTests {

		/**
		 * Logic for testing the Function {@link BitStreamWriter#data()}
		 *
		 * @param input
		 * 			number of bits to write in BitStreamWriter
		 *
		 * @author Christopher Bernjus
		 */
		void dataTest(int input) {
            int capacity = byteCount(input);
            BitStreamWriter writer = new BitStreamWriter(capacity);
            byte[] bits = new byte[capacity];
            random.nextBytes(bits);
            bits[bits.length - 1] &= -1 << trailBits(input);

            writer.writeBits(bits, input);
            assertArrayEquals(bits, writer.data());
        }

		/**
		 * Tests the Function {@link BitStreamWriter#data()} with no written Data
		 *
		 * @author Christopher Bernjus
		 */
		@Test
        void dataTestMin() {
            BitStreamWriter writer = new BitStreamWriter();
            assertArrayEquals(new byte[]{}, writer.data());
        }

		/**
		 * Tests the Function {@link BitStreamWriter#data()} on Random Data
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
        Stream<DynamicTest> dataTestRandom() {
            // Generates display names like: Data with Length 934
            Function<Integer, String> displayNameGen = (input) -> "Data with Length " + input;

            // Executes tests based on the current input value
            ThrowingConsumer<Integer> testExecutor = (input) -> dataTest(Math.max(input, 1));

            // Returns a steam of dynamic tests
            return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
        }

		/**
		 * Tests the Function {@link BitStreamWriter#data()} with large Input
		 *
		 * @author Christopher Bernjus
		 *//*
		@Test
        void dataTestMax() {
            dataTest(Integer.MAX_VALUE >> 1);
        }*/
    }

	/**
	 * Tests for the Function {@link BitStreamWriter#decode(String)} )}
	 *
	 * @author Christopher Bernjus
	 */
	@Nested
	@TestInstance(PER_CLASS)
	class decodeTests {

		/**
		 * Tests testcases for Function {@link BitStreamWriter#decode(String)}
		 *
		 * @param testname
		 * 			name of test displayed in IDE
		 * @param input
		 * 			number of bits to write in BitStreamWriter
		 * @param output
		 * 			expected output byte array
		 *
		 * @author Christopher Bernjus
		 */
		@ParameterizedTest(name = "{0}")
		@MethodSource("decodeTestData")
		void decodeTest(String testname, String input, byte[] output) {
			assertArrayEquals(output, BitStreamWriter.decode(input).data());
		}

		/**
		 * @return Test cases for {@link BitStreamWriterTest.decodeTests#decodeTest(String, String, byte[])}
		 *
		 * @author Christopher Bernjus
		 */
		Stream<Arguments> decodeTestData() {
			return Stream.of(
					Arguments.of("Empty Comment", "()", new byte[]{}),
					Arguments.of("Comment", "(Comment)", new byte[]{}),
					Arguments.of("Empty", "", new byte[]{}),
					Arguments.of("1", "1", new byte[]{(byte) 0b10000000}),
					Arguments.of("0", "0", new byte[]{0}),
					Arguments.of("Bit Combination", "00110", new byte[]{(byte) 0b00110000}),
					Arguments.of("Number Length 0", "[13:0]", new byte[]{}),
					Arguments.of("Number Length 12", "[-1:12]", new byte[]{(byte) 0b11111111, (byte) 0b11110000}),
					Arguments.of("Number 0", "[0:8]", new byte[]{(byte) 0b00000000}),
					Arguments.of("Number 1 Length 1", "[1:1]", new byte[]{(byte) 0b10000000}),
					Arguments.of("Number 1024", "[1024:11]", new byte[]{(byte) 0b10000000, (byte) 0b00000000}),
					Arguments.of("Multiple Times 0", "{32*0}", new byte[]{}),
					Arguments.of("Multiple 1s", "{1*10}", new byte[]{(byte) 0b11111111, (byte) 0b11000000}),
					Arguments.of("Multiple 0s", "{0*15}", new byte[]{(byte) 0b00000000, (byte) 0b00000000}),
					Arguments.of("Multiple 0 Numbers", "{[0:8]*2}", new byte[]{(byte) 0b00000000, (byte) 0b00000000}),
					Arguments.of("Multiple Positive Numbers", "{[12:6]*3}", new byte[]{(byte) 0b00110000, (byte) 0b11000011, (byte) 0b00000000}),
					Arguments.of("Multiple Negative Numbers", "{[-1:4]*4}", new byte[]{(byte) 0b11111111, (byte) 0b11111111}),
					Arguments.of("Multiple Multiple 1s", "{{1*10}*3}", new byte[]{(byte) 0b11111111, (byte) 0b11111111, (byte) 0b11111111, (byte) 0b11111100}),
					Arguments.of("Multiple Multiple 0s", "{{0*15}*2}", new byte[]{(byte) 0b00000000, (byte) 0b00000000, (byte) 0b00000000, (byte) 0b00000000}),
					Arguments.of("Multiple Multiple 0 Numbers", "{{[0:8]*2}*3}", new byte[]{(byte) 0b00000000, (byte) 0b00000000, (byte) 0b00000000, (byte) 0b00000000,(byte) 0b00000000, (byte) 0b00000000}),
					Arguments.of("Multiple Multiple Positive Numbers", "{{[12:6]*2}*2}", new byte[]{(byte) 0b00110000, (byte) 0b11000011, (byte) 0b00001100}),
					Arguments.of("Multiple Multiple Negative Numbers", "{{[-1:4]*4}*1}", new byte[]{(byte) 0b11111111, (byte) 0b11111111})
			);
		}

		/**
		 * Tests testcases for Function {@link BitStreamWriter#decode(String)} on Data throwing Errors
		 *
		 * @param testname
		 * 			name of test displayed in IDE
		 * @param input
		 * 			number of bits to write in BitStreamWriter
		 * @param exception
		 * 			expected exception byte array
		 *
		 * @author Christopher Bernjus
		 */
		@ParameterizedTest(name = "{0}")
		@MethodSource("decodeErrorData")
		void decodeError(String testname, String input, Exception exception) {
			if(exception.getMessage() == null) assertThrows(exception.getClass(), () -> BitStreamWriter.decode(input));
			else assertThrows(exception.getClass(), () -> BitStreamWriter.decode(input), exception.getMessage());
		}

		/**
		 * @return Test cases for {@link BitStreamWriterTest.decodeTests#decodeError(String, String, Exception)}
		 *
		 * @author Christopher Bernjus
		 */
		Stream<Arguments> decodeErrorData() {
			return Stream.of(
					Arguments.of("Malformed number specifier", "[", new RuntimeException("Invalid byte sequence string: Malformed number specifier")),
					Arguments.of("Malformed size specifier", "[2:", new RuntimeException("Invalid byte sequence string: Malformed size specifier")),
					Arguments.of("Malformed value specifier", "{", new RuntimeException("Invalid byte sequence string: Malformed value specifier")),
					Arguments.of("Malformed count specifier", "{0*", new RuntimeException("Invalid byte sequence string: Malformed count specifier")),
					Arguments.of("Number specifier NaN", "[x:3]", new NumberFormatException()),
					Arguments.of("Size specifier NaN", "[3:x]", new NumberFormatException()),
					Arguments.of("Count specifier NaN", "{1*x}", new NumberFormatException()),
					Arguments.of("Unexpected value", "8", new IllegalStateException()) // Only one example
			);
		}

	}

	/**
	 * Class containing Tests for the Function {@link BitStreamWriter#size()}
	 *
	 * @author Christopher Bernjus
	 */
    @Nested
	class sizeTests {

		/**
		 * Logic for testing the Function {@link BitStreamWriter#size()}
		 *
		 * @param count
		 * 			number of bits to write in BitStreamWriter
		 * @param size
		 * 			number of bits that should be in BitStreamWriter after writing
		 *
		 * @author Christopher Bernjus
		 */
    	void sizeTest(int count, int size) {
			BitStreamWriter writer = new BitStreamWriter();
			byte[] bits = new byte[Math.max(byteCount(count), 1)];
			writer.writeBits(bits, count);

			assertEquals(size, writer.size());
		}

		/**
		 * Tests the Function {@link BitStreamWriter#data()} with 0
		 *
		 * @author Christopher Bernjus
		 */
    	@Test
		void sizeTest0() {
    		sizeTest(0, 0);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#data()} on Random Data
		 *
		 * @author Christopher Bernjus
		 */
    	@TestFactory
		Stream<DynamicTest> sizeTestRandom() {
			// Generates display names like: Check Size: 934
			Function<Integer, String> displayNameGen = (input) -> "Check Size: " + input;

			// Executes tests based on the current input value
			ThrowingConsumer<Integer> testExecutor = (input) -> sizeTest(input, input);

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
		}
	}

	/**
	 * Class containing Tests for the Function {@link BitStreamWriter#position()}
	 *
	 * @author Christopher Bernjus
	 */
	@Nested
	class positionTests {

		/**
		 * Logic for testing the Function {@link BitStreamWriter#position()} after writing
		 *
		 * @param count
		 * 			number of bits to write in BitStreamWriter
		 * @param position
		 * 			estimated position of the write head in BitStreamWriter after writing
		 *
		 * @author Christopher Bernjus
		 */
		void positionTest(int count, int position) {
			BitStreamWriter writer = new BitStreamWriter();
			byte[] bits = new byte[Math.max(byteCount(count), 1)];
			writer.writeBits(bits, count);

			assertEquals(position, writer.position());
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
			writer.seek(position);

			assertEquals(position, writer.position());
		}

		/**
		 * Tests the Function {@link BitStreamWriter#position()} with 0
		 *
		 * @author Christopher Bernjus
		 */
		@Test
		void positionTest0() {
			positionTest(0, 0);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#position()} on Random Data
		 *
		 * @author Christopher Bernjus
		 */
		@TestFactory
		Stream<DynamicTest> positionTestRandom() {
			// Generates display names like: Check Position 634 After Writing
			Function<Integer, String> displayNameGen = (input) -> "Check Position " + input + " After Writing";

			// Executes tests based on the current input value
			ThrowingConsumer<Integer> testExecutor = (input) -> positionTest(input, input);

			// Returns a steam of dynamic tests
			return DynamicTest.stream(inputIntGen, displayNameGen, testExecutor);
		}

		/**
		 * Tests the Function {@link BitStreamWriter#position()} after seeking on Random Data
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