package BackTracking;

import java.util.Arrays;

public class Cryptarithmetic_Puzzles {

	public static void main(String[] args) {
		s1 = "send";
		s2 = "more";
		s3 = "money";
		boolean check[] = new boolean[26];
		int am[] = new int[26];
		Arrays.fill(am, -1);
		boolean[] dsf = new boolean[10];
		String qs = getuniquestr(check);
		crypto(qs, am, dsf);

	}

	static String s1;
	static String s2;
	static String s3;
	static int count = 0;

	static private int getnumfromString(String s, int[] am) {
		int p = 1;
		int ans = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			ans = ans + am[s.charAt(i) - 'a'] * p;
			p = p * 10;
		}
		return ans;
	}

	static void crypto(String qs, int[] am, boolean[] dsf) {

		if (qs.length() == 0) {
			int num1 = getnumfromString(s1, am);
			int num2 = getnumfromString(s2, am);
			int num3 = getnumfromString(s3, am);

			if (num1 + num2 == num3) {
				System.out.println(++count);
			}
			return;
		}
		char ch = qs.charAt(0);
		String ros = qs.substring(1);
		for (int i = 0; i <= 9; i++) {
			if (dsf[i] == false) {
				am[ch - 'a'] = i;
				dsf[i] = true;
				crypto(ros, am, dsf);
				am[ch - 'a'] = -1;
				dsf[i] = false;
			}
		}

	}

	private static String getuniquestr(boolean[] check) {
		String ans = "";
		for (int i = 0; i < s1.length(); i++) {
			if (check[s1.charAt(i) - 'a'] == false) {
				ans = ans + s1.charAt(i);
				check[s1.charAt(i) - 'a'] = true;
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if (check[s2.charAt(i) - 'a'] == false) {
				ans = ans + s2.charAt(i);
				check[s2.charAt(i) - 'a'] = true;
			}
		}
		for (int i = 0; i < s3.length(); i++) {
			if (check[s3.charAt(i) - 'a'] == false) {
				ans = ans + s3.charAt(i);
				check[s3.charAt(i) - 'a'] = true;
			}
		}
		return ans;
	}
}
