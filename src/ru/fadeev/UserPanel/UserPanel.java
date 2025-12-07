package ru.fadeev.UserPanel;


import static ru.fadeev.Classes.Handler.cacheHandler;
import static ru.fadeev.Classes.Handler.defaultHandler;
import static ru.fadeev.Classes.Handler.invokeHandler;
import static ru.fadeev.Classes.Handler.toStringForm;
import static ru.fadeev.Classes.Handler.twoHandler;
import static ru.fadeev.Classes.Handler.validateHandler;
import static ru.fadeev.UserPanel.CheckInput.inputInt;
import static ru.fadeev.UserPanel.CheckInput.inputIntRange;
import static ru.fadeev.UserPanel.CheckInput.inputString;

import ru.fadeev.Annotations.Default;
import ru.fadeev.Annotations.Invoke;
import ru.fadeev.Classes.CacheClass;
import ru.fadeev.Classes.DefaultClass;
import ru.fadeev.Classes.InvokeClass;
import ru.fadeev.Classes.TwoClass;
import ru.fadeev.Classes.ValidateClass;
import ru.fadeev.Classes.toStringClass;

/// Класс с методами для запуска заданий
public class UserPanel {


	private void t11() {
		System.out.println("Задание 1.1");

		InvokeClass asd = new InvokeClass();
		invokeHandler(asd);
		System.out.println();
	}


	private void t21() {
		System.out.println("Задание 1.2");

		DefaultClass def = new DefaultClass();
		defaultHandler(def);
		System.out.println();
	}

	private void t33() {
		System.out.println("Задание 1.3");

		toStringClass tstr = new toStringClass(inputString("Введите строковое значение поля: ", true), inputInt("Введите целочисленное значение поля: "), false);
		System.out.println(toStringForm(tstr));
		System.out.println();
	}

	private void t43() {
		System.out.println("Задание 1.4");
		System.out.println();
		System.out.println("Корректный класс с типами в аннотации Validate: ");
		validateHandler(ValidateClass.class);
		System.out.println();
		System.out.println("Аннотация без типов в аннотации Validate: ");
		validateHandler(Invoke.class);
		System.out.println();
		System.out.println("Аннотация без аннотации Validate: ");
		validateHandler(Default.class);
		System.out.println();
	}

	private void t57() {
		System.out.println("Задание 1.5");
		System.out.println("Вывод свойств аннотации Two: ");
		twoHandler(TwoClass.class);
		System.out.println();
	}

	private void t62() {
		System.out.println("Задание 1.6");
		cacheHandler(CacheClass.class);
		System.out.println();
	}

	public void choiceTask() {
		int task = 0;
		System.out.println("Выберите задание: ");
		System.out.println(
				"1 - Задание 1.1\n2 - Задание 1.2\n3 - Задание 1.3\n4 - Задание 1.4\n5 - Задание 1.5\n6 - Задание 1.6");
		task = inputIntRange("Введите номер задачи от 1 до 6: ", 0, 7);

		switch (task) {
			case 1:
				t11();
				break;
			case 2:
				t21();
				break;
			case 3:
				t33();
				break;
			case 4:
				t43();
				break;
			case 5:
				t57();
				break;
			case 6:
				t62();
		}
	}
}
