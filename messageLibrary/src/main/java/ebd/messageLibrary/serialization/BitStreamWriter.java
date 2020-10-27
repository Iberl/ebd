package ebd.messageLibrary.serialization;

import static ebd.messageLibrary.util.BitUtil.*;

/**
 * Class handling the writing in a bit stream
 *
 * @author Christopher Bernjus, Mario Welzig
 */
public class BitStreamWriter {

	/** Data buffer to write in */
	private byte[] data;

	/** Number of Bits currently stored in buffer */
	private int    size;

	/** Current write head position */
	private int    head;


	// Constructors

	/**
	 * Constructs a new BitStreamWriter with an initial buffer size of 1 byte
	 *
	 * @author Christopher Bernjus
	 */
	public BitStreamWriter() {
		this(1);
	}

	/**
	 * Constructs a new BitStreamWriter with an given initial buffer size
	 *
	 * @param initialCapacity
	 *            The initial buffer size in bytes
	 *
	 * @author Christopher Bernjus
	 */
	public BitStreamWriter(int initialCapacity) {
		grow(initialCapacity);
	}


    // Private Functions

    /**
     * Ensures that the buffer can hold the additional required bits
     *
     * @param additionalBits
     *            The number of additionally required bits
	 *
     * @author Christopher Bernjus
     */
    private void ensureFree(int additionalBits) {
        ensureCapacity(head + additionalBits);
    }

    /**
     * Doubles the buffer until it can contain the required bits
     *
     * @param requiredBits
     *            The new minimum capacity in bits
	 *
     * @author Christopher Bernjus
     */
    private void ensureCapacity(int requiredBits) {
        while((data.length << 3) < (size + requiredBits)) {
            grow(data.length << 1);
        }
    }

    /**
     * Extends the buffer to the specified capacity if it is greater than the current capacity
     *
     * @param newCapacity
     *            The new capacity in bytes
	 *
     * @author Christopher Bernjus
     */
    private void grow(int newCapacity) {
        if(data != null && newCapacity <= data.length) return;

        byte[] buffer = new byte[newCapacity];
        if(data != null) System.arraycopy(data, 0, buffer, 0, data.length);
        data = buffer;
    }


	// Methods

    /**
     * Repositions the read head
     *
     * @param position
     *            The new write head position
	 *
	 * @throws IndexOutOfBoundsException
	 *
     * @author Christopher Bernjus
     */
    public void seek(int position) {
        if(position < 0 || position > size) throw new IndexOutOfBoundsException("Invalid position " + position);
        head = position;
    }

	/**
	 * Writes a single bit
	 *
	 * @param bit
	 *            The bit to write
	 *
	 * @throws IllegalArgumentException
	 *
	 * @author Christopher Bernjus
	 */
	public void writeBit(boolean bit) {
		writeBits(new byte[] {bit ? (byte) -128 : 0}, 1);
	}

	/**
	 * Writes multiple bits
	 *
	 * @param bits
	 *            The array containing the bits to write
	 * @param count
	 *            The number of bits to write
	 *
	 * @throws IllegalArgumentException
	 *
	 * @author Christopher Bernjus
	 */
	public void writeBits(byte[] bits, int count) {
		if(count < 0) throw new IllegalArgumentException("Count must be positive.");
		ensureFree(count);
		copyBits(bits, 0, data, head, count);
		head += count;
		size = max(size, head);
	}

	/**
	 * Writes the lower {@code count} bits of the unsigned integer value
	 *
	 * @param value
	 *            The integer value to serialize
	 * @param count
	 *            The number of bits to write
	 *
	 * @throws IllegalArgumentException
	 *
	 * @author Christopher Bernjus
	 */
	public void writeInt(int value, int count) {
		writeInt(value, count, false);
	}

	/**
	 * Writes the lower {@code count} bits of the (un)signed integer value
	 *
	 * @param value
	 *            The integer value to serialize
	 * @param count
	 *            The number of bits to write
	 * @param signed
	 * 			  Indicates whether the given value is signed or unsigned
	 *
	 * @throws IllegalArgumentException
	 *
	 * @author Christopher Bernjus
	 */
	public void writeInt(int value, int count, boolean signed) {
		if(count == 0) return;
		if(count < 0 || count > 32) throw new IllegalArgumentException("Invalid bit length.");
		if(value > 0 && count != 32 && ((!signed && (value >> count) != 0) || (signed && (value >> count - 1) != 0))) {
			throw new IllegalArgumentException("Invalid value for given bit length.");
		}
		if(signed && value < 0 && count != 32 && (~value >> count - 1) != 0) {
			throw new IllegalArgumentException("Invalid negative value for given bit length.");
		}
		value <<= (32 - count);
		writeBits(new byte[] {(byte) (value >> 24), (byte) (value >> 16), (byte) (value >> 8), (byte) value}, count);
	}

	/**
	 * Writes the lower {@code count} bits of the unsigned long value
	 *
	 * @param value
	 *            The long value to serialize
	 * @param count
	 *            The number of bits to write
	 *
	 * @throws IllegalArgumentException
	 *
	 * @author Christopher Bernjus
	 */
	public void writeLong(long value, int count) {
		writeLong(value, count, false);
	}

