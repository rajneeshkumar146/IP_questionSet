package pep_misc;

import java.util.HashMap;

public class rohans_love_for_matrix {
	
	static HashMap<Long, Long> map = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 3; // 8 => ans 21
		map.put((long) 0, (long) 1);
		map.put((long) 1, (long) 1);
		if (n == 0) {
			System.out.println("0");
		} else {
			System.out.println(fib(n - 1) % 1000000007);
		}
	}

	public static long fib(long n) {
		if (map.containsKey(n)) {
			return map.get(n);
		}
		long k = n / 2;
		long f;
		if (n % 2 == 0) { // n=2*k
			f = (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) % 1000000007;
		} else { // n=2*k+1
			f = (fib(k) * fib(k + 1) + fib(k - 1) * fib(k)) % 1000000007;
		}
		map.put(n, f);
		return f;
	}

}
