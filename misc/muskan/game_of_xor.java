package pep_misc;

public class game_of_xor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 4;
		int[] arr1 = {1,2,3,4};
		int n2 = 3;
		int[] arr2 = {1,2,3};
		System.out.println(xorgame(arr1, n1));
		System.out.println(xorgame(arr2, n2));

	}

	private static int xorgame(int[] arr, int n) {
		if (n % 2 == 0) {
			return 0;
		} else {
			int res = 0;
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					res ^= arr[i];
				}
			}
			return res;
		}
	}

}
