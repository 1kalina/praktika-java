package ex02;

/**
 * Фабрика для створення табличного відображення з фіксованою шириною.
 */
public class TableResultFactory implements ResultDataFactory {
    @Override
    public ResultData createResultData(int number) {
        return new ExtendedResultData(number);
    }

    @Override
    public ResultDisplay createResultDisplay() {
        return new TableResultDisplay();
    }
}