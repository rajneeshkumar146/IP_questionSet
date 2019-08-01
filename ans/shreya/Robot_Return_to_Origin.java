package InternshipQuestionAs1;

public class Robot_Return_to_Origin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(judgeCircle("RLUURDDDLU"));
	}

	public static boolean judgeCircle(String s) {
		int u = 0, d = 0, r = 0, l = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'R')
				r++;
			else if (s.charAt(i) == 'L')
				l++;
			else if (s.charAt(i) == 'U')
				u++;
			else if (s.charAt(i) == 'D')
				d++;
		}
		if (r == l && u == d)
			return true;
		return false;
	}
}
