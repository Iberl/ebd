package ebd.messageLibrary.util.exception;

/**
 * Excpetion Indicating That The Serializer Is Not Able To Serialze The Given Object
 *
 * @author Christopher Bernjus
 */
public class NotSerializableException extends Exception {

    public NotSerializableException() {}

    public NotSerializableException(String msg) {
        super(msg);
    }

}
