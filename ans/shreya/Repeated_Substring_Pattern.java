package InternQuestAS1;

import java.util.Arrays;
import java.util.Scanner;

public class Repeated_Substring_Pattern {
	public static boolean repeatedSubstringPattern(String s) {
		char[] str = s.toCharArray();
		int kmp[] = new  int[s.length()+1];
		Arrays.fill(kmp, -1);
		int j = -1;
		for (int i = 1; i <= s.length(); i++) {
			while (j>=0 &&str[j] != str[i-1]) {
				j = kmp[j];
			}
			kmp[i] = j+1;
			j++;
			
		}
		 if(kmp[s.length()]>0 && (kmp[s.length()]%(s.length()-kmp[s.length()])==0)){
			 return true;
		 }
		 else{
			 return false;
		 }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = "abcabcabcabc";
		System.out.println(repeatedSubstringPattern(s));
	}

}
