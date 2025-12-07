package ru.fadeev;

import static ru.fadeev.UserPanel.CheckInput.inputIntRange;

import ru.fadeev.UserPanel.UserPanel;

/// Главный класс проекта
public class Main {

	public static void main(String[] args) {

		UserPanel panel = new UserPanel();
		boolean panelCycle = true;
		int cycle;
		while (panelCycle) {
			panel.choiceTask();
			cycle = inputIntRange("Начать заново?\nДа- 1\nНет-0\n->", -1, 2);
			if (cycle == 1) {
				//Цикл продолжится
			} else {
				panelCycle = false;
			}
		}

	}
}