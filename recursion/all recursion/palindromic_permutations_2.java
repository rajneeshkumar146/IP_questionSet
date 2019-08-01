package reccursion;
import java.util.ArrayList;

public class palindromic_permutations_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generatePalindromes("abbabbaba"));
	}

	public static  ArrayList<String> generatePalindromes(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return res;
		}
		int[] map = new int[256];
		int oddCount = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map[(int) c]++;
			oddCount = map[(int) c] % 2 == 0 ? oddCount - 1 : oddCount + 1;
		}

		if (oddCount > 1) {
			return res;
		}
		String mid = "";
		int length = 0;
		for (int i = 0; i < 256; i++) {
			if (map[i] % 2 == 1) {
				mid = "" + (char) i;
				map[i]--;
			}

			length += map[i] / 2;
			map[i] /= 2;
		}

		createPermutations(map, res, length, mid, "");
		return res;
	}

	public static void createPermutations(int[] map, ArrayList<String> res, int length, String mid, String cur) {
		if (cur.length() == length) {
			StringBuilder sb = new StringBuilder(cur).reverse();
			res.add(cur + mid + sb);
			return;
		}

		for (int i = 0; i < 256; i++) {
			if (map[i] > 0) {
				map[i]--;
				createPermutations(map, res, length, mid, cur + (char) i);
				map[i]++;
			}

		}
	}

}
