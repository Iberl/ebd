package ebd.messageLibrary.util.exception;

/**
 * Exception Indicating That The (De)Serializer Does Not Support The Given Class
 *
 * @author Christopher Bernjus
 */
public class ClassNotSupportedException extends Exception {

	public ClassNotSupportedException() {}

	public ClassNotSupportedException(String msg) {
		super(msg);
	}

}
