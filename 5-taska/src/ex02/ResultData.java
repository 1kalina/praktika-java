package ex02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class ResultData implements Serializable {
    private static final long serialVersionUID = 1L;
    protected final int decimalNumber;
    protected transient String binaryRepresentation;
    protected int transitionsCount;
    
       private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        calculateBinaryAndTransitions(); // Важливо: перераховуємо транзитні поля
    }

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
        
        // Оптимізація: використання вбудованого методу для двійкового представлення
        binaryRepresentation = Integer.toBinaryString(decimalNumber);
        
        // Оптимізація підрахунку переходів за допомогою бітових операцій
        transitionsCount = 0;
        int prevBit = (decimalNumber & 1);
        int n = decimalNumber >> 1;
        while (n != 0) {
            int currentBit = (n & 1);
            if (currentBit != prevBit) {
                transitionsCount++;
            }
            prevBit = currentBit;
            n >>= 1;
        }
    }

    public String getHexRepresentation() {
        return Integer.toHexString(decimalNumber);
    }

    @Override
    public String toString() {
        return String.format("Decimal: %d | Binary: %s | Hex: 0x%s | Transitions: %d",
            decimalNumber, binaryRepresentation, getHexRepresentation(), transitionsCount);
    }

    // Геттери
    public int getDecimalNumber() {
        return decimalNumber;
    }

    public String getBinaryRepresentation() {
        return binaryRepresentation;
    }

    public int getTransitionsCount() {
        return transitionsCount;
    }
}
