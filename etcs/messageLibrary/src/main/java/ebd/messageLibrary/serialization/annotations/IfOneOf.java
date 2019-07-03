package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.*;

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
