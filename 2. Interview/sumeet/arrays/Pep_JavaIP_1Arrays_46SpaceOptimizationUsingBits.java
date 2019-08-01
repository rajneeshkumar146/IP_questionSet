package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_46SpaceOptimizationUsingBits {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int lo = scn.nextInt();
		int hi = scn.nextInt();
		int k = scn.nextInt();

		int[] strg = new int[(int) Math.ceil((hi - lo) / 32.0)];

		// storing
		for (int i = lo; i <= hi; i++) {
			if(i % k == 0){
				setBit(strg, i - lo);
			}
		}
		
		// printing the storage
		for(int val: strg){
			System.out.print(val + " ");
		}
		System.out.println();
		
		// printing the valid numbers
		for(int i = lo; i <= hi; i++){
			if(isBitSet(strg, i - lo)){
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
	}

	private static void setBit(int[] strg, int val) {
		// When a number is encountered it is expressed as 32 * k + rem
		// k helps decide in which index to store this information
		// rem helps decide in which bit to store this information at that index
		strg[val / 32] |= (1 << (val % 32));
		// val / 32 can also be done by val >> 32 and 
		// val % 32 can also be done by val & 31 (holds true for powers of 2)
	}

	private static boolean isBitSet(int[] strg, int val) {
		return (strg[val / 32] & (1 << (val % 32))) != 0;
	}

}
