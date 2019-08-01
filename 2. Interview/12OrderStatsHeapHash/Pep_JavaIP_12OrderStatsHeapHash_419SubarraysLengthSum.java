package OrderStatsHeapHash;

import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_419SubarraysLengthSum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solve(arr));
	}

	private static int solve(int[] arr)
	{	
		HashSet<Integer> unique = new HashSet<Integer>();
		
		int n = arr.length;
		int j = 0, count = 0;
		
		for(int i = 0; i < n; i++)
		{
			while(j < n && !unique.contains(arr[j]))
			{
				unique.add(arr[j]);
				j++;
			}
			//if 1 2 3 4 is the unique set of elements, then length of all subarrays with distinct elements starting 
			//with 1 is :
			// (4*5)/2
			//We take each element as starting point and then take count of length of all subarrays with 
			//distinct elements
			//Each element is visited twice so, the  complexity is at max 2*n.
			count += (((j-i))*(j-i+1))/2;
			
			unique.remove(arr[i]);
		}
		
		return count;
	}

}


/*Test cases:
	3
	1 2 1
	-------------
	7
	
	
	5
	1 2 3 4 5
	--------------
	35
	
	
	9
	1 2 3 4 4 18 19 2 3 
	-------------------
	55
	
	
Source:https://www.geeksforgeeks.org/subarrays-distinct-elements/
*/