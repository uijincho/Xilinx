package mac;

import java.util.stream.LongStream;

public class PrimeNumberCounter {
	
    public static void main(String[] args) {
        var from = 2;
        var to = 100_000_000;
        var numberOfPrimes = countPrimesInRange(from, to);
		System.out.println("There are " + numberOfPrimes + " primes between " + from + " and " + to);
        
    }

    private static long countPrimesInRange(int from, int to) {
        var result = LongStream.range(from, to)
				.filter(number -> isPrime(number))
				.count();
        return result;
    }

	private static boolean isPrime(long number) {
		for (long factor = 2; factor * factor <= number; factor++) {
			if (number % factor == 0) { 
				return false; 
			}
		}
		return true;
	}

}
