package ebd.messageLibrary.util;

import java.math.BigInteger;

/**
 * Class Containing Functions For Arithmetic Operations
 *
 * @author Christopher Bernjus
 */
public class MathUtil {

    /**
     * Converts A Signed Integer To A Unsigned Long
     *
     * @param signed
     *            The Signed Integer Value
     *
     * @return The Unsigned Long Value
     *
     * @author Christopher Bernjus
     */
    public static long toUnsignedLong(int signed) {
        return signed & 0x00000000ffffffffL;
    }

    /**
     * Converts A Unsigned Long To A Signed Integer
     *
     * @param unsigned
     *            The Unsigned Long Value
     *
     * @return The Signed Integer Value
     *
     * @author Christopher Bernjus
     */
    public static int toSignedInteger(long unsigned) {
        if(unsigned < 0 || unsigned >> 32 != 0) {
            throw new IllegalArgumentException("Too large unsigned value to be converted to signed int value.");
        }
        return (int) (unsigned & 0x00000000ffffffffL);
    }

    /**
     * Converts A Signed Long To A Unsigned BigInteger
     *
     * @param signed
     *            The Signed Long Value
     *
     * @return The Unsigned BigInteger Value
     *
     * @author Christopher Bernjus
     */
    public static BigInteger toUnsignedBigInteger(long signed) {
        return new BigInteger(Long.toString(signed));
    }

    /**
     * Converts A Unsigned BigInteger To A Signed Long
     *
     * @param unsigned
     *            The Unsigned BigInteger Value
     *
     * @return The Signed Long Value
     *
     * @author Christopher Bernjus
     */
    public static long toSignedLong(BigInteger unsigned) {
        return unsigned.longValue();
    }

}
