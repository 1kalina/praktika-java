package ex05;

import java.io.*;

public class DataSerializer {
    private static final String SAVE_FILE = "data.ser";

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
}
