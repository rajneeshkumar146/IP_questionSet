package interview.strings;

import java.util.Scanner;

public class Pep_JavaIP_3strings_85AreBinariesAnagram {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n1 = scn.nextInt();
		int n2 = scn.nextInt();

		System.out.println(solve(n1, n2));
	}

	// if the number of set bits is same, they are anagramic
	public static boolean solve(int n1, int n2) {
		int countSetBits = 0;

		while (n1 != 0) {
			if (n1 % 2 == 1) {
				countSetBits++;
			}
			n1 /= 2;
		}

		while (n2 != 0) {
			if (n2 % 2 == 1) {
				countSetBits--;
			}
			n2 /= 2;
		}

		return countSetBits == 0;
	}

}
