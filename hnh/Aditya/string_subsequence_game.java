package may29;

import java.util.Scanner;

public class string_subsequence_game {

	 static int count=0;
	    
	 public static void main(String[] args) {

	 		Scanner scn = new Scanner(System.in);
	 		int t = scn.nextInt();

	 		for (int i = 0; i < t; i++) {

	 			String ques = scn.next();
	 			count=0;
	 			allvalidsubsequence(ques, "");
	 			if(count==0){
	 			    System.out.println(-1);
	 			}
	 			else{
	 			   
	 			
	 			System.out.println();
	 }
	 		}
	 	}

	 	static void allvalidsubsequence(String qsf, String ans) {
	 		if (qsf.length() == 0) {
	 			if (ans.length() > 0 && isvowel(ans.charAt(0)) && !isvowel(ans.charAt(ans.length() - 1)))
	 				{System.out.print(ans+" ");
	 				    count++;
	 				}
	 			return;
	 		}

	 		char c = qsf.charAt(0);
	 		allvalidsubsequence(qsf.substring(1), ans);
	 		allvalidsubsequence(qsf.substring(1), ans + c);
	 		

	 	}

	 	static boolean isvowel(char c) {
	 		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
	 			return true;
	 		}
	 		return false;
	 	}

}
