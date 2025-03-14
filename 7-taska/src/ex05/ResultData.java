package ex05;

/**
 *
 * @author sviatik-fedora
 */
import java.io.Serializable;

public final class ResultData implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int decimalNumber;
    private transient String binaryRepresentation;
    private int transitionsCount;

    public ResultData(int number) {
        this.decimalNumber = number;
        calculate();
    }

    private void calculate() {
        binaryRepresentation = Integer.toBinaryString(decimalNumber);
        transitionsCount = calculateTransitions(decimalNumber);
    }

    private int calculateTransitions(int n) {
        int count = 0;
        int prevBit = n & 1;
        while ((n >>= 1) != 0) {
            int currentBit = n & 1;
            if (currentBit != prevBit) {
                count++;
            }
            prevBit = currentBit;
        }
        return count;
    }

    // Геттери
    public int getDecimalNumber() {
        return decimalNumber;
    }

    public String getBinaryRepresentation() {
        return binaryRepresentation != null ? binaryRepresentation : "N/A";
    }

    public String getHexRepresentation() {
        return Integer.toHexString(decimalNumber);
    }

    public int getTransitionsCount() {
        return transitionsCount;
    }

    @Override
    public String toString() {
        return String.format("Decimal: %d | Binary: %s | Hex: 0x%s | Transitions: %d",
                decimalNumber, getBinaryRepresentation(), getHexRepresentation(), getTransitionsCount());
    }
}
