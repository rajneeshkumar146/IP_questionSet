package SnS;

public class pow {

	public static void main(String[] args) {
		System.out.println(myPow(2, -2));

	}

	public static double myPow(double x, int n) {
		double res = calcPow(x, n);
		if (n < 0) {
			return 1 / res;
		} else {
			return res;
		}
	}

	public static double calcPow(double x, int n) {
		if (n == 0) {
			return 1;
		}

		double res = calcPow(x, n / 2);
		if (n % 2 == 0) {
			return res * res;
		} else {
			return res * res * x;
		}
	}

}
