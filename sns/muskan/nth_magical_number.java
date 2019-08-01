package pep_sns;

public class nth_magical_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4;
		int A = 2;
		int B = 3;
		System.out.println(nthMagicalNumber(N, A, B));
	}

	public static int nthMagicalNumber(int N, int A, int B) {
		int mod = (int) Math.pow(10, 9) + 7;
		int lcm = (A * B) / gcd(A, B);
		long low = 0;
		long high = (long) Math.pow(10, 15);
		while (low < high) {
			long mid = (low + high) / 2;
			if (mid / A + mid / B - mid / lcm < N) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return (int) (low % mod);
	}

	public static int gcd(int A, int B) {
		if (A == 0) {
			return B;
		}
		return gcd(B % A, A);
	}

}
