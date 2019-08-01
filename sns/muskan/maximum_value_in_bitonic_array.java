package pep_sns;

public class maximum_value_in_bitonic_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 15, 25, 45, 42, 21, 17, 12, 11};
		int n1 = 9;
		System.out.println(bsearch(arr1, n1));
		int[] arr2 = {1, 15, 25, 45, 50, 6};
		int n2 = 6;
		System.out.println(bsearch(arr2, n2));

	}
	
	public static int bsearch(int[] arr, int n){
	     int left = 0;
	     int right = n-1;
	     while(left <= right){
	         if(left == right){
	             return arr[left];
	         }
	         int mid = (left + right)/2;
	         if(mid == 0 && arr[mid] > arr[mid + 1]){
	             return arr[mid];
	         }
	         if(mid == n-1 && arr[mid] > arr[mid - 1]){
	             return arr[mid];
	         }
	         if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]){
	             return arr[mid];
	         }
	         if(arr[mid] < arr[mid + 1]){
	             left = mid + 1;
	         }else{
	             right = mid - 1;
	         }
	         
	     }
	     return -1;
	 }

}
