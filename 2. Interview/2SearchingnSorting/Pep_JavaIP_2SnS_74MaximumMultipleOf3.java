package SearchingSorting;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_74MaximumMultipleOf3 {
/*What : Given an array of non-negative integers.
*Find the largest multiple of 3 that can be formed from array elements.
*
*HOW : Sort array, find sum of numbers. If divisble print from back.(largest number)
*(sum)mod3 = 1: find least number with mod = 1 ,
*               or find two least numbers with mod = 2
*(sum)mod3 = 2: find least number with mod = 2 ,
*               or find two least numbers with mod = 1
* WHY :
* numbers divisible by 3 have special property that sum of their digits is divisible
* by 3.If a number is divisible by 3, its any permutation is divisible by 3.
*	We have to print largest such permutation.Hence we remove least numers only
* 
*
*/
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int[] arr1 = new int[scn.nextInt()];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = scn.nextInt();
		}
		Arrays.sort(arr1);
		int sum=0;
		for(int i=0; i<arr1.length; i++) {
			sum+=arr1[i];
		}
		if(sum%3==0) {
			for(int i=arr1.length-1; i>=0; i--) {
				System.out.print(arr1[i]);
			}
		}else {
			if(sum%3==1) {
				//either find least number whose modulo 3 is 1
				int one=-1;
				int two=-1;
				for(int i=0; i<arr1.length; i++) {
					if(arr1[i]%3==1) {
						one=arr1[i];
						arr1[i]=-1;
					}
				}
				if(one!=-1) {
					for(int i=arr1.length-1; i>=0; i--) {
						if(arr1[i]<0) {
							continue;
						}
						System.out.print(arr1[i]);
					}
				}
				//or find 2 least numbers whose modulo 3 is 2
				else {
					for(int i=0; i<arr1.length; i++) {
						if(arr1[i]%3==2 && one==-1) {
							one=arr1[i];
							arr1[i]=-1;
						}else if(arr1[i]%3==2 && one!=-1 && two==-1) {
							two=arr1[i];
							arr1[i]=-1;
						}
					}
					for(int i=arr1.length-1; i>=0; i--) {
						if(arr1[i]<0) {
							continue;
						}
						System.out.print(arr1[i]);
					}
				}
			}else {
				//either find least number whose modulo 3 is 2
				int one=-1;
				int two=-1;
				for(int i=0; i<arr1.length; i++) {
					if(arr1[i]%3==2) {
						one=arr1[i];
						arr1[i]=-1;
					}
				}
				if(one!=-1) {
					for(int i=arr1.length-1; i>=0; i--) {
						if(arr1[i]<0) {
							continue;
						}
						System.out.print(arr1[i]);
					}
				}

				//or find 2 least numbers whose modulo 3 is 1
				else {
					for(int i=0; i<arr1.length; i++) {
						if(arr1[i]%3==1 && one==-1) {
							one=arr1[i];
							arr1[i]=-1;
						}else if(arr1[i]%3==1 && one!=-1 && two==-1) {
							two=arr1[i];
							arr1[i]=-1;
						}
					}
					for(int i=arr1.length-1; i>=0; i--) {
						if(arr1[i]<0) {
							continue;
						}
						System.out.print(arr1[i]);
					}
				}
			}
		}
	}

}

/*

Test cases:
4
5 5 5 7
------------------
555


8
1 2 3 4 25 36 49 50
--------------
493625431


4
12 3 4 5
----------------
12543

Source: https://www.geeksforgeeks.org/find-largest-multiple-3-array-digits-set-2-time-o1-space/
*/
