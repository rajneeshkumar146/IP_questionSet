package InternshipQuestionAs1;

import java.util.HashSet;

public class Unique_Morse_Code_Words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int uniqueMorseRepresentations(String[] words) {

		String[] morse = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
				".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
				"--.." };

		HashSet<String> seen = new HashSet<>();

		for (String word : words) {

			StringBuilder code = new StringBuilder();
			for (char c : word.toCharArray())
				code.append(morse[c - 'a']);   // determining index
			seen.add(code.toString());

		}

		return seen.size();
	}
}
