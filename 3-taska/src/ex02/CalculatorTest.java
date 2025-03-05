package ex02;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class CalculatorTest {
    @Test
    public void testHistory() {
        ResultData.clearHistory();
        new ResultData(5);
        new ResultData(10);
        List<ResultData> history = ResultData.getHistory();
        assertEquals(2, history.size());
        assertEquals(5, history.get(0).getDecimalNumber());
    }

    @Test
    public void testFormatter() {
        TextResultFormatter formatter = new TextResultFormatter();
        ResultData data = new ResultData(9);
        String expected = "Decimal: 9 | Binary: 1001 | Transitions: 2";
        assertEquals(expected, formatter.format(data));
    }

    @Test
    public void testSerialization() throws Exception {
        ResultData.clearHistory();
        new ResultData(9);
        Calculator calculator = new Calculator(new TextFormatterFactory());
        calculator.save();

        calculator.restore();
        List<ResultData> restored = ResultData.getHistory();
        assertEquals(1, restored.size());
        assertEquals(9, restored.get(0).getDecimalNumber());
    }
}