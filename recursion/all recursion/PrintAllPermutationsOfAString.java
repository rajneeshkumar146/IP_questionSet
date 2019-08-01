
public class PrintAllPermutationsOfAString {

	public static void main(String[] args) {

		printPermutation("abcd");
	}

	public static void printPermutation(String str) {

		printpermutationQA1("abcd", "");

	}

	static int counter = 0;

	public static void printpermutationQA1(String ques, String ans) {

		if (ques.length() == 0) {
			counter++;
			System.out.println(counter + "." + ans);
			return;
		}

		char ch = ques.charAt(0);
		String newQues = ques.substring(1);
		for (int i = 0; i <= ans.length(); i++) {
			String left = ans.substring(0, i);
			String right = ans.substring(i);
			String newAns = left + ch + right;
			printpermutationQA1(newQues, newAns);
		}

	}

}
