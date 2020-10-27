package ebd.messageLibrary.util;

/**
 * Class Containing Functions For Bitwise Operations
 *
 * @author Christopher Bernjus
 */
public class BitUtil {

	/**
	 * Copies bits {@code src}[{@code srcOffset}..{@code srcOffset} + {@code count}] to {@code dst}[{@code dstOffset}..{@code dstOffset} + {@code count}]
	 *
	 * @param src
	 *            Byte array containing the source bits
	 * @param srcOffset
	 *            Index of the first bit to copy
	 * @param dst
	 *            Byte array containing the destination bits
	 * @param dstOffset
	 *            Index of the first bit to overwrite
	 * @param count
	 *            Number of bits to copy
	 *
	 * @throws IllegalArgumentException
	 * @throws IndexOutOfBoundsException
	 *
	 * @author Christopher Bernjus
	 */
	public static void copyBits(byte[] src, int srcOffset, byte[] dst, int dstOffset, int count) {
		if(count < 0) {
			throw new IllegalArgumentException("Count must be positive.");
		}
		if(src == null || src.length <= 0 || dst == null || dst.length <= 0) {
			throw new IllegalArgumentException("Source and destination arrays can not be null or empty.");
		}
		if(srcOffset < 0 || byteIndex(srcOffset) >= src.length || byteIndex(srcOffset + count - 1) >= src.length) {
			throw new IndexOutOfBoundsException("Invalid source array offset.");
		}
		if(dstOffset < 0 || byteIndex(dstOffset) >= dst.length || byteIndex(dstOffset + count - 1) >= dst.length) {
			throw new IndexOutOfBoundsException("Invalid destination array offset.");
		}

		int offset = 0;

		while(offset < count) {

			// global indices for current bit
			int srcIndex = srcOffset + offset;
			int dstIndex = dstOffset + offset;

			// index of current bit in containing byte
			int srcBitIndex = bitIndex(srcIndex);
			int dstBitIndex = bitIndex(dstIndex);

			// remaining bits till end of byte with current bit
			int remainingSrcBits = 8 - srcBitIndex;
			int remainingDstBits = 8 - dstBitIndex;

			// number of bits to copy into current byte
			int copyBits = min(remainingSrcBits, remainingDstBits, count - offset);

			// buffer src byte with bits to copy
			byte buffer = src[byteIndex(srcIndex)];

			// truncate right side
			buffer >>= 8 - srcBitIndex - copyBits;

			// truncate left side
			buffer &= (255 >> (8 - copyBits));

			// align to dstIndex
			buffer <<= 8 - dstBitIndex - copyBits;

			// write buffer to dst byte index
			dst[byteIndex(dstIndex)] |= buffer;

			// increment offset by number of copied bits
			offset += copyBits;
		}
	}

	/**
	 * @param byteIndex
	 *            Index of the byte within the buffer
	 *
	 * @return Index of the byte's first bit within the buffer
	 *
	 * @author Christopher Bernjus
	 */
	public static int byteOffset(int byteIndex) {
		return byteIndex << 3;
	}

	/**
	 * @param globalBitIndex
	 *            Index of the bit within the buffer
	 *
	 * @return Index of the containing byte within the buffer
	 *
	 * @author Christopher Bernjus
	 */
	public static int byteIndex(int globalBitIndex) {
		return globalBitIndex >> 3;
	}

	/**
	 * @param globalBitIndex
	 *            Index of the bit within the buffer
	 *
	 * @return Index of the bit in containing byte within the buffer
	 *
	 * @author Christopher Bernjus
	 */
	public static int bitIndex(int globalBitIndex) {
		return globalBitIndex & 7;
	}

	/**
	 * @param globalBitIndex
	 *            Index of the bit within the buffer
	 *
	 * @return A byte with the bit at bitIndex(index) set to 1
	 *
	 * @author Christopher Bernjus
	 */
	public static int bitMask(int globalBitIndex) {
		return 1 << (7 - bitIndex(globalBitIndex));
	}

	/**
	 * @param numberOfBits
	 * 			  Number of bits to store in bytes
	 *
	 * @return Number of bytes necessary to hold given number of bits
	 *
	 * @author Christopher Bernjus
	 */
	public static int byteCount(int numberOfBits) { return byteIndex(numberOfBits) + ((numberOfBits & 7) != 0 ? 1 : 0); }

	/**
	 * @param number
	 * 			  Number to be stored in byte array
	 *
	 * @return Number of trailing bits in byte array containing the given number
	 *
	 * @author Christopher Bernjus
	 */
	public static int trailBits(int number) { return (8 - (number & 7)) & 7; }

	/**
	 * @param values
	 *            List of at least one integer
	 *
	 * @return Minimum value of the given values
	 *
	 * @author Christopher Bernjus
	 */
	public static int min(int... values) {
		int min = values[0];
		for(int i = 1; i < values.length; i++) {
			if(values[i] < min) min = values[i];
		}
		return min;
	}

	/**
	 * @param values
	 *            List of at least one integer
	 *
	 * @return Maximum value of the given values
	 *
	 * @author Christopher Bernjus
	 */
	public static int max(int... values) {
		int max = values[0];
		for(int i = 1; i < values.length; i++) {
			if(values[i] > max) max = values[i];
		}
		return max;
	}

	/**
	 * @param bytes
	 *            The byte array to format
	 *
	 * @return The binary string representation of each byte, separated by spaces
	 *
	 * @author Christopher Bernjus
	 */
	public static String format(byte[] bytes) {
		String[] parts = new String[bytes.length];
		for(int i = 0; i < bytes.length; i++) {
			String s = Integer.toBinaryString((int) bytes[i] & 0xFF);
			parts[i] = "00000000".substring(s.length()) + s;
		}
		return String.join(" ", parts);
	}
}
