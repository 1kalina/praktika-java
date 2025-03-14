package ex06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sviatik-fedora
 */

public class CommandQueue {
    private final ExecutorService executor;

    public CommandQueue(int nThreads) {
        executor = Executors.newFixedThreadPool(nThreads);
    }

    public void addCommand(Runnable command) {
        executor.execute(command);
    }

    public void shutdown() {
        executor.shutdown();
    }

    public void awaitTermination() throws InterruptedException {
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
}
