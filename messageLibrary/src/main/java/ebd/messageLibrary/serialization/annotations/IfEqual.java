package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.*;

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
