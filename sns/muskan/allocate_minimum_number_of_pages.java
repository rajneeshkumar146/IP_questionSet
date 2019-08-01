package pep_sns;

public class allocate_minimum_number_of_pages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pages = {12, 34, 67, 90};
		int students = 2;
		System.out.println(minpagesallocation(pages, students));
	}

	public static int minpagesallocation(int[] pages, int s) {
		int low = 0;
		long high = 0;
		for (int val : pages)
			high += val;
		while (low <= high) {
			int mid = (int)(low + high) / 2;
			if (satisfies(pages, s, mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static boolean satisfies(int[] pages, int s, int cap) {
		int cs = 1;
		int cp = 0;
		for (int i = 0; i < pages.length; i++) {
			if (pages[i] > cap)
				return false;
			else if (cs > s)
				return false;
			else if (pages[i] + cp > cap) {
				cp = pages[i];
				cs++;
			} else {
				cp += pages[i];
			}
		}
		return cs <= s;
	}

}
