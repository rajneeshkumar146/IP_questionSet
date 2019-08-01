package pep_sns;

public class peak_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6, 4, 5, 2, 4, 6};
		System.out.println(peakElement(arr, arr.length) >= 0 ? 1 : 0);
	}
	
	public static int peakElement(int arr[], int n)
	{
	   int left = 0;
	   int right = n - 1;
	   int indx = -1;
	   while(left <= right){
	       int mid = (left + right)/2;
	       if((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n-1 || arr[mid + 1] <= arr[mid])){
	            indx = mid;
	            break;
	       }
	       if(mid > 0 && arr[mid - 1] > arr[mid]){
	           right = mid - 1;
	       }else{
	           left = mid + 1;
	       }
	   }
	   return indx;
	}

}
