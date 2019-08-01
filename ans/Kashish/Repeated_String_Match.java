package InternQuestAS1;

import java.util.Scanner;

public class Repeated_String_Match {
	 public static int repeatedStringMatch(String s1, String s2) {
		 for (int i = 0; i < s1.length(); i++) {
	            if (s1.charAt(i) == s2.charAt(0)) {
	                int count = 1;
	                int j = 0;
	                int startIx = i;
	                while (j < s2.length() && s1.charAt(startIx) == s2.charAt(j)) {
	                    j++;
	                    startIx++;
	                    if (startIx >= s1.length() && j < s2.length()) {
	                        startIx = startIx % s1.length();
	                        count++;
	                    }
	                }
	                if (j == s2.length()) return count;
	            }
	        }
	        return -1;
		 
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner scn=new Scanner(System.in);
		String s1=scn.next();
		String s2=scn.next();
		System.out.println(repeatedStringMatch(s1, s2));
		

	}
//	abc
//	cabcabca

}
