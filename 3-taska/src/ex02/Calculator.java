package ex02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Calculator {
    private static final String FILE_NAME = "data.ser";
    private ResultFormatter formatter;

    public Calculator(ResultFormatterFactory factory) {
        this.formatter = factory.createFormatter();
    }

    public void save() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Path.of(FILE_NAME)))) {
            oos.writeObject(ResultData.getHistory());
        }
    }

    public void restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Path.of(FILE_NAME)))) {
            List<ResultData> restored = (List<ResultData>) ois.readObject();
            ResultData.clearHistory();
            ResultData.getHistory().addAll(restored);
        }
    }

    public String getFormattedResults() {
        return formatter.formatAll(ResultData.getHistory());
    }
}
