package dp;

import java.util.Scanner;

public class maximum_subarray {

	public static void main(String[] args) {
    
	}

	public static int kadans(int[] art) {
		int csum = 0;
		
		int osum = 0;
		
		for (int i = 0; i < art.length; i++) {
			if (csum >= 0) {
				
				csum += art[i];

			} else {
				csum=art[i];
				
			}
			osum = Math.max(osum, csum);
		}
		return osum;
	}
}
