package InternQuestionDP;

import java.util.Scanner;

public class Minimum_number_of_Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {

			int n = scn.nextInt();
			int arr[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
			coinrequired(arr, n);
		}
	}

	public static void coinrequired(int arr[], int n) {

		int len = arr.length;
		for (int i = len - 1; i >= 0; i--) {
			while (n >= arr[i]) {
				System.out.print(arr[i] + " ");
				n -= arr[i];
			}
		}
		System.out.println();
	}
}
