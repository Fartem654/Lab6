package ru.fadeev.Classes;

import ru.fadeev.Annotations.Cache;

/// Класс для демонстрации работы аннотации Cache с областями  {"area1", "area2", "area3"}
@Cache({"area1", "area2", "area3"})
public class CacheClass {

	/// Метод для примера
	private void method() {
		System.out.println("Вызов method");
	}
}
