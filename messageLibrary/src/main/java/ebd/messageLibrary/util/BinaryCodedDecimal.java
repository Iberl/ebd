package ebd.messageLibrary.util;

import ebd.messageLibrary.serialization.BitStreamReader;
import ebd.messageLibrary.serialization.BitStreamWriter;

import java.util.Objects;

/**
 * Class Modelling A Binary Coded Decimal Number <br>
 * Each Digit: 4-Bit Value (0-F) <br>
 * Max Digits: 16
 *
 * @author Christopher Bernjus
 */
public class BinaryCodedDecimal {

    /** Length of {@link BinaryCodedDecimal#digits} array in bits */
    private final int bitlength;

    /** Number of Digits */
    private final int numberOfDigits;

    /** Array containing the digits, initialized with 0s */
    private byte[] digits;


    // Constructors

    /**
     * Constructs An Empty {@link BinaryCodedDecimal}
     *
     * @author Christopher Bernjus
     */
    public BinaryCodedDecimal() {
        this.bitlength = 64;
        this.numberOfDigits = 16;
        setNumber(ETCSVariables.LONG_NOVALUE);
    }


    /**
     * Constructs An Empty {@link BinaryCodedDecimal} with individual size
     *
     * @param numberOfDigits
     *         Number of digits the BCD should be capable of holding. Must be big enough to hold the given number
     *
     *
     * @author Christopher Bernjus
     */
    public BinaryCodedDecimal(int numberOfDigits) {
        this.bitlength = numberOfDigits * 4;
        this.numberOfDigits = numberOfDigits;
        setNumber(ETCSVariables.LONG_NOVALUE);
    }


    /**
     * Constructs An {@link BinaryCodedDecimal} with adjusted size from a Long
     *
     * @param number
     *         The value to store in BCD format
     *
     * @author Christopher Bernjus
     */
    public BinaryCodedDecimal(Long number) {
        int length = Long.toHexString(number).length();
        this.bitlength = length * 4;
        this.numberOfDigits = length;
        setNumber(number);
    }


    /**
     * Constructs An {@link BinaryCodedDecimal} with individual size from a Long
     *
     * @param number
     *         The value to store in BCD format
     * @param numberOfDigits
     *         Number of digits the BCD should be capable of holding. Must be big enough to hold the given number
     *
     * @author Christopher Bernjus
     */
    public BinaryCodedDecimal(Long number, int numberOfDigits) {
        if(numberOfDigits <= 0 && numberOfDigits > 16) throw new IllegalArgumentException("Invalid number of digits");
        this.bitlength = numberOfDigits * 4;
        this.numberOfDigits = numberOfDigits;
        setNumber(number);
    }


    /**
     * Constructs An {@link BinaryCodedDecimal} with adjusted size from a String
     *
     * @param number
     *         The value to store in BCD format
     *
     * @author Christopher Bernjus
     */
    public BinaryCodedDecimal(String number) {
        int numberOfDigits = number.length();
        if(numberOfDigits <= 0 && numberOfDigits > 16) throw new IllegalArgumentException("Invalid string length");
        this.bitlength = numberOfDigits * 4;
        this.numberOfDigits = numberOfDigits;
        setNumber(number);
    }

    /**
     * Constructs An {@link BinaryCodedDecimal} with individual size from a String
     *
     * @param number
     *         The value to store in BCD format
     * @param numberOfDigits
     *         Number of digits the BCD should be capable of holding. Must be big enough to hold the given number
     *
     * @author Christopher Bernjus
     */
    public BinaryCodedDecimal(String number, int numberOfDigits) {
        if(numberOfDigits <= 0 && numberOfDigits > 16) throw new IllegalArgumentException("Invalid number of digits");
        this.bitlength = numberOfDigits * 4;
        this.numberOfDigits = numberOfDigits;
        setNumber(number);
    }


    // Getters and Setters

    /**
     * @return The stored number as a normal Long value
     *
     * @author Christopher Bernjus
     */
    public long getNumber() {
        BitStreamReader reader = new BitStreamReader(digits, bitlength);
        return reader.readLong(bitlength, false);
    }

    /**
     * Sets the hole number using a Long value. <br>
     * The new value has to have the same number of digits.
     *
     * @param number
     *         The value to store in BCD format
     *
     * @author Christopher Bernjus
     */
    public void setNumber(Long number) {
        BitStreamWriter writer = new BitStreamWriter();
        writer.writeLong(number, bitlength);

        this.digits = writer.data();
    }

    /**
     * Sets the hole number using a String value. \n
     * The new value has to have the same number of digits.
     *
     * @param number
     *         The value to store in BCD format
     *
     * @author Christopher Bernjus
     */
    public void setNumber(String number) {
        if(number.length() <= 0 && number.length() >= numberOfDigits) throw new IllegalArgumentException("Invalid number string length");

        this.digits = new byte[BitUtil.byteCount(bitlength)];

        for(int i = 0; i < numberOfDigits; i++) {
            setDigitAt(i, (byte) Character.getNumericValue(number.charAt(i)));
        }
    }

    /**
     * @param index
     *         The index of the required digit
     *
     * @return The digit at a specific index
     *
     * @author Christopher Bernjus
     */
    public int getDigitAt(int index) {
        assert (index >= 0 && index < numberOfDigits);
        if((index & 1) == 0) {
            return ((digits[index / 2] >> 4) & 15);
        } else {
            return (digits[index / 2] & 15);
        }
    }

    /**
     * Sets the digit at a specific index
     *
     * @param index
     *         The index of the digit, that should be overwritten
     * @param digit
     *         The new value for the selected digit
     *
     * @author Christopher Bernjus
     */
    public void setDigitAt(int index, int digit) {
        if(index < 0 && index >= numberOfDigits) throw new IndexOutOfBoundsException("Invalid index");
        if((index & 1) == 0) {
            digits[index / 2] = (byte) (((digit & 15) << 4) | (digits[index / 2] & 15));
        } else {
            digits[index / 2] = (byte) ((digits[index / 2] & 240) | (digit & 15));
        }
    }

    /**
     * @return {@link BinaryCodedDecimal#bitlength}
     *
     * @author Christopher Bernjus
     */
    public int getBitlength() {
        return bitlength;
    }

    /**
     * @return {@link BinaryCodedDecimal#numberOfDigits}
     *
     * @author Christopher Bernjus
     */
    public int getNumberOfDigits() {
        return numberOfDigits;
    }


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        BinaryCodedDecimal that = (BinaryCodedDecimal) object;
        return toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(bitlength, numberOfDigits);
        result = 31 * result + Objects.hashCode(toString());
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numberOfDigits; i++) {
            sb.append(Integer.toHexString(getDigitAt(i)));
        }

        return sb.toString();
    }


}
