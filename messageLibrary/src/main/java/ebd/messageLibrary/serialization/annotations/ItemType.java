package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation Indicating The Class Of Elements In A List
 *
 * @author Christopher Bernjus
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemType {
	Class<?> value();
}
