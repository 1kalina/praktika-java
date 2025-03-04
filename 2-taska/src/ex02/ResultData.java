package ex02;

import java.io.Serializable;

/**
 * Клас для зберігання вхідного числа, його двійкового представлення та кількості чергувань 0 і 1.
 * @author sviatik-fedora
 */
public class ResultData implements Serializable 
{
    private static final long serialVersionUID = 1L;
    private final int decimalNumber;
    private transient String binaryRepresentation; // transient поле
    private int transitionsCount;

    public ResultData(int decimalNumber) 
    {
        this.decimalNumber = decimalNumber;
        calculateBinaryAndTransitions();
    }

    /**
     * Обчислює двійкове представлення та кількість чергувань.
     */
    private void calculateBinaryAndTransitions() 
    {
        if (decimalNumber == 0) 
        {
            binaryRepresentation = "0";
            transitionsCount = 0;
            return;
        }
        
        StringBuilder binary = new StringBuilder();
        int n = decimalNumber;
        while (n > 0) 
        {
            binary.insert(0, n % 2);
            n /= 2;
        }
        binaryRepresentation = binary.toString();
        
        // Підрахунок переходів
        transitionsCount = 0;
        char prev = binaryRepresentation.charAt(0);
        for (int i = 1; i < binaryRepresentation.length(); i++) 
        {
            char current = binaryRepresentation.charAt(i);
            if (current != prev) 
            {
                transitionsCount++;
                prev = current;
            }
        }
    }

    // Геттери
    public int getDecimalNumber() 
    {
        return decimalNumber;
    }

    public String getBinaryRepresentation() 
    {
        return (binaryRepresentation != null) ? binaryRepresentation : "N/A (transient)";
    }

    public int getTransitionsCount() 
    {
        return transitionsCount;
    }

    @Override
    public String toString() 
    {
        return String.format("Decimal: %d, Binary: %s, Transitions: %d",
                decimalNumber, getBinaryRepresentation(), transitionsCount);
    }
}