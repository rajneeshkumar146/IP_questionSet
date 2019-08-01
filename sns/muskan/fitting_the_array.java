package pep_sns;

import java.util.Arrays;

public class fitting_the_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[] arr1 = {7, 5, 3, 2};
		int[] arr2 = {5, 4, 8, 7};
		
		// CASE FOR NO {7, 5, 3, 2, 5, 105, 45, 10 }; {2, 4, 0, 5, 6, 9, 75, 84}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (arr1[i] > arr2[i]) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}

}
