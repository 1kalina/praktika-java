package ex03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Головний клас для взаємодії з користувачем.
 */
public class Main {
    private View view;

    public Main(View view) {
        this.view = view;
    }

    public void menu() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String command;
            do {
                System.out.println("Команди: q-вийти, v-перегляд, g-генерація, s-зберегти, r-відновити");
                command = reader.readLine();
                switch (command) {
                    case "q":
                        System.out.println("Вихід.");
                        break;
                    case "v":
                        view.viewShow();
                        break;
                    case "g":
                        view.viewInit();
                        view.viewShow();
                        break;
                    case "s":
                        view.viewSave();
                        System.out.println("Дані збережено.");
                        break;
                    case "r":
                        view.viewRestore();
                        System.out.println("Дані відновлено.");
                        break;
                    default:
                        System.out.println("Невідома команда.");
                }
            } while (!command.equals("q"));
        } catch (IOException | Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Main main = new Main(new ViewableResult().getView());
        main.menu();
    }
}