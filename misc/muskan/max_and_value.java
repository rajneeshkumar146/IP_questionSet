package pep_misc;

public class max_and_value {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[] arr = { 4, 8, 12, 16 };
		int res = 0;
		int count;
		for (int b = 31; b >= 0; b--) {
			int mask = (res | (1 << b));
			count = countbits(arr, n, mask);
			if (count >= 2) {
				res = res | (1 << b);
			}
		}
		System.out.println(res);
	}

	public static int countbits(int[] arr, int n, int mask) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if ((arr[i] & mask) == mask) {
				count++;
			}
		}
		return count;
	}

}
