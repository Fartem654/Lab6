package ru.fadeev.Classes;

import static ru.fadeev.UserPanel.CheckInput.inputInt;

import ru.fadeev.Annotations.Two;

/// Класс для демонстрации работы аннотации Two со свойствами first = "Первый", second = 1
@Two(first = "Первый", second = 1)
public class TwoClass {

	/// Метод для примера
	private void method() {
		System.out.println("Вызов method");
	}
}