	/**
	 * Writes the lower {@code count} bits of the unsigned long value
	 *
	 * @param value
	 *            The long value to serialize
	 * @param count
	 *            The number of bits to write
	 * @param signed
	 * 			  Indicates whether the input is signed or unsigned
	 *
	 * @throws IllegalArgumentException
	 *
	 * @author Christopher Bernjus
	 */
	public void writeLong(long value, int count, boolean signed) {
		if(count == 0) return;
		if(count < 0 || count > 64) throw new IllegalArgumentException("Invalid bit length.");
		if(value > 0 && count != 64 && ((!signed && (value >> count) != 0) || (signed && (value >> count - 1) != 0))) {
			throw new IllegalArgumentException("Invalid value for given bit length.");
		}
		if(signed && value < 0 && count != 64 && (~value >> count - 1) != 0) {
			throw new IllegalArgumentException("Invalid negative value for given bit length.");
		}
		value <<= (64 - count);
		writeBits(new byte[] {(byte) (value >> 56), (byte) (value >> 48), (byte) (value >> 40), (byte) (value >> 32), (byte) (value >> 24), (byte) (value >> 16), (byte) (value >> 8), (byte) value}, count);
	}

	/**
	 * @return A byte array containing the stored bits
	 *
	 * @author Christopher Bernjus
	 */
	public byte[] data() {
        int buffersize = (size >> 3) + ((size & 7) != 0 ? 1 : 0);
        byte[] buffer = new byte[buffersize];
        System.arraycopy(data, 0, buffer, 0, buffersize);
        return buffer;
    }


    // Supporting Functions

    /**
     * Decodes an input string as a byte array, ignoring whitespace and (comments),
     * as well as expanding [x:y] to value x with a length of y bits
     * and repeating x value y times of {x:y}
     * No Nesting, except number specifiers in multiply specifiers
     *
     * @param data
     *          Input String
     * @return
     *          Interpreted String as byte array in BitStreamWriter
     *
	 * @throws IllegalStateException
	 *
     * @author Christopher Bernjus
     */
    public static BitStreamWriter decode(String data) {
        BitStreamWriter writer = new BitStreamWriter();
        return decode(data, writer);
    }

    /**
     * Decodes an input string as a byte array, ignoring whitespace and (comments),
     * as well as expanding [x:y] to value x with a length of y bits
     * and repeating x value y times of {x:y}
     * No Nesting, except number specifiers in multiply specifiers
     *
     * @param data
     *          Input String
     * @param writer
     * 			BitStreamWriter to expand
     * @return
     *          Interpreted String as byte array in BitStreamWriter
	 *
	 * @throws IllegalStateException
     *
     * @author Christopher Bernjus
     */
    public static BitStreamWriter decode(String data, BitStreamWriter writer) {
        data = data.replace(" ", "");
        char[] chars = data.toCharArray();

        int head = 0;
        for(; head < chars.length; head++) {
            int i = head + 1;
            int j = i;
			switch(chars[head]) {
				case '0' -> writer.writeBit(false);
				case '1' -> writer.writeBit(true);
				case '[' -> {
					j = findNext(chars, ':', j);
					long num = Long.parseLong(data.substring(i, j));
					i = j + 1;
					j = findNext(chars, ']', j);
					int len = Integer.parseInt(data.substring(i, j));
					writer.writeLong(num, len);
					head = j;
				}
				case '{' -> {
					int inner = findNextOptional(chars, '{', j);
					if(inner >= 0 && inner < findNext(chars, '*', j)) {
						j = findNext(chars, '}', j);
					}
					j = findNext(chars, '*', j);
					String value = data.substring(i, j);
					i = j + 1;
					j = findNext(chars, '}', j);
					int count = Integer.parseInt(data.substring(i, j));
					while(count-- > 0) {
						BitStreamWriter tmp = decode(value);
						writer.writeBits(tmp.data, tmp.size);
					}
					head = j;
				}
				case '(' -> head = findNext(chars, ')', head);
				default -> throw new IllegalStateException("Unexpected value: " + chars[head]);
			}
        }
        return writer;
    }

	/**
	 * Finds the next occurrence of the given character in char array and returns the index
	 *
	 * @param chars array to search through
	 * @param c		char to search for
	 * @param index starting index
	 *
	 * @return the index of the next occurrence or -1 if there is no occurrence
	 *
	 * @throws IndexOutOfBoundsException
	 *
	 * @author Christopher Bernjus
	 */
	private static int findNextOptional(char[] chars, char c, int index) {
		if(index < 0 || index >= chars.length) throw new IndexOutOfBoundsException("Invalid starting index " + index);
		index -= 1;
    	while(++index < chars.length && chars[index] != c);
    	if(index >= chars.length) return -1;
    	return index;
	}

	/**
	 * Finds the next occurrence of the given character in char array. Expects that there is at least one occurrence left.
	 *
	 * @param chars array to search through
	 * @param c		char to search for
	 * @param index starting index
	 *
	 * @return the index of the next occurrence
	 *
	 * @throws RuntimeException if no occurence is found
	 *
	 * @author Christopher Bernjus
	 */
	private static int findNext(char[] chars, char c, int index) {
		index = findNextOptional(chars, c, index);
		if(index < 0) throw new RuntimeException("Invalid byte sequence string");
		return index;
	}


	// Getter

	/**
	 * @return The number of bits currently stored in buffer
	 *
	 * @author Christopher Bernjus
	 */
	public int size() {
		return size;
	}

	/**
	 * @return The current write head position
	 *
	 * @author Christopher Bernjus
	 */
	public int position() {
		return head;
	}

	@Override
	public String toString() {
		return format(data());
	}
}
