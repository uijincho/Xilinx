package src.primes;
import java.util.ArrayList;

import java.util.List;



public class SequentialPrimeFinder {

	public static boolean isPrime(int number) {

		if (number <= 1) return false;

		if (number == 2) return true;

		if (number % 2 == 0) return false;

		for (int i = 3; i <= Math.sqrt(number); i += 2) {

			if (number % i == 0) return false;

		}

		return true;

	}

	static int primeCount = 0;

	static long compute(int upperLimit) {
		long start = System.nanoTime();

		List<Integer> primes = new ArrayList<>();

		for (int i = 2; i <= upperLimit; i++) {

			if (isPrime(i)) {

				primes.add(i);

			}

		}

		long end = System.nanoTime();

		primeCount = primes.size();

		return ((end - start) / 1_000_000);
	}

	public static long average(int count, int upperLimit) {
		long result = 0;
		for (int i = 0; i < count; i++) {
			result += compute(upperLimit);
		}

		result /= count;

		return result;
	}

	public static void main(String args[]) {
		int count = 100;
		int upperLimit = 1_000_000;

		long result = average(count, upperLimit);

		System.out.println("Sequential: Found " + primeCount + " primes " + count + " times, averaging " + result + " ms");
	}

}
