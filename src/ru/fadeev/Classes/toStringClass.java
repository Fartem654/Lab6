package ru.fadeev.Classes;

import ru.fadeev.Annotations.ToString;
import ru.fadeev.Annotations.ToString.Mode;

/// Класс для демонстрации работы аннотации ToString
@ToString
public class toStringClass {

	private String field1;

	@ToString
	public int field2;

	@ToString(Mode.NO)
	public boolean field3;

	/// Конструктор
	public toStringClass(String field1, int field2, boolean field3) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
}
