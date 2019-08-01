package pep_sns;

public class peak_index_in_mountain_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, 2, 4, 5, 1, -1};
		System.out.println(peakIndexInMountainArray(arr));

	}
	
	public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] < arr[mid + 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

}
