package pep_misc;

public class number_of_palindromic_paths_in_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] mat = { { 'a', 'a', 'a', 'b' }, { 'b', 'a', 'a', 'a' }, { 'a', 'b', 'b', 'a' } };
		System.out.println(f(0, 0, mat, ""));
	}

	public static int f(int sr, int sc, char[][] mat, String s) {
		if (sr == mat.length - 1 && sc == mat[0].length - 1) {
			s += mat[sr][sc];
			if (checkPalindrome(s)) {
				return 1;
			}
			else
				return 0;
		}
		int count = 0;
		if (sr + 1 < mat.length)
			count += f(sr + 1, sc, mat, s + mat[sr][sc]);
		if (sc + 1 < mat[0].length)
			count += f(sr, sc + 1, mat, s + mat[sr][sc]);
		return count;
	}

	private static boolean checkPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left <= right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
