package mac.mac;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelPrimeFinder {

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void findPrimes(int upperLimit) {
        long start = System.nanoTime();

        List<Integer> primes = IntStream.rangeClosed(2, upperLimit)
                .parallel()
                .filter(ParallelPrimeFinder::isPrime)
                .boxed()
                .toList();

        long end = System.nanoTime();
        System.out.println("Parallel: Found " + primes.size() + " primes in " + ((end - start) / 1_000_000) + " ms");
    }
}