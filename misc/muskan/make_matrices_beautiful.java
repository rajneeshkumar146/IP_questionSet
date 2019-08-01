package pep_misc;

public class make_matrices_beautiful {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] arr = { { 1, 2, 3 }, { 4, 2, 3 }, { 3, 2, 1 } };
		int[] rows = new int[n];
		int[] cols = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rows[i] += arr[i][j];
				cols[j] += arr[i][j];
			}
		}
		int maxofall = 0;
		for (int i = 0; i < n; i++) {
			maxofall = Math.max(maxofall, Math.max(rows[i], cols[i]));
		}
		int op = 0;
		for (int i = 0, j = 0; i < n && j < n;) {
			int diff = Math.min((maxofall - rows[i]), (maxofall - cols[j]));
			arr[i][j] += diff;
			rows[i] += diff;
			cols[i] += diff;
			if (rows[i] == maxofall) {
				i++;
			}
			if (cols[j] == maxofall) {
				j++;
			}
			op += diff;
		}
		System.out.println(op);

	}

}
