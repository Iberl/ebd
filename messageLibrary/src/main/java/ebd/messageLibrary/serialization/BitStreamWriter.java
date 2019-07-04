package ebd.messageLibrary.serialization;

import static ebd.messageLibrary.util.BitUtil.copyBits;
import static ebd.messageLibrary.util.BitUtil.format;
import static ebd.messageLibrary.util.BitUtil.max;

/**
 * Class handling the writing in a bit stream
 *
 * @author Christopher Bernjus, Mario Welzig
 */
public class BitStreamWriter {

	private byte[] data;
	private int    size;
	private int    head;

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
	 * @author Christopher Bernjus
	 */
	public BitStreamWriter(int initialCapacity) {
		grow(initialCapacity);
	}

	/**
	 * Writes multiple bits
	 *
	 * @param bits
	 *            The array containing the bits to write
	 * @param count
	 *            The number of bits to write
	 * @author Christopher Bernjus
	 */
	public void writeBits(byte[] bits, int count) {
		ensureCapacity(count);
		copyBits(bits, 0, data, head, count);
		head += count;
		size = max(size, head);
	}

	/**
	 * Writes a single bit
	 *
	 * @param bit
	 *            The bit to write
	 * @author Christopher Bernjus
	 */
	public void writeBit(boolean bit) {
		writeBits(new byte[] {bit ? (byte) -128 : 0}, 1);
	}

	/**
	 * Writes the lower {@code count} bits of the integer value
	 *
	 * @param value
	 *            The integer value to serialize
	 * @param count
	 *            The number of bits to write
	 * @author Christopher Bernjus
	 */
	public void writeInt(int value, int count) {
		value <<= 32 - count;
		writeBits(new byte[] {(byte) (value >> 24), (byte) (value >> 16), (byte) (value >> 8), (byte) value}, count);
	}

	/**
	 * Writes the lower {@code count} bits of the long value
	 *
	 * @param value
	 *            The long value to serialize
	 * @param count
	 *            The number of bits to write
	 * @author Christopher Bernjus
	 */
	public void writeLong(long value, int count) {
		value <<= 64 - count;
		writeBits(new byte[] {(byte) (value >> 56), (byte) (value >> 48), (byte) (value >> 40), (byte) (value >> 32), (byte) (value >> 24), (byte) (value >> 16), (byte) (value >> 8), (byte) value}, count);
	}

	/**
	 * @return A byte array containing the stored bits
	 * @author Christopher Bernjus
	 */
	public byte[] data() {
		int buffersize = (size >> 3) + ((size & 7) != 0 ? 1 : 0);
		byte[] buffer = new byte[buffersize];
		System.arraycopy(data, 0, buffer, 0, buffersize);
		return buffer;
	}

	/**
	 * @return The number of bits currently stored in buffer
	 * @author Christopher Bernjus
	 */
	public int size() {
		return size;
	}

	/**
	 * @return The current read head position
	 * @author Christopher Bernjus
	 */
	public int position() {
		return head;
	}

	/**
	 * Repositions the read head
	 *
	 * @param position
	 *            The new read head position
	 * @author Christopher Bernjus
	 */
	public void seek(int position) {
		if(position < 0 || position > size) throw new IndexOutOfBoundsException("Invalid position " + position);
		head = position;
	}

	/**
	 * Ensures that the buffer can hold the additional required bits
	 *
	 * @param additionalBits
	 *            The number of additionally required bits
	 * @author Christopher Bernjus
	 */
	public void ensureFree(int additionalBits) {
		ensureCapacity(head + additionalBits);
	}

	/**
	 * Doubles the buffer until it can contain the required bits
	 *
	 * @param requiredBits
	 *            The new minimum capacity in bits
	 * @author Christopher Bernjus
	 */
	public void ensureCapacity(int requiredBits) {
		while((data.length << 3) < (size + requiredBits)) {
			grow(data.length << 1);
		}
	}

	/**
	 * Extends the buffer to the specified capacity if it is greater than the current capacity
	 *
	 * @param newCapacity
	 *            The new capacity in bytes
	 * @author Christopher Bernjus
	 */
	public void grow(int newCapacity) {
		if(data != null && newCapacity <= data.length) return;

		byte[] buffer = new byte[newCapacity];
		if(data != null) System.arraycopy(data, 0, buffer, 0, data.length);
		data = buffer;
	}

	@Override
	public String toString() {
		return format(data());
	}
}
