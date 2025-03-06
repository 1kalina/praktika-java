package ex02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final String FILE_NAME = "data.ser";
    private List<ResultData> results = new ArrayList<>();
    private final ResultDataFactory factory;

    public Calculator(ResultDataFactory factory) {
        this.factory = factory;
    }

    public void addResult(int number) {
        results.add(factory.createResultData(number));
    }

    public void save() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Path.of(FILE_NAME)))) {
            oos.writeObject(results);
        }
    }

    @SuppressWarnings("unchecked")
    public void restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Path.of(FILE_NAME)))) {
            results = (List<ResultData>) ois.readObject();
        }
    }

    public List<ResultData> getResults() {
        return new ArrayList<>(results);
    }

    public void displayResults() {
        ResultDisplay display = factory.createResultDisplay();
        for (ResultData data : results) {
            display.display(data);
        }
    }
}