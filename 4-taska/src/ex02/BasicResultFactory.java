package ex02;

public class BasicResultFactory implements ResultDataFactory {
    @Override
    public ResultData createResultData(int number) {
        return new ResultData(number);
    }

    @Override
    public ResultDisplay createResultDisplay() {
        return new TextResultDisplay();
    }
}