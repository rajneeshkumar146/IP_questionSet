package june1;

import java.util.Scanner;

public class QueryAndArray {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		/*
		System.out.println(Integer.toBinaryString(697793));
		System.out.println(Integer.toBinaryString(676615));
		System.out.println(Integer.toBinaryString(707911));
		System.out.println(Integer.toBinaryString(676615 ^ 707911));
		System.out.println(Integer.toBinaryString(697793 ^ 707911));
		*/
		int T = scn.nextInt();

		while (T-- > 0) {
			int n = scn.nextInt();
			int query = scn.nextInt();

			int[] arr = new int[n];
			
			int minNum = Integer.MAX_VALUE;
			int minNumBits = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				
				arr[i] = scn.nextInt();
				
				int diffBits = arr[i] ^ query;
				int diffBitsCount = countSetBits(diffBits);
				
				if(diffBitsCount < minNumBits){
					minNumBits = diffBitsCount;
					minNum = arr[i];
					
				} else if(diffBitsCount == minNumBits && arr[i] < minNum){
					minNum = arr[i];
				}
			}
			
			System.out.println(minNum);
			
			
		}
	}
	
	
	private static int countSetBits(int n) {

		// Brian Kernighan's Algo Iterative
		int count = 0;

		while (n > 0) {
			n = n & (n - 1);
			count++;
		}

		return count;
	}

}
