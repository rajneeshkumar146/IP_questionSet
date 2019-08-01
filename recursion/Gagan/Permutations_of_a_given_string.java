package recursion;

import java.util.*;

class Permutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = new String();
			s = sc.next();
			char[] ar = s.toCharArray();
			Arrays.sort(ar);
			String s1 = new String(ar);
			permute(s1, "");

			System.out.println();
		}
	}

	public static void permute(String s, String ans) {
		String ros;
		if (s.length() == 0) {
			System.out.print(ans + " ");
		} else {
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				ros = s.substring(0, i) + s.substring(i + 1);
				permute(ros, ans + ch);
			}
		}
	}
}