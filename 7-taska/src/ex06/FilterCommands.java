package ex06;

/**
 *
 * @author sviatik-fedora
 */

public class FilterCommands {

    // ... Інші існуючі фільтри (UnitsFilterCommand, TensFilterCommand, HundredsFilterCommand) ...

    public static class SingleDigitCount implements Runnable {
        private final int[] array;

        public SingleDigitCount(int[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            int count = 0;
            for (int num : array) {
                if (num >= 0 && num <= 9) count++;
            }
            System.out.println("single-digit numbers: " + formatResult(count));
        }
    }

    public static class DoubleDigitCount implements Runnable {
        private final int[] array;

        public DoubleDigitCount(int[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            int count = 0;
            for (int num : array) {
                if (num >= 10 && num <= 99) count++;
            }
            System.out.println("double-digit numbers: " + formatResult(count));
        }
    }

    public static class TripleDigitCount implements Runnable {
        private final int[] array;

        public TripleDigitCount(int[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            int count = 0;
            for (int num : array) {
                if (num >= 100 && num <= 999) count++;
            }
            System.out.println("triple-digit numbers: " + formatResult(count));
        }
    }

    private static String formatResult(int count) {
        return count > 0 ? "[" + count + "]" : "[none]";
    }
}