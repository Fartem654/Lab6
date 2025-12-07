package ru.fadeev.Classes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import ru.fadeev.Annotations.Cache;
import ru.fadeev.Annotations.Default;
import ru.fadeev.Annotations.Invoke;
import ru.fadeev.Annotations.ToString;
import ru.fadeev.Annotations.ToString.Mode;
import ru.fadeev.Annotations.Two;
import ru.fadeev.Annotations.Validate;

/// Класс содержащий статические методы для обработки аннотаций
public class Handler {

	/// Обработчик, который находит методы, отмеченные аннотацией @Invoke, и вызывает их
	///
	/// @param obj объект класса, в котором нужно вызвать метод
	public static void invokeHandler(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Параметр obj не может быть null");
		}
		Class<?> clazz = obj.getClass();
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.isAnnotationPresent(Invoke.class)) {
				try {
					method.setAccessible(true);
					method.invoke(obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/// Обработчик, который выводит имя указанного класса по умолчанию
	///
	/// @param obj объект класса, в котором нужно узнать класс по умолчанию
	public static void defaultHandler(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Параметр obj не может быть null");
		}
		Class<?> clazz = obj.getClass();
		if (clazz.isAnnotationPresent(Default.class)) {
			Default annClass = clazz.getAnnotation(Default.class);
			System.out.println(
					"Класс '" + clazz.getSimpleName() + "' имеет тип по умолчанию: " + annClass.value()
							.getSimpleName());
		} else {
			System.out.println("Класс объекта не имеет типа по умолчанию");
		}

		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(Default.class)) {
				Default annField = field.getAnnotation(Default.class);
				System.out.println(
						"Поле '" + field.getName() + "' имеет тип по умолчанию: " + annField.value()
								.getSimpleName());
			}
		}
	}

	/// Метод, который формирует строковое представление объекта, учитывая только те поля, где
	/// `@ToString имеет значение YES.
	///
	/// @param obj объект класса, в котором нужно узнать класс по умолчанию
	public static String toStringForm(Object obj) {
		if (obj == null) {
			return "null";
		}

		String res = "";
		Class<?> clazz = obj.getClass();
		res += clazz.getSimpleName();

		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(ToString.class)) {
				ToString ann = field.getAnnotation(ToString.class);
				if (ann.value() == Mode.YES) {
					field.setAccessible(true);
					try {
						res += "\n" + field.getName() + " = " + field.get(obj);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}else{
				field.setAccessible(true);
				try {
					res += "\n" + field.getName() + " = " + field.get(obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	/// Обработчик, который выводит, какие классы указаны в аннотации.
	///
	/// @param clazz класс, в котором нужно вывести массив типов из аннотации
	public static void validateHandler(Class<?> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Параметр clazz не может быть null");
		}
		if (clazz.isAnnotationPresent(Validate.class)) {
			Validate ann = clazz.getAnnotation(Validate.class);
			Class<?>[] classes = ann.value();

			if (classes.length == 0) {
				System.out.println("Пустой массив в аннотации");
			} else {
				System.out.println("Типы в аннотации:");
				for (Class<?> clas : classes) {
					System.out.print(clas.getSimpleName() + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Класс не содержит аннотации @Validate.");
		}
	}

	/// Обработчик, который считывает и выводит значения свойств
	///
	/// @param clazz класс, в котором нужно вывести массив типов из аннотации
	public static void twoHandler(Class<?> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Параметр clazz не может быть null");
		}
		if (clazz.isAnnotationPresent(Two.class)) {
			String first = clazz.getAnnotation(Two.class).first();
			int second = clazz.getAnnotation(Two.class).second();
			System.out.println("First = " + first + "; Second = " + second);
		} else {
			System.out.println("Класс не содержит аннотации @Two");
		}
	}

	/// Обработчик, который выводит список всех кешируемых областей или сообщение, что
	/// список пуст.
	///
	/// @param clazz класс, в котором нужно вывести массив типов из аннотации
	public static void cacheHandler(Class<?> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Параметр clazz не может быть null");
		}
		if (clazz.isAnnotationPresent(Cache.class)) {
			String[] arr = clazz.getAnnotation(Cache.class).value();
			if (arr.length == 0) {
				System.out.println("Список пуст");
			} else {
				System.out.println("Кешируемые области:");
				for(String str: arr){
					System.out.println(str);
				}
			}
		} else {
			System.out.println("Класс не содержит аннотации @Cache");
		}
	}
}
