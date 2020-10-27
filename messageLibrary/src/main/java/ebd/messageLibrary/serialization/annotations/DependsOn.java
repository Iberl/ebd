package ebd.messageLibrary.serialization.annotations;

import java.lang.annotation.*;

/**
 * Annotation Resembling A Condition That Indicates Whether The Field Should Be Serialized <br>
 * True If The Related Field Is Serialized
 *
 * @author Christopher Bernjus
 */
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
