package ex06;

/**
 *
 * @author sviatik-fedora
 */

public class MinMaxCommand implements Runnable {
    private final int[] array;

    public MinMaxCommand(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        if (array.length == 0) {
            System.out.println("Min/Max: Array is empty.");
            return;
        }
        int min = array[0];
        int max = array[0];
        for (int num : array) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        System.out.println("Min: " + min + "\nMax: " + max);
    }
}
