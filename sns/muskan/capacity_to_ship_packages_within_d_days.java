package pep_sns;

public class capacity_to_ship_packages_within_d_days {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weights = {1,2,3,4,5,6,7,8,9,10};
		int D = 5;
		System.out.println(shipWithinDays(weights, D));
	}

	public static int shipWithinDays(int[] weights, int D) {
		int low = 0;
		int high = 0;
		for (int val : weights)
			high += val;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (satisfies(weights, D, mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static boolean satisfies(int[] wt, int d, int cap) {
		int cd = 1;
		int cw = 0;
		for (int i = 0; i < wt.length; i++) {
			if (wt[i] > cap)
				return false;
			else if (cd > d)
				return false;
			else if (wt[i] + cw > cap) {
				cw = wt[i];
				cd++;
			} else {
				cw += wt[i];
			}
		}
		return cd <= d;
	}
}
