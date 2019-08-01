package InternshipQuestionAs1;

public class Valid_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(String s) {

		int l = 0;
		int r = s.length() - 1;
		char[] a = s.toLowerCase().toCharArray();

		while (l < r) {
			
			while (!((a[l] >= 'a' && a[l] <= 'z') || (a[l] >= '0' && a[l] <= '9')) && l < r)
				l++;
			while (!((a[r] >= 'a' && a[r] <= 'z') || (a[r] >= '0' && a[r] <= '9')) && l < r)
				r--;
			
			if (a[l] != a[r])
				return false;
			l++;
			r--;
		}
		
		return true;

	}
}
