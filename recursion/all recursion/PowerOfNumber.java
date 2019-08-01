
public class PowerOfNumber {

	public static void main(String[] args) {

		int n = 31;
		System.out.println(returnPowerOfNum(n));
	}

	public static long returnPowerOfNum(int n) {
		int reverse = returnReverse(n);
		return powerModulo(n, reverse);
	}

	public static long powerModulo(int n, int r) {

		if (r == 0) {
			return 1;
		} 
		long temp = powerModulo(n, r / 2);
		if (r % 2 == 0) {
			long ans = temp * temp;
			return ans % (1000000000 + 7);
		} else {
			long ans = (temp * temp);
			long ans1=ans%(1000000000+7)*n%(1000000000+7);
			return ans1 % (1000000000 + 7);
		}

	}

	public static int returnReverse(int n) {

		int ans = 0;
		int temp = n;
		int digits = 0;
		while (temp != 0) {
			digits++;
			temp = temp / 10;
		}
		while (n != 0) {
			digits = digits - 1;
			int d = n % 10;
			ans += d * Math.pow(10, digits);
			n = n / 10;
		}
		return ans;

	}

}
