package ebd.messageLibrary.util.exception;

/**
 * Exception Indicating That The Field (Type) Does Not Support The Given Value
 *
 * @author Christopher Bernjus
 */
public class ValueNotSupportedException extends Exception {

	public ValueNotSupportedException() {}

	public ValueNotSupportedException(String msg) {
		super(msg);
	}

}