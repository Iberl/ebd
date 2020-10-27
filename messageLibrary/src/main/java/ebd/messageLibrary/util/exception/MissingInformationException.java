package ebd.messageLibrary.util.exception;

/**
 * Exception Indicating That The Class Or Its Annotations Misses Some Crucial Information
 *
 * @author Christopher Bernjus
 */
public class MissingInformationException extends Exception {

	public MissingInformationException() {}

	public MissingInformationException(String msg) {
		super(msg);
	}

}