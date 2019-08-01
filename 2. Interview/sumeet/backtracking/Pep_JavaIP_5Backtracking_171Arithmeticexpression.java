package interview.backtracking;

import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_171Arithmeticexpression {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		arithmeticExpressions(arr);
		in.close();
	}

	public static void arithmeticExpressions(int[] arr) {
		int vsf = arr[0];
		String expsp = arr[0] + "";
		arithmeticExpressions(arr, vsf, expsp, 1);
	}

	public static boolean arithmeticExpressions(int[] arr, int vsf, String expsf, int vidx) {
		if (vidx == arr.length) {
			if (vsf % 101 == 0) {
				System.out.println(expsf);
				return true;
			}
			return false;
		}

		boolean res = false;
		res = res || arithmeticExpressions(arr, vsf + arr[vidx], expsf + "+" + arr[vidx], vidx + 1);
		res = res || arithmeticExpressions(arr, vsf - arr[vidx], expsf + "-" + arr[vidx], vidx + 1);
		res = res || arithmeticExpressions(arr, vsf * arr[vidx], expsf + "*" + arr[vidx], vidx + 1);
		return res;
	}

}
