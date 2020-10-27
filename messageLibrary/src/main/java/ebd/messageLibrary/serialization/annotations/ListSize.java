package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation Indicating The BitLength Of The List Size <br>
 * If Not Present The BitLength Is Defaulted To 5 Bits
 *
 * @author Christopher Bernjus
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListSize {
    int value();
}
