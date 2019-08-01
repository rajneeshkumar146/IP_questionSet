package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_211WordBreak {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		HashSet<String> dict = new HashSet<>();
		for(int i = 0; i < n; i++){
			dict.add(scn.next());
		}
		
		String str = scn.next();
		System.out.println(solve(str, dict));
	}
	
	private static boolean solve(String str, HashSet<String> dict){
		boolean[] f = new boolean[str.length()];
		
		for(int i = 0; i < str.length(); i++){
			if(dict.contains(str.substring(0, i + 1))){
				f[i] = true;
			} else {
				for(int j = 0; j < i; j++){
					if(f[j] == true && dict.contains(str.substring(j + 1, i + 1))){
						f[i] = true;
					}
				}
			}
		}
		
		return f[str.length() - 1];
	}
	

}

// https://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
/* Test case 1 
12
samsung sam sung man mango icecream and go i like ice cream
ilikesamsung
true
*/

/* Test case 2 
12
samsung sam sung man mango icecream and go i like ice cream
gomanmangoiam
false
*/