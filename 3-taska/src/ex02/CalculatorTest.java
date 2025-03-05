package ex01;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Тестування класу Calculator.
 * @author Student
 * @version 1.0
 */
public class CalculatorTest {
    @Test
    public void testTransitionsCount() {
        // Перевірка для числа 5 (101)
        Calculator calculator = new Calculator(5);
        assertEquals(2, calculator.getResultData().getTransitionsCount());
        
        // Перевірка для числа 7 (111)
        calculator = new Calculator(7);
        assertEquals(0, calculator.getResultData().getTransitionsCount());
        
        // Перевірка для числа 10 (1010)
        calculator = new Calculator(10);
        assertEquals(3, calculator.getResultData().getTransitionsCount());
    }
    
    @Test
    public void testSerialization() throws Exception {
        Calculator calculator = new Calculator(9);
        calculator.save();
        
        Calculator restoredCalculator = new Calculator(0);
        restoredCalculator.restore();
        
        assertEquals(9, restoredCalculator.getResultData().getDecimalNumber());
        assertEquals(2, restoredCalculator.getResultData().getTransitionsCount());
    }
}