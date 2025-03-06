package ex02;

public class ExtendedResultFactory implements ResultDataFactory {
    @Override
    public ResultData createResultData(int number) {
        return new ExtendedResultData(number);
    }

    @Override
    public ResultDisplay createResultDisplay() {
        return new TextResultDisplay();
    }
}