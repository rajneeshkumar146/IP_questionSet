package pep_sns;

public class find_transition_point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, 0, 0, 0, 0, 1, 1, 1};
		int n = arr.length;
		System.out.println(transitionPoint(arr, n));
	}
	
	public static int transitionPoint(int[] arr,int n)
	{
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == 0 && arr[mid + 1] == 1){
                return mid + 1;
            }
            if(arr[mid] == 1 && arr[mid - 1] == 0){
                return mid;
            }
            if(arr[mid] == 0 && arr[mid + 1] == 0){
                left = mid + 1;
            }else if(arr[mid] == 1 && arr[mid - 1] == 1){
                right = mid - 1;
            }
        }
        return -1;
    } 

}
