package ex01;

import java.util.Scanner;

/**
 * Головний клас для взаємодії з користувачем.
 * @author Student
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть десяткове число: ");
        int number = scanner.nextInt();
        
        Calculator calculator = new Calculator(number);
        System.out.println("Результат: " + calculator.getResultData());
        
        try {
            calculator.save();
            System.out.println("Дані збережено.");
            
            // Зміна числа для демонстрації відновлення
            calculator = new Calculator(0);
            calculator.restore();
            System.out.println("Відновлені дані: " + calculator.getResultData());
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}