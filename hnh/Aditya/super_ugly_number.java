package may28;

 

public class super_ugly_number {

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] primeIndex = new int[primes.length]; // Store index of each number
													// in primes
		int[] result = new int[n]; // Store ugly number from 1 ~ n
		result[0] = 1;

		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;

			// finding next ugly
			for (int j = 0; j < primeIndex.length; j++) {
				min = Math.min(min, result[primeIndex[j]] * primes[j]);
			}
			result[i] = min;

			// updating arrays with the ugly
			for (int j = 0; j < primeIndex.length; j++) {
				if (min == result[primeIndex[j]] * primes[j]) {
					primeIndex[j]++;
				}
			}
		}
		return result[n - 1];
	}

}
