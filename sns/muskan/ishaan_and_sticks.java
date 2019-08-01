package pep_sns;

public class ishaan_and_sticks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 3, 2, 3, 6, 3, 3 };
		int n = arr.length;
		int[] fmap = new int[(int) Math.pow(10, 3) + 1];
		for (int i = 0; i < n; i++) {
			fmap[arr[i]]++;
		}
		int area = -1;
		int nos = -1;
		for (int i = fmap.length - 1; i >= 0; i--) {
			if (fmap[i] >= 4) {
				area = i * i;
				nos = fmap[i] / 4;
			}
		}
		if (area != -1) {
			System.out.println(area + " " + nos);
		} else {
			System.out.println(-1);
		}

	}

}
