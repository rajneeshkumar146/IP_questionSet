package InternshipQuestionAs1;

public class Rotated_Digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rotatedDigits(int N) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			String s = Integer.toString(i);
			if (isGood(s))
				count++;
		}
		return count;
	}

	public boolean isGood(String s) {

		boolean flag = false;
		for (char c : s.toCharArray()) {
			if (c == '3' || c == '4' || c == '7')// ek bhi y h to invalid
				return false;
			else if (c == '2' || c == '5' || c == '6' || c == '9')
				flag = true;
			else if (c == '0' || c == '1' || c == '8') {
				// ho y n ho fark nhi padhta
			}
		}
		return flag;
	}
}
