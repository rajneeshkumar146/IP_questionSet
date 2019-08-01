
public class CountNumbersContaining4 {
static int countNumbersWith4(int n) 
	{ 
		// Base case 
		if (n < 4) 
			return 0; 
		
		// d = number of digits minus 
		// one in n. For 328, d is 2 
		int d = (int)Math.log10(n); 

		// computing count of numbers from 1 to 10^d-1, 
		// d=0 a[0] = 0; 
		// d=1 a[1] = count of numbers from 
		// 0 to 9 = 1 
		// d=2 a[2] = count of numbers from 
		// 0 to 99 = a[1]*9 + 10 = 19 
		// d=3 a[3] = count of numbers from 
		// 0 to 999 = a[2]*19 + 100 = 171 
		int[] a = new int[d + 2]; 
		a[0] = 0; 
		a[1] = 1; 

		for (int i = 2; i <= d; i++) 
			a[i] = a[i - 1] * 9 + (int)Math.ceil(Math.pow(10, i - 1)); 

		// Computing 10^d 
		int p = (int)Math.ceil(Math.pow(10, d)); 

		// Most significant digit (msd) of n, 
		// For 328, msd is 3 which can be obtained using 328/100 
		int msd = n / p; 

		// If MSD is 4. For example if n = 428, then count of 
		// numbers is sum of following. 
		// 1) Count of numbers from 1 to 399 
		// 2) Count of numbers from 400 to 428 which is 29. 
		if (msd == 4) 
			return (msd) * a[d] + (n % p) + 1; 

		// IF MSD > 4. For example if n 
		// is 728, then count of numbers 
		// is sum of following. 
		// 1) Count of numbers from 1 to 
		// 399 and count of numbers from 
		// 500 to 699, i.e., "a[2] * 6" 
		// 2) Count of numbers from 400 
		// to 499, i.e. 100 
		// 3) Count of numbers from 700 to 
		// 728, recur for 28 
		if (msd > 4) 
			return (msd - 1) * a[d] + p + 
					countNumbersWith4(n % p); 

		// IF MSD < 4. For example if n is 328, then count of 
		// numbers is sum of following. 
		// 1) Count of numbers from 1 to 299 a 
		// 2) Count of numbers from 300 to 328, recur for 28 
		return (msd) * a[d] + countNumbersWith4(n % p); 
	} 

}
