package pep_misc;


public class missing_number_in_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		long[][] arr = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0 }, { 1, 2, 1, 1, 1 }, { 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 } };
		int zr = 0;
		int zc = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					zr = i;
					zc = j;
				}
			}
		}
		if (n == 1) {
			if (arr[0][0] == 0) {
				System.out.println("1");
			} else {
				System.out.println("-1");
			}
			return;
		}
		long rowsum = 0;
		int cr = 0;
		long zerorowsum = 0;
		if (zr == 0) {
			cr = 1;
		}
		for (int i = 0; i < n; i++) {
			rowsum += arr[cr][i];
			zerorowsum += arr[zr][i];
		}
		long val = rowsum - zerorowsum;
		arr[zr][zc] = val;
		if (val <= 0) {
			System.out.println("-1");
			return;
		}
		if (check(arr, n, rowsum, zr, zc)) {
			System.out.println(val);
		} else {
			System.out.println("-1");
		}

	}

	public static boolean check(long[][] arr, int n, long rowsum, int zr, int zc) {
		long zerorsum = 0;
		long zerocsum = 0;
		for (int i = 0; i < n; i++) {
			zerorsum += arr[zr][i];
			zerocsum += arr[i][zc];
		}
		if (zerorsum != rowsum || zerocsum != rowsum) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			long rsum = 0;
			long csum = 0;
			for (int j = 0; j < n; j++) {
				rsum += arr[i][j];
				csum += arr[j][i];
			}
			if (rsum != rowsum || csum != rowsum) {
				return false;
			}
		}
		long d1sum = 0;
		long d2sum = 0;
		for (int i = 0; i < n; i++) {
			d1sum += arr[i][i];
			d2sum += arr[i][n - i - 1];
		}
		if (d1sum != rowsum || d2sum != rowsum) {
			return false;
		}
		return true;
	}

}
