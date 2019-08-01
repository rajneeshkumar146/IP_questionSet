package may28;

import java.util.Scanner;

public class Substrings_with_similar_first_and_last_characters {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {

			int n = scn.nextInt();
			
			String s=scn.next();
			
			int[] count=new int[26];
			
			for(char c:s.toCharArray()){
				count[c-'a']++;
			}
			
			int ans=0;
			for(int val:count){
				ans+=(val*(val+1))/2;
			}
			System.out.println(ans);

		}

	}

}
