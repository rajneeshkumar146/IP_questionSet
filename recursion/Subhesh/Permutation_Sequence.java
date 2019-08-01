package BackTracking;

public class Permutation_Sequence {

	public static void main(String[] args) {
		int n = 3;
		int k = 3;
		String st = "";
		for (int i = 1; i <= n; i++) {
			st = st + i;
		}
		count = 0;
		ans = "";
		perm(st, "", k);
	}

	static int count;
	static String ans;

	public static boolean perm(String ques, String asf, int k) {
		if (ques.length() == 0) {
			count++;
			if (k == count) {
				ans = asf;
				return true;
			}
			return false;
		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			boolean check = perm(ques.substring(0, i) + ques.substring(i + 1), asf + ch, k);
			if (check == true) {
				return true;
			}
		}
		return false;
	}
}
