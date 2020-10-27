package ebd.messageLibrary.util.exception;

/**
 * Exception Indicating That The (De)Serializer Does Not Support The Given Field Type
 *
 * @author Christopher Bernjus
 */
public class FieldTypeNotSupportedException extends Exception {

	public FieldTypeNotSupportedException() {}

	public FieldTypeNotSupportedException(String msg) {
		super(msg);
	}

}