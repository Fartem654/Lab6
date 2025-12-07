package ru.fadeev.Classes;

import ru.fadeev.Annotations.Invoke;

/// Класс для демонстрации работы аннотации @Invoke
public class InvokeClass {

	/// Метод для примера с аннотацией Invoke
	@Invoke
	private void method1() {
		System.out.println("Вызов method1");
	}

	/// Метод для примера без аннотации Invoke
	public void method2() {
		System.out.println("Вызов method2");
	}

	/// Метод для примера с аннотацией Invoke
	@Invoke
	public void method3() {
		System.out.println("Вызов method3");
	}
}
