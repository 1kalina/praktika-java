package ex02;

public class ResultManager implements DataFactory {
    private static ResultManager instance;
    private final DisplayType displayType;

    private ResultManager(DisplayType displayType) {
        this.displayType = displayType;
    }

    public static ResultManager getInstance(DisplayType type) {
        if (instance == null) {
            instance = new ResultManager(type);
        }
        return instance;
    }

    @Override
    public ResultData createResultData(int number) {
        return new ResultData(number);
    }

    public ResultDisplay createResultDisplay() {
        return new ResultDisplay(displayType);
    }
}
