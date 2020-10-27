package ebd.messageLibrary.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

class MathUtilTest {

    /**
     * Class containing Tests for the Function {@link MathUtil#toUnsignedLong(int)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class toUnsignedTests {

        /**
         * Tests the Function {@link MathUtil#toUnsignedLong(int)} on Selected Test Cases
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("toUnsignedLongTestData")
        void toUnsignedLongTest(String testname, int number, long expected) {
            long actual = MathUtil.toUnsignedLong(number);
            assertEquals(expected, actual);
        }

        /**
         * Supplies the Testcases for {@link toUnsignedTests#toUnsignedLongTest(String, int, long)}
         *
         * @author Christopher Bernjus
         */
        public Stream<Arguments> toUnsignedLongTestData() {
            return Stream.of(
                    Arguments.of("Null", 0, 0L),
                    Arguments.of("Integer.MIN_VALUE", Integer.MIN_VALUE, 0x0000000080000000L),
                    Arguments.of("1", 1, 0x0000000000000001L),
                    Arguments.of("-1", -1, 0x00000000ffffffffL),
                    Arguments.of("Integer.MAX_VALUE", Integer.MAX_VALUE, 0x000000007fffffffL)
            );
        }

    }

    /**
     * Class containing Tests for the Function {@link MathUtil#toSignedInteger(long)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class toSignedIntegerTests {

        /**
         * Tests the Function {@link MathUtil#toSignedInteger(long)} on Selected Test Cases
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("toSignedIntegerTestData")
        void toSignedIntegerTest(String testname, long number, int expected) {
            int actual = MathUtil.toSignedInteger(number);
            assertEquals(expected, actual);
        }

        /**
         * Supplies the Testcases for {@link MathUtil#toSignedInteger(long)}
         *
         * @author Christopher Bernjus
         */
        public Stream<Arguments> toSignedIntegerTestData() {
            return Stream.of(
                    Arguments.of("Null", 0L, 0),
                    Arguments.of("Integer.MIN_VALUE", 0x0000000080000000L, Integer.MIN_VALUE),
                    Arguments.of("1", 0x0000000000000001L, 1),
                    Arguments.of("-1", 0x00000000ffffffffL, -1),
                    Arguments.of("Integer.MAX_VALUE", 0x000000007fffffffL, Integer.MAX_VALUE)
            );
        }

        /**
         * Tests the Function {@link MathUtil#toSignedInteger(long)} on Exceptions
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("toSignedIntegerTestExceptionsData")
        void toSignedIntegerTestExceptions(String testname, long number, Exception exception) {
            assertThrows(exception.getClass(), () -> MathUtil.toSignedInteger(number));
        }

        /**
         * Supplies the Testcases for {@link MathUtil#toSignedInteger(long)}
         *
         * @author Christopher Bernjus
         */
        public Stream<Arguments> toSignedIntegerTestExceptionsData() {
            return Stream.of(
                    Arguments.of("Long.MIN_VALUE", 0xffffffffffffffffL, new IllegalArgumentException("Too large unsigned value to be converted to signed int value.")),
                    Arguments.of("Integer.MAX_VALUE + 1", 0x00000001000000000L, new IllegalArgumentException("Too large unsigned value to be converted to signed int value."))
            );
        }

    }

    /**
     * Class containing Tests for the Function {@link MathUtil#toUnsignedBigInteger(long)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class toUnsignedBigIntegerTests {

        /**
         * Tests the Function {@link MathUtil#toUnsignedBigInteger(long)} on Selected Test Cases
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("toUnsignedBigIntegerTestData")
        void toUnsignedBigIntegerTest(String testname, long number, BigInteger expected) {
            BigInteger actual = MathUtil.toUnsignedBigInteger(number);
            assertEquals(expected, actual);
        }

        /**
         * Supplies the Testcases for {@link toUnsignedBigIntegerTests#toUnsignedBigIntegerTest(String, long, BigInteger)}
         *
         * @author Christopher Bernjus
         */
        public Stream<Arguments> toUnsignedBigIntegerTestData() {
            return Stream.of(
                    Arguments.of("Null", 0L, BigInteger.ZERO),
                    Arguments.of("Long.MIN_VALUE", Long.MIN_VALUE, BigInteger.valueOf(Long.MIN_VALUE)),
                    Arguments.of("1", 1L, BigInteger.ONE),
                    Arguments.of("-1", -1L, BigInteger.valueOf(-1L)),
                    Arguments.of("Long.MAX_VALUE", Long.MAX_VALUE, BigInteger.valueOf(Long.MAX_VALUE))
            );
        }

    }

    /**
     * Class containing Tests for the Function {@link MathUtil#toSignedLong(BigInteger)}
     *
     * @author Christopher Bernjus
     */
    @Nested
    @TestInstance(PER_CLASS)
    class toSignedLongTests {

        /**
         * Tests the Function {@link MathUtil#toSignedLong(BigInteger)} on Selected Test Cases
         *
         * @author Christopher Bernjus
         */
        @ParameterizedTest(name = "{0}")
        @MethodSource("toSignedLongTestData")
        void toSignedLongTest(String testname, BigInteger number, long expected) {
            long actual = MathUtil.toSignedLong(number);
            assertEquals(expected, actual);
        }

        /**
         * Supplies the Testcases for {@link toSignedLongTests#toSignedLongTest(String, BigInteger, long)}
         *
         * @author Christopher Bernjus
         */
        public Stream<Arguments> toSignedLongTestData() {
            return Stream.of(
                    Arguments.of("Null", BigInteger.ZERO, 0L),
                    Arguments.of("Long.MIN_VALUE", BigInteger.valueOf(0x8000000000000000L), Long.MIN_VALUE),
                    Arguments.of("1", BigInteger.ONE, 1L),
                    Arguments.of("-1", BigInteger.valueOf(0xffffffffffffffffL), -1L),
                    Arguments.of("-212", BigInteger.valueOf(0xffffffffffffff2cL), -212L),
                    Arguments.of("Long.MAX_VALUE", BigInteger.valueOf(Long.MAX_VALUE), Long.MAX_VALUE)
            );
        }

    }
}