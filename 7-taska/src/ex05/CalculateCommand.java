package ex05;

/**
 *
 * @author sviatik-fedora
 */

public class CalculateCommand implements Command {
    private final DataProcessor processor;
    private final int number;

    public CalculateCommand(DataProcessor processor, int number) {
        this.processor = processor;
        this.number = number;
    }

    @Override
    public void execute() {
        processor.createResultData(number);
        System.out.println("Обчислено: " + number);
    }

    @Override
    public void undo() {
        System.out.println("Скасовано: " + number);
    }
}
