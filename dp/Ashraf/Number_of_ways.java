package InternQuestionDP;

import java.util.Scanner;

public class Number_of_ways {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		while (t-- > 0) {
			int n = scn.nextInt();
			if (n == 1 || n == 2 || n == 3) {
				System.out.println(1);
				continue;
			} else if (n == 4) {
				System.out.println(2);
				continue;
			}
			long arr[] = new long[n];
			arr[0] = 1;
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 2;
			int i;
			for (i = 4; i < n; i++) {
				arr[i] = arr[i - 1] + arr[i - 4];
			}
			System.out.println(arr[i - 1]);
		}
	}
}