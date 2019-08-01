package pep_sns;

public class index_of_an_extra_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[] a = {2, 4, 6, 8, 9, 10, 12};
		int[] b = {2, 4, 6, 8, 10, 12};
		System.out.println(findExtra(a, b, n));

	}
	
	public static int findExtra(int a[],int b[],int n)
	{
	 int left = 0;
	 int right = n - 1;
	 int index = 0;
	 while(left <= right){
	     int mid = (left + right)/2;
	     if(a[mid] == b[mid]){
	         left = mid + 1;
	     }else{
	         index = mid;
	         right = mid - 1;
	     }
	 }
	 return index;
	}

}
