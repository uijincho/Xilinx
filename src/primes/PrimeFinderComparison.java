package src.primes;

public class PrimeFinderComparison {
    public static void main(String[] args) {
        int count = 100;
        int upperLimit = 1_000_000;

        System.out.println("Initializing...");
        System.out.println("Running...");

        long par = ParallelPrimeFinder.average(count, upperLimit);

        System.out.println("Parallel Complete");

        long seq = SequentialPrimeFinder.average(count, upperLimit);

        System.out.println("Sequential Complete");

        long difference = seq - par; // assumes parallel is faster than sequential

        System.out.printf("=========================\nComparison Test, finding average of %d tests to find %d primes:%s", count, upperLimit, System.lineSeparator());
        System.out.println("\tSequential: " + seq + " ms");
        System.out.println("\tParallel: " + par + " ms");
        System.out.println("Difference: " + difference + " ms");
        System.out.println("\tParallel beats Sequential by " + difference + " ms\n=========================");

    }
}
