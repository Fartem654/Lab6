package ru.fadeev.Classes;

import ru.fadeev.Annotations.Validate;

/// Класс для демонстрации работы аннотации Validate с типами: Integer.class, String.class
@Validate({Integer.class, String.class})
public class ValidateClass {

	/// Метод для примера
	public void method() {
		System.out.println("Вызов method");
	}
}
