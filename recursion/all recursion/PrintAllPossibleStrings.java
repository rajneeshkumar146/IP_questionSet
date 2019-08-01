package recursion;

public class PrintAllPossibleStrings {

	public static void main(String[] args) {

		printPossibleString("abc", "");

	}

	public static void printPossibleString(String ques, String asf) {

		
		if (ques.length() == 1) {
			System.out.println(asf+ques.charAt(0)+"$");
			return;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		printPossibleString(ros, asf + ch);

		printPossibleString(ros, asf + ch + " ");

	}
}
