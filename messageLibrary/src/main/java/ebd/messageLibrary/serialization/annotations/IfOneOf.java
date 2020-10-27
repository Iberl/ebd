package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.*;

/**
 * Annotation Resembling A Condition That Indicates Whether The Field Should Be Serialized <br>
 * True If The Value Of The Related Field Is Equal To One Of The Given Values
 *
 * @author Christopher Bernjus
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(IfOneOf.List.class)
public @interface IfOneOf {
	String field();
	int[] values();
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		IfOneOf[] value();
	}
}
