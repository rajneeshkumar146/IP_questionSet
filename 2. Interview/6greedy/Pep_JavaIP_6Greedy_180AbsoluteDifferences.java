package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_6Greedy_180AbsoluteDifferences {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int[] arr1=new int[scn.nextInt()];
		for(int i=0; i<arr1.length; i++) {
			arr1[i]=scn.nextInt();
		}
		int[] arr2=new int[arr1.length];
		for(int i=0; i<arr1.length; i++) {
			arr2[i]=scn.nextInt();
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int diff=0;
		for(int i=0; i<arr1.length; i++) {
			diff+=Math.abs(arr1[i]-arr2[i]);
		}
		
		System.out.println(diff);
			
	}

}

/*Test Cases: 
3
1 2 3
3 2 1
---------------
0

4
4 1 8 7
2 3 6 5
------------------
6

9
1 2 3 82 91 4 9 10 23
2 3 4 5 6 7  8 9 0
----------------------
181



Source: https://www.geeksforgeeks.org/minimum-sum-absolute-difference-pairs-two-arrays/

*/