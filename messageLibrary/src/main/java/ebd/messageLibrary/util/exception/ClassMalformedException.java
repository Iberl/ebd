package ebd.messageLibrary.util.exception;

/**
 * Exception Indicating Missing Annotations Or Fields In Class
 *
 * @author Christopher Bernjus
 */
public class ClassMalformedException extends Exception {

    public ClassMalformedException() {}

    public ClassMalformedException(String msg) {
        super(msg);
    }

}
