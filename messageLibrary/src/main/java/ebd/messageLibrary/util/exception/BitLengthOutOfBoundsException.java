package ebd.messageLibrary.util.exception;

/**
 * Exception Indication That A Specified BitLength In Class Leads To An IndexOutOfBoundsException
 *
 * @author Christopher Bernjus
 */
public class BitLengthOutOfBoundsException extends Exception {

	public BitLengthOutOfBoundsException() {}

	public BitLengthOutOfBoundsException(String msg) {
		super(msg);
	}

}