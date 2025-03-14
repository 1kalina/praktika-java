package ex05;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DataSerializer serializer = new DataSerializer();
            System.out.println("Оберіть формат відображення:");
            System.out.println("1 - текст, \n2 - таблиця:");
            System.out.print("Ваш вибір: ");
            DisplayType displayType = (scanner.nextInt() == 2) ? DisplayType.TABLE : DisplayType.TEXT;
            ResultManager manager = ResultManager.getInstance(displayType);
            System.out.print("Введіть число: ");
            ResultData data = manager.createResultData(scanner.nextInt());
            // Відображення
            manager.createResultDisplay().show(data);
            // Серіалізація
            try {
                serializer.save(data);
                System.out.println("\n\t\t\t --- Дані збережено ---");
                
                ResultData restoredData = serializer.restore();
                System.out.println("\nВідновлені дані:");
                manager.createResultDisplay().show(restoredData);
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Помилка: " + e.getMessage());
            }
        }    }
}
