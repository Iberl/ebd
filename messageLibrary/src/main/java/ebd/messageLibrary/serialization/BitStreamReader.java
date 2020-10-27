package ebd.messageLibrary.serialization;

import ebd.messageLibrary.util.BitUtil;

/**
 * Class for reading from a byte array buffer
 *
 * @author Christopher Bernjus
 */
public class BitStreamReader {

    /** Data buffer to read from */
    private byte[] data;

    /** Number of Bits currently stored in buffer */
    private int    size;

    /** Current write head position */
    private int    head;


    // Constructors

    /**
     * Constructs a new {@link BitStreamReader} from an existing buffer
     *
     * @param data
     *         the data from which the {@link BitStreamReader} will be created
     * @param size
     *         size of needed buffer for given data
     *
     * @author Christopher Bernjus
     */
    public BitStreamReader(byte[] data, int size) {
        this.data = data;
        this.size = size;
    }


    // Methods

    /**
     * Repositions the read head
     *
     * @param position
     *         the new read head position
     *
     * @author Christopher Bernjus
     */
    public void seek(int position) {
        if(position < 0 || position > size) throw new IndexOutOfBoundsException("Invalid position: " + position);
        head = position;
    }

    /**
     * Reads a number of Bits from the buffer and moves the read head forward accordingly
     *
     * @param count
     *         the number of bits to return
     *
     * @return The next {@code count} bits
     *
     * @throws IndexOutOfBoundsException
     *
     * @author Christopher Bernjus
     */
    public byte[] readBits(int count) {
        if(count == 0) return new byte[0];
        if(head + count > size) {
            throw new IndexOutOfBoundsException("Not enough bits remaining. (" + count + " requested, " + (size - head) + " available)");
        }
        byte[] buffer = new byte[(count >> 3) + ((count & 7) != 0 ? 1 : 0)];
        BitUtil.copyBits(data, head, buffer, 0, count);
        head += count;
        return buffer;
    }

    /**
     * Reads a number of Bits from the buffer, but don't move head
     *
     * @param count
     *         the number of bits to return
     *
     * @return The next {@code count} bits
     *
     * @throws IndexOutOfBoundsException
     *
     * @author Christopher Bernjus
     */
    public byte[] peekBits(int count) {
        int    currHead = head;
        byte[] buffer   = readBits(count);
        seek(currHead);
        return buffer;
    }

    /**
     * @return Reads a single bit from the buffer and moves the read head forward by one
     *
     * @throws IndexOutOfBoundsException
     *
     * @author Chrsitopher Bernjus
     */
    public Boolean readBit() {
        return readBits(1)[0] != 0;
    }

    /**
     * @return Reads a single bit from the buffer and moves the read head forward by one
     *
     * @throws IndexOutOfBoundsException
     *
     * @author Chrsitopher Bernjus
     */
    public Boolean peekBit() {
        return peekBits(1)[0] != 0;
    }

    /**
     * Reads a number of bits and converts them to an integer
     *
     * @param length
     *         The number of bits to consume
     * @param signed
     *         Whether to sign-extend the read value
     *
     * @return The converted integer value
     *
     * @throws IndexOutOfBoundsException
     *
     * @author Christopher Bernjus
     */
    public int readInt(int length, boolean signed) {
        if(length < 0 || length > 32) throw new IllegalArgumentException("Invalid length value");
        int    v    = 0;
        byte[] bits = readBits(length);

        // stitch together int from bytes
        for(int i = 0; i < bits.length; i++) {
            // shift byte to appropriate index with zero extend
            v |= (((int) bits[i]) & 0xFF) << ((bits.length - i - 1) << 3);
        }

        if(signed && (v & (1 << (length - 1))) != 0) {
            // msb is set and the number is signed -> fill with leading ones
            v |= -1 << ((length == 32) ? length - 1 : length);
        }

        // shift out trailing filler bits if length is not a multiple of 8
        return v >>> ((8 - (length & 7)) & 7);
    }

    /**
     * Peeks a number of bits and converts them to an integer
     *
     * @param length
     *         The number of bits to consume
     * @param signed
     *         Whether to sign-extend the read value
     *
     * @return The converted integer value
     *
     * @throws IndexOutOfBoundsException
     *
     * @author Christopher Bernjus
     */
    public int peekInt(int length, boolean signed) {
        int currHead = head;
        int value    = readInt(length, signed);
        seek(currHead);
        return value;
    }

    /**
     * Reads a number of bits and converts them to a long
     *
     * @param length
     *         The number of bits to consume
     * @param signed
     *         Whether to sign-extend the read value
     *
     * @return The converted long value
     *
     * @throws IndexOutOfBoundsException
     *
     * @author Christopher Bernjus
     */
    public long readLong(int length, boolean signed) {
        if(length < 0 || length > 64) throw new IllegalArgumentException("Invalid length value");
        long   v    = 0;
        byte[] bits = readBits(length);

        // stitch together long from bytes
        for(int i = 0; i < bits.length; i++) {
            // shift byte to appropriate index with zero extend
            v |= (((long) bits[i]) & 0xFF) << ((bits.length - i - 1) << 3);
        }

        if(signed && (v & (1L << (length - 1))) != 0) {
            // msb is set and the number is signed -> fill with leading ones
            v |= -1L << ((length == 64) ? length - 1 : length);
        }

        // shift out trailing filler bits if length is not a multiple of 8
        return v >>> ((8 - (length & 7)) & 7);
    }

    /**
     * Peeks a number of bits and converts them to a long
     *
     * @param length
     *         The number of bits to consume
     * @param signed
     *         Whether to sign-extend the read value
     *
     * @return The converted long value
     *
     * @throws IndexOutOfBoundsException
     *
     * @author Christopher Bernjus
     */
    public long peekLong(int length, boolean signed) {
        int  currHead = head;
        long value    = readLong(length, signed);
        seek(currHead);
        return value;
    }


    // Getter, Setter

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
        return BitUtil.format(data);
    }

}
