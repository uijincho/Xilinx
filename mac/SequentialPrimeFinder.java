package mac;
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

	public static void main(String args[]) {
		int upperLimit = 10000;
		long start = System.nanoTime();

		List<Integer> primes = new ArrayList<>();

		for (int i = 2; i <= upperLimit; i++) {

			if (isPrime(i)) {

				primes.add(i);

			}

		}

		long end = System.nanoTime();

		System.out.println("Sequential: Found " + primes.size() + " primes in " + ((end - start) / 1_000_000) + " ms");

	}

}
