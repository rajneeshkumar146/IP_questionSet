package InternQuestAS1;

import java.util.Scanner;

public class Reverse_String {
	public static void reverseString(char[] s) {
		int i = 0;
		int j = s.length - 1;
		while (i < s.length / 2) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

	}

}
