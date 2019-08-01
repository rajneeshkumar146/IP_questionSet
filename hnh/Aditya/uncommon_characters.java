package may27;

import java.util.Scanner;

public class uncommon_characters {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = 1;

		for (int i = 0; i < n; i++) {
			String s1 = "alphabets";
			String s2 = "characters";

			int[] map1 = new int[26];
			int[] map2 = new int[26];

			for (char c1 : s1.toCharArray()) {
				map1[c1-'a']++;
			}

			for (char c2 : s2.toCharArray()) {
				map2[c2-'a']++;
			}
			
			for(int itr=0;itr<26;itr++){
				
					System.out.print((char)(itr+'a'));
				
			}
			System.out.println();
		}

	}

}
