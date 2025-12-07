package ru.fadeev.Annotations;
import static ru.fadeev.UserPanel.CheckInput.inputInt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// Аннотация для указания первого строкового и второго целочисленного значения класса
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {

	/// Первое свойство аннотации Two
	String first();

	/// Второе свойство аннотации Two
	int second();
}
