package june1;

import java.util.Arrays;
import java.util.HashSet;

public class PrimeNumberOfSetBits {

	public static void main(String[] args) {
		System.out.println(countPrimeSetBits(10, 15));
	}
	
	private static int countPrimeSetBits(int l, int r) {
        HashSet<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29 ));
        int count = 0;
        
        for (int i = l; i <= r; i++) {
            int bits = 0;
            for (int n = i; n > 0; n >>= 1)
                bits += n & 1;
            count += primes.contains(bits) ? 1 : 0;
        }
        
        return count;        
    }
}


