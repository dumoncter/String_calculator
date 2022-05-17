/**
 * @created by Dmitriy Stanev
 * Калькулятор
 */
package CalculatorTest;

public class Calculator {
    static int calculations (int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+' -> {
                result = num1 + num2;
                System.out.println("Результат сложения: ");
            }
            case '-' -> {
                result = num1 - num2;
                System.out.println("Результат вычитания: ");
            }
            case '*' -> {
                result = num1 * num2;
                System.out.println("Результат умножения: ");
            }
            case '/' -> {
                result = num1 / num2;
                System.out.println("Результат деления: ");
            }
        }
        return result;
    }

}