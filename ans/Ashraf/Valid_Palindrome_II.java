package InternshipQuestionAs1;

public class Valid_Palindrome_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean validPalindrome(String s) {
		if (s.length() == 0 || s == null)
			return false;

		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) { // leave one character on either side and check if palindrome
				return (isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1));
			}
		}
		return true;
	}

	private static boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) { // like expand around the center
				i++; // we converge to the center
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
}
