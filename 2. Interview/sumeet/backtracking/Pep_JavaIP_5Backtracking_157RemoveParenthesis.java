package interview.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_157RemoveParenthesis {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();

		int min = getMin(str);
		solveInMin(str, min);
	}

	static HashSet<String> results = new HashSet<>();

	public static void solveInMin(String str, int remMoves) {
		if (IsValid(str) == true) {
			if (!results.contains(str)) {
				results.add(str);
				System.out.println(str);
			}
			return;
		}

		if (remMoves == 0) {
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i);
			String right = str.substring(i + 1);
			solveInMin(left + right, remMoves - 1);
		}
	}

	public static int getMin(String str) {
		if (IsValid(str) == true) {
			return 0;
		}

		int omin = Integer.MAX_VALUE;

		for (int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i);
			String right = str.substring(i + 1);
			int cmin = getMin(left + right) + 1;

			if (cmin < omin) {
				omin = cmin;
			}
		}

		return omin;
	}

	private static boolean IsValid(String str) {
		if (str.length() == 0) {
			return true;
		}

		ArrayList<Character> stack = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.add(str.charAt(i));
			} else if (str.charAt(i) == ')') {
				if (stack.size() == 0) {
					return false;
				} else {
					stack.remove(stack.size() - 1);
				}
			}
		}

		return stack.size() == 0;
	}

}
