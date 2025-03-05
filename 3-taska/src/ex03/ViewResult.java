package ex03;

import ex02.Item2d;
import java.io.*;
import java.util.ArrayList;

/**
 * Клас для зберігання та відображення результатів (ConcreteProduct).
 */
public class ViewResult implements View {
    private static final String FNAME = "items.bin";
    private ArrayList<Item2d> items = new ArrayList<>();

    /** Додати результат до колекції */
    public void addItem(double x, double y) {
        items.add(new Item2d(x, y));
    }

    /** Ініціалізація даних */
    @Override
    public void viewInit() {
        items.clear();
        for (int i = 0; i < 5; i++) {
            double x = i * 90.0;
            double y = Math.sin(Math.toRadians(x));
            addItem(x, y);
        }
    }

    /** Збереження колекції */
    @Override
    public void viewSave() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FNAME))) {
            oos.writeObject(items);
        }
    }

    /** Відновлення колекції */
    @Override
    @SuppressWarnings("unchecked")
    public void viewRestore() throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FNAME))) {
            items = (ArrayList<Item2d>) ois.readObject();
        }
    }

    /** Відображення результатів */
    @Override
    public void viewShow() {
        viewHeader();
        for (Item2d item : items) {
            System.out.printf("x = %.1f, y = %.3f%n", item.getX(), item.getY());
        }
        viewFooter();
    }

    @Override
    public void viewHeader() {
        System.out.println("Результати:");
    }

    @Override
    public void viewFooter() {
        System.out.println("Кінець.");
    }

    // Геттер для тестів
    public ArrayList<Item2d> getItems() {
        return items;
    }
}