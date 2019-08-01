package InternQuestionDP;

public class Non_negative_Integers_without_Consecutive_Ones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.err.println(count(4)+" "+findIntegers(4));
	}

	public static int count(int n) {
		int a[] = new int[n];
		int b[] = new int[n];

		a[0] = 1;
		b[0] = 1;

		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}

		return a[n - 1] + b[n - 1];
	}

	public static int findIntegers(int num) {
		String s = new StringBuilder(Integer.toBinaryString(num)).reverse().toString();
		int n = s.length();

		int[] one = new int[n];
		int[] zero = new int[n];
		one[0] = zero[0] = 1;
		for (int i = 1; i < n; i++) {
			one[i] = zero[i - 1];
			zero[i] = zero[i - 1] + one[i - 1];
		}

		int res = zero[n - 1] + one[n - 1];
		for (int i = s.length() - 2; i >= 0; i--) {
			if (s.charAt(i) == '0' && s.charAt(i + 1) == '0')
				res -= one[i];
			else if (s.charAt(i) == '1' && s.charAt(i + 1) == '1')
				break;
		}
		return res;
	}
}
