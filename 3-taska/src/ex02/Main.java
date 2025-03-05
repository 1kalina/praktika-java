package ex02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResultFormatterFactory factory = new TextFormatterFactory();
        Calculator calculator = new Calculator(factory);

        System.out.print("Введіть десяткове число: ");
        int number = scanner.nextInt();
        new ResultData(number); // Автоматично додається до історії

        System.out.println("Результати:\n" + calculator.getFormattedResults());

        try {
            calculator.save();
            System.out.println("Дані збережено.");

            calculator.restore();
            System.out.println("Відновлені дані:\n" + calculator.getFormattedResults());
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
