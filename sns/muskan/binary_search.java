package pep_sns;

public class binary_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int key = 4;
		int[] arr = {1,2,3,4,5};
		System.out.println(bin_search(arr, 0, arr.length - 1, key));
	}
	
	public static int bin_search(int A[], int left, int right,  int k)
	{
		while(left <= right){
    		int mid = (left + right)/2;
    		if(A[mid] == k){
    		    return mid;
    		}
    		else if(A[mid] > k){
    		    right = mid - 1;
    		}else{
    		    left = mid + 1;
    		}
		}
		return -1;
	}

}
