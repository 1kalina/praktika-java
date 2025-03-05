package ex02;

public interface ResultFormatterFactory {
    ResultFormatter createFormatter();
}

class TextFormatterFactory implements ResultFormatterFactory {
    @Override
    public ResultFormatter createFormatter() {
        return new TextResultFormatter();
    }
}
