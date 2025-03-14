package ex05;

public class ResultDisplay {
    private final DisplayType displayType;

    public ResultDisplay(DisplayType displayType) {
        this.displayType = displayType;
    }

    public void show(ResultData data) {
        switch (displayType) {
            case TABLE:
                printTable(data);
                break;
            case TEXT:
            default:
                printText(data);
        }
    }

    private void printText(ResultData data) {
        System.out.println("Результат:\n" + data);
    }

    private void printTable(ResultData data) {
        System.out.println("+-----------------+-------------------+-----------+------------+");
        System.out.println("| Десяткове       | Двійкове          | Шістнадц. | Переходи   |");
        System.out.println("+-----------------+-------------------+-----------+------------+");
        System.out.printf("| %-15d | %-17s | 0x%-7s | %-10d |\n",
            data.getDecimalNumber(),
            data.getBinaryRepresentation(),
            data.getHexRepresentation(),
            data.getTransitionsCount());
        System.out.println("+-----------------+-------------------+-----------+------------+");
    }
}
