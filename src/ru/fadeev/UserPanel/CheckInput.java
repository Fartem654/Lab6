package ru.fadeev.UserPanel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CheckInput {

	static Scanner in = new Scanner(System.in);

	// INT

	/**
	 * Ввод целого числа с клавиатуры.
	 *
	 * @param inputMessage пользовательское сообщение для ввода числа
	 */
	static public int inputInt(String inputMessage) {
		boolean isInt = false;

		int result = 0;

		while (!isInt) {
			System.out.print(inputMessage);
			try {
				result = in.nextInt();
				isInt = true;
			} catch (InputMismatchException error) {
				System.out.println("Ошибка: введено не целое число.");
				in.next();
			}
		}
		return result;
	}

	/**
	 * Ввод целого числа с клавиатуры.
	 *
	 */
	static public int inputInt() {
		return inputInt("Введите целое число: ");
	}

	/**
	 * Ввод целого числа в диапазоне, не включительно
	 *
	 * @param inputMessage пользовательское сообщение для ввода числа
	 */
	static public int inputIntRange(String inputMessage, int min, int max) {
		boolean isInt = false;

		int result = 0;

		while (!isInt) {
			System.out.print(inputMessage);
			try {
				result = in.nextInt();
				if (result > +min && result < +max) {
					isInt = true;
				} else {
					System.out.printf("Число %d не попадает в диапазон от %d до %d\n", result, min + 1,
							max - 1);
				}
			} catch (InputMismatchException error) {
				System.out.println("Ошибка: введено не целое число.");
				in.next();
			}
		}
		return result;
	}

	/**
	 * Ввод целого числа с ограничением слева, не включительно
	 *
	 * @param errorRangeMessage пользовательское сообщение о нарушении минимальной границы
	 */
	static public int inputIntRangeMin(String inputMessage, String errorRangeMessage, int min) {
		boolean isInt = false;

		int result = 0;

		while (!isInt) {
			System.out.print(inputMessage);
			try {
				result = in.nextInt();
				if (result > min) {
					isInt = true;
				} else {
					System.out.printf(errorRangeMessage + "\n", min);
				}
			} catch (InputMismatchException error) {
				System.out.println("Ошибка: введено не целое число.");
				in.next();
			}
		}
		return result;
	}

	/**
	 * Ввод целого числа с ограничением слева, не включительно
	 *
	 */
	static public int inputIntRangeMin(String inputMessage, int min) {
		return inputIntRangeMin(inputMessage, "Вводимое число не должно быть меньше или равно %d", min);
	}

	static public int inputIntRangeMax(String inputMessage, int max) {
		boolean isInt = false;

		int result = 0;

		while (!isInt) {
			System.out.print(inputMessage);
			try {
				result = in.nextInt();
				if (result < max) {
					isInt = true;
				} else {
					System.out.printf("Вводимое число не должно быть Больше %d\n", max);
				}
			} catch (InputMismatchException error) {
				System.out.println("Ошибка: введено не целое число.");
				in.next();
			}
		}
		return result;
	}

	//INT LIST

	static public List<Integer> inputListInt(String inputMessage) {
		System.out.println(inputMessage);
		int len = inputIntRangeMin("Введите количество элементов: ",
				"Длинна списка не может быть меньше %d!", 0);
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= len; i++) {
			result.add(inputInt("Введите " + i + "-ый элемент - число: "));
		}
		return result;
	}

	static public List<Integer> inputListIntUp(String inputMessage) {
		System.out.println(inputMessage);
		int len = inputIntRangeMin("Введите количество элементов: ",
				"Длинна списка не может быть меньше %d!", 0);
		List<Integer> result = new ArrayList<>();
		int minPrev;
		for (int i = 1; i <= len; i++) {
			minPrev = i == 1 ? Integer.MIN_VALUE : (result.get(i - 2)-1);
			result.add(inputIntRangeMin("Введите " + i + "-ый элемент - число: ",
					"Число должно быть больше или равно предыдущему: " + (minPrev+1), minPrev));
		}
		return result;
	}

	//LIST INT ARRAY

	static public List<int[]> createListIntArray(String inputMessage) {
		System.out.println(inputMessage);
		int len = inputIntRangeMin("Введите количество элементов: ",
				"Длинна списка не может быть меньше %d!", 0);
		List<int[]> result = new ArrayList<>();
		for (int i = 1; i <= len; i++) {
			result.add(createArrInt("Введите " + i + "-ый элемент - массив: "));
			System.out.println();
		}
		return result;
	}

	//LIST LIST INT

	static public List<List<Integer>> createListListInt(String inputMessage) {
		System.out.println(inputMessage);
		int len = inputIntRangeMin("Введите количество элементов: ",
				"Длинна списка не может быть меньше %d!", 0);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 1; i <= len; i++) {
			result.add(inputListInt("Введите " + i + "-ый элемент - список: "));
			System.out.println();
		}
		return result;
	}

	//INT ARRAY

	/**
	 * Создание целочисленного массива
	 */
	static public int[] createArrInt(String message) {
		System.out.println(message);
		int len = inputIntRangeMin("Введите длину массива: ", "Длинна массива не может быть меньше %d!",
				0);
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = inputInt("Введите " + (i + 1) + "-ый элемент массива: ");
		}
		return arr;
	}

	static public int[] createArrIntRange(String message, int min, int max) {
		System.out.println(message);
		int len = inputIntRangeMin("Введите длину массива: ", "Длинна массива не может быть меньше %d!",
				0);
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = inputIntRange("Введите " + (i + 1) + "-ый элемент массива: ", min, max);
		}
		return arr;
	}

	static public int[] createArrInt() {
		return createArrInt("Создание массива: ");
	}

	static public int[] createArrIntRange(int min, int max) {
		return createArrIntRange("Создание массива с ограничениями на элементы: ", min, max);
	}

	//DOUBLE

	/**
	 * Ввод дробного числа
	 *
	 * @param inputMessage пользовательское сообщение для ввода числа
	 */
	static public double inputDouble(String inputMessage) {
		boolean isDouble = false;

		double result = 0;

		while (!isDouble) {
			System.out.print(inputMessage);
			try {
				result = in.nextDouble();
				isDouble = true;
			} catch (InputMismatchException error) {
				System.out.println(
						"Ошибка: введено не число.\nИспользуйте ',', чтобы отделить целую часть.");
				in.next();
			}
		}
		return result;
	}

	//CHAR

	/**
	 * Ввод символа-цифры
	 */
	static public char inputCharDigit() {
		boolean isDigit = false;

		char result = 0;

		while (!isDigit) {
			System.out.print("Вводимый символ должен представлять собой один из “0 1 2 3 4 5 6 7 8 9”\n");

			result = in.next().charAt(0);
			if ((int) result >= 48 && (int) result <= 57) {
				isDigit = true;
			}
		}
		return result;
	}

	//STRING
	static public String inputString(String inputMessage, boolean usePassStr) {
		if (usePassStr) {
			passStr();
		}
		String result;
		System.out.print(inputMessage);
		result = in.nextLine();
		return result;
	}

	static public String inputStringMinLen(String inputMessage, int minLen, boolean usePassStr) {
		if (usePassStr) {
			passStr();
		}
		String result;
		do {
			System.out.print(inputMessage);
			result = in.nextLine();
		} while (result.length() < minLen);
		return result;
	}

	static void passStr() {
		in.nextLine();
	}

	//STRING LIST

	static public List<String> inputListString(String inputMessage) {
		System.out.println(inputMessage);
		int len = inputIntRangeMin("Введите количество элементов: ",
				"Длинна списка не может быть меньше %d!", 0);
		List<String> result = new ArrayList<>();
		passStr();
		for (int i = 1; i <= len; i++) {
			result.add(inputString("Введите " + i + "-ый элемент - строку: ", false));
		}
		return result;
	}

	static public List<String> inputListStringUp(String inputMessage) {
		System.out.println(inputMessage);
		int len = inputIntRangeMin("Введите количество элементов: ",
				"Длинна списка не может быть меньше %d!", 0);
		List<String> result = new ArrayList<>();
		int minPrev;
		for (int i = 1; i <= len; i++) {
			minPrev = i == 1 ? 1 : result.get(i - 2).length();
			result.add(inputStringMinLen(
					"Введите " + i + "-ый элемент - число длиной не меньше " + minPrev + ": ", minPrev,
					false));
		}
		return result;
	}




}
