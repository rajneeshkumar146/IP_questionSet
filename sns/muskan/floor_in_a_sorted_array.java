package pep_sns;

public class floor_in_a_sorted_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,8,10,11,12,19};
		System.out.println(flooridx(arr, 0));

		System.out.println(flooridx(arr, 5));

		System.out.println(flooridx(arr, 10));
	}
	
	public static int flooridx(int[] arr, int val){
	     int floor = -1;
	     int left = 0;
	     int right = arr.length - 1;
	     if(val >= arr[right]){
	         return right;
	     }
	     if(val == arr[left]){
	         return left;
	     }
	     if(val < arr[left]){
	         return -1;
	     }
	     while(left <= right){
	         int mid = left + (right - left)/2;
	         if(arr[mid] == val){
	             return mid;
	         }
	         if(arr[mid] <= val && arr[mid] > floor){
	             floor = arr[mid];
	         }
	         if(arr[mid] > val){
	             right = mid - 1;
	         }else{
	             left = mid + 1;
	         }
	     }
	     return right;
	 } 

}
