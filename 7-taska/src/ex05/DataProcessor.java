package ex05;

import java.io.*;

/**
 *
 * @author sviatik-fedora
 */
public class DataProcessor {
    private static final String SAVE_FILE = "data.ser";
    private static DataProcessor instance;
    private DisplayType displayType;

    private DataProcessor(DisplayType displayType) {
        this.displayType = displayType;
    }

    public static synchronized DataProcessor getInstance(DisplayType type) {
        if (instance == null) {
            instance = new DataProcessor(type);
        } else {
            instance.displayType = type;
        }
        return instance;
    }

    public ResultData createResultData(int number) {
        return new ResultData(number);
    }

    public void save(ResultData data) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            oos.writeObject(data);
        }
    }

    public ResultData restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            return (ResultData) ois.readObject();
        }
    }

    public void display(ResultData data) {
        new ResultDisplay(displayType).show(data);
    }
}
