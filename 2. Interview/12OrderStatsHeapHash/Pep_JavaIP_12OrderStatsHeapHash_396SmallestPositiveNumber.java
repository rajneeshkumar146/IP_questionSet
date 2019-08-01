package OrderStatsHeapHash;

import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_396SmallestPositiveNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int z = segregateposneg(arr);
		int[] posarr=new int[arr.length-z];
		for (int k=0,i = z; i < arr.length; i++, k++) {
			// we are marking presence of arr[i]
			posarr[k]=arr[i];
		}
		
		int k=findMissingPositive(posarr, posarr.length);
		
		System.out.println(k);

	}

	private static int segregateposneg(int[] arr) {
		int neg = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 0) {
				neg++;
				swap(arr, neg, i);
			}
		}

		return neg + 1;
	}

	private static void swap(int[] arr, int neg, int i) {
		int temp = arr[neg] ^ arr[i];
		arr[neg] ^= temp;
		arr[i] ^= temp;
	}
	
	 static int findMissingPositive(int arr[], int size)
	    {
	      int i;
	      
	      // Mark arr[i] as visited by making 
	      // arr[arr[i] - 1] negative. Note that 
	      // 1 is subtracted because index start 
	      // from 0 and positive numbers start from 1
	      for(i = 0; i < size; i++)
	      {
	        if(Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
	          arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
	      }
	      
	      // Return the first index value at which 
	      // is positive
	      for(i = 0; i < size; i++)
	        if (arr[i] > 0)
	          return i+1;  // 1 is added becuase indexes 
	                       // start from 0
	      
	      return size+1;
	    }

}

/*8
2 3 -7 6 8 1 -10 15
4

8
2 3 7 6 8 -1 -10 15
1

5
1 1 0 -1 -2
2

Source: https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
*/