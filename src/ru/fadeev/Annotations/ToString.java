package ru.fadeev.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// Аннотация для обозначения полей которые нужно привести в строковый вид
/// ?если класс помечен анн-ей нужно ли не выводить все поля?
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {

	///  Свойство для обозначения вывода или не вывода
	Mode value() default Mode.YES;

	/// Перечисление доступных значений для аннотации toSting: YES, NO
	enum Mode {
		YES, NO
	}
}
