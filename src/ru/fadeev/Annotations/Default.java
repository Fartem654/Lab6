package ru.fadeev.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// Аннотация для указания типа класса или поля по умолчанию
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {

	/// Свойство для указания типа по умолчанию
	Class<?> value();
}
