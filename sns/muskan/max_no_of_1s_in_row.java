package pep_sns;

public class max_no_of_1s_in_row {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 5;
		int n = 13;
		int maxindx = 0;
		int[][] arr = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
						{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
						{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 } };
		int last1indx = bsearch(arr, 0, 0, n - 1);
	     for(int i=1; i<m; i++){
	         if(last1indx != -1 && arr[i][last1indx] == 1){
	             int curr1indx = bsearch(arr, i, 0, n - 1);
	             if(curr1indx != -1 && curr1indx < last1indx){
	                 maxindx = i;
	                 last1indx = curr1indx;
	             }
	         }else{
	             int indx = bsearch(arr, i, 0, n - 1);
	             if(indx != - 1 && indx < last1indx)
	            	 last1indx = indx;
	         }
	     }
	     System.out.println(maxindx);

	}

	public static int bsearch(int[][] arr, int i, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid == 0 && arr[i][mid] == 1) {
				return mid;
			}
			if (mid - 1 >= 0 && arr[i][mid - 1] == 0 && arr[i][mid] == 1) {
				return mid;
			}
			if (arr[i][mid] == 1) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}
