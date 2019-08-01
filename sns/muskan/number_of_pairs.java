package pep_sns;

import java.util.Arrays;

public class number_of_pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3;
		int n = 2;
		int[] arr1 = {2,1,6};
		int[] arr2 = {1,5};
		// for elements less than 5
	     int[] arr2map = new int[5];
	     for(int i=0; i<n; i++){
	         if(arr2[i] < 5){
	             arr2map[arr2[i]] += 1;
	         }
	     }
	     Arrays.sort(arr2);
	     int count  = 0;
	     for(int i=0; i<m; i++){
	         count += xypairs(arr1[i], arr2, arr2map);
	     }
	     System.out.println(count);
	}
	public static int bsearch(int[] arr, int x){
	    int index=-1;
		int low = 0;
		int high = arr.length-1;
		int mid = low + (high-low)/2; 
		while(low<=high) {
			mid = low + (high-low)/2; 
			if(arr[mid] > x) {
				if((mid - 1 >= 0  && arr[mid - 1] <= x)|| (mid == 0) || (mid==arr.length-1)) {
					return mid;
				} else {
					high = mid-1;
				}
			} else if(mid == arr.length-1) {
				return -1;
			} else {
				low = mid+1;
			}
		}
		return index;
	 }
	 
	 public static int xypairs(int x, int[] arr2, int[] arr2map){
	     if(x == 1){
	         return 0;
	     }
	     int ans = 0;
	     int j = bsearch(arr2, x);
	     ans += arr2map[1];
	     if(j != -1){
    	     if(x > 3){
    	         ans += arr2.length - j;
    	     }
    	     if(x == 3){
    	         ans += arr2.length - j + arr2map[2];
    	     }
    	     if(x == 2){
    	         ans += arr2.length - j - arr2map[3] - arr2map[4];
    	     }
	     }
	     return ans;
	 }

}
