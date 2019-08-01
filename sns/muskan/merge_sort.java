package pep_sns;

public class merge_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 5, 3, 9, 0, -1, 2};
		mergeSort(arr, 0, arr.length - 1);
		for(int val: arr)
			System.out.print(val + " ");

	}
	
	public static void mergeSort(int arr[], int l, int r) {
	    if (l < r)   {
	        int m = l+(r-l)/2;
	        mergeSort(arr, l, m);
	        mergeSort(arr, m+1, r);
	        merge(arr, l, m, r);
	    }
	}
	
	public static void merge(int arr[], int l, int m, int r)
	{
	    int i = l;
	    int j = m+1;
	    if(arr[m] <= arr[j]){
	        return;
	    }
	    while(i <= m && j <= r){
	        if(arr[i] < arr[j]){
	            i++;
	        }else{
	            int temp = arr[j];
	            int index = j;
	            while(index != i){
	                arr[index] = arr[index - 1];
	                index--;
	            }
	            arr[i] = temp;
	            i++;
	            j++;
	            m++;
	        }
	    }
	}

}
