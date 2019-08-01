package pep_sns;

public class preimage_size_of_factorial_zeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(preimageSizeFZF(1));

	}

	public static int preimageSizeFZF(int k) {
		long lowerbound = bsearch(k, true);
		long upperbound = bsearch(k, false);
		if (upperbound != -1 && lowerbound != -1) {
			return (int) (upperbound - lowerbound + 1);
		} else {
			return 0;
		}
	}

	public static long bsearch(long k, boolean lower) {
		long low = 0;
		long high = (long) Math.pow(10, 15);
		long val = -1;
		while (low <= high) {
			long mid = low + (high - low) / 2;
			long zeroes = zeroes(mid);
			if (zeroes < k) {
				low = mid + 1;
			} else if (zeroes > k) {
				high = mid - 1;
			} else {
				val = mid;
				if (lower) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return val;
	}

	public static long zeroes(long n) {
		if (n == 0)
			return 0;
		long count = 0;
		for (long i = 5; n / i >= 1; i *= 5) {
			count += n / i;
		}
		return count;
	}
}
