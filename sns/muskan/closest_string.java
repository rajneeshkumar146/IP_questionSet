package pep_sns;

public class closest_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"the", "quick", "brown", "fox", "quick"};
		System.out.println(check(arr, "fox", "the"));
		System.out.println(check(arr, "fox", "quick"));
	}

	public static int check(String[] arr, String w1, String w2) {
		if (w1.equals(w2)) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int w1i = -1;
		int w2i = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(w1)) {
				w1i = i;
			}
			if (arr[i].equals(w2)) {
				w2i = i;
			}
			if (w1i != -1 && w2i != -1) {
				if (Math.abs(w1i - w2i) < min) {
					min = Math.abs(w1i - w2i);
				}
			}
		}
		return min;
	}

}
