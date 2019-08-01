package pep_sns;

import java.util.Arrays;

public class kth_smallest_number_in_multiplication_table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 2;
		int n = 3;
		int k = 6;
		System.out.println(findKthNumber(m, n, k));
	}
	
	public static int findKthNumber(int m, int n, int k) {
        // no need for table
        int low = 1; // 1*1 = 1
        int high = m*n; // max in a given table would be m*n
        while(low < high){
            int mid = low + (high - low)/2;
            if(!canhavek(mid, m, n, k)){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
    
    public static boolean canhavek(int mid, int m, int n, int k){
        int ele = 0;
        for(int i=1; i<=m; i++){
            int kcanbe = mid / i; 
            ele += Math.min(kcanbe, n);
        }
        return ele >= k;
    }

}
