package ex06;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numbers = generateArray(10);
        System.out.println("Generated array: " + Arrays.toString(numbers));

        CommandQueue queue = new CommandQueue(3); // 3 worker threads
        
        queue.addCommand(new AvgCommand(numbers));
        queue.addCommand(new MinMaxCommand(numbers));
        queue.addCommand(new FilterCommands.SingleDigitCount(numbers));
        queue.addCommand(new FilterCommands.DoubleDigitCount(numbers));
        queue.addCommand(new FilterCommands.TripleDigitCount(numbers));

        queue.shutdown();
        try {
            queue.awaitTermination();
        } catch (InterruptedException e) {
        }
    }

    private static int[] generateArray(int size) {
        return new Random().ints(size, 0, 15).toArray();
    }
}
