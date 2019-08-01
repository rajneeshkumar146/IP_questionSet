package recursion;
import java.util.ArrayList;

public class PrintPalindromicPartitioning {

	public static void main(String[] args) {

		String str = "nitin";
		System.out.println(returnListOfPalindromes(str, 0, new ArrayList<String>(), new ArrayList<ArrayList<String>>()));

	}

	public static ArrayList<ArrayList<String>> returnListOfPalindromes(String str, int start, ArrayList<String> curr,
			ArrayList<ArrayList<String>> res) {

		if (start == str.length()) {
			res.add(curr);
			return res;
		}

		ArrayList<String> temp = new ArrayList<String>(curr);

		for (int j = start; j < str.length(); j++) {

			String subStr = str.substring(start, j + 1);
			if (isPalindrome(subStr)) {
				curr.add(subStr);
				res = returnListOfPalindromes(str, j + 1, curr, res);
				curr = new ArrayList<String>(temp);
			}
		}
		return res;

	}

	private static boolean isPalindrome(String str) {
		int start = 0, end = str.length() - 1;
		while (start < end) {
			if (str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
