package ex04;

public interface ResultDataFactory {
    ResultData createResultData(int number);
    ResultDisplay createResultDisplay();

    // Реалізації фабрик
    class BasicResultFactory implements ResultDataFactory {
        @Override
        public ResultData createResultData(int number) {
            return new ResultData(number);
        }

        @Override
        public ResultDisplay createResultDisplay() {
            return new ResultDisplay.TextResultDisplay();
        }
    }

    class ExtendedResultFactory implements ResultDataFactory {
        @Override
        public ResultData createResultData(int number) {
            return new ResultData.ExtendedResultData(number);
        }

        @Override
        public ResultDisplay createResultDisplay() {
            return new ResultDisplay.TextResultDisplay();
        }
    }

    class TableResultFactory implements ResultDataFactory {
        @Override
        public ResultData createResultData(int number) {
            return new ResultData.ExtendedResultData(number);
        }

        @Override
        public ResultDisplay createResultDisplay() {
            return new ResultDisplay.TableResultDisplay();
        }
    }
}
