package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.*;

/**
 * Annotation Resembling A Condition That Indicates Whether The Field Should Be Serialized <br>
 * True If The Value Of The Related Field Is False
 *
 * @author Christopher Bernjus
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(IfFalse.List.class)
public @interface IfFalse {
	String value();
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		IfFalse[] value();
	}
}
