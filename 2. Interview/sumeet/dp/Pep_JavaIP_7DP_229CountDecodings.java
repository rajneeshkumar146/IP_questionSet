package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_229CountDecodings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(solve(str));
	}
	
	private static int solve(String str){
		int[] count = new int[str.length() + 1];
		
		count[0] = 1;
		count[1] = 1;
		for(int i = 2; i <= str.length(); i++){
			char ch = str.charAt(i - 1);
			char chm1 = str.charAt(i - 2);
			
			if(ch > '0'){
				count[i] = count[i - 1];
			}
			
			if(chm1 == '1' || chm1 == '2' && ch < '7'){
				count[i] += count[i - 2];
			}
		}
		
		return count[str.length()];
	}

}

// https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
/* Test case 1 
1234
3
*/

/* Test case 2 
1123
5
*/