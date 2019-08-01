package BackTracking;

public class AdditiveNumber {

	public static void main(String[] args) {
		
		String st = "112355";
		System.out.println(additive(st));
	}

	private static boolean additive(String st) {
		for (int i = 1; i <= st.length() / 2; i++) {
			for (int j = 1; j <= (st.length() - i) / 2; j++) {
				boolean ans = check(st, st.substring(0, i), st.substring(i, i+j), st.substring(i + j));
				if (ans == true) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean check(String st, String a, String b, String c) {
		if (!isvalid(a) || !isvalid(b)) {
			return false;
		}

		String sum = addstring(a, b);
		if (sum.equals(c)) {
			return true;
		}

		if ((c.length() < sum.length()) || !c.substring(0, sum.length()).equals(sum)) {
			return false;
		} else {
			return check(st, b, sum, c.substring(sum.length()));
		}
	}

	private static String addstring(String a, String b) {
		int st1 = Integer.parseInt(a);
		int st2 = Integer.parseInt(b);
		
		int sum = st1 + st2;
		String add = sum + "";
		return add;
	}

	private static boolean isvalid(String b) {
		if (b.length() > 1 && b.charAt(0) == '0') {
			return false;
		} else {
			return true;
		}
	}
}
