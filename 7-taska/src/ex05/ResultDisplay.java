package ex05;

/**
 *
 * @author sviatik-fedora
 */
public class ResultDisplay {

    private final DisplayType type;

    public ResultDisplay(DisplayType type) {
        this.type = type;
    }

    public void show(ResultData data) {
        switch (type) {
            case TABLE ->
                printTable(data);
            default ->
                printText(data);
        }
    }

    private void printTable(ResultData data) {
        System.out.printf("| %-15d | %-17s | 0x%-7s | %-10d |%n",
                data.getDecimalNumber(),
                data.getBinaryRepresentation(),
                data.getHexRepresentation(),
                data.getTransitionsCount());
    }

    private void printText(ResultData data) {
        System.out.println(data);
    }
}
