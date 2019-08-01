
public class CountofSubarrays {
	static int countSubarray(int arr[], int n, int k) 
		{ 

			// To store count of subarrays with all 
			// elements less than or equal to k. 
			int s = 0; 

			// Traversing the array. 
			int i = 0; 
			while (i < n) { 

				// If element is greater than k, ignore. 
				if (arr[i] > k) { 
					i++; 
					continue; 
				} 

				// Counting the subarray length whose 
				// each element is less than equal to k. 
				int count = 0; 
				while (i < n && arr[i] <= k) { 
					i++; 
					count++; 
				} 

				// Suming number of subarray whose 
				// maximum element is less than equal to k. 
				s += ((count * (count + 1)) / 2); 
			} 

			return (n * (n + 1) / 2 - s); 
		} 


}
