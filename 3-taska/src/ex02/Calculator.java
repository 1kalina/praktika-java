package ex01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Клас для обчислення кількості чергувань та серіалізації даних.
 * @author Student
 * @version 1.0
 */
public class Calculator {
    private static final String FILE_NAME = "data.ser";
    private ResultData resultData;

    public Calculator(int decimalNumber) {
        this.resultData = new ResultData(decimalNumber);
    }

    /**
     * Зберігає дані у файл.
     * @throws IOException якщо виникає помилка запису
     */
    public void save() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Path.of(FILE_NAME)))) {
            oos.writeObject(resultData);
        }
    }

    /**
     * Відновлює дані з файлу.
     * @throws IOException якщо файл не знайдено
     * @throws ClassNotFoundException якщо клас не знайдено
     */
    public void restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Path.of(FILE_NAME)))) {
            resultData = (ResultData) ois.readObject();
        }
    }

    // Геттер
    public ResultData getResultData() {
        return resultData;
    }
}