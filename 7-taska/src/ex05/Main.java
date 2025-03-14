package ex05;

import java.util.Scanner;

/**
 *
 * @author sviatik-fedora
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DataProcessor processor = DataProcessor.getInstance(DisplayType.TEXT);
            Command.History history = new Command.History();
            Command.MacroCommand macro = new Command.MacroCommand();

            System.out.println("Оберіть формат відображення:");
            System.out.println("1 - текст, \n2 - таблиця:");
            System.out.print("Ваш вибір: ");
            DisplayType displayType = (scanner.nextInt() == 2) ? DisplayType.TABLE : DisplayType.TEXT;
            processor = DataProcessor.getInstance(displayType);

            while (true) {
                System.out.println("\n1 - Ввести число\n2 - Скасувати\n3 - Виконати макрокоманду\n4 - Вийти");
                System.out.print("Ваш вибір: ");
                int choice = scanner.nextInt();
                if (choice == 4) {
                    break;
                }

                switch (choice) {
                    case 1 -> {
                        System.out.print("Введіть число: ");
                        int number = scanner.nextInt();
                        Command cmd = new CalculateCommand(processor, number);
                        cmd.execute();
                        history.push(cmd);
                        macro.addCommand(cmd);
                        ResultData data = processor.createResultData(number);
                        processor.display(data);
                    }
                    case 2 -> {
                        if (!history.isEmpty()) {
                            history.pop().undo();
                        }
                    }
                    case 3 ->
                        macro.execute();
                }
            }
        }
    }
}
