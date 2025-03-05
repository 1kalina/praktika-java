package ex02;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultData implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int decimalNumber;
    private transient String binaryRepresentation;
    private int transitionsCount;
    private static List<ResultData> history = new ArrayList<>();

    public ResultData(int decimalNumber) {
        this.decimalNumber = decimalNumber;
        calculateBinaryAndTransitions();
        history.add(this);
    }

    private void calculateBinaryAndTransitions() {
        if (decimalNumber == 0) {
            binaryRepresentation = "0";
            transitionsCount = 0;
            return;
        }
        
        StringBuilder binary = new StringBuilder();
        int n = decimalNumber;
        while (n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        binaryRepresentation = binary.toString();
        
        transitionsCount = 0;
        char prev = binaryRepresentation.charAt(0);
        for (int i = 1; i < binaryRepresentation.length(); i++) {
            char current = binaryRepresentation.charAt(i);
            if (current != prev) {
                transitionsCount++;
                prev = current;
            }
        }
    }

    // Геттери
    public int getDecimalNumber() {
        return decimalNumber;
    }

    public String getBinaryRepresentation() {
        return (binaryRepresentation != null) ? binaryRepresentation : "N/A (transient)";
    }

    public int getTransitionsCount() {
        return transitionsCount;
    }

    public static List<ResultData> getHistory() {
        return new ArrayList<>(history);
    }

    public static void clearHistory() {
        history.clear();
    }
}
