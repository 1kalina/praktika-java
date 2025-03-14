package ex04;

import java.io.IOException;
import java.util.Scanner;

/**
 * Головний клас програми з фіксованим табличним форматом.
 * @author sviatik-fedora
 */
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResultDataFactory factory;

        System.out.println("Оберіть тип відображення:");
        System.out.println("1 - Текстове відображення");
        System.out.println("2 - Табличне відображення");
        System.out.print("Ваш вибір: ");
        int choice = scanner.nextInt();
        
        // Оновлення створення фабрик через вкладені класи
        if (choice == 2) {
            factory = new ResultDataFactory.TableResultFactory();
        } else {
            factory = new ResultDataFactory.ExtendedResultFactory(); // або BasicResultFactory, залежно від логіки
        }

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