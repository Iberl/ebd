package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation Indicating That The Field Or Class Should Not Be Serialized
 *
 * @author Christopher Bernjus
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotToBeSerialized {
	boolean value() default true;
}
