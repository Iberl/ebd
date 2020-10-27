package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.*;

/**
 * Annotation Resembling A Condition That Indicates Whether The Field Should Be Serialized <br>
 * True If The Given Value Equals The Value Of The Related Field
 *
 * @author Christopher Bernjus
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(IfEqual.List.class)
public @interface IfEqual {
	String field();
	int value();

	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		IfEqual[] value();
	}
}
