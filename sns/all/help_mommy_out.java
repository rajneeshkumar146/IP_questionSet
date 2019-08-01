package pep_sns;

public class help_mommy_out {

	public static void main(String[] args) {
		// case for 0 ->
		// m = 5
		// s = 40
		// n = 8
		// arr = {25, 28, 12, 20, 6, 5, 37, 26}

		int[] arr = { 35, 10, 85, 90, 30 };
		int m = 20;
		int s = 15;
		int n = 5;
		int countswaps = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < (n - i - 1); j++) {
				if (arr[j] > arr[j + 1]) {
					countswaps++;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		if (countswaps * s <= (m * 60)) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}

}
