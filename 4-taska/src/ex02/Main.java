package ex02;

import java.io.IOException;
import java.util.Scanner;

/**
 * Головний клас програми з фіксованим табличним форматом.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResultDataFactory factory;

        System.out.println("Оберіть тип відображення:");
        System.out.println("1 - Текстове відображення");
        System.out.println("2 - Таблиця (фіксовані стовпці)");
        System.out.print("Ваш вибір: ");
        int choice = scanner.nextInt();
        
        factory = (choice == 2) ? new TableResultFactory() : new ExtendedResultFactory();

        Calculator calculator = new Calculator(factory);
        System.out.print("\nВведіть десяткове число: ");
        int number = scanner.nextInt();
        calculator.addResult(number);

        System.out.println("\nРезультати:");
        calculator.displayResults();

        try {
            calculator.save();
            System.out.println("\n\t\t\t\t  --- Дані збережено ---");
            
            Calculator restoredCalc = new Calculator(factory);
            restoredCalc.restore();
            System.out.println("\nВідновлені дані:");
            restoredCalc.displayResults();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
        scanner.close();
    }
}