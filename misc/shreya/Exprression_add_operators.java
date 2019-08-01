package misc;

import java.util.ArrayList;

public class Exprression_add_operators {

	public static void main(String[] args) {
		ArrayList<String> res=new ArrayList<>();
		res=addOperators("123", 6);
		System.out.println(res);

	}

	public static ArrayList<String> addOperators(String num, int target) {
		ArrayList<String> res = new ArrayList<>();
		if (num == null || num.length() == 0) {
			return res;
		}

		helper(res, num, "", target, 0, 0, 0);
		return res;

	}

	public static void helper(ArrayList<String> res, String num, String path, int target, int pos, long val, long mult) {

		if (pos == num.length()) {
			if (val == target) {
				res.add(path);
			}
			return;
		}

		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0') {
				break;
			}

			Long cur = Long.parseLong(num.substring(pos, i + 1));

			if (pos == 0) {
				helper(res, num, path + cur, target, i + 1, cur, cur);
			} else {

				helper(res, num, path + "*" + cur, target, i + 1, val - mult + mult * cur, mult * cur);

				helper(res, num, path + "+" + cur, target, i + 1, val + cur, cur);

				helper(res, num, path + "-" + cur, target, i + 1, val - cur, -cur);

			}
		}
	}
}
