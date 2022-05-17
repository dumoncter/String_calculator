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
        System.out.println("✔ Привет! Я умный калькулятор!\n👍 Для выхода нажмите: e (rus-eng)\n😜 Введите ваше выражение: ");
        String input = scanner.nextLine().replaceAll("\\s+", "");
        if (input.equals("е") || input.equals("e")) {
            System.out.println("Завершение программы.");
            System.exit(0);
        }

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
            throw new Exception("Используются одновременно разные системы счисления (введите только арабские или только римские цифры) или введено римское число больше X");
        }

        if (firstValue < 0 && secondValue < 0) {
            result = 0;

        } else {
            result = Calculator.calculations(firstValue, secondValue, operation);
            if (result < 0 || result == 0) {
                throw new Exception("В римской системе нет отрицательных чисел");
            }
            String resultRoman = RomanNumb.ArabToRoman(result);
            System.out.println(resultRoman);
            return;
        }

        try {
            firstValue = Integer.parseInt(left);
            secondValue = Integer.parseInt(right);
        } catch (NumberFormatException e) {
            throw new Exception("Неверный формат строки. Введи римскую или арабскую цифру от 1 до 10");
        }
        if ((firstValue < 1) || (firstValue > 10) || (secondValue < 1) || (secondValue > 10)) {
            throw new Exception("Число вне диапазона. Допускается ввод цифр от 1 до 10");
        } else {
            result = Calculator.calculations(firstValue, secondValue, operation);
            System.out.println(result);
        }

        // }
    }
}
