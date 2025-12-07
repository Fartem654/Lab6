package ru.fadeev.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// Аннотация для указания методов, которые должны вызываться обработчиком
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Validate({})// 4
public @interface Invoke {

}
