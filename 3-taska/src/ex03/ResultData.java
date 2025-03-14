package ex03;

import java.io.Serializable;

public class ResultData implements Serializable {
    private static final long serialVersionUID = 1L;
    protected final int decimalNumber;
    protected transient String binaryRepresentation;
    protected int transitionsCount;

    public ResultData(int decimalNumber) {
        this.decimalNumber = decimalNumber;
        calculateBinaryAndTransitions();
    }

    protected void calculateBinaryAndTransitions() {
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

    public int getDecimalNumber() {
        return decimalNumber;
    }

    public String getBinaryRepresentation() {
        return (binaryRepresentation != null) ? binaryRepresentation : "N/A (transient)";
    }

    public int getTransitionsCount() {
        return transitionsCount;
    }

    @Override
    public String toString() {
        return String.format("Decimal: %d, Binary: %s, Transitions: %d",
                decimalNumber, getBinaryRepresentation(), transitionsCount);
    }

    // Вкладений клас для ExtendedResultData
    public static class ExtendedResultData extends ResultData {
        public ExtendedResultData(int decimalNumber) {
            super(decimalNumber);
        }

        public String getHexRepresentation() {
            return Integer.toHexString(decimalNumber);
        }

        @Override
        public String toString() {
            return super.toString() + ", Hex: " + getHexRepresentation();
        }
    }
}
