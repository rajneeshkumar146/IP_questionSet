package Strings;

import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_120ComputerCafeCustomers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int n=scn.nextInt();
		solve(str,n);
	}

	private static void solve(String str, int n) {
		HashSet<Character> set=new HashSet();
		int count=0;
	//no. of persons <=no. of computers present in the shop.


	//so  for each entry and exit , we check the above condition.
		for(int i=0; i<str.length(); i++) {
			if(set.contains(str.charAt(i))) {
	//checking if it is already assigned or not.
				set.remove(str.charAt(i));
			}else {
	//add till it becomes full or not.
				set.add(str.charAt(i));
				if(set.size()>n) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
/*
Test cases:
ABBAJJKZKZ
2
----------------------
0


GACCBDDBAGEE
3
-----------------
1

ABBCCA
1
------------------------
2
	
	
	Source: https://www.geeksforgeeks.org/function-to-find-number-of-customers-who-could-not-get-a-computer/
 */
