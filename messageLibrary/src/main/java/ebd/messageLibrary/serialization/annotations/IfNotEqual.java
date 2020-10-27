package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.*;

/**
 * Annotation Resembling A Condition That Indicates Whether The Field Should Be Serialized <br>
 * True If The Given Value Does Not Equal The Value Of The Related Field
 *
 * @author Christopher Bernjus
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(IfNotEqual.List.class)
public @interface IfNotEqual {
	String field();
	int value();

	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		IfNotEqual[] value();
	}
}
