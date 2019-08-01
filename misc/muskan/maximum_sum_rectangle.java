package pep_misc;

public class maximum_sum_rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int m = 5;
		int[][] arr = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };
		System.out.println(findMax(arr, n, m));
	}

	public static int findMax(int[][] arr, int rows, int cols) {
		int left = 0;
		int right = 0;
		int top = 0;
		int bottom = 0;
		int maxsum = 0;
		int leftc = 0;
		int rightc = 0;
		int[] karr = new int[3];
		for (leftc = 0; leftc < cols; leftc++) {
			int[] temp = new int[rows];
			for (rightc = leftc; rightc < cols; rightc++) {
				for (int i = 0; i < rows; i++) {
					temp[i] += arr[i][rightc];
				}
				karr = kadanes(temp);
				if (karr[0] > maxsum) {
					maxsum = karr[0];
					left = leftc;
					right = rightc;
					top = karr[1];
					bottom = karr[2];
				}
			}
		}
		System.out.println("from row " + top + " - " + bottom + " col " + left + " - " + right);
		return maxsum;
	}

	public static int[] kadanes(int[] temp) {
		int[] karr = new int[3];
		karr[0] = Integer.MIN_VALUE;
		karr[1] = 0;
		karr[2] = -1;
		int cstart = 0;
		int csum = 0;
		for (int i = 0; i < temp.length; i++) {
			csum += temp[i];
			if (csum < 0) {
				cstart = i + 1;
				csum = 0;
			} else if (csum > karr[0]) {
				karr[0] = csum;
				karr[1] = cstart;
				karr[2] = i;
			}
		}

		if (karr[2] == -1) {
			karr[0] = 0;
			for (int i = 0; i < temp.length; i++) {
				if (temp[i] > karr[0]) {
					karr[0] = temp[i];
					karr[1] = i;
					karr[2] = i;
				}
			}
		}
		return karr;
	}

}
