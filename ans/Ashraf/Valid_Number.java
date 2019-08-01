package InternshipQuestionAs1;

public class Valid_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isNumber(String s) {

		s = s.trim();// for aage k spaces
		boolean eSeen = false;
		boolean nSeen = false;
		boolean dotSeen = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				nSeen = true;
			else if (c == 'e') {
				if (eSeen || !nSeen)
					return false;
				else {
					eSeen = true;
					nSeen = false;
				}
			} else if (c == '.') {
				if (eSeen || dotSeen)
					return false;
				else
					dotSeen = true;
			} else if (c == '-' || c == '+') {
				if (i != 0 && s.charAt(i - 1) != 'e')
					return false;
			} else
				return false;
		}
		return nSeen;
	}
}
