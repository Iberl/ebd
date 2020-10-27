package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation Used To Indicate The Number Of Bits Needed To Serialize The Field Or Class
 *
 * @author Christopher Bernjus
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BitLength {
	int value();
}
