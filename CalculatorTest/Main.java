/**
 * @created by Dmitriy Stanev
 * Калькулятор
 */
package CalculatorTest;

import java.util.Scanner;


public class Main {
    static int firstValue, secondValue, result;
    static char operation;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // while (true) {
        System.out.println("✔ Привет! Я умный калькулятор!\n👍 Введите ваше выражение: ");
        String input = scanner.nextLine();

        char[] charArray = new char[10];
        for (int i = 0; i < input.length(); i++) {
            charArray[i] = input.charAt(i);
            if (charArray[i] == '+') {
                operation = '+';
            }
            if (charArray[i] == '-') {
                operation = '-';
            }
            if (charArray[i] == '*') {
                operation = '*';
            }
            if (charArray[i] == '/') {
                operation = '/';
            }
        }


        String massCharString = String.valueOf(charArray);
        String[] ArrayStr = massCharString.split("[+-/*]");

        if (ArrayStr.length > 2) {
            throw new Exception("Формат математической операции не соответствует заданию - требуется два операнда и один оператор (+, -, *, /)");
        }

        if (ArrayStr.length < 2) {
            throw new Exception("Строка не является математической операцией");
        }


        String left = ArrayStr[0].trim();
        String right = ArrayStr[1].trim();


        firstValue = RomanNumb.romanToArabian(left);
        secondValue = RomanNumb.romanToArabian(right);


        if (firstValue == -1 && secondValue > -1 || secondValue == -1 && firstValue > -1) {
            throw new Exception("Используются одновременно разные системы счисления");
        }

        try {
            firstValue = Integer.parseInt(left);
            secondValue = Integer.parseInt(right);
        } catch (NumberFormatException e) {
            throw new Exception("Неверный формат строки. Введи римскую или арабскую цифру от 1 до 10");
        }
        if ((firstValue < 1) || (firstValue > 10) || (secondValue < 1) || (secondValue > 10)) {
            throw new Exception("Введено число вне диапазона значения. Допускается ввод цифр от 1 до 10");

        } else {
            result = Calculator.calculations(firstValue, secondValue, operation);
            System.out.println(result);
        }

        // }
    }
}
