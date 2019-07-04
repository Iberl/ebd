package ebd.messageLibrary.serialization;

import ebd.messageLibrary.util.BitUtil;

/**
 * Class for reading from a byte array buffer
 *
 * @author Christopher Bernjus, Mario Welzig
 */
public class BitStreamReader {

	private byte[] data;
	private int    size;
	private int    head;

	/**
	 * Constructs a new {@link BitStreamReader} from an existing buffer
	 *
	 * @param data
	 *          the data from which the {@link BitStreamReader} will be created
	 * @param size
	 *          size of needed buffer for given data
	 *
	 * @author Christopher Bernjus, Mario Welzig
	 */
	public BitStreamReader(byte[] data, int size) {
		this.data = data;
		this.size = size;
	}

	/**
	 * Repositions the read head
	 *
	 * @param position
	 *          the new read head position
	 *
	 * @author Christopher Bernjus, Mario Welzig
	 */
	public void seek(int position) {
		if(position < 0 || position > size) throw new IndexOutOfBoundsException("Invalid position: " + position);
		head = position;
	}

	/**
	 * @return The current read head position
	 *
	 * @author Christopher Bernjus, Mario Welzig
	 */
	public int position() {
		return head;
	}

	/**
	 * @param count
	 *          the number of bits to return
	 *
	 * @return The next {@code count} bits
	 *
	 * @author Christopher Bernjus, Mario Welzig
	 */
	public byte[] peekBits(int count) {
		if(head + count > size) throw new IndexOutOfBoundsException("Not enough bits remaining. (" + count + " requested, " + (size - head) + "available)");
		byte[] buffer = new byte[(count >> 3) + ((count & 7) != 0 ? 1 : 0)];
		BitUtil.copyBits(data, head, buffer, 0, count);
		return buffer;
	}

	/**
	 * Reads a number of Bits from the buffer and moves the read head forward accordingly
	 *
	 * @param count
	 *          the number of bits to return
	 *
	 * @return The next {@code count} bits
	 *
	 * @author Christopher Bernjus, Mario Welzig
	 */
	public byte[] readBits(int count) {
		byte[] buffer = peekBits(count);
		head += count;
		return buffer;
	}

	/**
	 * @return Reads a single bit from the buffer and moves the read head forward by one
	 *
	 * @author Chrsitopher Bernjus, Mario Welzig
	 */
	public Boolean readBit() {
		return readBits(1)[0] != 0;
	}

	/**
	 * Reads a number of bits and converts them to an integer
	 *
	 * @param length
	 *            The number of bits to consume
	 * @param signed
	 *            Whether to sign-extend the read value
	 *
	 * @return The converted integer value
	 *
	 * @author Christopher Bernjus, Mario Welzig
	 */
	public int readInt(int length, boolean signed) {
		int v = 0;
		byte[] bits = readBits(length);

		// stitch together int from bytes
		for(int i = 0; i < bits.length; i++) {
			v |= (((int) bits[i]) & 0xFF) << ((bits.length - i - 1) << 3);
		}

		if(signed && (v & (1 << (length - 1))) != 0) {
			// msb is set and the number is signed -> fill with leading ones
			v |= -1 << length;
		}

		return v >> ((8 - (length & 7)) & 7);
	}

	/**
	 * Reads a number of bits and converts them to a long
	 *
	 * @param length
	 *            The number of bits to consume
	 * @param signed
	 *            Whether to sign-extend the read value
	 *
	 * @return The converted long value
	 *
	 * @author Christopher Bernjus, Mario Welzig
	 */
	public long readLong(int length, boolean signed) {
		long v = 0;
		byte[] bits = readBits(length);

		// stitch together long from bytes
		for(int i = 0; i < bits.length; i++) {
			v |= (((int) bits[i]) & 0xFF) << ((bits.length - i - 1) << 3);
		}

		if(signed && (v & (1 << (length - 1))) != 0) {
			// msb is set and the number is signed -> fill with leading ones
			v |= -1L << length;
		}

		return v >> ((8 - (length & 7)) & 7);
	}

	@Override
	public String toString() {
		return BitUtil.format(data);
	}

}
