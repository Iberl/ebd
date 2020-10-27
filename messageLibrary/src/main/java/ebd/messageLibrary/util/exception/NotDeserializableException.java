package ebd.messageLibrary.util.exception;

/**
 * Excpetion Indicating That The Deserializer Is Not Able To Deserialze The Given BitStream
 *
 * @author Christopher Bernjus
 */
public class NotDeserializableException extends Exception {

    public NotDeserializableException() {}

    public NotDeserializableException(String msg) {
        super(msg);
    }

}
