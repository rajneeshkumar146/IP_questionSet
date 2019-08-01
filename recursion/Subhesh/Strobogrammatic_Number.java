package BackTracking;

public class Strobogrammatic_Number {

	public static void main(String[] args) {
		String st = "10698186901";
		System.out.println(isStrobogrammatic(st));
	}

	public static boolean isStrobogrammatic(String num) {
		char ch = num.charAt(0);
		if (num.length() == 1) {
			if (ch != '0' && ch != '1' && ch != '8') {
				return false;
			} else {
				return true;
			}
		}
		int start = 0;
		int end = num.length() - 1;
		while (start <= end) {
			char ch1 = num.charAt(start);
			char ch2 = num.charAt(end);
			if ((ch1 == '6' && ch2 != '9') && (ch2 == '6' && ch1 != 9)) {
				return false;
			}
			if (ch1 != '6' && ch1 != '9' && ch1 != '0' && ch1 != '1' && ch1 != '8') {
				return false;
			}
			if (ch1 != '6' && ch1 != '9' && ch2 != '0' && ch2 != '1' && ch2 != '8') {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
