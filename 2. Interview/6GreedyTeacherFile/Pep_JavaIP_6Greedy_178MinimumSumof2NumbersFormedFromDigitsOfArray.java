package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_6Greedy_178MinimumSumof2NumbersFormedFromDigitsOfArray {
//Greedy choice : pick minimum elements for both numbers
// start from front. Minimize MSB and so on..
// ex : {2,4,6,5,1,3}
// num1--> min(arr)--> 1 then-->3 so on
// num2--> min(arr)--> 2 then --> 4 so on
// num1: 1 3 5
// num2: 2 4 6
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int[] arr=new int[scn.nextInt()];

		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0; i<arr.length; i++) {
			arr[i]=scn.nextInt();
			pq.add(arr[i]);
		}
		StringBuilder one=new StringBuilder();
		StringBuilder two=new StringBuilder();
		while(!pq.isEmpty()) {
			int num1=pq.remove();
			one.append(num1);
			if(!pq.isEmpty()) {
				int num2=pq.remove();
				two.append(num2);
			}
		}

		int sum=Integer.parseInt(one.toString())+Integer.parseInt(two.toString());
		System.out.println(sum);
	}

}

/*Test Cases:

	5
	5 3 0 7 4
	-------------
	82

	6
	6 8 4 5 2 3
	----------------
	604

	20
	1 8 9 4 2 0 5 1 2 2 1 3 5 4 4 4 6 7 7 0
	-------------------------------------
	234790257

Source: https://www.geeksforgeeks.org/minimum-sum-two-numbers-formed-digits-array-2/
	*/
