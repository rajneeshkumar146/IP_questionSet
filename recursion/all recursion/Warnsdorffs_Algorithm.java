package BackTracking;

public class Warnsdorffs_Algorithm {

	public static void main(String[] args) {
		Integer[][] arr = new Integer[6][6];

		knighttour(arr, 0, 0, 0);
	}

	private static boolean knighttour(Integer[][] arr, int vidx, int rno, int cno) {
		if (arr[rno][cno] != null) {
			return false;
		}

		if (vidx == 35) {
			arr[rno][cno] = vidx;
			print(arr);
			return true;
		}
		boolean res = false;
		for (int i = 0; i < dir.length; i++) {
			int rdash = rno + dir[i][0];
			int cdash = cno + dir[i][1];
			if (rdash >= 0 && rdash < arr.length && cdash >= 0 && cdash < arr.length) {
				arr[rno][cno] = vidx;
				res = res || knighttour(arr, vidx + 1, rdash, cdash);
				arr[rno][cno] = null;
			}
		}

		return res;

	}

	static int[][] dir = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };

	private static void knighttourreac(Integer[][] arr, int vidx, int cellno) {

		int rno = (cellno - 1) / arr.length;
		int cno = (cellno - 1) % arr.length;
		if (arr[rno][cno] != null) {
			return;
		}
		if (vidx == 64) {
			print(arr);
			return;
		}

		for (int i = 0; i < dir.length; i++) {
			arr[rno][cno] = vidx;
			int rdash = rno + dir[i][0];
			int cdash = cno + dir[i][1];
			if (rdash >= 0 && rdash < 8 && cdash >= 0 && cdash < 8) {
				cellno = cdash + (arr[0].length * rdash) + 1;
				knighttourreac(arr, vidx + 1, cellno);
				arr[rno][cno] = null;
			}
		}
	}

	private static void print(Integer[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
