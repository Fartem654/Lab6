package ru.fadeev.Classes;

import ru.fadeev.Annotations.Default;

/// Класс для демонстрации работы аннотации @Default с классом по умолчанию Integer
@Default(Integer.class)
public class DefaultClass {

	@Default(String.class)
	private String name;

	private boolean flag;
}
