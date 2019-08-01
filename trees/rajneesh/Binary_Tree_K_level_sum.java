package Tree;

import java.util.Scanner;

public class Binary_Tree_K_level_sum {
	public static void main(String[] args) {
		Scanner ab = new Scanner(System.in);
		int t = Integer.parseInt(ab.nextLine().trim());
		
		while (t-- > 0) {
			int n = Integer.parseInt(ab.nextLine().trim());
			String str = new String(ab.nextLine().trim());
			int c = 0, sum = 0;
		
			for (int i = 0; i < str.length(); ++i) {
				if (str.charAt(i) == '(') {
					++c;
					++i;
					int val = 0;
					while (i < str.length() && (str.charAt(i) != ')' && str.charAt(i) != '(')) {
						if (c == n + 1) {
							val = val * 10 + str.charAt(i) - '0';
						}
						++i;
					}
						sum += val;
				}

				if (i < str.length() && str.charAt(i) == ')')
					--c;
				else if (i < str.length() && str.charAt(i) == '(')
					--i;
			}
			System.out.println(sum);
		}
	}

}
