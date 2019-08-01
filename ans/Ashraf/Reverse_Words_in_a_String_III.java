package InternshipQuestionAs1;

public class Reverse_Words_in_a_String_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("Let's take LeetCode contest"));

	}

	public static String reverseWords(String s) {

		String[] sa = s.split(" ");
		s = "";
		for (String s1 : sa) {
			StringBuilder sb = new StringBuilder(s1);
			sb = sb.reverse();
			s = s + sb + " ";
		}
		return s.substring(0, s.length() - 1);
	}
}
