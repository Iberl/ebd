package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.*;

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
