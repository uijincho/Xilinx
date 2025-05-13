import java.util.*;
import java.util.stream.Collectors;
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

    public static void main(String[] args) {
        int upperLimit = 100_000;
        
        List<Integer> primes = IntStream.rangeClosed(2, upperLimit)
                .parallel()
                .filter(ParallelPrimeFinder::isPrime)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Found " + primes.size() + " prime numbers up to " + upperLimit);

    }
}
