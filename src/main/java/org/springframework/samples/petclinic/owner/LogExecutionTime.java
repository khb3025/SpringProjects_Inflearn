package org.springframework.samples.petclinic.owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 해당 어노테이션은 메소드에 사용할 것이다.
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
}
