package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(IfTrue.List.class)
public @interface IfTrue {
	String value();
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		IfTrue[] value();
	}
}
