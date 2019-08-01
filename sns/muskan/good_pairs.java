package pep_sns;

public class good_pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 3, 2 };
		int n = 3;
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] != arr[j]) {
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
