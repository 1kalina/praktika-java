package ex06;

/**
 *
 * @author sviatik-fedora
 */

public class AvgCommand implements Runnable {
    private final int[] array;

    public AvgCommand(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        if (array.length == 0) {
            System.out.println("Average: Array is empty.");
            return;
        }
        double sum = 0;
        for (int num : array) sum += num;
        System.out.println("Average: " + (sum / array.length));
    }
}
