package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(DependsOn.List.class)
public @interface DependsOn {
	String value();
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		DependsOn[] value();
	}
}
