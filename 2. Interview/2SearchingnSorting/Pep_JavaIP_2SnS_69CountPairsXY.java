package SearchingSorting;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_69CountPairsXY {
/* What : Given two arrays(X,Y) find all pairs such that x^y > y ^ x
* HOW :Sort array Y.
* Count trivial cases,
*  x^0 is always greater than 0 ^ x
*  x^1 is always greater than 1 ^ x
* Rule : All x < y, result in x^y > y^x
* Exceptions : 2^3 and 2^4 are invalid
*							3^2 > 2^3 is valid
*Rest given by rule
*Why : Same as above
*
*
*/
	public static void main(String[] args) {
	Scanner scn = new Scanner(System.in);
	int sizeofX = scn.nextInt();
	int[] X = new int[sizeofX];
	for (int i = 0; i < X.length; i++) {
		X[i] = scn.nextInt();
	}

	int[] Y = new int[scn.nextInt()];
	int number0 = 0;
	int number1 = 0;
	int number2 = 0;
	int number3 = 0;
	int number4 = 0;
	for (int i = 0; i < Y.length; i++) {
		Y[i] = scn.nextInt();
		if (Y[i] == 0) {
			number0++;
		}
		if (Y[i] == 1) {
			number1++;
		}
		if (Y[i] == 2) {
			number2++;
		}
		if (Y[i] == 3) {
			number3++;
		}
		if (Y[i] == 4) {
			number4++;
		}
	}

	Arrays.sort(Y);
	int count = 0;
	for (int i = 0; i < X.length; i++) {
		if (X[i] == 0) {
			// do nothing
			continue;
		} else if (X[i] == 1) {
			count += number0;
			continue;
		} else if (X[i] == 2) {
			count -= number3 + number4;
		} else if (X[i] == 3) {
			count += number2;
		} else if (X[i] == 4) {
			// do nothing
		}

		int pos = ceil(X[i], Y);
		if (pos != -1)
			count += Y.length - pos;
		count += number0 + number1;
	}
	System.out.println(count);
}

private static int ceil(int i, int[] y) {
	int lo = 0;
	int hi = y.length - 1;
	int pos = findceil(i, y, lo, hi);
	return pos;
}

private static int findceil(int i, int[] y, int lo, int hi) {
	if(lo>hi) {
		return -1;
	}
	if (i < y[lo]) {
		return lo;
	}
	if (i > y[hi]) {
		return -1;
	}

	int mid = (lo + hi) / 2;

	if (y[mid] > i) {
		if (y[mid - 1] <= i && mid - 1 >= lo) {
			return mid;
		} else {
			return findceil(i, y, lo, mid - 1);
		}
	} else {
		if (mid + 1 <= hi && y[mid + 1] > i) {
			return mid + 1;
		} else {
			return findceil(i, y, mid + 1, hi);
		}
	}
}

}


/*
Test cases:

3
10 19 18
3
11 15 9
--------------
2

3
2 1 6
2
1 5
----------------
2

3
10 19 8
3
11 15 9
--------------
5

Source: https://www.geeksforgeeks.org/find-number-pairs-xy-yx/
*/
