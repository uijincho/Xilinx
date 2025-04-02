package mac;
import java.util.*;

public class ParallelMAC {

    public static int compute(int[] x, int[] y) throws InterruptedException {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Input arrays must be the same length.");
        }

        final int[] result = {0}; 
        Thread[] threads = new Thread[x.length];
        final Object lock = new Object(); 

        for (int i = 0; i < x.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                int product = x[index] * y[index];
                synchronized (lock) {
                    result[0] += product;
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join(); 
        }

        return result[0];
    }

}