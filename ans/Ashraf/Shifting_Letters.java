package InternshipQuestionAs1;

public class Shifting_Letters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shiftingLetters("adzz", new int[] { 3, 12, 1, 3 }));
	}

	public static String shiftingLetters(String S, int[] shifts) {

		int total = 0;
		char[] chars = S.toCharArray();

		for (int i = shifts.length - 1; i >= 0; i--) {

			total = (total + shifts[i]) % 26;

			chars[i] += total; // adding to ASCII

			if (chars[i] > 'z') { // if >'z' ASCII ex = 'z' + 3 then add -26 to become 'a'+ 3 -1;
				chars[i] += 'a' - 'z' - 1;
			}
		}
		return new String(chars);
	}
}
