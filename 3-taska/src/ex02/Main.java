package ex02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResultDataFactory factory = new ExtendedResultFactory(); // або BasicResultFactory
        Calculator calculator = new Calculator(factory);

        System.out.print("Введіть десяткове число: ");
        int number = scanner.nextInt();
        calculator.addResult(number);

        calculator.displayResults();

        try {
            calculator.save();
            System.out.println("-------------------");
            System.out.println("Дані збережено.");
            System.out.println("-------------------");
            
            calculator = new Calculator(factory);
            calculator.restore();
            System.out.println("\nВідновлені дані:");
            calculator.displayResults();
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}